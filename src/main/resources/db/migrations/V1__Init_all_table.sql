CREATE TABLE IF NOT EXISTS ${schema}.brand
(
    id          UUID PRIMARY KEY,
    name        VARCHAR(255)                NOT NULL,
    logo        VARCHAR(255),
    description TEXT,
    created_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted     BOOLEAN                     NOT NULL DEFAULT FALSE
);


CREATE TABLE IF NOT EXISTS ${schema}.seller
(
    id          UUID PRIMARY KEY,
    name        VARCHAR(255)                NOT NULL,
    logo        VARCHAR(255),
    description TEXT,
    created_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted     BOOLEAN                     NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS ${schema}.product
(
    id             UUID PRIMARY KEY,
    name           VARCHAR(255)                NOT NULL,
    description    TEXT,
    original_price DECIMAL(10, 2)              NOT NULL,
    sale_price     DECIMAL(10, 2)              NOT NULL,
    brand_id       UUID                        NOT NULL,
    seller_id      UUID                        NOT NULL,
    image          VARCHAR(255),
    is_new         BOOLEAN                     NOT NULL DEFAULT FALSE,
    rating         DECIMAL(2, 1)               NOT NULL DEFAULT 0,
    sold           INTEGER                     NOT NULL DEFAULT 0,
    created_at     TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted        BOOLEAN                     NOT NULL DEFAULT FALSE,
    CONSTRAINT fk_brand_product FOREIGN KEY (brand_id) REFERENCES brand (id),
    CONSTRAINT fk_seller_product FOREIGN KEY (seller_id) REFERENCES seller (id)
);

CREATE TABLE IF NOT EXISTS ${schema}.category
(
    id           UUID PRIMARY KEY,
    name         VARCHAR                     NOT NULL,
    parent_id    UUID,
    has_children BOOLEAN                     NOT NULL DEFAULT FALSE,
    created_at   TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted      BOOLEAN                     NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS ${schema}.category_product
(
    product_id  UUID,
    category_id UUID,
    created_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted     BOOLEAN                              DEFAULT FALSE,
    PRIMARY KEY (product_id, category_id)
);