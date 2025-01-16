package wk2;

import java.util.Random;

public class SentenceGenerator {

    public static void main(String[] args) {

        String[] nouns1 = {"Ben", "Georgian College", "Barrie"};
        String[] verbs = {"loves", "has", "likes"};
        String[] nouns2 = {"cars", "bikes", "books"};

        Random random = new Random();

        random.nextInt(5, 11);

        System.out.printf("%s %s %s\n",
                nouns1[random.nextInt(nouns1.length)],
                verbs[random.nextInt(verbs.length)],
                nouns2[random.nextInt(nouns2.length)]
                );

    }
}
