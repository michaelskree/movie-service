package com.michaelskree.movieservice;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface MovieRepository extends PagingAndSortingRepository<Movie, UUID>{
}