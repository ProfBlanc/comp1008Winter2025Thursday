// Online Java Compiler
// Use this editor to write, compile and run your Java code online


class TakeGoTrain{
    
    /*
         tapOn()    station/city source         return   cardBalance
      tapOff()   station/city destination    return cardBalance 
      tripTotal()    difference between starting tapBalance and ending tapBalance
      getDuration()    station source, station destination
                              create a random value for duration
        

What attributes do we need to make methods above functional?
  cardBalance
  station/city source
  flatEntryPrice  (8 dollars)
  
    */
    
    private double cardBalance = 100;

    private String stationSource = "";
    private String stationDestination = "";

    //mutli-dimensional array
    /*
    String[] availableStations = {"Barrie", "Bradford", "Newmarket", "Maple", "Rutherford", "Downsview Park", "Union Station"};
    */
    private String[][] availableStationsMM = new String[][] {
        
        {"Barrie", "Bradford", "Newmarket", "Maple", "Rutherford", "Downsview Park", "Union Station"}
        ,
        {"Danforth","Scarborough","Eglinton","Guildwood","Rouge Hill",
        "Pickering","Durham College"}
        ,
        
        {"Exhibition","Mimico","Long Branch","Port Credit","Clarkson",
            "Oakville","Hamilton"}
        
        
    } ;
    
    private int lineNumber = 1;
    private String[] availableStations = availableStationsMM[lineNumber - 1];
    
    float flatEntryPrice = 4f;
    
    void addFunds(double amount){
        cardBalance += amount;
        System.out.println("Your new balance is $" + cardBalance);
    }
    void tapOn(String sourceStation){
        if(cardBalance < 0){
            System.out.println("Sorry, but you cannot Tap "
            + "On because your card balance is $" + cardBalance);
           
            return;
        }
        //validate 
        setStationSource(sourceStation);
        
    }
    //just like tapOn
    void tapOff(String station){
        if(stationSource.length() == 0){
            System.out.println("Uh oh! You didn't Tap On "
            + "therefore, you cannot tap off");
            return;
        }
        setStationDestination(station);
        tripTotal();
    }
    //return the index difference between source station 
    // and destination station
    //get absolute value
    private int getDuration(){
        int indexSrc = -1;
        int indexDest = -1;
        
        for(int i = 0; i < availableStations.length; i++){
            
            if(stationSource.equalsIgnoreCase(availableStations[i])){
                indexSrc = i;
            }
            if(stationDestination.equalsIgnoreCase(availableStations[i])){
                indexDest = i;
            }
            
        }
        int duration = indexSrc - indexDest;
            if(duration < 0){
                duration *= -1;
            }
            return duration;
    }
    //duration * flatEntryPrice
    //SUB card balance by trip total price
    private float tripTotal(){
        float total = getDuration() * flatEntryPrice;
        cardBalance -= total;
        System.out.println("Your trip total was $" + total + ".");
        System.out.println("Your card balance is $" + cardBalance);
        return total;
    }
    
    //setter: set the value of this instance variable
    private void setStationDestination(String dest){
       
        for(int i = 0; i < availableStations.length; i++){
            
            if(availableStations[i].equalsIgnoreCase(dest)){
                stationDestination = dest;
                break;
            }
        }
        
    }
    //setter: set the value of this instance variable
    private void setStationSource(String src){
       
        for(int i = 0; i < availableStations.length; i++){
            
            if(availableStations[i].equalsIgnoreCase(src)){
                stationSource = src;
                break;
            }
        }
        
    }
    String getStationSource(){
        return stationSource;
    }
    
    //constructor is a special method used to BUILD, hence construct,
    //the object
    
    public TakeGoTrain(){}
    
    public TakeGoTrain(String source, String destination){
        tapOn(source);
        tapOff(destination);
    }
    
    public void setLineNumber(int lineNumber){
        
        if(lineNumber >= 1 && lineNumber <= availableStationsMM.length){
            this.lineNumber = lineNumber;
            availableStations = availableStationsMM[this.lineNumber - 1]; 
            System.out.println("You are travelling on Line Number " + lineNumber);
            System.out.println("The stations available are");
            
            for(int i = 0; i < availableStations.length; i++){
                if(i == availableStations.length - 1){
                    System.out.print("and ");
                }
                System.out.print(availableStations[i]);
                if(i == availableStations.length - 1){
                    System.out.print(".");
                }
                else{
                    System.out.print(", ");
                }
            }
            System.out.println(); // to create a new line character
        }
        else{
            System.out.println("Sorry but line number " + lineNumber + " doesn't exist!");
        }
        
    }
    
    public TakeGoTrain(int lineNumber){
        
        setLineNumber(lineNumber);
    }
    
    
}

class Main {
    public static void main(String[] args) {
       
        TakeGoTrain go = new TakeGoTrain(2);
        
        go.tapOn("Scarborough");
        go.tapOff("DurhamCollege");
    }
    static void example1(){
         TakeGoTrain go = new TakeGoTrain();
        go.tapOn("barrie");
        go.tapOff("Downsview Park");
        
        //System.out.println(go.tripTotal());
        TakeGoTrain go1 = new TakeGoTrain("barrie", "union station");
        go1.tapOn("union station");
        go1.tapOff("maple");
    }
}
