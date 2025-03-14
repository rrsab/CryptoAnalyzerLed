package com.javarush.sabitov.commands;

import com.javarush.sabitov.entity.Result;

public class Encoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        String sourceTextFile = parameters[0];
        String encryptedFile = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        return createNewFileWithKey(sourceTextFile, encryptedFile, key);
    }
}
