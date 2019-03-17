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
            buttonMul , buttonBrackets , buttonModulo,  buttonC , buttonComa ,  buttonEqual, buttonPM;
    ImageButton deleteButton;
    EditText resultBar ;

    String result;
    boolean zeroFlag;
    DigitsNOperatorsLists digitsNOperatorsLists;
    MathematicOperations mathematicOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        digitsNOperatorsLists = new DigitsNOperatorsLists();
        mathematicOperations = new MathematicOperations();

        zeroFlag=true;
        result="";

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
        buttonPM = (Button) findViewById(R.id.buttonPM);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "1");
                digitsNOperatorsLists.addOperatorList("1");
                digitsNOperatorsLists.incrementNumberOfDigits();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "2");
                digitsNOperatorsLists.addOperatorList("2");
                digitsNOperatorsLists.incrementNumberOfDigits();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "3");
                digitsNOperatorsLists.addOperatorList("3");
                digitsNOperatorsLists.incrementNumberOfDigits();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "4");
                digitsNOperatorsLists.addOperatorList("4");
                digitsNOperatorsLists.incrementNumberOfDigits();

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "5");
                digitsNOperatorsLists.addOperatorList("5");
                digitsNOperatorsLists.incrementNumberOfDigits();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "6");
                digitsNOperatorsLists.addOperatorList("6");
                digitsNOperatorsLists.incrementNumberOfDigits();
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "7");
                digitsNOperatorsLists.addOperatorList("7");
                digitsNOperatorsLists.incrementNumberOfDigits();
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "8");
                digitsNOperatorsLists.addOperatorList("8");
                digitsNOperatorsLists.incrementNumberOfDigits();
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() + "9");
                digitsNOperatorsLists.addOperatorList("9");
                digitsNOperatorsLists.incrementNumberOfDigits();
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                if(resultBar.getText().toString().equals("0")){
                    System.out.println("multiZero");
                }else {
                    resultBar.setText(resultBar.getText() + "0");
                    digitsNOperatorsLists.addOperatorList("0");
                    digitsNOperatorsLists.incrementNumberOfDigits();
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (resultBar == null) {
                    resultBar.setText("");
                } else {
                    vibrate();
                    resultBar.setText(resultBar.getText() +"+");
                    digitsNOperatorsLists.addOperatorList("+");
                }
                mathematicOperations.moreThanOneOperatorException(digitsNOperatorsLists.operatorList);
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() +"-");
                digitsNOperatorsLists.addOperatorList("-");
                mathematicOperations.moreThanOneOperatorException(digitsNOperatorsLists.operatorList);
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() +"*");
                digitsNOperatorsLists.addOperatorList("*");
                mathematicOperations.moreThanOneOperatorException(digitsNOperatorsLists.operatorList);
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText() +"/");
                digitsNOperatorsLists.addOperatorList("/");
                mathematicOperations.moreThanOneOperatorException(digitsNOperatorsLists.operatorList);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                System.out.println(digitsNOperatorsLists.operatorList);
                if(mathematicOperations.operatorAtTheEndException(digitsNOperatorsLists.operatorList)){
                    Toast.makeText(getApplicationContext(),"Wrong format!", Toast.LENGTH_SHORT).show();
                }else {
                    result = mathematicOperations.calculation(digitsNOperatorsLists.operatorList);
                    resultBar.setText(result);
                }
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(null);
                digitsNOperatorsLists.clearOperatorList();
                digitsNOperatorsLists.resetNumberOfDigits();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(digitsNOperatorsLists.numberOfDigits!=0) {
                    vibrate();
                    resultBar.setText(null);
                    digitsNOperatorsLists.decrementNumberOfDigits();
                }
            }
        });
        buttonComa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(resultBar.getText()+",");
                digitsNOperatorsLists.addOperatorList(".");
                digitsNOperatorsLists.incrementNumberOfDigits();
            }
        });
        buttonPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                mathematicOperations.negativNuber(digitsNOperatorsLists.operatorList);
                //TODO wyświetlanie minusa przy liczbie na ekranie
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