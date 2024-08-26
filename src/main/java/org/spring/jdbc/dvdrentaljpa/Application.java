package org.spring.jdbc.dvdrentaljpa;

import org.spring.jdbc.dvdrentaljpa.entity.Actor;
import org.spring.jdbc.dvdrentaljpa.service.ActorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        // Получение бина ActorService из контекста
//        ActorService actorService = context.getBean(ActorService.class);

        // Примеры использования методов ActorService
//        Actor newActor = new Actor();
//        newActor.setFirstName("John");
//        newActor.setLastName("Doe");
//        actorService.insert(newActor);

//        Actor actor = actorService.getActorById(newActor.getActorId());
//        System.out.println("Inserted Actor: " + actor);
//
//        actor.setLastName("Smith");
//        actorService.update(actor);
//
//        System.out.println("Updated Actor: " + actorService.getActorById(actor.getActorId()));
//
//        actorService.delete(actor.getActorId());
//        System.out.println("Deleted Actor with ID: " + actor.getActorId());
    }
}