import java.util.HashMap;

public class customer {
    private  int customer_id;
    private  String customer_name;
    private String c_location;
     static HashMap<String,Integer> order=new HashMap<>();

//    public void setOrder(HashMap<String, Integer> order) {
//        this.order = order;
//    }


    public HashMap<String, Integer> getOrder() {
        return order;
    }

    public customer(int customer_id, String customer_name, String c_location) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.c_location = c_location;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setC_location(String c_location) {
        this.c_location = c_location;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getC_location() {
        return c_location;
    }
}
