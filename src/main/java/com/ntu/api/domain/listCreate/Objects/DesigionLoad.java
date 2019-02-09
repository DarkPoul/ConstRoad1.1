package com.ntu.api.domain.listCreate.Objects;

import java.io.Serializable;

public class DesigionLoad extends Element implements Serializable {
    /* DesigionLoad - група розрахункового навантаження
        name - і'мя групи розрахункового навантаження
        staticLoadAxis - нормативне статичне навантаження на вісь, кН
        Qroz - нормативне статичне навантаження на поверхню покриття від колеса розрахункового автомобіля, кН
        preassureWeel - тиск повітря в шині, МПа
        Ds - діаметр відбитка колеса, м
        Dm - діаметр відбитка колеса рухомого автомобіля, м

    * */

    private String name;
    private Integer staticLoadAxis;
    private Double Qroz;
    private Double preassureWeel;
    private Double Ds;
    private Double Dm;
    private Double bKoeficient;

    public DesigionLoad(String name, Integer staticLoadAxis, Double staticLoadWeel, Double preassureWeel, Double diaWeelPrint, Double diaMovWeelPrint, Double bKoeficient) {
        this.name = name;
        this.staticLoadAxis = staticLoadAxis;
        this.Qroz = staticLoadWeel;
        this.preassureWeel = preassureWeel;
        this.Ds = diaWeelPrint;
        this.Dm = diaMovWeelPrint;
        this.bKoeficient = bKoeficient;
    }

    @Override
    public String getName() {
        return name;
    }
    public Integer getStaticLoadAxis() {
        return staticLoadAxis;
    }
    public Double getQroz() {
        return Qroz;
    }
    public Double getPreassureWeel() {
        return preassureWeel;
    }
    public Double getDs() {
        return Ds;
    }
    public Double getDm() {
        return Dm;
    }
    public Double getbKoeficient() {
        return bKoeficient;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DesigionLoad{");
        sb.append("name='").append(name).append('\'');
        sb.append(", staticLoadAxis=").append(staticLoadAxis);
        sb.append(", Qroz=").append(Qroz);
        sb.append(", preassureWeel=").append(preassureWeel);
        sb.append(", Ds=").append(Ds);
        sb.append(", Dm=").append(Dm);
        sb.append(", bKoeficient=").append(bKoeficient);
        sb.append('}');
        return sb.toString();
    }
}
