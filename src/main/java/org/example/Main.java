package org.example;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static String AdminL = "Admin";
    public static String AddPass = "123";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n----------------------------------------------------");
                System.out.println("Welcome to ZOOtopia!\n" +
                        "\n" +
                        "1. Enter as Admin\n" +
                        "2. Enter as a Visitor\n" +
                        "3. View Special Deals\n");

                int entry = scan.nextInt();


                switch (entry) {
                    case 1:
                        System.out.println("Enter Admin Email: ");

                        scan.nextLine();
                        String mail = scan.nextLine();

                        if (Objects.equals(AdminL, mail)) {
                            System.out.println("Enter Admin Password: ");
                            String pass = scan.nextLine();

                            if (Objects.equals(AddPass, pass)) {
                                System.out.println("Login Success!");
                                Admin.main(args);
                            } else {
                                System.out.println("Wrong Password");
                            }
                        } else {
                            System.out.println("Wrong Mail");
                        }
                        break;

                    case 2:
                        VisitorLogin.main(args);
                        break;

                    case 3:
                        System.out.println("Available Deals");
                        for (Special_Deals deal : Special_Deals.deals) {
                            System.out.println(deal.toString());
                        }
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid number choice");
            scan.nextLine();
            Main.main(args);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            scan.close();
        }
    }
}


