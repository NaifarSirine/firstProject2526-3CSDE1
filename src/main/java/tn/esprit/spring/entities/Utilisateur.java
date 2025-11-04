package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;

@Entity // Pour définir que Utilisateur est une entité JPA
@Table(name = "user") // Pour personnaliser le nom de la table dans la BD
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
//@RequiredArgsConstructor
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NonNull
    long id;
    @Column(name = "lastName")
    String nom;
    @Column(name = "firstName")
    String prenom;
    // @Enumerated ou bien @Enumerated(EnumType.ORDINAL) // tinyint
    @Enumerated(EnumType.STRING) // varchar
    @Column(name = "gender")
    Sexe sexe;
    @Column(unique = true)
    long cin;
    LocalDate dateNaissance;
    @Temporal(TemporalType.DATE)
    Date dateAjout;
    @Transient
    @JsonIgnore
    int age;


}
