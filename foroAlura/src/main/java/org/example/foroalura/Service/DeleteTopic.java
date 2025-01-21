package org.example.foroalura.Service;

import org.example.foroalura.Entitys.TopicsEntity;
import org.example.foroalura.Repository.AnswerRepository;
import org.example.foroalura.Repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeleteTopic {
    @Autowired
    TopicsRepository topicsRepository;
    @Autowired
    AnswerRepository answerRepository;
    @Transactional
    public void deleteTP(Integer id){

        if (answerRepository.existsByTopicsEntityId(id)){
            answerRepository.deleteByTopicsEntityId(id);
            topicsRepository.deleteById(id);
        }else {
            topicsRepository.deleteById(id);
        }
    }
}
