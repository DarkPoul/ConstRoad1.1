package com.ntu.api.domain.listCreate.Objects;

import java.io.Serializable;

public class ElasticModul implements Serializable {
    /*
    ElasticModul - описує розрахунковий короткочасний модуль пружності
    (модуль пружності при статичній дії навантаження) за температури
    temperature  - температуура
    elasticModule - модуль пружності
    * */

    private Integer temperature;
    private Integer elasticModule;

    public ElasticModul(Integer temperature, Integer elasticModule) {
        this.temperature = temperature;
        this.elasticModule = elasticModule;
    }

    public Integer getTemperature() {
        return temperature;
    }
    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }
    public Integer getElasticModule() {
        return elasticModule;
    }
    public void setElasticModule(Integer elasticModule) {
        this.elasticModule = elasticModule;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ElasticModul{");
        sb.append("temperature=").append(temperature);
        sb.append(", elasticModule=").append(elasticModule);
        sb.append('}');
        return sb.toString();
    }
}
