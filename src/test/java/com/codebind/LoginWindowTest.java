package com.codebind;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import static org.junit.jupiter.api.Assertions.*;

class LoginWindowTest {

    LoginWindow lw = new LoginWindow();

    @Test
    void launchNavigator() {
        WindowListener listener = new WindowAdapter() {
            public void WindowOpened(WindowEvent evt) {
                Frame frame = (Frame) evt.getSource();
                assertEquals("Navigator", frame.getTitle());
            }
        };
    }

    @Test
    void isUsernameAndPasswordCorrect() {
        String correctUser = "Sol";
        char[] correctPassword = {'L', 'o', 's', 't', '!'};

        String incorrectUser = "Adam";
        char[] incorrectPassword = {'F', 'o', 'u', 'n', 'd'};

        assertEquals(lw.isUsernameAndPasswordCorrect(correctUser, correctPassword), true);

        assertEquals(lw.isUsernameAndPasswordCorrect(incorrectUser, incorrectPassword), false);

        assertEquals(lw.isUsernameAndPasswordCorrect(incorrectUser, correctPassword), false);

        assertEquals(lw.isUsernameAndPasswordCorrect(correctUser, incorrectPassword), false);


    }
}