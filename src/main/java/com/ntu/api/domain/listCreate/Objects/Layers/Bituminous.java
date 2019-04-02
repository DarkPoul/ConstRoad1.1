package com.ntu.api.domain.listCreate.Objects.Layers;

import com.ntu.api.domain.listCreate.Objects.ElasticModul;

import java.io.Serializable;
import java.util.ArrayList;

public class Bituminous extends Layer implements Serializable {
    /*
    Bituminous - описує характристики асфальтобетонів
    name - код асвальтобетону
    material - матеріал асвальтобетону
    bindingMark - марка в'яжучого
    elasticityModulTension- модуль пружності при згині Е, МПа
    variationCoeficientCE - кoефіцієнт варіації CE
    rLab - гранична міцність на розтяг при згині Rlab, МПа
    variationCoeficientCR - коефіцієнт варіації CR
    m - показник втоми
    koeficientKpr - коефіцієнт Кпр
    kM - коефіцієнт kM
    kT - коефіцієнт kT
    shortElasticModuls - короткочасний модуль пружності асвальтобетону
    staticElasticModuls - модуль пружності при статичній дії навантаження
    thickness - товщина
    thicknessVariationCoeficient - коефіцієнт варіації товщини шару
    elasticModuleDeflection - модуль пружності при прогину
    elasticModuleMovement - модуль пружності при зсуві
    * */

    private String name;
    private String material;
    private String bindingMark;
    private Double elasticityModulTension;
    private Double variationCoeficientCE;
    private Double rLab;
    private Double variationCoeficientCR;
    private Double m;
    private Double koeficientKpr;
    private Double kM;
    private Double kT;
    private ArrayList<ElasticModul> shortElasticModuls;
    private ArrayList<ElasticModul> staticElasticModuls;
    private Double minThickness;
    private Double maxThickness;
    private Double cost;
    private Double thickness;
    private Double thicknessVariationCoeficient;
    private Double elasticModuleDeflection;
    private Double elasticModuleMovement;


    public Bituminous(String name, String material, String bindingMark, Double elasticityModulTension,
                      Double variationCoeficientCE, Double rLab, Double variationCoeficientCR, Double m,
                      Double koeficientKpr, Double kM, Double kT, ArrayList<ElasticModul> shortElasticModuls,
                      ArrayList<ElasticModul> staticElasticModuls, Double minThickness, Double maxThickness,
                      Double cost) {
        this.name = name;
        this.material = material;
        this.bindingMark = bindingMark;
        this.elasticityModulTension = elasticityModulTension;
        this.variationCoeficientCE = variationCoeficientCE;
        this.rLab = rLab;
        this.variationCoeficientCR = variationCoeficientCR;
        this.m = m;
        this.koeficientKpr = koeficientKpr;
        this.kM = kM;
        this.kT = kT;
        this.shortElasticModuls = shortElasticModuls;
        this.staticElasticModuls = staticElasticModuls;
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
    public Double getElasticityModulTension() {
        return elasticityModulTension;
    }
    public void setElasticityModulTension(Double elasticityModulTension) {
        this.elasticityModulTension = elasticityModulTension;
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
    public Double getVariationCoeficientCR() {
        return variationCoeficientCR;
    }
    public void setVariationCoeficientCR(Double variationCoeficientCR) {
        this.variationCoeficientCR = variationCoeficientCR;
    }
    public Double getM() {
        return m;
    }
    public void setM(Double m) {
        this.m = m;
    }
    public Double getKoeficientKpr() {
        return koeficientKpr;
    }
    public void setKoeficientKpr(Double koeficientKpr) {
        this.koeficientKpr = koeficientKpr;
    }
    public Double getkM() {
        return kM;
    }
    public void setkM(Double kM) {
        this.kM = kM;
    }
    public Double getkT() {
        return kT;
    }
    public void setkT(Double kT) {
        this.kT = kT;
    }
    public ArrayList<ElasticModul> getShortElasticModuls() {
        return shortElasticModuls;
    }
    public void setShortElasticModuls(ArrayList<ElasticModul> shortElasticModuls) {
        this.shortElasticModuls = shortElasticModuls;
    }
    public ArrayList<ElasticModul> getStaticElasticModuls() {
        return staticElasticModuls;
    }
    public void setStaticElasticModuls(ArrayList<ElasticModul> staticElasticModuls) {
        this.staticElasticModuls = staticElasticModuls;
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
        final StringBuilder sb = new StringBuilder("Bituminous{");
        sb.append("name='").append(name).append('\'');
        sb.append(", material='").append(material).append('\'');
        sb.append(", bindingMark='").append(bindingMark).append('\'');
        sb.append(", elasticityModul=").append(elasticityModulTension);
        sb.append(", variationCoeficientCE=").append(variationCoeficientCE);
        sb.append(", rLab=").append(rLab);
        sb.append(", variationCoeficientCR=").append(variationCoeficientCR);
        sb.append(", m=").append(m);
        sb.append(", koeficientKpr=").append(koeficientKpr);
        sb.append(", kM=").append(kM);
        sb.append(", kT=").append(kT);
        sb.append(", shortElasticModuls=").append(shortElasticModuls);
        sb.append(", staticElasticModuls=").append(staticElasticModuls);
        sb.append(", minThickness=").append(minThickness);
        sb.append(", maxThickness=").append(maxThickness);
        sb.append(", cost=").append(cost);
        sb.append(", thickness=").append(thickness);
        sb.append(", thicknessVariationCoeficient=").append(thicknessVariationCoeficient);
        sb.append('}');
        return sb.toString();
    }
}
