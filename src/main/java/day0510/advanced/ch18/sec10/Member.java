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
public class Member implements Serializable {

    private String id;
    private String name;
}
