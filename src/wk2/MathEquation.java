package wk2;

public class MathEquation {

    //attributes/properties/components

    double operand1, operand2;

    private double result;

    private char operator;

    //actions/behaviours

    public void setOperator(char operator) {

        //this.operator = operator;
        if(operator=='+'||operator=='-' ||
        operator=='*'||operator=='/'){
            this.operator=operator;
        }
        else{
            System.out.println("Invalid operator. Defaulting to Plus");
            this.operator = '+';
        }
    }
    public char getOperator() {
        return operator;
    }

    public double calculate(){

        if(operator=='+'){
            result = operand1 + operand2;
        }
        else if(operator=='-'){
            result = operand1 - operand2;
        }
        else if(operator=='*'){
            result = operand1 * operand2;
        }
        else{
            result = operand1 / operand2;
        }

        return result;
    }


}
