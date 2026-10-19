/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qickchat;

/**
 *
 * @author Student
 */
public class message {
    
//Declarations 
import java.util.ArrayList;
import java.util.Random;
import java.io.FileWriter;

public class Message {
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    
    private static int totalMessagesSent = 0;
    private static ArrayList<Message> sentMessages = new ArrayList<>();
    
    public Message(int messageNumber, String recipient, String messageText) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    public boolean checkMessageID() {
        return this.messageID != null && this.messageID.length() <= 10;
    }

    public String checkRecipientCell() {
        // Validates that it starts with + and is a reasonable length for an international number
        if (this.recipient != null && this.recipient.startsWith("+") && this.recipient.length() <= 12) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    public String createMessageHash() {
        if (messageText == null || messageText.trim().isEmpty()) {
            return "";
        }
        String firstTwoID = messageID.substring(0, 2);
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z]", ""); 
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z]", ""); 

        return (firstTwoID + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();
    }

    public String SentMessage(int choice) {
        switch (choice) {
            case 1:
                totalMessagesSent++;
                sentMessages.add(this);
                return "Message successfully sent.";
            case 2:
                return "Press 0 to delete the message.";
            case 3:
                storeMessage(); 
                return "Message successfully stored.";
            default:
                return "Invalid option.";
        }
    }

    public static String printMessages() {
        StringBuilder sb = new StringBuilder();
        for (Message msg : sentMessages) {
            sb.append("Message ID: ").append(msg.messageID).append("\n");
            sb.append("Message Hash: ").append(msg.messageHash).append("\n");
            sb.append("Recipient: ").append(msg.recipient).append("\n");
            sb.append("Message: ").append(msg.messageText).append("\n");
            sb.append("-------------------------\n");
        }
        return sb.toString();
    }

    public static int returnTotalMessagess() {
        return totalMessagesSent;
    }

    public void storeMessage() {
        String json = String.format(
            "{\n  \"id\": \"%s\",\n  \"number\": %d,\n  \"recipient\": \"%s\",\n  \"message\": \"%s\",\n  \"hash\": \"%s\"\n}",
            messageID, messageNumber, recipient, messageText, messageHash
        );
        try {
            FileWriter file = new FileWriter("messages.json", true); 
            file.write(json + "\n");
            file.close();
        } catch (Exception e) {
            System.out.println("Error saving to JSON file.");
        }
    }

    private String generateMessageID() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
}
}
