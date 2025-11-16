package tn.esprit.spring.mappers;

import org.mapstruct.Mapper;
import tn.esprit.spring.dto.utilisateur.UtilisateurRequest;
import tn.esprit.spring.dto.utilisateur.UtilisateurResponse;
import tn.esprit.spring.entities.Utilisateur;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
   Utilisateur fromDTOToEntity(UtilisateurRequest u);
   Utilisateur fromDTOToEntity2(UtilisateurResponse u);
   UtilisateurResponse fromEntityToDTO(Utilisateur u);
}
