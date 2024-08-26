package org.spring.jdbc.dvdrentaljpa.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


import java.time.LocalDateTime;

@Entity
@Table(name = "film_actor")
public class FilmActor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_actor_id")
    private int filmActorId;

    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = true)
    private Actor actor;

    @Column(name = "last_update", nullable = false, updatable = true)
    private LocalDateTime lastUpdate;

    public FilmActor() {}

    public FilmActor(int filmActorId, Actor actor, LocalDateTime lastUpdate) {
        this.filmActorId = filmActorId;
        this.actor = actor;
        this.lastUpdate = lastUpdate;
    }

    public int getFilmActorId() {
        return filmActorId;
    }

    public void setFilmActorId(int filmActorId) {
        this.filmActorId = filmActorId;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "FilmActor{" +
                "filmActorId=" + filmActorId +
                ", actor=" + actor +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}

