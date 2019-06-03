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

public class AdvancedCalc extends AppCompatActivity {

    Button button0 , button1 , button2 , button3 , button4 , button5 , button6 ,
            button7 , button8 , button9 , buttonAdd , buttonSub , buttonDivision ,
            buttonMul ,  buttonC,buttonAC , buttonComa ,  buttonEqual, buttonPM, tangBtn, powPowBtn, pow2Btn, sinBtn, cosBtn, lnBtn, logBtn, percentBtn, sqrtBtn;
    ImageButton deleteButton, backButton;
    EditText resultBar ;
    String result;
    boolean zeroFlag, dotFlag, minusFlag, digitAfterEqualFlag, cFlag;
    DigitsNOperatorsLists digitsNOperatorsLists;
    MathematicOperations mathematicOperations;
    DisplaingNumberExceptions displaingNumberExceptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_calc);

        digitsNOperatorsLists = new DigitsNOperatorsLists();
        zeroFlag=true;
        dotFlag = true;
        minusFlag = false;
        digitAfterEqualFlag = false;
        cFlag = true;
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
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonAC = (Button) findViewById(R.id.buttonAC);
        buttonEqual = (Button) findViewById(R.id.buttonResult);
        resultBar = (EditText) findViewById(R.id.resultBar);
        deleteButton = (ImageButton) findViewById(R.id.deleteButton);
        buttonPM = (Button) findViewById(R.id.buttonPM);
        backButton = (ImageButton) findViewById(R.id.backButton);
        tangBtn = (Button) findViewById(R.id.buttonTan);
        sinBtn = (Button) findViewById(R.id.buttonSin);
        cosBtn = (Button) findViewById(R.id.buttonCos);
        logBtn = (Button) findViewById(R.id.buttonLog);
        lnBtn = (Button) findViewById(R.id.buttonLn);
        sqrtBtn = (Button) findViewById(R.id.buttonSqrt);
        pow2Btn = (Button) findViewById(R.id.buttonPow2);
        powPowBtn = (Button) findViewById(R.id.buttonPowPow);
        percentBtn = (Button) findViewById(R.id.buttonPerc);


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
                    digitAfterEqualFlag = true;
                    minusFlag=false;
                    dotFlag=true;
                }
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
                        dotFlag=true;
                        cFlag = true;
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
        resultBar.setKeyListener(null);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.example.kuba.calculator.Menu.class);
                startActivity(intent);
            }
        });

        sinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                if(mathematicOperations.operatorAtStart()) {
                    Toast.makeText(getApplicationContext(), "Wrong format!", Toast.LENGTH_SHORT).show();
                }else if(mathematicOperations.operatorAtTheEndException()){
                    Toast.makeText(getApplicationContext(), "Wrong format!", Toast.LENGTH_SHORT).show();
                }else {
                    resultBar.setText(mathematicOperations.sinus());
                    digitAfterEqualFlag = true;
                }
            }
        });

        cosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                if(mathematicOperations.operatorAtStart()) {
                    Toast.makeText(getApplicationContext(), "Wrong format!", Toast.LENGTH_SHORT).show();
                }else if(mathematicOperations.operatorAtTheEndException()){
                    Toast.makeText(getApplicationContext(), "Wrong format!", Toast.LENGTH_SHORT).show();
                }else {
                    resultBar.setText(mathematicOperations.cosiunus());
                    digitAfterEqualFlag = true;
                }
            }
        });
        tangBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                if(mathematicOperations.operatorAtStart()) {
                    Toast.makeText(getApplicationContext(), "Wrong format!", Toast.LENGTH_SHORT).show();
                }else if(mathematicOperations.operatorAtTheEndException()){
                    Toast.makeText(getApplicationContext(), "Wrong format!", Toast.LENGTH_SHORT).show();
                }else {
                    resultBar.setText(mathematicOperations.tangens());
                    digitAfterEqualFlag = true;
                }
            }
        });
        sqrtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                if(mathematicOperations.operatorAtStart()) {
                    Toast.makeText(getApplicationContext(),"value less than 0", Toast.LENGTH_SHORT).show();
                }else if(mathematicOperations.operatorAtTheEndException()){
                    Toast.makeText(getApplicationContext(), "Wrong format!", Toast.LENGTH_SHORT).show();
                }else if(!mathematicOperations.biggerThanZero()){
                    Toast.makeText(getApplicationContext(), "Wrong format!", Toast.LENGTH_SHORT).show();
                } else {
                    resultBar.setText(mathematicOperations.square());
                    digitAfterEqualFlag = true;
                }
            }
        });
        lnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                if(mathematicOperations.operatorAtStart()) {
                    Toast.makeText(getApplicationContext(),"value less than 0", Toast.LENGTH_SHORT).show();
                }else if(mathematicOperations.operatorAtTheEndException()){
                    Toast.makeText(getApplicationContext(), "Wrong format!", Toast.LENGTH_SHORT).show();
                }else if(!mathematicOperations.biggerThanZero()){
                    Toast.makeText(getApplicationContext(), "Wrong format!", Toast.LENGTH_SHORT).show();
                } else {
                    resultBar.setText(mathematicOperations.logNat());
                    digitAfterEqualFlag = true;
                }
            }
        });
        pow2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                if(mathematicOperations.operatorAtStart()) {
                    Toast.makeText(getApplicationContext(), "Wrong format!", Toast.LENGTH_SHORT).show();
                }else if(mathematicOperations.operatorAtTheEndException()){
                    Toast.makeText(getApplicationContext(), "Wrong format!", Toast.LENGTH_SHORT).show();
                }else {
                    resultBar.setText(mathematicOperations.power());
                    digitAfterEqualFlag = true;
                }
            }
        });

        powPowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOperandToList("^");
            }
        });

        percentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOperandToList("%");
            }
        });

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mathematicOperations.operatorAtStart()) {
                    Toast.makeText(getApplicationContext(),"value less than 0", Toast.LENGTH_SHORT).show();
                }else if(mathematicOperations.operatorAtTheEndException()){
                    Toast.makeText(getApplicationContext(), "Wrong format!", Toast.LENGTH_SHORT).show();
                }else if(!mathematicOperations.biggerThanZero()){
                    Toast.makeText(getApplicationContext(), "Wrong format!", Toast.LENGTH_SHORT).show();
                } else {
                    resultBar.setText(mathematicOperations.log());
                    digitAfterEqualFlag = true;
                }
            }
        });
    }

    void addDigitToList(String mark){
        vibrate();
        if(!minusFlag && !digitAfterEqualFlag) {
            resultBar.setText(resultBar.getText() + mark);
            digitsNOperatorsLists.addOperatorList(mark);
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
        }
        dotFlag=true;
        minusFlag=false;
        digitAfterEqualFlag = false;
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
