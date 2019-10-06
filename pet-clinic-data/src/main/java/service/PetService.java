package service;

import model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PetService extends CrudService<Pet, Long>{
}
