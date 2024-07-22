package in.ineuron.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class MessageResponse {

    String message;
    String sender;
    LocalTime time=LocalTime.now();

}
