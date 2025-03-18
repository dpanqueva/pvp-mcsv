package com.bcnc.inditex.pvp.mcsv.infrastructure.adapter.secondary.mapper;


public interface GenericMapper<D,E>{

    D toDto(E entity);

}
