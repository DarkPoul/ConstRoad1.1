package com.ntu.api.model;

import com.ntu.api.domain.Message;
import com.ntu.api.domain.RoadConstraction;
import com.ntu.api.domain.listCreate.Objects.Layers.Layer;
import com.ntu.api.domain.listCreate.Objects.Layers.RoadLayers;
import com.ntu.api.domain.listCreate.Objects.Layers.Sand;

import java.math.BigDecimal;
import java.util.ArrayList;

public class RoadConstractionModel {
    /* Клас, який описує модель конструкції дорожнього одягу для розрахунку характеристик його конструкції та надійності
    roadConstraction - конструкція дорожнього одягу, яка розраховується

    * */
    private static RoadConstraction roadConstraction;
    private static Integer groundHumidity;
    private static Integer soundHumidity;


    private static Double elasticDeflectionKoeficient;

    public static RoadConstraction getRoadConstraction() {
        return roadConstraction;
    }
    public static void setRoadConstraction(RoadConstraction roadConstraction) {
        RoadConstractionModel.roadConstraction = roadConstraction;
    }


//    метод розрахунку коефіцієнту запасу міцності за критерієм опору шарів з монолітних матеріалів розтягу при згині
    public static Double bendingTensionCalculation(){

        return 0.0 ;
    }

//    метод розрахунку коефіцієнт запасу міцності за критерієм пружного прогину(загального модуля пружності)
    public static Double elasticDeflectionCalculation(){
//            elasticDeflectionKoeficient = elasticModele/neededElasticModule;
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
    public static ArrayList<Double> layersThicknessWithoutSand(RoadConstraction roadConstraction){
        ArrayList<Double> layerThicknessWithoutSands = new ArrayList<>();
        Double tempLAyerThickness=0.0;
        for(RoadLayers el: roadConstraction.getRoadLayers()){
            if(!el.getName().equals("Шар нев'язкого середовища") && el.getLayers().size()>0){
                for (Layer layer:el.getLayers()){
                    tempLAyerThickness += layer.getThickness()*0.01;
                }
            }
        }
        layerThicknessWithoutSands.add(tempLAyerThickness);
        for (Sand sand: roadConstraction.getSands()){
            layerThicknessWithoutSands.add(layerThicknessWithoutSands.get(layerThicknessWithoutSands.size()-1)+sand.getThickness()*0.01);
        }
        return layerThicknessWithoutSands;
    }

//    метод визначення розрахункової вологості грунту
    public static Double estimatedGroundMoisture(){
        return (roadConstraction.getHumidity()-roadConstraction.getCorrection())
                        *(1+roadConstraction.getRoad().getkStudent()*roadConstraction.getHumidityVariationCoeficient());
    }

//    метод визначення розрахугковох вологості нев'язкого шару (піску)
    public static Double estimatedSandMoisture(){
        if(roadConstraction.getHumidity()<=0.75 && roadConstraction.getTotalLayersThickness()<=0.75){
            return (roadConstraction.getHumidity()-roadConstraction.getCorrection())
                    *(1+roadConstraction.getRoad().getkStudent()*roadConstraction.getHumidityVariationCoeficient());
        }
        else{
            return (-0.967*Math.pow(roadConstraction.getHumidity(),2)+1.956*roadConstraction.getHumidity()-0.924)
                    *0.0001*Math.pow(roadConstraction.getTotalLayersThickness(),2)+
                    (-2.531*Math.pow(roadConstraction.getHumidity(),2)+5.745*roadConstraction.getHumidity()-2.885)
                            *0.01*roadConstraction.getTotalLayersThickness()+
                    (-2.029*Math.pow(roadConstraction.getHumidity(),2)+5.319*roadConstraction.getHumidity()-2.098);
        }
    }
//    метод визначення розрахункових параметрів землянгого полотна
    public static void estimatedGroundParameters(){
        BigDecimal min = BigDecimal.valueOf(Math.round(roadConstraction.getEstimatedGroundMoisture()/0.05)*0.05);
        BigDecimal max = BigDecimal.valueOf(Math.round(roadConstraction.getEstimatedGroundMoisture()/0.05)*0.05+0.05);
        System.out.println(roadConstraction.getEstimatedGroundMoisture());
        System.out.println(min);
        System.out.println(max);

//        roadConstraction.getGround()
    }

}
