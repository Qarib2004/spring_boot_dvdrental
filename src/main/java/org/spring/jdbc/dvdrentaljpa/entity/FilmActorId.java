//package org.spring.jdbc.dvdrentaljpa.entity;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//public class FilmActorId implements Serializable {
//
//    private int actor;
//    private int film;
//
//    public FilmActorId() {}
//
//    public FilmActorId(int actor,int film) {
//        this.actor = actor;
//       this.film = film;
//    }
//
//    // hashCode и equals
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        FilmActorId that = (FilmActorId) o;
//        return actor == that.actor && film==that.film;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(actor);
//    }
//}
