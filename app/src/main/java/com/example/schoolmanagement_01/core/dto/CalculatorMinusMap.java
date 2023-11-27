package com.example.schoolmanagement_01.core.dto;

public class CalculatorMinusMap {
    public Integer minus;

    public Integer idRuleParent;

    public CalculatorMinusMap(Integer minus, Integer idRuleParent) {
        this.minus = minus;
        this.idRuleParent = idRuleParent;
    }

    public CalculatorMinusMap(Integer minus) {
        this.minus = minus;
    }

    public Integer getMinus() {
        return minus;
    }

    public void setMinus(Integer minus) {
        this.minus = minus;
    }

    public Integer getIdRuleParent() {
        return idRuleParent;
    }

    public void setIdRuleParent(Integer idRuleParent) {
        this.idRuleParent = idRuleParent;
    }
}
