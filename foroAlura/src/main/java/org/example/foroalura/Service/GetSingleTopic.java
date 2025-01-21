package org.example.foroalura.Service;

import org.example.foroalura.DTOS.DTOTopicList;
import org.example.foroalura.Entitys.TopicsEntity;
import org.example.foroalura.Repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GetSingleTopic {
    @Autowired
    TopicsRepository topicsRepository;

    public DTOTopicList getTpic(Integer id){
        DTOTopicList dto = new DTOTopicList();
        TopicsEntity topicsToDto = topicsRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"El topico no encontrado")) ;

        dto.setId(topicsToDto.getId());
        dto.setTitle(topicsToDto.getTitle());
        dto.setMessage(topicsToDto.getMessage());
        dto.setCreatedAt(topicsToDto.getCreatedAt());
        dto.setStatus(topicsToDto.getStatus());
        dto.setAuthorName(topicsToDto.getUser().getPerfilEntity().getName());
        dto.setCurseName(topicsToDto.getCurseEntity().getName());

        return dto;
    }
}
