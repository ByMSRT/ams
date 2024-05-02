package org.sip.exo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sip.exo.repository.Etudiant;
import org.sip.exo.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class TestDemoDataController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    private Etudiant etudiant;

    @BeforeEach
    public void setUp() {
        etudiant = new Etudiant();
        etudiant.setNom("John Doe");
        etudiant.setAge(25);
    }

    @Test
    public void testCreateEtudiant() {
        Etudiant savedEtudiant = etudiantRepository.save(etudiant);
        assertNotNull(savedEtudiant.getId(), "Etudiant ID should not be null");
    }

    @Test
    public void testReadEtudiant() {
        Etudiant savedEtudiant = etudiantRepository.save(etudiant);
        Optional<Etudiant> foundEtudiant = etudiantRepository.findById(savedEtudiant.getId());
        assertTrue(foundEtudiant.isPresent(), "Etudiant should be found");
        assertEquals("John Doe", foundEtudiant.get().getNom(), "Etudiant name should match");
    }

    @Test
    public void testUpdateEtudiant() {
        Etudiant savedEtudiant = etudiantRepository.save(etudiant);
        savedEtudiant.setNom("Jane Doe");
        etudiantRepository.save(savedEtudiant);

        Optional<Etudiant> updatedEtudiant = etudiantRepository.findById(savedEtudiant.getId());
        assertTrue(updatedEtudiant.isPresent(), "Updated Etudiant should be found");
        assertEquals("Jane Doe", updatedEtudiant.get().getNom(), "Updated Etudiant name should match");
    }

    @Test
    public void testDeleteEtudiant() {
        Etudiant savedEtudiant = etudiantRepository.save(etudiant);
        etudiantRepository.delete(savedEtudiant);
        Optional<Etudiant> deletedEtudiant = etudiantRepository.findById(savedEtudiant.getId());
        assertFalse(deletedEtudiant.isPresent(), "Etudiant should have been deleted");
    }
}

