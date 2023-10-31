package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Admin {
    public static int Tot_rev = 0;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        MainLOOP:
        while (true) {
            try {
                System.out.println("\nLogged in as Admin.\n" +
                        "\n" +
                        "Admin Menu:\n" +
                        "1. Manage Attractions\n" +
                        "2. Manage Animals\n" +
                        "3. Schedule Events\n" +
                        "4. Set Discounts\n" +
                        "5. Set Special Deal\n" +
                        "6. View Visitor Stats\n" +
                        "7. View Feedback\n" +
                        "8. Exit\n");


                if (scanner.hasNextInt()) {
                    int entry = scanner.nextInt();
                    switch (entry) {
                        case 1:
                            Attraction.Manage_Attractions();
                            break;

                        case 2:
                            Animals.ManageAnimals();
                            break;

                        case 3:
                            System.out.println("1.Schedule Animals\n" +
                                    "2.Schedule Attractions\n");
                            int choice3=scanner.nextInt();
                            scanner.nextLine();
                            switch (choice3){
                                case 1:
                                    Animals.Modify();
                                case 2:
                                    Attraction.Modify();
                                default:
                                    System.out.println("Enter Correct Choice");
                            }
                            break;
//
                        case 4:
                            System.out.println("Enter category for Discount");
                            scanner.nextLine();
                            String Cat= scanner.nextLine();
                            System.out.println("Enter Percentage for Discount");
                            int per = scanner.nextInt();
                            Discounts dis = new Discounts(Cat,per);
                            System.out.println("Discount Added");
                            break;
//
                        case 5:
                            System.out.println("Enter No. of Tickets for Discount");
                            int quant= scanner.nextInt();
                            System.out.println("Enter Percentage for Discount");
                            int perc =scanner.nextInt();
                            Special_Deals deal = new Special_Deals(quant,perc);
                            System.out.println("Deal Added");
                            break;

                        case 6:
                            System.out.printf("Total Visitors %d\n",VisitorLogin.visitors.size());
                            System.out.printf("Total Revenue %d\n",Admin.Tot_rev);
                            break ;


                        case 7:
                            for (FeedBack feed : FeedBack.Feeds) {
                                System.out.printf("%s\nVisitorName:%s", feed.Name, feed.FeedBack1);
                            }
                            break;

                        case 8:
                            Main.main(args);

                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                            break;
                    }
                } else {
                   System.err.println("Invalid input. Please enter a number.");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
                e.printStackTrace();
            }

        }


    }
}
