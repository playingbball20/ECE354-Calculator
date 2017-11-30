package com.example.jon.calculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.view.inputmethod.InputMethodManager;
import java.util.Stack;


public class MainActivity extends AppCompatActivity {

    private double result = 0.0;
    private EditText Operand1;
    private EditText Operand2;
    private EditText results;
    char valueNext;
    private Stack<Character> stack = new Stack<Character>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickAdd(View view) {                           //Add Operand1+Operand2

       Operand1 = findViewById(R.id.text1);
       Operand2 = findViewById(R.id.text2);
       results = findViewById(R.id.text3);

        double Op1 = 0;
        double Op2 = 0;

        if((Operand1.getText().toString().trim().length()) > 0)
            Op1 = Double.valueOf(eval(Operand1.getText().toString())).doubleValue();//Double.valueOf(Operand1.getText().toString());
        else
            Operand1.setText("0");

        if(Operand2.getText().toString().trim().length() > 0)
            Op2 = Double.valueOf(eval(Operand2.getText().toString())).doubleValue(); //Double.valueOf(Operand2.getText().toString());

        else
            Operand2.setText("0");

        result = addNum((double) Op1,(double) Op2);
        Operand1.requestFocus();
        hideKeyboard();
        results.setText(Double.toString(result));
    }

    public void clickSub(View view) {                           //Subtract Operand1-Operand2

        Operand1 = (EditText) findViewById(R.id.text1) ;
        Operand2 = (EditText) findViewById(R.id.text2) ;
        results = (EditText) findViewById(R.id.text3) ;

        double Op1 = 0;
        double Op2 = 0;

        if(Operand1.getText().toString().trim().length() > 0)
            Op1 = Double.valueOf(eval(Operand1.getText().toString())).doubleValue();
        else
            Operand1.setText("0");

        if(Operand2.getText().toString().trim().length() > 0)
            Op2 = Double.valueOf(eval(Operand2.getText().toString())).doubleValue();
        else
            Operand2.setText("0");

        result = minNum((double)Op1, (double)Op2);
        hideKeyboard();
        Operand1.requestFocus();
        results.setText(Double.toString(result));
    }

    public void clickMult(View view) {                          //Multiply Operand1*Operand2

        Operand1 = (EditText) findViewById(R.id.text1) ;
        Operand2 = (EditText) findViewById(R.id.text2) ;
        results = (EditText) findViewById(R.id.text3) ;

        double Op1 = 0;
        double Op2 = 0;

        if(Operand1.getText().toString().trim().length() > 0)
            Op1 = Double.valueOf(eval(Operand1.getText().toString())).doubleValue();
        else
            Operand1.setText("0");

        if(Operand2.getText().toString().trim().length() > 0)
            Op2 = Double.valueOf(eval(Operand2.getText().toString())).doubleValue();
        else
            Operand2.setText("0");

        result =  multNum((double) Op1,(double) Op2);
        hideKeyboard();
        Operand1.requestFocus();
        results.setText(Double.toString(result));
    }

    public void clickDiv(View view) {                           //Divide Operand1/Operand2

        Operand1 = (EditText) findViewById(R.id.text1);
        Operand2 = (EditText) findViewById(R.id.text2);
        results = (EditText) findViewById(R.id.text3);

        double Op1 = 0;
        double Op2 = 0;

        if(Operand1.getText().toString().trim().length() > 0)
            Op1 = Double.valueOf(eval(Operand1.getText().toString())).doubleValue();
        else
            Operand1.setText("0");

        Operand1.requestFocus();
        hideKeyboard();

        if(Operand2.getText().toString().trim().length() > 0 && (Double.valueOf(Operand2.getText().toString()).doubleValue()) != 0)
            Op2 = Double.valueOf(eval(Operand2.getText().toString())).doubleValue();
        else
            Operand2.setText("0");

        result = divNum((Double) Op1, (Double) Op2);
        results.setText(Double.toString(result));
    }

    public void clickSqrt(View view) {                              //Take Square Root of Operand1

        Operand1 = (EditText) findViewById(R.id.text1) ;
        Operand2 = (EditText) findViewById(R.id.text2) ;
        results = (EditText) findViewById(R.id.text3) ;

        double Op1 = 0;
        double Op2 = 0;

        if(Operand1.getText().toString().trim().length() > 0)
            Op1 = Double.valueOf(eval(Operand1.getText().toString())).doubleValue();
        else
            Operand1.setText("0");

        hideKeyboard();
        Operand1.requestFocus();

        if((int) Op1 < 0) {
            result = Math.sqrt(-1*Op1);
            String str = String.valueOf(result);
            results.setText("j" + str);
        }else {
            result = Math.sqrt(Op1);
            results.setText(Double.toString(result));
        }
    }

    public void clickPow(View view) {                               //Button click for Operand1^Operand2
        Operand1 = (EditText) findViewById(R.id.text1) ;
        Operand2 = (EditText) findViewById(R.id.text2) ;
        results = (EditText) findViewById(R.id.text3) ;

        double Op1 = 0;
        double Op2 = 0;

        if(Operand1.getText().toString().trim().length() > 0)
            Op1 = Double.valueOf(eval(Operand1.getText().toString())).doubleValue();
        else
            Operand1.setText("0");

        if(Operand2.getText().toString().trim().length() > 0) {
            Op2 = Double.valueOf(eval(Operand2.getText().toString())).doubleValue();
        }
        else
            Operand2.setText("0");

        result = PowNum(Op1, Op2);
        hideKeyboard();
        Operand1.requestFocus();
        results.setText(Double.toString(result));
    }

    public void clickClear(View view) {                             //Clears Operand1,Operand2, and Result

        Operand1 = (EditText) findViewById(R.id.text1);
        Operand2 = (EditText) findViewById(R.id.text2);
        results = (EditText) findViewById(R.id.text3);

        Operand1.setText(null);
        Operand2.setText(null);
        results.setText(null);
        showKeyboard();
        Operand1.requestFocus();
        showKeyboard();

    }

    private void showKeyboard() {                                    //Hide keyboard after button press
   //     if(getCurrentFocus()==null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    //    }
    }

    private void hideKeyboard() {                                    //Hide keyboard after button pres
         if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
         }
    }

    public void clickExit(View view) {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Exit Calculator App")
                .setMessage("Do you want to exit the calculator?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                })
                .setNegativeButton("No",null)
                .show();

    }

    private double addNum(double x, double y){                       //Add Op1+Op2
        return (x + y);
    }
    private double minNum(double x, double y){                       //Subtract Op1-Op2
        return (x - y);
    }
    private double multNum(double x, double y){                      //Multiply Op1*Op2
        return (x * y);
    }
    private double divNum(double x, double y){                       //Divide Op1/Op2
            return (x / y);
    }

    private double PowNum(double x, double y){                       //Power of Op1^Op2

        if(y == 0) {
            hideKeyboard();
            return 1;
        }

        double answer = x;

        int i=2;
        while(i <= (int) y) {
            answer *= x;
            i++;
        }

        hideKeyboard();
        return (answer);
    }

 //   char valueNext;
 //   private Stack<Character> stack = new Stack<Character>();

    private Double eval(String expression) {
        String postfixString = "";

        for (int index = 0; index < expression.length(); ++index) {
            char value = expression.charAt(index);

            if (index != (expression.length() - 1))
                valueNext = expression.charAt(index + 1);

            if (value == '(') {
                stack.push('(');
            } else if (value == ')') {
                Character oper = stack.peek();

                while (!(oper.equals('(')) && !(stack.isEmpty())) {
                    stack.pop();
                    postfixString += oper.charValue();
                    if (!stack.isEmpty())
                        oper = stack.peek();
                }
                stack.pop();
                //Added Muliplication if )(...
                if (((index + 1) < expression.length()) && (valueNext == '(' || valueNext == '0' || valueNext == '1' || valueNext == '2' ||
                        valueNext == '3' || valueNext == '4' || valueNext == '5' || valueNext == '6' || valueNext == '7' || valueNext == '8' ||
                        valueNext == '9')) {     //IF )( then nultiply

                    stack.push('*');
                }
                postfixString += " ";

            } else if (value == '+' || value == '-') {
                if (stack.isEmpty()) {
                    stack.push(value);
                } else {
                    Character oper = stack.peek();
                    while (!(stack.isEmpty() || oper.equals(('(')) || oper.equals((')')))) {
                        oper = stack.pop();
                        postfixString += oper.charValue();
                    }
                    stack.push(value);
                }

                postfixString += " ";
            } else if (value == '*' || value == '/') {
                if (stack.isEmpty()) {
                    stack.push(value);

                } else {
                    Character oper = stack.peek();
                    while (!oper.equals(('(')) && !oper.equals(('+')) && !oper.equals(('-')) && !stack.isEmpty()) {
                        oper = stack.pop();
                        postfixString += oper.charValue();
                    }
                    stack.push(value);
                }
                postfixString += " ";
            } else {
                postfixString += value;
                if ((index + 1) < expression.length() && valueNext == '(')
                    stack.push('*');
                postfixString += " ";
            }
        }

        while (!stack.isEmpty()) {
            Character oper = stack.peek();
            if (!oper.equals(('('))) {
                stack.pop();
                postfixString += oper.charValue();
            }

            postfixString += " ";
        }

        //
        /// //
        ///
        ///
        ///
        /// //return postfixString;

        Stack<Double> s = new Stack<Double>();

        // Convert expression to char array
        char[] chars = postfixString.toCharArray();

        // Cache the length of expression
        int N = chars.length;

        for (int i = 0; i < N; i++) {
            char ch = chars[i];

            if (isOperator(ch)) {
                // Operator, simply pop out two numbers from stack and perfom operation
                // Notice the order of operands
                switch (ch) {
                    case '+':
                        s.push(s.pop() + s.pop());
                        break;
                    case '*':
                        s.push(s.pop() * s.pop());
                        break;
                    case '-':
                        s.push(-s.pop() + s.pop());
                        break;
                    case '/':
                        s.push(1 / s.pop() * s.pop());
                        break;
                }
            } else if (Character.isDigit(ch)) {
                // Number, push to the stack
                s.push(0.0);
                while (Character.isDigit(chars[i]))
                    s.push(10.0 * s.pop() + (chars[i++] - '0'));
            }
        }

        // The final result should be located in the bottom of stack
        // Otherwise return 0.0
        if (!s.isEmpty())
            return s.pop();
        else
            return 0.0;
    }

    /**
     * Check if the character is an operator
     */
    private static boolean isOperator(char ch) {
        return ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }


}
