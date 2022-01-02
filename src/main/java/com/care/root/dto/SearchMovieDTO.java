package com.care.root.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchMovieDTO extends RepresentationModel<SearchMovieDTO> {
	private String movieId;
	private String movieTitle;
	private String movieDate;
	private int count;
}
