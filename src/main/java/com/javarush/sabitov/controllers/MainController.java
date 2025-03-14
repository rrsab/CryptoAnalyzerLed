package com.javarush.sabitov.controllers;

import com.javarush.sabitov.constants.Const;
import com.javarush.sabitov.entity.Result;
import com.javarush.sabitov.commands.Action;
import com.javarush.sabitov.commands.Decoder;
import com.javarush.sabitov.commands.Encoder;
import com.javarush.sabitov.entity.ResultCode;
import com.javarush.sabitov.exceptions.AppException;

public class MainController {
    public Result doAction(String action, String[] parameters) {
        Action currentAction;
        currentAction = switch (action) {
            case Const.ENCODE -> new Encoder();
            case Const.DECODE -> new Decoder();
            default -> throw new IllegalStateException("Unexpected value: " + action);
        };
        try {
            return currentAction.execute(parameters);
        } catch (AppException e) {
            return new Result(ResultCode.ERROR, e.getMessage());
        }
    }
}
