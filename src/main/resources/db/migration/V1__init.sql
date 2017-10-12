CREATE CACHED TABLE PUBLIC.PRODUCT(
    ID VARCHAR(60) NOT NULL,
    CREATED TIMESTAMP,
    BASE_PRICE DOUBLE,
    DESCRIPTION VARCHAR(255),
    PRODUCT_NAME VARCHAR(255)
);
ALTER TABLE PUBLIC.PRODUCT ADD CONSTRAINT PUBLIC.CONSTRAINT_PK_PRODUCT PRIMARY KEY(ID);
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.PRODUCT;

CREATE CACHED TABLE PUBLIC.STORE(
    ID VARCHAR(60) NOT NULL,
    CREATED TIMESTAMP,
    DESCRIPTION VARCHAR(255),
    STORE_NAME VARCHAR(255)
);
ALTER TABLE PUBLIC.STORE ADD CONSTRAINT PUBLIC.CONSTRAINT_PK_STORE PRIMARY KEY(ID);
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.STORE;

CREATE CACHED TABLE PUBLIC.STORE_PRICE(
    ID VARCHAR(60) NOT NULL,
    CREATED TIMESTAMP,
    NOTES VARCHAR(255),
    PRICE DOUBLE,
    PRODUCT_ID VARCHAR(60),
    STORE_ID VARCHAR(60)
);
ALTER TABLE PUBLIC.STORE_PRICE ADD CONSTRAINT PUBLIC.CONSTRAINT_PK_STORE_PRICE PRIMARY KEY(ID);
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.STORE_PRICE;

ALTER TABLE PUBLIC.STORE_PRICE ADD CONSTRAINT PUBLIC.FK_STORE_PRICE_STORE FOREIGN KEY(STORE_ID) REFERENCES PUBLIC.STORE(ID) NOCHECK;
ALTER TABLE PUBLIC.STORE_PRICE ADD CONSTRAINT PUBLIC.FK_STORE_PRICE_PRODUCT FOREIGN KEY(PRODUCT_ID) REFERENCES PUBLIC.PRODUCT(ID) NOCHECK;
