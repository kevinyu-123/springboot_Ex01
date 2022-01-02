package com.care.root.service;

import java.util.ArrayList;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import com.care.root.dto.UrlDTO;

@Service
public class UrlService {
	public ArrayList<UrlDTO> getUrl(){
  ArrayList<UrlDTO> urlList = new ArrayList<UrlDTO>();
  String[] url = {"/home","/searchMovie"};
  String[] name = {"홈","영화검색"};
  String defaultURL = "http://localhost:10000";
  for(int i=0;i<url.length;i++) {
      UrlDTO dto = new UrlDTO(name[i], url[i]);
      Link link = Link.of(defaultURL + url[i]);
      dto.add(link.withRel(dto.getUrl()));
      urlList.add(dto);
  		}
  return urlList;
    }
}

