-- Include table data insertion, updation, deletion and select scripts
-----------------------------------------------------------------------
-- Adding Menu Items in Menu Item Table
-----------------------------------------------------------------------


INSERT INTO menu_item
VALUES
(1, 'Sandwich', 99.0, 'Yes', '2017-03-10','Main Course', 'Yes'),
(2, 'Burger', 129.0, 'Yes', '2017-12-23','Main Course', 'No'),
(3, 'Pizza', 149.0, 'Yes', '2018-08-21', 'Main Course', 'No'),
(4, 'French Fries', 57.0, 'No','2017-07-02','Starters', 'Yes'),
(5, 'Chocolate Browine', 57.0, 'Yes','2022-11-02','Dessert', 'Yes');


-----------------------------------------------------------------------
-- Edit Menu Item Table
-----------------------------------------------------------------------
update menu_item 
set me_name='Noodles',me_category='Chinees',me_free_delivery='No'
where me_id=1;


-----------------------------------------------------------------------
-- Displaying Customer List in Menu Item Table
-----------------------------------------------------------------------
select me_name,me_free_delivery,me_price,me_category
from menu_item
where me_active='Yes' and me_date_of_launch <= current_date();


-----------------------------------------------------------------------
-- Setting User Name and Id
-----------------------------------------------------------------------
INSERT INTO user
VALUES
(1,'Raksha'),
(2,'Dora');


-----------------------------------------------------------------------
-- Add To Cart
-----------------------------------------------------------------------
INSERT INTO cart(ct_us_id,ct_pr_id)
VALUES
(2,2),
(1,4),
(2,1),
(1,1),
(2,5);


-----------------------------------------------------------------------
-- Show Cart Items
-----------------------------------------------------------------------
SELECT me_name,me_free_delivery,me_price
FROM menu_item
INNER JOIN cart
ON ct_pr_id=me_id
WHERE ct_us_id=2;


-----------------------------------------------------------------------
-- Total Price of Cart Items
-----------------------------------------------------------------------
SELECT SUM(me_price) AS total
FROM menu_item
INNER JOIN cart
ON ct_pr_id=me_id
WHERE ct_us_id=2;


-----------------------------------------------------------------------
-- Delete from Cart
-----------------------------------------------------------------------
DELETE FROM cart
WHERE ct_us_id=1
AND ct_pr_id=4
LIMIT 1;


-----------------------------------------------------------------------
-- View Delete Cart Items
-----------------------------------------------------------------------
SELECT me_name,me_free_delivery,me_price
FROM menu_item
INNER JOIN cart
On ct_pr_id=me_id
WHERE ct_us_id=2;


-----------------------------------------------------------------------
-- Total Price of Cart Items
-----------------------------------------------------------------------
SELECT SUM(me_price) AS total
FROM menu_item
INNER JOIN cart
ON ct_pr_id=me_id
WHERE ct_us_id=2;


