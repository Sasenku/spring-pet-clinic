package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Owner extends Person{
    public Owner(Long id, String firstName, String latName) {
        super(id, firstName, latName);
    }
}
