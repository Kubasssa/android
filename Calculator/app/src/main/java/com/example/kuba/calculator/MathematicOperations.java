package com.example.kuba.calculator;

import android.content.Context;
import android.os.Vibrator;
import android.widget.Toast;

import java.util.List;

import static android.telephony.PhoneNumberUtils.compare;

public class MathematicOperations {

    public MathematicOperations() {

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

    void connectDigits(List<Double> numberList, int numberOfDigits, boolean comaFlag){
        int tmp=0;
        String comaTmp;

        if(comaFlag){
            tmp = (numberList.get(numberOfDigits-2).intValue());
            comaTmp = Integer.toString(tmp)+ ".";
            numberList.set(numberOfDigits-2, (Double.parseDouble(comaTmp + numberList.get(numberOfDigits-1).toString())));
            numberList.remove(numberOfDigits-1);
        }else {
            tmp = (numberList.get(numberOfDigits - 2).intValue());
            numberList.set(numberOfDigits - 2, (Double.parseDouble(Integer.toString(tmp) + numberList.get(numberOfDigits - 1).toString())));
            numberList.remove(numberOfDigits - 1);
        }
        //TODO coma things...;
    }

    void removeLastDigit(List<String> operatorList, List<Double> numberList, int numberOfDigits){

    }
}
