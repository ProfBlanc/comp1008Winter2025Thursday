// Online Java Compiler
// Use this editor to write, compile and run your Java code online


/*

Create a class named FuelCar
    attributes
        tankCapacity: bt 30-100 in litres
        fuelLevel: 0- 100%
        kilometresPerLitre: 10 or 30 (or be creative)
    method
        drive(doube/int of kilometers)
            using the param, decrease the fuel level by a percentage

    getFuelLevel()  returns fuel level
    setTankCapacity: only accepts values b/t 30-100
    setFuelLevel() only accepts values between 0-100



*/
package wk3;
public class FuelCar{
    
    //attributes: values that store a state of object
    /*
    tankCapacity: bt 30-100 in litres
        fuelLevel: 0- 100%
        kilometresPerLitre: 10 or 30 (or be creative)
    */
    
    
    //in litres
    int tankCapacity = 50;
    double fuelLevel = 100f; //50L = 100%, 25L = 50%
    // 1 litre is consumed once you drive 15KM
    double kilometresPerLitre = 15d;
    int kmDrivenSinceLastOilChange;
    double odometer;
    
    void drive(int kilometresDriven){
        
        kmDrivenSinceLastOilChange += kilometresDriven;
        odometer += kilometresDriven;
        
        double valueToSubFromTankCapacity = kilometresDriven / kilometresPerLitre;
                                    //  50             -         1   = 49    /50  = 0.98
                                    // fuelLevel - above equation
        double value = 100 -  ((tankCapacity - valueToSubFromTankCapacity) / tankCapacity ) ;
        fuelLevel = (fuelLevel - value) * 100;

        
    }
    boolean needsOilChange(){
        
        return kmDrivenSinceLastOilChange >= 5000;
    }
    void doOilChange(){
        kmDrivenSinceLastOilChange = 0;
    }
    
    // oil change needed: needed after X amount of KM driven
            //needsOilChange: evaluated instance var: kmDrivenSinceLastOilChange
            //doOilChange
                //reset the instace var: kmDrivenSinceLastOilChange
    // store: 1 additional: kilometres drives since last oil 
    
}


