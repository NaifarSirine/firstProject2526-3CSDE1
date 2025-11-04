package tn.esprit.spring.Services;

import tn.esprit.spring.entities.Utilisateur;

import java.util.List;

public interface IUserService {
    Utilisateur addUser(Utilisateur u);
    List<Utilisateur> saveUsers(List<Utilisateur> users);
    Utilisateur selectUserByIdWithGet(long id);
    Utilisateur selectUserByIdWithOrElse(long id);
    List<Utilisateur> selectAllUsers();
    void deleteUser(Utilisateur u);
    void deleteAllUsers();
    void deleteUserById(long id);
    long countingUsers();
    boolean verifUserById(long id);
}
