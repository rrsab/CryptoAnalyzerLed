package com.javarush.sabitov.commands;

import com.javarush.sabitov.entity.Result;

public class Decoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        String encryptedFile = parameters[0];
        String decryptedTextFile = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        return createNewFileWithKey(encryptedFile, decryptedTextFile, -1 * key);
    }
}
