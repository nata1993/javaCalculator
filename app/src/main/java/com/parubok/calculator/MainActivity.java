package com.parubok.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText result;
    double value1, value2;
    boolean multiply, divide, subtract, add, exponent, remainder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.etResult);
    }

    public void onDigit(View view) {
        switch (view.getId())
        {
            case R.id.button0:
                result.setText(String.format("%s0", result.getText()));
                break;
            case R.id.button1:
                result.setText(String.format("%s1", result.getText()));
                break;
            case R.id.button2:
                result.setText(String.format("%s2", result.getText()));
                break;
            case R.id.button3:
                result.setText(String.format("%s3", result.getText()));
                break;
            case R.id.button4:
                result.setText(String.format("%s4", result.getText()));
                break;
            case R.id.button5:
                result.setText(String.format("%s5", result.getText()));
                break;
            case R.id.button6:
                result.setText(String.format("%s6", result.getText()));
                break;
            case R.id.button7:
                result.setText(String.format("%s7", result.getText()));
                break;
            case R.id.button8:
                result.setText(String.format("%s8", result.getText()));
                break;
            case R.id.button9:
                result.setText(String.format("%s9", result.getText()));
                break;
            case R.id.button_C:
                result.setText("");
                value1 = 0.0;
                value2 = 0.0;
                break;
            case R.id.button_dot:
                if (!result.getText().toString().contains("."))
                {
                    result.setText(String.format("%s4", result.getText()));
                }
                break;
        }
    }

    public void onOperator(View view) {
        if (result.length() == 0)
            return;
        try
        {
            value1 = Double.parseDouble(result.getText().toString());
            result.setText("");
            switch (view.getId())
            {
                case R.id.button_minus:
                    subtract = true;
                    break;
                case R.id.button_multip:
                    multiply = true;
                    break;
                case R.id.button_plus:
                    add = true;
                    break;
                case R.id.button_slash:
                    divide = true;
                    break;
                case R.id.button_pwr:
                    exponent = true;
                    break;
                case R.id.button_percent:
                    remainder = true;
                    break;
            }
        }
        catch(NumberFormatException e)
        {
            e.printStackTrace();
        }
    }

    public void onEnter(View view) {
        if (result.length() == 0)
            return;
        value2 = Double.parseDouble(result.getText().toString());
        try {
            if(add)
            {
                result.setText(String.valueOf(value1+value2));
                add = false;
            }
            if(subtract)
            {
                result.setText(String.valueOf(value1-value2));
                subtract = false;
            }
            if(divide)
            {
                result.setText(String.valueOf(value1/value2));
                divide = false;
            }
            if(multiply)
            {
                result.setText(String.valueOf(value1*value2));
                multiply = false;
            }
            if(exponent)
            {
                result.setText(String.valueOf(Math.pow(value1,value2)));
                exponent = false;
            }
            if(remainder)
            {
                result.setText(String.valueOf(value1%value2));
                remainder = false;
            }
        }
        catch(NumberFormatException e)
        {
            e.printStackTrace();
        }
    }
}