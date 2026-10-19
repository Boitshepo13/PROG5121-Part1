/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class testpackgages {
    package quickchat;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MessageTest {

    @Test
    public void testMessageLengthSuccess() {
        String msgText = "Hi Mike, can you join us for dinner tonight?";
        assertTrue(msgText.length() <= 250, "Message ready to send.");
    }

    @Test
    public void testMessageLengthFailure() {
        String longMsg = "A".repeat(260); 
        assertTrue(longMsg.length() > 250, "Message exceeds 250 characters by 10; please reduce the size.");
    }

    @Test
    public void testRecipientCellSuccess() {
        Message msg = new Message(1, "+27718693002", "Test");
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCell());
    }

    @Test
    public void testRecipientCellFailure() {
        Message msg = new Message(1, "08575975889", "Test"); 
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", msg.checkRecipientCell());
    }

    @Test
    public void testMessageHash() {
        Message msg = new Message(0, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        String hash = msg.getMessageHash();
        assertTrue(hash.endsWith(":HITHANKS"), "Hash should end with :HITHANKS");
    }

    @Test
    public void testMessageIDCreation() {
        Message msg = new Message(1, "+27718693002", "Test");
        assertTrue(msg.checkMessageID(), "Message ID generated: " + msg.getMessageID());
        assertEquals(10, msg.getMessageID().length());
    }

    @Test
    public void testSentMessageAction() {
        Message msg = new Message(1, "+27718693002", "Test");
        assertEquals("Message successfully sent.", msg.SentMessage(1));
        assertEquals("Press 0 to delete the message.", msg.SentMessage(2));
        assertEquals("Message successfully stored.", msg.SentMessage(3));
    }
}
}
