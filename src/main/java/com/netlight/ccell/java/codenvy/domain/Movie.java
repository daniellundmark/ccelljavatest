package com.netlight.ccell.java.codenvy.domain;

public class Movie
{
   private String title;
   private int id;
  
   public Movie()
   {
      randomizeId();
   }


/*   public Movie(String title)
   {
      super();
      randomizeId();
      this.title = title;
   }
*/

   public String getTitle()
   {
      return title;
   }

   public void setTitle(String title)
   {
      this.title = title;
   }


   public int getId()
   {
      return id;
   }


   public void setId(int id)
   {
      this.id = id;
   }
   
   public void randomizeId()
   {
      this.id = (int)(Math.random() * 1000);
   }
}