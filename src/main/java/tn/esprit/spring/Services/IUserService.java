package tn.esprit.spring.Services;

import tn.esprit.spring.dto.utilisateur.UtilisateurRequest;
import tn.esprit.spring.dto.utilisateur.UtilisateurResponse;
import tn.esprit.spring.entities.Utilisateur;

import java.util.List;

public interface IUserService {
    Utilisateur addUser(Utilisateur u);
    UtilisateurResponse addUserWithDTO(UtilisateurRequest utilisateurRequest);
    //-----------------------------------------
    List<Utilisateur> saveUsers(List<Utilisateur> users);
    List<UtilisateurResponse> saveUsersWithDTO(List<UtilisateurRequest> users);
    //-----------------------------------------
    Utilisateur selectUserByIdWithGet(long id);
    Utilisateur selectUserByIdWithOrElse(long id);
    List<Utilisateur> selectAllUsers();
    void deleteUser(Utilisateur u);
    void deleteAllUsers();
    void deleteUserById(long id);
    long countingUsers();
    boolean verifUserById(long id);
}
