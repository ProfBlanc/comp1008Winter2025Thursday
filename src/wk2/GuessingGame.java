package wk2;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numberToGuess = new Random().nextInt(1, 20);
        int numberOfGuesses = 0;
        int whatNumberUserGuessed = 0;

        do{
            numberOfGuesses++;
            if(numberOfGuesses == 5)
                System.out.println("Half of the number to guess is " + numberToGuess / 2);

            System.out.println("Guess a number between 1 and 20");
            whatNumberUserGuessed = sc.nextInt();

            if(whatNumberUserGuessed == numberToGuess){
                System.out.println("Congrats, you won!");
            }
            else{
                if(whatNumberUserGuessed > numberToGuess)
                    System.out.println("The number is lower than " + whatNumberUserGuessed);
                else
                    System.out.println("The number is higher than " + whatNumberUserGuessed);
            }

        }
        while(numberOfGuesses < 5 && whatNumberUserGuessed != numberToGuess);

    }
}
