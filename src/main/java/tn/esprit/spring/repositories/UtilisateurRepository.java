package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Utilisateur;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UtilisateurRepository extends
        JpaRepository<Utilisateur, Long> {

    //select * from User where nom=Ahmed
    List<Utilisateur> findByNom(String nom);

    List<Utilisateur> getByNom(String nom);

    List<Utilisateur> searchByNom(String nom);

    List<Utilisateur> readByNom(String nom);

    List<Utilisateur> queryByNom(String nom);

    @Query("SELECT u FROM Utilisateur u WHERE u.nom = ?1")
    List<Utilisateur> recupJPQL(String nom);

    @Query(value = "SELECT * FROM user WHERE lastName =:n", nativeQuery = true)
    List<Utilisateur> recupSQL(@Param("n") String nom);

    //select * from User where nom=Ahmed ou AHMED ou aHMED
    List<Utilisateur> findByNomIgnoreCase(String nom);

    //select * from User where nom=... and prenom = ...
    List<Utilisateur> findByNomAndPrenom(String n, String p);

    @Query("SELECT u FROM Utilisateur u WHERE u.nom = ?2 AND u.prenom = ?1")
    List<Utilisateur> recupJPQL1(String prenom, String nom);

    @Query(value = "SELECT * FROM user WHERE lastName =:n AND firstName =:p",
            nativeQuery = true)
    List<Utilisateur> recupSQL1(@Param("n") String nom, @Param("p") String prenom);

    //select * from User where nom=... or prenom = ...
    List<Utilisateur> findByNomOrPrenom(String n, String p);

    // select * from User where nom=%Ben%
    List<Utilisateur> findByNomLike(String chaine);

    List<Utilisateur> findByNomContains(String chaine);

    List<Utilisateur> findByNomContaining(String chaine);

    // select * from User where nom=k%
    List<Utilisateur> findByNomStartingWith(String c);

    List<Utilisateur> findByNomStartsWith(String c);

    List<Utilisateur> findByNomIsStartingWith(String c);

    // select * from User where nom=%P
    List<Utilisateur> findByNomEndingWith(String c);

    List<Utilisateur> findByNomEndsWith(String c);

    List<Utilisateur> findByNomIsEndingWith(String c);

    // select * from User where cin =...
    List<Utilisateur> findByCin(long num);

    // select * from User where cin > ...
    List<Utilisateur> findByCinGreaterThan(long num);

    // select * from User where cin >= ...
    List<Utilisateur> findByCinGreaterThanEqual(long num);

    // select * from User where cin < ...
    List<Utilisateur> findByCinLessThan(long num);

    // select * from User where cin <= ...
    List<Utilisateur> findByCinLessThanEqual(long num);

    // select * from User where cin < ... and cin >...
    List<Utilisateur> findByCinGreaterThanAndCinLessThan(long min, long max);

    List<Utilisateur> findByCinBetween(long min, long max);

    List<Utilisateur> findByCinIsBetween(long min, long max);

    // select * from User where dateNaissance=...
    List<Utilisateur> getByDateNaissance(LocalDate localDate);

    // select * from User where dateNaissance>...
    List<Utilisateur> getByDateNaissanceAfter(LocalDate date);

    List<Utilisateur> getByDateNaissanceIsAfter(LocalDate date);

    // select * from User where dateNaissance<...
    List<Utilisateur> getByDateNaissanceBefore(LocalDate date);

    List<Utilisateur> getByDateNaissanceIsBefore(LocalDate date);

}
