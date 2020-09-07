insert into course (id_code_course, name) values ('0001', 'Math');
insert into course (id_code_course, name) values ('0002', 'History and geography');
insert into course (id_code_course, name) values ('0003', 'English');
insert into course (id_code_course, name) values ('0004', 'Biology');
insert into course (id_code_course, name) values ('0005', 'Chemistry');


insert into student (id_rut_student, name, last_name, age, code_course_id) values (6509330, 'Pablo', 'Escobar', 28, '0001');
insert into student (id_rut_student, name, last_name, age, code_course_id) values (11800819, 'Mario', 'Bros', 32, '0002');
insert into student (id_rut_student, name, last_name, age, code_course_id) values (16888413, 'Matias', 'Soto', 32, null);


INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO users (username, password, enabled, name, lastname, email) VALUES ('matias1','$2a$10$2pvKQmdlc6tF084.RXWU1uV43iaugZT7LgrTKhNAlPJyaYRmHosla',true, 'Matias E', 'Matias R','matias.sotomayor2@gmail.com');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);