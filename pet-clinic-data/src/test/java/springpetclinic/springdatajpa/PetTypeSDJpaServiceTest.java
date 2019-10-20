package springpetclinic.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import springpetclinic.model.PetType;
import springpetclinic.model.PetType;
import springpetclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PetTypeSDJpaServiceTest {

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    PetTypeSDJpaService petTypeSDJpaService;

    final Long PET_TYPE_ID = 1L;
    final String PET_TYPE_NAME = "Cat";

    PetType petType;

    @BeforeEach
    void setUp() {
        petType = PetType.builder().id(PET_TYPE_ID).name(PET_TYPE_NAME).build();
    }

    @Test
    void findAll() {
        Set<PetType> petTypeSet = new HashSet<>();
        petTypeSet.add(petType);
        petTypeSet.add(PetType.builder().id(2L).name("Dog").build());

        when(petTypeRepository.findAll()).thenReturn(petTypeSet);

        Set<PetType> savedPetTypes = petTypeSDJpaService.findAll();

        assertEquals(petTypeSet.size(),savedPetTypes.size());
        assertEquals(petTypeSet.contains(petType),savedPetTypes.contains(petType));
    }

    @Test
    void findById() {
        when(petTypeRepository.findById(anyLong())).thenReturn(Optional.of(petType));
        PetType petType2 = petTypeSDJpaService.findById(PET_TYPE_ID);

        assertNotNull(petType2);
    }

    @Test
    void save() {
        PetType petTypeToSave = PetType.builder().id(1L).name("Cat").build();
        when(petTypeRepository.save(any())).thenReturn(petTypeToSave);

        PetType savedPet = petTypeSDJpaService.save(petTypeToSave);

        assertEquals(petType.getId(),savedPet.getId());
        assertEquals(petType.getName(),savedPet.getName());
    }

    @Test
    void delete() {
        petTypeSDJpaService.delete(petType);

        verify(petTypeRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        petTypeSDJpaService.deleteById(PET_TYPE_ID);

        verify(petTypeRepository,times(1)).deleteById(anyLong());
    }
}