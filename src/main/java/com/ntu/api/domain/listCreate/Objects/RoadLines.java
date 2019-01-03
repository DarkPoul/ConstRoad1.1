package com.ntu.api.domain.listCreate.Objects;

import java.io.Serializable;

public class RoadLines extends Element implements Serializable {

    /*RoadLines - смуги руху
    /*RoadLines описує коефіцієнти суг руху
    name - назва кількості смуг руху
    numberLines - кількість смуг руху
    k1 - значення коефіцієнта fсмуги для смуги за номером 1
    k2 - значення коефіцієнта fсмуги для смуги за номером 2
    k3 - значення коефіцієнта fсмуги для смуги за номером 3
    k4 - значення коефіцієнта fсмуги для смуги за номером 4
    * */
    private String name;
    private Integer numberLines;
    private Double k1;
    private Double k2;
    private Double k3;
    private Double k4;

    @Override
    public String getName() {
        return name;
    }
    public Integer getNumberLines() {
        return numberLines;
    }
    public Double getK1() {
        return k1;
    }
    public Double getK2() {
        return k2;
    }
    public Double getK3() {
        return k3;
    }
    public Double getK4() {
        return k4;
    }

    public RoadLines(String name, Integer numberLines, Double k1, Double k2, Double k3, Double k4) {
        this.name = name;
        this.numberLines = numberLines;
        this.k1 = k1;
        this.k2 = k2;
        this.k3 = k3;
        this.k4 = k4;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RoadLines{");
        sb.append("name='").append(name).append('\'');
        sb.append(", numberLines=").append(numberLines);
        sb.append(", k1=").append(k1);
        sb.append(", k2=").append(k2);
        sb.append(", k3=").append(k3);
        sb.append(", k4=").append(k4);
        sb.append('}');
        return sb.toString();
    }
}
