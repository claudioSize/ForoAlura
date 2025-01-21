package org.example.foroalura.Controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.example.foroalura.DTOS.*;
import org.example.foroalura.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class Controller {

    @Autowired
    private SGetTopics sGetTopics;
    @Autowired
    private CreateTopics createTopics;
    @Autowired
    private CreateUser createUser;
    @Autowired
    private CreateCurse createCurse;
    @Autowired
    private CreateAnswers createAnswers;
    @Autowired
    private GetSingleTopic getSingleTopic;
    @Autowired
    private DeleteTopic deleteTopic;
    @Autowired
    private GetAnswerList getAnswerList;
    @Autowired
    private UpdateTopic updateTopic;

    @GetMapping("/topico/lista/")
    public ResponseEntity<List<DTOTopicList>> getTopicsList(){
        return ResponseEntity.ok(sGetTopics.getTopics());
    }
    @GetMapping("/topico/{id}/")
    public ResponseEntity<DTOTopicList> getTopics(@PathVariable Integer id){
        return ResponseEntity.ok(getSingleTopic.getTpic(id));
    }
    @GetMapping("/respuesta/{id}/")
    public ResponseEntity<List<DTOCreateAnswer>> getAns(@PathVariable Integer id){
        return ResponseEntity.ok(getAnswerList.answers(id));
    }
    @PostMapping("/usuario/nuevo/")
    public ResponseEntity<HttpStatus> createUserC(@RequestBody DTOCreateUser dto) {
        createUser.createUs(dto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @PostMapping("/curso/nuevo/")
    public ResponseEntity<HttpStatus> createCurse(@Valid @RequestBody DTOCreateCurse dto) {
        createCurse.createCurseM(dto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @PostMapping("/topico/nuevo/")
    public ResponseEntity<HttpStatus> topicCreate(@Valid @RequestBody DTOCreateTopics dto){
        createTopics.createTopicsM(dto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @DeleteMapping("/topico/eliminar/{id}/")
    public ResponseEntity<HttpStatus> deletetTopics(@PathVariable Integer id){
        deleteTopic.deleteTP(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/respuesta/nueva/")
    @Validated
    public ResponseEntity<HttpStatus> createAns(@Valid @RequestBody DTOCreateAnswer dto){
        createAnswers.createAnswer(dto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @PutMapping("/topico/actualizar/{id}/")
    public ResponseEntity<HttpStatus> upgradeTop(@Valid @PathVariable Integer id, @RequestBody DTOUpdateTopic dto){
        updateTopic.updateTopicsM(id,dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
