package springpetclinic.service.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springpetclinic.model.Pet;
import springpetclinic.model.PetType;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetTypeMapServiceTest {

    PetTypeMapService petTypeMapService;
    Long PET_TYPE_ID = 1L;

    @BeforeEach
    void setUp() {
        petTypeMapService = new PetTypeMapService();
        petTypeMapService.save(PetType.builder().id(PET_TYPE_ID).build());
    }

    @Test
    void findAll() {
        Set<PetType> petTypeSet = petTypeMapService.findAll();
        assertEquals(1,petTypeSet.size());
    }

    @Test
    void deleteById() {
        petTypeMapService.deleteById(PET_TYPE_ID);
        assertEquals(0,petTypeMapService.findAll().size());
    }

    @Test
    void delete() {
        petTypeMapService.delete(petTypeMapService.findById(PET_TYPE_ID));
        assertEquals(0,petTypeMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id=2L;

        PetType savedPetType = PetType.builder().id(id).build();
        petTypeMapService.save(savedPetType);

        assertEquals(id,savedPetType.getId());
    }

    @Test
    void saveNoId(){
        PetType petType2 = PetType.builder().build();

        PetType savedPetType = petTypeMapService.save(petType2);

        assertNotNull(savedPetType);
        assertNotNull(savedPetType.getId());
    }

    @Test
    void findById() {
        PetType petType = petTypeMapService.findById(PET_TYPE_ID);
        assertEquals(PET_TYPE_ID,petType.getId());
    }
}