INSERT INTO ecomerce.brand (id, name, logo, description, created_at, updated_at, deleted)
VALUES ('a6a99888-2c81-4bb1-b840-66511af2986e', 'Avon', null, 'Avon desc', '2024-01-20 02:52:30.041413',
        '2024-01-20 02:52:30.041413', false);
INSERT INTO ecomerce.brand (id, name, logo, description, created_at, updated_at, deleted)
VALUES ('55855c5d-2961-4904-a89b-21142c0ba7bc', 'Olay', null, 'Olay desc', '2024-01-20 02:52:30.041413',
        '2024-01-20 02:52:30.041413', false);
INSERT INTO ecomerce.brand (id, name, logo, description, created_at, updated_at, deleted)
VALUES ('780095e0-4e09-4b8d-8adc-c237c8885685', 'Intel', null, 'Intel desc', '2024-01-20 02:52:30.041413',
        '2024-01-20 02:52:30.041413', false);
INSERT INTO ecomerce.brand (id, name, logo, description, created_at, updated_at, deleted)
VALUES ('9ad9c201-21f3-4ed8-8b7c-abc8fc822f21', 'Sony', null, 'Sony desc', '2024-01-20 02:52:30.041413',
        '2024-01-20 02:52:30.041413', false);
INSERT INTO ecomerce.brand (id, name, logo, description, created_at, updated_at, deleted)
VALUES ('322ceeca-08bd-4bb8-a50f-bad17a12c536', 'Dior', null, 'Dior desc', '2024-01-20 02:52:30.041413',
        '2024-01-20 02:52:30.041413', false);
INSERT INTO ecomerce.brand (id, name, logo, description, created_at, updated_at, deleted)
VALUES ('fe1ef5cd-e878-43fe-b8b3-fd9d99d02835', 'Apple', null, 'Apple desc', '2024-01-20 02:52:30.041413',
        '2024-01-20 02:52:30.041413', false);
INSERT INTO ecomerce.brand (id, name, logo, description, created_at, updated_at, deleted)
VALUES ('9fa862de-402a-4191-bd57-9b1f246d36da', 'Nike', null, 'Nike desc', '2024-01-20 02:52:30.041413',
        '2024-01-20 02:52:30.041413', false);
INSERT INTO ecomerce.brand (id, name, logo, description, created_at, updated_at, deleted)
VALUES ('00a75d21-283b-449d-bf2f-018d4ec9f11e', 'Pandora', null, 'Pandora desc', '2024-01-20 02:52:30.041413',
        '2024-01-20 02:52:30.041413', false);
INSERT INTO ecomerce.brand (id, name, logo, description, created_at, updated_at, deleted)
VALUES ('ab577e6d-2569-46ca-9221-a3f800c1b156', 'Samsung', null, 'Samsung desc', '2024-01-20 02:52:30.041413',
        '2024-01-20 02:52:30.041413', false);
INSERT INTO ecomerce.brand (id, name, logo, description, created_at, updated_at, deleted)
VALUES ('1bfe0261-24b2-41c9-a77d-b1725db48e4b', 'Lenovo', null, 'Lenovo desc', '2024-01-20 02:52:30.041413',
        '2024-01-20 02:52:30.041413', false);


INSERT INTO ecomerce.seller (id, name, logo, description, created_at, updated_at, deleted)
VALUES ('6474ff64-6576-4798-905b-19eeab6037b5', 'ABC Store',
        'https://placehold.jp/30/dd6699/ffffff/150x150.png?text=placeholder+image', 'Lorem ipsum dolor sit amet',
        '2024-01-20 02:55:14.429025', '2024-01-20 02:55:14.429025', false);
INSERT INTO ecomerce.seller (id, name, logo, description, created_at, updated_at, deleted)
VALUES ('1212f632-dd55-4408-9f2e-eb1620fea36b', 'FPT Shop',
        'https://placehold.jp/30/dd6699/ffffff/150x150.png?text=placeholder+image', 'Lorem ipsum dolor sit amet',
        '2024-01-20 02:55:14.429025', '2024-01-20 02:55:14.429025', false);
INSERT INTO ecomerce.seller (id, name, logo, description, created_at, updated_at, deleted)
VALUES ('d806bd67-64fd-4aef-be11-290496d40f65', 'TSell',
        'https://placehold.jp/30/dd6699/ffffff/150x150.png?text=placeholder+image', 'Lorem ipsum dolor sit amet',
        '2024-01-20 02:55:14.429025', '2024-01-20 02:55:14.429025', false);
INSERT INTO ecomerce.seller (id, name, logo, description, created_at, updated_at, deleted)
VALUES ('bdef2928-2335-4c72-8fb5-d52b23c850a2', 'LC Shop',
        'https://placehold.jp/30/dd6699/ffffff/150x150.png?text=placeholder+image', 'Lorem ipsum dolor sit amet',
        '2024-01-20 02:55:14.429025', '2024-01-20 02:55:14.429025', false);
INSERT INTO ecomerce.seller (id, name, logo, description, created_at, updated_at, deleted)
VALUES ('99dbbd4d-8b03-4be9-88d5-7fc8d2a58b95', 'HTV Store',
        'https://placehold.jp/30/dd6699/ffffff/150x150.png?text=placeholder+image', 'Lorem ipsum dolor sit amet',
        '2024-01-20 02:55:14.429025', '2024-01-20 02:55:14.429025', false);

INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('0f051b4b-460b-423f-9dac-d4aed5953033', 'Antec Air Cooler', 'Lorem ipsum dolor sit amet', 250.00, 170.00,
        '780095e0-4e09-4b8d-8adc-c237c8885685', '1212f632-dd55-4408-9f2e-eb1620fea36b',
        'https://i.ibb.co/yqndcgs/cpu-5.webp', true, 4.6, 21, '2024-01-20 02:57:41.078921',
        '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('75038edb-019e-468e-a317-cd163dd11a07', 'Apple iPad Air', 'Lorem ipsum dolor sit amet', 999.00, 949.99,
        'fe1ef5cd-e878-43fe-b8b3-fd9d99d02835', '6474ff64-6576-4798-905b-19eeab6037b5',
        'https://i.ibb.co/G9ttXCM/ipad-1.webp', false, 4.6, 12, '2024-01-20 02:57:41.078921',
        '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('2cc86fc6-1b30-4132-b5e1-57f4056c0867', 'Apple Watch Sport Band', 'Lorem ipsum dolor sit amet', 470.00, 399.99,
        'fe1ef5cd-e878-43fe-b8b3-fd9d99d02835', '1212f632-dd55-4408-9f2e-eb1620fea36b',
        'https://i.ibb.co/xqQtGPr/watch-1.webp', true, 3.6, 28, '2024-01-20 02:57:41.078921',
        '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('d4700c43-4bfd-4c1a-8997-f89a1033874f', 'Brand Cosmetic Product', 'Lorem ipsum dolor sit amet', 160.00, 120.00,
        'a6a99888-2c81-4bb1-b840-66511af2986e', '99dbbd4d-8b03-4be9-88d5-7fc8d2a58b95',
        'https://i.ibb.co/qkspnNy/cosmetics-1.webp', false, 2.0, 52,
        '2024-01-20 02:57:41.078921', '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('e0007aa2-18fa-4b12-9cb1-459c64d9c5aa', 'DeepCool Air Cooler', 'Lorem ipsum dolor sit amet', 130.00, 110.00,
        '780095e0-4e09-4b8d-8adc-c237c8885685', 'd806bd67-64fd-4aef-be11-290496d40f65',
        'https://i.ibb.co/2d2qBRb/cpu-1.webp', false, 2.9, 47,
        '2024-01-20 02:57:41.078921', '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('408a00fd-0aca-4022-811e-92c17d3b9120', 'Fortuna Bangle Three-row', 'Lorem ipsum dolor sit amet', 600.00,
        499.00, '00a75d21-283b-449d-bf2f-018d4ec9f11e', 'bdef2928-2335-4c72-8fb5-d52b23c850a2',
        'https://i.ibb.co/ThVqy07/bracelet-4.webp', false, 4.7, 28,
        '2024-01-20 02:57:41.078921', '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('6dc9b28e-1bad-4af2-a7c6-590fd4766ceb', 'Fortuna Creole Hoop', 'Lorem ipsum dolor sit amet', 550.00, 380.00,
        '322ceeca-08bd-4bb8-a50f-bad17a12c536', 'bdef2928-2335-4c72-8fb5-d52b23c850a2',
        'https://i.ibb.co/wNsPjhC/earring-8.webp', false, 4.1, 36,
        '2024-01-20 02:57:41.078921', '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('433b8aa7-cdc6-48d8-8bb1-4178a9dc0066', 'Galaxy Android Tablet', 'Lorem ipsum dolor sit amet', 380.00, 340.00,
        'ab577e6d-2569-46ca-9221-a3f800c1b156', 'd806bd67-64fd-4aef-be11-290496d40f65',
        'https://i.ibb.co/RpnnGmx/mobile-1.webp', false, 5.0, 45,
        '2024-01-20 02:57:41.078921', '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('df7cbdf1-2247-4817-84e8-0c1bab22a8ef', 'Gaming Headphone', 'Lorem ipsum dolor sit amet', 300.00, 270.00,
        '1bfe0261-24b2-41c9-a77d-b1725db48e4b', '6474ff64-6576-4798-905b-19eeab6037b5',
        'https://i.ibb.co/M6nVQ2v/headphone-5.webp', false, 0.0, 100,
        '2024-01-20 02:57:41.078921', '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('f920afb8-6448-4780-b740-e6feb13e08bb', 'Headphone with Mic', 'Lorem ipsum dolor sit amet', 490.00, 360.00,
        '9ad9c201-21f3-4ed8-8b7c-abc8fc822f21', 'd806bd67-64fd-4aef-be11-290496d40f65',
        'https://i.ibb.co/xDqmwGW/headphone-8.webp', true, 4.0, 19, '2024-01-20 02:57:41.078921',
        '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('1f5da368-6dfb-42b3-91f8-eea428ef9c18', 'Tea Lemon For Fine Hair', 'Lorem ipsum dolor sit amet', 70.00,
        55.00, 'a6a99888-2c81-4bb1-b840-66511af2986e', 'd806bd67-64fd-4aef-be11-290496d40f65',
        'https://i.ibb.co/998PPnW/cosmetics-4.webp', false, 4.0, 14,
        '2024-01-20 02:57:41.078921', '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('735d967d-2016-488e-9126-5fcde71e3ae5', 'Sony Smart Watch', 'Lorem ipsum dolor sit amet', 299.00, 189.99,
        '9ad9c201-21f3-4ed8-8b7c-abc8fc822f21', 'bdef2928-2335-4c72-8fb5-d52b23c850a2',
        'https://i.ibb.co/sQmZc0x/watch-5.webp', true, 4.3, 17, '2024-01-20 02:57:41.078921',
        '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('0f0cddb9-d99b-4592-8238-537a3fc25e27', 'Sony Lady Fitness Watch', 'Lorem ipsum dolor sit amet', 199.00, 169.00,
        '9ad9c201-21f3-4ed8-8b7c-abc8fc822f21', '6474ff64-6576-4798-905b-19eeab6037b5',
        'https://i.ibb.co/w4K4TY2/watch-9.webp', false, 3.9, 36,
        '2024-01-20 02:57:41.078921', '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('47d1b0b9-fe5f-47b2-b29b-9e6d64f53afb', 'Nike Retro GTS-2', 'Lorem ipsum dolor sit amet', 450.00, 399.99,
        '9fa862de-402a-4191-bd57-9b1f246d36da', '99dbbd4d-8b03-4be9-88d5-7fc8d2a58b95',
        'https://i.ibb.co/WFWKQWZ/shoes-1.webp', true, 4.8, 78, '2024-01-20 02:57:41.078921',
        '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('5904bb4e-3807-41ce-ac7a-5da927b462f3', 'Lenovo Wireless Bluetooth', 'Lorem ipsum dolor sit amet', 99.99, 79.99,
        '1bfe0261-24b2-41c9-a77d-b1725db48e4b', '1212f632-dd55-4408-9f2e-eb1620fea36b',
        'https://i.ibb.co/0XPd7D4/blutooth-4.webp', true, 3.7, 63, '2024-01-20 02:57:41.078921',
        '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('a13f9564-69a4-4099-b686-4955484555d3', 'Lenovo Sports Bluetooth', 'Lorem ipsum dolor sit amet', 57.00, 49.00,
        '1bfe0261-24b2-41c9-a77d-b1725db48e4b', '6474ff64-6576-4798-905b-19eeab6037b5',
        'https://i.ibb.co/YNLw2QM/blutooth-1.webp', false, 4.0, 74,
        '2024-01-20 02:57:41.078921', '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('d7a8fb56-a5ff-4189-bab7-c4adf4919603', 'iPhone 14 Pro', 'Lorem ipsum dolor sit amet', 1399.00, 1350.00,
        'fe1ef5cd-e878-43fe-b8b3-fd9d99d02835', 'd806bd67-64fd-4aef-be11-290496d40f65',
        'https://i.ibb.co/gmdpWtD/mobile-5.webp', true, 5.0, 17, '2024-01-20 02:57:41.078921',
        '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('86ea7d39-7f5a-42c4-85c2-44b59a9afeee', 'Innisfree Face Wash', 'Lorem ipsum dolor sit amet', 130.00, 99.99,
        '55855c5d-2961-4904-a89b-21142c0ba7bc', '6474ff64-6576-4798-905b-19eeab6037b5',
        'https://i.ibb.co/9n6f275/cream-1.webp', false, 4.3, 41, '2024-01-20 02:57:41.078921',
        '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('370bc848-c1ea-4bbd-873c-618773468041', 'INIKA Mineral Sunkissed', 'Lorem ipsum dolor sit amet', 99.00, 80.00,
        '55855c5d-2961-4904-a89b-21142c0ba7bc', '99dbbd4d-8b03-4be9-88d5-7fc8d2a58b95',
        'https://i.ibb.co/PGRX8wM/powder-1.webp', false, 2.0, 12,
        '2024-01-20 02:57:41.078921', '2024-01-20 02:57:41.078921', false);
INSERT INTO ecomerce.product (id, name, description, original_price, sale_price, brand_id, seller_id, image, is_new,
                              rating, sold, created_at, updated_at, deleted)
VALUES ('01a5e3a8-2c3a-44d2-aa18-4d8689e9dd11', 'Headphones Wireless', 'Lorem ipsum dolor sit amet', 150.00, 103.20,
        '9ad9c201-21f3-4ed8-8b7c-abc8fc822f21', '1212f632-dd55-4408-9f2e-eb1620fea36b',
        'https://i.ibb.co/zS3k6QB/headphone-1.webp', true, 3.0, 38, '2024-01-20 02:57:41.078921',
        '2024-01-20 02:57:41.078921', false);



INSERT INTO ecomerce.category (id, name, parent_id, has_children, created_at, updated_at, deleted)
VALUES ('4411bf50-5a4d-4a51-a9c5-87c5cc1eddc5', 'Technology', null, true, '2024-01-20 02:53:16.643266',
        '2024-01-20 02:53:16.643266', false);
INSERT INTO ecomerce.category (id, name, parent_id, has_children, created_at, updated_at, deleted)
VALUES ('0e55ef79-e364-4806-8535-14e8288cd49e', 'Beauty', null, true, '2024-01-20 02:53:16.643266',
        '2024-01-20 02:53:16.643266', false);
INSERT INTO ecomerce.category (id, name, parent_id, has_children, created_at, updated_at, deleted)
VALUES ('1b8e063a-a108-47c1-9968-1e1b78bcf022', 'Smartwatch', '4411bf50-5a4d-4a51-a9c5-87c5cc1eddc5', false,
        '2024-01-20 02:53:16.643266', '2024-01-20 02:53:16.643266', false);
INSERT INTO ecomerce.category (id, name, parent_id, has_children, created_at, updated_at, deleted)
VALUES ('e586dafc-6d41-4206-a279-17664431ef2a', 'Headphone', '4411bf50-5a4d-4a51-a9c5-87c5cc1eddc5', false,
        '2024-01-20 02:53:16.643266', '2024-01-20 02:53:16.643266', false);
INSERT INTO ecomerce.category (id, name, parent_id, has_children, created_at, updated_at, deleted)
VALUES ('9ad9c201-21f3-4ed8-8b7c-abc8fc822f21', 'Earphone', '4411bf50-5a4d-4a51-a9c5-87c5cc1eddc5', false,
        '2024-01-20 02:53:16.643266', '2024-01-20 02:53:16.643266', false);
INSERT INTO ecomerce.category (id, name, parent_id, has_children, created_at, updated_at, deleted)
VALUES ('fe1ef5cd-e878-43fe-b8b3-fd9d99d02835', 'Computer Accessories', '4411bf50-5a4d-4a51-a9c5-87c5cc1eddc5', false,
        '2024-01-20 02:53:16.643266', '2024-01-20 02:53:16.643266', false);
INSERT INTO ecomerce.category (id, name, parent_id, has_children, created_at, updated_at, deleted)
VALUES ('0b09f9d3-ab9d-41cf-9925-f5db8b4dbdc6', 'Shoes', '0e55ef79-e364-4806-8535-14e8288cd49e', false,
        '2024-01-20 02:53:16.643266', '2024-01-20 02:53:16.643266', false);
INSERT INTO ecomerce.category (id, name, parent_id, has_children, created_at, updated_at, deleted)
VALUES ('4cdc40e6-e85e-4470-9458-afd624ee3a7a', 'Cosmetic', '0e55ef79-e364-4806-8535-14e8288cd49e', false,
        '2024-01-20 02:53:16.643266', '2024-01-20 02:53:16.643266', false);
INSERT INTO ecomerce.category (id, name, parent_id, has_children, created_at, updated_at, deleted)
VALUES ('2e5b8298-2f4a-4198-96a8-e7ca4ea9e4bd', 'Jewelry', '0e55ef79-e364-4806-8535-14e8288cd49e', false,
        '2024-01-20 02:53:16.643266', '2024-01-20 02:53:16.643266', false);
INSERT INTO ecomerce.category (id, name, parent_id, has_children, created_at, updated_at, deleted)
VALUES ('da683523-593b-44e2-b2c6-e2cf3b3c67e1', 'Smartphone/Tablet', '4411bf50-5a4d-4a51-a9c5-87c5cc1eddc5', false,
        '2024-01-20 02:53:16.643266', '2024-01-20 02:53:16.643266', false);

INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('01a5e3a8-2c3a-44d2-aa18-4d8689e9dd11', 'e586dafc-6d41-4206-a279-17664431ef2a', '2024-01-20 03:03:59.678987',
        '2024-01-20 03:03:59.678987', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('0f051b4b-460b-423f-9dac-d4aed5953033', 'fe1ef5cd-e878-43fe-b8b3-fd9d99d02835', '2024-01-20 03:03:59.678987',
        '2024-01-20 03:03:59.678987', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('0f0cddb9-d99b-4592-8238-537a3fc25e27', '1b8e063a-a108-47c1-9968-1e1b78bcf022', '2024-01-20 10:49:24.085136',
        '2024-01-20 10:49:24.085136', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('1f5da368-6dfb-42b3-91f8-eea428ef9c18', '4cdc40e6-e85e-4470-9458-afd624ee3a7a', '2024-01-20 10:49:24.085136',
        '2024-01-20 10:49:24.085136', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('2cc86fc6-1b30-4132-b5e1-57f4056c0867', '1b8e063a-a108-47c1-9968-1e1b78bcf022', '2024-01-20 03:03:59.678987',
        '2024-01-20 03:03:59.678987', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('370bc848-c1ea-4bbd-873c-618773468041', '4cdc40e6-e85e-4470-9458-afd624ee3a7a', '2024-01-20 10:49:24.085136',
        '2024-01-20 10:49:24.085136', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('408a00fd-0aca-4022-811e-92c17d3b9120', '2e5b8298-2f4a-4198-96a8-e7ca4ea9e4bd', '2024-01-20 10:49:24.085136',
        '2024-01-20 10:49:24.085136', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('433b8aa7-cdc6-48d8-8bb1-4178a9dc0066', 'da683523-593b-44e2-b2c6-e2cf3b3c67e1', '2024-01-20 10:49:24.085136',
        '2024-01-20 10:49:24.085136', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('47d1b0b9-fe5f-47b2-b29b-9e6d64f53afb', '0b09f9d3-ab9d-41cf-9925-f5db8b4dbdc6', '2024-01-20 03:03:59.678987',
        '2024-01-20 03:03:59.678987', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('5904bb4e-3807-41ce-ac7a-5da927b462f3', '9ad9c201-21f3-4ed8-8b7c-abc8fc822f21', '2024-01-20 03:03:59.678987',
        '2024-01-20 03:03:59.678987', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('f920afb8-6448-4780-b740-e6feb13e08bb', 'e586dafc-6d41-4206-a279-17664431ef2a', '2024-01-20 03:03:59.678987',
        '2024-01-20 03:03:59.678987', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('e0007aa2-18fa-4b12-9cb1-459c64d9c5aa', 'fe1ef5cd-e878-43fe-b8b3-fd9d99d02835', '2024-01-20 10:49:24.085136',
        '2024-01-20 10:49:24.085136', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('df7cbdf1-2247-4817-84e8-0c1bab22a8ef', 'e586dafc-6d41-4206-a279-17664431ef2a', '2024-01-20 10:49:24.085136',
        '2024-01-20 10:49:24.085136', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('d7a8fb56-a5ff-4189-bab7-c4adf4919603', 'da683523-593b-44e2-b2c6-e2cf3b3c67e1', '2024-01-20 03:03:59.678987',
        '2024-01-20 03:03:59.678987', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('d4700c43-4bfd-4c1a-8997-f89a1033874f', '4cdc40e6-e85e-4470-9458-afd624ee3a7a', '2024-01-20 10:49:24.085136',
        '2024-01-20 10:49:24.085136', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('a13f9564-69a4-4099-b686-4955484555d3', '03f39d58-2adb-45b6-a394-cf75f0ad97f7', '2024-01-20 10:49:24.085136',
        '2024-01-20 10:49:24.085136', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('86ea7d39-7f5a-42c4-85c2-44b59a9afeee', '4cdc40e6-e85e-4470-9458-afd624ee3a7a', '2024-01-20 03:03:59.678987',
        '2024-01-20 03:03:59.678987', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('75038edb-019e-468e-a317-cd163dd11a07', 'da683523-593b-44e2-b2c6-e2cf3b3c67e1', '2024-01-20 03:03:59.678987',
        '2024-01-20 03:03:59.678987', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('735d967d-2016-488e-9126-5fcde71e3ae5', '1b8e063a-a108-47c1-9968-1e1b78bcf022', '2024-01-20 03:03:59.678987',
        '2024-01-20 03:03:59.678987', false);
INSERT INTO ecomerce.category_product (product_id, category_id, created_at, updated_at, deleted)
VALUES ('6dc9b28e-1bad-4af2-a7c6-590fd4766ceb', '2e5b8298-2f4a-4198-96a8-e7ca4ea9e4bd', '2024-01-20 10:49:24.085136',
        '2024-01-20 10:49:24.085136', false);


