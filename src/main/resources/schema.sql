-- テーブルが存在したら削除する
DROP TABLE IF EXISTS todos;
DROP TABLE IF EXISTS authentications;
--DROP TABLE IF EXISTS role;

-- テーブルの作成
CREATE TABLE todos (
	-- id（することID）：主キー
    id SERIAL PRIMARY KEY,
    -- todo（すること）：NULL不許可
    todo VARCHAR(255) NOT NULL,
    -- detail（説明）
    detail TEXT,
    -- created_at（作成日）
    created_at TIMESTAMP,
    -- updated_at（更新日）
    updated_at TIMESTAMP
    --mysqlでは標準でタイムゾーンなし
	--postgreSQLの場合
	---- created_at（作成日）
	--    created_at timestamp without time zone,
	--    -- updated_at（更新日）
	--    updated_at timestamp without time zone
);

-- 権限用のENUM型,mysqlでは型の生成が不可
--CREATE TYPE role AS ENUM ('ADMIN', 'USER');


CREATE TABLE authentications (
	-- ユーザー名：主キー
	username VARCHAR(50) PRIMARY KEY,
	-- パスワード
	password VARCHAR(255) NOT NULL,
	-- 権限
	authority ENUM('ADMIN', 'USER') NOT NULL, 
	-- 表示名
	displayname VARCHAR(50) NOT NULL
);

