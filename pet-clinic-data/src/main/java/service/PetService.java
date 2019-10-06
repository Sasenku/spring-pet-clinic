package service;

import model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetService extends JpaRepository<Pet , Long> {
}
