package fr.univ.tp.etudiants.controller;

import fr.univ.tp.etudiants.model.Etudiant;
import fr.univ.tp.etudiants.repository.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/etudiants")
public class EtudiantController {
    private final EtudiantRepository repo;

    @GetMapping
    public List<Etudiant> all() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Etudiant get(@PathVariable int id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Etudiant non trouvé"));
    }

    @PostMapping
    public Etudiant create(@RequestBody Etudiant e) { return repo.save(e); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) { repo.delete(id); }
}