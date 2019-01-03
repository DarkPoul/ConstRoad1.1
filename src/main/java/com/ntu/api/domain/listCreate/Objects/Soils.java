package com.ntu.api.domain.listCreate.Objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Soils extends Element implements Serializable {

/*Soils - описує вид грунтів (табл 4.1-4.5)
 name - назва (
T1 - глибоке залягання ґрунтових вод,
    забезпечений поверхневий водовідвід та
    наявність нижнього шару основи з дискретних матеріалів
    у дорожньому одязі на межі поділу із земляним полотном
T2 - глибоке залягання ґрунтових вод,
    тривалий застій води в бічних канавах
    наявність нижнього шару основи з дискретних матеріалів
    у дорожньому одязі на межі поділу із земляним полотном
T3 - близьке залягання ґрунтових вод,
    наявність нижнього шару основи з дискретних матеріалів
    у дорожньому одязі на межі поділу із земляним полотном
T4 - глибоке залягання ґрунтових вод,
    забезпечений поверхневий водовідвід та
    наявності  щільного монолітного нижнього шару основи
    у дорожньому одязі на межі поділу із земляним полотном
T5 - глибоке залягання ґрунтових вод,
    застій води в бічних канавах
     наявності  щільного монолітного нижнього шару основи
    у дорожньому одязі на межі поділу із земляним полотном        )

 soilTypes - список категорій грунтів
* */

    private String name;
    private ArrayList<GroundType> soilTypes;

    @Override
    public String getName() {
        return name;
    }
    public ArrayList<GroundType> getSoilTypes() {
        return soilTypes;
    }

    public Soils(String name, ArrayList<GroundType> soilTypes) {
        this.name = name;
        this.soilTypes = soilTypes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Soils{");
        sb.append("name='").append(name).append('\'');
        sb.append(", soilTypes=").append(soilTypes);
        sb.append('}');
        return sb.toString();
    }
}
