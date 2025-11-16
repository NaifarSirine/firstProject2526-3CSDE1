package tn.esprit.spring.dto.utilisateur;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.entities.Sexe;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UtilisateurRequest {
    String nom;
    String prenom;
    Sexe sexe;
    long cin;
    LocalDate dateNaissance;
    Date dateAjout;
}
