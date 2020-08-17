package com.junhyuk.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textNumber;
    TextView textSubNumber;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonPlus;
    Button buttonMinus;
    Button buttonMultiple;
    Button buttonDiv;
    Button buttonEquals;
    Button buttonClear;

    String mainNumber = "";
    String subNumber = "";

    int checkCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNumber = findViewById(R.id.textNumber);
        textSubNumber = findViewById(R.id.sub_number);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonMultiple = findViewById(R.id.button_multiple);
        buttonDiv = findViewById(R.id.button_div);
        buttonEquals = findViewById(R.id.button_equals);
        buttonClear = findViewById(R.id.buttonC);

        button0.setOnClickListener(onClickListener);
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        button5.setOnClickListener(onClickListener);
        button6.setOnClickListener(onClickListener);
        button7.setOnClickListener(onClickListener);
        button8.setOnClickListener(onClickListener);
        button9.setOnClickListener(onClickListener);
        buttonPlus.setOnClickListener(onClickListener);
        buttonMinus.setOnClickListener(onClickListener);
        buttonMultiple.setOnClickListener(onClickListener);
        buttonDiv.setOnClickListener(onClickListener);
        buttonEquals.setOnClickListener(onClickListener);
        buttonClear.setOnClickListener(onClickListener);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            calculator calculator = new calculator();

            switch (view.getId()) {
                case R.id.button0:
                    mainNumber += "0";
                    textNumber.setText(mainNumber);
                    break;
                case R.id.button1:
                    mainNumber += "1";
                    textNumber.setText(mainNumber);
                    break;
                case R.id.button2:
                    mainNumber += "2";
                    textNumber.setText(mainNumber);
                    break;
                case R.id.button3:
                    mainNumber += "3";
                    textNumber.setText(mainNumber);
                    break;
                case R.id.button4:
                    mainNumber += "4";
                    textNumber.setText(mainNumber);
                    break;
                case R.id.button5:
                    mainNumber += "5";
                    textNumber.setText(mainNumber);
                    break;
                case R.id.button6:
                    mainNumber += "6";
                    textNumber.setText(mainNumber);
                    break;
                case R.id.button7:
                    mainNumber += "7";
                    textNumber.setText(mainNumber);
                    break;
                case R.id.button8:
                    mainNumber += "8";
                    textNumber.setText(mainNumber);
                    break;
                case R.id.button9:
                    mainNumber += "9";
                    textNumber.setText(mainNumber);
                    break;
                case R.id.button_plus:
                    subNumber = mainNumber;
                    Log.d("data2", "data: " + subNumber);
                    mainNumber = "";
                    textSubNumber.setText(subNumber);
                    textNumber.setText("0");
                    checkCalculate = 0;
                    break;
                case R.id.button_minus:
                    subNumber = mainNumber;
                    mainNumber = "";
                    textSubNumber.setText(subNumber);
                    textNumber.setText("0");
                    checkCalculate = 1;
                    break;
                case R.id.button_multiple:
                    subNumber = mainNumber;
                    mainNumber = "";
                    textSubNumber.setText(subNumber);
                    textNumber.setText("0");
                    checkCalculate = 2;
                    break;
                case R.id.button_div:
                    subNumber = mainNumber;
                    mainNumber = "";
                    textSubNumber.setText(subNumber);
                    textNumber.setText("0");
                    checkCalculate = 3;
                    break;
                case R.id.button_equals:
                    switch (checkCalculate){
                        case 0:
                            mainNumber = String.valueOf(calculator.plus(Integer.parseInt(mainNumber), Integer.parseInt(subNumber)));
                            textNumber.setText(mainNumber);
                            subNumber = "";
                            textSubNumber.setText(subNumber);
                            break;
                        case 1:
                            if(Integer.parseInt(mainNumber) > Integer.parseInt(subNumber)){
                                mainNumber = String.valueOf(calculator.minus(Integer.parseInt(mainNumber), Integer.parseInt(subNumber)));
                            }else{
                                mainNumber = String.valueOf(calculator.minus(Integer.parseInt(subNumber), Integer.parseInt(mainNumber)));
                            }
                            textNumber.setText(mainNumber);
                            subNumber = "";
                            textSubNumber.setText(subNumber);
                            break;
                        case 2:
                            mainNumber = String.valueOf(calculator.multiple(Integer.parseInt(mainNumber), Integer.parseInt(subNumber)));
                            textNumber.setText(mainNumber);
                            subNumber = "";
                            textSubNumber.setText(subNumber);
                            break;
                        case 3:
                            if(Integer.parseInt(mainNumber) > Integer.parseInt(subNumber)){
                                mainNumber = String.valueOf(calculator.divide(Integer.parseInt(mainNumber), Integer.parseInt(subNumber)));
                            }else{
                                mainNumber = String.valueOf(calculator.divide(Integer.parseInt(subNumber), Integer.parseInt(mainNumber)));
                            }
                            textNumber.setText(mainNumber);
                            subNumber = "";
                            textSubNumber.setText(subNumber);
                            break;
                    }
                    break;
                case R.id.buttonC:
                    mainNumber = "";
                    subNumber = "";
                    textNumber.setText("0");
                    textSubNumber.setText(subNumber);
                    break;

            }
        }
    };


}