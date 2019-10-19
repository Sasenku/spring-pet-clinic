package springpetclinic.service.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springpetclinic.model.Pet;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetMapServiceTest {

    PetMapService petMapService;
    final Long PET_ID = 1L;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        petMapService.save(Pet.builder().id(PET_ID).build());
    }

    @Test
    void findAll() {
        Set<Pet> petSet = petMapService.findAll();
        assertEquals(1,petSet.size());
    }

    @Test
    void findById() {
        Pet pet = petMapService.findById(PET_ID);

        assertNotNull(pet);
        assertEquals(PET_ID,pet.getId());
    }

    @Test
    void saveNoId() {
        Pet savedPet = petMapService.save(Pet.builder().build());

        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;

        Pet pet2 = Pet.builder().id(id).build();
        Pet savedPet = petMapService.save(Pet.builder().id(id).build());

        assertEquals(id,savedPet.getId());
    }

    @Test
    void delete() {
        petMapService.delete(petMapService.findById(PET_ID));
        assertEquals(0,petMapService.findAll().size());
    }

    @Test
    void deleteById() {
        petMapService.deleteById(PET_ID);
        assertEquals(0,petMapService.findAll().size());
    }
}