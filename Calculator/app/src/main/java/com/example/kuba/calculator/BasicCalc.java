package com.example.kuba.calculator;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.math.BigDecimal;

import static android.telephony.PhoneNumberUtils.compare;

public class BasicCalc extends AppCompatActivity {

    Button button0 , button1 , button2 , button3 , button4 , button5 , button6 ,
            button7 , button8 , button9 , buttonAdd , buttonSub , buttonDivision ,
            buttonMul , buttonPerc,  buttonC, buttonAC , buttonComa ,  buttonEqual, buttonPM;
    ImageButton deleteButton, backButton;
    EditText resultBar ;
    String result;
    boolean zeroFlag, dotFlag, minusFlag, digitAfterEqualFlag,cFlag, firstZeroFlag;
    DigitsNOperatorsLists digitsNOperatorsLists;
    MathematicOperations mathematicOperations;
    DisplaingNumberExceptions displaingNumberExceptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        digitsNOperatorsLists = new DigitsNOperatorsLists();
        zeroFlag=true;
        dotFlag = true;
        minusFlag = false;
        digitAfterEqualFlag = false;
        cFlag = true;
        firstZeroFlag = true;
        result="";

        if (savedInstanceState != null) {
            digitsNOperatorsLists.operatorList = savedInstanceState.getStringArrayList("operatorList");
            System.out.println(digitsNOperatorsLists.getOperatorList());
//            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }

        mathematicOperations = new MathematicOperations(digitsNOperatorsLists.operatorList);
        displaingNumberExceptions = new DisplaingNumberExceptions(digitsNOperatorsLists,mathematicOperations);

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
        buttonC = (Button) findViewById(R.id.buttonTan);
        buttonAC = (Button) findViewById(R.id.buttonAC);
        buttonEqual = (Button) findViewById(R.id.buttonResult);
        resultBar = (EditText) findViewById(R.id.resultBar);
        deleteButton = (ImageButton) findViewById(R.id.deleteButton);
        buttonPM = (Button) findViewById(R.id.buttonPM);
        backButton = (ImageButton) findViewById(R.id.backButton);
        buttonPerc = (Button) findViewById(R.id.buttonPowPow);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigitToList("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigitToList("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigitToList("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigitToList("4");

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigitToList("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigitToList("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigitToList("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigitToList("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigitToList("9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                if(resultBar.getText().toString().equals("0")){
                    System.out.println("multiZero");
                }else {
                    addDigitToList("0");
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOperandToList("+");
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOperandToList("-");
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOperandToList("*");
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOperandToList("/");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                if(mathematicOperations.operatorAtStart()||mathematicOperations.operatorAtTheEndException()) {
                    Toast.makeText(getApplicationContext(), "Wrong format!", Toast.LENGTH_SHORT).show();
                }else if(mathematicOperations.checkIfDevideByZero()) {
                    Toast.makeText(getApplicationContext(), "Devide by Zero!", Toast.LENGTH_SHORT).show();
                }else {
                    double finalResult = Math.round(Double.parseDouble(mathematicOperations.calculation()) * 10000.0) / 10000.0;
                    resultBar.setText(displaingNumberExceptions.cutZeroFromInt(Double.toString(finalResult)));

//                    double big = 0.33333333333333;
//                    double roundOff = Math.round(big * 100.0) / 100.0;
//                    System.out.println(roundOff);

                    digitAfterEqualFlag = true;
                    minusFlag=false;
                    cFlag = true;
                }
//                digitsNOperatorsLists.clearOperatorList();

            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                if(!digitsNOperatorsLists.operatorList.isEmpty()) {
                    if (cFlag) {
                        mathematicOperations.removeOneElement();
                        resultBar.setText(digitsNOperatorsLists.convertToString());
                        minusFlag = false;
                        digitAfterEqualFlag = false;
                        dotFlag=true;
                        cFlag = false;
                    } else {
                        resultBar.setText(null);
                        digitsNOperatorsLists.clearOperatorList();
                        digitAfterEqualFlag = false;
                        minusFlag = false;
                        cFlag = true;
                        dotFlag = true;
                    }
                }
            }
        });
        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                resultBar.setText(null);
                digitsNOperatorsLists.clearOperatorList();
                digitAfterEqualFlag = false;
                minusFlag=false;
                dotFlag = true;
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                if(digitsNOperatorsLists.operatorList.size()!=0) {
                    mathematicOperations.removeOneElement();
                    resultBar.setText(digitsNOperatorsLists.convertToString());
                }
            }
        });
        buttonComa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dotFlag && !mathematicOperations.onlyDot()) {
                    addDigitToList(".");
                    dotFlag = false;
                }else {
                    Toast.makeText(getApplicationContext(),"Wrong format!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                if(mathematicOperations.operatorAtStart()) {
                    Toast.makeText(getApplicationContext(),"Wrong format!", Toast.LENGTH_SHORT).show();
                }else if (mathematicOperations.negativAfterOperator()){
                    Toast.makeText(getApplicationContext(),"Wrong format!", Toast.LENGTH_SHORT).show();
                } else {
                    mathematicOperations.negativNuber();
                    resultBar.setText(displaingNumberExceptions.showingMinusOnDisplay());
                    minusFlag=true;
                }
            }
        });

        buttonPerc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                addOperandToList("%");
            }
        });

        resultBar.setKeyListener(null);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.example.kuba.calculator.Menu.class);
                startActivity(intent);
            }
        });
    }

    void addDigitToList(String mark){
        vibrate();
        if(!minusFlag && !digitAfterEqualFlag) {
            if(digitsNOperatorsLists.operatorList.size() == 1) {
                if(digitsNOperatorsLists.operatorList.get(0) != "0" )
                resultBar.setText(resultBar.getText() + mark);
                digitsNOperatorsLists.addOperatorList(mark);
            }else{
                resultBar.setText(resultBar.getText() + mark);
                digitsNOperatorsLists.addOperatorList(mark);
            }
        }
    }

    void addOperandToList(String mark){
        vibrate();
        if (mathematicOperations.operatorAtStart()) {
            Toast.makeText(getApplicationContext(),"Wrong format!", Toast.LENGTH_SHORT).show();
        } else {
            digitsNOperatorsLists.addOperatorList(mark);
            mathematicOperations.moreThanOneOperatorException();
            resultBar.setText(digitsNOperatorsLists.convertToString());

            dotFlag=true;
            minusFlag =  false;
            digitAfterEqualFlag = false;
        }
    }

    void vibrate(){
        Vibrator vb = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vb.vibrate(5);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Make sure to call the super method so that the states of our views are saved
        outState.putStringArrayList("operatorList", digitsNOperatorsLists.operatorList);

        super.onSaveInstanceState(outState);
        // Save our own state now
//        outState.putSerializable(STATE_ITEMS, outState);
    }


}