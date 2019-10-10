package springpetclinic.bootstrap;

import springpetclinic.model.Owner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springpetclinic.service.OwnerService;
import springpetclinic.service.VetService;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataInitializer(OwnerService ownerService, VetService vetService) {
        this.ownerService=ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Jakub");
        owner1.setLastname("Gluma");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Angelika");
        owner2.setLastname("Gluma");

        ownerService.save(owner2);

        System.out.println("Loading owners...");

    }
}
