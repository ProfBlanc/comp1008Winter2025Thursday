package wk4;

import java.io.Console;
import java.util.ArrayList;
import java.util.Random;

public class WordGuessingGame {

    private String[] easyWords = {"Hello", "Cool", "Boo"};
    private String[] mediumWords = {"Goodbye", "Lovely", "Awesome"};
    private String[] hardWords = {"Incredible", "Wonderful", "Stupendous"};
    private String wordToGuess;
    private String whatWordDidUserGuess;

    private enum Level {EASY, MEDIUM, HARD};
    private Level currentLevel;
    private Random rand = new Random();
    private Console console = System.console();


    private char[] lettersToDisplayToUser;

    private int numberOfUserGuesses = 1;
    private int maxNumberOfGuessesGivenLevelChosen;
    private boolean wordGuessedByUser;

    public WordGuessingGame(String level) {
        setUpGame(level);
        play();
    }
    private void setUpGame(String level){
        level = level.strip().toUpperCase();
        currentLevel = Level.valueOf(level); // could throw an exception

        if(currentLevel == Level.EASY) {
            maxNumberOfGuessesGivenLevelChosen = 10;
            wordToGuess = easyWords[rand.nextInt(easyWords.length)];
        }
        else if(currentLevel == Level.MEDIUM) {
            maxNumberOfGuessesGivenLevelChosen = 5;
            wordToGuess = mediumWords[rand.nextInt(mediumWords.length)];
        }
        else if(currentLevel == Level.HARD) {
            maxNumberOfGuessesGivenLevelChosen = 3;
            wordToGuess = hardWords[rand.nextInt(hardWords.length)];
        }

        lettersToDisplayToUser = new char[wordToGuess.length()];

    }

    void displayDashesOfWord(){
        for(int i = 0; i < wordToGuess.length(); i++){


            if(lettersToDisplayToUser[i] == 0){

                System.out.print("____");
            }
            else{
                System.out.print(" " + lettersToDisplayToUser[i] + "  ");
            }
            System.out.print('\t');

        }
        System.out.println();

    }
    private void didUserGuessLetterOrWord(){


        int length = whatWordDidUserGuess.length();
        if (length == 1) {
            //then the user guessed a letter

            if(wordToGuess.toUpperCase().contains(whatWordDidUserGuess.toUpperCase())){

                char letter = whatWordDidUserGuess.toUpperCase().charAt(0);
                for(int i = 0; i < wordToGuess.toUpperCase().length(); i++){
                    if( letter == wordToGuess.toUpperCase().charAt(i)){
                        lettersToDisplayToUser[i] = wordToGuess.toUpperCase().charAt(i);
                    }
                }




            }

        }
        else {
            //the user guessed a word
            wordGuessedByUser = whatWordDidUserGuess.equals(wordToGuess);
        }

    }
    void play(){
        do{
            displayDashesOfWord();
            System.out.println("Guess the word: ");
            whatWordDidUserGuess = console.readLine();
            System.out.println("You guessed " + whatWordDidUserGuess);
            numberOfUserGuesses++;
            didUserGuessLetterOrWord();

        }
        while(numberOfUserGuesses <= maxNumberOfGuessesGivenLevelChosen && !wordGuessedByUser);

    }
}
