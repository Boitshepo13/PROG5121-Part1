# QuickChat Application

## 📌 Project Overview
QuickChat is a Java console-based messaging application developed as part of a programming task. It allows users to simulate sending, storing, and disregarding messages while validating user input, generating unique message IDs and hashes, and tracking the total number of messages sent.

This project uses **Java**, **Maven**, and **JUnit 5** for automated unit testing, and implements **GitHub Actions (CI/CD)** to automatically run tests on every push.

## ✨ Features
*   **User Authentication Simulation:** Displays a welcome message upon successful login.
*   **Menu System:** Allows users to navigate between sending messages, viewing "Coming Soon" features, or quitting the application.
*   **Message Validation:**
    *   Ensures message text does not exceed 250 characters.
    *   Validates recipient cell numbers to ensure they contain an international code (e.g., `+27`).
*   **Unique Identifiers:**
    *   Auto-generates a random 10-digit `Message ID`.
    *   Generates a custom `Message Hash` (e.g., `00:1:HITHANKS`) based on the ID, message number, and first/last words of the message.
*   **Action Options:** Users can choose to Send, Disregard, or Store the message.
*   **JSON Storage:** Simulates storing messages to a `messages.json` file for later retrieval.
*   **Automated Testing:** Includes comprehensive unit tests using JUnit 5 to verify logic and edge cases.

## 🛠️ Prerequisites
To run this project locally, you will need:
*   [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or higher.
*   [Apache NetBeans IDE](https://netbeans.apache.org/) (or any IDE that supports Maven, like IntelliJ or Eclipse).
*   [Git](https://git-scm.com/) installed on your machine.

## 🚀 How to Run the Application (NetBeans)
1. Open NetBeans and go to **File > Open Project**.
2. Navigate to the folder containing this project and open it.
3. In the Projects window, expand the `Source Packages` > `quickchat` folder.
4. Right-click on `QuickChat.java` and select **Run File** (or press `Shift + F6`).
5. Follow the on-screen prompts in the NetBeans Output console.

## 🧪 Running the Unit Tests
The project includes a `MessageTest.java` file containing JUnit 5 tests to ensure the application meets the required specifications.
1. In NetBeans, right-click on the `QuickChat` project folder.
2. Select **Test** (or press `Alt + F6`).
3. The console will show the test results. A green bar indicates all tests have passed successfully.

## 🔄 CI/CD Pipeline (GitHub Actions)
This project uses GitHub Actions to implement Continuous Integration. 
Every time code is pushed to the `main` or `master` branch, the `.github/workflows/maven.yml` file triggers a virtual machine to:
1. Check out the code.
2. Set up Java JDK 17.
3. Run `mvn clean test` to automatically compile the code and run the JUnit tests.
4. If any test fails, the Action will flag an error, preventing broken code from being merged.

## 📂 Project Structure
```text
QuickChat/
├── .github/
│   └── workflows/
│       └── maven.yml          # GitHub Actions CI/CD configuration
├── src/
│   ├── main/
│   │   └── java/
│   │       └── quickchat/
│   │           ├── Message.java     # Core logic, validation, and data management
│   │           └── QuickChat.java   # Main application class, UI, and menu loop
│   └── test/
│       └── java/
│           └── quickchat/
│               └── MessageTest.java # JUnit 5 Unit Tests
├── pom.xml                    # Maven dependencies (JUnit)
└── README.md                  # Project documentation