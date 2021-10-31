package br.com.softblue.jogoforca.game;

import br.com.softblue.jogoforca.core.Dictionary;
import br.com.softblue.jogoforca.core.Word;

public class Game {
    public void start() {
        Dictionary dictionary = Dictionary.getInstance();
        System.out.println(dictionary);

        Word word = dictionary.netWord();
        System.out.println(word.getOriginalWord());
    }
}
