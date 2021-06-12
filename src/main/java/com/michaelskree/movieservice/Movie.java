package com.michaelskree.movieservice;

import java.time.Duration;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.interval.PostgreSQLIntervalType;

@TypeDef(
    typeClass = PostgreSQLIntervalType.class,
    defaultForType = Duration.class
)
@Entity
public class Movie {
    @Id
    public UUID id;
    public String title;
    public String format;
    public Duration length;
    public Integer releaseYear;
    public Integer rating;
}
