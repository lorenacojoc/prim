package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;




@RestController
public class ActorController {

  private List<Actor> actors = new ArrayList<Actor>();

  ActorController() {
    Actor a1 = new Actor("The_Hunger_Games", "Liam_Hemsworth");
    Actor a2 = new Actor("Thor", "Chris_Hemsworth");
    Actor a3 = new Actor("The_Anomaly", "Ian_Somerhalder");

    actors.add(a1);
    actors.add(a2);
    actors.add(a3);
  }

  @RequestMapping(value="/actor", method = RequestMethod.GET)
  public List<Actor> index() {
    return this.actors;
  }

  @RequestMapping(value="/actor/{name}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("name") String name) {
    for(Actor a : this.actors) {
      if(a.getName().equals(name)) {
        return new ResponseEntity<Actor>(a, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/actor/{name}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("name") String name) {
    for(Actor a : this.actors) {
      if(a.getName().equals(name)) {
        this.actors.remove(a);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }




    @RequestMapping(value = "/actor/", method = RequestMethod.POST)
    public ResponseEntity<Actor> create(
        @RequestParam(value="movie") String movie,
        @RequestParam(value="name") String name){


        Actor actorr = new Actor(movie,name);
        this.actors.add(actorr);

   return new ResponseEntity<Actor>(actorr, new HttpHeaders(), HttpStatus.OK);



		

}


  @RequestMapping( value="/actor/{name}/{movie}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("name") String name,@PathVariable("movie") String movie) {
    for(Actor a : this.actors) {
      if(a.getName().equals(name)) {


        a.setMovie(movie);


    return new ResponseEntity<List<Actor>>(actors, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

}
