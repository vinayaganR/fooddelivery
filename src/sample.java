import java.util.*;

class Customer {
    private int id;
    private String name;
    private String location;

    // constructor
    public Customer(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }
    // getters and setters

    public String getName() {
        return name;
    }
}

class Driver {
    private int id;
    private String name;
    private String car;
    private String location;
    private boolean available = true;

    public Driver(int id, String name, String car, String location) {
        this.id = id;
        this.name = name;
        this.car = car;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getId() {
        return id;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // getters and setters
}

class Ride {
    private int rideId;
    private Customer customer;
    private Driver driver;
    private String start;
    private String end;
    private double fare;
    private String status; // "Booked", "Completed"

    public Ride(int rideId, Customer customer, Driver driver, String start, String end) {
        this.rideId = rideId;
        this.customer = customer;
        this.driver = driver;
        this.start = start;
        this.end = end;
        this.status = "Booked";
    }

    public int getRideId() {
        return rideId;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public double getFare() {
        return fare;
    }

    public Driver getDriver() {
        return driver;
    }
// getters and setters

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }
}

class CabService {
    static Scanner sc=new Scanner(System.in);
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Driver> drivers = new ArrayList<>();
    private static ArrayList<Ride> rides = new ArrayList<>();
    private static int rideCounter = 1;

    public static void addCustomer(int id, String name, String location) {
        // TODO: add customer
        Customer customer=new Customer(id,name,location);
        customers.add(customer);


    }

    public static void addDriver(int id, String name, String car, String location) {
        // TODO: add driver
        Driver driver=new Driver(id,name,car,location);
        drivers.add(driver);
    }

    public static void showNearbyDrivers(String location) {
        // TODO: show drivers based on distance
        double min=0;
        int id=-1;
        int x2=location.charAt(0)-'a';
        int y2=location.charAt(1)-'0';

        for (int i=0;i<drivers.size();i++){
            if(drivers.get(i).isAvailable())
            {
                String loc=drivers.get(i).getLocation();
                int x1=loc.charAt(0)-'a';
                int y1=loc.charAt(1)-'0';
                double ans= Math.pow((x2-x1),2)+Math.pow((y2-y1),2);
                if(ans>min){
                    min=ans;
                    id=drivers.get(i).getId();

                }

            }


        }
        System.out.println("Driver "+id+" is near to you with distance of  "+min);
    }

    public static void bookRide(int customerId, String destination) {
        // TODO: find nearest driver, assign ride
        String location="";
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).getId()==customerId){
                location=customers.get(i).getLocation();
                showNearbyDrivers(location);
                System.out.println("do you want to assign the rider ?");
                String book=sc.nextLine();
                int id=sc.nextInt();
                sc.nextLine();
                for (int j=0;j<drivers.size();j++){
                    if(book.equals("yes")&& drivers.get(j).getId()==id){
                        drivers.get(i).setAvailable(false);
                        Ride r=new Ride(1,customers.get(i),drivers.get(i),location,destination);
                        rides.add(r);

                    }
                }



            }
        }
    }

    public static void completeRide(int rideId) {
        int fare=0;
        // TODO: calculate fare, mark driver available again
        for (int i=0;i<rides.size();i++)
        {
            if (rides.get(i).getRideId()==rideId){
                String start=rides.get(i).getStart();
                String end=rides.get(i).getEnd();
                int x1=start.charAt(0)-'a';
                int y=start.charAt(1)-'0';
                int x2=end.charAt(0)-'a';
                int y2=end.charAt(1)-'0';
                double dis=Math.pow((x2-x1),2)+Math.pow((y2-y),2);
                 fare=(int)(dis*5);
            }
             Driver d =rides.get(i).getDriver();
            d.setAvailable(true);
            rides.get(i).setStatus("completed");

        }
    }

    public static void showRideHistory(int customerId) {
        // TODO: show rides for this customer
        for (int i=0;i<rides.size();i++)
        {
        if (rides.get(i).getCustomer().getId()==customerId){
            System.out.println(" .....your rides  are ....");
            System.out.print(rides.get(i).getStart());
            System.out.print(rides.get(i).getEnd());
            System.out.print(rides.get(i).getFare());
        }
        }
    }
}

public class sample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("1. Add Customer");
            System.out.println("2. Add Driver");
            System.out.println("3. Show Nearby Drivers");
            System.out.println("4. Book Ride");
            System.out.println("5. Complete Ride");
            System.out.println("6. Show Ride History");
            System.out.println("7. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    String location=sc.nextLine();
                    int id=sc.nextInt();
                    String name=sc.nextLine();
                    CabService.addCustomer(id,name,location);
                    break;
                case 2:
                    // call addDriver
                    int did=sc.nextInt();
                    String dname=sc.nextLine();
                    String dcar=sc.nextLine();
                    String dlocation=sc.nextLine();
                    CabService.addDriver(did,dname,dcar,dlocation);
                    break;
                case 3:
                    String location1=sc.nextLine();
                    CabService.showNearbyDrivers(location1);
                    // call showNearbyDrivers
                    break;
                case 4:
                    int io=sc.nextInt();
                    String destination =sc.nextLine();
                    CabService.bookRide(io,destination);
                    // call bookRide
                    break;
                case 5:
                    // call completeRide
                    int riderid=sc.nextInt();
                    CabService.completeRide(riderid);
                    break;
                case 6:
                    // call showRideHistory
                    int customerid=sc.nextInt();
                    CabService.showRideHistory(customerid);
                    break;
                case 7:
                    loop = false;
                    break;
            }
        }
    }
}
