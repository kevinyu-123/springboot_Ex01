package com.care.root.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlDTO extends RepresentationModel<UrlDTO> {
	private String title;
	private String url;
	
	public UrlDTO(String title,String url)  {
		this.title = title;
		this.url = url;
	}
}
