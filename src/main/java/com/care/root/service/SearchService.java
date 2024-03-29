package com.care.root.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.care.root.dto.MovieBookDto;
import com.care.root.dto.SearchMovieDTO;
import com.care.root.movieURL.movieURL;

@Service
public class SearchService implements movieURL {
	
	RestTemplate movieSearch = new RestTemplate();
	
	public SearchMovieDTO[] getMovieView() {
		  return movieSearch.getForObject(
		      movieViewUrl+"/getMovies" , SearchMovieDTO[].class);
		    }

	public String booking(MovieBookDto dto) {
	    boolean bool = bookingChk(dto.getMovieId(),dto.getBookCount());
	    String message;
	    if(bool) {
	    	Calendar cal = Calendar.getInstance();
	    	  SimpleDateFormat format = 
	    	    new SimpleDateFormat("yyyy/MM/dd-HH시mm분"); 
	    	  dto.setBookDate(format.format(cal.getTime()) );
	    	  int re = movieSearch.postForObject(
	    	    movieBookUrl+"save/", dto, Integer.class);
	    	  System.out.println("결과(1성공, 0실패) : "+re);

	  message = "<script>alert('성공')</script>";
	    }else {
	  message =
	   "<script>alert('실패');location.href='"+movieUrl+"'</script>";
	    }
	    return message;
	}
	private boolean bookingChk(String movieId, String bookCount) {
	    int count = movieSearch.getForObject(
	          movieViewUrl+"getCount/"+movieId , Integer.class);
	    if(count < Integer.parseInt(bookCount)) {
	    	return false;
	    	}else {
	    		Map<String , Object> map = new HashMap<String, Object>();
	    		map.put("movieId", movieId);
	    		map.put("count", bookCount);
	    		movieSearch.put(movieViewUrl+"subCount", map);

	    		return true;
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public ArrayList<SearchMovieDTO> getMovieView() {
//											 //경로, 반환타입
//		String test = movieSearch.getForObject(movieViewUrl+"/getMovies", String.class);
//		System.out.println("movieSearh 와 연결 결과 : "+test);
//		
//		
//		ArrayList<SearchMovieDTO> list = new ArrayList<SearchMovieDTO>();
//		String movieURL = "http://localhost:10000/search/movieinfo/";
//		for (int i = 1; i < 6; i++) {
//			SearchMovieDTO dto = new SearchMovieDTO();
//			dto.setMovieId(i + "");
//			dto.setMovieTitle("화성을 지켜라" + i);
//			dto.setMovieDate("2200-05-1" + i);
//			Link link = Link.of(movieURL + i);
//			dto.add(link.withRel(dto.getMovieTitle()));// 경로이름
//			list.add(dto);
//		}
//		return list;
//	}
}