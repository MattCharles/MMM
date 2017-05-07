package com.vulpes.gemini;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by matt on 5/6/17.
 */
public class Player {
    private Deck deck;
    private List<Card> discard;
    private List<Card> hand;
    private String name;
    private int influence;

    public Player() {
        this.deck = new Deck();
        this.influence = 0;
    }

    public void draw(){
        if(deck.hasMore()){
            hand.add(deck.draw());
        } else {
            deck.addCards(discard);
            discard.clear();
        }
    }

    public void draw(int numberOfCards){
        while(numberOfCards-->0) {
            draw();
        }
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getInfluence(){
        return this.influence;
    }

    public int addInfluence(int points){
        return this.influence+=points;
    }

    public void setInfluence(int points){
        this.influence = points;
    }

    public void printDiscard(){

    }

    public void printHand(){
        System.out.println(hand.stream().map(Object::toString).collect(Collectors.joining(", ")));
    }

    public void startingDraw(){

    }
}
