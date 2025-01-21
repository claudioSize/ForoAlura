package org.example.foroalura.Service;

import org.example.foroalura.DTOS.DTOUpdateTopic;
import org.example.foroalura.Entitys.CurseEntity;
import org.example.foroalura.Entitys.TopicsEntity;
import org.example.foroalura.Repository.CurseRepository;
import org.example.foroalura.Repository.PerfilRepository;
import org.example.foroalura.Repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UpdateTopic {
    @Autowired
    TopicsRepository topicsRepository;
    @Autowired
    CurseRepository curseRepository;
    @Autowired
    PerfilRepository perfilRepository;
    //título, mensaje, autor y curso
    public void updateTopicsM(Integer id, DTOUpdateTopic dto){
        TopicsEntity topics = topicsRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"El topico no existe"));
        CurseEntity curse = curseRepository.findByName(dto.getCurseName());

        if (topicsRepository.existsByTitle(dto.getTitle()) || topicsRepository.existsByMessage(dto.getMess())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El topico ya existe");
        }
        topics.setTitle(dto.getTitle());
        topics.setMessage(dto.getMess());
        topics.setCurseEntity(curse);
        topics.setStatus(dto.getStatus());
        try {

            topicsRepository.save(topics);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"El curso no existe");
        }

    }
}
