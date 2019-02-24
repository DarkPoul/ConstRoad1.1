package com.ntu.api.model;

import com.ntu.api.domain.RoadConstraction;
import com.ntu.api.domain.listCreate.Objects.GroundWtParameters;
import com.ntu.api.domain.listCreate.Objects.Layers.*;

import java.util.ArrayList;

public class RoadConstractionModel {
    /* Клас, який описує модель конструкції дорожнього одягу для розрахунку характеристик його конструкції та надійності
    * roadConstraction - конструкція дорожнього одягу, яка розраховується
    * dinamicLoadDuration - тривалість дії навантаження від рухомого автотранспорту
    * staticLoadDuration - тривалість дії статичного навантаження
    * humidityVariationCoeficient - коефіцієент варіації вологості
    *  wTg - характеристик за вологістю грунту
    *  wTs - характеристик за вологістю невя'зкого шару (піску)
    *  dinamicKoeficient - коефіцієнт динамічності
    *  nominalDynamicLoad - номінальне динамічне  навантаження
    *  neededElasticModule - потрібний модуль пружності Епотр
    *  calculatedWeelImprintDiameter - діаметр розрахункового відбитку колеса D,м
    *  elasticModele - загальний розрахований модуль пружності Езаг
    *  elasticDeflectionKoeficient -  коефіцієнт запасу Еза/Епотр
    * */
    private static RoadConstraction roadConstraction;
    private static final Integer staticLoadDuration = 600;
    private static final Double dinamicLoadDuration = 0.1;
    private static final Double humidityVariationCoeficient = 0.1;
    private static final Double dinamicKoeficient = 1.3;
    private static GroundWtParameters wTg;
    private static GroundWtParameters wTs;
    private static Double nominalDynamicLoad;
    private static Double calculatedDailyIntensity;
    private static Double neededElasticModule;
    private static Double calculatedWeelImprintDiameter;
    private static Double elasticModele;

    private static Double elasticDeflectionKoeficient;

    public static RoadConstraction getRoadConstraction() {
        return roadConstraction;
    }
    public static void setRoadConstraction(RoadConstraction roadConstraction) {
        RoadConstractionModel.roadConstraction = roadConstraction;
    }
    public static Integer getStaticLoadDuration() {
        return staticLoadDuration;
    }
    public static Double getDinamicLoadDuration() {
        return dinamicLoadDuration;
    }
    public static Double getHumidityVariationCoeficient() {
        return humidityVariationCoeficient;
    }
    public static Double getDinamicKoeficient() {
        return dinamicKoeficient;
    }
    public static GroundWtParameters getwTg() {
        return wTg;
    }
    public static void setwTg(GroundWtParameters wTg) {
        RoadConstractionModel.wTg = wTg;
    }
    public static GroundWtParameters getwTs() {
        return wTs;
    }
    public static void setwTs(GroundWtParameters wTs) {
        RoadConstractionModel.wTs = wTs;
    }
    public static Double getNominalDynamicLoad() {
        return nominalDynamicLoad;
    }
    public static void setNominalDynamicLoad(Double nominalDynamicLoad) {
        RoadConstractionModel.nominalDynamicLoad = nominalDynamicLoad;
    }
    public static Double getCalculatedDailyIntensity() {
        return calculatedDailyIntensity;
    }
    public static void setCalculatedDailyIntensity(Double calculatedDailyIntensity) {
        RoadConstractionModel.calculatedDailyIntensity = calculatedDailyIntensity;
    }
    public static Double getNeededElasticModule() {
        return neededElasticModule;
    }
    public static void setNeededElasticModule(Double neededElasticModule) {
        RoadConstractionModel.neededElasticModule = neededElasticModule;
    }

    //    метод розрахунку коефіцієнту запасу міцності за критерієм опору шарів з монолітних матеріалів розтягу при згині
    public static Double bendingTensionCalculation(){

        return 0.0 ;
    }

//    метод розрахунку коефіцієнт запасу міцності за критерієм пружного прогину(загального модуля пружності)
    public static Double elasticDeflectionCalculation(){
        ArrayList<Layer> calculatedLayersList = new ArrayList<>();
        for (Layer temp: roadConstraction.getTotalLayerList()){
            calculatedLayersList.add(0,temp);
        }
        double calculatedElasticModule = roadConstraction.getEstimatedGroundWt().geteGr();
        for (Layer temp: calculatedLayersList){
            Double hEkvD = 2*temp.getThickness()/calculatedWeelImprintDiameter*Math.pow(temp.getElasticModuleDeflection()/(6*calculatedElasticModule),1/3);
            calculatedElasticModule = temp.getElasticModuleDeflection()*(1.05-(0.1*temp.getThickness()/calculatedWeelImprintDiameter*
                    (1-Math.pow(calculatedElasticModule/temp.getElasticModuleDeflection(),1/3))))
                    /(0.71*Math.pow(calculatedElasticModule/temp.getElasticModuleDeflection(),1/3)*Math.atan(1.35*hEkvD)
                    +(temp.getElasticModuleDeflection()/calculatedElasticModule*2/Math.PI*Math.atan(1/hEkvD)));
        }
        elasticModele = calculatedElasticModule;
            elasticDeflectionKoeficient = elasticModele/neededElasticModule;
            return elasticDeflectionKoeficient;
    }

//    метод розрахунку коефіцієнту запасу міцності за критерієм зсуву у грунті земляного полотна
    public static Double movementSubGradeCalculation(){

        return 0.0 ;
    }
//    метод розрахунку коефіцієнту запасу міцності за критерієм зсуву у шарі нев'язкого середовища
    public static Double movementInviscidLayerCalculation(){

        return 0.0 ;
    }
    //    метод розрахунку надійності за критерієм опору шарів з монолітних матеріалів розтягу при згині
    public static Double bendingTensionReliabilityCalculation(){

        return 0.0 ;
    }

    //    метод розрахунку надійності за критерієм пружного прогину(загального модуля пружності)
    public static Double elasticDeflectionReliabilityCalculation(){

        return 0.0 ;
    }

    //    метод розрахунку надійності за критерієм зсуву у грунті земляного полотна
    public static Double movementSubGradeReliabilityCalculation(){

        return 0.0 ;
    }
    //    метод розрахунку надійності за критерієм зсуву у шарі нев'язкого середовища
    public static Double movementInviscidLayerReliabilityCalculation(){

        return 0.0 ;
    }

    // метод розрахунку загального модуля пружності Езаг
    public static Double elasticModuleCalculation(){
        return 0.0 ;
    }

    //     метод визначення загальної товщини шарів дорожного покриття
    public static Double totalLayersThickness(RoadConstraction roadConstraction){
        Double layersThickness = 0.0;
        for(RoadLayers el: roadConstraction.getRoadLayers()){
            for (Layer layer: el.getLayers()) {
                layersThickness += layer.getThickness()*0.01;
            }
        }
        return layersThickness;
    }

//    метод визначення загальної товщини в'язких шарів дорожнього покриття (без шарів піску + з шарами піску)
//    public static ArrayList<Double> layersThicknessWithoutSand(RoadConstraction roadConstraction){
//        ArrayList<Double> layerThicknessWithoutSands = new ArrayList<>();
//        Double tempLAyerThickness=0.0;
//        for(RoadLayers el: roadConstraction.getRoadLayers()){
//            if(!el.getName().equals("Шар нев'язкого середовища") && el.getLayers().size()>0){
//                for (Layer layer:el.getLayers()){
//                    tempLAyerThickness += layer.getThickness()*0.01;
//                }
//            }
//        }
//        layerThicknessWithoutSands.add(tempLAyerThickness);
//        for (Sand sand: roadConstraction.getSands()){
//            layerThicknessWithoutSands.add(layerThicknessWithoutSands.get(layerThicknessWithoutSands.size()-1)+sand.getThickness()*0.01);
//        }
//        return layerThicknessWithoutSands;
//    }

//    метод визначення розрахункової вологості грунту
    public static void estimatedGroundMoisture(){
        Double moisture = (roadConstraction.getHumidity()-roadConstraction.getCorrection())
                *(1+roadConstraction.getRoad().getkStudent()*humidityVariationCoeficient);
        roadConstraction.setEstimatedGroundMoisture(moisture);
        System.out.println(roadConstraction.getEstimatedGroundMoisture());
        wTg = estimatedParameters(roadConstraction.getGround().getwT(), roadConstraction.getEstimatedGroundMoisture());
        roadConstraction.setEstimatedGroundWt(wTg);
        System.out.println(roadConstraction.getEstimatedGroundWt());
    }

//    метод визначення розрахугковох вологості нев'язкого шару (піску)
    public static void estimatedSandMoisture(){
        Double moisture;
        if(roadConstraction.getRoadLayers().get(4).getLayers().size()>0) {
            if (roadConstraction.getHumidity() <= 0.75 && roadConstraction.getTotalLayersThickness() <= 0.75) {
                moisture = (roadConstraction.getHumidity() - roadConstraction.getCorrection())
                        * (1 + roadConstraction.getRoad().getkStudent() * humidityVariationCoeficient);
            } else {
                moisture = (-0.967 * Math.pow(roadConstraction.getHumidity(), 2) + 1.956 * roadConstraction.getHumidity() - 0.924)
                        * 0.0001 * Math.pow(roadConstraction.getTotalLayersThickness(), 2) +
                        (-2.531 * Math.pow(roadConstraction.getHumidity(), 2) + 5.745 * roadConstraction.getHumidity() - 2.885)
                                * 0.01 * roadConstraction.getTotalLayersThickness() +
                        (-2.029 * Math.pow(roadConstraction.getHumidity(), 2) + 5.319 * roadConstraction.getHumidity() - 2.098);
            }
            for(Sand sand: roadConstraction.getSands()){
                wTs = estimatedParameters(sand.getwT(), moisture);
                sand.setEstimatedWt(wTs);
                sand.setElasticModuleDeflection(sand.getEstimatedWt().geteGr());
                sand.setElasticModuleMovement(sand.getEstimatedWt().geteGr());
            }
        }
    }

//  метод визначення розрахункового значення вологості земляного полотна або нев'язкового шару
    private static GroundWtParameters estimatedParameters(ArrayList<GroundWtParameters> wt, double estimatedMoisture){
        GroundWtParameters temp;
        double estimatedMoisturetemp = estimatedMoisture;
        double max =(double)Math.round(Math.ceil(estimatedMoisture/0.05)*5)/100;
        double min =(double)Math.round(Math.floor(estimatedMoisture/0.05)*5)/100;
        GroundWtParameters wtMin = new GroundWtParameters();
        GroundWtParameters wtMax = new GroundWtParameters();

        if(min<wt.get(0).getWt()){
            temp = wt.get(0);
        }
        else if(max>wt.get(8).getWt()){
            temp = wt.get(8);
        }
        else{
            for (GroundWtParameters el : wt) {
                if (el.getWt().equals(min)) {
                    wtMin = el;
                } else if (el.getWt().equals(max)) {
                    wtMax = el;
                }
            }
            Double eGrEstimated = wtMin.geteGr() + (estimatedMoisturetemp-wtMin.getWt())*
                    ((wtMin.geteGr()-wtMax.geteGr())/(wtMin.getWt()-wtMax.getWt()));
            Double fiEstimated = wtMin.getFi() + (estimatedMoisturetemp-wtMin.getWt())*
                    ((wtMin.getFi()-wtMax.getFi())/(wtMin.getWt()-wtMax.getWt()));
            Double cGrEstimated = wtMin.getcGr() + (estimatedMoisturetemp-wtMin.getWt())*
                    ((wtMin.getcGr()-wtMax.getcGr())/(wtMin.getWt()-wtMax.getWt()));
            temp = new GroundWtParameters(String.valueOf(estimatedMoisture),estimatedMoisturetemp,eGrEstimated,fiEstimated,cGrEstimated);
        }
        return temp;
    }

//    метод проведення попередніх розрахунків
    public static void preCalculation(){
        estimatedSandMoisture();
        nominalDynamicLoad = dinamicKoeficient*roadConstraction.getDesigionLoad().getStaticLoadAxis();
        calculatedDailyIntensity = roadConstraction.getPassageNumber()/roadConstraction.getOperationTime()/roadConstraction.getRbcz().getCheckoutDay();
        double tempNeededElasticModule = 42.843*Math.log(roadConstraction.getPassageNumber())-roadConstraction.getDesigionLoad().getbKoeficient();
        if(tempNeededElasticModule<roadConstraction.getMinElasticModule()){
            neededElasticModule = (double)(roadConstraction.getMinElasticModule());
        }
        else{neededElasticModule = tempNeededElasticModule;}
        calculatedWeelImprintDiameter = 0.01*Math.sqrt((4*nominalDynamicLoad*10)/(2*Math.PI*roadConstraction.getDesigionLoad().getPreassureWeel()));
    }
//метод визначення мінімального модуля пружності
    public static void minElasticModuleChoose(){
        if(roadConstraction.getRoadType().getName().equals("Капітальний")){
            roadConstraction.setMinElasticModule(roadConstraction.getRoad().getMinElasticModulCapital());
        }
        else if(roadConstraction.getRoadType().getName().equals("Вдосконалений полекшений")){
            roadConstraction.setMinElasticModule(roadConstraction.getRoad().getMinElasticModulLite());
        }
        else if(roadConstraction.getRoadType().getName().equals("Перехідний")){
            roadConstraction.setMinElasticModule(roadConstraction.getRoad().getMinElasticModulTransfer());
        }
    }

//    метод для формування списку матеріалів з їх товщиною та модулями пружності для розрахунку загального модуля пружності при прогині
//    private static ArrayList<LayerModele> DeflectionElasticModelesCalculating(ArrayList<Layer> layers){
//        ArrayList<LayerModele> layerModeles = new ArrayList<>();
//        for(Layer layer: layers){
//            if(layer.getClass().equals(Bituminous.class)) {
//                Bituminous tempBitum = (Bituminous) layer;
//                layerModeles.set(0, new LayerModele(tempBitum.getName(), tempBitum.getThickness(), (double)tempBitum.getShortElasticModuls().get(0).getElasticModule());
//            }
//            else if (layer.)
//
//        }
//
//        return 0.0;
//    }

}
