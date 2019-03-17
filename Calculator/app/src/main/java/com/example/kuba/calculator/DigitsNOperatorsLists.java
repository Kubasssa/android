package com.example.kuba.calculator;

import java.util.ArrayList;
import java.util.List;

public class DigitsNOperatorsLists {
    List<Double> numberList;
    List<String> operatorList;
    int numberOfDigits;

    public DigitsNOperatorsLists() {
        this.numberList = new ArrayList();
        this.operatorList = new ArrayList<>();
        this.numberOfDigits = 0;
    }

    public String getOperatorList(int i) {
        return operatorList.get(i);
    }

    public void addOperatorList(String operator) {
        operatorList.add(operator);
    }

    public void removeLastOperaorListElement () {
        operatorList.remove(operatorList.size()-1);
    }

    public void clearOperatorList () {
        operatorList.clear();
    }

    public void incrementNumberOfDigits(){ numberOfDigits++; }
    public void decrementNumberOfDigits(){numberOfDigits--;}
    public void resetNumberOfDigits(){numberOfDigits=0;};
}
