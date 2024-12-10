package com.devsuperior.uri2611.repositories;

import com.devsuperior.uri2611.dto.MovieMinDto;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true, value = "SELECT movies.id, movies.name " +
            "FROM movies " +
            "INNER JOIN genres " +
            "ON movies.id_genres = genres.id " +
            "WHERE UPPER(genres.description) = UPPER(:description)")
    List<MovieProjection> search1(@Param("description") String description);

    @Query("SELECT new com.devsuperior.uri2611.dto.MovieMinDto(obj.id, obj.name) " +
            "FROM Movie obj " +
            "WHERE obj.genre.description = :description")
    List<MovieMinDto> search2(@Param("description") String description);

}
