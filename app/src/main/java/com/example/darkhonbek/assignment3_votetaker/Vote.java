package com.example.darkhonbek.assignment3_votetaker;

import android.util.Log;

public class Vote {
    private String name;
    private String lastname;
    private Boolean isComing;
    private String drink;
    private String food;

    public Vote(String name,
                String surname,
                Boolean isComing,
                String drink,
                String food) {
        this.name = name;
        this.lastname = surname;
        this.isComing = isComing;
        this.drink = drink;
        this.food = food;
    }

    public String toString() {
        String result = "-> " + name + " " + lastname ;

        if (isComing) {
            result += " will go to the party and will drink " + drink + " and eat " + food + ".";
        } else {
            result += " will not go to the party.";
        }

        return result;
    }

    public String toFile() {
        String vote = "";
        vote += name + ":";
        vote += lastname + ":";
        if(isComing == false) {
            vote += "false: : :";
        } else {
            vote += "true:";
            vote += drink + ":";
            vote += food + ":";
        }

        return vote;
    }

    public static Vote getVoteFromString(String vote) {
        String name;
        String lastname;
        String isComingString;
        Boolean isComing;
        String drink;
        String food;

        String[] elements = vote.split(":");
        int numberOfElements = elements.length;

        if (numberOfElements == 5) {
            name = elements[0];
            lastname = elements[1];
            isComingString = elements[2];
            drink = elements[3];
            food = elements[4];

            if(isComingString.contains("true")) {
                isComing = true;
            } else {
                isComing = false;
            }

        } else {
            return null;
        }

        Vote voteObject = new Vote(name, lastname, isComing, drink, food);

        return voteObject;
    }
}
