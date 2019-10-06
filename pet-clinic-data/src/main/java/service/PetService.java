package service;

import model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PetService{
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
