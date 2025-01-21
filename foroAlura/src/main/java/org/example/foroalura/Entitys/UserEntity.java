package org.example.foroalura.Entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "User_entity")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String pass;

    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PerfilEntity perfilEntity;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AnswerEntity> answerEntity;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TopicsEntity> topicsEntity;

    public UserEntity() {
    }

    public UserEntity(Integer id, String name, String pass, String email, PerfilEntity perfil, List<AnswerEntity> answer, List<TopicsEntity> topics) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.perfilEntity = perfil;
        this.answerEntity = answer;
        this.topicsEntity = topics;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PerfilEntity getPerfilEntity() {
        return perfilEntity;
    }

    public void setPerfilEntity(PerfilEntity perfilEntity) {
        this.perfilEntity = perfilEntity;
    }

    public List<AnswerEntity> getAnswerEntity() {
        return answerEntity;
    }

    public void setAnswerEntity(List<AnswerEntity> answerEntity) {
        this.answerEntity = answerEntity;
    }

    public List<TopicsEntity> getTopicsEntity() {
        return topicsEntity;
    }

    public void setTopicsEntity(List<TopicsEntity> topicsEntity) {
        this.topicsEntity = topicsEntity;
    }
}
