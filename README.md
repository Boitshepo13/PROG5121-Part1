# PROG5121-Part1
# PROG5121 - POE Part 1 - User Registration & Login System

## Project Description
This is a Java application developed in NetBeans that allows a user to create an account and login. The system validates username, password complexity, and South African cell phone number using regex and provides appropriate success/failure messages as per the IIE brief.

## Features
1.  Create account with username, password, cell number
2.  Validate username: must contain `_` and be <= 5 characters
3.  Validate password: >= 8 chars, 1 capital, 1 number, 1 special char
4.  Validate cell number: must contain international code +27 and 9 digits
5.  Login with same username and password
6.  Return welcome message if login successful

## Class Structure

### Login Class - `com.mycompany.login.Login`
Contains 6 main methods required by the brief:

| Method | Functionality |
|--------|---------------|
| `checkUserName()` | Ensures username contains underscore and <=5 chars |
| `checkPasswordComplexity()` | Ensures password meets complexity rules |
| `checkCellPhoneNumber()` | Ensures cell has +27 and correct length |
| `registerUser()` | Returns registration messages (success/fail) |
| `loginUser()` | Verifies login details match stored details |
| `returnLoginStatus()` | Returns welcome or failed login message |

## Validation Rules & Messages

**Username:**
- True: `Username successfully captured.`
- False: `Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.`

**Password:**
- True: `Password successfully captured.`
- False: `Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.`

**Cell Phone:**
- True: `Cell phone number successfully added.`
- False: `Cell phone number incorrectly formatted or does not contain international code.`

**Login:**
- True: `Welcome <first name>, <last name> it is great to see you again.`
- False: `Username or password incorrect, please try again.`

## How To Run

### Requirements
- NetBeans IDE 18+
- Java JDK 17+
- JUnit 5

### Steps
1. Open NetBeans > New Project > Java with Maven > Java Application
2. Package name: `com.mycompany.login`
3. Create class `Login.java` and paste code
4. Right-click Test Packages > New > JUnit Test > `LoginTest.java`
5. Right-click Project > Test
6. All tests should be GREEN

## Unit Tests - Test Data Used (as per brief)

| Test | Test Data | Expected Return |
|------|-----------|-----------------|
| Username Correct | `kyl_1` | True |
| Username Incorrect | `kyle!!!!!!!` | False + error message |
| Password Correct | `Ch&sec@ke99!` | True |
| Password Incorrect | `password` | False + error message |
| Cell Correct | `+27838968976` | True |
| Cell Incorrect | `08966553` | False + error message |
| Login Success | `kyl_1` / `Ch&sec@ke99!` | True |
| Login Failed | `kyl_1` / `wrong` | False |

## Regex Reference
Cell phone validation regex adapted from:
StackOverflow - South African Phone Number Regex
https://stackoverflow.com/questions/11518035/regex-for-south-african-phone-number

Regex used: `^\+27[0-9]{9}$` - checks for +27 followed by 9 digits.

## Author
Student Name: [Your Name]
Student Number: [Your Number]
Module: PROG5121 - 2026

## Video Link
[Add your YouTube unlisted link for Part 3 here]
