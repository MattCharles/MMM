package com.vulpes.gemini;

import java.util.Scanner;

public class Main {

    public interface optionSelector {
        public void execute();
    }

    //Options text
    private static String[] optionsList = new String[]{
            "New Game",
            "Exit"
    };

    //Functions called on selection of matching option text
    private static optionSelector[] functionsList = new optionSelector[]{
            () -> newGame(),
            () -> exitMenu()
    };

    public static void main(String[] args) {
	    //welcome
        while(true) {
            System.out.println("Welcome to MMM Helper!");
            displayMenu();
            parseInput();
        }
    }

    public static void displayMenu() {
        //Set up options map
        int numOptions = 0;
        while (numOptions < optionsList.length) {
            System.out.println((numOptions + 1) + ") " + optionsList[numOptions]);
            numOptions++;
        }
        System.out.println("Select an option...");
    }

    public static void parseInput(){
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

    public static void newGame(){
        System.out.println("TBD");
        //ask how many players
        Game game = new Game();
        game.play();
        System.exit(0);
    }

    public static void exitMenu(){
        System.out.println("Bye bye!");
        System.exit(0);
    }
}
