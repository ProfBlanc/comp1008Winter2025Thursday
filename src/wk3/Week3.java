package wk3;

public class Week3 {

    public static void main(String[] args) {

    }

    static void example3(){

        TakeGoTrain go = new TakeGoTrain(2);

        go.tapOn("Scarborough");
        go.tapOff("DurhamCollege");

    }

    static void example2(){
        TakeGoTrain go = new TakeGoTrain();
        go.tapOn("barrie");
        go.tapOff("Downsview Park");

        //System.out.println(go.tripTotal());
        TakeGoTrain go1 = new TakeGoTrain("barrie", "union station");
        go1.tapOn("union station");
        go1.tapOff("maple");
    }

    static void example1(){

        String s = "Hello World";
        System.out.println(s);

        FuelCar fc = new FuelCar();
        System.out.println(fc.tankCapacity);
        //fc.tankCapacity = -20;
        System.out.println(fc.tankCapacity);

        fc.drive(15);
        System.out.println(fc.fuelLevel);

        System.out.println(fc.needsOilChange());

    }
}
