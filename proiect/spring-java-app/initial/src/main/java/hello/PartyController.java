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
public class PartyController {

  private List<Party> parties = new ArrayList<Party>();

  PartyController() {
    Party p1 = new Party(1,10, "Halloween");
    Party p2 = new Party(2,20, "Spring");
    Party p3 = new Party(3,30, "Vampire");

    parties.add(p1);
    parties.add(p2);
    parties.add(p3);
  }

  @RequestMapping(value="/party", method = RequestMethod.GET)
  public List<Party> index() {
    return this.parties;
  }

  @RequestMapping(value="/party/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int  id) {
    for(Party p : this.parties) {
      if(p.getId() == id) {
        return new ResponseEntity<Party>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/party/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Party p : this.parties) {
      if(p.getId() == id) {
        this.parties.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }




    @RequestMapping(value = "/party", method = RequestMethod.POST)
    public ResponseEntity<Party> create(
        @RequestParam(value="id") int id,
        @RequestParam(value="nr_guests") int nr_guests,
        @RequestParam(value="theme") String theme){


        Party part = new Party(id,nr_guests,theme);
        this.parties.add(part);

   return new ResponseEntity<Party>(part, new HttpHeaders(), HttpStatus.OK);




}


  @RequestMapping( value="/party/{id}/{nr_guests}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id,@PathVariable("nr_guests") int nr_guests) {
    for(Party p : this.parties) {
      if(p.getId() == id) {

        p.setNr_guests(nr_guests);


    return new ResponseEntity<Party>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

}
