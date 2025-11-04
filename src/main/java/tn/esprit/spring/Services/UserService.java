package tn.esprit.spring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Utilisateur;
import tn.esprit.spring.repositories.UtilisateurRepository;

import java.util.List;

@Service
// ou @Component
@AllArgsConstructor
public class UserService implements IUserService {

    UtilisateurRepository repo;

    @Override
    public Utilisateur addUser(Utilisateur u) {return repo.save(u);}

    @Override
    public List<Utilisateur> saveUsers(List<Utilisateur> users)
    {return repo.saveAll(users);}

    @Override
    public Utilisateur selectUserByIdWithGet(long id)
    {return repo.findById(id).get();}

    @Override
    public Utilisateur selectUserByIdWithOrElse(long id) {
        Utilisateur fakeUser = Utilisateur.builder()
                .nom("BEN FOULEN").prenom("FOULEN")
                .age(4200).id(1200)
                .build();
        return repo.findById(id).orElse(fakeUser);
    }

    @Override
    public List<Utilisateur> selectAllUsers() {return repo.findAll();}
    @Override
    public void deleteUser(Utilisateur u) {repo.delete(u);}
    @Override
    public void deleteAllUsers() {repo.deleteAll();}
    @Override
    public void deleteUserById(long id) {repo.deleteById(id);}
    @Override
    public long countingUsers() {
        // select count(*) from User;
        return repo.count();
    }
    @Override
    public boolean verifUserById(long id) {return repo.existsById(id);}
}
