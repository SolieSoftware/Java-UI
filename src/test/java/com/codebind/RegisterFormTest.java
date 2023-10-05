package com.codebind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterFormTest {
    RegisterForm rf = new RegisterForm();
    @Test
    void checkEmptyFields() {
        rf.username.setText("");
        rf.password.setText("");
        rf.email.setText("");
        assertEquals(rf.checkEmptyFields(), false);
        rf.username.setText("Sol");
        assertEquals(rf.checkEmptyFields(), false);
        rf.password.setText("hello!");
        rf.email.setText("sol.shortland@gmail.com");
        assertEquals(rf.checkEmptyFields(), true);
        rf.username.setText("");
        rf.password.setText("");
        rf.email.setText("");



    }

    @Test
    void checkUsernameExists() {
        assertEquals(rf.checkUsernameExists("Sol"), false);
        assertEquals(rf.checkUsernameExists("Ahsoke Tano"), true);
    }

    @Test
    void addRecord() {

    }
}