package com.javarush.sabitov.commands;

import com.javarush.sabitov.Result;

public interface Action {
    Result execute(String[] parameters);
}
