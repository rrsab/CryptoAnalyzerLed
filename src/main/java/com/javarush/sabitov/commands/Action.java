package com.javarush.sabitov.commands;

import com.javarush.sabitov.constants.Alphabet;
import com.javarush.sabitov.constants.Const;
import com.javarush.sabitov.entity.ResultCode;
import com.javarush.sabitov.exceptions.AppException;
import com.javarush.sabitov.util.PathBuilder;
import com.javarush.sabitov.entity.Result;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public interface Action {
    Alphabet alphabet = new Alphabet();

    Result execute(String[] parameters);

    default Result createNewFileWithKey(String sourceTextFile, String targetTextFile, int key) {
        Path source = PathBuilder.get(sourceTextFile);
        Path target = PathBuilder.get(targetTextFile);
        try (
                BufferedReader reader = Files.newBufferedReader(source);
                BufferedWriter writer = Files.newBufferedWriter(target)
        ) {
            int value;
            int length = alphabet.ALPHABET.length;
            while ((value = reader.read()) > -1) {
                char character = (char) value;
                character = Character.toLowerCase(character);
                if (Alphabet.index.containsKey(character)) {
                    Integer index = Alphabet.index.get(character);
                    index = (index + key + Math.abs(key) * length) % length;
                    writer.write(Alphabet.ALPHABET[index]);
                } else if (character == '\n') {
                    writer.write(character);
                }
            }
        } catch (IOException e) {
            throw new AppException(Const.INCORRECT_FILE + e.getMessage(), e);
        }
        return new Result(ResultCode.OK, targetTextFile);
    }
}
