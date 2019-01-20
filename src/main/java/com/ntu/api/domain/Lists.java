package com.ntu.api.domain;

import com.ntu.api.domain.listCreate.*;
import com.ntu.api.domain.listCreate.Objects.*;
import com.ntu.api.domain.listCreate.Objects.Layers.*;

import java.io.File;
import java.util.ArrayList;

public class Lists {
    private static int temp =0;
    private static ArrayList<RBCZ> rbczList;
    private static ArrayList<String> rbczName;
    private static ArrayList<Road> roadList;
    private static ArrayList<String> roadName;
    private static ArrayList<RoadType> roadTypeList;
    private static ArrayList<String> roadTypeName;
    private static ArrayList<String> roadGroundLoad;
    private static ArrayList<Soils> soilList;
    private static ArrayList<String> soilName;
    private static ArrayList<String> groundType;
    private static ArrayList<Ground> grounds;
    private static ArrayList<String> groundsName;
    private static ArrayList<GroundCorection> groundCorrection;
    private static ArrayList<String> groundCorrectionName;
    private static ArrayList<DesigionLoad> design;
    private static ArrayList<RoadLines> roadLines;
    private static ArrayList<String> roadLinesName;
    private static ArrayList<Bituminous> bituminousList;
    private static ArrayList<String> bituminousName;
    private static ArrayList<StrengthenedMaterial> strengthenedMaterialsList;
    private static ArrayList<String> strengthenedMaterialsName;
    private static ArrayList<UnstrengthenedMaterial> unstrengthenedMaterialsBaseList;
    private static ArrayList<String> unstrengthenedMaterialsBaseName;
    private static ArrayList<UnstrengthenedMaterial> unstrengthenedMaterialsCoverList;
    private static ArrayList<String> unstrengthenedMaterialsCoverName;
    private static ArrayList<Sand> sands;
    private static ArrayList<String> sandsName;
    private static ArrayList<RoadLayers> roadLayers;
    private static ArrayList<String> roadLayersName;
    private static ArrayList<ArrayList<String>> layersList;



    private static String root = "/home/arsen/Java/ConstRoad/base";


    public static ArrayList<RBCZ> getRbczList() {
        return rbczList;
    }
    public static ArrayList<String> getRbczName() {
        return rbczName;
    }
    public static ArrayList<Road> getRoadList() {
        return roadList;
    }
    public static ArrayList<String> getRoadName() {
        return roadName;
    }
    public static ArrayList<RoadType> getRoadTypeList() {
        return roadTypeList;
    }
    public static ArrayList<String> getRoadTypeName() {
        return roadTypeName;
    }
    public static ArrayList<Soils> getSoilList() {
        return soilList;
    }
    public static ArrayList<String> getSoilName() {
        return soilName;
    }
    public static ArrayList<String> getGroundType() {
        return groundType;
    }
    public static ArrayList<Ground> getGrounds() {
        return grounds;
    }
    public static ArrayList<String> getGroundsName() {
        return groundsName;
    }
    public static ArrayList<String> getRoadGroundLoad() {
        return roadGroundLoad;
    }
    public static ArrayList<GroundCorection> getGroundCorrection() {
        return groundCorrection;
    }
    public static ArrayList<String> getGroundCorrectionName() {
        return groundCorrectionName;
    }
    public static ArrayList<DesigionLoad> getDesign() {
        return design;
    }
    public static ArrayList<RoadLines> getRoadLines() {
        return roadLines;
    }
    public static ArrayList<String> getRoadLinesName() {
        return roadLinesName;
    }
    public static ArrayList<Bituminous> getBituminousList() {
        return bituminousList;
    }
    public static ArrayList<StrengthenedMaterial> getStrengthenedMaterialsList() {
        return strengthenedMaterialsList;
    }
    public static ArrayList<UnstrengthenedMaterial> getUnstrengthenedMaterialsBaseList() {
        return unstrengthenedMaterialsBaseList;
    }
    public static ArrayList<UnstrengthenedMaterial> getUnstrengthenedMaterialsCoverList() {
        return unstrengthenedMaterialsCoverList;
    }
    public static ArrayList<String> getBituminousName() {
        return bituminousName;
    }
    public static ArrayList<String> getStrengthenedMaterialsName() {
        return strengthenedMaterialsName;
    }
    public static ArrayList<String> getUnstrengthenedMaterialsBaseName() {
        return unstrengthenedMaterialsBaseName;
    }
    public static ArrayList<String> getUnstrengthenedMaterialsCoverName() {
        return unstrengthenedMaterialsCoverName;
    }
    public static ArrayList<Sand> getSands() {
        return sands;
    }
    public static ArrayList<String> getSandsName() {
        return sandsName;
    }
    public static ArrayList<RoadLayers> getRoadLayers() {
        return roadLayers;
    }
    public static ArrayList<String> getRoadLayersName() {
        return roadLayersName;
    }
    public static ArrayList<ArrayList<String>> getLayersList() {
        return layersList;
    }

    public static void listReader() {
        rbczList = create(new File(root + "/climateZoneList"));
        rbczName = nameList(rbczList);
        roadList = create(new File(root + "/roadList"));
        roadName = nameList(roadList);
        roadTypeList = create(new File(root +"/roadTypeList"));
        roadTypeName = nameList(roadTypeList);
        design = create(new File(root+"/designLoad"));
        roadGroundLoad = nameList(design);
        soilList = create(new File(root + "/soils"));
        soilName = nameList(soilList);
        groundType = nameList(soilList.get(temp).getSoilTypes());
        grounds = create(new File(root + "/ground"));
        groundsName = nameList(grounds);
        groundCorrection = create(new File(root + "/groundCorection"));
        groundCorrectionName = nameList(groundCorrection);
        roadLines = create(new File(root+"/roadLines"));
        roadLinesName = nameList(roadLines);
        bituminousList = create(new File(root +"/bituminous"));
        bituminousName = nameLayerList(bituminousList);
        strengthenedMaterialsList = create(new File(root + "/strengthenedMaterials"));
        strengthenedMaterialsName = nameLayerList(strengthenedMaterialsList);
        unstrengthenedMaterialsBaseList = create(new File(root + "/unstrengthenedMaterialsBase"));
        unstrengthenedMaterialsBaseName = nameLayerList(unstrengthenedMaterialsBaseList);
        unstrengthenedMaterialsCoverList = create(new File(root + "/unstrengthenedMaterialsCover"));
        unstrengthenedMaterialsCoverName = nameLayerList(unstrengthenedMaterialsCoverList);
        sands = create(new File(root+ "/sands"));
        sandsName = nameLayerList(sands);
        roadLayers = create(new File(root + "/roadLayers"));
        roadLayersName = nameList(roadLayers);
        layersList = create(new File(root + "/layersName"));
    }

    private static ArrayList create (File file){
        Reader reader = new Reader();
        return reader.read(file);
    }

    private static <T extends Element> ArrayList<String> nameList(ArrayList<T> list){
        ArrayList<String> strList = new ArrayList<>();
        for(T el:list){
            strList.add(el.getName());
        }
        return strList;
    }

    private static <T extends Layer> ArrayList<String> nameLayerList(ArrayList<T> list){
        ArrayList<String> strList = new ArrayList<>();
        for(T el: list){
            strList.add(el.getName() + " " + el.getMaterial());
        }
        return strList;
    }

}
