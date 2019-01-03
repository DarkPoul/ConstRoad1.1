package com.ntu.api.domain.listCreate.Objects;

import java.io.Serializable;

public class RBCZ extends Element implements Serializable {
    /*
    * Road building climate zone (RBCZ) Дорожньо-кліматична зона України.
    * Таблю 6.4- 6.8
    * RBCZ описує дорожньо кліматичні зони Укрїни:
    * name ім'я,
    * checkoutDay розрахункова кількість діб,
    * calculatedTemperature розрахункова температура
    * */
    private String name;
    private Integer checkoutDay;
    private Integer calculatedTemperature;

    public String getName() {
        return name;
    }
    public Integer getCheckoutDay() {
        return checkoutDay;
    }
    public Integer getCalculatedTemperature() {
        return calculatedTemperature;
    }

    public RBCZ(String name, Integer checkoutDay, Integer calculatedTemperature){
        this.name = name;
        this.checkoutDay = checkoutDay;
        this.calculatedTemperature = calculatedTemperature;
    }

    @Override
    public String toString() {
        return name + " " + checkoutDay + " " + calculatedTemperature + ";";
    }
}
