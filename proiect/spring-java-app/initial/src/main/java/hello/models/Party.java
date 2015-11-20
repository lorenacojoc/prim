package hello;

public class Party {

    private  int id;
    private  int nr_guests;
    private  String theme;


    public Party(int id,int nr_guests, String theme) {
        this.id = id;
        this.nr_guests = nr_guests;
        this.theme = theme;

    }

    public int getNr_guests() {
        return nr_guests;
    }

    public String getTheme() {
        return theme;
    }


    public int getId() {
        return id;
    }

    public void setNr_guests(int nr_guests){
      this.nr_guests = nr_guests;
    }


}
