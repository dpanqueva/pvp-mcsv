package com.bcnc.inditex.pvp.mcsv.infrastructure.adapter.secondary.mapper;

import com.bcnc.inditex.pvp.mcsv.domain.entity.Price;
import com.bcnc.inditex.pvp.mcsv.infrastructure.adapter.primary.model.PricesDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper extends GenericMapper< PricesDto,Price> {

    @Override
    PricesDto toDto(Price entity);
}
