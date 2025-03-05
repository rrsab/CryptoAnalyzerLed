package com.javarush.sabitov;

import com.javarush.sabitov.controllers.MainController;
import com.javarush.sabitov.exceptions.AppException;

import java.util.Arrays;

public class Application {
    private final MainController mainController;

    public Application() {
        mainController = new MainController();
    }

    public Result run(String[] args) {
        if (args.length>0){
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            mainController.doAction(action,parameters);
        }
        throw new AppException();
    }
}
