package com.example.darkhonbek.assignment3_votetaker;

public class Result {
    private String name;
    private String surname;
    private Boolean isComing;
    private String drink;
    private String food;

    public Result(String name,
                       String surname,
                       Boolean isComing,
                       String drink,
                       String food) {
        this.name = name;
        this.surname = surname;
        this.isComing = isComing;
        this.drink = drink;
        this.food = food;
    }

    public String toString() {
        String result = "-> " + name + " " + surname ;

        if (isComing) {
            result += " will go to the party and will drink " + drink + " and eat " + food + ".";
        } else {
            result += " will not go to the party.";
        }

        return result;
    }
}
