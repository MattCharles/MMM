package com.vulpes.gemini;

/**
 * Created by matt on 5/6/17.
 */
public class Card {
    protected String name;
    protected int cost;

    public Card(){
        //for extension
    }

    public Card(String name, int cost){
        this.name = name;
        this.cost = cost;
    }

    public String getName(){
        return this.name;
    }

    public int getCost(){
        return this.cost;
    }
}
