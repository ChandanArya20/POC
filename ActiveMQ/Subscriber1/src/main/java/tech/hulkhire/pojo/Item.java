package tech.hulkhire.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Item implements Serializable {

    private int id;
    private String itemName;
    private int itemQuantity;
}