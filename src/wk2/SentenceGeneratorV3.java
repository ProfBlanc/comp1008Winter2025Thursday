package wk2;

import java.io.Console;
import java.util.Random;

public class SentenceGeneratorV3 {

    public static void main(String[] args) {

        String[] nouns1 = {"Ben", "Georgian College", "Barrie"};
        String[] verbs = {"loves", "has", "likes"};
        String[] nouns2 = {"cars", "bikes", "books"};

        Console console = System.console();

        System.out.println("Enter a value between 0 and 2");
        int number = Integer.parseInt( console.readLine() );

        if(number >= 0 && number <= 2){
            System.out.println("Good job!");
        }
        else{
            System.out.println("Bad input. Defaulting to zero");
            number = 0;
        }

            System.out.printf("%s %s %s\n",
                    nouns1[number],
                    verbs[number],
                    nouns2[number]
            );

    }
}
