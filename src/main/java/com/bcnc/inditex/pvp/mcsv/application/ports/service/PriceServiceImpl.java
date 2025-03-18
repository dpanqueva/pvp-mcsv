package com.bcnc.inditex.pvp.mcsv.application.ports.service;

import com.bcnc.inditex.pvp.mcsv.application.ports.primary.PriceService;
import com.bcnc.inditex.pvp.mcsv.application.ports.secundary.PriceRepositoryPort;
import com.bcnc.inditex.pvp.mcsv.domain.entity.Price;
import com.bcnc.inditex.pvp.mcsv.domain.exceptions.NotFoundException;
import com.bcnc.inditex.pvp.mcsv.infrastructure.adapter.primary.model.PricesDto;
import com.bcnc.inditex.pvp.mcsv.infrastructure.adapter.secondary.mapper.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    private  final PriceRepositoryPort priceRepositoryPort;
    private  final PriceMapper priceMapper;

    @Override
    public PricesDto getPriceByDateAndBrandAndProduct(LocalDateTime applicationDate, Long productId, Long brandId) {

        Optional<Price> price =
        priceRepositoryPort.findTopPriceByDateAndBrandAndProduct(applicationDate, productId, brandId);

        if (price.isEmpty()) {
            throw new NotFoundException("Price not found for request");
        }
        return priceMapper.toDto(price.get());
    }
}
