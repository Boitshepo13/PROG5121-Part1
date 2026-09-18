/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class Login {
    // stored user details
    String firstName;
    String lastName;
    String username;
    String password;
    String cellNumber;

    // check username has _ and 5 or less chars
    public boolean checkUserName(String username) {
        if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    // check password rules
    public boolean checkPasswordComplexity(String password) {
        boolean hasLength = password.length() >= 8;
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        // loop through each character
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                hasCapital = true; // capital found
            }
            if (c >= '0' && c <= '9') {
                hasNumber = true; // number found
            }
            if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true; // special char found
            }
        }

        if (hasLength && hasCapital && hasNumber && hasSpecial) {
            return true;
        } else {
            return false;
        }
    }

    // check cell has +27 and correct length
    public boolean checkCellPhoneNumber(String cell) {
        if (cell.startsWith("+27") && cell.length() == 12) {
            if (cell.matches("\\+27[0-9]{9}")) { // regex for +27 + 9 digits
                return true;
            }
        }
        return false;
    }

    // register user and return message
    public String registerUser(String username, String password, String cell) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cell)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        // save if all correct
        this.username = username;
        this.password = password;
        this.cellNumber = cell;

        return "Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.";
    }

    // check if login matches saved details
    public boolean loginUser(String enteredUser, String enteredPass) {
        if (enteredUser.equals(this.username) && enteredPass.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }

    // return login message
    public String returnLoginStatus(String enteredUser, String enteredPass, String firstName, String lastName) {
        if (loginUser(enteredUser, enteredPass)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}

   