package org.example;

import com.sun.jdi.connect.AttachingConnector;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Attraction implements Events {
    public static ArrayList<Attraction> All_Attractions =new ArrayList<>();
    private boolean status;
    public void visit(){
        System.out.println(getDes());
        System.out.println("Visit Success");
    }
    private String Des;

    public String getDes() {
        return Des;
    }
    private void setDes(String s){
        this.Des=s;
    }

    public String get_Status(){
        return (status?"Open":"Close");
    }
    private int Price;
    public int getPrice(){
        return Price;
    }
    public void setPrice(int price){
        this.Price=price;
    }
    public void changeStatus(){
        this.status=(!this.status);
    }
    private String name;
    public  String get_Name(){
        return this.name;
    }
    private void setName(String newn){
        this.name=newn;
    }
private int Tic_count=0;
    public int getTic_count(){
        return this.Tic_count;
    }
    public void TicketSale(){
        this.Tic_count++;
    }
    public Attraction(String name, String des, int price){
        this.name=name;
        this.Des=des;
        this.setPrice(price);
        this.status=true;

    }
    public static void Modify(){
        Scanner scan = new Scanner(System.in);
        System.out.println("These Are Available Attractions");
        for (int i=0;i<Attraction.All_Attractions.size();i++){
            System.out.printf("%d %s\n",i+1,Attraction.All_Attractions.get(i).get_Name());
        }
        System.out.println("Choose Attraction You Want To Modify");
        int MChoice = scan.nextInt();
        if(MChoice>All_Attractions.size()){
            System.out.println("Input a Valid Choice ");
            return;
        }
        scan.nextLine();
        Attraction att = Attraction.All_Attractions.get(MChoice-1);
        System.out.println("1.Change Name of Attraction\n" +
                "2.Change Open/Close Status\n" +
                "3.Change Price\n" +
                "4.Change Description\n" +
                        "5.Exit"
                );
        int Mchoice1 = scan.nextInt();
        scan.nextLine();
        switch (Mchoice1){
            case 1:
                System.out.println("Enter New Name");
                String Mchoice2 = scan.nextLine();
                att.setName(Mchoice2);
                System.out.println("Name Changes Successfully;");
                break;
            case 2:
                System.out.printf("Current Status is %s \n",att.get_Status());
                System.out.println("Press C to change or other key to exit");
                String MChoice2 ="A";
                Mchoice2=scan.nextLine();
                if(Objects.equals(Mchoice2, "C")){
                    att.changeStatus();
                    System.out.printf(" Status Changed to %s \n",att.get_Status());
                    break;
                }
                break;
            case 3:
                System.out.println("Enter New Price");
               int MChoice3 =scan.nextInt();
               scan.nextLine();
               att.setPrice(MChoice3);
                break;
            case 4:
                System.out.println("Enter New Description");
                String MChoice4 =scan.nextLine();
                att.setDes(MChoice4);
                break;
            case 5:
                break;
        }

    }
    public static void Manage_Attractions(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Manage Attractions:\n" +
                "1. Add Attraction\n" +
                "2. View Attractions\n" +
                "3. Modify Attraction\n" +
                "4. Remove Attraction\n" +
                "5. Exit\n" +
                "Enter Your Choice ");
        int choice = scan.nextInt();
        scan.nextLine();
        switch (choice){
            case 1:
                System.out.print("Enter Name Of Attraction \n");
                String Name1 = scan.nextLine();
                System.out.println("Enter Description Of Attraction ");
                String Des1 = scan.nextLine();
                System.out.println("Enter Price for Attraction ");
                int price =  scan.nextInt();
                scan.nextLine();
                Attraction newAt = new Attraction(Name1,Des1,price);
                Attraction.All_Attractions.add(newAt);
                break;
            case 2:
                for(Attraction attr: Attraction.All_Attractions ){
                    System.out.println(attr.get_Name());
                }
                break;
            case 3:
                Attraction.Modify();
                break;
            case 4:
                System.out.println("These Are Available Attractions");
                for (int i=0;i<Attraction.All_Attractions.size();i++){
                    System.out.printf("%d %s\n",i+1,Attraction.All_Attractions.get(i).get_Name());
                }
                System.out.println("Choose Attraction You Want To Remove");
                int Choice4 = scan.nextInt();
                scan.nextLine();
                Attraction.All_Attractions.remove(Choice4-1);
                System.out.println("Attraction Removed Successfully");
            case 5:
                break;
            default:
                System.out.println("Enter Correct Choice");

        }


    }
}
