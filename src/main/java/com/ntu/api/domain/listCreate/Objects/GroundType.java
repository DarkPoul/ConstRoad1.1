package com.ntu.api.domain.listCreate.Objects;

import java.io.Serializable;

public class GroundType extends Element implements Serializable {

    /* SoilType - категорія грунта
    SoilType описує вид грунту:
    name - його шифр,
    typicalSoil - типовий грунт,
    humidity_1_2 - вологість для 1-2 категорі] доріг
    humidity_3_4 - вологість для 3-4 категорій доріг,
    humidity_5 - вологість для 5 категорії дороги (не передбачено таблицею 4.1 - 4.5)
    * */

    private String name;
    private String typicalSoil;
    private Double humidity_1_2;
    private Double humidity_3_4;
    private Double humidity_5;

    @Override
    public String getName() {
        return name;
    }
    public String getTypicalSoil() {
        return typicalSoil;
    }
    public Double getHumidity_1_2() {
        return humidity_1_2;
    }
    public Double getHumidity_3_4() {
        return humidity_3_4;
    }
    public Double getHumidity_5() {
        return humidity_5;
    }

    public GroundType(String name, String typicalSoil, Double humidity_1_2, Double humidity_3_4, Double humidity_5) {
        this.name = name;
        this.typicalSoil = typicalSoil;
        this.humidity_1_2 = humidity_1_2;
        this.humidity_3_4 = humidity_3_4;
        this.humidity_5 = humidity_5;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GroundType:");
        sb.append("name='").append(name).append('\'');
        sb.append(", typicalSoil='").append(typicalSoil).append('\'');
        sb.append(", humidity_1_2=").append(humidity_1_2);
        sb.append(", humidity_3_4=").append(humidity_3_4);
        sb.append(", humidity_5=").append(humidity_5);
        sb.append(";\n");
        return sb.toString();
    }
}
