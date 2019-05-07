package com.ntu.api.domain.listCreate.Objects.Layers;

import java.io.Serializable;

public class StrengthenedMaterial extends Layer implements Serializable {
     /*
    StrengthenedMaterial - описує характристики матеріалів і грунтів укрвплених в'яжучими речовинами
    name - код
    material - матеріал
    bindingMark - марка в'яжучого
    elasticityModul - модуль пружності Е, МПа
    variationCoeficientCE - крефіцієнт варіації CE
    rLab - гранична міцність на розтяг при згині Rlab, МПа
    minThickness - мінімальна товщина;
    maxThickness - максимальна товщина
    cost - вартість
    thickness - товщина
    thicknessVariationCoeficient - коефіцієнт варіації товщини шару
    elasticModuleDeflection - модуль пружності при прогину
    elasticModuleMovement - модуль пружності при зсуві
    * */

    private String name;
    private String material;
    private String bindingMark;
    private Integer elasticityModul;
    private Double variationCoeficientCE;
    private Double rLab;
    private Double minThickness;
    private Double maxThickness;
    private Double cost;
    private Double thickness;
    private Double thicknessVariationCoeficient;
    private Double elasticModuleDeflection;
    private Double elasticModuleMovement;

    public StrengthenedMaterial(String name, String material, String bindingMark, Integer elasticityModul,
                                Double variationCoeficientCE, Double rLab, Double minThickness, Double maxThickness,
                                Double cost) {
        this.name = name;
        this.material = material;
        this.bindingMark = bindingMark;
        this.elasticityModul = elasticityModul;
        this.variationCoeficientCE = variationCoeficientCE;
        this.rLab = rLab;
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
    public String getBindingMark() {
        return bindingMark;
    }
    public void setBindingMark(String bindingMark) {
        this.bindingMark = bindingMark;
    }
    public Integer getElasticityModul() {
        return elasticityModul;
    }
    public void setElasticityModul(Integer elasticityModul) {
        this.elasticityModul = elasticityModul;
    }
    public Double getVariationCoeficientCE() {
        return variationCoeficientCE;
    }
    public void setVariationCoeficientCE(Double variationCoeficientCE) {
        this.variationCoeficientCE = variationCoeficientCE;
    }
    public Double getrLab() {
        return rLab;
    }
    public void setrLab(Double rLab) {
        this.rLab = rLab;
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
    public Double getElasticModuleDeflection() {
        return elasticModuleDeflection;
    }
    @Override
    public void setElasticModuleDeflection(Double elasticModuleDeflection) {
        this.elasticModuleDeflection = elasticModuleDeflection;
    }
    @Override
    public Double getElasticModuleMovement() {
        return elasticModuleMovement;
    }
    @Override
    public void setElasticModuleMovement(Double elasticModuleMovement) {
        this.elasticModuleMovement = elasticModuleMovement;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StrengthenedMaterial{");
        sb.append("name='").append(name).append('\'');
        sb.append(", material='").append(material).append('\'');
        sb.append(", bindingMark='").append(bindingMark).append('\'');
        sb.append(", elasticityModul=").append(elasticityModul);
        sb.append("elasticModuleDeflection" + elasticModuleDeflection);
        sb.append(", variationCoeficientCE=").append(variationCoeficientCE);
        sb.append(", rLab=").append(rLab);
        sb.append(", minThickness=").append(minThickness);
        sb.append(", maxThickness=").append(maxThickness);
        sb.append(", cost=").append(cost);
        sb.append(", thickness=").append(thickness);
        sb.append(", thicknessVariationCoeficient=").append(thicknessVariationCoeficient);
        sb.append('}');
        return sb.toString();
    }
}
