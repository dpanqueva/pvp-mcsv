CREATE TABLE PRICE (
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
COMMENT ON COLUMN PRICE.BRAND_ID IS 'Identificador único de la marca (ejemplo: 1 para ZARA)';
COMMENT ON COLUMN PRICE.START_DATE IS 'Fecha de inicio de validez del precio y tarifa';
COMMENT ON COLUMN PRICE.END_DATE IS 'Fecha de finalización de validez del precio y tarifa';
COMMENT ON COLUMN PRICE.PRICE_LIST IS 'Identificador de la tarifa específica aplicable';
COMMENT ON COLUMN PRICE.PRODUCT_ID IS 'Identificador único del producto en el catálogo';
COMMENT ON COLUMN PRICE.PRIORITY IS 'Valor numérico para desambiguar precios coincidentes';
COMMENT ON COLUMN PRICE.PRICE IS 'Precio final de venta del producto';
COMMENT ON COLUMN PRICE.CURR IS 'Código ISO de la moneda (ejemplo: EUR, USD, etc.)';