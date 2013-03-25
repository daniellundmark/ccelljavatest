package com.netlight.ccell.java.codenvy.rest;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import com.netlight.ccell.java.codenvy.dao.MovieMockService;
import com.netlight.ccell.java.codenvy.domain.Movie;

@Controller
@RequestMapping("/rest/movie")
public class MovieRestController
{
  @Autowired
  private MovieMockService movieService; 


   @RequestMapping(value = "/{name}", method = RequestMethod.GET)
   public @ResponseBody
   Movie getMovie(@PathVariable String name)
   {
     return movieService.getMovie(name);
   }
   
   @RequestMapping(value = "/", method = {RequestMethod.PUT, RequestMethod.POST})
   public @ResponseBody
   Movie newMovie(@RequestBody Movie movie)
   {
     return movieService.newMovie(movie);
   }
   
   @RequestMapping(value = "/{id}", method = {RequestMethod.PUT, RequestMethod.POST})
   public @ResponseBody
   Movie updateMovie(@RequestBody Movie movie)
   {
     return movieService.updateMovie(movie);
   }
   

   @RequestMapping(value = "/", method = RequestMethod.GET)
   public @ResponseBody
   List<Movie> getAllMovies()
   {
      return movieService.getAllMovies();
   }

}
