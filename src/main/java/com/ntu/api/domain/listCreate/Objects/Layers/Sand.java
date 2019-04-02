package com.ntu.api.domain.listCreate.Objects.Layers;

import com.ntu.api.domain.listCreate.Objects.GroundWtParameters;

import java.io.Serializable;
import java.util.ArrayList;

public class Sand extends Layer implements Serializable {
     /*
    Sand - описує характристики шару піску
    name - код
    material - матеріал
    plasticNumber - число пластичності jP
    SanPartNumber - вміст піщаних часток (2,0 - 0,5) мм, % за масою
    k3 - коефіцієнт, який враховує особливості роботи грунтц в констукції,
         повязані зі збільшенням фактичного зчеплення грунтів за рахунок защемлення та іншого
    kCfi - коефіцієнт варіації кута внутрішнього тертя Сfi
    kCeg - коефіцієнт варіації модуля пружності грунтового півпростору СЕгр
    wT - колекція обєктів, які характеризують розрахунгкові значення характеристик за вологістю грунту
         обєкт в якості імені містить розрахунковк значення вологості грунту та параметри
        Еsn - модуль пружності шару піска, МПа;
        fi - кут внутрішнього тертя, град;
        Сsn - коефіцієнт внутрішнього тертя шару піску, МПа
    thickness - товщина
    thicknessVariationCoeficient - коефіцієнт варіації товщини шару
    estimatedWt - значення характеристик грунтів за вологістю
    elasticModuleDeflection - модуль пружності при прогину
    elasticModuleMovement - модуль пружності при зсуві
    * */

    private String name;
    private String material;
    private String plasticNumber;
    private String sanPartNumber;
    private Double k3;
    private Double kCfi;
    private Double kCeg;
    private ArrayList<GroundWtParameters> wT;
    private Double minThickness;
    private Double maxThickness;
    private Double cost;
    private Double thickness;
    private Double thicknessVariationCoeficient;
    private GroundWtParameters estimatedWt;
    private Double elasticModuleDeflection;
    private Double elasticModuleMovement;

    public Sand(String name, String material, String plasticNumber, String sanPartNumber, Double k3, Double kCfi,
                Double kCeg, ArrayList<GroundWtParameters> wT, Double minThickness, Double maxThickness, Double cost) {
        this.name = name;
        this.material = material;
        this.plasticNumber = plasticNumber;
        this.sanPartNumber = sanPartNumber;
        this.k3 = k3;
        this.kCfi = kCfi;
        this.kCeg = kCeg;
        this.wT = wT;
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
    public String getPlasticNumber() {
        return plasticNumber;
    }
    public void setPlasticNumber(String plasticNumber) {
        this.plasticNumber = plasticNumber;
    }
    public String getSanPartNumber() {
        return sanPartNumber;
    }
    public void setSanPartNumber(String sanPartNumber) {
        this.sanPartNumber = sanPartNumber;
    }
    public Double getK3() {
        return k3;
    }
    public void setK3(Double k3) {
        this.k3 = k3;
    }
    public Double getkCfi() {
        return kCfi;
    }
    public void setkCfi(Double kCfi) {
        this.kCfi = kCfi;
    }
    public Double getkCeg() {
        return kCeg;
    }
    public void setkCeg(Double kCeg) {
        this.kCeg = kCeg;
    }
    public ArrayList<GroundWtParameters> getwT() {
        return wT;
    }
    public void setwT(ArrayList<GroundWtParameters> wT) {
        this.wT = wT;
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
    public GroundWtParameters getEstimatedWt() {
        return estimatedWt;
    }
    public void setEstimatedWt(GroundWtParameters estimatedWt) {
        this.estimatedWt = estimatedWt;
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
        final StringBuilder sb = new StringBuilder("Sand{");
        sb.append("name='").append(name).append('\'');
        sb.append(", material='").append(material).append('\'');
        sb.append(", plasticNumber='").append(plasticNumber).append('\'');
        sb.append(", sanPartNumber='").append(sanPartNumber).append('\'');
        sb.append(", k3=").append(k3);
        sb.append(", kCfi=").append(kCfi);
        sb.append(", kCeg=").append(kCeg);
        sb.append(", wT=").append(wT);
        sb.append(", minThickness=").append(minThickness);
        sb.append(", maxThickness=").append(maxThickness);
        sb.append(", cost=").append(cost);
        sb.append(", thickness=").append(thickness);
        sb.append(", thicknessVariationCoeficient=").append(thicknessVariationCoeficient);
        sb.append('}');
        return sb.toString();
    }
}
