import java.util.*;

public class foodfunction {
    static Scanner sc=new Scanner(System.in);
    static ArrayList<customer> user=new ArrayList<>();
    static  ArrayList<resturant> ruser=new ArrayList<>();
    static  ArrayList<deliveryagent> deliveryuser=new ArrayList<>();
    static  Map<String,Integer> order_id=new HashMap<>();
    static  int price=0;
    public static  void addUser(){
        int n=1;
        while(n==1){
            System.out.println("enter the id");
            int id= sc.nextInt();
            sc.nextLine();
            System.out.println("enter the name");
            String name= sc.nextLine();
            System.out.print("enter the location ");
            String c_loaction=sc.nextLine();

            customer c=new customer(id,name,c_loaction);
            user.add(c);

            System.out.println(" do u want to add the user more ?");
            n=sc.nextInt();


        }
    }
    public static void addrestuarnt(){
        int n=1;
        while(n==1){
            System.out.println("enter the id");
            int id= sc.nextInt();
            sc.nextLine();
            System.out.println("enter the name");
            String name= sc.nextLine();
            System.out.print("enter the location ");
            String c_loaction=sc.nextLine();

            resturant r=new resturant(id,name,c_loaction);
            ruser.add(r);

            System.out.println(" do u want to add the restuarnt more ?");
            n=sc.nextInt();


        }
    }
    public static void adddeliveryagent(){
        int n=1;
        while(n==1){
            System.out.println("enter the id");
            int id= sc.nextInt();
            sc.nextLine();
            System.out.println("enter the name");
            String name= sc.nextLine();
            System.out.print("enter the location ");
            String c_loaction=sc.nextLine();

        deliveryagent d=new deliveryagent(id,name,c_loaction);
            deliveryuser.add(d);

            System.out.println(" do u want to add more delivery agent ?");
            n=sc.nextInt();


        }

    }

    public static  HashMap<Double,String>  shownearbyresuarnt(String location){
        HashMap<Double,String> res=new HashMap<>();
        int x1=location.charAt(0)-'a';
        int y1=location.charAt(1)-'1';
        for(int i=0;i<ruser.size();i++){
           String loc= ruser.get(i).getLocation();
           loc.toLowerCase();
           int x2=loc.charAt(0)-'a';
           int y2=loc.charAt(1)-'1';
           double km= Math.pow(Math.abs(x2-x1),2)+Math.pow(Math.abs(y2-y1),2);
           res.put(km,ruser.get(i).getR_name());

        }

        return res;


    }
    public void addmenu(int id){
        HashMap<String,Integer>res=new HashMap<>();
        boolean loop=true;
        for(int i=0;i<ruser.size();i++){
            if(ruser.get(i).getId()==id){
                while(loop){
                    System.out.println("enter the menu ");
                    String menu=sc.nextLine();
                    System.out.println("enter the price");
                    int price=sc.nextInt();
                    sc.nextLine();
                    res.put(menu,price);
                    System.out.println(" add more menu");
                    loop=sc.nextBoolean();


                }
                ruser.get(i).setFoods(res);


            }

        }


    }
    public static void placeorder(int id){
        for(int i=0;i<user.size();i++){
            if(user.get(i).getCustomer_id()==id){
                String name= user.get(i).getCustomer_name();
                String location =user.get(i).getC_location();
                shownearbyresuarnt(location);

            }
        }
        System.out.println("chooose the restauarnt id near to u ");
        String  r_id=sc.nextLine();
        for(int i=0;i<ruser.size();i++){
            if(ruser.get(i).getR_name().equals(r_id)){
                ruser.get(i).getFoods();


                System.out.println(" order the food  ");
                String foodname=sc.nextLine();
                int quantity=sc.nextInt();
                int food= ruser.get(i).price(foodname);

                sc.nextLine();
                System.out.println("enter the customer id");
                int oid=sc.nextInt();


                user.get(oid).order.put(foodname,quantity);
                price=quantity*food;




// get food

//store this
            }

        }



    }
    public static  int getbill(){
        return price;

    }
    public static void  gethistory( int id){
        for(int i=0;i<user.size();i++){
            if(user.get(i).getCustomer_id()==id){
                System.out.println(user.get(i).getOrder());

            }
        }
    }
}
