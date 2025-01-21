package org.example.foroalura.Service;

import org.example.foroalura.DTOS.DTOCreateCurse;
import org.example.foroalura.Entitys.CurseEntity;
import org.example.foroalura.Repository.CurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CreateCurse {
    @Autowired
    CurseRepository curseRepository;

    public void createCurseM(DTOCreateCurse dto){
        CurseEntity curse = new CurseEntity();
        curse.setName(dto.getName());
        curse.setCategory(dto.getCategory());
        if (curseRepository.existsByName(dto.getName())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"El curso ya existe");
        }else {
            curseRepository.save(curse);
        }

    }
}
