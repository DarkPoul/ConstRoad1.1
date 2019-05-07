package com.ntu.api.domain.listCreate.Objects.Layers;

import com.ntu.api.domain.listCreate.Objects.Element;

//*клас описує шар дорожнього одягу в загальному вигляді
public class Layer extends Element {
//    name - ім'я
//    material - матеріал
//    minThickness - мінімальна товщина
//    maxThickness - максимальна товщина
//    cost - ціна
//    thickness -товщина
//    thicknessVariationCoeficient - коефіцієнт варіації товщини
//    elasticModuleDeflection - модуль пружності при прогину
//    elasticModuleMovement - модуль пружності при зсуві
    String name;
    String material;
    Double minThickness;
    Double maxThickness;
    Double cost;
    Double thickness;
    Double thicknessVariationCoeficient;
    Double elasticModuleDeflection;
    Double elasticModuleMovement;

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
    public Double getElasticModuleDeflection() {
        return elasticModuleDeflection;
    }
    public void setElasticModuleDeflection(Double elasticModuleDeflection) {
        this.elasticModuleDeflection = elasticModuleDeflection;
    }
    public Double getElasticModuleMovement() {
        return elasticModuleMovement;
    }
    public void setElasticModuleMovement(Double elasticModuleMovement) {
        this.elasticModuleMovement = elasticModuleMovement;
    }
}
