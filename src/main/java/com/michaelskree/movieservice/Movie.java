package com.michaelskree.movieservice;

import java.time.Duration;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.interval.PostgreSQLIntervalType;

@TypeDef(
    typeClass = PostgreSQLIntervalType.class,
    defaultForType = Duration.class
)
@Entity
public class Movie {
    @GeneratedValue
    @Id
    public UUID id;

    @Size(min = 1, max = 50)
    public String title;

    @Enumerated(EnumType.STRING)
    public MovieFormat format;

    public Duration length;

    @Min(1800)
    @Max(2100)
    public Integer releaseYear;

    @Min(1)
    @Max(5)
    public Integer rating;
}
