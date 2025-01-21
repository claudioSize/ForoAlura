package org.example.foroalura.Service;

import org.example.foroalura.DTOS.DTOCreateAnswer;
import org.example.foroalura.Entitys.AnswerEntity;
import org.example.foroalura.Entitys.PerfilEntity;
import org.example.foroalura.Entitys.TopicsEntity;
import org.example.foroalura.Repository.AnswerRepository;
import org.example.foroalura.Repository.PerfilRepository;
import org.example.foroalura.Repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAnswerList {
    @Autowired
    AnswerRepository answerRepository;

    public List<DTOCreateAnswer> answers(Integer id){

        List<DTOCreateAnswer> response = new ArrayList<>();

        for (AnswerEntity answer1 : answerRepository.findAnswerEntitiesByTopicsEntityId(id)){
            DTOCreateAnswer dto = new DTOCreateAnswer();
            dto.setMess(answer1.getMess());
            dto.setSolution(answer1.getSolution());
            dto.setTopicName(answer1.getTopicsEntity().getTitle());
            dto.setUserName(answer1.getUserEntity().getPerfilEntity().getName());
            response.add(dto);
        }
        return response;
    }
}
