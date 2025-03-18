package com.bcnc.inditex.pvp.mcsv.infrastructure.adapter.primary.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PricesDto {

    private Long productId;
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Float pricePvp;
    private String curr;

}
