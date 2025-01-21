package org.example.foroalura.Service;

import org.example.foroalura.DTOS.DTOCreateTopics;
import org.example.foroalura.Entitys.CurseEntity;
import org.example.foroalura.Entitys.PerfilEntity;
import org.example.foroalura.Entitys.TopicsEntity;
import org.example.foroalura.Repository.CurseRepository;
import org.example.foroalura.Repository.PerfilRepository;
import org.example.foroalura.Repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CreateTopics {
    @Autowired
    TopicsRepository topicsRepository;
    @Autowired
    CurseRepository curseRepository;
    @Autowired
    PerfilRepository perfilRepository;
    //título, mensaje, autor y curso
    public void createTopicsM(DTOCreateTopics dto){
        if (!curseRepository.existsByName(dto.getCurseName())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"El curso no existe");
        } else if (!perfilRepository.existsByName(dto.getAuthorName())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"El Author no existe");
        } else if (topicsRepository.existsByTitle(dto.getTitle()) ) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"El topico ya existe");
        }else if (topicsRepository.existsByMessage(dto.getMess())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"El topico ya existe");
        } {
            TopicsEntity topics = new TopicsEntity();
            CurseEntity curse = curseRepository.findByName(dto.getCurseName());
            PerfilEntity user = perfilRepository.findByName(dto.getAuthorName());

            topics.setTitle(dto.getTitle());
            topics.setMessage(dto.getMess());
            topics.setCurseEntity(curse);
            topics.setUser(user.getUserEntity());
            topics.setStatus("Abierto");
            topicsRepository.save(topics);
        }

    }
}
