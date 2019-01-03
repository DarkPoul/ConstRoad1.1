package com.ntu.api.domain.listCreate.Objects.Layers;

import java.io.Serializable;

public class UnstrengthenedMaterial extends Layer implements Serializable {
    /*
    UnstrengthenedMaterial - описує характристики матеріалів і грунтів неукрвплених в'яжучими речовинами
    name - код
    material - матеріал
    elasticityModul - модуль пружності Е, МПа для основ
    variationCoefficientCE - крефіцієнт варіації CE для основ
    angle - кут внутрішнього тертя
    coefficientFriction - крефіцієнт зчеплення Сзч
    thickness - товщина
    thicknessVariationCoefficient - коефіцієнт варіації товщини шару
    * */

    private String name;
    private String material;
    private Integer elasticityModul;
    private Double variationCoefficientCE;
    private Double angle;
    private Double coefficientFriction;
    private Double minThickness;
    private Double maxThickness;
    private Double cost;
    private Double thickness;
    private Double thicknessVariationCoeficient;


    public UnstrengthenedMaterial(String name, String material, Integer elasticityModul, Double variationCoefficientCE,
                                  Double angle, Double coefficientFriction, Double minThickness, Double maxThickness,
                                  Double cost) {
        this.name = name;
        this.material = material;
        this.elasticityModul = elasticityModul;
        this.variationCoefficientCE = variationCoefficientCE;
        this.angle = angle;
        this.coefficientFriction = coefficientFriction;
        this.minThickness = minThickness;
        this.maxThickness = maxThickness;
        this.cost = cost;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getMaterial() {
        return material;
    }
    @Override
    public void setMaterial(String material) {
        this.material = material;
    }
    public Integer getElasticityModul() {
        return elasticityModul;
    }
    public void setElasticityModul(Integer elasticityModul) {
        this.elasticityModul = elasticityModul;
    }
    public Double getVariationCoefficientCE() {
        return variationCoefficientCE;
    }
    public void setVariationCoefficientCE(Double variationCoefficientCE) {
        this.variationCoefficientCE = variationCoefficientCE;
    }
    public Double getAngle() {
        return angle;
    }
    public void setAngle(Double angle) {
        this.angle = angle;
    }
    public Double getCoefficientFriction() {
        return coefficientFriction;
    }
    public void setCoefficientFriction(Double coefficientFriction) {
        this.coefficientFriction = coefficientFriction;
    }
    @Override
    public Double getMinThickness() {
        return minThickness;
    }
    @Override
    public void setMinThickness(Double minThickness) {
        this.minThickness = minThickness;
    }
    @Override
    public Double getMaxThickness() {
        return maxThickness;
    }
    @Override
    public void setMaxThickness(Double maxThickness) {
        this.maxThickness = maxThickness;
    }
    @Override
    public Double getCost() {
        return cost;
    }
    @Override
    public void setCost(Double cost) {
        this.cost = cost;
    }
    @Override
    public Double getThickness() {
        return thickness;
    }
    @Override
    public void setThickness(Double thickness) {
        this.thickness = thickness;
    }
    @Override
    public Double getThicknessVariationCoeficient() {
        return thicknessVariationCoeficient;
    }
    @Override
    public void setThicknessVariationCoeficient(Double thicknessVariationCoeficient) {
        this.thicknessVariationCoeficient = thicknessVariationCoeficient;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UnstrengthenedMaterial{");
        sb.append("name='").append(name).append('\'');
        sb.append(", material='").append(material).append('\'');
        sb.append(", elasticityModul=").append(elasticityModul);
        sb.append(", variationCoefficientCE=").append(variationCoefficientCE);
        sb.append(", angle=").append(angle);
        sb.append(", coefficientFriction=").append(coefficientFriction);
        sb.append(", minThickness=").append(minThickness);
        sb.append(", maxThickness=").append(maxThickness);
        sb.append(", cost=").append(cost);
        sb.append(", thickness=").append(thickness);
        sb.append(", thicknessVariationCoeficient=").append(thicknessVariationCoeficient);
        sb.append('}');
        return sb.toString();
    }
}
