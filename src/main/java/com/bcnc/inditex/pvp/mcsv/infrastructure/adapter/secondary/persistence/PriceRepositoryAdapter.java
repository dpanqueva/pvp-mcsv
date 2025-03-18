package com.bcnc.inditex.pvp.mcsv.infrastructure.adapter.secondary.persistence;

import com.bcnc.inditex.pvp.mcsv.application.ports.secundary.PriceRepositoryPort;
import com.bcnc.inditex.pvp.mcsv.domain.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceRepositoryAdapter extends JpaRepository<Price, Long>, PriceRepositoryPort {


    @Query("SELECT p FROM Price p WHERE :applicationDate BETWEEN p.startDate AND p.endDate  AND p.productId = :productId AND p.brandId = :brandId ORDER BY p.priority DESC LIMIT 1")
    Optional<Price> findTopPriceByDateAndBrandAndProduct(@Param("applicationDate") LocalDateTime applicationDate,
                                                     @Param("productId") Long productId,
                                                     @Param("brandId") Long brandId);
}
