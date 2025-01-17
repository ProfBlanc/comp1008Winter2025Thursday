package wk2;

import java.util.Scanner;

public class PizzaOrder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Pizza Place");
        System.out.println("What size pizza do you want? S, M, L ");
        //char choice = sc.next().charAt(0);
        String choice = sc.nextLine().toUpperCase();
        if(choice.equals("S") || choice == "M" || choice.equals("L")){

            String[] toppings = new String[5];

            for(int i = 0 ; i < 5 ; i++){
                System.out.printf("Enter topping %d of %d: ", i + 1, toppings.length);
                toppings[i] = sc.nextLine();
                if(toppings[i].isEmpty()){
                    System.out.println("NO topping given, exiting loop");
                    break;
                }
            }


            System.out.printf("Summary\n Pizza size was %s\nToppings: %s %s %s %s %s\n",
                    choice,toppings[0],toppings[1],toppings[2],toppings[3],toppings[4]);
        }
        else{
            System.out.println("Invalid choice!");
        }

    }
}
