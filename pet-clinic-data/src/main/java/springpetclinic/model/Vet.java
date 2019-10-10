package springpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Vet extends Person {
    private Long salary;

    public Vet(Long id, String firstName, String latName, Long salary) {
        super(id, firstName, latName);
        this.salary = salary;
    }
}
