package com.example.schoolmanagement_01.core.dto;

public class RuleDTO {

    private Integer id;

    private String collectionCode;

    private Integer parentId;

    private String ruleName;

    private String ruleNameMore;

    private String groupCode;

    private Integer minusPoint;

    public RuleDTO(Integer id, String collectionCode, Integer parentId, String ruleName, String ruleNameMore, String groupCode, Integer minusPoint) {
        this.id = id;
        this.collectionCode = collectionCode;
        this.parentId = parentId;
        this.ruleName = ruleName;
        this.ruleNameMore = ruleNameMore;
        this.groupCode = groupCode;
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

    public String getRuleNameMore() {
        return ruleNameMore;
    }

    public void setRuleNameMore(String ruleNameMore) {
        this.ruleNameMore = ruleNameMore;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
}
