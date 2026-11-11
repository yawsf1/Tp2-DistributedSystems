package fr.univ.tp.cours.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cours {
    private Integer id;
    private String titre;
    private Integer etudiantId;
}