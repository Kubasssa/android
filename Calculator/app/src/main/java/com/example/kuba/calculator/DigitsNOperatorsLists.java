package com.example.kuba.calculator;

import java.util.ArrayList;
import java.util.List;

public class DigitsNOperatorsLists {
    List<String> operatorList;
    int numberOfDigits;

    public DigitsNOperatorsLists() {
        this.operatorList = new ArrayList<>();
        this.numberOfDigits = 0;
    }

    public void addOperatorList(String operator) {
        operatorList.add(operator);
    }
    public void clearOperatorList () {
        operatorList.clear();
    }

    public String convertToString(){
        String result ="";

        for (String s:operatorList) {
            result +=s;
        }
        return result;
    }
}
