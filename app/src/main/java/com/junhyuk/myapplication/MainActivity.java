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
    private void addMainNum(int num){
        if(mainNumber.equals("0") || mainNumber.equals(""))
            mainNumber = String.valueOf(num);
        else
            mainNumber += String.valueOf(num);
    }
    void updateMainNumber(){
        textNumber.setText(mainNumber);
    }
    private void updateSubNumber(){
        textSubNumber.setText(subNumber);
    }
    private void resetMainNumber(){
        mainNumber = "0";
        updateMainNumber();
    }
    private void resetSubNumber(){
        subNumber = "";
        updateSubNumber();
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Calculator calculator = new Calculator();
            switch (view.getId()) {
                case R.id.button0:
                    addMainNum(0);
                    updateMainNumber();
                    break;
                case R.id.button1:
                    addMainNum(1);
                    updateMainNumber();
                    break;
                case R.id.button2:
                    addMainNum(2);
                    updateMainNumber();
                    break;
                case R.id.button3:
                    addMainNum(3);
                    updateMainNumber();
                    break;
                case R.id.button4:
                    addMainNum(4);
                    updateMainNumber();
                    break;
                case R.id.button5:
                    addMainNum(5);
                    updateMainNumber();
                    break;
                case R.id.button6:
                    addMainNum(6);
                    updateMainNumber();
                    break;
                case R.id.button7:
                    addMainNum(7);
                    updateMainNumber();
                    break;
                case R.id.button8:
                    addMainNum(8);
                    updateMainNumber();
                    break;
                case R.id.button9:
                    addMainNum(9);
                    updateMainNumber();
                    break;
                case R.id.button_plus:
                    subNumber = mainNumber;
                    updateSubNumber();
                    resetMainNumber();
                    Log.d("data2", "data: " + subNumber);
                    checkCalculate = 0;
                    break;
                case R.id.button_minus:
                    subNumber = mainNumber;
                    updateSubNumber();
                    resetMainNumber();
                    checkCalculate = 1;
                    break;
                case R.id.button_multiple:
                    subNumber = mainNumber;
                    updateSubNumber();
                    resetMainNumber();
                    checkCalculate = 2;
                    break;
                case R.id.button_div:
                    subNumber = mainNumber;
                    updateSubNumber();
                    resetMainNumber();
                    checkCalculate = 3;
                    break;
                case R.id.button_equals:
                    int mainNum = Integer.parseInt(mainNumber);
                    int subNum = Integer.parseInt(subNumber);
                    switch (checkCalculate){
                        case 0:
                            mainNumber = String.valueOf(calculator.plus(mainNum, subNum));
                            updateMainNumber();
                            resetSubNumber();
                            break;
                        case 1:
                            if(mainNum > subNum){
                                mainNumber = String.valueOf(calculator.minus(mainNum, subNum));
                            }else{
                                mainNumber = String.valueOf(calculator.minus(subNum, mainNum));
                            }
                            updateMainNumber();
                            resetSubNumber();
                            break;
                        case 2:
                            mainNumber = String.valueOf(calculator.multiple(mainNum, subNum));
                            updateMainNumber();
                            resetSubNumber();
                            break;
                        case 3:
                            if(mainNum > subNum){
                                mainNumber = String.valueOf(calculator.divide(mainNum, subNum));
                            }else{
                                mainNumber = String.valueOf(calculator.divide(subNum, mainNum));
                            }
                            updateMainNumber();
                            resetSubNumber();
                            break;
                    }
                    break;
                case R.id.buttonC:
                    resetMainNumber();
                    resetSubNumber();
                    break;

            }
        }
    };


}