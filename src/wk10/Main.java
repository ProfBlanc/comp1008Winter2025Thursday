/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

//Shape

abstract class Shape{
    
    private String name;
    private int sides;
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        if(name.length() < 3)
            throw new IllegalArgumentException(name + " is too short. Must be at least 3 characters");
        this.name = name;
    }
    public int getSides(){
        return sides;
    }
    public void setSides(int sides){
        if(sides < 1)
            throw new IllegalArgumentException("Sides must be at least 1");
        this.sides = sides;
    }
    public Shape(){}
    public Shape(String name, int sides){
        setName(name);
        setSides(sides);
    }
    
    //abstract methods
    
    public abstract double getArea();
    public abstract double getPerimeter();
    
}

class Rectangle extends Shape{
    
    private double length, width;
    
    @Override
    public double getArea(){
        return length * width;
    }
    @Override
    public double getPerimeter(){
        return 2 * (length + width);
    }
    
    public Rectangle(){super();}
    public Rectangle(String name, int sides, double length, double width){
        
        super(name, sides);
        this.length = length;
        this.width = width;
    }
    
}

abstract class ThreeDShape extends Shape{
    
    public double depth;
    
    public abstract double getVolume();
}
class Cube extends ThreeDShape{
    
    @Override
    public double getArea(){
        return 10;
    }
    @Override
    public double getPerimeter(){
        return 100;
    }
    @Override
    public double getVolume(){
        return 1;
    }
}

interface Pet{
    double MIN_WEIGHT = 1;
    double MAX_WEIGHT = 100;
    
    String speak(double loudnessLevel);
    void eat(String food);
    
}

interface DangerousPet extends Pet{
    
    double value = MIN_WEIGHT * MAX_WEIGHT;
    
    void dangerLevel();
    void feedtime();
}
interface FakeInterface{
    
    void method1();
    void method2();
}
interface CoolInterface{
    void method3();
    void method4();
}

interface MysteryInterface extends Pet, FakeInterface, CoolInterface{
    
}

class RandomClass extends ThreeDShape implements CoolInterface, Pet{
    @Override
    public void method3(){}
    @Override
    public void method4(){}
    
        @Override
    public double getArea(){
        return 10;
    }
    @Override
    public double getPerimeter(){
        return 100;
    }
    @Override
    public double getVolume(){
        return 1;
    }
    
    @Override
    public String speak(double loudnessLevel){
        return "Dog is barking at level " + loudnessLevel;
    }
    @Override
    public void eat(String food){
        System.out.println("Dog is eating " + food);
    }
    
    
}


class Dog implements Pet{
    private double weight;
    @Override
    public String speak(double loudnessLevel){
        return "Dog is barking at level " + loudnessLevel;
    }
    @Override
    public void eat(String food){
        System.out.println("Dog is eating " + food);
    }
    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        
        if(weight < MIN_WEIGHT || weight > MAX_WEIGHT){
            throw new IllegalArgumentException(
                String.format("%.1f is outside of range. The weight range is between %.1f and %.1f",
                    weight, MIN_WEIGHT, MAX_WEIGHT
                )
                );
        }
    }
}

public class Main
{
	public static void main(String[] args) {
		//Shape s1 = new Shape();
		Rectangle r1 = new Rectangle();
		Shape s1 = new Rectangle("rectangle", 4, 10, 2);
		System.out.println(s1.getArea());
		
		Dog d1 = new Dog();
		d1.setWeight(1);
		
		Pet p1 = new Dog();
		
	}
}
