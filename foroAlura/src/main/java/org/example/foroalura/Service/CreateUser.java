package org.example.foroalura.Service;

import org.example.foroalura.DTOS.DTOCreateUser;
import org.example.foroalura.Entitys.PerfilEntity;
import org.example.foroalura.Entitys.UserEntity;
import org.example.foroalura.Repository.PerfilRepository;
import org.example.foroalura.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CreateUser {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PerfilRepository perfilRepository;

    public void createUs(DTOCreateUser dtoCreateUser){

        UserEntity user = new UserEntity();
        PerfilEntity perfil = new PerfilEntity();
        perfil.setName(dtoCreateUser.getPerfilName());
        perfil.setUserEntity(user);
        user.setName(dtoCreateUser.getName());
        user.setEmail(dtoCreateUser.getEmail());
        user.setPass(dtoCreateUser.getPass());
        user.setPerfilEntity(perfil);

        if (userRepository.existsByEmail(dtoCreateUser.getEmail())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"El correo ya esta en uso");
        } else if (perfilRepository.existsByName(dtoCreateUser.getPerfilName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"El nombre de perfil ya existe");
        }else {
            userRepository.save(user);
        }
    }
}
