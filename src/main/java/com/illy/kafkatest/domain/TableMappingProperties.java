package com.illy.kafkatest.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
@ConfigurationProperties(prefix = "tablemapping")
public class TableMappingProperties {

    private Table table = new Table();
    public Table getTable(){
        return table;
    }

    @NestedConfigurationProperty
    private List<Column> columns = new ArrayList<>();

    public List<Column> getColumns() {
        return columns;
    }

}
