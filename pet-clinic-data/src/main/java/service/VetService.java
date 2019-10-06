package service;

import model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface VetService{
    Vet findByLastName(String lastName);
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
