package br.com.softblue.jogoforca.core;

import java.util.List;

public class StaticDictionary extends Dictionary {

    private final List<String> words = List.of(
            "casa", "computador", "caneta", "carro"
    );
    private int currentIndex = -1;

    @Override
    public Word netWord() {
        currentIndex = (currentIndex + 1) % words.size();
        return new Word(words.get(currentIndex));

    }

    @Override
    public String getName() {
        return "Estático";
    }
}
