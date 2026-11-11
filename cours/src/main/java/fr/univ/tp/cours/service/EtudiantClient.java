package fr.univ.tp.cours.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import fr.univ.tp.cours.model.Etudiant;

@Service
public class EtudiantClient {
    private final RestTemplate rest = new RestTemplate();
    private final String baseUrl = "http://localhost:8081/etudiants";

    public Etudiant getEtudiantById(int id) {
        return rest.getForObject(baseUrl + "/" + id, Etudiant.class);
    }
}