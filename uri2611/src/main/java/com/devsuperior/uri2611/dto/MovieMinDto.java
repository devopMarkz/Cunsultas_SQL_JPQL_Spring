package com.devsuperior.uri2611.dto;

import com.devsuperior.uri2611.projections.MovieProjection;

public class MovieMinDto {

    private Long id;
    private String name;

    public MovieMinDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MovieMinDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
