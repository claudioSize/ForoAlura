package org.example.foroalura.Entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "curse_entity")
public class CurseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String category;


    @OneToMany(mappedBy = "curseEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TopicsEntity> topicsEntity;

    public CurseEntity(Integer id, String name, String category, List<TopicsEntity> topics) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.topicsEntity = topics;
    }

    public CurseEntity() {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<TopicsEntity> getTopicsEntity() {
        return topicsEntity;
    }

    public void setTopicsEntity(List<TopicsEntity> topicsEntity) {
        this.topicsEntity = topicsEntity;
    }
}
