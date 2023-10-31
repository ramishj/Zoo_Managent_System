package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Visitor {
    private String MemeType=null;
    public String getMemeType(){
        return this.MemeType;
    }
    public void setMemeType(String s){
        this.MemeType=s;
    }
    private ArrayList<Events> tickets = new ArrayList<>();
    private String Name;

    public String getName() {
        return Name;
    }
    public void setName(String s){
        this.Name=s;
    }
    private int Age;
    public int getAge(){
        return this.Age;
    }
    public void setAge(int i){
        this.Age=i;
    }
    private String phone;
    public String getPhone(){
        return this.phone;
    }
    public void setPhone(String abc){
        this.phone=abc;
    }
    private int Balance;
    public int getBalance(){
        return this.Balance;
    }
    public void deductBalance(int a){
        this.Balance-=a;
    }
    public void setBalance(int a){
        this.Balance=a;
    }
    private String Email;
    public String getEmail(){
        return this.Email;
    }
    private String PassWord;
    private String getPassWord(){
        return this.PassWord;
    }
    public boolean verifyPass(String s){
        if(s.equals(this.getPassWord())){
            return true;
        }
        return false;
    }
    public Visitor(String name,int Age,String phone,int balance,String Mail,String pass){
        this.Name=name;
        this.Age=Age;
        this.phone=phone;
        this.Balance=balance;
        this.Email=Mail;
        this.PassWord=pass;

    }
    private void PurchaseTicket(Events a, int quantity, int originalPrice, int discountedAmount) {
        for (int i = 0; i < quantity; i++) {
            tickets.add(a);
        }
        this.Balance -= discountedAmount;
        System.out.println("Tickets Purchased Successfully ");
        System.out.printf("%d Rs Deducted", discountedAmount);
        Admin.Tot_rev += discountedAmount;
    }
    private int checkTickets(Events a,int quantity){
        int count =0;
        for(int i=0;i<tickets.size();i++){
            if(tickets.get(i).equals(a)){
                count++;
            }
        }
        if(count>=quantity){
            for (int i=0;i<quantity;i++){
                tickets.removeIf(b->b.equals(a));
                return 1;
            }

        }
        return 0;
    }
    public void VisitorMenu() {
        Scanner scan = new Scanner(System.in);
        boolean logout = false;
        while (!logout){
            System.out.println("/n---------------------------------------");
            System.out.printf("\nWelcome %s\n", this.getName());
        System.out.println("Visitor Menu:\n" +
                "1. Explore the Zoo\n" +
                "2. Buy Membership\n" +
                "3. Buy Tickets\n" +
                "4. View Discounts\n" +
                "5. View Special Deals\n" +
                "6. Visit Animals\n" +
                "7. Visit Attractions\n" +
                "8. Leave Feedback\n" +
                "9. Log Out\n");
        int choice = scan.nextInt();
        scan.nextLine();
        OuterSwitch1:
        switch (choice) {
            case 1:
                System.out.println("1.View Attractions\n" +
                        "2.View Animals\n" +
                        "3.Exit\n");
                int choice1 = scan.nextInt();
                scan.nextLine();
                switch (choice1) {
                    case 1:
                        for (Attraction anim : Attraction.All_Attractions) {
                            System.out.println(anim.get_Name());
                        }

                        break;
                    case 2:
                        for (Animals anim : Animals.animals) {
                            System.out.println(anim.get_Name());
                        }

                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Enter Correct Choice");
                        break;
                }
                break;

            case 2:
                System.out.printf("You Currently Have %s\n", getMemeType());
                System.out.println("1.Buy Basic Membership 20Rs\n" +
                        "2.Buy Premium Membership 50Rs\n" +
                        "3.Exit");
                int buyt = scan.nextInt();
                scan.nextLine();
                switch (buyt) {
                    case 1:
                        this.deductBalance(20);
                        Admin.Tot_rev += 20;
                        System.out.println("Basic Bought");
                        this.setMemeType("Basic");
                        break;
                    case 2:
                        this.deductBalance(50);
                        Admin.Tot_rev += 50;
                        System.out.println("Premium Bought");
                        this.setMemeType("Premium");
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Enter Correct Choice");
                }
                break;
            case 3:
                if (this.getMemeType() == null) {
                    System.out.println("Buy Membership First");
                    break;
                }
                System.out.println("Buy Tickets for\n" +
                        "1.Attractions\n" +
                        "2.Animals\n" +
                        "3.Exit\n");
                int TicketsBuy1 = scan.nextInt();
                scan.nextLine();
                switch (TicketsBuy1) {
                    case 1:
                        for (int i = 0; i < Attraction.All_Attractions.size(); i++) {
                            System.out.printf("%d %s %s\n", i + 1, Attraction.All_Attractions.get(i).get_Name(), Attraction.All_Attractions.get(i).get_Status());
                        }
                        System.out.println("Select Attraction You Want To Buy Ticket for");
                        int choice33 = scan.nextInt();
                        scan.nextLine();
                        Attraction curr = Attraction.All_Attractions.get(choice33 - 1);
                        if (curr.get_Status().equals("Close")) {
                            System.out.println("This Attraction Is closed");
                            break;
                        }
                        System.out.println("Enter Quantity");
                        int quant = scan.nextInt();
                        scan.nextLine();
                        int disc = 0;
                        int maxDealdisc = 0;
                        for (Special_Deals deal : Special_Deals.deals) {
                            if (deal.quantity >= quant) {
                                maxDealdisc = Math.max(maxDealdisc, deal.discountPercent);
                            }
                        }
                        if (maxDealdisc != 0) {
                            System.out.printf("Deal Applied %d%% off\n", maxDealdisc);
                        }
                        System.out.println("Do You Want To Apply Coupon Code\n" +
                                "1.Yes\n" +
                                "2.No\n");
                        int optionC = scan.nextInt();
                        scan.nextLine();
                        int currDis = 0;
                        switch (optionC) {
                            case 1:
                                System.out.println("Enter Coupon Code ");
                                String coupon = scan.nextLine();
                                for (Discounts dis : Discounts.disc) {
                                    if (dis.Coupon.equals(coupon)) {
                                        currDis += dis.Percent;
                                    }
                                }
                                if (currDis > 0) {
                                    System.out.printf("Discount Applied of %d%%\n", currDis);
                                }
                                break;
                            case 2:
                                break;
                        }

                        if (getBalance() > quant * curr.getPrice() - (curr.getPrice() * ((currDis + maxDealdisc) / 100))) {
                            PurchaseTicket(curr, quant, quant * curr.getPrice(), (quant * curr.getPrice()) - (curr.getPrice() * ((currDis + maxDealdisc) / 100)));
                        }
                        break;
                    case 2:
                        for (int i = 0; i < Animals.animals.size(); i++) {
                            System.out.printf("%d %s %s\n", i + 1, Animals.animals.get(i).get_Name(), Animals.animals.get(i).get_Status());
                        }
                        System.out.println("Select Animal You Want To Buy Ticket for");
                        int choice333 = scan.nextInt();
                        scan.nextLine();
                        if (choice333 > Animals.animals.size()) {
                            System.out.println("Enter Correct Choice");
                            break;
                        }
                        Animals currr = Animals.animals.get(choice333 - 1);
                        if (currr.get_Status().equals("Close")) {
                            System.out.println("This Animal Is closed");
                            break;
                        }
                        System.out.println("Enter Quantity");
                        int quant1 = scan.nextInt();
                        scan.nextLine();
                        int disc1 = 0;
                        int maxDealdisc1 = 0;
                        for (Special_Deals deal : Special_Deals.deals) {
                            if (deal.quantity >= quant1) {
                                maxDealdisc1 = Math.max(maxDealdisc1, deal.discountPercent);
                            }
                        }
                        if (maxDealdisc1 != 0) {
                            System.out.printf("Deal Applied %d%% off\n", maxDealdisc1);
                        }
                        System.out.println("Do You Want To Apply Coupon Code\n" +
                                "1.Yes\n" +
                                "2.No\n");
                        int optionC1 = scan.nextInt();
                        scan.nextLine();
                        int currDis1 = 0;
                        switch (optionC1) {
                            case 1:
                                System.out.println("Enter Coupon Code ");
                                String coupon1 = scan.nextLine();
                                for (Discounts dis : Discounts.disc) {
                                    if (dis.Coupon.equals(coupon1)) {
                                        currDis1 += dis.Percent;
                                        System.out.printf("Discount Applied of %d%%\n", currDis1);
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                break;
                        }
                        if (getBalance() > (quant1 * currr.getPrice()) - (currr.getPrice() * ((currDis1 + maxDealdisc1) / 100))) {
                            PurchaseTicket(currr, quant1, quant1 * currr.getPrice(), (quant1 * currr.getPrice()) - (currr.getPrice() * ((currDis1 + maxDealdisc1) / 100)));
                        }

                        break;
                }
                break;
            case 4:
                System.out.println("Available Discounts");
                for (int i = 0; i < Discounts.disc.size(); i++) {
                    System.out.printf(" %s (%d%% discount) - %s%s\n",
                            Discounts.disc.get(i).Category,
                            Discounts.disc.get(i).Percent,
                            Discounts.disc.get(i).Category,
                            Integer.toString(Discounts.disc.get(i).Percent)
                    );
                }
                break;

            case 5:
                System.out.println("Available Deals");
                for (Special_Deals deal : Special_Deals.deals) {
                    System.out.println(deal.toString());
                }
                break;
            case 6:
                System.out.println("Choose Animal to Visit");
                for (int i = 0; i < Animals.animals.size(); i++) {
                    System.out.printf("%d. %s\n", i + 1, Animals.animals.get(i).get_Name());
                }
                int choice6 = scan.nextInt();
                scan.nextLine();
                Animals curr1 = Animals.animals.get(choice6 - 1);
                System.out.println("Enter No. of tickets to be used");
                int choice66 = scan.nextInt();
                scan.nextLine();
                if (this.checkTickets(curr1, choice66) == 1) {
                    curr1.visit();
                }
                else {
                    System.out.println("Not enough Tickets");
                }
                break;
            case 7:
                System.out.println("Choose Atttraction to Visit");
                for (int i = 0; i < Attraction.All_Attractions.size(); i++) {
                    System.out.printf("%d. %s\n", i + 1, Attraction.All_Attractions.get(i).get_Name());
                }

                int choice7 = scan.nextInt();

                Attraction currr1 = Attraction.All_Attractions.get(choice7 - 1);
                System.out.println("Enter No. of tickets to be used");

                int choice77 = scan.nextInt();
                scan.nextLine();
                if (this.checkTickets(currr1, choice77) == 1) {
                    currr1.visit();
                    System.out.println("Visited");
                }
                else {
                    System.out.println("Not enough Tickets");
                }
                break;

            case 8:
                System.out.println("Enter Your FeedBack");
                String feed = scan.nextLine();
                FeedBack feedBack = new FeedBack(getName(), feed);
                break;
            case 9:
                logout=true;
                break;
            default:
                System.out.println("Enter Correct Choice");


        }
    }
    }
}
class VisitorLogin{
    public static  ArrayList<Visitor> visitors=new ArrayList<>();
public static Visitor getInstancebyMail(String Name){
    for(Visitor visit: visitors){
        if(visit.getEmail().equals(Name)){
            return visit;
        }
    }
    return null;
}
    public static void main(String[] args) {
        System.out.println("1.Register\n" +
                "2.Login");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        scan.nextLine();
        switch (option){
            case 1:
                System.out.println("Enter Visitor Name: ");
                String name = scan.next();
                System.out.println("Enter Visitor Age: ");
                int age = scan.nextInt();
                System.out.println("Enter Visitor Phone Number: ");
                String phone = scan.next();
                System.out.println("Enter Visitor Balance:");
                int bal = scan.nextInt();
                System.out.println("Enter Visitor Email: ");
                String Email = scan.next();
                System.out.println("Enter Visitor Password: ");
                String Password = scan.next();
                Visitor vis = new Visitor(name, age, phone, bal, Email, Password);
                VisitorLogin.visitors.add(vis);
                System.out.println("User Registered");
                break;
            case 2:
                System.out.println("Enter Visitor Email: ");
                String Mail = scan.nextLine();
                Visitor curr = VisitorLogin.getInstancebyMail(Mail);
                if(curr==null){
                    System.out.println("Incorrect Mail");
                    break;
                }
                System.out.println("Enter Visitor Password: ");
                    String Pass = scan.nextLine();
                    if (curr.verifyPass(Pass)) {
                        System.out.println("Login Success!");
                        curr.VisitorMenu();
                    } else {
                        System.out.println("Wrong Password");
                    }
                    break;
        }
    }
}
