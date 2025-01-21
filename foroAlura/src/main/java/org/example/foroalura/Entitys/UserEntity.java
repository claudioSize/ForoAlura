package org.example.foroalura.Entitys;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "User_entity")
public class UserEntity implements UserDetails {

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

    public UserEntity(Integer id, String name, String email, PerfilEntity perfilEntity, String pass, List<AnswerEntity> answerEntity, List<TopicsEntity> topicsEntity) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.perfilEntity = perfilEntity;
        this.pass = pass;
        this.answerEntity = answerEntity;
        this.topicsEntity = topicsEntity;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
