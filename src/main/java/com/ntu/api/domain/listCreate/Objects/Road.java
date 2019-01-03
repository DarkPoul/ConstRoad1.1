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

    public Road(String name, Double kN, Double b, Double rBend, Double rDefl, Double rOffset,
                Double crBend, Double crDefl, Double crOffset, Double cS, Double cR, Double cT,
                Double kStudent, ArrayList<RoadType> roadType) {
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
        sb.append("}\n");
        return sb.toString();
    }
}
