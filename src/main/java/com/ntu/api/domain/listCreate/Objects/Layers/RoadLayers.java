package com.ntu.api.domain.listCreate.Objects.Layers;

import com.ntu.api.domain.listCreate.Objects.Element;

import java.io.Serializable;
import java.util.ArrayList;

public class RoadLayers extends Element implements Serializable {
    private String name;
    private ArrayList<? extends Layer> layers;

    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<? extends Layer> getLayers() {
        return layers;
    }
    public void setLayers(ArrayList<? extends Layer> layers) {
        this.layers = layers;
    }

    public RoadLayers(){
    name = "road Layers";
    layers = new ArrayList<>();
    }

    public RoadLayers(String name, ArrayList<? extends Layer> layers) {
        this.name = name;
        this.layers = layers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RoadLayers{");
        sb.append("name='").append(name).append('\'');
        sb.append(", layers=").append(layers);
        sb.append('}');
        return sb.toString();
    }
}
