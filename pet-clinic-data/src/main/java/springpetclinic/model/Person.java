package springpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity{
    private String firstName;
    private String lastname;

    public Person(Long id, String firstName, String lastname) {
        super(id);
        this.firstName = firstName;
        this.lastname = lastname;
    }
}
