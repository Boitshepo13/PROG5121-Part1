===========================================================
PROJECT: Part 3 - Store Data and Display Task Report
STUDENT NAME: ST1092507
STUDENT NUMBER: BOITSHEPOMATLALA
DATE: 19/11/2026
===========================================================

1. PROJECT DESCRIPTION
-----------------------------------------------------------
This application is the final part of the messaging system project. 
It includes features to handle and manipulate strings, create and 
work with arrays, read data from a JSON file, and perform unit tests. 

The application allows users to:
- Populate arrays (Sent, Disregarded, Stored) without hard-coding.
- Read stored messages from a JSON file into an array.
- Use a main menu with a new option for "Stored Messages".
- Perform actions on stored messages such as: 
  * Display sender and recipient.
  * Find the longest message.
  * Search by Message ID.
  * Search by Recipient.
  * Delete a message using a Message Hash.
  * Display a full report of sent messages.

2. PROJECT STRUCTURE
-----------------------------------------------------------
The project is organized into the following folders:

/src
  - Main.java             : The entry point of the program. Contains the main menu.
  - Message.java          : The object class representing a single message.
  - MessageManager.java   : The logic class containing arrays and methods for 
                            handling messages, searches, and reports.

/test
  - MessageManagerTest.java : Contains the JUnit unit tests to verify the 
                              functionality of the application.

/data
  - stored_messages.json  : The JSON file containing stored message data.

/screenshots
  - Contains images proving the unit tests passed and the application 
    functions correctly (menu, longest message, delete, report).

3. HOW TO RUN THE APPLICATION
-----------------------------------------------------------
Prerequisites: 
- Java Development Kit (JDK) installed.
- An IDE (IntelliJ IDEA, Eclipse, or NetBeans) is recommended.

Steps:
1. Open the project folder in your IDE.
2. Ensure the /src and /test folders are marked as Source and Test roots.
3. Run the Main.java file to start the application.
4. Follow the on-screen menu prompts to interact with the system.

4. HOW TO RUN THE UNIT TESTS
-----------------------------------------------------------
1. Open the MessageManagerTest.java file.
2. Right-click anywhere in the code and select "Run 'MessageManagerTest'".
3. Verify that all tests (Sent Messages populated, Longest Message, 
   Search ID, Search Recipient, Delete Hash) pass successfully.

5. TEST DATA USED
-----------------------------------------------------------
The application uses the following test data provided in the assignment:
- Test Data 1: +27834557896 | "Did you get the cake?" | Sent
- Test Data 2: +27838884567 | "Where are you? You are late!..." | Stored
- Test Data 3: +27834484567 | "Yohoooo, I am at your gate." | Disregard
- Test Data 4: 0838884567   | "It is dinner time !" | Sent
- Test Data 5: +27838884567 | "Ok, I am leaving without you." | Stored

6. NOTES
-----------------------------------------------------------
- The Message IDs and Hashes are generated automatically by the system.
- The JSON file is loaded to simulate stored messages as required.
- No hard-coding of arrays was used; all data is populated via the 
  Message objects.

===========================================================
END OF README
===========================================================
