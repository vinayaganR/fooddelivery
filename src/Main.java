import  java.util.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("welcome to food delivery App");

        boolean loop=true;
        while(loop){
            System.out.println("enter  your option");
            int n=sc.nextInt() ;
            sc.nextLine();
            switch (n){
                case 1 :{
                    System.out.println("......adding customer........");
                    foodfunction.addUser();
                    break;
                }
                case 2:{
                    System.out.println("......Adding resturant.......");
                    foodfunction.addrestuarnt();
                    break;
                }
                case 3:{
                    System.out.println(".....adding  delivery agent.....");
                    foodfunction.adddeliveryagent();
                    break;
                }
                case 4:{
                    System.out.println(".....show near by resuartant....");
                    System.out.println("enter  ur location");
                    String loc=sc.nextLine();
                    foodfunction.shownearbyresuarnt(loc);

                    break;
                }
                case 5:{
                    System.out.println("....place order....");
                    System.out.println("enter your id ");
                    int id=sc.nextInt();
                    sc.nextLine();
                    foodfunction.placeorder( id);






                    break;
                }
                case 6:{
                    System.out.print(".....complete Order....");
                    foodfunction.getbill();
                    break;
                }
                case 7:{
                    System.out.println(".....show order history.......");
                    break;
                }
                case 8:{
                    loop=false;
                    break;
                }
            }
        }

    }
}