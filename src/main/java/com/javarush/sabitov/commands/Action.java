package com.javarush.sabitov.commands;

import com.javarush.khmelov.constant.Alphabet;
import com.javarush.khmelov.constant.Const;
import com.javarush.khmelov.entity.ResultCode;
import com.javarush.khmelov.exception.AppException;
import com.javarush.khmelov.util.PathBuilder;
import com.javarush.sabitov.Result;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public interface Action {
    Result execute(String[] parameters);
    default Result createWithKey(String sourceTextFile, String targetTextFile, int key) {
        Path source = PathBuilder.get(sourceTextFile);
        Path target = PathBuilder.get(targetTextFile);
        try (
                BufferedReader reader = Files.newBufferedReader(source);
                BufferedWriter writer = Files.newBufferedWriter(target)
        ) {
            int value;
            int length = Alphabet.chars.length;
            while ((value = reader.read()) > -1) {
                char character = (char) value;
                character = Character.toLowerCase(character);
                if (Alphabet.index.containsKey(character)) {
                    Integer index = Alphabet.index.get(character);
                    index = (index + key + Math.abs(key) * length) % length;
                    writer.write(Alphabet.chars[index]);
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
