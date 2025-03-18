package com.bcnc.inditex.pvp.mcsv.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRICE")
    private Long idPrice;

    @Column(name = "BRAND_ID")
    private Long brandId;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "PRICE_LIST")
    private String priceList;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE")
    private Float pricePvp;

    @Column(name = "CURR")
    private String curr;

}
