package service;

import model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetService extends JpaRepository<Vet, Long> {
}
