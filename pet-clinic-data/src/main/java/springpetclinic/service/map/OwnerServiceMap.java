package springpetclinic.service.map;

import springpetclinic.model.Owner;
import org.springframework.stereotype.Service;
import springpetclinic.service.OwnerService;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(vet -> vet.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(new Owner(null,null,null));
    }
}
