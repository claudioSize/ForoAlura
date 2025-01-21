package org.example.foroalura.Entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "topic_entity")

public class TopicsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String message;
    @CreationTimestamp
    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    private String status;

    @ManyToOne
    @JoinColumn(name = "curse_entity_id")
    @JsonIgnore
    private CurseEntity curseEntity;

    @ManyToOne
    @JoinColumn(name = "user_entity_id")
    @JsonIgnore
    private UserEntity userEntity;

    @OneToMany(mappedBy = "topicsEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AnswerEntity> answersEntity;

    public TopicsEntity() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CurseEntity getCurseEntity() {
        return curseEntity;
    }

    public void setCurseEntity(CurseEntity curseEntity) {
        this.curseEntity = curseEntity;
    }

    public UserEntity getUser() {
        return userEntity;
    }

    public void setUser(UserEntity user) {
        this.userEntity = user;
    }

    public List<AnswerEntity> getAnswersEntity() {
        return answersEntity;
    }

    public void setAnswersEntity(List<AnswerEntity> answersEntity) {
        this.answersEntity = answersEntity;
    }
}
