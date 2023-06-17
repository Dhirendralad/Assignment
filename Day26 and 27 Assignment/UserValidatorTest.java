package org.example;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserValidatorTest {

    @Test
    public void testValidateFirstName_Correct() {
        String firstName = "John";
        try {
            UserValidator.validateFirstName(firstName);
            Assert.assertTrue(true);
        } catch (InvalidUserDetailsException e) {
            Assert.fail("Should not throw an exception");
        }
    }

    @Test
    public void testValidateFirstName_Incorrect() {
        String firstName = "j0on";
        try {
            UserValidator.validateFirstName(firstName);
            Assert.fail("Should throw an exception");
        } catch (InvalidUserDetailsException e) {
            assertEquals("Invalid first name: " + firstName, e.getMessage());
        }
    }

    @Test
    public void testValidateLastName_Correct() {
        String lastName = "Doe";
        try {
            UserValidator.validateLastName(lastName);
            Assert.assertTrue (true);
        } catch (InvalidUserDetailsException e) {
            Assert.fail("Should not throw exception");
        }
    }

    @Test
    public void testValidateLastName_Incorrect() {
        String lastName = "do3";
        try {
            UserValidator.validateLastName(lastName);
            Assert.fail("Should throw an exception");
        } catch (InvalidUserDetailsException e) {
            assertEquals("Invalid last name: " + lastName, e.getMessage());
        }
    }

    @Test
    public void testValidateEmail_Correct() {
        String email = "abc.xyz@bl.co.in";
        try{
            UserValidator.validateEmail(email);
            Assert.assertTrue(true);
        } catch (InvalidUserDetailsException e) {
            Assert.fail("Should not throw an exception");
        }
    }

    @Test
    public void testValidateEmail_Incorrect() {
        String email = "abc.xyz@bl@co.in";
        try{
            UserValidator.validateEmail(email);
            Assert.fail("Should throw an exception");
        } catch (InvalidUserDetailsException e) {
            assertEquals("Invalid email: " + email,  e.getMessage());
        }
    }

    @Test
    public void testValidateMobileNumber_Correct() {
        String mobileNumber = "91 9919819801";
        try{
            UserValidator.validateMobileNumber(mobileNumber);
            Assert.assertTrue(true);
        } catch (InvalidUserDetailsException e) {
            Assert.fail("Should not throw an exception");
        }
    }

    @Test
    public void testValidateMobileNumber_Incorrect() {
        String mobileNumber = "9919819801";
        try {
            UserValidator.validateMobileNumber(mobileNumber);
            Assert.fail("Should throw an exception");
        } catch (InvalidUserDetailsException e) {
            assertEquals("Invalid mobile number: " + mobileNumber, e.getMessage());
        }
    }

    @Test
    public void testValidatePassword_Correct() {
        String password = "Pass@123";
        try {
            UserValidator.validatePassword(password);
            Assert.assertTrue(true);
        } catch (InvalidUserDetailsException e) {
            Assert.fail("Should not throw an exception");
        }
    }

    @Test
    public void testValidatePassword_Incorrect() {
        String password = "pass123";
        try {
            UserValidator.validatePassword(password);
            Assert.fail("Should throw an exception");
        } catch (InvalidUserDetailsException e) {
            assertEquals("Invalid password", e.getMessage());
        }
    }
}


