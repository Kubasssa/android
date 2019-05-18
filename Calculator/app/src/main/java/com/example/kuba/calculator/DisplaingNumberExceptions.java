package com.example.kuba.calculator;

import java.util.ArrayList;
import java.util.List;

public class DisplaingNumberExceptions {

    DigitsNOperatorsLists digitsNOperatorsLists;
    MathematicOperations mathematicOperations;

    public DisplaingNumberExceptions(DigitsNOperatorsLists digitsNOperatorsLists, MathematicOperations mathematicOperations) {
        this.digitsNOperatorsLists = digitsNOperatorsLists;
        this.mathematicOperations = mathematicOperations;
    }

    String  showingMinusOnDisplay(){
        String returnValue="";
        int lastElement = digitsNOperatorsLists.operatorList.size()-1;
        mathematicOperations.connectDigits();
        for (int i =0;i<lastElement;i++)
        {
            returnValue += digitsNOperatorsLists.operatorList.get(i);
        }
        String tmp = digitsNOperatorsLists.operatorList.get(lastElement);
        returnValue = returnValue + "(" + tmp +")";
        return returnValue;
    }

    String cutZeroFromInt(String result){
        String checkedResult = result;
        //double convertNumber;

      //  convertNumber = Double.parseDouble(checkedResult);
//        if(!Double.isInfinite(convertNumber)) {
//            BigDecimal bd = new BigDecimal(convertNumber).setScale(7, RoundingMode.HALF_EVEN);
//            convertNumber = bd.doubleValue();
//
//            checkedResult = String.valueOf(convertNumber);
//        }

        if(Double.parseDouble(result)%1==0){
            checkedResult = String.valueOf(Math.round(Double.parseDouble(result)));
        }
        return checkedResult;
    }

//    boolean minusAfterOperand(){
//        boolean result=false;
//        int lastElement = digitsNOperatorsLists.operatorList.size()-1;
//
//        ArrayList tmpList = new ArrayList();
//        tmpList.add("-");
//        tmpList.add("+");
//        tmpList.add("/");
//        tmpList.add("*");
//
//        if(tmpList.contains(digitsNOperatorsLists.operatorList.get(lastElement))){result=true;}
//
//        return result;
//    }
//
//    void moreThanOneOperatorException(){
//        int lastElement = digitsNOperatorsLists.displayingList.size()-1;
//        int secondLastElement = digitsNOperatorsLists.displayingList.size()-2;
//        List<String> tmpList = new ArrayList<>();
//        tmpList.add("+");
//        tmpList.add("-");
//        tmpList.add("*");
//        tmpList.add("/");
//
//        if(tmpList.contains(digitsNOperatorsLists.displayingList.get(lastElement))&&tmpList.contains(digitsNOperatorsLists.displayingList.get(secondLastElement))){
//            digitsNOperatorsLists.displayingList.set(secondLastElement,digitsNOperatorsLists.displayingList.get(lastElement));
//            digitsNOperatorsLists.displayingList.remove(lastElement);
//        }
//    }

}
