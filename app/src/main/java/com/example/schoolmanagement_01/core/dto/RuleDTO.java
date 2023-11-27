package com.example.schoolmanagement_01.core.dto;

public class RuleDTO {

    private Integer id;

    private String ruleCode;

    private String collectionCode;

    private Integer parentId;

    private String ruleName;

    private String ruleNameMore;

    private Integer groupId;

    private Integer minusPoint;

    public RuleDTO(Integer id,Integer parentId, String ruleName, Integer minusPoint) {
        this.id = id;
        this.ruleName = ruleName;
        this.minusPoint = minusPoint;
        this.parentId = parentId;
    }

    public RuleDTO(Integer id, String ruleCode, Integer parentId, String ruleName,String ruleNameMore, Integer groupId, Integer minusPoint) {
        this.id = id;
        this.ruleCode = ruleCode;
        this.parentId = parentId;
        this.ruleName = ruleName;
        this.ruleNameMore = ruleNameMore;
        this.groupId = groupId;
        this.minusPoint = minusPoint;
    }

    public RuleDTO(Integer id, String ruleCode, String collectionCode, Integer parentId, String ruleName, String ruleNameMore, Integer groupId, Integer minusPoint) {
        this.id = id;
        this.ruleCode = ruleCode;
        this.collectionCode = collectionCode;
        this.parentId = parentId;
        this.ruleName = ruleName;
        this.ruleNameMore = ruleNameMore;
        this.groupId = groupId;
        this.minusPoint = minusPoint;
    }

    public String getCollectionCode() {
        return collectionCode;
    }

    public void setCollectionCode(String collectionCode) {
        this.collectionCode = collectionCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Integer getMinusPoint() {
        return minusPoint;
    }

    public void setMinusPoint(Integer minusPoint) {
        this.minusPoint = minusPoint;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getRuleNameMore() {
        return ruleNameMore;
    }

    public void setRuleNameMore(String ruleNameMore) {
        this.ruleNameMore = ruleNameMore;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
