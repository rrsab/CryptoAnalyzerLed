package com.javarush.sabitov.constants;

import java.io.File;

public interface Const {
    String ENCODE = "encrypt";
    String DECODE = "decrypt";


    String TXT_FOLDER = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator;

    String NOT_FOUND_ACTION_FORMAT = "not found action: %s";
    String INCORRECT_FILE = "Incorrect file: ";
    String INCORRECT_INPUT = "Incorrect args!";
    String APPLICATION_CLOSED = "application closed";
}