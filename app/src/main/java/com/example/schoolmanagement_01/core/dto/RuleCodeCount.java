package com.example.schoolmanagement_01.core.dto;

public class RuleCodeCount {
    String ruleCode;

    Integer count;

    public RuleCodeCount(String ruleCode, Integer count) {
        this.ruleCode = ruleCode;
        this.count = count;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
