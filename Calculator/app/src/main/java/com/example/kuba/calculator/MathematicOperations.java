package com.example.kuba.calculator;

import android.content.Context;
import android.os.Vibrator;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static android.telephony.PhoneNumberUtils.compare;

public class MathematicOperations {
    List<String> listOfNumbers;
    public MathematicOperations(List<String> listOfNumbers) {
       this.listOfNumbers = listOfNumbers;
    }

    String calculation(){
        connectDigits();
        System.out.println(listOfNumbers);
        while(listOfNumbers.size()!=1){
            listOfNumbers = subCalculation();
        }

        String finalResult = Double.toString(Math.round(Double.parseDouble(listOfNumbers.get(0)) * 10000.0) / 10000.0);
        listOfNumbers.set(0,finalResult);

        return listOfNumbers.get(0);

    }

    List<String> subCalculation(){
        for(int i=0;i<listOfNumbers.size();i++){
            if(listOfNumbers.get(i).equals("*")||listOfNumbers.get(i).equals("/")||listOfNumbers.get(i).equals("+")||listOfNumbers.get(i).equals("-")||listOfNumbers.get(i).equals("^")||listOfNumbers.get(i).equals("%")) {
                listOfNumbers = operatorFunction( i, listOfNumbers.get(i));
                i--;
            }
        }
        return listOfNumbers;
    }


    List<String> operatorFunction ( int i, String operationMark) {
        double tmp=0;

        switch (operationMark){
            case "*":
                tmp = Double.parseDouble(listOfNumbers.get(i - 1)) * Double.parseDouble(listOfNumbers.get(i + 1));
                break;
            case "/":
                tmp = Double.parseDouble(listOfNumbers.get(i - 1)) / Double.parseDouble(listOfNumbers.get(i + 1));
                break;
            case "+":
                tmp = Double.parseDouble(listOfNumbers.get(i - 1)) + Double.parseDouble(listOfNumbers.get(i + 1));
                break;
            case "-":
                tmp = Double.parseDouble(listOfNumbers.get(i - 1)) - Double.parseDouble(listOfNumbers.get(i + 1));
                break;
            case "^":
                tmp = Math.pow(Double.parseDouble(listOfNumbers.get(i - 1)) , Double.parseDouble(listOfNumbers.get(i + 1)) );
                break;
            case "%":
                tmp = (Double.parseDouble(listOfNumbers.get(i - 1))/100) * Double.parseDouble(listOfNumbers.get(i + 1));
                break;
        }

        listOfNumbers.set(i - 1, Double.toString(tmp));
        listOfNumbers.remove(i + 1);
        listOfNumbers.remove(i);

        return listOfNumbers;
    }

    String sinus(){
        Double result = Math.sin(Math.toRadians(Double.parseDouble(calculation())));
        listOfNumbers.set(0, Double.toString(result));
        BigDecimal finalResult = new BigDecimal(result);
        return finalResult.toString();
    }

    String cosiunus(){
        Double result = Math.cos(Math.toRadians(Double.parseDouble(calculation())));
        listOfNumbers.set(0, Double.toString(result));
        BigDecimal finalResult = new BigDecimal(result);
        return finalResult.toString();
    }

    String tangens(){
        Double result = Math.tan(Math.toRadians(Double.parseDouble(calculation())));
        listOfNumbers.set(0, Double.toString(result));
        BigDecimal finalResult = new BigDecimal(result);
        return finalResult.toString();
    }

    String log(){
        Double result = Math.log10(Math.toRadians(Double.parseDouble(calculation())));
        listOfNumbers.set(0, Double.toString(result));
        BigDecimal finalResult = new BigDecimal(result);
        return finalResult.toString();
    }

    String logNat(){
        Double result = Math.log(Double.parseDouble(calculation()));
        listOfNumbers.set(0, Double.toString(result));
        BigDecimal finalResult = new BigDecimal(result);
        return finalResult.toString();
    }

    String square(){
        Double result = Math.sqrt(Double.parseDouble(calculation()));
        listOfNumbers.set(0, Double.toString(result));
        BigDecimal finalResult = new BigDecimal(result);
        return finalResult.toString();
    }

    String power(){
        Double result = Math.pow(Double.parseDouble(calculation()),2);
        listOfNumbers.set(0, Double.toString(result));
        BigDecimal finalResult = new BigDecimal(result);
        return finalResult.toString();
    }

    boolean biggerThanZero(){
        boolean result = true;

        Double tmp = Double.parseDouble(calculation());
        if(tmp < 0) result = false;

        return result;
    }

    List<String> connectDigits(){
        String tmpDigit="";
        int firstNumberIterator =0;
        for (int i=0;i<listOfNumbers.size();i++){
            if(listOfNumbers.get(i).matches("0|1|2|3|4|5|6|7|8|9")||listOfNumbers.get(i).equals(".")){

                tmpDigit += listOfNumbers.get(i);

                if(tmpDigit.length()>1){
                    listOfNumbers.remove(i);
                    listOfNumbers.set(firstNumberIterator,tmpDigit);
                    i--;
                }else{firstNumberIterator = i;}
            }else{tmpDigit="";firstNumberIterator = 0;}
        }
        return listOfNumbers;
    }


    boolean operatorAtTheEndException(){
        int lastElement = listOfNumbers.size()-1;
        boolean x = false;
        if(listOfNumbers.get(lastElement).equals("+")||listOfNumbers.get(lastElement).equals("-")||listOfNumbers.get(lastElement).equals("*")||listOfNumbers.get(lastElement).equals("/") ||listOfNumbers.get(lastElement).equals("^")||listOfNumbers.get(lastElement).equals("%")){
            x=true;
        }
        return x;
    }

    void moreThanOneOperatorException(){
        int lastElement = listOfNumbers.size()-1;
        int secondLastElement = listOfNumbers.size()-2;
        List<String> tmpList = new ArrayList<>();
        tmpList.add("+");
        tmpList.add("-");
        tmpList.add("*");
        tmpList.add("/");
        tmpList.add("^");
        tmpList.add("%");

        if(tmpList.contains(listOfNumbers.get(lastElement))&&tmpList.contains(listOfNumbers.get(secondLastElement))){
            listOfNumbers.set(secondLastElement,listOfNumbers.get(lastElement));
            listOfNumbers.remove(lastElement);
        }
    }

    boolean operatorAtStart(){
        boolean tmp = false;
        if(listOfNumbers.isEmpty()){
            tmp = true;
        }
        return tmp;
    }

    void negativNuber(){
        connectDigits();
        double tmp = Double.parseDouble(listOfNumbers.get(listOfNumbers.size()-1));
        tmp = tmp*(-1);
        listOfNumbers.set(listOfNumbers.size()-1,Double.toString(tmp));
    }

    boolean negativAfterOperator(){
        boolean result = false;
        int lastElement = listOfNumbers.size()-1;
        List<String> tmpList = new ArrayList<>();
        tmpList.add("+");
        tmpList.add("-");
        tmpList.add("*");
        tmpList.add("/");
        tmpList.add("^");

        if(tmpList.contains(listOfNumbers.get(lastElement))){
            result = true;
        }
        return result;
    }

    void removeOneElement(){
        connectDigits();
        listOfNumbers.remove(listOfNumbers.size()-1);
    }

    boolean checkIfDevideByZero(){
        boolean result=false;
        connectDigits();
        for(int i=0;i<listOfNumbers.size();i++){
            if(listOfNumbers.get(i).equals("/")&&listOfNumbers.get(i+1).equals("0")) {
                result=true;
            }
        }
        return result;
    }

    boolean onlyDot(){
        boolean result=false;
        List<String> tmpList = new ArrayList<>();
        tmpList.add("0");
        tmpList.add("1");
        tmpList.add("2");
        tmpList.add("3");
        tmpList.add("4");
        tmpList.add("5");
        tmpList.add("6");
        tmpList.add("7");
        tmpList.add("8");
        tmpList.add("9");
//        System.out.println(listOfNumbers);
        if (listOfNumbers.isEmpty()||!tmpList.contains(listOfNumbers.get(listOfNumbers.size()-1)) ) {
            result = true;
        }

        return  result;
    }

}