package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {
    private Long id ;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private int jobId;
}
