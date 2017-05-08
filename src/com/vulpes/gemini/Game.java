package com.vulpes.gemini;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by matt on 5/6/17.
 */
public class Game {
    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 8;
    private static final int DEFAULT_NUM_PLAYERS = 2;
    private static final int DEFAULT_HAND_SIZE = 4;     //doesn't include peasant
    private List<Player> players;
    private int numPlayers;

    public static Card militiaman = new Unit("militiaman", 0, 2, 1, 1);
    public static Card shopkeeper = new Unit("shopkeeper", 0, 1, 2, 1);
    public static Card scribe = new Unit("scribe", 0, 1, 1, 2);

    //default players
    public Game(){
        this(DEFAULT_NUM_PLAYERS);
    }

    public Game(int numPlayers){
        if(numPlayers >= MIN_PLAYERS && numPlayers <= MAX_PLAYERS) {
            players = new ArrayList<>(numPlayers);
            for(int i = 0; i< numPlayers; i++){
                players.add(new Player());
            }
            this.numPlayers = numPlayers;
        } else {
            System.out.println("Ensure games have between " + MIN_PLAYERS + " and " + MAX_PLAYERS + " players.");
            System.exit(1);
        }
    }

    public void play() {
        Scanner reader = new Scanner(System.in);

        //welcome players.
        System.out.println("Welcome to Might, Money and Magic!");

        //Player Setup, Enter Game Loop
        startGame(reader, setupPlayers(reader));
    }

    public Player setupPlayers(Scanner reader) {
        System.out.println("Input player names. Make yourself player one and ensure everyone has the same player order.");
        boolean orderIsUndecided = true;
        List<Player> newOrder = new ArrayList<>(numPlayers);

        int newZero = 0;
        int newZeroInput;
        int newOrderIndex;
        Player thisGuy = null;

        while (orderIsUndecided) {
            for (int playerCounter = 0; playerCounter < numPlayers; playerCounter++) {
                this.players.get(playerCounter).setName(this.askName(reader, playerCounter + 1));
            }
            thisGuy = players.get(0);

            System.out.println("Who will go first?");
            for (int playerCounter2 = 0; playerCounter2 < numPlayers; playerCounter2++) {
                System.out.println((playerCounter2 + 1) + ") " + players.get(playerCounter2).getName());
            }
            do {
                System.out.println("Enter an integer between 1 and " + numPlayers + ".");
                newZeroInput = reader.nextInt();
            } while(newZeroInput < 0 || newZeroInput > numPlayers + 1);

            newZero = newZeroInput-1;
            newOrderIndex = newZero;

            System.out.println("So, the order will be:");
            do{
                newOrder.add(players.get(newOrderIndex));
                System.out.println(players.get(newOrderIndex).getName());
                newOrderIndex = (newOrderIndex + 1) % (numPlayers);
            } while(newOrderIndex!=Math.abs(newZero));


            System.out.println("Is that okay? (Y/N)");
            //TODO: maybe set up a method that accepts different affirmative inputs
            if (reader.next().equalsIgnoreCase("y")) {
                //exit loop
                orderIsUndecided = false;
            } else {
                System.out.println("\nOkay here we go again lmao.\n");
            }
        }
        players = newOrder;
        return thisGuy;
    }

    public String askName(Scanner reader, int playerNum){
        String answer;
        while(true) {
            System.out.println("What is player " + playerNum + "'s name?");
            answer = reader.next();

            //saving for 'options' feature maybe?
            //System.out.println("Is " + answer + " okay? (Y/N)");
            //if(reader.next().equalsIgnoreCase("y")){
            return answer;
            //}
        }
    }

    private void startGame(Scanner reader, Player thisGuy){
        //while(nobody win yet), put all this shit in a diff function prolly

        //draw tiles

        //start round; everyone draw cards
        thisGuy.draw(DEFAULT_HAND_SIZE);
        thisGuy.addPeasant();

        System.out.println("Your Hand:");
        thisGuy.printHand();

        //Action phase.
        for(Player dude: players){
            System.out.println(dude.getName());
            //if it's your turn, do a bunch of actions.
            if(dude.equals(thisGuy)){
                //thisGuy.doActions();
            } else {
                System.out.println("It's " + dude.getName() + "'s turn to do actions.");
                //display scores?
                System.out.println("Hit Enter when they're done.");
                reader.next();      //probably sloppy
            }
        }

        //Same as well for units
    }
}
