package com.example.schoolmanagement_01.core.dto;

public class SummaryRawDTO {
    private String jsonListReport;

    private String jsonListPoint;

    public SummaryRawDTO(String jsonListReport, String jsonListPoint) {
        this.jsonListReport = jsonListReport;
        this.jsonListPoint = jsonListPoint;
    }

    public SummaryRawDTO() {
    }

    public String getJsonListReport() {
        return jsonListReport;
    }

    public void setJsonListReport(String jsonListReport) {
        this.jsonListReport = jsonListReport;
    }

    public String getJsonListPoint() {
        return jsonListPoint;
    }

    public void setJsonListPoint(String jsonListPoint) {
        this.jsonListPoint = jsonListPoint;
    }
}
