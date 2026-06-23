-- ユーザーとDBの作成
CREATE USER 'springuser'@'%' IDENTIFIED BY 'p@ss';
create database springdb default character set utf8mb4 collate utf8mb4_general_ci;
grant all on springdb.* to 'springuser'@'%';
FLUSH PRIVILEGES;

-- -- データベースを選択
-- USE company;

-- -- データベース作成
-- create table shain (
--     id int primary key,
--     name varchar(20),
--     sei varchar(4),
--     nen int,
--     address varchar(30)
-- );

-- -- データ作成
-- insert into shain (id, name, sei, nen, address) values
-- (100, '山田太郎', '男', 2002, '東京都世田谷区'),
-- (101, '鈴木義信', '男', 2003, '宮城県仙台市'),
-- (102, '佐藤香織', '女', 2004, '福岡県福岡市'),
-- (103, '高橋正美', '女', 2005, '福岡県福岡市'),
-- (104, '佐藤隆一', '男', 2003, '宮城県仙台市'),
-- (105, '小林誠二', '男', 2002, '東京都江東区');