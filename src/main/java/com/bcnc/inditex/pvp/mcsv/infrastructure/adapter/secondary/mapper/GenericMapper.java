package com.bcnc.inditex.pvp.mcsv.infrastructure.adapter.secondary.mapper;


import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface GenericMapper<D,E>{

    E toEntity(D dto);

    D toDto(E entity);

}
