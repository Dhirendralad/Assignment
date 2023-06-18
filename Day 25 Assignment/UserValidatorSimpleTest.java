package org.example;

import org.junit.Assert;
import org.junit.Test;

public class UserValidatorSimpleTest {

    @Test
    public void testValidFirstName_Happy() {
        String firstName = "John";
        boolean result = UserValidatorSimple.validFirstName(firstName);
        Assert.assertTrue(result);
    }

    @Test
    public void testValidFirstName_Sad() {
        String firstName = "j";
        boolean result = UserValidatorSimple.validFirstName(firstName);
        Assert.assertFalse(result);
    }

    @Test
    public void testValidLastName_Happy() {
        String lastName = "Doe";
        boolean result = UserValidatorSimple.validLastName(lastName);
        Assert.assertTrue(result);
    }

    @Test
    public void testValidLastName_Sad() {
        String lastName = "d";
        boolean result = UserValidatorSimple.validLastName(lastName);
        Assert.assertFalse(result);
    }

    @Test
    public void testValidEmail_Happy() {
        String email = "abc.xyz@bl.co.in";
        boolean result = UserValidatorSimple.validEmail(email);
        Assert.assertTrue(result);
    }

    @Test
    public void testValidEmail_Sad() {
        String email = "abc.xyz@bl@co.in";
        boolean result = UserValidatorSimple.validEmail(email);
        Assert.assertFalse(result);
    }

    @Test
    public void testValidMobileNumber_Happy() {
        String mobileNumber = "91 9919819801";
        boolean result = UserValidatorSimple.validMobileNumber(mobileNumber);
        Assert.assertTrue(result);
    }

    @Test
    public void testValidMobileNumber_Sad() {
        String mobileNumber = "9919819801";
        boolean result = UserValidatorSimple.validMobileNumber(mobileNumber);
        Assert.assertFalse(result);
    }

    @Test
    public void testValidPassword_Happy() {
        String password = "Pass@123";
        boolean result = UserValidatorSimple.validPassword(password);
        Assert.assertTrue(result);
    }

    @Test
    public void testValidPassword_Sad() {
        String password = "pass123";
        boolean result = UserValidatorSimple.validPassword(password);
        Assert.assertFalse(result);
    }
}

