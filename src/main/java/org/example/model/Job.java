package org.example.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Job {
    private Long id;
    private String position;
    private String profession;
    private String description;
    private int experiences;

    public Job(String position, String profession, String description, int experiences) {
        this.position = position;
        this.profession = profession;
        this.description = description;
        this.experiences = experiences;
    }

    public Job(Long id, String position, String profession, int experiences) {
        this.id = id;
        this.position = position;
        this.profession = profession;
        this.experiences = experiences;
    }
}
