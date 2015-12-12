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
public class ProductController {

  private List<Product> products = new ArrayList<Product>();

  ProductController() {
    Product p1 = new Product(1, "parfum",250.57,"lily,rose");
    Product p2 = new Product(2, "tricou", 30.25,"red");
    Product p3 = new Product(3, "pantofi", 340.67,"leather");

    products.add(p1);
    products.add(p2);
    products.add(p3);
  }

  @RequestMapping(value="/product", method = RequestMethod.GET)
  public List<Product> index() {
    return this.products;
  }

  @RequestMapping(value="/product/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int  id) {
    for(Product p : this.products) {
      if(p.getId()==id) {
        return new ResponseEntity<Product>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/product/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Product p : this.products) {
      if(p.getId()==id) {
        this.products.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }




    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Product> create(
        @RequestParam(value="id", defaultValue="7") int id,
        @RequestParam(value="name", defaultValue="Yolo") String name,
        @RequestParam(value="price", defaultValue="77.77") double price
        @RequestParam(value="details",defaultValue="") String details){


        Product prod = new Product(id,name,price,details);
        this.products.add(prod);

   return new ResponseEntity<Product>(prod, new HttpHeaders(), HttpStatus.OK);



}


  @RequestMapping( value="/product/{id}/{price}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id,@PathVariable("price") double price) {
    for(Product p : this.products) {
      if(p.getId()==id) {

        p.setPrice(price);



    return new ResponseEntity<List<Product>>(products, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

}
