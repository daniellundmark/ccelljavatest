package com.netlight.ccell.java.codenvy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netlight.ccell.java.codenvy.dao.MovieMockService;
import com.netlight.ccell.java.codenvy.domain.Movie;

@Controller
@RequestMapping("/movie")
public class MovieController
{
  @Autowired
  private MovieMockService movieService;


  @RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String name, ModelMap model) {
   
    Movie movie = movieService.getMovie(name);
		model.addAttribute("movie", movie);
		return "list";
 
	}
  
}