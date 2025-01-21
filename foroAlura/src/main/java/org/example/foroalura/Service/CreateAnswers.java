package org.example.foroalura.Service;

import org.example.foroalura.DTOS.DTOCreateAnswer;
import org.example.foroalura.Entitys.AnswerEntity;
import org.example.foroalura.Entitys.PerfilEntity;
import org.example.foroalura.Entitys.TopicsEntity;
import org.example.foroalura.Repository.AnswerRepository;
import org.example.foroalura.Repository.PerfilRepository;
import org.example.foroalura.Repository.TopicsRepository;
import org.example.foroalura.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CreateAnswers {
    @Autowired
    PerfilRepository perfilRepository;
    @Autowired
    TopicsRepository topicsRepository;
    @Autowired
    AnswerRepository answerRepository;

    public void createAnswer(DTOCreateAnswer dto){
        AnswerEntity answer = new AnswerEntity();
        if (!topicsRepository.existsByTitle(dto.getTopicName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"El topico no existe");
        }else if (!perfilRepository.existsByName(dto.getUserName())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"El usuario no existe");
        } else {
            TopicsEntity topics = topicsRepository.findByTitle(dto.getTopicName());
            PerfilEntity perfil = perfilRepository.findByName(dto.getUserName());
            answer.setMess(dto.getMess());
            answer.setSolution(dto.getSolution());
            answer.setTopicsEntity(topics);
            answer.setUserEntity(perfil.getUserEntity());
            answerRepository.save(answer);
        }

    }
}
