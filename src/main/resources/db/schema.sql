CREATE TABLE PRICES (
    ID_PRICE INT AUTO_INCREMENT,
    BRAND_ID INT NOT NULL,
    START_DATE DATETIME NOT NULL,
    END_DATE DATETIME NOT NULL,
    PRICE_LIST VARCHAR(50) NOT NULL,
    PRODUCT_ID INT NOT NULL,
    PRIORITY INT NOT NULL,
    PRICE DECIMAL(15,2) NOT NULL,
    CURR VARCHAR(3) NOT NULL,
    PRIMARY KEY (ID_PRICE)
);

-- Column comments
COMMENT ON COLUMN PRICES.BRAND_ID IS 'Identificador único de la marca (ejemplo: 1 para ZARA)';
COMMENT ON COLUMN PRICES.START_DATE IS 'Fecha de inicio de validez del precio y tarifa';
COMMENT ON COLUMN PRICES.END_DATE IS 'Fecha de finalización de validez del precio y tarifa';
COMMENT ON COLUMN PRICES.PRICE_LIST IS 'Identificador de la tarifa específica aplicable';
COMMENT ON COLUMN PRICES.PRODUCT_ID IS 'Identificador único del producto en el catálogo';
COMMENT ON COLUMN PRICES.PRIORITY IS 'Valor numérico para desambiguar precios coincidentes';
COMMENT ON COLUMN PRICES.PRICE IS 'Precio final de venta del producto';
COMMENT ON COLUMN PRICES.CURR IS 'Código ISO de la moneda (ejemplo: EUR, USD, etc.)';


CREATE INDEX IDX_DATE_PRODUCT_BRAND ON PRICES (START_DATE,END_DATE,PRODUCT_ID,BRAND_ID);

