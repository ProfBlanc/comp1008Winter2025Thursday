package wk5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Week5 {

    public static void main(String[] args) {
        example2();
    }
    static void example3(){

        try{
            PicnicGame game = new PicnicGame("Ben", "water");
            game.play();
        }
        catch (IllegalArgumentException e){
            System.err.println("Error! " + e.getMessage());
        }


    }
    static void example2(){

        try {
            PicnicGame game = new PicnicGame("Ben", "water");
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a number");
            int number = input.nextInt();
            System.out.println(number);
        }
        //catch (IllegalArgumentException | InputMismatchException e){
           catch (IllegalArgumentException e){
            //serr
            System.err.println(e.getClass().getSimpleName());  //exception name
            System.err.println(e.getMessage()); //message OR null
        }
        catch (InputMismatchException e){
            System.err.println("Invalid numerical value");
        }

    }
    static void example1(){
        String s1 = "Hello World";
        s1 = "Updated";

        StringBuilder sb = new StringBuilder();
        //length: # of chars
        //capacity: max # of chars...dynamic

        System.out.println(sb.length());
        System.out.println(sb.capacity());

        sb.append("hello"); //length = 5, cap = 16
        sb.append(123); //length = 8, capacity = 16
        sb.append("java is the greatest lange");
        //length = 20-30, capacity: 34
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        sb.append(1);
        System.out.println(sb.length());
        System.out.println(sb.capacity());

        sb.deleteCharAt(10);
        sb.setCharAt(15, 'U');

    }

}
