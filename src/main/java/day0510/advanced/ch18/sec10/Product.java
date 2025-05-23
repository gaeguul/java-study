package day0510.advanced.ch18.sec10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Product implements Serializable {
    private String name;
    private int price;
}
