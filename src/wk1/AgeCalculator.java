package wk1;

public class AgeCalculator {

    public static void main(String[] args) {
        System.out.println("What year were you born?");
        String birthYearAsString = System.console().readLine();
        int birthYear = Integer.parseInt(birthYearAsString);
        //Double.parseDouble
        //DataType.parseDataType
        int currentYear = 2025;
        int ageInYears = currentYear - birthYear;
        int ageInMonths = ageInYears * 12;
        int ageInDays = ageInYears * 365;

        System.out.println("Your age in years is " + ageInYears);
        System.out.println("Your age in months is " + ageInMonths);
        System.out.println("Your age in days is " + ageInDays);
    }
}
