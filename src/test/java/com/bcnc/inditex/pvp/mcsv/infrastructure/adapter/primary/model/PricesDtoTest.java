package com.bcnc.inditex.pvp.mcsv.infrastructure.adapter.primary.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PricesDtoTest {

    @Test
    void testConstructor() {
        PricesDto pricesDto = new PricesDto(1L, 2L, LocalDateTime.now(), LocalDateTime.now(), "priceList", 3L, 4L, 5.0f, "EUR");

        assertEquals(1L, pricesDto.getIdPrice());
        assertEquals(2L, pricesDto.getBrandId());
        assertNotNull(pricesDto.getStartDate());
        assertNotNull(pricesDto.getEndDate());
        assertEquals("priceList", pricesDto.getPriceList());
        assertEquals(3L, pricesDto.getProductId());
        assertEquals(4L, pricesDto.getPriority());
        assertEquals(5.0f, pricesDto.getPricePvp());
        assertEquals("EUR", pricesDto.getCurr());
    }
}