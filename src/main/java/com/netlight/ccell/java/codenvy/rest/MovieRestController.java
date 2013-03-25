package com.netlight.ccell.java.codenvy.rest;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


import com.netlight.ccell.java.codenvy.domain.Movie;

@Controller
@RequestMapping("/rest/movie")
public class MovieRestController
{

   Map<Integer, Movie> movies = new HashMap<Integer, Movie>();

   public MovieRestController()
   {
    if(movies.isEmpty()) {
       newMovie(new Movie("The horse whisperer"));
       newMovie(new Movie("The color purple"));
    }
   }

   @RequestMapping(value = "/{name}", method = RequestMethod.GET)
   public @ResponseBody
   Movie getMovie(@PathVariable String name)
   {

      for(int id : movies.keySet()) {
        Movie movie = movies.get(id);
        if(movie.getId() == id) {
          return movie;
        }
      }
      
      return null;
   }
   
   @RequestMapping(value = "/", method = {RequestMethod.PUT, RequestMethod.POST})
   public @ResponseBody
   Movie newMovie(@RequestBody Movie movie)
   {

      if (movie.getId() == 0) {
         movie.randomizeId();
      }
      
      movies.put(movie.getId(), movie);

      return movie;
   }
   
   @RequestMapping(value = "/{id}", method = {RequestMethod.PUT, RequestMethod.POST})
   public @ResponseBody
   Movie updateMovie(@RequestBody Movie movie)
   {
   
      movies.put(movie.getId(), movie);

      return movie;
   }
   

   @RequestMapping(value = "/", method = RequestMethod.GET)
   public @ResponseBody
   List<Movie> getAllMovies()
   {
      List<Movie> allMovies = new ArrayList<Movie>();
      for(int id : movies.keySet()) {
        Movie movie = movies.get(id);
        allMovies.add(movie);
      }
      return allMovies;
   }

}
