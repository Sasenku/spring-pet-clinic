package model;

import lombok.*;

import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity{
    private String firstName;
    private String latName;

    public Person(Long id, String firstName, String latName) {
        super(id);
        this.firstName = firstName;
        this.latName = latName;
    }
}
