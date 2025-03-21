package com.bcnc.inditex.pvp.mcsv;

import com.bcnc.inditex.pvp.mcsv.application.ports.secundary.PriceRepositoryPort;
import com.bcnc.inditex.pvp.mcsv.domain.exceptions.ExceptionErrorHandler;
import com.bcnc.inditex.pvp.mcsv.infrastructure.adapter.primary.model.PricesDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PvpMcsvApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@InjectMocks
	private ExceptionErrorHandler exceptionHandlerController;

	@Mock
	private PriceRepositoryPort priceRepositoryPort;

	@ParameterizedTest
	@CsvSource({
			"2020, 6, 14, 10, 0, 0",
			"2020, 6, 14, 16, 0, 0",
			"2020, 6, 14, 21, 0, 0",
			"2020, 6, 15, 10, 0, 0",
			"2020, 6, 16, 21, 0, 0",
	})
	void testGetPrice(int year, int month, int day, int hour, int minute, int second) {
		LocalDateTime applicationDate = LocalDateTime.of(
				year,
				month,
				day,
				hour,
				minute,
				second
		);
		Long productId = 35455L;
		Long brandId = 1L;

		ResponseEntity<PricesDto> response = getPriceToController(applicationDate, productId, brandId);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
	}


	@Test
	void testGetPriceNotFound() {
		LocalDateTime applicationDate = LocalDateTime.of(2025, 6, 22, 13, 0, 0);
		Long productId = 35455L;
		Long brandId = 1L;

		ResponseEntity<PricesDto> response = getPriceToController(applicationDate,productId,brandId);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	void testGetPriceBadRequest() {
		LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
		Long productId = 35455L;
		Long brandId = 1L;

		ResponseEntity<PricesDto> response = restTemplate.getForEntity(
				"http://localhost:" + port + "/api/v1/pvp-prices?applicationDate=2025-03-18&productId={productId}&brandId={brandId}",
				PricesDto.class,
				applicationDate,
				productId,
				brandId
		);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	void testInternalServerExceptionHandler() {
		Exception exception = new Exception("Unexpected error");
		ResponseEntity<Map<String, Object>> responseEntity = exceptionHandlerController.internalServerException(exception);

		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());

		Map<String, Object> response = responseEntity.getBody();
		assertEquals("UPS! Unexpected error, contact system administrator", response.get("Message"));
	}

	private ResponseEntity<PricesDto> getPriceToController(LocalDateTime applicationDate,Long productId,Long brandId ){
		return restTemplate.getForEntity(
				"http://localhost:" + port + "/api/v1/pvp-prices?applicationDate={applicationDate}&productId={productId}&brandId={brandId}",
				PricesDto.class,
				applicationDate,
				productId,
				brandId
		);
	}
}
