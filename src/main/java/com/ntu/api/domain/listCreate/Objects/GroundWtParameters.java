package com.ntu.api.domain.listCreate.Objects;

import java.io.Serializable;

public class GroundWtParameters extends Element implements Serializable {
/*
* GroundWtParameters -  розрахунгкові значення характеристик за вологістю грунту
*
*      Wt - розрахункове значення вологості грунту
 *     Егр - модуль пружності земляного полотна, МПа;
 *     fi - кут внутрішнього тертя, град;
 *     Сгр - коефіцієнт внутрішнього тертя грунту, МПа
* */
    private String name;
    private Double wt;
    private Double eGr;
    private Double fi;
    private Double cGr;

    @Override
    public String getName() {
        return name;
    }
    public Double getWt() {
        return wt;
    }
    public Double geteGr() {
        return eGr;
    }
    public Double getFi() {
        return fi;
    }
    public Double getcGr() {
        return cGr;
    }

    public GroundWtParameters(){}

    public GroundWtParameters(String name, Double wt, Double eGr, Double fi, Double cGr) {
        this.name = name;
        this.wt = wt;
        this.eGr = eGr;
        this.fi = fi;
        this.cGr = cGr;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GroundWtParameters{");
        sb.append("name='").append(name).append('\'');
        sb.append(", eGr=").append(eGr);
        sb.append(", fi=").append(fi);
        sb.append(", cGr=").append(cGr);
        sb.append("}\n");
        return sb.toString();
    }
}
