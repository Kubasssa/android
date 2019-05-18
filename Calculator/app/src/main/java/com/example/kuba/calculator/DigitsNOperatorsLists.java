package com.example.kuba.calculator;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DigitsNOperatorsLists {
    ArrayList<String> operatorList;
    ArrayList<String> displayingList;
    int numberOfDigits;

    public DigitsNOperatorsLists() {
        this.operatorList = new ArrayList<>();
        this.displayingList = new ArrayList<>();
        this.numberOfDigits = 0;
    }

    public void addOperatorList(String operator) {
        operatorList.add(operator);
    }
    public void addDisplayingList(String operator) { displayingList.add(operator); }

    public void clearOperatorList () {
        operatorList.clear();
    }
    public ArrayList<String> getOperatorList(){
        return this.operatorList;
    }

    public String convertToString(){
        String result ="";

        for (String s:operatorList) {
            result +=s;
        }
        return result;
    }
}
