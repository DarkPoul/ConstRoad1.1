package com.ntu.api.domain.listCreate;

import com.ntu.api.domain.Lists;
import com.ntu.api.domain.listCreate.Objects.*;
import com.ntu.api.domain.listCreate.Objects.Layers.*;

import java.io.File;
import java.util.ArrayList;


public class Main {
    private static String root = "/home/arsen/Java/ConstRoad/base";
    public static void main(String[] args) {
        start();
    }

    public static void start(){
        Writer writer = new Writer();
        Lists lists = new Lists();
        ArrayList<RBCZ> list = new ArrayList<>();

        list.add(new RBCZ("I", 145, 20));
        list.add(new RBCZ("II", 135, 25));
        list.add(new RBCZ("III", 130, 30));
        list.add(new RBCZ("IV West", 140, 35));
        list.add(new RBCZ("IV South", 120, 35));

        File file = new File(root + "/climateZoneList");
        writer.write(file, list);

        DesigionLoad a1 = new DesigionLoad("A1", 130, 65.0, 0.9, 0.303, 0.346, 0.0);
        DesigionLoad a2 = new DesigionLoad("A2", 115, 57.5, 0.8, 0.303, 0.345, 315.68);
        DesigionLoad a3 = new DesigionLoad("A3", 100, 50.0, 0.6, 0.326, 0.371, 350.21);
        DesigionLoad b = new DesigionLoad("B", 60, 30.0, 0.5, 0.276, 0.315, 409.4);

        ArrayList<DesigionLoad> capital1 = new ArrayList<>();
        capital1.add(a1);
        capital1.add(a2);

        ArrayList<DesigionLoad> capital2 = new ArrayList<>();
        capital2.add(a2);

        ArrayList<DesigionLoad> capital3 = new ArrayList<>();
        capital3.add(a3);

        ArrayList<DesigionLoad> lite = new ArrayList<>();
        lite.add(a3);

        ArrayList<DesigionLoad> transfer = new ArrayList<>();
        transfer.add(b);

        ArrayList<DesigionLoad> allDesignLoad = new ArrayList<>();
        allDesignLoad.add(a1);
        allDesignLoad.add(a2);
        allDesignLoad.add(a3);
        allDesignLoad.add(b);

        File fileDesigionLoad = new File(root + "/designLoad");
        writer.write(fileDesigionLoad, allDesignLoad);

        RoadType cap1RType = new RoadType("Капітальний", capital1);
        RoadType cap2RType = new RoadType("Капітальний", capital2);
        RoadType cap3RType = new RoadType("Капітальний", capital3);
        RoadType litRType = new RoadType("Вдосконалений полекшений", lite);
        RoadType transferRType = new RoadType("Перехідний", transfer);

        ArrayList<RoadType> type1_2= new ArrayList<>();
        ArrayList<RoadType> type3= new ArrayList<>();
        ArrayList<RoadType> type4= new ArrayList<>();
        ArrayList<RoadType> type5= new ArrayList<>();

        type1_2.add(cap1RType);
        type3.add(cap2RType);
        type3.add(litRType);
        type4.add(cap3RType);
        type4.add(litRType);
        type5.add(cap3RType);
        type5.add(litRType);
        type5.add(transferRType);

        ArrayList<RoadType> roadTypes = new ArrayList<>();
        roadTypes.addAll(type5);
        File fileRoadType = new File(root + "/roadTypeList");
        writer.write(fileRoadType, roadTypes);

        ArrayList<Integer> lanesNumber1a = new ArrayList<>();
        lanesNumber1a.add(4);
        lanesNumber1a.add(6);
        lanesNumber1a.add(8);
        ArrayList<Integer> lanesNumber1b = new ArrayList<>();
        lanesNumber1b.add(4);
        lanesNumber1b.add(6);
        ArrayList<Integer> lanesNumber2 = new ArrayList<>();
        lanesNumber2.add(2);
        ArrayList<Integer> lanesNumber3 = new ArrayList<>();
        lanesNumber3.add(2);
        ArrayList<Integer> lanesNumber4 = new ArrayList<>();
        lanesNumber4.add(2);
        ArrayList<Integer> lanesNumber5 = new ArrayList<>();
        lanesNumber5.add(1);

        ArrayList<Road> roadList = new ArrayList<>();
        roadList.add(new Road("I-a", 0.97, 1.875, 1.39, 1.5, 1.51, 0.12, 0.17, 0.16, 0.12, 0.08, 0.12, 1.97, type1_2, 260,0,0,150,1.51,lanesNumber1a,3.75d,3.75d,2.5d,0.75d,6.0d,0.75d, "понад 10000", "понад 14000"));
        roadList.add(new Road("I-b", 0.95, 1.645, 1.35, 1.43, 1.48, 0.12, 0.17, 0.18, 0.14, 0.1, 0.12, 1.71, type1_2, 250,0,0,150,1.57,lanesNumber1b,3.75d,3.75d,2.5d,0.5d,3.0d,0.5d, "понад 10000", "понад 14000"));
        roadList.add(new Road("II", 0.95, 1.645, 1.35, 1.43, 1.48, 0.12, 0.17, 0.18, 0.14, 0.1, 0.12, 1.71, type1_2,235,0,0,120,1.57,lanesNumber2,3.75d,3.75d,2.5d,0.5d,0.0d,0.0d, "від 3000 до 10000", "від 5000 до 14000"));
        roadList.add(new Road("III", 0.9, 1.28, 1.29, 1.33, 1.4, 0.14, 0.18, 0.2, 0.14, 0.1, 0.14, 1.32, type3,225,190,0,120,1.57,lanesNumber3,3.5d,2.5d,0.0d,0.5d,0.0d,0.0d,"від 1000 до 3000", "від 2000 до 5000"));
        roadList.add(new Road("IV", 0.85, 1.035, 1.27, 1.29, 1.38, 0.16, 0.2, 0.24, 0.16, 0.1, 0.16, 1.06, type4,190,150,0,80,1.57,lanesNumber4,3.0d,2.0d,0.0d,0.5d,0.0d,0.0d,"від 150 до 1000", "від 300 до 2500"));
        roadList.add(new Road("V", 0.75, 0.68, 1.19, 1.23, 1.25, 0.18, 0.26, 0.26, 0.18, 0.1, 0.18, 0.86, type5,150,100,50,0,1.98,lanesNumber5,4.5d,1.75d,0.0d,0.0d,0.0d,0.0d, "до 150", "300"));

        File fileRoad = new File(root + "/roadList");
        writer.write(fileRoad, roadList);

        ArrayList<GroundType> groundTypes1 = new ArrayList<>();
        groundTypes1.add(new GroundType("I.P.1","Супісок, пісок", 0.72, 0.69, null));
        groundTypes1.add(new GroundType("I.P.2","Суглинок", 0.74, 0.71, null));
        groundTypes1.add(new GroundType("I.P.3","Суглинок", 0.7, 0.67, null));
        groundTypes1.add(new GroundType("II.P.4","Суглинок", 0.69, 0.66, null));
        groundTypes1.add(new GroundType("II.P.5","Суглинок", 0.71, 0.68, null));
        groundTypes1.add(new GroundType("II.P.6","Суглинок важкий, глина", 0.61, 0.59, null));
        groundTypes1.add(new GroundType("IV.Г.7","Суглинок", 0.83, 0.8, null));
        groundTypes1.add(new GroundType("IV.Г.8","Суглинок важкий", 0.72, 0.69, null));
        groundTypes1.add(new GroundType("III.P.9","Суглинок важкий, глина", 0.61, 0.59, null));
        groundTypes1.add(new GroundType("III.P.10","Суглинок важкий, глина", 0.63, 0.6, null));
        groundTypes1.add(new GroundType("III.P.11","Суглинок важкий", 0.72, 0.69, null));
        groundTypes1.add(new GroundType("III.P.12","Суглинок важкий", 0.69, 0.66, null));
        groundTypes1.add(new GroundType("III.P.13","Суглинок важкий, глина", 0.58, 0.55, null));
        groundTypes1.add(new GroundType("III.P.14","Суглинок важкий", 0.56, 0.54, null));
        groundTypes1.add(new GroundType("III.P.15","Суглинок", 0.58, 0.56, null));
        groundTypes1.add(new GroundType("III.P.16","Суглинок", 0.57, 0.56, null));

        ArrayList<GroundType> groundTypes2 = new ArrayList<>();
        groundTypes2.add(new GroundType("I.P.1","Супісок, пісок", 0.74, 0.7, null));
        groundTypes2.add(new GroundType("I.P.2","Суглинок", 0.76, 0.73, null));
        groundTypes2.add(new GroundType("I.P.3","Суглинок", 0.71, 0.69, null));
        groundTypes2.add(new GroundType("II.P.4","Суглинок", 0.7, 0.68, null));
        groundTypes2.add(new GroundType("II.P.5","Суглинок", 0.72, 0.7, null));
        groundTypes2.add(new GroundType("II.P.6","Суглинок важкий, глина", 0.63, 0.6, null));
        groundTypes2.add(new GroundType("IV.Г.7","Суглинок", 0.85, 0.82, null));
        groundTypes2.add(new GroundType("IV.Г.8","Суглинок важкий", 0.74, 0.7, null));
        groundTypes2.add(new GroundType("III.P.9","Суглинок важкий, глина", 0.63, 0.6, null));
        groundTypes2.add(new GroundType("III.P.10","Суглинок важкий, глина", 0.64, 0.62, null));
        groundTypes2.add(new GroundType("III.P.11","Суглинок важкий", 0.74, 0.7, null));
        groundTypes2.add(new GroundType("III.P.12","Суглинок важкий", 0.7, 0.68, null));
        groundTypes2.add(new GroundType("III.P.13","Суглинок важкий, глина", 0.59, 0.56, null));
        groundTypes2.add(new GroundType("III.P.14","Суглинок важкий", 0.57, 0.55, null));
        groundTypes2.add(new GroundType("III.P.15","Суглинок", 0.6, 0.57, null));
        groundTypes2.add(new GroundType("III.P.16","Суглинок", 0.58, 0.57, null));

        ArrayList<GroundType> groundTypes3 = new ArrayList<>();
        groundTypes3.add(new GroundType("I.P.1","Супісок, пісок", 0.75, 0.72, null));
        groundTypes3.add(new GroundType("I.P.2","Суглинок", 0.78, 0.74, null));
        groundTypes3.add(new GroundType("I.P.3","Суглинок", 0.74, 0.7, null));
        groundTypes3.add(new GroundType("II.P.4","Суглинок", 0.72, 0.69, null));
        groundTypes3.add(new GroundType("II.P.5","Суглинок", 0.74, 0.71, null));
        groundTypes3.add(new GroundType("II.P.6","Суглинок важкий, глина", 0.64, 0.61, null));
        groundTypes3.add(new GroundType("IV.Г.7","Суглинок", 0.87, 0.83, null));
        groundTypes3.add(new GroundType("IV.Г.8","Суглинок важкий", 0.75, 0.72, null));
        groundTypes3.add(new GroundType("III.P.9","Суглинок важкий, глина", 0.64, 0.61, null));
        groundTypes3.add(new GroundType("III.P.10","Суглинок важкий, глина", 0.66, 0.63, null));
        groundTypes3.add(new GroundType("III.P.11","Суглинок важкий", 0.75, 0.72, null));
        groundTypes3.add(new GroundType("III.P.12","Суглинок важкий", 0.72, 0.69, null));
        groundTypes3.add(new GroundType("III.P.13","Суглинок важкий, глина", 0.61, 0.58, null));
        groundTypes3.add(new GroundType("III.P.14","Суглинок важкий", 0.59, 0.56, null));
        groundTypes3.add(new GroundType("III.P.15","Суглинок", 0.61, 0.58, null));
        groundTypes3.add(new GroundType("III.P.16","Суглинок", 0.6, 0.57, null));

        ArrayList<GroundType> groundTypes4 = new ArrayList<>();
        groundTypes4.add(new GroundType("I.P.1","Супісок, пісок", 0.65, 0.62, null));
        groundTypes4.add(new GroundType("I.P.2","Суглинок", 0.67, 0.65, null));
        groundTypes4.add(new GroundType("I.P.3","Суглинок", 0.63, 0.61, null));
        groundTypes4.add(new GroundType("II.P.4","Суглинок", 0.62, 0.6, null));
        groundTypes4.add(new GroundType("II.P.5","Суглинок", 0.64, 0.62, null));
        groundTypes4.add(new GroundType("II.P.6","Суглинок важкий, глина", 0.55, 0.53, null));
        groundTypes4.add(new GroundType("IV.Г.7","Суглинок", 0.75, 0.72, null));
        groundTypes4.add(new GroundType("IV.Г.8","Суглинок важкий", 0.65, 0.62, null));
        groundTypes4.add(new GroundType("III.P.9","Суглинок важкий, глина", 0.55, 0.53, null));
        groundTypes4.add(new GroundType("III.P.10","Суглинок важкий, глина", 0.57, 0.55, null));
        groundTypes4.add(new GroundType("III.P.11","Суглинок важкий", 0.65, 0.62, null));
        groundTypes4.add(new GroundType("III.P.12","Суглинок важкий", 0.62, 0.6, null));
        groundTypes4.add(new GroundType("III.P.13","Суглинок важкий, глина", 0.52, 0.5, null));
        groundTypes4.add(new GroundType("III.P.14","Суглинок важкий", 0.51, 0.49, null));
        groundTypes4.add(new GroundType("III.P.15","Суглинок", 0.53, 0.51, null));
        groundTypes4.add(new GroundType("III.P.16","Суглинок", 0.52, 0.51, null));

        ArrayList<GroundType> groundTypes5 = new ArrayList<>();
        groundTypes5.add(new GroundType("I.P.1","Супісок, пісок", 0.66, 0.63, null));
        groundTypes5.add(new GroundType("I.P.2","Суглинок", 0.68, 0.66, null));
        groundTypes5.add(new GroundType("I.P.3","Суглинок", 0.64, 0.62, null));
        groundTypes5.add(new GroundType("II.P.4","Суглинок", 0.63, 0.61, null));
        groundTypes5.add(new GroundType("II.P.5","Суглинок", 0.65, 0.63, null));
        groundTypes5.add(new GroundType("II.P.6","Суглинок важкий, глина", 0.56, 0.54, null));
        groundTypes5.add(new GroundType("IV.Г.7","Суглинок", 0.76, 0.73, null));
        groundTypes5.add(new GroundType("IV.Г.8","Суглинок важкий", 0.66, 0.63, null));
        groundTypes5.add(new GroundType("III.P.9","Суглинок важкий, глина", 0.56, 0.54, null));
        groundTypes5.add(new GroundType("III.P.10","Суглинок важкий, глина", 0.58, 0.55, null));
        groundTypes5.add(new GroundType("III.P.11","Суглинок важкий", 0.66, 0.63, null));
        groundTypes5.add(new GroundType("III.P.12","Суглинок важкий", 0.63, 0.61, null));
        groundTypes5.add(new GroundType("III.P.13","Суглинок важкий, глина", 0.53, 0.51, null));
        groundTypes5.add(new GroundType("III.P.14","Суглинок важкий", 0.52, 0.5, null));
        groundTypes5.add(new GroundType("III.P.15","Суглинок", 0.54, 0.51, null));
        groundTypes5.add(new GroundType("III.P.16","Суглинок", 0.52, 0.51, null));

        ArrayList<Soils> soils = new ArrayList<>();
        soils.add(new Soils("Грунти при глибокому заляганні грунтових вод, забезпеченому водовідводі та наявності шару основи з дискретних матеріалів", groundTypes1));
        soils.add(new Soils("Грунти при глибокому заляганні грунтових вод, тривалому застої води та наявності шару основи з дискретних матеріалів", groundTypes2));
        soils.add(new Soils("Грунти при близькому заляганні грунтових вод та наявності шару основи з дискретних матеріалів", groundTypes3));
        soils.add(new Soils("Грунти при глибокому заляганні грунтових вод, забезпеченому водовідводі та наявності щільного монолітного нижнього шару основ", groundTypes4));
        soils.add(new Soils("Грунти при глибокому заляганні грунтових вод, тривалому застої води та наявності щільного монолітного нижнього шару основи", groundTypes5));

        File filesoils = new File(root + "/soils");
        writer.write(filesoils, soils);


        ArrayList<GroundWtParameters> g1 = new ArrayList<>();
        g1.add(new GroundWtParameters("0,5", 0.5,130.0,35.0,0.004));
        g1.add(new GroundWtParameters("0,55", 0.55,130.0,35.0,0.004));
        g1.add(new GroundWtParameters("0,6", 0.6,130.0,35.0,0.004));
        g1.add(new GroundWtParameters("0,65", 0.65,130.0,35.0,0.004));
        g1.add(new GroundWtParameters("0,7", 0.7,130.0,35.0,0.004));
        g1.add(new GroundWtParameters("0,75", 0.75,130.0,35.0,0.004));
        g1.add(new GroundWtParameters("0,8", 0.8,130.0,35.0,0.004));
        g1.add(new GroundWtParameters("0,85", 0.85,130.0,35.0,0.004));
        g1.add(new GroundWtParameters("0,9", 0.9,130.0,35.0,0.004));

        ArrayList<GroundWtParameters> g2 = new ArrayList<>();
        g2.add(new GroundWtParameters("0,5", 0.5,120.0,32.0,0.004));
        g2.add(new GroundWtParameters("0,55", 0.55,120.0,32.0,0.004));
        g2.add(new GroundWtParameters("0,6", 0.6,120.0,32.0,0.004));
        g2.add(new GroundWtParameters("0,65", 0.65,120.0,32.0,0.004));
        g2.add(new GroundWtParameters("0,7", 0.7,120.0,32.0,0.004));
        g2.add(new GroundWtParameters("0,75", 0.75,120.0,32.0,0.004));
        g2.add(new GroundWtParameters("0,8", 0.8,120.0,32.0,0.004));
        g2.add(new GroundWtParameters("0,85", 0.85,120.0,32.0,0.004));
        g2.add(new GroundWtParameters("0,9", 0.9,120.0,32.0,0.004));

        ArrayList<GroundWtParameters> g3 = new ArrayList<>();
        g3.add(new GroundWtParameters("0,5", 0.5,100.0,31.0,0.003));
        g3.add(new GroundWtParameters("0,55", 0.55,100.0,31.0,0.003));
        g3.add(new GroundWtParameters("0,6", 0.6,100.0,31.0,0.003));
        g3.add(new GroundWtParameters("0,65", 0.65,100.0,31.0,0.003));
        g3.add(new GroundWtParameters("0,7", 0.7,100.0,31.0,0.003));
        g3.add(new GroundWtParameters("0,75", 0.75,100.0,31.0,0.003));
        g3.add(new GroundWtParameters("0,8", 0.8,100.0,31.0,0.003));
        g3.add(new GroundWtParameters("0,85", 0.85,100.0,31.0,0.003));
        g3.add(new GroundWtParameters("0,9", 0.9,100.0,31.0,0.003));

        ArrayList<GroundWtParameters> g4 = new ArrayList<>();
        g4.add(new GroundWtParameters("0,5", 0.5,75.0,31.0,0.003));
        g4.add(new GroundWtParameters("0,55", 0.55,75.0,31.0,0.003));
        g4.add(new GroundWtParameters("0,6", 0.6,75.0,31.0,0.003));
        g4.add(new GroundWtParameters("0,65", 0.65,75.0,31.0,0.003));
        g4.add(new GroundWtParameters("0,7", 0.7,75.0,31.0,0.003));
        g4.add(new GroundWtParameters("0,75", 0.75,75.0,31.0,0.003));
        g4.add(new GroundWtParameters("0,8", 0.8,75.0,31.0,0.003));
        g4.add(new GroundWtParameters("0,85", 0.85,75.0,31.0,0.003));
        g4.add(new GroundWtParameters("0,9", 0.9,75.0,31.0,0.003));

        ArrayList<GroundWtParameters> g5 = new ArrayList<>();
        g5.add(new GroundWtParameters("0,5", 0.5,96.0,38.0,0.026));
        g5.add(new GroundWtParameters("0,55", 0.55,90.0,38.0,0.024));
        g5.add(new GroundWtParameters("0,6", 0.6,84.0,37.0,0.022));
        g5.add(new GroundWtParameters("0,65", 0.65,78.0,37.0,0.018));
        g5.add(new GroundWtParameters("0,7", 0.7,72.0,36.0,0.014));
        g5.add(new GroundWtParameters("0,75", 0.75,60.0,35.0,0.012));
        g5.add(new GroundWtParameters("0,8", 0.8,60.0,34.0,0.011));
        g5.add(new GroundWtParameters("0,85", 0.85,54.0,33.0,0.01));
        g5.add(new GroundWtParameters("0,9", 0.9,48.0,32.0,0.009));

        ArrayList<GroundWtParameters> g6 = new ArrayList<>();
        g6.add(new GroundWtParameters("0,5", 0.5,108.0,32.0,0.022));
        g6.add(new GroundWtParameters("0,55", 0.55,108.0,30.0,0.016));
        g6.add(new GroundWtParameters("0,6", 0.6,100.0,29.0,0.014));
        g6.add(new GroundWtParameters("0,65", 0.65,100.0,28.0,0.013));
        g6.add(new GroundWtParameters("0,7", 0.7,79.0,27.0,0.011));
        g6.add(new GroundWtParameters("0,75", 0.75,69.0,26.0,0.01));
        g6.add(new GroundWtParameters("0,8", 0.8,62.0,25.0,0.007));
        g6.add(new GroundWtParameters("0,85", 0.85,54.0,23.0,0.005));
        g6.add(new GroundWtParameters("0,9", 0.9,50.0,22.0,0.0));

        ArrayList<GroundWtParameters> g7 = new ArrayList<>();
        g7.add(new GroundWtParameters("0,5", 0.5,108.0,32.0,0.022));
        g7.add(new GroundWtParameters("0,55", 0.55,108.0,30.0,0.02));
        g7.add(new GroundWtParameters("0,6", 0.6,100.0,29.0,0.014));
        g7.add(new GroundWtParameters("0,65", 0.65,100.0,28.0,0.013));
        g7.add(new GroundWtParameters("0,7", 0.7,79.0,27.0,0.011));
        g7.add(new GroundWtParameters("0,75", 0.75,69.0,26.0,0.01));
        g7.add(new GroundWtParameters("0,8", 0.8,62.0,25.0,0.007));
        g7.add(new GroundWtParameters("0,85", 0.85,54.0,23.0,0.005));
        g7.add(new GroundWtParameters("0,9", 0.9,50.0,22.0,0.0));

        ArrayList<GroundWtParameters> g8 = new ArrayList<>();
        g8.add(new GroundWtParameters("0,5", 0.5,108.0,27.0,0.035));
        g8.add(new GroundWtParameters("0,55", 0.55,100.0,25.0,0.026));
        g8.add(new GroundWtParameters("0,6", 0.6,77.0,23.0,0.024));
        g8.add(new GroundWtParameters("0,65", 0.65,64.0,21.0,0.018));
        g8.add(new GroundWtParameters("0,7", 0.7,52.0,19.0,0.014));
        g8.add(new GroundWtParameters("0,75", 0.75,42.0,18.0,0.011));
        g8.add(new GroundWtParameters("0,8", 0.8,34.0,16.0,0.009));
        g8.add(new GroundWtParameters("0,85", 0.85,27.0,13.0,0.006));
        g8.add(new GroundWtParameters("0,9", 0.9,23.0,11.0,0.004));

        ArrayList<GroundWtParameters> g9 = new ArrayList<>();
        g9.add(new GroundWtParameters("0,5", 0.5,108.0,28.0,0.04));
        g9.add(new GroundWtParameters("0,55", 0.55,100.0,25.0,0.03));
        g9.add(new GroundWtParameters("0,6", 0.6,77.0,24.0,0.03));
        g9.add(new GroundWtParameters("0,65", 0.65,64.0,22.0,0.019));
        g9.add(new GroundWtParameters("0,7", 0.7,52.0,20.0,0.015));
        g9.add(new GroundWtParameters("0,75", 0.75,42.0,18.0,0.012));
        g9.add(new GroundWtParameters("0,8", 0.8,34.0,16.0,0.009));
        g9.add(new GroundWtParameters("0,85", 0.85,27.0,14.0,0.007));
        g9.add(new GroundWtParameters("0,9", 0.9,23.0,11.0,0.005));

        ArrayList<GroundWtParameters> g10 = new ArrayList<>();
        g10.add(new GroundWtParameters("0,5", 0.5,100.0,25.0,0.05));
        g10.add(new GroundWtParameters("0,55", 0.55,80.0,22.0,0.035));
        g10.add(new GroundWtParameters("0,6", 0.6,62.0,20.0,0.03));
        g10.add(new GroundWtParameters("0,65", 0.65,49.0,18.0,0.022));
        g10.add(new GroundWtParameters("0,7", 0.7,38.0,15.0,0.016));
        g10.add(new GroundWtParameters("0,75", 0.75,29.0,13.0,0.013));
        g10.add(new GroundWtParameters("0,8", 0.8,21.0,10.0,0.01));
        g10.add(new GroundWtParameters("0,85", 0.85,13.0,7.0,0.008));
        g10.add(new GroundWtParameters("0,9", 0.9,10.0,0.0,0.007));

        ArrayList<GroundWtParameters> g11 = new ArrayList<>();
        g11.add(new GroundWtParameters("0,5", 0.5,100.0,25.0,0.05));
        g11.add(new GroundWtParameters("0,55", 0.55,80.0,22.0,0.035));
        g11.add(new GroundWtParameters("0,6", 0.6,62.0,20.0,0.03));
        g11.add(new GroundWtParameters("0,65", 0.65,49.0,18.0,0.022));
        g11.add(new GroundWtParameters("0,7", 0.7,38.0,15.0,0.016));
        g11.add(new GroundWtParameters("0,75", 0.75,29.0,13.0,0.013));
        g11.add(new GroundWtParameters("0,8", 0.8,21.0,10.0,0.01));
        g11.add(new GroundWtParameters("0,85", 0.85,13.0,7.0,0.008));
        g11.add(new GroundWtParameters("0,9", 0.9,10.0,0.0,0.007));

        ArrayList<GroundWtParameters> g12 = new ArrayList<>();
        g12.add(new GroundWtParameters("0,5", 0.5,82.0,23.0,0.06));
        g12.add(new GroundWtParameters("0,55", 0.55,62.0,20.0,0.04));
        g12.add(new GroundWtParameters("0,6", 0.6,51.0,17.0,0.032));
        g12.add(new GroundWtParameters("0,65", 0.65,34.0,15.0,0.024));
        g12.add(new GroundWtParameters("0,7", 0.7,24.0,12.0,0.02));
        g12.add(new GroundWtParameters("0,75", 0.75,17.0,8.0,0.02));
        g12.add(new GroundWtParameters("0,8", 0.8,10.0,3.0,0.01));
        g12.add(new GroundWtParameters("0,85", 0.85,5.0,0.0,0.008));
        g12.add(new GroundWtParameters("0,9", 0.9,0.0,0.0,0.01));

        ArrayList<GroundWtParameters> g13 = new ArrayList<>();
        g13.add(new GroundWtParameters("0,5", 0.5,82.0,23.0,0.06));
        g13.add(new GroundWtParameters("0,55", 0.55,62.0,20.0,0.04));
        g13.add(new GroundWtParameters("0,6", 0.6,51.0,17.0,0.032));
        g13.add(new GroundWtParameters("0,65", 0.65,34.0,15.0,0.024));
        g13.add(new GroundWtParameters("0,7", 0.7,24.0,12.0,0.02));
        g13.add(new GroundWtParameters("0,75", 0.75,17.0,8.0,0.02));
        g13.add(new GroundWtParameters("0,8", 0.8,10.0,3.0,0.01));
        g13.add(new GroundWtParameters("0,85", 0.85,5.0,0.0,0.008));
        g13.add(new GroundWtParameters("0,9", 0.9,0.0,0.0,0.01));

        ArrayList<GroundWtParameters> g14 = new ArrayList<>();
        g14.add(new GroundWtParameters("0,5", 0.5,70.0,22.0,0.06));
        g14.add(new GroundWtParameters("0,55", 0.55,48.0,19.0,0.044));
        g14.add(new GroundWtParameters("0,6", 0.6,34.0,16.0,0.034));
        g14.add(new GroundWtParameters("0,65", 0.65,24.0,13.0,0.025));
        g14.add(new GroundWtParameters("0,7", 0.7,16.0,10.0,0.02));
        g14.add(new GroundWtParameters("0,75", 0.75,10.0,5.0,0.015));
        g14.add(new GroundWtParameters("0,8", 0.8,5.0,0.0,0.01));
        g14.add(new GroundWtParameters("0,85", 0.85,4.0,0.0,0.006));
        g14.add(new GroundWtParameters("0,9", 0.9,0.0,0.0,0.0));

        ArrayList<Ground> grounds = new ArrayList<>();
        grounds.add(new Ground("G1 Пісок крупний","-","-",7.0, 0.05, 0.37, g1));
        grounds.add(new Ground("G2 Пісок середньої крупності","-","-",6.0, 0.07, 0.37, g2));
        grounds.add(new Ground("G3 Пісок дрібний","-","-",5.0, 0.1, 0.36, g3));
        grounds.add(new Ground("G4 Пісок однорідний","-","-",5.0, 0.12, 0.34, g4));
        grounds.add(new Ground("G5 Пісок пилуватий","-","-",3.0, 0.14, 0.31, g5));
        grounds.add(new Ground("G6 Супісок піщанистий","від 1 до 7","більше 50",3.0, 0.18, 0.27, g6));
        grounds.add(new Ground("G7 Супісок пилуватий","від 1 до 7","більше 50",1.5, 0.2, 0.33, g7));
        grounds.add(new Ground("G8 Суглинок легкий піщанистий","від 7 до 12","більше 40",1.5, 0.2, 0.27, g8));
        grounds.add(new Ground("G9 Суглинок легкий пилуватий","від 7 до 12","менше 40",1.5, 0.2, 0.27, g9));
        grounds.add(new Ground("G10 Суглинок важкий піщанистий","від 12 до 17","більше 40",1.5, 0.2, 0.27, g10));
        grounds.add(new Ground("G11 Суглинок важкий пилуватий","від 12 до 17","менше 40",1.5, 0.2, 0.27, g11));
        grounds.add(new Ground("G12 Глина легка піщаниста","від 17 до 27","більше 40",1.5, 0.22, 0.27, g12));
        grounds.add(new Ground("G13 Глина легка пилувата","від 17 до 27","менше 40",1.5, 0.22, 0.27, g13));
        grounds.add(new Ground("G14 Глина важка","більше 27","не нормується",1.5, 0.22, 0.27, g14));

        File fileground = new File(root + "/ground");
        writer.write(fileground, grounds);

        ArrayList<GroundCorection> groundCor = new ArrayList<>();
        groundCor.add(new GroundCorection("Відсутній", 0.0, 0.0, 0.0, 0.0));
        groundCor.add(new GroundCorection("W1 голкопробивний геотекстиль в контакті з грунтами", 0.03, 0.03, 0.03, 0.03));
        groundCor.add(new GroundCorection("W2 голкопробивний геотекстиль в контакті з грунтами", 0.06, 0.06, 0.06, 0.06));
        groundCor.add(new GroundCorection("W3 голкопробивний геотекстиль в контакті з суглинками і глинами", 0.05, 0.05, 0.05, 0.04));
        groundCor.add(new GroundCorection("W4 голкопробивний геотекстиль в контакті з супісками і пісками", 0.07, 0.07, 0.06, 0.05));
        groundCor.add(new GroundCorection("W5 дренажні композити", 0.08, 0.08, 0.06, 0.05));
        groundCor.add(new GroundCorection("W6 термоскріплені геотекстиль з жорстким ядром", 0.05, 0.03, 0.0, 0.0));
        groundCor.add(new GroundCorection("W7 дренаж", 0.08, 0.08, 0.06, 0.05));
        groundCor.add(new GroundCorection("W8 дренаж з повздовжніми трубчастими дренами", 0.05, 0.05, 0.03, 0.03 ));
        groundCor.add(new GroundCorection("W9 дренаж з зернистого матеріалу в обоймі з геосинтетичного матеріалу з дренажною трубою", 1.03, 1.03, 1.03, 1.03));
        groundCor.add(new GroundCorection("W10 влаштування гідроізолюючих водопаронепроникних прошарків з полімерних матеріалів", 0.05, 0.05, 0.03, 0.03 ));

        File groundCorection = new File(root + "/groundCorection");
        writer.write(groundCorection, groundCor);

        ArrayList<RoadLines> roadLines = new ArrayList<>();
        roadLines.add(new RoadLines("1",1,1d,0d,0d,0d));
        roadLines.add(new RoadLines("2",2,0.55d,0d,0d,0d));
        roadLines.add(new RoadLines("3",3,0.5d,0.35d,0d,0d));
        roadLines.add(new RoadLines("4",4,0.35d,0.2d,0d,0d));
        roadLines.add(new RoadLines("6",6,0.35d,0.2d,0.05d,0d));
        roadLines.add(new RoadLines("8",8,0.3d,0.2d,0.05d,0.01d));

        File roadLine = new File(root, "/roadLines");
        writer.write(roadLine,roadLines);

        ArrayList<ElasticModul> elasticModulsAshm1 = new ArrayList<>();
        elasticModulsAshm1.add(new ElasticModul(10, 6000));
        elasticModulsAshm1.add(new ElasticModul(20, 4000));
        elasticModulsAshm1.add(new ElasticModul(25, 3350));
        elasticModulsAshm1.add(new ElasticModul(30, 2700));
        elasticModulsAshm1.add(new ElasticModul(35, 1950));
        elasticModulsAshm1.add(new ElasticModul(40, 1200));

        ArrayList<ElasticModul> elasticModulsAshm2 = new ArrayList<>();
        elasticModulsAshm2.add(new ElasticModul(10, 5000));
        elasticModulsAshm2.add(new ElasticModul(20, 3800));
        elasticModulsAshm2.add(new ElasticModul(25, 3150));
        elasticModulsAshm2.add(new ElasticModul(30, 2500));
        elasticModulsAshm2.add(new ElasticModul(35, 1750));
        elasticModulsAshm2.add(new ElasticModul(40, 1000));

        ArrayList<ElasticModul> elasticModulsAsh1 = new ArrayList<>();
        elasticModulsAsh1.add(new ElasticModul(10, 4400));
        elasticModulsAsh1.add(new ElasticModul(20, 2600));
        elasticModulsAsh1.add(new ElasticModul(25, 1950));
        elasticModulsAsh1.add(new ElasticModul(30, 1300));
        elasticModulsAsh1.add(new ElasticModul(35, 995));
        elasticModulsAsh1.add(new ElasticModul(40, 690));

        ArrayList<ElasticModul> elasticModulsAsh2 = new ArrayList<>();
        elasticModulsAsh2.add(new ElasticModul(10, 3200));
        elasticModulsAsh2.add(new ElasticModul(20, 1800));
        elasticModulsAsh2.add(new ElasticModul(25, 1350));
        elasticModulsAsh2.add(new ElasticModul(30, 900));
        elasticModulsAsh2.add(new ElasticModul(35, 725));
        elasticModulsAsh2.add(new ElasticModul(40, 550));

        ArrayList<ElasticModul> elasticModulsAsh3 = new ArrayList<>();
        elasticModulsAsh3.add(new ElasticModul(10, 2400));
        elasticModulsAsh3.add(new ElasticModul(20, 1200));
        elasticModulsAsh3.add(new ElasticModul(25, 930));
        elasticModulsAsh3.add(new ElasticModul(30, 660));
        elasticModulsAsh3.add(new ElasticModul(35, 550));
        elasticModulsAsh3.add(new ElasticModul(40, 440));

        ArrayList<ElasticModul> elasticModulsAsh4 = new ArrayList<>();
        elasticModulsAsh4.add(new ElasticModul(10, 1500));
        elasticModulsAsh4.add(new ElasticModul(20, 800));
        elasticModulsAsh4.add(new ElasticModul(25, 680));
        elasticModulsAsh4.add(new ElasticModul(30, 560));
        elasticModulsAsh4.add(new ElasticModul(35, 470));
        elasticModulsAsh4.add(new ElasticModul(40, 380));

        ArrayList<ElasticModul> elasticModulsAp1 = new ArrayList<>();
        elasticModulsAp1.add(new ElasticModul(10, 2800));
        elasticModulsAp1.add(new ElasticModul(20, 1700));
        elasticModulsAp1.add(new ElasticModul(25, 1300));
        elasticModulsAp1.add(new ElasticModul(30, 900));
        elasticModulsAp1.add(new ElasticModul(35, 720));
        elasticModulsAp1.add(new ElasticModul(40, 540));

        ArrayList<ElasticModul> elasticModulsAp2 = new ArrayList<>();
        elasticModulsAp2.add(new ElasticModul(10, 2000));
        elasticModulsAp2.add(new ElasticModul(20, 1200));
        elasticModulsAp2.add(new ElasticModul(25, 950));
        elasticModulsAp2.add(new ElasticModul(30, 700));
        elasticModulsAp2.add(new ElasticModul(35, 580));
        elasticModulsAp2.add(new ElasticModul(40, 460));

        ArrayList<ElasticModul> elasticModulsAp3 = new ArrayList<>();
        elasticModulsAp3.add(new ElasticModul(10, 1400));
        elasticModulsAp3.add(new ElasticModul(20, 800));
        elasticModulsAp3.add(new ElasticModul(25, 655));
        elasticModulsAp3.add(new ElasticModul(30, 510));
        elasticModulsAp3.add(new ElasticModul(35, 445));
        elasticModulsAp3.add(new ElasticModul(40, 380));

        ArrayList<ElasticModul> elasticModulsAp4 = new ArrayList<>();
        elasticModulsAp4.add(new ElasticModul(10, 1100));
        elasticModulsAp4.add(new ElasticModul(20, 590));
        elasticModulsAp4.add(new ElasticModul(25, 500));
        elasticModulsAp4.add(new ElasticModul(30, 410));
        elasticModulsAp4.add(new ElasticModul(35, 375));
        elasticModulsAp4.add(new ElasticModul(40, 340));

        ArrayList<ElasticModul> elasticModulsAvp1 = new ArrayList<>();
        elasticModulsAvp1.add(new ElasticModul(10, 2800));
        elasticModulsAvp1.add(new ElasticModul(20, 1700));
        elasticModulsAvp1.add(new ElasticModul(25, 1300));
        elasticModulsAvp1.add(new ElasticModul(30, 900));
        elasticModulsAvp1.add(new ElasticModul(35, 720));
        elasticModulsAvp1.add(new ElasticModul(40, 540));

        ArrayList<ElasticModul> elasticModulsAvp2 = new ArrayList<>();
        elasticModulsAvp2.add(new ElasticModul(10, 2000));
        elasticModulsAvp2.add(new ElasticModul(20, 1200));
        elasticModulsAvp2.add(new ElasticModul(25, 950));
        elasticModulsAvp2.add(new ElasticModul(30, 700));
        elasticModulsAvp2.add(new ElasticModul(35, 580));
        elasticModulsAvp2.add(new ElasticModul(40, 460));

        ArrayList<ElasticModul> elasticModulsAvp3 = new ArrayList<>();
        elasticModulsAvp3.add(new ElasticModul(10, 1400));
        elasticModulsAvp3.add(new ElasticModul(20, 800));
        elasticModulsAvp3.add(new ElasticModul(25, 655));
        elasticModulsAvp3.add(new ElasticModul(30, 510));
        elasticModulsAvp3.add(new ElasticModul(35, 445));
        elasticModulsAvp3.add(new ElasticModul(40, 380));

        ArrayList<ElasticModul> elasticModulsShma1 = new ArrayList<>();
        elasticModulsShma1.add(new ElasticModul(10, 3600));
        elasticModulsShma1.add(new ElasticModul(20, 2200));
        elasticModulsShma1.add(new ElasticModul(25, 1750));
        elasticModulsShma1.add(new ElasticModul(30, 1250));
        elasticModulsShma1.add(new ElasticModul(35, 925));
        elasticModulsShma1.add(new ElasticModul(40, 600));

        ArrayList<ElasticModul> elasticModulsShma2 = new ArrayList<>();
        elasticModulsShma2.add(new ElasticModul(10, 3300));
        elasticModulsShma2.add(new ElasticModul(20, 2100));
        elasticModulsShma2.add(new ElasticModul(25, 1600));
        elasticModulsShma2.add(new ElasticModul(30, 1100));
        elasticModulsShma2.add(new ElasticModul(35, 825));
        elasticModulsShma2.add(new ElasticModul(40, 550));

        ArrayList<ElasticModul> elasticModulsShma3 = new ArrayList<>();
        elasticModulsShma3.add(new ElasticModul(10, 3000));
        elasticModulsShma3.add(new ElasticModul(20, 1900));
        elasticModulsShma3.add(new ElasticModul(25, 1500));
        elasticModulsShma3.add(new ElasticModul(30, 1100));
        elasticModulsShma3.add(new ElasticModul(35, 805));
        elasticModulsShma3.add(new ElasticModul(40, 510));

        ArrayList<ElasticModul> elasticModulsShma4 = new ArrayList<>();
        elasticModulsShma4.add(new ElasticModul(10, 2800));
        elasticModulsShma4.add(new ElasticModul(20, 1800));
        elasticModulsShma4.add(new ElasticModul(25, 1400));
        elasticModulsShma4.add(new ElasticModul(30, 1000));
        elasticModulsShma4.add(new ElasticModul(35, 750));
        elasticModulsShma4.add(new ElasticModul(40, 500));

        ArrayList<ElasticModul> elasticModulsShma5 = new ArrayList<>();
        elasticModulsShma5.add(new ElasticModul(10, 2700));
        elasticModulsShma5.add(new ElasticModul(20, 1700));
        elasticModulsShma5.add(new ElasticModul(25, 1325));
        elasticModulsShma5.add(new ElasticModul(30, 950));
        elasticModulsShma5.add(new ElasticModul(35, 710));
        elasticModulsShma5.add(new ElasticModul(40, 470));

        ArrayList<ElasticModul> elasticModulsShma6 = new ArrayList<>();
        elasticModulsShma6.add(new ElasticModul(10, 2600));
        elasticModulsShma6.add(new ElasticModul(20, 1600));
        elasticModulsShma6.add(new ElasticModul(25, 1250));
        elasticModulsShma6.add(new ElasticModul(30, 900));
        elasticModulsShma6.add(new ElasticModul(35, 680));
        elasticModulsShma6.add(new ElasticModul(40, 460));

        ArrayList<ElasticModul> elasticModulsShma7 = new ArrayList<>();
        elasticModulsShma7.add(new ElasticModul(10, 2500));
        elasticModulsShma7.add(new ElasticModul(20, 1600));
        elasticModulsShma7.add(new ElasticModul(25, 1200));
        elasticModulsShma7.add(new ElasticModul(30, 800));
        elasticModulsShma7.add(new ElasticModul(35, 600));
        elasticModulsShma7.add(new ElasticModul(40, 400));

        ArrayList<ElasticModul> elasticModulsShma8 = new ArrayList<>();
        elasticModulsShma8.add(new ElasticModul(10, 2400));
        elasticModulsShma8.add(new ElasticModul(20, 1500));
        elasticModulsShma8.add(new ElasticModul(25, 1125));
        elasticModulsShma8.add(new ElasticModul(30, 750));
        elasticModulsShma8.add(new ElasticModul(35, 570));
        elasticModulsShma8.add(new ElasticModul(40, 390));

        ArrayList<ElasticModul> elasticModulsShma9 = new ArrayList<>();
        elasticModulsShma9.add(new ElasticModul(10, 3900));
        elasticModulsShma9.add(new ElasticModul(20, 2700));
        elasticModulsShma9.add(new ElasticModul(25, 2200));
        elasticModulsShma9.add(new ElasticModul(30, 1700));
        elasticModulsShma9.add(new ElasticModul(35, 1275));
        elasticModulsShma9.add(new ElasticModul(40, 850));

        ArrayList<ElasticModul> elasticModulsShma10 = new ArrayList<>();
        elasticModulsShma10.add(new ElasticModul(10, 3500));
        elasticModulsShma10.add(new ElasticModul(20, 2300));
        elasticModulsShma10.add(new ElasticModul(25, 1900));
        elasticModulsShma10.add(new ElasticModul(30, 1500));
        elasticModulsShma10.add(new ElasticModul(35, 1125));
        elasticModulsShma10.add(new ElasticModul(40, 750));

        ArrayList<ElasticModul> elasticModulsShma11 = new ArrayList<>();
        elasticModulsShma11.add(new ElasticModul(10, 3100));
        elasticModulsShma11.add(new ElasticModul(20, 2000));
        elasticModulsShma11.add(new ElasticModul(25, 1625));
        elasticModulsShma11.add(new ElasticModul(30, 1250));
        elasticModulsShma11.add(new ElasticModul(35, 975));
        elasticModulsShma11.add(new ElasticModul(40, 700));

        ArrayList<ElasticModul> elasticModulsShma12 = new ArrayList<>();
        elasticModulsShma12.add(new ElasticModul(10, 2700));
        elasticModulsShma12.add(new ElasticModul(20, 1800));
        elasticModulsShma12.add(new ElasticModul(25, 1450));
        elasticModulsShma12.add(new ElasticModul(30, 1100));
        elasticModulsShma12.add(new ElasticModul(35, 850));
        elasticModulsShma12.add(new ElasticModul(40, 600));

        ArrayList<ElasticModul> staticModulsAshC1 = new ArrayList<>();
        staticModulsAshC1.add(new ElasticModul(20, 400));
        staticModulsAshC1.add(new ElasticModul(25, 375));
        staticModulsAshC1.add(new ElasticModul(30, 350));
        staticModulsAshC1.add(new ElasticModul(35, 325));
        staticModulsAshC1.add(new ElasticModul(40, 300));

        ArrayList<ElasticModul> staticModulsAshC2 = new ArrayList<>();
        staticModulsAshC2.add(new ElasticModul(20, 300));
        staticModulsAshC2.add(new ElasticModul(25, 285));
        staticModulsAshC2.add(new ElasticModul(30, 270));
        staticModulsAshC2.add(new ElasticModul(35, 245));
        staticModulsAshC2.add(new ElasticModul(40, 220));

        ArrayList<ElasticModul> staticModulsApC1 = new ArrayList<>();
        staticModulsApC1.add(new ElasticModul(20, 200));
        staticModulsApC1.add(new ElasticModul(25, 190));
        staticModulsApC1.add(new ElasticModul(30, 180));
        staticModulsApC1.add(new ElasticModul(35, 170));
        staticModulsApC1.add(new ElasticModul(40, 160));

        ArrayList<ElasticModul> staticModulsApC2 = new ArrayList<>();
        staticModulsApC2.add(new ElasticModul(20, 360));
        staticModulsApC2.add(new ElasticModul(25, 340));
        staticModulsApC2.add(new ElasticModul(30, 320));
        staticModulsApC2.add(new ElasticModul(35, 300));
        staticModulsApC2.add(new ElasticModul(40, 280));

        ArrayList<ElasticModul> staticModulsApC3 = new ArrayList<>();
        staticModulsApC3.add(new ElasticModul(20, 290));
        staticModulsApC3.add(new ElasticModul(25, 270));
        staticModulsApC3.add(new ElasticModul(30, 250));
        staticModulsApC3.add(new ElasticModul(35, 235));
        staticModulsApC3.add(new ElasticModul(40, 220));

        ArrayList<ElasticModul> staticModulsApC4 = new ArrayList<>();
        staticModulsApC4.add(new ElasticModul(20, 250));
        staticModulsApC4.add(new ElasticModul(25, 238));
        staticModulsApC4.add(new ElasticModul(30, 225));
        staticModulsApC4.add(new ElasticModul(35, 213));
        staticModulsApC4.add(new ElasticModul(40, 200));

        ArrayList<ElasticModul> staticModulsShmAc1 = new ArrayList<>();
        staticModulsShmAc1.add(new ElasticModul(20, 380));
        staticModulsShmAc1.add(new ElasticModul(25, 360));
        staticModulsShmAc1.add(new ElasticModul(30, 340));
        staticModulsShmAc1.add(new ElasticModul(35, 325));
        staticModulsShmAc1.add(new ElasticModul(40, 310));

        ArrayList<ElasticModul> staticModulsShmAc2 = new ArrayList<>();
        staticModulsShmAc2.add(new ElasticModul(20, 420));
        staticModulsShmAc2.add(new ElasticModul(25, 390));
        staticModulsShmAc2.add(new ElasticModul(30, 360));
        staticModulsShmAc2.add(new ElasticModul(35, 340));
        staticModulsShmAc2.add(new ElasticModul(40, 320));

        ArrayList<ElasticModul> staticModulsShmAc3 = new ArrayList<>();
        staticModulsShmAc3.add(new ElasticModul(20, 460));
        staticModulsShmAc3.add(new ElasticModul(25, 420));
        staticModulsShmAc3.add(new ElasticModul(30, 380));
        staticModulsShmAc3.add(new ElasticModul(35, 360));
        staticModulsShmAc3.add(new ElasticModul(40, 340));

        ArrayList<ElasticModul> staticModulsShmAc4 = new ArrayList<>();
        staticModulsShmAc4.add(new ElasticModul(20, 490));
        staticModulsShmAc4.add(new ElasticModul(25, 455));
        staticModulsShmAc4.add(new ElasticModul(30, 420));
        staticModulsShmAc4.add(new ElasticModul(35, 390));
        staticModulsShmAc4.add(new ElasticModul(40, 360));

        ArrayList<Bituminous> bituminous = new ArrayList<>();
        bituminous.add(new Bituminous("АЩМ1","Щільний асфальтобето-полімербетон","БМПА 60/90-53 на основі термопластів",7000,0.09,14.0,0.1,7.0,3.1,1.0,0.9,elasticModulsAshm1,staticModulsAshC1,4.0,6.0,2186.73));
        bituminous.add(new Bituminous("АЩМ2","Щільний асфальтобето-полімербетон","БМПА 60/90-53 на основі термоеластопластів",5500,0.09,12.0,0.1,6.5,2.9,1.0,0.9,elasticModulsAshm2,staticModulsAshC1,4.0,6.0,2186.73));
        bituminous.add(new Bituminous("АЩ1","Щільний асфальтобетобетон І-ІІ марки","БНД 40/60",6000,0.09,10.0,0.1,6.0,3.7,0.9,0.8,elasticModulsAsh1,staticModulsAshC2,5.0,10.0,1840.61));
        bituminous.add(new Bituminous("АЩ2","Щільний асфальтобетобетон І-ІІ марки","БНД 60/90",4500,0.1,9.8,0.1,5.5,4.0,0.9,0.8,elasticModulsAsh2,staticModulsAshC2,5.0,10.0,1841.61));
        bituminous.add(new Bituminous("АЩ3","Щільний асфальтобетобетон І-ІІ марки","БНД 90/130",3600,0.1,9.5,0.1,5.0,4.5,0.9,0.8,elasticModulsAsh3,staticModulsAshC2,5.0,10.0,1842.61));
        bituminous.add(new Bituminous("АЩ4","Щільний асфальтобетобетон І-ІІ марки","БНД 130/200",2600,0.11,9.3,0.12,4.5,5.1,0.9,0.8,elasticModulsAsh4,staticModulsAshC2,5.0,10.0,1843.61));
        bituminous.add(new Bituminous("АП1","Пористий асфальтобетобетон","БНД 40/60",3600,0.1,8.3,0.12,4.5,7.2,0.75,0.8,elasticModulsAp1,staticModulsApC1,8.0,12.0,1829.02));
        bituminous.add(new Bituminous("АП2","Пористий асфальтобетобетон","БНД 60/90",2800,0.11,8.0,0.12,4.3,8.2,0.75,0.8,elasticModulsAp2,staticModulsApC4,8.0,12.0,1830.02));
        bituminous.add(new Bituminous("АП3","Пористий асфальтобетобетон","БНД 90/130",2200,0.12,7.8,0.14,4.0,8.6,0.75,0.8,elasticModulsAp3,staticModulsApC3,8.0,12.0,1831.02));
        bituminous.add(new Bituminous("АП4","Пористий асфальтобетобетон","БНД 130/200",1800,0.1,7.6,0.1,3.75,9.0,0.75,0.8,elasticModulsAp4,staticModulsApC2,8.0,12.0,1832.02));
        bituminous.add(new Bituminous("АВП1","Високо-пористий асфальтобетобетон","БНД 40/60",3000,0.11,6.0,0.15,4.3,8.8,0.7,0.75,elasticModulsAvp1,staticModulsApC1,8.0,15.0,1362.59));
        bituminous.add(new Bituminous("АВП2","Високо-пористий асфальтобетобетон","БНД 60/90",2100,0.12,5.8,0.15,4.0,9.3,0.7,0.75,elasticModulsAvp2,staticModulsApC4,8.0,15.0,1363.59));
        bituminous.add(new Bituminous("АВП3","Високо-пористий асфальтобетобетон","БНД 90/130",1700,0.12,5.5,0.15,3.75,9.8,0.7,0.75,elasticModulsAvp3,staticModulsApC3,8.0,15.0,1364.59));
        bituminous.add(new Bituminous("ЩМА1","Щебеневомастиковий асвальтобетон виду ЩМА-5","БНД 40/60",5000,0.11,7.3,0.12,6.0,3.7,0.85,0.85,elasticModulsShma1,staticModulsShmAc1,3.0,5.0,2421.43));
        bituminous.add(new Bituminous("ЩМА2","Щебеневомастиковий асвальтобетон виду ЩМА-5","БНД 60/90",4500,0.11,6.6,0.11,5.5,4.0,0.85,0.85,elasticModulsShma2,staticModulsShmAc1,3.0,5.0,2422.43));
        bituminous.add(new Bituminous("ЩМА3","Щебеневомастиковий асвальтобетон виду ЩМА-10","БНД 40/60",4100,0.1,4.6,0.12,6.0,3.7,0.85,0.85,elasticModulsShma3,staticModulsShmAc2,3.0,5.0,2423.43));
        bituminous.add(new Bituminous("ЩМА4","Щебеневомастиковий асвальтобетон виду ЩМА-10","БНД 60/90",3900,0.12,4.2,0.11,5.5,4.0,0.85,0.85,elasticModulsShma4,staticModulsShmAc2,3.0,5.0,2424.43));
        bituminous.add(new Bituminous("ЩМА5","Щебеневомастиковий асвальтобетон виду ЩМА-15","БНД 40/60",3800,0.12,4.2,0.12,6.0,3.7,0.85,0.85,elasticModulsShma5,staticModulsShmAc3,4.5,6.0,2425.43));
        bituminous.add(new Bituminous("ЩМА6","Щебеневомастиковий асвальтобетон виду ЩМА-15","БНД 60/90",3600,0.1,3.9,0.13,5.5,4.0,0.85,0.85,elasticModulsShma6,staticModulsShmAc3,4.5,6.0,2426.43));
        bituminous.add(new Bituminous("ЩМА7","Щебеневомастиковий асвальтобетон виду ЩМА-20","БНД 40/60",3500,0.12,3.2,0.12,6.0,3.7,0.85,0.85,elasticModulsShma7,staticModulsShmAc4,5.0,7.0,2427.43));
        bituminous.add(new Bituminous("ЩМА8","Щебеневомастиковий асвальтобетон виду ЩМА-20","БНД 60/90",3300,0.12,2.9,0.13,5.5,4.0,0.85,0.85,elasticModulsShma8,staticModulsShmAc4,5.0,7.0,2428.43));
        bituminous.add(new Bituminous("ЩМА9","Щебеневомастиковий асвальтобетон виду ЩМА-5","БМПА 60/90-52",5200,0.08,7.5,0.1,6.5,2.9,0.85,0.85,elasticModulsShma9,staticModulsShmAc1,3.0,4.0,2429.43));
        bituminous.add(new Bituminous("ЩМА10","Щебеневомастиковий асвальтобетон виду ЩМА-10","БМПА 60/90-52",4500,0.08,5.6,0.1,6.5,2.9,0.85,0.85,elasticModulsShma10,staticModulsShmAc2,4.0,5.0,2430.43));
        bituminous.add(new Bituminous("ЩМА11","Щебеневомастиковий асвальтобетон виду ЩМА-15","БМПА 60/90-52",4100,0.09,4.3,0.11,6.5,2.9,0.85,0.85,elasticModulsShma11,staticModulsShmAc3,4.5,6.0,2431.43));
        bituminous.add(new Bituminous("ЩМА12","Щебеневомастиковий асвальтобетон виду ЩМА-20","БМПА 60/90-52",3700,0.1,3.4,0.13,6.5,2.9,0.85,0.85,elasticModulsShma12,staticModulsShmAc4,5.0,7.0,2432.43));

        File bituminouses = new File(root, "/bituminous");
        writer.write(bituminouses,bituminous);

        ArrayList<StrengthenedMaterial> strengthenedMaterials = new ArrayList<>();
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ1","ЩПС укріплені цементом", "марки М75", 1000, 0.15,0.7,14.0,25.0,750.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ2","ЩПС укріплені цементом", "марки М60", 900, 0.15,0.6,16.0,25.0,700.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ3","ЩПС укріплені цементом", "марки М40", 700, 0.16,0.5,18.0,25.0,650.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ4","ЩПС укріплені цементом", "марки М20", 400, 0.18,0.33,18.0,25.0,600.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ5","ЩПС укріплені цементом", "марки М10", 180,0.2,0.22,18.0,25.0,550.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ6","Матеріали отримані за технологією холодного ресайклінгу без додавання нових мінеральних матеріалів, укріплені цементом", "марки М60", 800,0.18,0.4,10.0,24.0,900.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ7","Матеріали отримані за технологією холодного ресайклінгу без додавання нових мінеральних матеріалів, укріплені цементом", "марки М40", 600,0.18,0.35, 10.0,24.0,850.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ8","Матеріали отримані за технологією холодного ресайклінгу без додавання нових мінеральних матеріалів, укріплені цементом", "марки М20", 350,0.19,0.2,10.0,24.0,800.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ9","Матеріали отримані за технологією холодного ресайклінгу без додавання нових мінеральних матеріалів, укріплені бітумною емельсією  або спіненим бітумом та цементом (комплексним в'яжучим)", "марки М60", 850,0.19,0.45,10.0,24.0,900.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ10","Матеріали отримані за технологією холодного ресайклінгу без додавання нових мінеральних матеріалів, укріплені бітумною емельсією  або спіненим бітумом та цементом (комплексним в'яжучим)", "марки М40", 650,0.19,0.4,10.0,24.0,850.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ11","Матеріали отримані за технологією холодного ресайклінгу без додавання нових мінеральних матеріалів, укріплені бітумною емельсією  або спіненим бітумом та цементом (комплексним в'яжучим)", "марки М20", 400,0.2,0.25,10.0,24.0,800.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ12","Матеріали отримані за технологією холодного ресайклінгу без додавання нових мінеральних матеріалів, укріплені бітумною емельсією  або спіненим бітумом", "марки М60", 300,0.2,0.1,10.0,24.0,900.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ13","Матеріали отримані за технологією холодного ресайклінгу без додавання нових мінеральних матеріалів, укріплені бітумною емельсією  або спіненим бітумом", "марки М40", 200,0.21,0.1,10.0,24.0,850.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ14","Матеріали отримані за технологією холодного ресайклінгу без додавання нових мінеральних матеріалів, укріплені бітумною емельсією  або спіненим бітумом", "марки М20", 120,0.22,0.09,10.0,24.0,800.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ15","Матеріали отримані за технологією холодного ресайклінгу з додавання нових мінеральних матеріалів, укріплені цемонтом", "марки М60", 800,0.18,0.45,10.0,24.0,900.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ16","Матеріали отримані за технологією холодного ресайклінгу з додавання нових мінеральних матеріалів, укріплені цемонтом", "марки М40", 650,0.19,0.35,10.0,24.0,850.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ17","Матеріали отримані за технологією холодного ресайклінгу з додавання нових мінеральних матеріалів, укріплені цемонтом", "марки М20", 350,0.2,0.2,10.0,24.0,800.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ18","Матеріали отримані за технологією холодного ресайклінгу з додавання нових мінеральних матеріалів, укріплені бітумною емульсією або спіненим бітумом та цементом (комплексним в'яжучим)", "марки М60", 850,0.19,0.55,10.0,24.0,900.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ19","Матеріали отримані за технологією холодного ресайклінгу з додавання нових мінеральних матеріалів, укріплені бітумною емульсією або спіненим бітумом та цементом (комплексним в'яжучим)", "марки М40", 700,0.2,0.4,10.0,24.0,850.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ20","Матеріали отримані за технологією холодного ресайклінгу з додавання нових мінеральних матеріалів, укріплені бітумною емульсією або спіненим бітумом та цементом (комплексним в'яжучим)", "марки М20", 400,0.2,0.25,10.0,24.0,800.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ21","Матеріали отримані за технологією холодного ресайклінгу з додавання нових мінеральних матеріалів, укріплені бітумною емульсією або спіненим бітумом", "марки М60", 320,0.2,0.12,10.0,24.0,900.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ22","Матеріали отримані за технологією холодного ресайклінгу з додавання нових мінеральних матеріалів, укріплені бітумною емульсією або спіненим бітумом", "марки М40", 220,0.21,0.12,10.0,24.0,850.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ23","Матеріали отримані за технологією холодного ресайклінгу з додавання нових мінеральних матеріалів, укріплені бітумною емульсією або спіненим бітумом", "марки М20", 150,0.21,0.1,10.0,24.0,800.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ24","Крупноуламкові ґрунти і ПГС оптимального чи близьких до оптимального складів, укріплені комплексним в'яжучим", "марки М45", 900,0.15,0.55,15.0,25.0,450.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ25","Крупноуламкові ґрунти і ПГС оптимального чи близьких до оптимального складів, укріплені комплексним в'яжучим", "марки М25", 650,0.17,0.42,15.0,25.0,400.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ26","Крупноуламкові ґрунти і ПГС оптимального чи близьких до оптимального складів, укріплені комплексним в'яжучим", "марки М15", 450,0.19,0.32,15.0,25.0,350.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ27","Крупноуламкові ґрунти і ПГС оптимального чи близьких до оптимального складів, укріплені цементом", "марки М40", 800,0.16,0.46,15.0,25.0,400.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ28","Крупноуламкові ґрунти і ПГС оптимального чи близьких до оптимального складів, укріплені цементом", "марки М20", 530,0.18,0.33,15.0,25.0,350.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ29","Крупноуламкові ґрунти і ПГС оптимального чи близьких до оптимального складів, укріплені цементом", "марки М10", 320,0.2,0.22,15.0,25.0,300.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ30","Крупноуламкові ґрунти і ПГС оптимального чи близьких до оптимального складів, укріплені активною золою-виносу або гранульованим шлаком, вапном, фосфатними в'яжучими та іншими композиційними в'яжучими з добавками чи без добавок ПАР", "марки М40", 700,0.17,0.4,15.0,25.0,400.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ31","Крупноуламкові ґрунти і ПГС оптимального чи близьких до оптимального складів, укріплені активною золою-виносу або гранульованим шлаком, вапном, фосфатними в'яжучими та іншими композиційними в'яжучими з добавками чи без добавок ПАР", "марки М20", 500,0.18,0.31,15.0,25.0,350.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ32","Крупноуламкові ґрунти і ПГС оптимального чи близьких до оптимального складів, укріплені активною золою-виносу або гранульованим шлаком, вапном, фосфатними в'яжучими та іншими композиційними в'яжучими з добавками чи без добавок ПАР", "марки М10", 300,0.2,0.2,15.0,25.0,300.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ33","Крупноуламкові ґрунти і ПГС оптимального чи близьких до оптимального складів, укріплені в'язким спіненим бітумом або емульсією на в'язкому бітумі", "", 350,0.2,0.35,15.0,25.0,500.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ34","Крупноуламкові ґрунти і ПГС неоптимального складу, піски (крім дрібних, пилуватих і однорозмірних), супісок легкий, крупний, відходи каменедроблення з маломіцних гірських порід, укріплені комплексними в'яжучими", "марки М45", 800,0.16,0.5,15.0,25.0,450.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ35","Крупноуламкові ґрунти і ПГС неоптимального складу, піски (крім дрібних, пилуватих і однорозмірних), супісок легкий, крупний, відходи каменедроблення з маломіцних гірських порід, укріплені комплексними в'яжучими", "марки М25", 600,0.17,0.4,15.0,25.0,400.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ36","Крупноуламкові ґрунти і ПГС неоптимального складу, піски (крім дрібних, пилуватих і однорозмірних), супісок легкий, крупний, відходи каменедроблення з маломіцних гірських порід, укріплені комплексними в'яжучими", "марки М15", 420,0.19,0.31,15.0,25.0,350.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ37","Крупноуламкові ґрунти і ПГС неоптимального складу, піски (крім дрібних, пилуватих і однорозмірних), супісок легкий, крупний, відходи каменедроблення з маломіцних гірських порід, укріплені цементом", "марки М40", 700,0.17,0.4,15.0,25.0,450.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ38","Крупноуламкові ґрунти і ПГС неоптимального складу, піски (крім дрібних, пилуватих і однорозмірних), супісок легкий, крупний, відходи каменедроблення з маломіцних гірських порід, укріплені цементом", "марки М20", 480,0.18,0.28,15.0,25.0,400.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ39","Крупноуламкові ґрунти і ПГС неоптимального складу, піски (крім дрібних, пилуватих і однорозмірних), супісок легкий, крупний, відходи каменедроблення з маломіцних гірських порід, укріплені цементом", "марки М10", 300,0.2,0.19,15.0,25.0,350.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ40","Крупноуламкові ґрунти і ПГС неоптимального складу, піски (крім дрібних, пилуватих і однорозмірних), супісок легкий, крупний, відходи каменедроблення з маломіцних гірських порід, укріплені активною золою-виносу або гранульованим шлаком, вапном, фосфатними в'яжучими та іншими композиційними в'яжучими з добавками чи без добавок ПАР", "марки М20", 450,0.19,0.25,15.0,25.0,350.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ41","Крупноуламкові ґрунти і ПГС неоптимального складу, піски (крім дрібних, пилуватих і однорозмірних), супісок легкий, крупний, відходи каменедроблення з маломіцних гірських порід, укріплені активною золою-виносу або гранульованим шлаком, вапном, фосфатними в'яжучими та іншими композиційними в'яжучими з добавками чи без добавок ПАР", "марки М10", 280,0.21,0.16,15.0,25.0,300.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ42","Крупноуламкові ґрунти і ПГС неоптимального складу, піски (крім дрібних, пилуватих і однорозмірних), супісок легкий, крупний, відходи каменедроблення з маломіцних гірських порід, укріплені в'язким спіненим бітумом або емульсією на в'язкому бітумі", "", 300,0.21,0.3,15.0,25.0,350.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ43","Піски дрібні і пилуваті, супісок легкий і пилуватий, укріплені комплексними в'яжучими", "марки М45", 750,0.16,0.47,15.0,30.0,450.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ44","Піски дрібні і пилуваті, супісок легкий і пилуватий, укріплені комплексними в'яжучими", "марки М25", 550,0.18,0.37,15.0,30.0,400.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ45","Піски дрібні і пилуваті, супісок легкий і пилуватий, укріплені комплексними в'яжучими", "марки М15", 380,0.2,0.28,15.0,30.0,350.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ46","Піски дрібні і пилуваті, супісок легкий і пилуватий, укріплені цементом", "марки М40", 650,0.17,0.35,15.0,30.0,400.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ47","Піски дрібні і пилуваті, супісок легкий і пилуватий, укріплені цементом", "марки М20", 450,0.19,0.25,15.0,30.0,350.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ48","Піски дрібні і пилуваті, супісок легкий і пилуватий, укріплені цементом", "марки М10", 260,0.21,0.16,15.0,30.0,300.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ49","Піски дрібні і пилуваті, супісок легкий і пилуватий, укріплені активною золою-виносу або гранульованим шлаком, вапном, фосфатними в'яжучими та іншими композиційними в'яжучими з добавками чи без добавок ПАР", "марки М20", 430,0.19,0.22,15.0,30.0,300.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ50","Піски дрібні і пилуваті, супісок легкий і пилуватий, укріплені активною золою-виносу або гранульованим шлаком, вапном, фосфатними в'яжучими та іншими композиційними в'яжучими з добавками чи без добавок ПАР", "марки М10", 230,0.2,0.08,15.0,30.0,250.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ51","Піски дрібні і пилуваті, супісок легкий і пилуватий, укріплені в'язким спіненим бітумом або емульсією на в'язкому бітумі", "", 300,0.21,0.25,15.0,30.0,300.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ52","Побічні продукти промисловості (кам'яні матеріали і крупноуламкові грунти, які відповідають рудним копалинам, золошлакові суміші, формувальні суміщі тощо), укріплені комплексними в'яжучими", "марки М45", 700,0.16,0.46,12.0,25.0,450.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ53","Побічні продукти промисловості (кам'яні матеріали і крупноуламкові грунти, які відповідають рудним копалинам, золошлакові суміші, формувальні суміщі тощо), укріплені комплексними в'яжучими", "марки М25", 530,0.18,0.36,12.0,25.0,400.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ54","Побічні продукти промисловості (кам'яні матеріали і крупноуламкові грунти, які відповідають рудним копалинам, золошлакові суміші, формувальні суміщі тощо), укріплені комплексними в'яжучими", "марки М15", 320,0.21,0.26,12.0,25.0,250.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ55","Побічні продукти промисловості (кам'яні матеріали і крупноуламкові грунти, які відповідають рудним копалинам, золошлакові суміші, формувальні суміщі тощо), укріплені цементом", "марки М40", 600,0.17,0.3,12.0,25.0,400.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ56","Побічні продукти промисловості (кам'яні матеріали і крупноуламкові грунти, які відповідають рудним копалинам, золошлакові суміші, формувальні суміщі тощо), укріплені цементом", "марки М20", 400,0.2,0.2,12.0,25.0,300.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ57","Побічні продукти промисловості (кам'яні матеріали і крупноуламкові грунти, які відповідають рудним копалинам, золошлакові суміші, формувальні суміщі тощо), укріплені цементом", "марки М10", 200,0.22,0.12,12.0,25.0,250.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ58","Супіски важкі і пилуваті, суглинки легкі укріплені комплексними в'яжучими", "марки М45", 600,0.17,0.4,12.0,24.0,450.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ59","Супіски важкі і пилуваті, суглинки легкі укріплені комплексними в'яжучими", "марки М25", 450,0.19,0.32,12.0,24.0,400.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ60","Супіски важкі і пилуваті, суглинки легкі укріплені комплексними в'яжучими", "марки М15", 280,0.22,0.24,12.0,24.0,350.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ61","Супіски важкі і пилуваті, суглинки легкі укріплені цементом", "марки М40", 500,0.18,0.22,12.0,24.0,400.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ62","Супіски важкі і пилуваті, суглинки легкі укріплені цементом", "марки М20", 350,0.2,0.16,12.0,24.0,350.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ63","Супіски важкі і пилуваті, суглинки легкі укріплені цементом", "марки М10", 200,0.24,0.09,12.0,24.0,300.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ64","Супіски важкі і пилуваті, суглинки легкі укріплені активною золою-виносу або гранульованим шлаком, вапном, фосфатними в'яжучими та іншими композиційними в'яжучими з добавками чи без добавок ПАР", "марки М20", 300,0.21,0.12,12.0,24.0,300.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ65","Супіски важкі і пилуваті, суглинки легкі укріплені активною золою-виносу або гранульованим шлаком, вапном, фосфатними в'яжучими та іншими композиційними в'яжучими з добавками чи без добавок ПАР", "марки М10", 180,0.24,0.06,12.0,24.0,250.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ66","Супіски важкі і пилуваті, суглинки легкі укріплені в'язким спіненим бітумом або емульсією на в'язкому бітумі", "", 250,0.22,0.17,12.0,24.0,300.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ67","Суглинки важкі і пилуваті, глини піщанисті і пилуваті, укріплені мінеральними і комплексними в'яжучими", "марки М20", 330,0.21,0.12,12.0,24.0,250.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ68","Суглинки важкі і пилуваті, глини піщанисті і пилуваті, укріплені мінеральними і комплексними в'яжучими", "марки М10", 80,0.25,0.06,12.0,24.0,200.0));
        strengthenedMaterials.add(new StrengthenedMaterial("ОУ69","Суглинки важкі і пилуваті, глини піщанисті і пилуваті, укріплені дьогтем (грунтодьоготь)", "", 100,0.25,0.05,12.0,24.0,150.0));

        File strengthenedMaterialses = new File(root, "/strengthenedMaterials");
        writer.write(strengthenedMaterialses,strengthenedMaterials);

        ArrayList<UnstrengthenedMaterial> unstrengthenedMaterialsBase = new ArrayList<>();
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН1","Чорний щебінь, влаштований за способом заклинки",600,null,null,0.15,8.0,16.0,700.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН2","Щебінь марок 1000-1400, влаштований за способом просочення в'язким бітумом",400,null,null,0.16,6.0,12.0,600.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН3","Щебінь марок 800-1400, влаштований за способом заклинки з міцних осадових та метаморфічних порід",350,null,null,0.17,12.0,25.0,200.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН4","Щебінь марок 800-1400, влаштований за способом заклинки з магматичних порід",250,null,null,0.19,12.0,25.0,230.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН5","Шлаковий щебінь",150,null,null,0.22,12.0,30.0,150.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН6","Бетонна бруківка \"Г-подібної форми хвиля\" розміром (243,5х243,5х120) мм",1200,null,null,0.12,12.0,12.0,500.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН7","Бетонна бруківка \"Г-подібної форми хвиля\" розміром (243,5х243,5х120) мм",900,null,null,0.13,10.0,10.0,500.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН8","Бетонна бруківка \"фалка\" розміром (300х150х100) мм",700,null,null,0.14,10.0,10.0,450.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН9","Бетонна бруківка \"фалка\" розміром (240х130х80) мм",550,null,null,0.15,8.0,8.0,400.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН10","Бетонна бруківка \"подвійне Т\" розміром (200х165х80) мм",700,null,null,0.14,8.0,8.0,400.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН11","Кам'яна бруківка, пакеляж",400,null,null,0.16,15.0,15.0,800.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН12","ПГС згідно ДСТУ Б В.2.7-30",180,45.0,0.03,0.21,5.0,30.0,300.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН13","Щебенево-піщана суміш для покриття С1",250,null,null,0.19,12.0,25.0,140.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН14","Щебенево-піщана суміш для покриття С2",240,null,null,0.19,10.0,25.0,190.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН15","Щебенево-піщана суміш для покриття С3",200,null,null,0.2,10.0,25.0,240.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН16","Щебенево-піщана суміш для покриття С4",280,null,null,0.18,24.0,30.0,290.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН17","Щебенево-піщана суміш для покриття С5",240,null,null,0.19,18.0,25.0,330.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН18","Щебенево-піщана суміш для покриття С6",240,null,null,0.19,18.0,25.0,380.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН19","Щебенево-піщана суміш для покриття С7",220,null,null,0.19,12.0,25.0,430.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН20","Щебенево-піщана суміш для покриття С8",200,null,null,0.2,12.0,25.0,480.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН21","Щебенево-піщана суміш для покриття С9",180,null,null,0.21,8.0,25.0,530.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН22","Щебенево-піщана суміш для покриття С10",180,null,null,0.21,8.0,25.0,605.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН23","Віброруйнування цементно-бетонного покриття",220,null,null,0.19,18.0,24.0,500.0));
        unstrengthenedMaterialsBase.add(new UnstrengthenedMaterial("ОН24","Суглинки важкі і пилуваті, глини піщанисті і пилуваті, укріплені дьогьем (грунтодьоготь)",100,null,null,0.24,12.0,18.0,150.0));

        File unstrengthenedMaterialsesBase = new File(root, "/unstrengthenedMaterialsBase");
        writer.write(unstrengthenedMaterialsesBase,unstrengthenedMaterialsBase);


        ArrayList<UnstrengthenedMaterial> unstrengthenedMaterialsCover = new ArrayList<>();
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН1","Чорний щебінь, влаштований за способом заклинки",900,null,null,0.13,8.0,16.0,700.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН2","Щебінь марок 1000-1400, влаштований за способом просочення в'язким бітумом",600,null,null,0.18,6.0,12.0,600.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН3","Щебінь марок 800-1400, влаштований за способом заклинки з міцних осадових та метаморфічних порід",450,null,null,0.19,12.0,25.0,200.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН4","Щебінь марок 800-1400, влаштований за способом заклинки з магматичних порід",350,null,null,0.2,12.0,25.0,230.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН5","Шлаковий щебінь",200,null,null,0.24,12.0,30.0,150.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН6","Бетонна бруківка \"Г-подібної форми хвиля\" розміром (243,5х243,5х120) мм",1600,null,null,0.13,12.0,12.0,500.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН7","Бетонна бруківка \"Г-подібної форми хвиля\" розміром (243,5х243,5х120) мм",1200,null,null,0.14,10.0,10.0,500.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН8","Бетонна бруківка \"фалка\" розміром (300х150х100) мм",900,null,null,0.16,10.0,10.0,450.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН9","Бетонна бруківка \"фалка\" розміром (240х130х80) мм",650,null,null,0.17,8.0,8.0,400.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН10","Бетонна бруківка \"подвійне Т\" розміром (200х165х80) мм",900,null,null,0.16,8.0,8.0,400.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН11","Кам'яна бруківка, пакеляж",500,null,null,0.18,15.0,15.0,800.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН12","ПГС згідно ДСТУ Б В.2.7-30",180,45.0,0.03,0.25,5.0,30.0,300.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН13","Щебенево-піщана суміш для покриття С1",300,null,null,0.21,12.0,25.0,140.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН14","Щебенево-піщана суміш для покриття С2",290,null,null,0.22,10.0,25.0,190.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН15","Щебенево-піщана суміш для покриття С3",250,null,null,0.23,10.0,25.0,240.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН16","Щебенево-піщана суміш для покриття С4",350,null,null,0.2,24.0,30.0,290.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН17","Щебенево-піщана суміш для покриття С5",280,null,null,0.22,18.0,25.0,330.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН18","Щебенево-піщана суміш для покриття С6",280,null,null,0.22,18.0,25.0,380.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН19","Щебенево-піщана суміш для покриття С7",260,null,null,0.22,12.0,25.0,430.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН20","Щебенево-піщана суміш для покриття С8",240,null,null,0.23,12.0,25.0,480.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН21","Щебенево-піщана суміш для покриття С9",220,null,null,0.23,8.0,25.0,530.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН22","Щебенево-піщана суміш для покриття С10",220,null,null,0.23,8.0,25.0,605.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН23","Віброруйнування цементно-бетонного покриття",250,null,null,0.23,18.0,24.0,500.0));
        unstrengthenedMaterialsCover.add(new UnstrengthenedMaterial("ОН24","Суглинки важкі і пилуваті, глини піщанисті і пилуваті, укріплені дьогьем (грунтодьоготь)",100,null,null,0.24,12.0,18.0,150.0));

        File unstrengthenedMaterialsesCover = new File(root, "/unstrengthenedMaterialsCover");
        writer.write(unstrengthenedMaterialsesCover,unstrengthenedMaterialsCover);



        ArrayList<Sand> sand = new ArrayList<>();
        sand.add(new Sand("G1", "Пісок крупний","-","-",7.0, 0.05, 0.37, g1,15.0,30.0,408.0));
        sand.add(new Sand("G2", "Пісок середньої крупності","-","-",6.0, 0.07, 0.37, g2,15.0,30.0,240.0));
        sand.add(new Sand("G3", "Пісок дрібний","-","-",5.0, 0.1, 0.36, g3,15.0,30.0,160.0));
        sand.add(new Sand("G4", "Пісок однорідний","-","-",5.0, 0.12, 0.34, g4,15.0,30.0,100.0));
        sand.add(new Sand("G5", "Пісок пилуватий","-","-",3.0, 0.14, 0.31, g5,15.0,30.0,25.0));
        sand.add(new Sand("G6", "Супісок піщанистий","від 1 до 7","більше 50",3.0, 0.18, 0.27, g6,15.0,30.0,30.0));
        sand.add(new Sand("G7", "Супісок пилуватий","від 1 до 7","більше 50",1.5, 0.2, 0.33, g7,15.0,30.0,30.0));
        sand.add(new Sand("G8", "Суглинок легкий піщанистий","від 7 до 12","більше 40",1.5, 0.2, 0.27, g8,15.0,30.0,30.0));
        sand.add(new Sand("G9", "Суглинок легкий пилуватий","від 7 до 12","менше 40",1.5, 0.2, 0.27, g9,15.0,30.0,30.0));
        sand.add(new Sand("G10", "Суглинок важкий піщанистий","від 12 до 17","більше 40",1.5, 0.2, 0.27, g10,15.0,30.0,30.0));
        sand.add(new Sand("G11", "Суглинок важкий пилуватий","від 12 до 17","менше 40",1.5, 0.2, 0.27, g11,15.0,30.0,30.0));
        sand.add(new Sand("G12", "Глина легка піщаниста","від 17 до 27","більше 40",1.5, 0.22, 0.27, g12,15.0,30.0,30.0));
        sand.add(new Sand("G13", "Глина легка пилувата","від 17 до 27","менше 40",1.5, 0.22, 0.27, g13,15.0,30.0,30.0));
        sand.add(new Sand("G14", "Глина важка","більше 27","не нормується",1.5, 0.22, 0.27, g14,15.0,30.0,30.0));

        File sands = new File(root,"/sands");
        writer.write(sands, sand);

        ArrayList<RoadLayers> roadLayers = new ArrayList<>();
        roadLayers.add(new RoadLayers("Асфальтобетон",bituminous));
        roadLayers.add(new RoadLayers("Матеріали і грунти укріплені в'яжучими речовинами",strengthenedMaterials));
        roadLayers.add(new RoadLayers("Неукріплені матеріали покриття",unstrengthenedMaterialsCover));
        roadLayers.add(new RoadLayers("Неукріплені матеріали основ",unstrengthenedMaterialsBase));
        roadLayers.add(new RoadLayers("Шар нев'язкого середовища",sand));

        File layers = new File(root, "/roadLayers");
        writer.write(layers, roadLayers);

        Lists.listReader();

        ArrayList<ArrayList<String>> layersNames = new ArrayList<>();
        layersNames.add(Lists.getBituminousName());
        layersNames.add(Lists.getStrengthenedMaterialsName());
        layersNames.add(Lists.getUnstrengthenedMaterialsCoverName());
        layersNames.add(Lists.getUnstrengthenedMaterialsBaseName());
        layersNames.add(Lists.getSandsName());

        File layersName = new File(root,"/layersName");
        writer.write(layersName,layersNames);


//        System.out.println(Lists.getRbczList());
//        System.out.println(Lists.getRbczName());
//        System.out.println(Lists.getRoadList());
//        System.out.println(Lists.getRoadName());
//        System.out.println(Lists.getGroundType());
//        System.out.println(Lists.getSoilName());
//        System.out.println(Lists.getSoilList());
//        System.out.println(Lists.getGrounds());
//        System.out.println(Lists.getGroundsName());
//        System.out.println(Lists.getRoadTypeList());
//        System.out.println(Lists.getRoadGroundLoad());
//        System.out.println(Lists.getGroundCorrection());
//        System.out.println(Lists.getGroundCorrectionName());
//        System.out.println(Lists.getBituminousList());
//        System.out.println(Lists.getBituminousName());
//        System.out.println(Lists.getStrengthenedMaterialsList());
//        System.out.println(Lists.getStrengthenedMaterialsName());
//        System.out.println(Lists.getUnstrengthenedMaterialsCoverList());
//        System.out.println(Lists.getUnstrengthenedMaterialsCoverName());
//        System.out.println(Lists.getUnstrengthenedMaterialsBaseList());
//        System.out.println(Lists.getUnstrengthenedMaterialsBaseName());
//        System.out.println(Lists.getSands());
//        System.out.println(Lists.getSandsName());
//        System.out.println(Lists.getRoadLayers());
//        System.out.println(Lists.getRoadLayersName());
//        System.out.println(Lists.getLayersList());


    }
}
