package com.vulpes.gemini;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by matt on 5/6/17.
 */
public class Deck {
    private Stack<Card> cards;

    private Card militiaman = new Unit("militiaman", 0, 2, 1, 1);
    private Card shopkeeper = new Unit("shopkeeper", 0, 1, 2, 1);
    private Card scribe = new Unit("scribe", 0, 1, 1, 2);

    // Initialize a default deck.
    public Deck(){
        cards = new Stack<>();
        int numBasics = 3;
        for(int i=0; i<numBasics; i++){
            cards.push(militiaman);
            cards.push(shopkeeper);
            cards.push(scribe);
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card draw(){
        return cards.pop();
    }

    public boolean isEmpty(){
        return cards.isEmpty();
    }

    public boolean hasMore(){
        return !cards.isEmpty();
    }

    public void addCards(List<Card> newCards){
        for(Card card : newCards){
            cards.push(card);
        }
    }
}
