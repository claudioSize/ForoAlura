package org.example.foroalura.Service;

import org.example.foroalura.DTOS.DTOTopicList;
import org.example.foroalura.Entitys.TopicsEntity;
import org.example.foroalura.Repository.CurseRepository;
import org.example.foroalura.Repository.PerfilRepository;
import org.example.foroalura.Repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SGetTopics {
    @Autowired
    TopicsRepository topicsRepository;
    @Autowired
    CurseRepository curseRepository;
    @Autowired
    PerfilRepository perfilRepository;


    public List<DTOTopicList> getTopics(){
        List<TopicsEntity> list = topicsRepository.findAll();

        return topicsToDTO(list);
    }

    public List<DTOTopicList> topicsToDTO(List<TopicsEntity> list){
        List<DTOTopicList> response = new ArrayList<>();
        for (TopicsEntity topicsToDto : list){
            DTOTopicList dto = new DTOTopicList();
            dto.setId(topicsToDto.getId());
            dto.setTitle(topicsToDto.getTitle());
            dto.setMessage(topicsToDto.getMessage());

            dto.setCreatedAt(topicsToDto.getCreatedAt());
            dto.setStatus(topicsToDto.getStatus());
            dto.setAuthorName(topicsToDto.getUser().getPerfilEntity().getName());
            dto.setCurseName(topicsToDto.getCurseEntity().getName());
            response.add(dto);
        }
        return response;
    }


}
