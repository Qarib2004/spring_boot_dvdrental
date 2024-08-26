package org.spring.jdbc.dvdrentaljpa.service;

import org.spring.jdbc.dvdrentaljpa.entity.Actor;
import org.spring.jdbc.dvdrentaljpa.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ActorService {

    private static final Logger logger = Logger.getLogger(ActorService.class.getName());

    @Autowired
    private ActorRepository actorRepository;

    public void insert(Actor actor) {
        logger.info("insert actor: " + actor);
        actorRepository.save(actor);
        logger.info("id: " + actor.getActorId());
    }

    public void update(Actor actor) {
        logger.info("update actor: " + actor);
        actorRepository.save(actor);
    }

    public void delete(int actorId) {
        logger.info("Delete actor by id: " + actorId);
        actorRepository.deleteById(actorId);
    }

    public List<Actor> getAllActors() {
        logger.info("Select all actors");
        return actorRepository.findAll();
    }

    public Actor getActorById(int actorId) {
        logger.info("Select actor by id: " + actorId);
        return actorRepository.findById(actorId).orElse(null);
    }
}
