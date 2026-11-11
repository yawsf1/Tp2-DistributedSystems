package fr.univ.tp.etudiants.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    private Integer id;
    private String nom;
    private String email;
}