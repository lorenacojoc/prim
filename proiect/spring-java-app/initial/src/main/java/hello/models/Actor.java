package hello;

import java.util.List;
import java.util.ArrayList;

public class Actor {
  private String movie;
  private String name;


  public Actor() {}

  public Actor(String movie, String name) {
      this.name = name;
      this.movie = movie;
  }



 public String getMovie(){
    return this.movie;
 }

  public String getName() {
      return this.name;
  }


public void setMovie(String movie) {
    this.movie = movie;
}


}
