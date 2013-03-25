package com.netlight.ccell.java.codenvy.dao;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import com.netlight.ccell.java.codenvy.domain.Movie;

@Service
public class MovieMockService
{
   private static Map<Integer, Movie> movies = new HashMap<Integer, Movie>();
   
     public MovieMockService()
     {
        if(movies.isEmpty()) {
         newMovie(new Movie("The horse whisperer"));
         newMovie(new Movie("The color purple"));
         newMovie(new Movie("Apollo XIII"));
        }
     }

     public Movie getMovie(int id)
     {
        return movies.get(id);
     } 

    
   public Movie getMovie(String name)
   {

      for(int id : movies.keySet()) {
        Movie movie = movies.get(id);
        if(movie.getTitle().equals(name)) {
          return movie;
        }
      }
      
      return null;
   }
   

   public Movie newMovie(Movie movie)
   {

      if (movie.getId() == 0) {
         movie.randomizeId();
      }
      
      movies.put(movie.getId(), movie);

      return movie;
   }
   
  
   public Movie updateMovie(Movie movie)
   {
   
      movies.put(movie.getId(), movie);

      return movie;
   }
   

  
   public List<Movie> getAllMovies()
   {
      List<Movie> allMovies = new ArrayList<Movie>();
      for(int id : movies.keySet()) {
        Movie movie = movies.get(id);
        allMovies.add(movie);
      }
      return allMovies;
   }
}