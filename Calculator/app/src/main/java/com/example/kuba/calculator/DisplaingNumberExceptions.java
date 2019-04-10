package com.example.kuba.calculator;

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
        System.out.println(checkedResult);

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

}
