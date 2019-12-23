package com.example.microservices.productservice.domain;

public class FilterRequest {

    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "FilterRequest{" +
                "label='" + label + '\'' +
                '}';
    }
}
