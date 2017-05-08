package com.vulpes.gemini;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

    private static String[] optionsList = new String[]{
            "Show hand",
            "Play a card"
    };

    private optionSelector[] functionsList = new optionSelector[]{
            () -> printHand(),
            () -> cardSelect()
    };

    public Player() {
        this.deck = new Deck();
        this.influence = 0;
        this.hand = new ArrayList<>();
        this.discard = new ArrayList<>();
    }


    public void draw(){
        if(deck.hasMore()){
            hand.add(deck.draw());
        } else {
            deck.addCards(discard);
            discard.clear();
            hand.add(deck.draw());
        }
    }

    public void draw(int numberOfCards){
        while(numberOfCards-->0) {
            draw();
        }
    }

    public void addPeasant(){
        hand.add(new Unit("Peasant", 0));
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
        for(Card card : this.hand){
            System.out.print(card.getName() + " ");
        }
    }

    public void startingDraw(){

    }

    public void showOptions(){
        System.out.println("");
    }

    //these two are the same as Main.cardSelect() - possible to reuse code?
    public void cardSelect(){
        //Set up options map
        int numOptions = 0;
        while (numOptions < optionsList.length) {
            System.out.println((numOptions + 1) + ") " + optionsList[numOptions]);
            numOptions++;
        }
        System.out.println("Select an option...");
    }

    public void parseInput(){
        //Get user input
        Scanner reader = new Scanner(System.in);
        int selectedOption = reader.nextInt();
        if(selectedOption > optionsList.length || selectedOption < 1) {
            System.out.println("Invalid option selected.");
            exitMenu();
        } else {
            functionsList[selectedOption-1].execute();
        }
    }

    public static void exitMenu(){
        System.out.println("Bye bye!");
        System.exit(0);
    }
}
