package com.javarush.sabitov;

import com.javarush.sabitov.controllers.MainController;
import com.javarush.sabitov.view.ConsoleApplication;
import com.javarush.sabitov.view.Menu;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        MainController mainController = new MainController();
        ConsoleApplication consoleApplication = new ConsoleApplication(menu,mainController);
        consoleApplication.run(args);
    }
}
