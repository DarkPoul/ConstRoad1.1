package com.ntu.api.domain.listCreate.Objects;

import java.io.Serializable;

public class RoadUsage extends Element implements Serializable {
/* RoadUsage - використання ділянки (в якості стоянки, перехрестя, для пробігу)
name - ім'я (назва)
* */

    private String name;

    public RoadUsage(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RoadUsage{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
