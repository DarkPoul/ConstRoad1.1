package com.ntu.api.domain.listCreate.Objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Ground extends Element implements Serializable {

    /*Ground - описує різновид глинистих грунтів
    * name - назва різновиду глинистих грунтів
    * plasticNumber - число пластичності jP
    * SanPartNumber - вміст піщаних часток (2,0 - 0,5) мм, % за масою
    * k3 - коефіцієнт, який враховує особливості роботи грунтц в констукції,
    *      повязані зі збільшенням фактичного зчеплення грунтів за рахунок защемлення та іншого
    * kCfi - коефіцієнт варіації кута внутрішнього тертя Сfi
    * kCeg - коефіцієнт варіації модуля пружності грунтового півпростору СЕгр
    * wT - колекція обєктів, які характеризують розрахунгкові значення характеристик за вологістю грунту
    *      обєкт в якості імені містить розрахунковк значення вологості грунту та параметри
    *     Егр - модуль пружності земляного полотна, МПа;
    *     fi - кут внутрішнього тертя, град;
    *     Сгр - коефіцієнт внутрішнього тертя грунту, МПа
    * */

    private String name;
    private String plasticNumber;
    private String SanPartNumber;
    private Double k3;
    private Double kCfi;
    private Double kCeg;
    private ArrayList<GroundWtParameters> wT;

    @Override
    public String getName() {
        return name;
    }
    public String getPlasticNumber() {
        return plasticNumber;
    }
    public String getSanPartNumber() {
        return SanPartNumber;
    }
    public Double getK3() {
        return k3;
    }
    public Double getkCfi() {
        return kCfi;
    }
    public Double getkCeg() {
        return kCeg;
    }
    public ArrayList<GroundWtParameters> getwT() {
        return wT;
    }


    public Ground(String name, String plasticNumber, String sanPartNumber, Double k3, Double kCfi, Double kCeg, ArrayList<GroundWtParameters> wT) {
        this.name = name;
        this.plasticNumber = plasticNumber;
        this.SanPartNumber = sanPartNumber;
        this.k3 = k3;
        this.kCfi = kCfi;
        this.kCeg = kCeg;
        this.wT = wT;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ground{");
        sb.append("name='").append(name).append('\'');
        sb.append(", plasticNumber='").append(plasticNumber).append('\'');
        sb.append(", SanPartNumber='").append(SanPartNumber).append('\'');
        sb.append(", k3=").append(k3);
        sb.append(", kCfi=").append(kCfi);
        sb.append(", kCeg=").append(kCeg);
        sb.append(", wT=").append(wT);
        sb.append('}');
        return sb.toString();
    }
}
