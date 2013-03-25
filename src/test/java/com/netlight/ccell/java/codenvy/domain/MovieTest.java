package com.netlight.ccell.java.codenvy.domain;

import junit.framework.Test;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.*;

import org.codehaus.jackson.map.ObjectMapper;
 
public class MovieTest extends TestCase {
  
 

    public void testMovieToJson() throws Exception{
    
       Movie m = new Movie();
       m.setTitle("JUnit test");

       ObjectMapper mapper = new ObjectMapper();
       String jsonString = mapper.writeValueAsString(m);
       System.out.println("@Test - JSON is: "+jsonString);
    }
 

    public void testJsonToMovie() throws Exception{

          ObjectMapper mapper = new ObjectMapper();
          String json = "{\"id\":999\"title\":\"The horse whisperer\"}";
          Movie m = mapper.readValue(json, Movie.class);

    }
}