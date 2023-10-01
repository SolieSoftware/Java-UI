package com.codebind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterFormTest {

    @Test
    void checkEmptyFields() {
        RegisterForm.username.setText("");
        assertEquals(RegisterForm.checkEmptyFields(), false);
    }

    @Test
    void checkUsernameExists() {
    }

    @Test
    void addRecord() {
    }
}