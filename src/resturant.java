import java.util.*;
public class resturant {
    private int id;
    private String r_name;
    private String location;
    private HashMap<String ,Integer>foods=new HashMap<>();

    public resturant(int id, String r_name, String location) {
        this.id = id;
        this.r_name = r_name;
        this.location = location;
    }
    public int price(String food){
        int price=0;
        for(int i=0;i<foods.size();i++){
            price= foods.get(food);
        }
        return price;
    }

    public resturant() {
    }

    public int getId() {
        return id;
    }

    public String getR_name() {
        return r_name;
    }

    public String getLocation() {
        return location;
    }

    public HashMap<String, Integer> getFoods() {
        return foods;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFoods(HashMap<String, Integer> foods) {
        this.foods = foods;
    }

}
