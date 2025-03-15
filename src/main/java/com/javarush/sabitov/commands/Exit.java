package com.javarush.sabitov.commands;

import com.javarush.sabitov.constants.Const;
import com.javarush.sabitov.entity.Result;
import com.javarush.sabitov.entity.ResultCode;

public class Exit implements Action {

    @Override
    public Result execute(String[] parameters) {
        return new Result(ResultCode.OK, Const.APPLICATION_CLOSED);
    }
}
