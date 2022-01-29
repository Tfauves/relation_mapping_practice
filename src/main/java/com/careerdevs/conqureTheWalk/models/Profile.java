package com.careerdevs.conqureTheWalk.models;

import com.careerdevs.conqureTheWalk.models.auth.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

// TODO: 1/25/2022 need to bring in profile avatar for user and for dogs 
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("owner")
    private Set<Dog> myDogs;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @OneToOne
    private Avatar avatar;

    public Profile() {}

    public Profile(User user, String name, Avatar avatar) {
        this.user = user;
        this.name = name;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Dog> getMyDogs() {
        return myDogs;
    }

    public void setMyDogs(Set<Dog> myDogs) {
        this.myDogs = myDogs;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }
}
