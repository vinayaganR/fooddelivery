import java.util.*;
public class deliveryagent {

    private int d_id;
    private String d_name;
    private String d_location;
    private  boolean avialable=true;

    public deliveryagent(int d_id, String d_name, String d_location) {
        this.d_id = d_id;
        this.d_name = d_name;
        this.d_location = d_location;
    }

    public int getD_id() {
        return d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public String getD_location() {
        return d_location;
    }

    public boolean isAvialable() {
        return avialable;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public void setD_location(String d_location) {
        this.d_location = d_location;
    }

    public void setAvialable(boolean avialable) {
        this.avialable = avialable;
    }

}
