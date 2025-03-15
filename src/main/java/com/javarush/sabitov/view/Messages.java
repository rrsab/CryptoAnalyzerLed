package com.javarush.sabitov.view;

import com.javarush.sabitov.constants.Const;


public interface Messages {
    String[][][] QUESTIONS = new String[][][]{
            {
                    {Const.ENCODE},
                    {"Enter source (full path OR only filename, example text.txt ) :"},
                    {"Enter destination (full path OR only filename, example encrypted.txt) :"},
                    {"Enter key :"},
            },
            {
                    {Const.DECODE},
                    {"Enter source (full path OR only filename, example encrypted.txt) :"},
                    {"Enter destination (full path OR only filename, example decrypted.txt) :"},
                    {"Enter key :"},
            },
            {
                    {Const.EXIT},
            }
    };

    String ANSI_RESET = "\u001B[0m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_CYAN = "\u001B[36m";
    String ANSI_PURPLE = "\u001B[35m";
    String ANSI_GREEN = "\u001B[32m";

    String LINE = "-".repeat(20);
    String MESSAGE_SELECT_MODE = LINE +
            ANSI_BLUE + "\nPlease select mode:\n" + ANSI_CYAN + """
            1. Encrypt
            2. Decrypt
            3. Exit
            """ + ANSI_RESET + LINE;
    String INCORRECT_SELECTION = "Incorrect selection";
    String INCORRECT_INPUT = "Incorrect input - key can only be a number";

    String OK_FORMAT = ANSI_GREEN + """
                Operation complete
                Result: %s
            """ + ANSI_RESET;

    String ERR_FORMAT = ANSI_PURPLE + """
                ERROR
                Message: %s
            """ + ANSI_RESET;

}
