package com.zt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @Author Tommy
 * @Date 2024/6/9 15:22
 * @Version 1.0
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModelGlassesCommodity {

    @Id
    private String id;

    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;

}
