use qldrl;



-- CREATE TABLE chuyen_vien_ctsv (
--     id INT AUTO_INCREMENT PRIMARY KEY
-- );




-- CREATE TABLE dieu (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     dieu INT NOT NULL,
--     diem_toi_da INT NOT NULL
-- );



-- CREATE TABLE hoc_ki (
--     id INT PRIMARY KEY,
--     hoc_ki VARCHAR(10) NOT NULL
-- );

-- CREATE TABLE nam_hoc (
--     id INT PRIMARY KEY,
--     nam_hoc INT NOT NULL
-- );

-- CREATE TABLE hoc_ki_nam_hoc (
--     id INT PRIMARY KEY  AUTO_INCREMENT,
--     hoc_ki_id INT,
--     nam_hoc_id INT,
--     FOREIGN KEY (hoc_ki_id) REFERENCES hoc_ki(id),
--     FOREIGN KEY (nam_hoc_id) REFERENCES nam_hoc(id)
-- );

-- CREATE TABLE khoa (
--     id INT PRIMARY KEY AUTO_INCREMENT,
--     ten VARCHAR(45)
-- );

-- CREATE TABLE lop (
--     id INT PRIMARY KEY AUTO_INCREMENT,
--     ten VARCHAR(45),
--     khoa_id INT,
--     FOREIGN KEY (khoa_id) REFERENCES khoa(id)
-- );



-- C-- REATE TABLE nguoi_dung (
--     id INT PRIMARY KEY AUTO_INCREMENT,
--     ho VARCHAR(45),
--     ten VARCHAR(45),
--     nam_sinh DATETIME,
--     gioi_tinh SMALLINT,
--     avatar VARCHAR(205),
--     email VARCHAR(45),
--     password VARCHAR(45)
-- );

-- CREATE TABLE sinh_vien (
--     id INT PRIMARY KEY AUTO_INCREMENT,
--     lop_id INT NOT NULL,
--     nam_hoc_id INT NOT NULL,
--     FOREIGN KEY (lop_id) REFERENCES lop(id),
--     FOREIGN KEY (nam_hoc_id) REFERENCES nam_hoc(id)
-- );

-- CREATE TABLE tro_ly_sinh_vien (
--     id INT PRIMARY KEY AUTO_INCREMENT,
--     khoa_id INT,
--     FOREIGN KEY (khoa_id) REFERENCES khoa(id)
-- );

-- CREATE TABLE hoat_dong (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     ten VARCHAR(200),
--     mo_ta VARCHAR(400),
--     diem INT NOT NULL,
--     dieu_id INT,
--     hoc_ki_nam_hoc_id INT,
--     khoa_id INT,
--     tro_ly_id INT,
--     FOREIGN KEY (dieu_id) REFERENCES dieu(id),
--     FOREIGN KEY (hoc_ki_nam_hoc_id) REFERENCES hoc_ki_nam_hoc(id),
--     FOREIGN KEY (khoa_id) REFERENCES khoa(id),
--     FOREIGN KEY (tro_ly_id) REFERENCES tro_ly_sinh_vien(id)
-- );
-- CREATE TABLE sinh_vien_hoat_dong (
--     id INT PRIMARY KEY AUTO_INCREMENT,
--     trang_thai BOOLEAN,
--     hoat_dong_id INT,
--     sinh_vien_id INT,
--     FOREIGN KEY (hoat_dong_id) REFERENCES hoat_dong(id),
--     FOREIGN KEY (sinh_vien_id) REFERENCES sinh_vien(id)
-- );


-- CREATE TABLE bai_viet (
--     id INT PRIMARY KEY,
--     ten VARCHAR(45),
--     ngay_tao TIMESTAMP,
--     noi_dung VARCHAR(105),
--     hoat_dong_id INT,
--     FOREIGN KEY (hoat_dong_id) REFERENCES hoat_dong(id)
-- );
-- CREATE TABLE comment (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     noi_dung VARCHAR(105),
--     thoi_gian TIMESTAMP,
--     bai_viet_id INT,
--     comment_id INT,
--     nguoi_dung_id INT,
--     FOREIGN KEY (bai_viet_id) REFERENCES bai_viet(id),
--     FOREIGN KEY (comment_id) REFERENCES comment(id),
--     FOREIGN KEY (nguoi_dung_id) REFERENCES nguoi_dung(id)
-- );




-- Thêm một hàng mới vào bảng chuyen_vien_ctsv
-- INSERT INTO chuyen_vien_ctsv (id) VALUES (NULL);


-- Thêm dữ liệu vào bảng khoa
-- INSERT INTO khoa (ten) VALUES ('Khoa Công nghệ thông tin'), ('Khoa Kinh tế'), ('Khoa Ngoại ngữ');

-- Thêm dữ liệu vào bảng lop
-- INSERT INTO lop (ten, khoa_id) VALUES 
--     ('IT03', 1),
--     ('IT02', 1),
--     ('IT03', 1),
--     ('CS01', 1),
--     ('CS02', 1),
--     ('CS03', 1);

-- -- Thêm dữ liệu vào bảng nam_hoc
-- INSERT INTO nam_hoc (id, nam_hoc) VALUES 
--     (2021, 2021),
--     (2022, 2022),
--     (2023, 2023);

-- Thêm dữ liệu vào bảng nguoi_dung
-- INSERT INTO nguoi_dung (ho, ten, nam_sinh, gioi_tinh, avatar, email, password) VALUES 
--     ('Nguyễn', 'Văn A', '1995-05-15', 1, 'avatar1.jpg', 'vana@gmail.com', 'password1'),
--     ('Trần', 'Thị B', '1998-08-20', 0, 'avatar2.jpg', 'thib@gmail.com', 'password2'),
--     ('Lê', 'Đức C', '1997-12-10', 1, 'avatar3.jpg', 'ducc@gmail.com', 'password3');

-- Thêm dữ liệu vào bảng hoc_ki
-- INSERT INTO hoc_ki (id, hoc_ki) VALUES (3, 'Học kì 3');




-- Thêm dữ liệu vào bảng hoc_ki_nam_hoc
-- INSERT INTO hoc_ki_nam_hoc (hoc_ki_id, nam_hoc_id) VALUES 
--     (1, 2021),
--     (2, 2021),
--     (1, 2022),
--     (2, 2022),
--     (1, 2023),
--     (2, 2023);

-- Thêm dữ liệu vào bảng dieu
-- INSERT INTO dieu (dieu, diem_toi_da) VALUES 
--     (1, 5),
--     (2, 15),
--     (3, 20),
--     (4, 10);

-- INSERT INTO tro_ly_sinh_vien (khoa_id) VALUES 
--     (1),
--     (2),
--     (3);

-- Thêm dữ liệu vào bảng hoat_dong
-- INSERT INTO hoat_dong (ten, mo_ta, diem, dieu_id, hoc_ki_nam_hoc_id, khoa_id, tro_ly_id) VALUES 
--     ('Hoạt động 1', 'Mô tả hoạt động 1', 5, 1, 1, 1, 1),
--     ('Hoạt động 2', 'Mô tả hoạt động 2', 10, 2, 1, 1, 2),
--     ('Hoạt động 3', 'Mô tả hoạt động 3', 5, 3, 1, 2, 1),
--     ('Hoạt động 4', 'Mô tả hoạt động 4', 5, 1, 2, 2, 2);




-- Thêm dữ liệu vào bảng sinh_vien
-- INSERT INTO sinh_vien (lop_id, nam_hoc_id) VALUES 
--     (1, 2021),
--     (2, 2021),
--     (3, 2022,
-- 		(4, 2021);


-- Thêm dữ liệu vào bảng sinh_vien_hoat_dong
-- INSERT INTO sinh_vien_hoat_dong (trang_thai, hoat_dong_id, sinh_vien_id) VALUES 
--     (TRUE, 1, 1),
--     (TRUE, 2, 2),
--     (TRUE, 3, 3),
--     (FALSE, 4, 4);

-- Insert data into bai_viet
INSERT INTO bai_viet (id, ten, ngay_tao, noi_dung, hoat_dong_id) VALUES (1, 'Post 1', NOW(), 'Content 1', 1), (2, 'Post 2', NOW(), 'Content 2', 2);

-- Insert data into comment
INSERT INTO comment (noi_dung, thoi_gian, bai_viet_id, comment_id, nguoi_dung_id) VALUES
('Comment 1', NOW(), 1, NULL, 1),
('Reply to Comment 1', NOW(), 1, 1, 2);



