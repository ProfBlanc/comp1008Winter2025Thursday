package wk2;

import java.util.Random;

public class SentenceGeneratorV2 {

    public static void main(String[] args) {

        String[] nouns1 = {"Ben", "Georgian College", "Barrie"};
        String[] verbs = {"loves", "has", "likes"};
        String[] nouns2 = {"cars", "bikes", "books"};

        Random random = new Random();


        for(int i = 0; i < 5; i++) {
            System.out.printf("%s %s %s\n",
                    nouns1[random.nextInt(nouns1.length)],
                    verbs[random.nextInt(verbs.length)],
                    nouns2[random.nextInt(nouns2.length)]
            );
        }
    }
}
