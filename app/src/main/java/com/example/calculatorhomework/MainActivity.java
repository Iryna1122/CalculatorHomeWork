package com.example.calculatorhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView inputTextView, resultTextView;

    private String digit1="";
    private String digit2="";
    private String operator="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTextView = findViewById(R.id.inputTextView);
        resultTextView = findViewById(R.id.resultTextView);
    }

    private double calculateResult()
    {
        double num1= Double.parseDouble(digit1);
        double num2 = Double.parseDouble(digit2);
        double res = 0.0;

        switch (operator)
        {
            case "+":{
                res = num1 + num2;
                break;
            }
            case "-": res = num1 - num2;
            break;

            case "*": res = num1*num2;
            break;

            case "/":
                if(num2!=0)
                {
                    res = num1/num2;
                }
                break;
        }
        digit1 = String.valueOf(res);
        operator = "";
        digit2 = "";
        return res;
    }

    public void onButtonClick(View view)
    {

        Button button = (Button)view;
        String buttonText = button.getText().toString();

        switch (buttonText)
        {
            case "/":{
                if(digit2!=null && !operator.isEmpty())
                {
                    return;
                }
//                else {
//                    resultTextView.setText("Error");
//                }
                operator=buttonText;
            }break;
            case "+":

            case "-":

            case "*":

            case "=" :{
                if (digit1.isEmpty() || operator.isEmpty() || digit2.isEmpty()) {
                    return;
                }
                double result = calculateResult();
                resultTextView.setText(String.valueOf(result));
                break;
            }
            case "C":
                digit1 = "";
                operator = "";
                digit2 = "";
                inputTextView.setText("");
                resultTextView.setText("");
                break;

            default:
                if (operator.isEmpty()) {
                    digit1 += buttonText;
                }
                else {
                   digit2 += buttonText;
                }
                break;
        }
        if(!buttonText.equals("C")){
            inputTextView.append(buttonText);
        }
    }

}