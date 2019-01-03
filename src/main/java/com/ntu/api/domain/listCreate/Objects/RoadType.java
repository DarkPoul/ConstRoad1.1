package com.ntu.api.domain.listCreate.Objects;

import java.io.Serializable;
import java.util.ArrayList;

public class RoadType extends Element implements Serializable {
    /* RoadType - тип дорожнього одягу
        name - ім'я типу дорожнього одягу
        loadType - перелік груп розрахункових навантажень притаманних для даного типу дорожнього одягу
    * */

    private String name;
    private ArrayList<DesigionLoad> loadType;

    public RoadType(String name, ArrayList<DesigionLoad> loadType) {
        this.name = name;
        this.loadType = loadType;
    }

    public String getName() {
        return name;
    }
    public ArrayList<DesigionLoad> getLoadType() {
        return loadType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RoadType{");
        sb.append("name='").append(name).append('\'');
        sb.append(", loadType=").append(loadType);
        sb.append("}\n");
        return sb.toString();
    }
}
