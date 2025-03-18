package com.bcnc.inditex.pvp.mcsv.domain.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {

    @Test
    void testConstructor() {

        Price price = new Price(1L, 2L, LocalDateTime.now(), LocalDateTime.now(), "priceList", 3L, 1, 5.0f, "EUR");

        assertEquals(1L, price.getIdPrice());
        assertEquals(2L, price.getBrandId());
        assertNotNull(price.getStartDate());
        assertNotNull(price.getEndDate());
        assertEquals("priceList", price.getPriceList());
        assertEquals(3L, price.getProductId());
        assertEquals(1, price.getPriority());
        assertEquals(5.0f, price.getPricePvp());
        assertEquals("EUR", price.getCurr());
    }

    @Test
    void testNoArgsConstructor() {

        Price price = new Price();

        assertNull(price.getIdPrice());
        assertNull(price.getBrandId());
        assertNull(price.getStartDate());
        assertNull(price.getEndDate());
        assertNull(price.getPriceList());
        assertNull(price.getProductId());
        assertNull(price.getPriority());
        assertNull(price.getPricePvp());
        assertNull(price.getCurr());
    }

    @Test
    void testAllArgsConstructor() {

        Price price = new Price(1L, 2L, LocalDateTime.now(), LocalDateTime.now(), "priceList", 3L, 1, 5.0f, "EUR");

        assertEquals(1L, price.getIdPrice());
        assertEquals(2L, price.getBrandId());
        assertNotNull(price.getStartDate());
        assertNotNull(price.getEndDate());
        assertEquals("priceList", price.getPriceList());
        assertEquals(3L, price.getProductId());
        assertEquals(1, price.getPriority());
        assertEquals(5.0f, price.getPricePvp());
        assertEquals("EUR", price.getCurr());
    }
}