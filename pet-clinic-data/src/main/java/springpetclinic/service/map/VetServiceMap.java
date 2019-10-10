package springpetclinic.service.map;

import springpetclinic.model.Vet;
import org.springframework.stereotype.Service;
import springpetclinic.service.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Vet findByLastName(String lastName) {
        return super.findAll()
                .stream()
                .filter(vet -> vet.getLastname().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(new Vet(null,null,null,null));
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(),vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
