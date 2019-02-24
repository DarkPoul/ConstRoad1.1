package com.ntu.api.domain.listCreate.Objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Road extends Element implements Serializable {

    /*
    * Road Дорога
    * Road описує категорії дороги:
    * name ім'я категорії,
    * kN коефіцієнт надійності,
    * b характеристика надійності,
    * rBend опір щарів з монолітних матеріалів розтягу при згину,
    * rDefl опір пружному прогину всієї конструкції,
    * rOffset опір зсуву в грунті в шарах з невязких або маловязких матеріалів,
    * crBend коефіцієнт варіації на розтяг при згині,
    * crDefl коефіцієнт варіації на загальний модуль пружності,
    * crOffset коефіцієнт варіації зсуваючого напруження,
    * cS коефіцієнт варіації напруження (потрібного модуля пружності) для критерію згину монолітних шарів,
    * cR коефіцієнт варіації напруження (потрібного модуля пружності) для критерію пружного прогину,
    * cT коефіцієнт варіації напруження (потрібного модуля пружності) для критерію зсуву у невязких шарах,
    * kStudent коефіцієнт стюдента, який відповідає коефіцієнту надійності
    * roadType - список типів дорожнього покриття
    * minElasticModulCapital - мінімальний потрібний модуль пружності МПа для капітального типу дорожнього одягу
    * minElasticModulLite - мінімальний потрібний модуль пружності МПа для вдосконаленого полекшеного типу дорожнього одягу
    * minElasticModulTransfer - мінімальний потрібний модуль пружності МПа для перехідного типу дорожнього одягу
    * neededElasticBaseModul - потрібний модуль пружності основи
    * k4Koeficient - коефіцієнт к4
    * lanesNumber - кількість смуг руху
    * laneWidth - ширина смуги руху
    * roadsideWidth - ширина узбіччя
    * stopLaneWidth - ширина зупиночної смуги разом з укріпленою смугою
    * fortifiedLaneWidth - ширина укріпленої смуги
    * dividingLaneWidth - ширина розділювальної смуги
    * dividingFortifiedLaneWidth - ширина укріпленої смуги на розділювальній смузі
    * estimatedProspectiveTrafficIntensityInTransportUnits - розрахункова перспективна інтенсивність руху у транспотних одиницях, авт/добу
    * estimatedProspectiveTrafficIntensityInReducedUnits - розрахункова перспективна інтенсивність руху у приведених одиницях до легкового автомобіля, авт/добу
    * */

    private String name;
    private Double kN;
    private Double b;
    private Double rBend;
    private Double rDefl;
    private Double rOffset;
    private Double crBend;
    private Double crDefl;
    private Double crOffset;
    private Double cS;
    private Double cR;
    private Double cT;
    private Double kStudent;
    private ArrayList<RoadType> roadType;
    private Integer minElasticModulCapital;
    private Integer minElasticModulLite;
    private Integer minElasticModulTransfer;
    private Integer neededElasticBaseModul;
    private Double k4Koeficient;
    private ArrayList<Integer> lanesNumber;
    private Double laneWidth;
    private Double roadsideWidth;
    private Double stopLaneWidth;
    private Double fortifiedLaneWidth;
    private Double dividingLaneWidth;
    private Double dividingFortifiedLaneWidth;
    private String estimatedProspectiveTrafficIntensityInTransportUnits;
    private String estimatedProspectiveTrafficIntensityInReducedUnits;

    @Override
    public String getName() {
        return name;
    }
    public Double getkN() {
        return kN;
    }
    public Double getB() {
        return b;
    }
    public Double getrBend() {
        return rBend;
    }
    public Double getrDefl() {
        return rDefl;
    }
    public Double getrOffset() {
        return rOffset;
    }
    public Double getCrBend() {
        return crBend;
    }
    public Double getCrDefl() {
        return crDefl;
    }
    public Double getCrOffset() {
        return crOffset;
    }
    public Double getcS() {
        return cS;
    }
    public Double getcR() {
        return cR;
    }
    public Double getcT() {
        return cT;
    }
    public Double getkStudent() {
        return kStudent;
    }
    public ArrayList<RoadType> getRoadType() {
        return roadType;
    }
    public Integer getMinElasticModulCapital() {
        return minElasticModulCapital;
    }
    public Integer getMinElasticModulLite() {
        return minElasticModulLite;
    }
    public Integer getMinElasticModulTransfer() {
        return minElasticModulTransfer;
    }
    public Integer getNeededElasticBaseModul() {
        return neededElasticBaseModul;
    }
    public Double getK4Koeficient() {
        return k4Koeficient;
    }
    public ArrayList<Integer> getLanesNumber() {
        return lanesNumber;
    }
    public Double getLaneWidth() {
        return laneWidth;
    }
    public Double getRoadsideWidth() {
        return roadsideWidth;
    }
    public Double getStopLaneWidth() {
        return stopLaneWidth;
    }
    public Double getFortifiedLaneWidth() {
        return fortifiedLaneWidth;
    }
    public Double getDividingLaneWidth() {
        return dividingLaneWidth;
    }
    public Double getDividingFortifiedLaneWidth() {
        return dividingFortifiedLaneWidth;
    }
    public String getEstimatedProspectiveTrafficIntensityInTransportUnits() {
        return estimatedProspectiveTrafficIntensityInTransportUnits;
    }
    public String getEstimatedProspectiveTrafficIntensityInReducedUnits() {
        return estimatedProspectiveTrafficIntensityInReducedUnits;
    }

    public Road(String name, Double kN, Double b, Double rBend, Double rDefl, Double rOffset, Double crBend,
                Double crDefl, Double crOffset, Double cS, Double cR, Double cT, Double kStudent,
                ArrayList<RoadType> roadType, Integer minElasticModulCapital, Integer minElasticModulLite,
                Integer minElasticModulTransfer, Integer neededElasticBaseModul, Double k4Koeficient,
                ArrayList<Integer> lanesNumber, Double laneWidth, Double roadsideWidth, Double stopLaneWidth,
                Double fortifiedLaneWidth, Double dividingLaneWidth, Double dividingFortifiedLaneWidth,
                String estimatedProspectiveTrafficIntensityInTransportUnits,
                String estimatedProspectiveTrafficIntensityInReducedUnits) {
        this.name = name;
        this.kN = kN;
        this.b = b;
        this.rBend = rBend;
        this.rDefl = rDefl;
        this.rOffset = rOffset;
        this.crBend = crBend;
        this.crDefl = crDefl;
        this.crOffset = crOffset;
        this.cS = cS;
        this.cR = cR;
        this.cT = cT;
        this.kStudent = kStudent;
        this.roadType = roadType;
        this.minElasticModulCapital = minElasticModulCapital;
        this.minElasticModulLite = minElasticModulLite;
        this.minElasticModulTransfer = minElasticModulTransfer;
        this.neededElasticBaseModul = neededElasticBaseModul;
        this.k4Koeficient = k4Koeficient;
        this.lanesNumber = lanesNumber;
        this.laneWidth = laneWidth;
        this.roadsideWidth = roadsideWidth;
        this.stopLaneWidth = stopLaneWidth;
        this.fortifiedLaneWidth = fortifiedLaneWidth;
        this.dividingLaneWidth = dividingLaneWidth;
        this.dividingFortifiedLaneWidth = dividingFortifiedLaneWidth;
        this.estimatedProspectiveTrafficIntensityInTransportUnits = estimatedProspectiveTrafficIntensityInTransportUnits;
        this.estimatedProspectiveTrafficIntensityInReducedUnits = estimatedProspectiveTrafficIntensityInReducedUnits;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Road{");
        sb.append("name='").append(name).append('\'');
        sb.append(", kN=").append(kN);
        sb.append(", b=").append(b);
        sb.append(", rBend=").append(rBend);
        sb.append(", rDefl=").append(rDefl);
        sb.append(", rOffset=").append(rOffset);
        sb.append(", crBend=").append(crBend);
        sb.append(", crDefl=").append(crDefl);
        sb.append(", crOffset=").append(crOffset);
        sb.append(", cS=").append(cS);
        sb.append(", cR=").append(cR);
        sb.append(", cT=").append(cT);
        sb.append(", kStudent=").append(kStudent);
        sb.append(", roadType=").append(roadType);
        sb.append(", minElasticModulCapital=").append(minElasticModulCapital);
        sb.append(", minElasticModulLite=").append(minElasticModulLite);
        sb.append(", minElasticModulTransfer=").append(minElasticModulTransfer);
        sb.append(", neededElasticBaseModul=").append(neededElasticBaseModul);
        sb.append(", k4Koeficient=").append(k4Koeficient);
        sb.append(", lanesNumber=").append(lanesNumber);
        sb.append(", laneWidth=").append(laneWidth);
        sb.append(", roadsideWidth=").append(roadsideWidth);
        sb.append(", stopLaneWidth=").append(stopLaneWidth);
        sb.append(", fortifiedLaneWidth=").append(fortifiedLaneWidth);
        sb.append(", dividingLaneWidth=").append(dividingLaneWidth);
        sb.append(", dividingFortifiedLaneWidth=").append(dividingFortifiedLaneWidth);
        sb.append(", estimatedProspectiveTrafficIntensityInTransportUnits='").append(estimatedProspectiveTrafficIntensityInTransportUnits).append('\'');
        sb.append(", estimatedProspectiveTrafficIntensityInReducedUnits='").append(estimatedProspectiveTrafficIntensityInReducedUnits).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
