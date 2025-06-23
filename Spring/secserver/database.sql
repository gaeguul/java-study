-- 사용자 정보 테이블
DROP TABLE IF EXISTS tbl_member;
CREATE TABLE tbl_member
(
    username    VARCHAR(50) PRIMARY KEY, -- 사용자 id
    password    VARCHAR(128) NOT NULL,   -- 암호화된 비밀번호
    email       VARCHAR(50)  NOT NULL,
    reg_date    DATETIME DEFAULT NOW(),
    update_date DATETIME DEFAULT NOW()
);

-- 사용자 권한 테이블
DROP TABLE IF EXISTS tbl_member_auth;
CREATE TABLE tbl_member_auth
(
    username VARCHAR(50) NOT NULL, -- 사용자 id
    auth     VARCHAR(50) NOT NULL,
    PRIMARY KEY (username, auth),  -- 복합키
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES tbl_member (username)
);

-- 테스트 사용자 추가
INSERT INTO tbl_member(username, password, email)
VALUES ('admin', '$2a$10$Ne4Qq8/9Th5DPvc3nWptfeLcc.dCsxxyfPlsvJ8O8UA1YcYC5N7d2', 'admin@galapgos.org'),
       ('user0', '$2a$10$Ne4Qq8/9Th5DPvc3nWptfeLcc.dCsxxyfPlsvJ8O8UA1YcYC5N7d2', 'user0@galapgos.org'),
       ('user1', '$2a$10$Ne4Qq8/9Th5DPvc3nWptfeLcc.dCsxxyfPlsvJ8O8UA1YcYC5N7d2', 'user1@galapgos.org'),
       ('user2', '$2a$10$Ne4Qq8/9Th5DPvc3nWptfeLcc.dCsxxyfPlsvJ8O8UA1YcYC5N7d2', 'user2@galapgos.org'),
       ('user3', '$2a$10$Ne4Qq8/9Th5DPvc3nWptfeLcc.dCsxxyfPlsvJ8O8UA1YcYC5N7d2', 'user3@galapgos.org'),
       ('user4', '$2a$10$Ne4Qq8/9Th5DPvc3nWptfeLcc.dCsxxyfPlsvJ8O8UA1YcYC5N7d2', 'user4@galapgos.org');
SELECT *
FROM tbl_member;

INSERT INTO tbl_member_auth(username, auth)
VALUES ('admin', 'ROLE_ADMIN'),
       ('admin', 'ROLE_MANAGER'),
       ('admin', 'ROLE_MEMBER'),
       ('user0', 'ROLE_MANAGER'),
       ('user0', 'ROLE_MEMBER'),
       ('user1', 'ROLE_MEMBER'),
       ('user2', 'ROLE_MEMBER'),
       ('user3', 'ROLE_MEMBER'),
       ('user4', 'ROLE_MEMBER');
SELECT *
FROM tbl_member_auth
ORDER BY auth;