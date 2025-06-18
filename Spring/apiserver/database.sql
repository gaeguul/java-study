DROP TABLE IF EXISTS tbl_board;
CREATE TABLE tbl_board
(
    no          INTEGER AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(200) NOT NULL,
    content     TEXT,
    writer      VARCHAR(50)  NOT NULL,
    reg_date    DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO tbl_board(title, content, writer)
VALUES ('테스트 제목1', '테스트 내용1', 'user00'),
       ('테스트 제목2', '테스트 내용2', 'user00'),
       ('테스트 제목3', '테스트 내용3', 'user00'),
       ('테스트 제목4', '테스트 내용4', 'user00'),
       ('테스트 제목5', '테스트 내용5', 'user00');

SELECT *
FROM tbl_board;


# File Upload
# 첨부파일을 위한 tbl_board_attachment 테이블 생성

DROP TABLE IF EXISTS tbl_board_attachment;

CREATE TABLE tbl_board_attachment
(
    no           INTEGER AUTO_INCREMENT PRIMARY KEY,
    filename     VARCHAR(256) NOT NULL, -- 원본 파일 명
    path         VARCHAR(256) NOT NULL, -- 서버에서의 파일 경로
    content_type VARCHAR(56),           -- content-type
    size         INTEGER,               -- 파일의 크기
    bno          INTEGER      NOT NULL, -- 게시글 번호, FK
    reg_date     DATETIME DEFAULT NOW(),
    CONSTRAINT FOREIGN KEY (bno) REFERENCES tbl_board (no)
);


/* 게시글 조회 + 첨부파일 조회 테스트 */

-- 테스트용 게시글 삽입
INSERT INTO tbl_board (title, content, writer)
VALUES ('첨부 파일 테스트', '첨부파일 테스트 내용', '테스터');

-- 테스트 게시글에 샘플 첨부파일 데이터 삽입
INSERT INTO tbl_board_attachment(filename, path, content_type, size, bno)
VALUES ('cat1.jpg', '/Users/jiham/Desktop/board/cat1-1749870568385.jpg', 'image/jpeg', 283580,
        (SELECT MAX(no) FROM tbl_board)),
       ('cat2.jpg', '/Users/jiham/Desktop/board/cat2-1749870568395.jpg', 'image/jpeg', 166577,
        (SELECT MAX(no) FROM tbl_board)),
       ('cat3.jpg', '/Users/jiham/Desktop/board/cat3-1749870568401.jpg', 'image/jpeg', 119049,
        (SELECT MAX(no) FROM tbl_board)),
       ('cat4.jpg', '/Users/jiham/Desktop/board/cat4-1749870568407.jpg', 'image/jpeg', 193510,
        (SELECT MAX(no) FROM tbl_board)),
       ('cat5.jpg', '/Users/jiham/Desktop/board/cat5-1749870568412.jpg', 'image/jpeg', 186751,
        (SELECT MAX(no) FROM tbl_board));


-- 게시글과 첨부파일을 조인하여 조회
SELECT b.*,
       a.no       AS ano,
       a.bno,
       a.filename,
       a.path,
       a.content_type,
       a.size,
       a.reg_date AS a_reg_date
FROM tbl_board b
         LEFT OUTER JOIN tbl_board_attachment a ON b.no = a.bno
WHERE b.no = (SELECT MAX(no) FROM tbl_board)
ORDER BY filename;