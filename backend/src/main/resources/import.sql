INSERT INTO tb_user (name, email, password) VALUES ('Alex Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Maria Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO tb_course (name, img_uri, img_gray_uri) VALUES ('Bootcamp HTML', 'https://c.pxhere.com/images/07/b2/f8ed07d6f1a9c740e7703cbb99ee-1443423.jpg!d', 'http://blog.efrontlearning.net/wp-content/uploads/2014/09/efront_pro_beta2.jpg');

INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2020-11-20T03:00:00Z', TIMESTAMP WITH TIME ZONE '2021-11-20T03:00:00Z', 1);
INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) VALUES ('2.0', TIMESTAMP WITH TIME ZONE '2020-12-20T03:00:00Z', TIMESTAMP WITH TIME ZONE '2021-12-20T03:00:00Z', 1);

INSERT INTO tb_resource (title, description, position, img_url, type, offer_id) VALUES ('Trilha HTML', 'Trilha pincipal do curso', 1, 'https://c.pxhere.com/images/07/b2/f8ed07d6f1a9c740e7703cbb99ee-1443423.jpg!d', 1, 1);
INSERT INTO tb_resource (title, description, position, img_url, type, offer_id) VALUES ('Forúm', 'Tire suas dúvidas', 2, 'https://c.pxhere.com/images/07/b2/f8ed07d6f1a9c740e7703cbb99ee-1443423.jpg!d', 2, 1);
INSERT INTO tb_resource (title, description, position, img_url, type, offer_id) VALUES ('Lives', 'Lives exclusivas para a turma', 3, 'https://c.pxhere.com/images/07/b2/f8ed07d6f1a9c740e7703cbb99ee-1443423.jpg!d', 0, 1);

INSERT INTO tb_section (title, description, position, img_url, resource_id, prerequisite_id) VALUES ('Capítulo 1', 'Neste capítulo vamos começar', 1, 'https://c.pxhere.com/images/07/b2/f8ed07d6f1a9c740e7703cbb99ee-1443423.jpg!d', 1, null);
INSERT INTO tb_section (title, description, position, img_url, resource_id, prerequisite_id) VALUES ('Capítulo 2', 'Neste capítulo vamos continuar', 2, 'https://c.pxhere.com/images/07/b2/f8ed07d6f1a9c740e7703cbb99ee-1443423.jpg!d', 1, 1);
INSERT INTO tb_section (title, description, position, img_url, resource_id, prerequisite_id) VALUES ('Capítulo 3', 'Neste capítulo vamos finalizar', 3, 'https://c.pxhere.com/images/07/b2/f8ed07d6f1a9c740e7703cbb99ee-1443423.jpg!d', 1, 2);

INSERT INTO tb_enrollment (enrollment_moment, refund_moment, available, only_update, user_id, offer_id) VALUES ('2020-11-20T13:00:00Z', null, true, false, 1, 1);
INSERT INTO tb_enrollment (enrollment_moment, refund_moment, available, only_update, user_id, offer_id) VALUES ('2020-11-20T13:00:00Z', null, true, false, 2, 1);

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula 1 Capitulo 1', 1, 1);
INSERT INTO tb_content (text_content, video_uri, id) VALUES ('Material de apoio: abc', 'https://www.youtube.com/watch?v=v6dfpWictcE&ab_channel=C%C3%B3digoFonteTV', 1);

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula 2 Capitulo 1', 2, 1);
INSERT INTO tb_content (text_content, video_uri, id) VALUES ('Material de apoio: abc', 'https://www.youtube.com/watch?v=v6dfpWictcE&ab_channel=C%C3%B3digoFonteTV', 2);

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula 3 Capitulo 1', 3, 1);
INSERT INTO tb_content (text_content, video_uri, id) VALUES ('Material de apoio: abc', 'https://www.youtube.com/watch?v=v6dfpWictcE&ab_channel=C%C3%B3digoFonteTV', 3);

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Tarefa do Capítulo 1', 4, 1);
INSERT INTO tb_task (description, question_count, approval_count, weight, due_date, id) VALUES ('Fazer trabalho 1', 5, 4, 1.0, '2020-11-25T13:00:00Z', 4);

INSERT INTO tb_lessons_done (lesson_id, user_id, offer_id) VALUES (1, 1, 1);
INSERT INTO tb_lessons_done (lesson_id, user_id, offer_id) VALUES (2, 1, 1);

INSERT INTO tb_deliver (uri, moment, status, feedback, correct_Count, lesson_id, user_id, offer_id) VALUES ('https://github.com/devsuperior/bds-dslearn', TIMESTAMP WITH TIME ZONE '2020-12-10T10:00:00Z', 0, null, null, 4, 1, 1);




