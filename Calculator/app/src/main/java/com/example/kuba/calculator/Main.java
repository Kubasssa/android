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
import android.widget.Toast;

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

    double result;
    boolean mAddition , mSubtract ,mMultiplication ,mDivision, isOperator, comaFlag ;
    DigitsNOperatorsLists digitsNOperatorsLists;
    MathematicOperations mathematicOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        digitsNOperatorsLists = new DigitsNOperatorsLists();
        mathematicOperations = new MathematicOperations();

        result=0;
        isOperator = true;
        comaFlag=false;

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
                digitsNOperatorsLists.addNumberList(1.0);
                digitsNOperatorsLists.incrementNumberOfDigits();
                if(!isOperator){
                    mathematicOperations.connectDigits(digitsNOperatorsLists.numberList, digitsNOperatorsLists.numberOfDigits,comaFlag);
                    digitsNOperatorsLists.decrementNumberOfDigits();
                }
                isOperator=false;
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "2");
                digitsNOperatorsLists.addNumberList(2.0);
                digitsNOperatorsLists.incrementNumberOfDigits();
                if(!isOperator){
                    mathematicOperations.connectDigits(digitsNOperatorsLists.numberList, digitsNOperatorsLists.numberOfDigits,comaFlag);
                    digitsNOperatorsLists.decrementNumberOfDigits();
                }
                isOperator=false;
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "3");
                digitsNOperatorsLists.addNumberList(3.0);
                digitsNOperatorsLists.incrementNumberOfDigits();
                if(!isOperator){
                    mathematicOperations.connectDigits(digitsNOperatorsLists.numberList, digitsNOperatorsLists.numberOfDigits,comaFlag);
                    digitsNOperatorsLists.decrementNumberOfDigits();
                }
                isOperator=false;
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "4");
                digitsNOperatorsLists.addNumberList(4.0);
                digitsNOperatorsLists.incrementNumberOfDigits();
                if(!isOperator){
                    mathematicOperations.connectDigits(digitsNOperatorsLists.numberList, digitsNOperatorsLists.numberOfDigits,comaFlag);
                    digitsNOperatorsLists.decrementNumberOfDigits();
                }
                isOperator=false;
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "5");
                digitsNOperatorsLists.addNumberList(5.0);
                digitsNOperatorsLists.incrementNumberOfDigits();
                if(!isOperator){
                    mathematicOperations.connectDigits(digitsNOperatorsLists.numberList, digitsNOperatorsLists.numberOfDigits,comaFlag);
                    digitsNOperatorsLists.decrementNumberOfDigits();
                }
                isOperator=false;
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "6");
                digitsNOperatorsLists.addNumberList(6.0);
                digitsNOperatorsLists.incrementNumberOfDigits();
                if(!isOperator){
                    mathematicOperations.connectDigits(digitsNOperatorsLists.numberList, digitsNOperatorsLists.numberOfDigits,comaFlag);
                    digitsNOperatorsLists.decrementNumberOfDigits();
                }
                isOperator=false;
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "7");
                digitsNOperatorsLists.addNumberList(7.0);
                digitsNOperatorsLists.incrementNumberOfDigits();
                if(!isOperator){
                    mathematicOperations.connectDigits(digitsNOperatorsLists.numberList, digitsNOperatorsLists.numberOfDigits,comaFlag);
                    digitsNOperatorsLists.decrementNumberOfDigits();
                }
                isOperator=false;
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "8");
                digitsNOperatorsLists.addNumberList(8.0);
                digitsNOperatorsLists.incrementNumberOfDigits();
                if(!isOperator){
                    mathematicOperations.connectDigits(digitsNOperatorsLists.numberList, digitsNOperatorsLists.numberOfDigits,comaFlag);
                    digitsNOperatorsLists.decrementNumberOfDigits();
                }
                isOperator=false;
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "9");
                digitsNOperatorsLists.addNumberList(9.0);
                digitsNOperatorsLists.incrementNumberOfDigits();
                if(!isOperator){
                    mathematicOperations.connectDigits(digitsNOperatorsLists.numberList, digitsNOperatorsLists.numberOfDigits,comaFlag);
                    digitsNOperatorsLists.decrementNumberOfDigits();
                }
                isOperator=false;
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "0");
                digitsNOperatorsLists.addNumberList(0.0);
                digitsNOperatorsLists.incrementNumberOfDigits();
                if(!isOperator){
                    mathematicOperations.connectDigits(digitsNOperatorsLists.numberList, digitsNOperatorsLists.numberOfDigits,comaFlag);
                    digitsNOperatorsLists.decrementNumberOfDigits();
                }
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
                    digitsNOperatorsLists.addOperatorList("+");
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
                digitsNOperatorsLists.addOperatorList("-");
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
                digitsNOperatorsLists.addOperatorList("*");
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
                digitsNOperatorsLists.addOperatorList("/");
                isOperator=true;
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                if(digitsNOperatorsLists.operatorList.size()>=digitsNOperatorsLists.numberList.size()){
                    Toast.makeText(getApplicationContext(),"Wrong format!", Toast.LENGTH_SHORT).show();
                }else {
                    result = mathematicOperations.calculations(digitsNOperatorsLists.operatorList, digitsNOperatorsLists.numberList);
                    resultBar.setText(Double.toString(result));
                    digitsNOperatorsLists.clearOperatorList();
                    digitsNOperatorsLists.clearNumberList();
                    isOperator = true;
                    digitsNOperatorsLists.resetNumberOfDigits();
                }
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(null);
                digitsNOperatorsLists.clearOperatorList();
                digitsNOperatorsLists.clearNumberList();
                isOperator=true;
                digitsNOperatorsLists.resetNumberOfDigits();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(digitsNOperatorsLists.numberOfDigits!=0) {
                    vibrate();
                    resultBar.setText(null);
                    digitsNOperatorsLists.removeLastNumberListElement();
                    isOperator = true;
                    digitsNOperatorsLists.decrementNumberOfDigits();
                }
            }
        });
        buttonComa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText()+",");
                isOperator=false;
                comaFlag=true;
            }
        });
        buttonBrackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                Toast.makeText(getApplicationContext(),"work in progres...", Toast.LENGTH_SHORT).show();
            }
        });
        buttonModulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                Toast.makeText(getApplicationContext(),"work in progres...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void vibrate(){
        Vibrator vb = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vb.vibrate(5);
    }


}