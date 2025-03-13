/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.ArrayList;
//Human
class Human{
    
    public String name = "Person";
    protected double height = 50d;
    private int age = 18;
    
    public Human(){}
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if(age >= 0 && age <= 100){
            this.age = age;
        }
    }
    public Human(String name, double height, int age){
        this.name = name;
        this.height = height;
        setAge(age);
    }
    
    @Override
    public String toString(){
        
        return String.format("Name = %s, Height = %.2f, Age = %d",
            name, height, age
        );
    }
    
    
}

class Student extends Human{
    
    private ArrayList<String> courses = new ArrayList<>();
    long studentId;
    double gpa;
    
    @Override
    public void setAge(int age){
        if(age >= 18 && age <= 60){
            super.setAge(age);
        }
        
    }
    
    public void setCourses(String... courses){  //studentObject.setCourses("java", "c#", "php");
        for(String course : courses){
            this.courses.add(course);
        }
    }
    public String getCourses(){
        StringBuilder sb = new StringBuilder();
        for(String course : courses){
            sb.append(course);
            sb.append(",");
        }
        if(sb.length() > 0)
            sb.setLength(sb.length() - 1); //to remove the trailing ","
        return sb.toString();
    }
    @Override
    public String toString(){
        
return super.toString() + "," + String.format("Student ID = %d, GPA = %.1f, Courses = %s",

    studentId, gpa, getCourses()
);
    }
    
    public Student(){
        super();
    }
    public Student(String name, double height, int age){
        super(name, height, age);
    }
    public Student(String name, double height, int age,
    int studentId, double gpa, String... courses
    ){
        
        //this(name, height, age);
        super(name, height, age);
        
        //super.name = "new new name value"; //legal...for demo purposes
        //this.height = 100f; //legal...for demo purposes
        
        this.gpa = gpa;
        this.studentId = studentId;
        setCourses(courses);
    }
    
}
public class Main
{
	public static void main(String[] args) {
    	Human h1 = new Human();
    	Student s1 = new Student();
    	s1.studentId = 123456789;
    	s1.gpa = 4.0;
    	s1.setCourses("php", "c#", "python", "java");
    	
     	System.out.println(h1.name);
       	System.out.println(s1.name);
       	System.out.println(h1);
       	System.out.println(s1);
       	
       	
       	Human h2 = new Student();
       	Object o = new Student();
       	
       	System.out.println(o);
       	
       	
       	
       	Human[] people = {new Human(), new Student()};
       	
       	
       	
       //	Student s4 = new Human(); // not possible
       
       Student s5 = new Student("Prof Blanc", 184d, 20, 123456789, 4.0d, "java", "python",
       "cybersecurity", "asp.net", "the list goes on..."); 
       System.out.println(s5);
       	
	}
}
