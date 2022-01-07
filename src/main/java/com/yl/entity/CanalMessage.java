package com.yl.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ：jerry
 * @date ：Created in 2022/1/7 15:02
 * @description：实体对象
 * @version: V1.1
 */
@NoArgsConstructor
@Data
public class CanalMessage<T> {
    @JsonProperty("type")
    private String type;

    @JsonProperty("table")
    private String table;

    @JsonProperty("data")
    private List<T> data;

    @JsonProperty("database")
    private String database;

    @JsonProperty("es")
    private Long es;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("isDdl")
    private Boolean isDdl;

    @JsonProperty("old")
    private List<T> old;

    @JsonProperty("pkNames")
    private List<String> pkNames;

    @JsonProperty("sql")
    private String sql;

    @JsonProperty("ts")
    private Long ts;
}