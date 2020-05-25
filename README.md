# Monopoly

### Summary

Monopoly is a game that built with Java. It gets the number of players as an input from the user and initialises the board and the players. 

Then, the system runs for 20 rounds, which prints all the events happened and stops. 

The board has 40 square and the fules are as the following:

- If a player lands on a Rail Road, Utility, or Lot square, the player will attempt to purchase the square. If they successfully purchase a square, other players have to pay the rent to the owner when they land on that square.
- If a player lands on the Go to Jail square, the player has to move to the Jail square.
- If a player lands on the IncomeTax square, the player has to pay 10% of their net worth (or $200 at maximum) as tax.
- If a player lands on the Go square, the player gets $200 cash.
- If a player lands on the Jail or Regular squares, the system does nothing.

### Motivation

The purpose of this project was to get familiar with the GRASP principles and GoF Facade, Observer, and Decorator design patterns.

### Getting Started

Clone/download the repository on your local machine.
Run the MonopolyGame.java

### Features

1. LuckCards: The player will randomly draw 1 card from the card deck and if the card is:
- JailExcemptionCard: The player doesn't need to move to the Jail square
- PayJailFeeCard: The player pays $500 to exempt from Jail if it has sufficient money.
- GoToJailCard: The player moves to the Jail square

**Design pattern: use Facade pattern, Singleton, Polymorphism to ensure low impact on the GotoJailSquare class.**

2. Logging Player’s Assets: While the system is running, it records player's cash and owned properties in a txt file. 

That is, every time the player successfully purchases a square, the logger should automatically rewrite the whole file.

**Design pattern: use observer pattern to ensure the logging engine have low coupling with the current Monopoly system.**

