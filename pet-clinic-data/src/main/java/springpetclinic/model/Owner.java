package springpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Owner extends Person{
    private String address;
    private String city;
    private String telephone;

    private Set<Pet> pets = new HashSet<>();

    public Owner(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }
}
