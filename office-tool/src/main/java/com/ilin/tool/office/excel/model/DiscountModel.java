package com.ilin.tool.office.excel.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DiscountModel implements Serializable {
    private Long seq;
    private Long crowdGroupId;
    private Long crowdId;
    private Boolean sendDiscount;
    private Long thresholdOfFullReduce;
    private Long amountOfFullReduce;
}
