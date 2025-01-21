package org.example.foroalura;

import org.apache.catalina.core.ApplicationContext;
import org.example.foroalura.Entitys.*;
import org.example.foroalura.Repository.UserRepository;
import org.example.foroalura.Service.SaveUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ForoAluraApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForoAluraApplication.class, args);

    }

}
