package com.ntu.api.model;

import com.ntu.api.domain.LayerT;
import com.ntu.api.domain.listCreate.Objects.*;
import com.ntu.api.domain.listCreate.Objects.Layers.*;

import java.io.Serializable;
import java.util.ArrayList;

public class RoadConstraction extends Element implements Serializable {

    /*RoadConstraction - конструкція дорожнього одягу
    * Road Constraction описує конструкцію дорожнього одягу, його розташування та параметри,
    * а також результати розрахунку експлуатаційних характеристик конструкції дорожнього одягу та її надійності
    * rbcz - дорожньо-кліматична зона України, розташування ділянки дорожнього одягу, що рохраховується
    * road - описує категорію дороги:
    * roadType - описує тип дорожнього одягу
    * desigionLoad - описує групу розрахункового навантаження
    * soils -  описує вид грунту
    * groundType - описує вид грунту;
    * ground - описує різновид глинистих грунтів;
    * roadLines - описує коефіцієнти суг руху
    * groundCorection - описує поправку на конструктивні особливості використовуваних
    дренажних конструкцій у дорожньо-кліматичних зонах І-IV
    * humidity - вологість грунту
    * correction - поправка на конструктивні особливості дренажної
    * roadLayers - список шарів покриття
    *
    */

    private static RBCZ rbcz;
    private static Road road;
    private static RoadType roadType;
    private static DesigionLoad desigionLoad;
    private static Soils soils;
    private static GroundType groundType;
    private static Ground ground;
    private static RoadLines roadLines;
    private static GroundCorection groundCorection;
    private static double humidity;
    private static double correction;

    private static ArrayList<Bituminous> bituminous= new ArrayList<>();
    private static ArrayList<StrengthenedMaterial> strengthenedMaterials= new ArrayList<>();
    private static ArrayList<UnstrengthenedMaterial> unstrengthenedMaterialsCover = new ArrayList<>();
    private static ArrayList<UnstrengthenedMaterial> unstrengthenedMaterialsBase = new ArrayList<>();
    private static ArrayList<Sand> sands = new ArrayList<>();

    private static ArrayList<RoadLayers> roadLayers = new ArrayList<>();



    public static RBCZ getRbcz() {
        return rbcz;
    }
    public static void setRbcz(RBCZ rbcz) {
        RoadConstraction.rbcz = rbcz;
        System.out.println(rbcz);
    }
    public static Road getRoad() {
        return road;
    }
    public static void setRoad(Road road) {
        RoadConstraction.road = road;
        System.out.println(road);
    }
    public static RoadType getRoadType() {
        return roadType;
    }
    public static void setRoadType(RoadType roadType) {
        RoadConstraction.roadType = roadType;
        System.out.println(roadType);
    }
    public static DesigionLoad getDesigionLoad() {
        return desigionLoad;
    }
    public static void setDesigionLoad(DesigionLoad desigionLoad) {
        RoadConstraction.desigionLoad = desigionLoad;
        System.out.println(desigionLoad);
    }
    public static Soils getSoils() {
        return soils;
    }
    public static void setSoils(Soils soils) {
        RoadConstraction.soils = soils;
        System.out.println(soils);
    }
    public static GroundType getGroundType() {
        return groundType;
    }
    public static void setGroundType(GroundType groundType) {
        RoadConstraction.groundType = groundType;
        humidityChoose();
        System.out.println(groundType);
    }
    public static Ground getGround() {
        return ground;
    }
    public static void setGround(Ground ground) {
        RoadConstraction.ground = ground;
        System.out.println(ground);
    }
    public static RoadLines getRoadLines() {
        return roadLines;
    }
    public static void setRoadLines(RoadLines roadLines) {
        RoadConstraction.roadLines = roadLines;
        System.out.println(roadLines);
    }
    public static GroundCorection getGroundCorection() {
        return groundCorection;
    }
    public static void setGroundCorection(GroundCorection groundCorection) {
        RoadConstraction.groundCorection = groundCorection;
        correctionChoose();
        System.out.println(groundCorection);
    }
    public static double getHumidity() {
        return humidity;
    }
    public static void setHumidity(double humidity) {
        RoadConstraction.humidity = humidity;
        System.out.println("humidity = "+humidity);
    }
    public static double getCorrection() {
        return correction;
    }
    public static void setCorrection(double correction) {
        RoadConstraction.correction = correction;
        System.out.println("correction = " + correction);
    }

    public static ArrayList<Bituminous> getBituminous() {
        return bituminous;
    }
    public static void setBituminous(ArrayList<Bituminous> bituminous) {
        RoadConstraction.bituminous = bituminous;
    }
    public static ArrayList<StrengthenedMaterial> getStrengthenedMaterials() {
        return strengthenedMaterials;
    }
    public static void setStrengthenedMaterials(ArrayList<StrengthenedMaterial> strengthenedMaterials) {
        RoadConstraction.strengthenedMaterials = strengthenedMaterials;
    }
    public static ArrayList<UnstrengthenedMaterial> getUnstrengthenedMaterialsCover() {
        return unstrengthenedMaterialsCover;
    }
    public static void setUnstrengthenedMaterialsCover(ArrayList<UnstrengthenedMaterial> unstrengthenedMaterialsCover) {
        RoadConstraction.unstrengthenedMaterialsCover = unstrengthenedMaterialsCover;
    }
    public static ArrayList<UnstrengthenedMaterial> getUnstrengthenedMaterialsBase() {
        return unstrengthenedMaterialsBase;
    }
    public static void setUnstrengthenedMaterialsBase(ArrayList<UnstrengthenedMaterial> unstrengthenedMaterialsBase) {
        RoadConstraction.unstrengthenedMaterialsBase = unstrengthenedMaterialsBase;
    }
    public static ArrayList<Sand> getSands() {
        return sands;
    }
    public static void setSands(ArrayList<Sand> sands) {
        RoadConstraction.sands = sands;
    }

    public static ArrayList<RoadLayers> getRoadLayers() {
        return roadLayers;
    }
    public static void setRoadLayers(ArrayList<RoadLayers> roadLayers) {
        RoadConstraction.roadLayers = roadLayers;
    }



    private static void humidityChoose(){
        if(getRoad().getName().equals("I-a") || getRoad().getName().equals("I-b") || getRoad().getName().equals("II")){
            setHumidity(getGroundType().getHumidity_1_2());
        }
        else if(getRoad().getName().equals("III") || getRoad().getName().equals("IV")){
            setHumidity(getGroundType().getHumidity_3_4());
        }
        else if(getRoad().getName().equals("V")){
            setHumidity(getGroundType().getHumidity_5());
        }
        else{
            System.out.println("Error");
        }
    }

    private static void correctionChoose(){
        if(getRoad().getName().equals("I-a") || getRoad().getName().equals("I-b")){
            setCorrection(getGroundCorection().getCorrection1());
        }
        else if(getRoad().getName().equals("II")){
            setCorrection(getGroundCorection().getCorrection2());
        }
        else if(getRoad().getName().equals("III")){
            setCorrection(getGroundCorection().getCorrection3());
        }
        else if(getRoad().getName().equals("IV")){
            setCorrection(getGroundCorection().getCorrection4());
        }
        else if(getRoad().getName().equals("V")){
            setCorrection(0.0);
        }
        else{
            System.out.println("Error");
        }
    }

    public static void layers(){
        roadLayers = new ArrayList<>();
        roadLayers.add(new RoadLayers("Асфальтобетон",bituminous));
        roadLayers.add(new RoadLayers("Матеріали і грунти укріплені в'яжучими речовинами",strengthenedMaterials));
        roadLayers.add(new RoadLayers("Неукріплені матеріали покриття",unstrengthenedMaterialsCover));
        roadLayers.add(new RoadLayers("Неукріплені матеріали основ",unstrengthenedMaterialsBase));
        roadLayers.add(new RoadLayers("Шар нев'язкого середовища",sands));
    }

    public static ArrayList<LayerT> layerTableList(){
        ArrayList<LayerT> layers = new ArrayList<>();
        int temp =1;
        for(RoadLayers roadLayers: roadLayers){
            for(Layer el:roadLayers.getLayers()){
//                String str = el.getName() + " " + el.getMaterial();
                layers.add(new LayerT(temp,roadLayers.getName(),el.getName() + " " + el.getMaterial(), el.getThickness()));
                temp++;
            }
        }
        return layers;
    }

}