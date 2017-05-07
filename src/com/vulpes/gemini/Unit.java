package com.vulpes.gemini;

/**
 * Created by matt on 5/6/17.
 *
 * TODO: stats object instead of raw cost/might/money/magic
 * TODO: maybe use builder pattern?
 */
public class Unit extends Card {
    private int cost, might, money, magic;
    private String name, text, tribe;
    public Unit(){

    }

    public Unit(String name, int cost){
        //bare minimum constructor if we don't handle combat in app
    }

    public Unit(String name, int cost, int might, int money, int magic){
        //default for vanilla units
    }

    public Unit(String name, int cost, int might, int money, int magic, String text, String tribe){

    }
}