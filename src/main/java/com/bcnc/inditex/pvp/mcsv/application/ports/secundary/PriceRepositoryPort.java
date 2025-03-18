package com.bcnc.inditex.pvp.mcsv.application.ports.secundary;

import com.bcnc.inditex.pvp.mcsv.domain.entity.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepositoryPort {

    Optional<Price> findTopPriceByDateAndBrandAndProduct(LocalDateTime applicationDate, Long product, Long brand);
}
