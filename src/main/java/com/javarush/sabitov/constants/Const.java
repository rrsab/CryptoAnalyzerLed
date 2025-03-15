package com.javarush.sabitov.constants;

import java.io.File;

public interface Const {
    String ENCODE = "encrypt";
    String DECODE = "decrypt";
    String EXIT = "exit";


    String TXT_FOLDER = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator;

    String INCORRECT_FILE = "Incorrect file: ";
    String APPLICATION_CLOSED = "application closed";
}