package service;

import model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface VetService extends CrudService<Vet, Long>{
    Vet findByLastName(String lastName);
}
