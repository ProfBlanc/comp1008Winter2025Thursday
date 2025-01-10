package wk1;

public class ConverterPart1 {

    public static void main(String[] args) {

        System.out.println("Enter weight in pounds");
        String input = System.console().readLine();
        int value = Integer.parseInt(input);
        double conversionRate =  0.453;

        System.out.printf("%s in pounds is %.2f kilograms", input, value * conversionRate );

        //string formatting
        //%s        string
        //%d        digit   whole number
        //%f        float or double

    }
}
