package com.javarush.sabitov.view;

import com.javarush.sabitov.entity.ResultCode;
import com.javarush.sabitov.controllers.MainController;
import com.javarush.sabitov.entity.Result;

import java.util.Arrays;

public class ConsoleApplication {
    private final Menu menu;
    private final MainController mainController;

    public ConsoleApplication(Menu menu, MainController mainController) {
        this.menu = menu;
        this.mainController=mainController;
    }

    public void run(String[] args) {
        Result result;
        do {
            if (args.length == 0) {
                args = menu.getArgs();
            }
            result = getResult(args);
            print(result);
            args = new String[0];
        } while (result.resultCode == ResultCode.ERROR);
    }

    private void print(Result result) {
        String message = switch (result.resultCode) {
            case OK -> String.format(
                    Messages.OK_FORMAT, result.message
            );
            case ERROR -> String.format(
                    Messages.ERR_FORMAT, result.message
            );
        };
        System.out.println(message);
    }

    private Result getResult(String[] args) {
        String action = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);
        return mainController.doAction(action, parameters);
    }
}
