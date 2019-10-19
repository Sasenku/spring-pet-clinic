package springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springpetclinic.model.Specialty;

public interface SpecialityRepository extends CrudRepository<Specialty,Long> {
}
