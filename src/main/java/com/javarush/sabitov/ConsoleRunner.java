package com.javarush.sabitov;

public class ConsoleRunner {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Application application = new Application();
        Result result = application.run(args);
        System.out.println(result);
    }
}
