package wk2;

public class Week2Runner {

    public static void main(String[] args) {

        MathEquation me = new MathEquation();
        me.operand1 = 10;
        me.operand2 = 20;
        System.out.println(me.getOperator());
        me.setOperator('/');
        System.out.println(me.getOperator());
        System.out.println(me.calculate());
    }
}
