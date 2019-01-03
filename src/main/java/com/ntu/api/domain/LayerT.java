package com.ntu.api.domain;

import java.io.Serializable;

public class LayerT implements Serializable {

    private Integer id;
    private String type;
    private String construction;
    private Double thickness;

    public LayerT(Integer id, String type, String construction, Double thickness) {
        this.id = id;
        this.type = type;
        this.construction = construction;
        this.thickness = thickness;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getConstruction() {
        return construction;
    }
    public void setConstruction(String construction) {
        this.construction = construction;
    }
    public Double getThickness() {
        return thickness;
    }
    public void setThickness(Double thickness) {
        this.thickness = thickness;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Layer{");
        sb.append("id=").append(id);
        sb.append(", type='").append(type).append('\'');
        sb.append(", construction='").append(construction).append('\'');
        sb.append(", thickness=").append(thickness);
        sb.append('}');
        return sb.toString();
    }
}
