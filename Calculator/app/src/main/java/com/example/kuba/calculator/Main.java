package com.example.kuba.calculator;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

import static android.telephony.PhoneNumberUtils.compare;

public class Main extends AppCompatActivity {

    Button button0 , button1 , button2 , button3 , button4 , button5 , button6 ,
            button7 , button8 , button9 , buttonAdd , buttonSub , buttonDivision ,
            buttonMul , buttonBrackets , buttonModulo,  buttonC , buttonComa ,  buttonEqual;
    ImageButton deleteButton;
    EditText resultBar ;

    float mValueOne , mValueTwo;
    double result;
    List<Double> numberList;
    List<String> operatorList;
    int numberOfDigits;
    boolean mAddition , mSubtract ,mMultiplication ,mDivision, isOperator ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberList = new ArrayList();
        operatorList = new ArrayList<>();
        numberOfDigits =0;
        result=0;
        isOperator = true;

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonComa = (Button) findViewById(R.id.buttonComa);
        buttonAdd = (Button) findViewById(R.id.buttonPlus);
        buttonSub = (Button) findViewById(R.id.buttonMinus);
        buttonMul = (Button) findViewById(R.id.buttonMultiply);
        buttonDivision = (Button) findViewById(R.id.buttonDevide);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonEqual = (Button) findViewById(R.id.buttonResult);
        buttonBrackets = (Button) findViewById(R.id.buttonBrackets);
        buttonModulo = (Button) findViewById(R.id.buttonModulo);
        resultBar = (EditText) findViewById(R.id.resultBar);
        deleteButton = (ImageButton) findViewById(R.id.deleteButton);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "1");
                numberList.add(1.0);
                numberOfDigits++;
                if(!isOperator){connectDigits();}
                isOperator=false;
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "2");
                numberList.add(2.0);
                numberOfDigits++;
                if(!isOperator){connectDigits();}
                isOperator=false;
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "3");
                numberList.add(3.0);
                numberOfDigits++;
                if(!isOperator){connectDigits();}
                isOperator=false;
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "4");
                numberList.add(4.0);
                numberOfDigits++;
                if(!isOperator){connectDigits();}
                isOperator=false;
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "5");
                numberList.add(5.0);
                numberOfDigits++;
                if(!isOperator){connectDigits();}
                isOperator=false;
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "6");
                numberList.add(6.0);
                numberOfDigits++;
                if(!isOperator){connectDigits();}
                isOperator=false;
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "7");
                numberList.add(7.0);
                numberOfDigits++;
                if(!isOperator){connectDigits();}
                isOperator=false;
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "8");
                numberList.add(8.0);
                numberOfDigits++;
                if(!isOperator){connectDigits();}
                isOperator=false;
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "9");
                numberList.add(9.0);
                numberOfDigits++;
                if(!isOperator){connectDigits();}
                isOperator=false;
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "0");
                numberList.add(0.0);
                numberOfDigits++;
                if(!isOperator){connectDigits();}
                isOperator=false;
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (resultBar == null) {
                    resultBar.setText("");
                } else {
                    vibrate();
//                    mValueOne = Float.parseFloat(resultBar.getText() + "");
                    mAddition = true;
                    resultBar.setText(resultBar.getText() +"+");
                    operatorList.add("+");
                    isOperator=true;
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
//                mValueOne = Float.parseFloat(resultBar.getText() + "");
                mSubtract = true;
                resultBar.setText(resultBar.getText() +"-");
                operatorList.add("-");
                isOperator=true;
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
//                mValueOne = Float.parseFloat(resultBar.getText() + "");
                mMultiplication = true;
                resultBar.setText(resultBar.getText() +"*");
                operatorList.add("*");
                isOperator=true;
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
//                mValueOne = Float.parseFloat(resultBar.getText() + "");
                mDivision = true;
                resultBar.setText(resultBar.getText() +"/");
                operatorList.add("/");
                isOperator=true;
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(numberList);
                System.out.println(operatorList);
                System.out.println(numberOfDigits);
                vibrate();
                result = calculations(operatorList, numberList);
                resultBar.setText(Double.toString(result));
                operatorList.clear();
                numberList.clear();
                isOperator=true;
                numberOfDigits=0;
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(null);
                operatorList.clear();
                numberList.clear();
                isOperator=true;
                numberOfDigits=0;
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numberOfDigits!=0) {
                    vibrate();
                    resultBar.setText(null);
                    numberList.remove(numberList.size() - 1);
                    isOperator = true;
                    numberOfDigits--;
                }
            }
        });
    }


    double calculations(List<String> operatorList, List<Double> numberList){
        //TODO return result in list after push equalButton
        int listIterator = 0;
        listIterator = operatorList.size();
        double Result=0;

        while(listIterator!=0){
            for(int i=0;i<operatorList.size();i++){
                if(operatorList.get(i).equals("*")){
                    numberList.set(i,(numberList.get(i) * numberList.get(i+1)));
                    numberList.set(i+1,numberList.get(i));
                    operatorList.set(i,null);
                    listIterator--;
                    Result = numberList.get(i);
                }else if (operatorList.get(i).equals("/")){
                    numberList.set(i,(numberList.get(i) / numberList.get(i+1)));
                    numberList.set(i+1,numberList.get(i));
                    operatorList.set(i,null);
                    listIterator--;
                    Result = numberList.get(i);
                }
            }

            if(listIterator==0){
                Result*=10000000;
                Result = Math.round(Result);
                Result/=10000000;
                return Result;
            }

            for(int i=0;i<operatorList.size();i++){
                if(compare("+",operatorList.get(i))){
                    numberList.set(i,(numberList.get(i) + numberList.get(i+1)));
                    numberList.set(i+1,numberList.get(i));
                    operatorList.set(i,null);
                    listIterator--;
                    Result = numberList.get(i);
                }else if (compare("-",operatorList.get(i))){
                    numberList.set(i,(numberList.get(i) - numberList.get(i+1)));
                    numberList.set(i+1,numberList.get(i));
                    operatorList.set(i,null);
                    listIterator--;
                    Result = numberList.get(i);
                }
            }
        }

        Result*=10000000;
        Result = Math.round(Result);
        Result/=10000000;
        return Result;
    }

    void vibrate(){
        Vibrator vb = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vb.vibrate(5);
    }

    void connectDigits(){
        int tmp=0;
        System.out.println(numberList);
        tmp = (numberList.get(numberOfDigits-2).intValue());
        System.out.println(tmp);
        numberList.set(numberOfDigits-2, (Double.parseDouble(Integer.toString(tmp)+ numberList.get(numberOfDigits-1).toString())));
        numberList.remove(numberOfDigits-1);
        numberOfDigits--;
    }


}