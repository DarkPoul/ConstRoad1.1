package com.ntu.api.domain.listCreate.Objects.Layers;

import com.ntu.api.domain.listCreate.Objects.Element;

public class Layer extends Element {
    String name;
    String material;
    Double minThickness;
    Double maxThickness;
    Double cost;
    Double thickness;
    Double thicknessVariationCoeficient;

    public Layer() {
    }

    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public Double getMinThickness() {
        return minThickness;
    }
    public void setMinThickness(Double minThickness) {
        this.minThickness = minThickness;
    }
    public Double getMaxThickness() {
        return maxThickness;
    }
    public void setMaxThickness(Double maxThickness) {
        this.maxThickness = maxThickness;
    }
    public Double getCost() {
        return cost;
    }
    public void setCost(Double cost) {
        this.cost = cost;
    }
    public Double getThickness() {
        return thickness;
    }
    public void setThickness(Double thickness) {
        this.thickness = thickness;
    }
    public Double getThicknessVariationCoeficient() {
        return thicknessVariationCoeficient;
    }
    public void setThicknessVariationCoeficient(Double thicknessVariationCoeficient) {
        this.thicknessVariationCoeficient = thicknessVariationCoeficient;
    }
}
