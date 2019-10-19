package springpetclinic.service.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springpetclinic.model.Specialty;
import springpetclinic.service.SpecialtyService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SpecialtyMapServiceTest {

    SpecialtyMapService specialtyMapService;
    Long SPECIALTY_ID=1L;

    @BeforeEach
    void setUp() {
        specialtyMapService = new SpecialtyMapService();
        specialtyMapService.save(Specialty.builder().id(SPECIALTY_ID).build());
    }

    @Test
    void findAll() {
        Set<Specialty> specialtySet = specialtyMapService.findAll();
        assertEquals(1,specialtySet.size());
    }

    @Test
    void deleteById() {
        specialtyMapService.deleteById(SPECIALTY_ID);
        assertEquals(0,specialtyMapService.findAll().size());
    }

    @Test
    void delete() {
        specialtyMapService.delete(specialtyMapService.findById(SPECIALTY_ID));
        assertEquals(0,specialtyMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Specialty specialty2 = Specialty.builder().id(id).build();
        Specialty savedSpecialty = specialtyMapService.save(specialty2);

        assertEquals(id,savedSpecialty.getId());
    }

    @Test
    void saveNoId() {
        Specialty specialty2 = Specialty.builder().build();
        Specialty savedSpecialty = specialtyMapService.save(specialty2);

        assertNotNull(savedSpecialty);
        assertNotNull(savedSpecialty.getId());
    }

    @Test
    void findById() {
        Specialty specialty = specialtyMapService.findById(SPECIALTY_ID);

        assertEquals(SPECIALTY_ID,specialty.getId());
    }
}