package com.codebind;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {


    @Test
    void main() {
        WindowListener listener = new WindowAdapter() {
            public void WindowOpened(WindowEvent evt) {
                Frame frame = (Frame) evt.getSource();
                assertEquals("Login", frame.getTitle());
            }
        };

    }
}