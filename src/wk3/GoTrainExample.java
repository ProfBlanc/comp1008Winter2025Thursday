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
    
    double cardBalance = 100;

    private String stationSource = "";
    private String stationDestination = "";

    String[] availableStations = {"Barrie", "Bradford", "Newmarket", "Maple", "Rutherford", "Downsview Park", "Union Station"};
    float flatEntryPrice = 8f;
    
    void tapOn(String sourceStation){
        
        //validate 
        setStationSource(sourceStation);
        
    }
    //just like tapOn
    void tapOff(String station){
        setStationDestination(station);
    }
    //return the index difference between source station 
    // and destination station
    //get absolute value
    int getDuration(){
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
    float tripTotal(){
        float total = getDuration() * flatEntryPrice;
        cardBalance -= total;
        return total;
    }
    
    //setter: set the value of this instance variable
    void setStationDestination(String dest){
       
        for(int i = 0; i < availableStations.length; i++){
            
            if(availableStations[i].equalsIgnoreCase(dest)){
                stationDestination = dest;
                break;
            }
        }
        
    }
    //setter: set the value of this instance variable
    void setStationSource(String src){
       
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
    
}

class Main {
    public static void main(String[] args) {
        TakeGoTrain go = new TakeGoTrain();
        go.tapOn("barrie");
        go.tapOff("Downsview Park");
        
        System.out.println(go.tripTotal());
        
    }
}
