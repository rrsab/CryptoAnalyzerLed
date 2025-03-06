package com.javarush.sabitov.controllers;

import com.javarush.sabitov.Result;
import com.javarush.sabitov.commands.Action;
import com.javarush.sabitov.commands.Decoder;
import com.javarush.sabitov.commands.Encoder;

public class MainController {
    public Result doAction(String action, String[] parameters) {
        Action currentAction;
        currentAction = switch (action) {
                case "encode" -> new Encoder();
                case "decode" -> new Decoder();
            default -> throw new IllegalStateException("Unexpected value: " + action);
        };
        currentAction.execute(parameters);


        return null;
    }
}
