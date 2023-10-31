package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Animals implements Events {
    private String Type;
    public void visit(){
        System.out.println("1.Feed\n" +
                "2.Read About Animals");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        scan.nextLine();
        switch (choice){
            case 1:
                System.out.println("Feeding ");
                System.out.println(getSound());
                break;
            case 2:
                System.out.println(getDes());
                break;
        }
    }
    public String getType(){
        return this.Type;
    }
    private void SetType(String s){
        this.Type= s;
    }
    public static ArrayList<Animals> animals = new ArrayList<>();
    boolean status;
    private String Des;

    public String getDes() {
        return Des;
    }

    private void setDes(String s) {
        this.Des = s;
    }

    private String Sound;

    public String getSound() {
        return this.Sound;
    }

    private void SetSound(String Sound) {
        this.Sound = Sound;
    }

    public String get_Status() {
        return (status ? "Open" : "Close");
    }

    private int Price;

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        this.Price = price;
    }

    public void changeStatus() {
        this.status = (!this.status);
    }

    private String name;

    public String get_Name() {
        return this.name;
    }

    private void setName(String newn) {
        this.name = newn;
    }

    private int Tic_count = 0;

    public int getTic_count() {
        return this.Tic_count;
    }

    public void TicketSale() {
        this.Tic_count++;
    }

    public Animals(String name, String des, String Sound, int price,String type) {
        this.name = name;
        this.Des = des;
        this.setPrice(price);
        this.SetSound(Sound);
        this.status = true;
        this.Type=type;

    }
    public static void Modify(){
        Scanner scan = new Scanner(System.in);
        System.out.println("These Are Available Attractions");
        for (int i=0;i<Animals.animals.size();i++){
            System.out.printf("%d %s\n",i+1,Animals.animals.get(i).get_Name());
        }
        System.out.println("Choose Attraction You Want To Modify");
        int MChoice = scan.nextInt();
        if(MChoice>Animals.animals.size()){
            System.out.println("Input a Valid Choice ");
            return;
        }
        scan.nextLine();
        Animals att = Animals.animals.get(MChoice-1);
        System.out.println("1.Change Name of Animal\n" +
                "2.Change Open/Close Status\n" +
                "3.Change Price\n" +
                "4.Change Description\n" +
                "5.Change Sound\n" +
                "6.Exit"
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
                System.out.println("Enter New Sound");
                String MChoice6 = scan.nextLine();
                att.SetSound(MChoice6);
            case 6:
                break;
            default:
                System.out.println("Enter Correct Choice");
        }

    }
    public static void ManageAnimals() {
        Scanner scan = new Scanner(System.in);

        System.out.printf("1. Add Animal\n" +
                "2. Update Animal Details\n" +
                "3. Remove Animal\n" +
                "4.View Animals\n" +
                "5. Exit\n");
        int choice = scan.nextInt();
        scan.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Enter Name Of Animal \n");
                String Name1 = scan.nextLine();
                System.out.println("Enter Description Of Animal ");
                String Des1 = scan.nextLine();
                System.out.println("Enter Price for Animal ");
                int price = scan.nextInt();
                scan.nextLine();
                System.out.println("Enter Sound Of Animal ");
                String Sound = scan.nextLine();
                System.out.println("Enter M For Mammal , R For Reptile or A for Amphibian");
                String type = scan.nextLine();
                switch (type){
                    case "M":
                        Animals newt=new Mammal(Name1,Des1,Sound,price);
                        Animals.animals.add(newt);
                        break;
                    case "A":
                        Animals newt1=new Amphibian(Name1,Des1,Sound,price);
                        Animals.animals.add(newt1);
                        break;
                    case "R":
                        Animals newt11=new Reptiles(Name1,Des1,Sound,price);
                        Animals.animals.add(newt11);
                        break;
                    default:
                        System.out.println("Enter Correct Type");
                }
                break;
            case 2:
                Animals.Modify();
                break;
            case 3:
                System.out.println("These Are Available Attractions");
                for (int i=0;i<Animals.animals.size();i++){
                    System.out.printf("%d %s\n",i+1,Animals.animals.get(i).get_Name());
                }
                System.out.println("Choose Animal You Want To Remove");
                int Choice4 = scan.nextInt();
                scan.nextLine();
                String type1 = Animals.animals.get(Choice4-1).getType();
                switch (type1){
                    case "M":
                       Mammal.Mammals.removeIf(arr->arr.get_Name().equals(Animals.animals.get(Choice4-1).get_Name()));
                       break;
                    case "A":
                        Amphibian.Amphibians.removeIf(arr->arr.get_Name().equals(Animals.animals.get(Choice4-1).get_Name()));
                        break;
                    case "R":
                        Reptiles.Reptiles.removeIf(arr->arr.get_Name().equals(Animals.animals.get(Choice4-1).get_Name()));
                        break;
                }
                Animals.animals.remove(Choice4-1);
                System.out.println("Animal Removed Successfully");
            case 4:
                for(int i=0;i<Animals.animals.size();i++){
                    System.out.println(Animals.animals.get(i).get_Name());
                }
            case 5:
                break;
            default:
                System.out.println("Enter Correct Choice");

        }
    }
}
class Mammal extends Animals{
    public static ArrayList<Mammal> Mammals = new ArrayList<>();
    Mammal(String name, String des, String Sound, int price){
        super(name,des,Sound,price,"Mammals");
        Mammal.Mammals.add(this);

    }
}
class Amphibian extends Animals{
    public static ArrayList<Amphibian> Amphibians = new ArrayList<>();
    Amphibian(String name, String des, String Sound, int price){
        super(name,des,Sound,price,"Amphibians");
        Amphibian.Amphibians.add(this);
    }
}
class Reptiles extends Animals{
    public static ArrayList<Reptiles> Reptiles = new ArrayList<>();
    Reptiles(String name, String des, String Sound, int price){
        super(name,des,Sound,price,"Reptiles");
        Reptiles.add(this);

    }
}