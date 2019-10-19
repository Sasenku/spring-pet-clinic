package springpetclinic.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import springpetclinic.model.Owner;
import springpetclinic.repositories.OwnerRepository;
import springpetclinic.repositories.PetRepository;
import springpetclinic.repositories.PetTypeRepository;
import springpetclinic.service.OwnerService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    //@InjectMocks mozna tez tak
    OwnerSDJpaService ownerSDJpaService;

    Owner owner;

    final Long OWNER_ID = 1L;
    final String OWNER_LAST_NAME = "Smith";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ownerSDJpaService = new OwnerSDJpaService(ownerRepository,petRepository,petTypeRepository);
        owner = Owner.builder().id(OWNER_ID).lastName(OWNER_LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner smith = ownerSDJpaService.findByLastName("Smith");

        assertEquals(OWNER_LAST_NAME,smith.getLastName());
        verify(ownerRepository,times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(2L).lastName("King").build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> ownerSetReturner = ownerSDJpaService.findAll();

        assertNotNull(ownerSetReturner);
        assertEquals(1,ownerSetReturner.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        Owner owner2 =  ownerSDJpaService.findById(1L);

        assertNotNull(owner2);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner2 =  ownerSDJpaService.findById(1L);

        assertNull(owner2);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(owner);

        Owner savedOwner = ownerSDJpaService.save(ownerToSave);

        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(owner);

        verify(ownerRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);

        verify(ownerRepository).deleteById(1L);
    }
}