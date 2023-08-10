package com.movies.repository;

import com.movies.entities.PopularIMDbIdList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularMovieIMDbRepository extends JpaRepository<PopularIMDbIdList, Long>{

}
