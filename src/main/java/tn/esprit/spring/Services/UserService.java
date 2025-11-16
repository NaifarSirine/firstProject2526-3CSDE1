package tn.esprit.spring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.dto.utilisateur.UtilisateurRequest;
import tn.esprit.spring.dto.utilisateur.UtilisateurResponse;
import tn.esprit.spring.entities.Utilisateur;
import tn.esprit.spring.mappers.UtilisateurMapper;
import tn.esprit.spring.repositories.UtilisateurRepository;

import java.util.ArrayList;
import java.util.List;

@Service
// ou @Component
@AllArgsConstructor
public class UserService implements IUserService {

    UtilisateurRepository repo;
    UtilisateurMapper mapper;

    @Override
    public Utilisateur addUser(Utilisateur u) {
        return repo.save(u);
    }

    @Override
    public UtilisateurResponse addUserWithDTO(UtilisateurRequest utilisateurRequest) {
        // ** Transformation de  UtilisateurRequest à Utilisateur
        // Utilisateur utilisateur = mapper.fromDTOToEntity(utilisateurRequest);
        // ** Ajout
        // Utilisateur utilisateurAdded = repo.save(utilisateur);
        // ** Transformation de  Utilisateur à UtilisateurResponse
        // UtilisateurResponse utilisateurResponse= mapper.fromEntityToDTO(utilisateurAdded);
        // return  utilisateurResponse;

        return mapper.fromEntityToDTO(repo.save(
                mapper.fromDTOToEntity(utilisateurRequest)));

    }
    //-----------------------------------------

    @Override
    public List<Utilisateur> saveUsers(List<Utilisateur> users) {
        return repo.saveAll(users);
    }

    @Override
    public List<UtilisateurResponse> saveUsersWithDTO(List<UtilisateurRequest> users) {
        // List<UtilisateurRequest> --> List<Utilisateur>
        List<Utilisateur> utilisateurs = new ArrayList<>();
        for (UtilisateurRequest u : users) {
            utilisateurs.add(mapper.fromDTOToEntity(u));
        }
        // Ajout
        List<Utilisateur> utilisateursAdded = repo.saveAll(utilisateurs);
        // List<Utilisateur> --> List<UtilisateurResponse>
        List<UtilisateurResponse> utilisateurResponses = new ArrayList<>();
        for(Utilisateur u : utilisateursAdded){
            utilisateurResponses.add(mapper.fromEntityToDTO(u));
        }
        return utilisateurResponses;
    }

    //-----------------------------------------

    @Override
    public Utilisateur selectUserByIdWithGet(long id) {
        return repo.findById(id).get();
    }

    @Override
    public Utilisateur selectUserByIdWithOrElse(long id) {
        Utilisateur fakeUser = Utilisateur.builder()
                .nom("BEN FOULEN").prenom("FOULEN")
                .age(4200).id(1200)
                .build();
        return repo.findById(id).orElse(fakeUser);
    }

    @Override
    public List<Utilisateur> selectAllUsers() {
        return repo.findAll();
    }

    @Override
    public void deleteUser(Utilisateur u) {
        repo.delete(u);
    }

    @Override
    public void deleteAllUsers() {
        repo.deleteAll();
    }

    @Override
    public void deleteUserById(long id) {
        repo.deleteById(id);
    }

    @Override
    public long countingUsers() {
        // select count(*) from User;
        return repo.count();
    }

    @Override
    public boolean verifUserById(long id) {
        return repo.existsById(id);
    }
}
