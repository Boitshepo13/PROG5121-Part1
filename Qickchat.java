/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.qickchat;

/**
 *
 * @author Student
 */
public class Qickchat {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    package quickchat;

import java.util.Scanner;

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to QuickChat.");

        System.out.print("How many messages do you wish to enter? ");
        int numMessages = scanner.nextInt();
        scanner.nextLine(); 

        boolean running = true;

        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose an option: ");
            
            int menuChoice = scanner.nextInt();
            scanner.nextLine(); 

            switch (menuChoice) {
                case 1:
                    for (int i = 1; i <= numMessages; i++) {
                        System.out.println("\n--- Message " + i + " of " + numMessages + " ---");
                        
                        System.out.print("Enter recipient cell number (include international code, e.g., +27): ");
                        String recipient = scanner.nextLine();
                        
                        String messageText = "";
                        boolean validMessage = false;
                        
                        while (!validMessage) {
                            System.out.print("Enter message (max 250 characters): ");
                            messageText = scanner.nextLine();
                            
                            if (messageText.length() > 250) {
                                int excess = messageText.length() - 250;
                                System.out.println("Message exceeds 250 characters by " + excess + "; please reduce the size.");
                            } else {
                                System.out.println("Message ready to send.");
                                validMessage = true;
                            }
                        }

                        Message msg = new Message(i, recipient, messageText);
                        
                        String cellCheck = msg.checkRecipientCell();
                        System.out.println(cellCheck);
                        
                        System.out.println("\nWhat would you like to do?");
                        System.out.println("1) Send Message");
                        System.out.println("2) Disregard Message");
                        System.out.println("3) Store Message to send later");
                        System.out.print("Choice: ");
                        int actionChoice = scanner.nextInt();
                        scanner.nextLine(); 
                        
                        String actionResult = msg.SentMessage(actionChoice);
                        System.out.println(actionResult);
                        
                        if (actionChoice == 1) {
                            System.out.println("\nMessage Details:");
                            System.out.println("Message ID: " + msg.getMessageID());
                            System.out.println("Message Hash: " + msg.getMessageHash());
                            System.out.println("Recipient: " + recipient);
                            System.out.println("Message: " + messageText);
                        }
                    }
                    
                    System.out.println("\nTotal messages successfully sent: " + Message.returnTotalMessagess());
                    break;

                case 2:
                    System.out.println("Coming Soon.");
                    break;

                case 3:
                    System.out.println("Exiting QuickChat. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }
        scanner.close();
    }
}
    }

