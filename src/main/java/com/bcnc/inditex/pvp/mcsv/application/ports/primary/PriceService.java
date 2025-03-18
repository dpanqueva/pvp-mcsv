package com.bcnc.inditex.pvp.mcsv.application.ports.primary;

import com.bcnc.inditex.pvp.mcsv.infrastructure.adapter.primary.model.PricesDto;

import java.time.LocalDateTime;

public interface PriceService {

    public PricesDto getPriceByDateAndBrandAndProduct(LocalDateTime applicationDate, Long product, Long brand);
}
