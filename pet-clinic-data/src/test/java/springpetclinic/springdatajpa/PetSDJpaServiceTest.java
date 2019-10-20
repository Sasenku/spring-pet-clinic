package springpetclinic.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import springpetclinic.model.Pet;
import springpetclinic.repositories.PetRepository;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PetSDJpaServiceTest {

    @Mock
    PetRepository petRepository;

    @InjectMocks
    PetSDJpaService petSDJpaService;

    final Long PET_ID = 1L;
    final String PET_NAME = "Franek";

    Pet pet;

    @BeforeEach
    void setUp() {
//        MockitoAnnotations.initMocks(this);
//        petSDJpaService = new PetSDJpaService(petRepository);

        pet = Pet.builder().id(PET_ID).name(PET_NAME).build();
    }

    @Test
    void findAll() {
        Set<Pet> petSet = new HashSet<>();
        petSet.add(pet);
        petSet.add(Pet.builder().id(2L).name("Roman").build());

        when(petRepository.findAll()).thenReturn(petSet);

        Set<Pet> returnedPetSet = petSDJpaService.findAll();

        assertNotNull(petSet);
        assertEquals(2,returnedPetSet.size());
    }

    @Test
    void findById() {
        when(petRepository.findById(anyLong())).thenReturn(Optional.of(pet));
        Pet pet2 = petSDJpaService.findById(PET_ID);

        assertNotNull(pet2);
    }

    @Test
    void save() {
        Pet petToSave = Pet.builder().id(1L).name("Franek").build();
        when(petRepository.save(any())).thenReturn(pet);

        Pet savedPet = petSDJpaService.save(petToSave);

        assertEquals(pet.getId(),savedPet.getId());
        assertEquals(pet.getName(),savedPet.getName());
    }

    @Test
    void delete() {
        petSDJpaService.delete(pet);

        verify(petRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        petSDJpaService.deleteById(PET_ID);

        verify(petRepository,times(1)).deleteById(anyLong());
    }
}