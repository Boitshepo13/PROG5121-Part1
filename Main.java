/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login login = new Login(); // create login object

        // get user names
        System.out.print("Enter First Name: ");
        String firstName = input.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = input.nextLine();

        // get account details
        System.out.print("Enter Username: ");
        String username = input.nextLine();

        System.out.print("Enter Password: ");
        String password = input.nextLine();

        System.out.print("Enter Cell Phone Number (e.g +27838968976): ");
        String cell = input.nextLine();

        // call register method
        String result = login.registerUser(username, password, cell);
        System.out.println(result);

        // loop again if something wrong
        while (!login.checkUserName(username) || !login.checkPasswordComplexity(password) || !login.checkCellPhoneNumber(cell)) {
            if (!login.checkUserName(username)) {
                System.out.print("Enter Username again: ");
                username = input.nextLine();
            }
            if (!login.checkPasswordComplexity(password)) {
                System.out.print("Enter Password again: ");
                password = input.nextLine();
            }
            if (!login.checkCellPhoneNumber(cell)) {
                System.out.print("Enter Cell again: ");
                cell = input.nextLine();
            }
            result = login.registerUser(username, password, cell);
            System.out.println(result);
        }

        // login part
        System.out.println("\n--- LOGIN ---");
        System.out.print("Enter Username to login: ");
        String loginUser = input.nextLine();
        System.out.print("Enter Password to login: ");
        String loginPass = input.nextLine();

        // show login status
        String loginStatus = login.returnLoginStatus(loginUser, loginPass, firstName, lastName);
        System.out.println(loginStatus);
    }
}
