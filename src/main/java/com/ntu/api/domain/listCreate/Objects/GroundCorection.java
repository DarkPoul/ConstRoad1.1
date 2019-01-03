package com.ntu.api.domain.listCreate.Objects;

import java.io.Serializable;

public class GroundCorection extends Element implements Serializable {
    /* GroundCorection - поправка на конструктивні особливості використовуваних
    дренажних конструкцій у дорожньо-кліматичних зонах І-IV

    name назва конструктивної особливості;
    correction1 - поправка для 1 категорії дорог
    correction2 - поправка для 2 категорії дорог
    correction3 - поправка для 3 категорії дорог
    correction4 - поправка для 4 категорії дорог

для V конструкццї необхідно передбачити логіку вибору!!!!!!!!!!!!!!!!!!!!
    * */

    private String name;
    private Double correction1;
    private Double correction2;
    private Double correction3;
    private Double correction4;

    public GroundCorection(String name, Double correction1, Double correction2, Double correction3, Double correction4) {
        this.name = name;
        this.correction1 = correction1;
        this.correction2 = correction2;
        this.correction3 = correction3;
        this.correction4 = correction4;
    }

    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getCorrection1() {
        return correction1;
    }
    public void setCorrection1(Double correction1) {
        this.correction1 = correction1;
    }
    public Double getCorrection2() {
        return correction2;
    }
    public void setCorrection2(Double correction2) {
        this.correction2 = correction2;
    }
    public Double getCorrection3() {
        return correction3;
    }
    public void setCorrection3(Double correction3) {
        this.correction3 = correction3;
    }
    public Double getCorrection4() {
        return correction4;
    }
    public void setCorrection4(Double correction4) {
        this.correction4 = correction4;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GroundCorection{");
        sb.append("name='").append(name).append('\'');
        sb.append(", correction1=").append(correction1);
        sb.append(", correction2=").append(correction2);
        sb.append(", correction3=").append(correction3);
        sb.append(", correction4=").append(correction4);
        sb.append("}\n");
        return sb.toString();
    }
}
