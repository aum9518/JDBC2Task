package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Job {
    private Long id;
    private String position;
    private String profession;
    private String description;
    private int experiences;
}
