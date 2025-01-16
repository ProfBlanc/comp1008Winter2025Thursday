package wk2;

import java.io.Console;
import java.time.LocalDate;
import java.util.Scanner;

public class AgeCalculator {

    public static void main(String[] args) {

        int currentYear = 2025;
        currentYear = LocalDate.now().getYear();
        Scanner sc = new Scanner(System.in);
        Console c = System.console();
        System.out.println("What year were you born? ");
        int birthYear1 = sc.nextInt();

        System.out.println("What year were you born part 2? ");
        int birthYear2 = Integer.parseInt(c.readLine());

        int ageInYears = currentYear - birthYear1;
        double ageInDays = ageInYears * 365.25;
        int ageInMonths = ageInYears * 12;
        System.out.println("Your age in years is " + ageInYears);
        System.out.println("Your age in months is " + ageInMonths);

    }
}
