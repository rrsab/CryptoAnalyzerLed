package com.javarush.sabitov.view;

import java.util.Scanner;


import static com.javarush.sabitov.view.Messages.*;

public class Menu {
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getArgs() {
        String action = getAction();
        int actionIndex=0;
        for (int i = 0; i < QUESTIONS.length; i++) {
            if ((QUESTIONS[i][0][0]).equals(action)) {
                actionIndex=i;
                break;
            }
        }
        String[] args= new String[QUESTIONS[actionIndex].length];
        args[0]=action;
        for (int i = 1; i < args.length; i++) {
            String quest = QUESTIONS[actionIndex][i][0];
            System.out.println(quest);
            String answer = scanner.nextLine();
            args[i] = answer;
        }
        return args;
    }

    private String getAction() {
        String action = "";
        while (action.equals("")) {
            System.out.println(MESSAGE_SELECT_MODE);
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> action = "encrypt";
                case "2" -> action = "decrypt";
                case "3" -> action = "exit";
                default -> {
                    action = "";
                    System.out.println(INCORRECT_SELECTION);
                }
            }

        }
        return action;
    }

}
