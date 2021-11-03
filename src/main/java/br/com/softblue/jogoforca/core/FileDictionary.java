package br.com.softblue.jogoforca.core;


import br.com.softblue.jogoforca.game.GameException;
import br.com.softblue.jogoforca.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FileDictionary extends Dictionary {

    private static final String FILE_NAME = "dicionario.txt";
    private final List<String> words = new ArrayList<>();

    public FileDictionary() {
        load();
    }

    private void load() {
        try (Scanner scanner =
                     new Scanner(Objects.requireNonNull(getClass().getResourceAsStream("/" + FILE_NAME)))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                words.add(word);

            }
            if (words.size() == 0) {
                throw new GameException("A lista de palavras não pode ser vazia");
            }
        }
    }

    @Override
    public Word netWord() {
        int pos = RandomUtils.newRandomNumber(0, words.size());
        return new Word(words.get(pos));
    }

    @Override
    public String getName() {
        return "Arquivo " + FILE_NAME;
    }
}
