package com.example.rabbitmq;

public class Extent {

    public Extent(String project, Double minX, Double minY, Double maxX, Double maxY) {
        this.project = project;
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }
    private String project;

    private Double minX;

    private Double minY;

    private Double maxX;

    private Double maxY;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Double getMinX() {
        return minX;
    }

    public void setMinX(Double minX) {
        this.minX = minX;
    }

    public Double getMinY() {
        return minY;
    }

    public void setMinY(Double minY) {
        this.minY = minY;
    }

    public Double getMaxX() {
        return maxX;
    }

    public void setMaxX(Double maxX) {
        this.maxX = maxX;
    }

    public Double getMaxY() {
        return maxY;
    }

    public void setMaxY(Double maxY) {
        this.maxY = maxY;
    }
}
