package tech.hulkhire.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.hulkhire.model.Addresss;
import tech.hulkhire.model.User;
import tech.hulkhire.service.UserService;

import java.util.List;

@Component
public class RecordSaver implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
//        User user = User.builder()
//                .name("Chandan")
//                .email("chandank1848@gmail.com")
//                .address(
//                        Addresss.builder()
//                                .country("India")
//                                .city("Bettiah")
//                                .zipcode("845307")
//                                .phoneNum("9905669732")
//                                .build()
//                ).build();

//        User user = User.builder()
//                .name("Chandan")
//                .email("chandank1848@gmail.com")
//                .address(
//                        List.of(
//                                Addresss.builder()
//                                        .country("India")
//                                        .city("Bettiah")
//                                        .zipcode("845307")
//                                        .phoneNum("9905669732")
//                                        .build(),
//                                Addresss.builder()
//                                        .country("India")
//                                        .city("Bettiah")
//                                        .zipcode("845307")
//                                        .phoneNum("9905669732")
//                                        .build(),
//                                Addresss.builder()
//                                        .country("India")
//                                        .city("Bettiah")
//                                        .zipcode("845307")
//                                        .phoneNum("9905669732")
//                                        .build()
//                        )
//
//                ).build();

//        User savedUser = userService.saveUser(user);
//        User savedUser = userService.saveUser(user);
//        System.out.println(savedUser);
    }
}
