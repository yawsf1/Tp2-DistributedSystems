package fr.univ.tp.cours.repository;

import fr.univ.tp.cours.model.Cours;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CoursRepository {
    private final Map<Integer, Cours> store = new HashMap<>();
    private final AtomicInteger seq = new AtomicInteger(1);
    public List<Cours> findAll() { return new ArrayList<>(store.values()); }
    public Optional<Cours> findById(int id) { return Optional.ofNullable(store.get(id)); }
    public Cours save(Cours e) {
        if (e.getId() == null) e.setId(seq.getAndIncrement());
        store.put(e.getId(), e);
        return e;
    }
    public void delete(int id) { store.remove(id); }
}