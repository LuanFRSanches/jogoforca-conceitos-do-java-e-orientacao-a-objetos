package br.com.softblue.jogoforca.core;


public abstract class Dictionary {


    private static Dictionary instance;


    public static Dictionary getInstance() {
        if (instance == null) {
            instance = new FileDictionary();
        }
        return instance;
    }


    public abstract Word netWord();

    public abstract String getName();
}
