
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DacordMachine
 */
public class Tester {

    public static void main(String args[]) {

        boolean done = false;

        ConnectorUsers conu = new ConnectorUsers();

        System.out.println("Welcome to JDBC practice");
        
        do {
        
        System.out.print("What would you like to do? \n"
                + "1. Create user \n"
                + "2. Select users \n"
                + "3. Update user \n"
                + "4. Delete user \n"
                + "5. Exit \n" +
                " ->");

        try {

            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();

            switch (option) {

                case 1:
                    conu.create();
                    break;

                case 2:
                    conu.select();
                    break;

                case 3:
                    conu.select();
                    conu.update();
                    break;

                case 4:
                    conu.select();
                    conu.delete();
                    break;

                case 5:
                    System.out.println("Thanks");
                    done = true;

            }

        } catch (Exception ex) {

            System.out.println("Invalid option");

        }
        
        }while(done==false);

    }

}
