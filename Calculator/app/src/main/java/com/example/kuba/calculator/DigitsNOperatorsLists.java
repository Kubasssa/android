package com.example.kuba.calculator;

import java.util.ArrayList;
import java.util.List;

public class DigitsNOperatorsLists {
    List<Double> numberList;
    List<String> operatorList;

    public DigitsNOperatorsLists() {
        this.numberList = new ArrayList();
        this.operatorList = new ArrayList<>();
//        this.numberList = numberList;
//        this.operatorList = operatorList;
    }

    public Double getNumberList(int i) {
        return numberList.get(i);
    }

    public void addNumberList(Double number) {
        numberList.add(number);
    }

    public void removeLastNumberListElement () {
        numberList.remove(numberList.size()-1);
    }

    public void clearNumberList () {
        numberList.clear();
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
}
