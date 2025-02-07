package wk5;

import java.io.Console;
import java.util.ArrayList;

public class PicnicGame {

    private ArrayList<String> items = new ArrayList<String>();
    private ArrayList<String> whatUserGuessed = new ArrayList<>();
    private String organizer;
    private Console console = System.console();
    private StringBuilder str = new StringBuilder();
    private boolean gameIsOver = false;

    public PicnicGame(String organizer, String firstItem){

        setOrganizer(organizer);
        addItem(firstItem);
        play();
    }
    public void play(){

        System.out.printf("%s is organizing a picnic and is bringing %s\n", organizer, items.get(0));
        while(!gameIsOver)
            askPlayerToRecallPreviousItems();

        gameOver();

    }
    private void askPlayerToRecallPreviousItems(){
        System.out.println("Your turn! What items do you recall (what items were added to the picnic) ?");

        whatUserGuessed.clear();//clearing previous guesses

        do{
            System.out.printf("Guess item %d of %d: ", whatUserGuessed.size() + 1, items.size());
            str.delete(0, str.length()); // delete all characters
            str.append(console.readLine().toLowerCase());  // get user input and save it to StringBuilder object

            if(!whatUserGuessed.contains(str.toString()) && items.contains(str.toString())   ){
                System.out.printf("Yes, %s exists in the picnic inventory. Guess another item\n", str.toString());
                whatUserGuessed.add(str.toString());
            }
            else if(whatUserGuessed.contains(str.toString())){
                System.out.printf("You already guessed %s. You lose the challenge\n", str.toString());
            }
            else{
                System.out.printf("Sorry, but %s is NOT in the picnic inventory\n", str.toString());
                gameIsOver = true;
                gameOver();
               break;
            }

        }while(whatUserGuessed.size() < items.size() );

        askPlayerToAddAnItem();

    }
    private void askPlayerToAddAnItem(){

        System.out.println("Add a new item to the picnic inventory");
        str.delete(0, str.length());
        str.append(console.readLine().toLowerCase());
        addItem(str.toString());
    }
    private void gameOver(){
        //
        System.out.println("Thanks for playing!");
        System.out.printf("At the end of the game, you guessed %d out of %d items\n",
                whatUserGuessed.size(), items.size());
        return;
    }
    private void setOrganizer(String organizer){
        if(organizer.length() < 3){
            throw new IllegalArgumentException("Invalid Name. Name must be at least 3 characters.");
        }
        this.organizer = organizer;
    }
    private void addItem(String item){
        if(item.length() < 3 || items.contains(item)){
            throw new IllegalArgumentException(item + "'s name is too short or already exists in the inventory");
        }
        items.add(item.toLowerCase());
    }
}
