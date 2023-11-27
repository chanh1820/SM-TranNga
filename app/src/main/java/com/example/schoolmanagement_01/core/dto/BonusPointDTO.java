package com.example.schoolmanagement_01.core.dto;

public class BonusPointDTO {

    private String bonusName;

    private Integer bonusPoint;

    public BonusPointDTO(String bonusName, Integer bonusPoint) {
        this.bonusName = bonusName;
        this.bonusPoint = bonusPoint;
    }

    public BonusPointDTO() {
    }

    public String getBonusName() {
        return bonusName;
    }

    public void setBonusName(String bonusName) {
        this.bonusName = bonusName;
    }

    public Integer getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(Integer bonusPoint) {
        this.bonusPoint = bonusPoint;
    }
}
