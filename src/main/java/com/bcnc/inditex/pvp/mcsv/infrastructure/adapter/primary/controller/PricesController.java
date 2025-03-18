package com.bcnc.inditex.pvp.mcsv.infrastructure.adapter.primary.controller;

import com.bcnc.inditex.pvp.mcsv.application.ports.primary.PriceService;
import com.bcnc.inditex.pvp.mcsv.domain.exceptions.NotFoundException;
import com.bcnc.inditex.pvp.mcsv.infrastructure.adapter.primary.model.PricesDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/pvp-prices")
@Tag(name = "Precios", description = "API para gestionar precios finales de producto")
@RequiredArgsConstructor
@Slf4j
public class PricesController {

    private final PriceService priceService;
    private final CircuitBreakerFactory<?,?> breakerFactory;
    @Operation(summary = "Get a productId by date and brand and product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the productId",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PricesDto.class))}),
            @ApiResponse(responseCode = "400", description = "UPS! Bad request, date must have the format yyyy-mm-ddHH:mm:ss. Example: 2020-06-1410:10:00",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "UPS! Unexpected error, contact system administrator",
                    content = @Content)})
    @CircuitBreaker(name = "pvp-prices", fallbackMethod = "pricesPvpFallback")
    @GetMapping
    public ResponseEntity<PricesDto> pricesPvp(
            @DateTimeFormat(pattern = "yyyy-MM-ddHH:mm:ss")
            @RequestParam LocalDateTime applicationDate, @RequestParam Long productId
            , @RequestParam Long brandId) {

        return ResponseEntity.ok(priceService.getPriceByDateAndBrandAndProduct(applicationDate, productId, brandId));
    }

    private ResponseEntity<PricesDto> pricesPvpFallback(LocalDateTime applicationDate, Long product, Long brand, Throwable error) {
        String message = String.format("Fallback method called for applicationDate: %s, product: %s, brand: %s", applicationDate, product, brand);

        if (error instanceof NotFoundException) {
            throw new NotFoundException("Price not found for request");
        }
        log.error(message.concat("-").concat(error.getMessage()), error);
        return ResponseEntity.ok().body(buildPricesDto());
    }

    private PricesDto buildPricesDto() {
        return PricesDto.builder()
                .idPrice(1L)
                .pricePvp(1.0f)
                .priceList("priceList")
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .brandId(1L)
                .productId(1L)
                .priority(1L)
                .curr("curr")
                .build();
    }

}
