package wk4;

import java.io.Console;
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

    }

    void displayDashesOfWord(){

        System.out.println( "____\t".repeat(wordToGuess.length()));

    }

    void play(){
        do{
            displayDashesOfWord();
            System.out.println("Guess the word: ");
            whatWordDidUserGuess = console.readLine();
            System.out.println("You guessed " + whatWordDidUserGuess);
            numberOfUserGuesses++;

        }
        while(numberOfUserGuesses <= maxNumberOfGuessesGivenLevelChosen || !wordGuessedByUser);

    }
}
