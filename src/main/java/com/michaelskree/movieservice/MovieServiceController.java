package com.michaelskree.movieservice;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class MovieServiceController {

    @Autowired
    private MovieRepository movieRepository;

    /**
     * Health check endpoint
     */
    @GetMapping("/health")
    public void health() {
    }

    @GetMapping("/movie")
    public Page<Movie> getMovies(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable UUID id) {
        return movieRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/movie")
    public Movie createMovie(@RequestBody @Valid Movie movie) {
        return movieRepository.save(movie);
    }

    @PutMapping("/movie/{id}")
    public void updateMovie(@PathVariable UUID id, @RequestBody @Valid Movie movie) {
        if (movieRepository.existsById(id)) {
            movie.id = id;
            movieRepository.save(movie);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/movie/{id}")
    public void deleteMovie(@PathVariable UUID id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
