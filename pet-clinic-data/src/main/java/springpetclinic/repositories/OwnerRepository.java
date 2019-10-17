package springpetclinic.repositories;


import org.springframework.data.repository.CrudRepository;
import springpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

    //This will use Dynamic Query Method with a SD JPA to provide findByLastName
    Owner findByLastName(String lastName);
}
