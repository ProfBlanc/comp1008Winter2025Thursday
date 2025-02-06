package wk5;

public class Week5 {

    public static void main(String[] args) {
        example1();
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
