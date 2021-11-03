package br.com.softblue.jogoforca.game;

import br.com.softblue.jogoforca.core.Config;
import br.com.softblue.jogoforca.core.Dictionary;
import br.com.softblue.jogoforca.core.InvalidCharacterException;
import br.com.softblue.jogoforca.core.Word;
import br.com.softblue.jogoforca.ui.UI;

import java.util.HashSet;
import java.util.Set;

public class Game {

    public void start(String[] args) {

        Set<Character> useChars = new HashSet<>();
        int errorCount = 0;
        if (args.length > 0) {
            Config.setMaxErrors(args[0]);
        }

        int maxErros = Integer.parseInt(Config.get("maxErrors"));
        UI.print("Você pode errar no máximo " + maxErros + " vez(es)");
        UI.print("Bem vindo ao jogo da Forca!");

        Dictionary dictionary = Dictionary.getInstance();
        Word word = dictionary.netWord();

        UI.print("A palavra tem " + word.size() + " letras");


        while (true) {
            UI.print(word);
            UI.printNewLine();

            char c;
            try {
                c = UI.readChar("Digite uma letra: ");
                if (useChars.contains(c)) {
                    throw new InvalidCharacterException("Esta letra já foi utilizada");
                }
                useChars.add(c);

                if (word.hasChar(c)) {

                    UI.print("Você acertou uma letra!");

                } else {

                    errorCount++;
                    if (errorCount < maxErros) {
                        UI.print(maxErros);

                    }
                }
                UI.printNewLine();

                if (word.discovered()) {

                    UI.print("PARABÉNS! Você acertou a palavra correta: " + word.getOriginalWord());
                    UI.print("Fim do jogo!");
                    break;

                }

                if (errorCount == maxErros) {

                    UI.print("Você perdeu o jogo! A palavra correta era: " + word.getOriginalWord());
                    UI.print("Fim do jogo!");
                    break;
                }


            } catch (InvalidCharacterException e) {
                UI.print("Erro: " + e.getMessage());
                UI.printNewLine();
            }
        }
    }

}