package tech.hulkhire.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.hulkhire.exception.UserNotFoundException;
import tech.hulkhire.exception.UserInactiveException;
import tech.hulkhire.exception.UserUnauthorizedException;
import tech.hulkhire.model.User;
import tech.hulkhire.pojo.UserLoginRequest;
import tech.hulkhire.pojo.UserRequest;
import tech.hulkhire.pojo.UserResponse;
import tech.hulkhire.pojo.UserUpdateRequest;
import tech.hulkhire.repository.UserRepository;
import tech.hulkhire.security.UserDetailsServiceImpl;
import tech.hulkhire.service.UserService;
import tech.hulkhire.utils.JwtUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private UserDetailsServiceImpl userDetailsService;
    private JwtUtil jwtUtil;

    @Override
    public UserResponse saveUser(UserRequest userReq) {
        User user = new User();
        BeanUtils.copyProperties(userReq, user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.setRoles(Set.of("USER"));
        User savedUser = userRepo.save(user);

        return mapToUserResponse(savedUser);
    }

    @Override
    public UserResponse updateUser(UserUpdateRequest userReq) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = getUserByEmail(email);

        if (!user.isActive()){
            throw new UserInactiveException("This user is not active");
        }

        if (userReq.getName()!=null){
            user.setName(userReq.getName());
        }
        if (userReq.getPassword()!=null){
            user.setPassword(passwordEncoder.encode(userReq.getPassword()));
        }
        if (userReq.getActive()!=null){
            user.setActive(userReq.getActive());
        }

        User updatedUser = userRepo.save(user);
        return mapToUserResponse(updatedUser);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(
                () -> new UserNotFoundException("User not found with email : " + email));
    }

    @Override
    public List<UserResponse> fetchAllUsers() {
        List<User> userList = (List<User>) userRepo.findAll();
        return mapToUserResponse(userList);
    }

    @Override
    public UserResponse makeUserAdmin(UserLoginRequest userReq) {
        User user = getUserByEmail(userReq.getEmail());
        if (user.getPassword().equals(userReq.getPassword())){
            throw new UserUnauthorizedException("user password is not current");
        }
        Set<String> roles = user.getRoles();
        roles.add("ADMIN");
        user.setRoles(roles);
        User savedUser = userRepo.save(user);

        return mapToUserResponse(savedUser);
    }

    @Override
    public String loginUser(UserLoginRequest user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        return jwtUtil.generateToken(userDetails.getUsername());
    }

    public UserResponse mapToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        String[] roles = user.getRoles().toArray(new String[0]);
        BeanUtils.copyProperties(user, userResponse);
        userResponse.setRoles(roles);

        return userResponse;
    }

    public List<UserResponse> mapToUserResponse(List<User> users) {
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user: users){
            userResponses.add(mapToUserResponse(user));
        }

        return userResponses;
    }
}
