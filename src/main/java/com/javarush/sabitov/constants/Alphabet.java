package com.javarush.sabitov.constants;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', '☮', '”','’','-', '\n'};


    public final static Map<Character, Integer> index = new HashMap<>();

    static {
        for (int i = 0; i < ALPHABET.length; i++) {
            index.put(ALPHABET[i], i);
        }
    }


}
