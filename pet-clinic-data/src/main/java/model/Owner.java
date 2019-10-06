package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner extends Person{
    public Owner(Long id, String firstName, String latName) {
        super(id, firstName, latName);
    }
}
