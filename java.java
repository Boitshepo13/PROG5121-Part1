/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MaasageManagerTest;

/**
 *
 * @author Student
 */
public class java {
  import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class MessageManagerTest {
    private MessageManager manager;

    @Before
    public void setUp() {
        manager = new MessageManager();
        manager.populateTestData(); // Load the 5 test messages
    }

    @Test
    public void testSentMessagesArrayPopulated() {
        // Based on Test Data 1 and 4 being "Sent"
        // We check if the sentMessages array contains the expected texts.
        // In the image, it asks for "Developer entry for Test data for message 1-4"
        // But 4 is dinner time. 
        
        // Let's verify Sent array has "Did you get the cake?"
        boolean foundCake = false;
        for(Message m : manager.sentMessages) {
            if(m.getMessageText().equals("Did you get the cake?")) foundCake = true;
        }
        assertTrue("Sent messages should contain Test Data 1", foundCake);

        boolean foundDinner = false;
        for(Message m : manager.sentMessages) {
            if(m.getMessageText().equals("It is dinner time !")) foundDinner = true;
        }
        assertTrue("Sent messages should contain Test Data 4", foundDinner);
    }

    @Test
    public void testGetLongestMessage() {
        // Test Data 2 is the longest stored message
        String expected = "Where are you? You are late! I have asked you to be on time.";
        assertEquals(expected, manager.getLongestMessage());
    }

    @Test
    public void testSearchByID() {
        // The assignment table says "Test Data: message 4" and ID "0838884567".
        // NOTE: In my generated code, IDs are random. 
        // To pass this specific test, you might need to hardcode the ID in your test 
        // or modify the Message constructor to accept an ID for testing.
        
        // Let's assume the logic works and we search for the ID of the 'Dinner' message.
        // We need to find the ID from the list first.
        String targetID = "";
        for(Message m : manager.sentMessages) {
            if(m.getMessageText().contains("dinner")) {
                targetID = m.getMessageID();
            }
        }
        
        // Now verify search
        String result = manager.searchByID(targetID);
        assertTrue(result.contains("It is dinner time !"));
        assertTrue(result.contains("0838884567"));
    }

    @Test
    public void testSearchByRecipient() {
        // Test Data: +27838884567
        // Expected: "Where are you..." and "Ok, I am leaving..."
        ArrayList<String> results = manager.searchByRecipient("+27838884567");
        
        assertTrue(results.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(results.contains("Ok, I am leaving without you."));
    }

    @Test
    public void testDeleteMessageByHash() {
        // Test Data: Test Message 2
        // First find the hash for that message
        String targetHash = "";
        for(Message m : manager.storedMessages) {
            if(m.getMessageText().contains("Where are you")) {
                targetHash = m.getMessageHash();
            }
        }
        
        String response = manager.deleteMessageByHash(targetHash);
        assertTrue(response.contains("successfully deleted"));
    }
}  
}
