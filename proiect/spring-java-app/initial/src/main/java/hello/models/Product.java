package hello;

public class Product {

    private  int id;
    private  String name;
    private  double price;
    private String details;

    public Product(int id, String name,double price,String details) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
      return price;
    }

    public void setPrice(double price){
      this.price = price;
    }

    public String getDetails() {
      return details;
    }
}
