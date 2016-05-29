/* Generating data for database: postgres  */

/* Table public.users cleared */
DELETE FROM "public"."users";
COMMIT;

/* Table public.user_roles cleared */
DELETE FROM "public"."user_roles";

/* Table public.posts cleared */
DELETE FROM "public"."posts";
COMMIT;

/* Table public.tags cleared */
DELETE FROM "public"."tags";
COMMIT;

/* Generating data for table public.tags... */
INSERT INTO "public"."tags"("title")
VALUES( E'lorem');
INSERT INTO "public"."tags"("title")
VALUES( E'ipsum');
COMMIT;


/* Generating data for table public.users... */
INSERT INTO "public"."users"("first_name","last_name","e_mail","password", "is_active")
VALUES(E'Elżbieta',E'Wojciechowski',E'admin@blog.com',E'$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C',TRUE);
INSERT INTO "public"."users"("first_name","last_name","e_mail","password", "is_active")
VALUES(E'Ewa',E'Nowak',E'user1@test.com',E'$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C',TRUE);
INSERT INTO "public"."users"("first_name","last_name","e_mail","password", "is_active")
VALUES(E'Zofia',E'Kwiatkowski',E'zafia@test.com',E'$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C',TRUE);
INSERT INTO "public"."users"("first_name","last_name","e_mail","password", "is_active")
VALUES(E'Katarzyna',E'Wiśniewski',E'kasia@test.com',E'$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C',TRUE);
INSERT INTO "public"."users"("first_name","last_name","e_mail","password", "is_active")
VALUES(E'Agnieszka',E'Kowalski',E'aga.testowy@test.com',E'$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C',TRUE);
INSERT INTO "public"."users"("first_name","last_name","e_mail","password", "is_active")
VALUES(E'Janina',E'Wójcik',E'janina@test.com',E'$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C',TRUE);
INSERT INTO "public"."users"("first_name","last_name","e_mail","password", "is_active")
VALUES(E'Barbara',E'Dąbrowski',E'barbara.testowy@test.com',E'$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C',TRUE);
INSERT INTO "public"."users"("first_name","last_name","e_mail","password", "is_active")
VALUES(E'Monika',E'Woźniak',E'monika.testowy@test.com',E'$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C',TRUE);
INSERT INTO "public"."users"("first_name","last_name","e_mail","password", "is_active")
VALUES(E'Krystyna',E'Zieliński',E'krycha@test.com',E'$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C',TRUE);
INSERT INTO "public"."users"("first_name","last_name","e_mail","password", "is_active")
VALUES(E'Anna',E'Kamiński',E'anna@test.com',E'$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C',TRUE);
INSERT INTO "public"."users"("first_name","last_name","e_mail","password", "is_active")
VALUES(E'Małgorzata',E'Kowalczyk',E'malgosia@test.com',E'$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C',TRUE);
INSERT INTO "public"."users"("first_name","last_name","e_mail","password", "is_active")
VALUES(E'Magdalena',E'Lewandowski',E'magdalena.testowy@test.com',E'$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C',TRUE);
INSERT INTO "public"."users"("first_name","last_name","e_mail","password", "is_active")
VALUES(E'Maria',E'Jankowski',E'maria@test.com',E'$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C',TRUE);
INSERT INTO "public"."users"("first_name","last_name","e_mail","password", "is_active")
VALUES(E'Joanna',E'Kozłowski',E'joanna@test.com',E'$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C',TRUE);
INSERT INTO "public"."users"("first_name","last_name","e_mail","password", "is_active")
VALUES(E'Teresa',E'Szymański',E'terenia.testowy@test.com',E'$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C',TRUE);
COMMIT;

/* Generating data for table public.user_roles... */
INSERT INTO "public"."user_roles"("users_id_user","role")
VALUES(1, E'ADMIN');
INSERT INTO "public"."user_roles"("users_id_user","role")
VALUES(1, E'USER');
INSERT INTO "public"."user_roles"("users_id_user","role")
VALUES(2, E'USER');
INSERT INTO "public"."user_roles"("users_id_user","role")
VALUES(3, E'USER');
INSERT INTO "public"."user_roles"("users_id_user","role")
VALUES(4, E'USER');
INSERT INTO "public"."user_roles"("users_id_user","role")
VALUES(5, E'USER');
INSERT INTO "public"."user_roles"("users_id_user","role")
VALUES(6, E'USER');
INSERT INTO "public"."user_roles"("users_id_user","role")
VALUES(7, E'USER');
INSERT INTO "public"."user_roles"("users_id_user","role")
VALUES(8, E'USER');
INSERT INTO "public"."user_roles"("users_id_user","role")
VALUES(9, E'USER');
INSERT INTO "public"."user_roles"("users_id_user","role")
VALUES(10, E'USER');
INSERT INTO "public"."user_roles"("users_id_user","role")
VALUES(11, E'USER');
INSERT INTO "public"."user_roles"("users_id_user","role")
VALUES(12, E'USER');
INSERT INTO "public"."user_roles"("users_id_user","role")
VALUES(13, E'USER');
INSERT INTO "public"."user_roles"("users_id_user","role")
VALUES(14, E'USER');
INSERT INTO "public"."user_roles"("users_id_user","role")
VALUES(15, E'USER');
COMMIT;

INSERT INTO "public"."posts"("post_date","post_title","post_content","users_id_user", "is_deleted")
VALUES('2016-05-24 15:00:00.000000',E'Pellentesque eu interdum quam.',E'Pellentesque eu interdum quam. Aenean dapibus feugiat ligula ut feugiat. Aliquam ullamcorper ullamcorper sapien, a pretium quam lobortis id. Nulla nec erat eget sem ullamcorper vulputate at nec urna. Curabitur sit amet ligula quis nibh egestas vulputate in sed dui. Phasellus eu risus ut eros iaculis maximus a quis nunc. Mauris turpis metus, auctor quis fringilla ac, consectetur ut ipsum. Mauris bibendum venenatis felis ut imperdiet. Curabitur sodales, ligula sit amet vulputate luctus, ligula tellus suscipit mauris, id pulvinar justo neque eget lacus. In eget placerat neque, non posuere ante. Quisque euismod. ',2,FALSE);
INSERT INTO "public"."posts"("post_date","post_title","post_content","users_id_user", "is_deleted")
VALUES('2016-05-24 16:00:00.000000',E'Interdum et malesuada fames',E'Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla fringilla velit in leo tempus dapibus. Suspendisse dapibus laoreet orci ut finibus. Mauris sem dui, malesuada quis enim nec, semper porta eros. Integer ac ex eu tortor accumsan vehicula a nec ligula. Nulla facilisi. Nulla eros tellus, pharetra quis sagittis quis, gravida nec orci. Sed pellentesque nisi id dapibus placerat. Morbi volutpat dolor quis porttitor semper. Donec auctor elit non enim finibus, id rhoncus nisi vulputate. Suspendisse consectetur pharetra neque a gravida. Pellentesque efficitur congue nisi et lacinia. Donec non ex sit amet erat euismod pulvinar dictum ac velit. ',2,FALSE);
INSERT INTO "public"."posts"("post_date","post_title","post_content","users_id_user", "is_deleted")
VALUES('2016-05-24 17:00:00.000000',E'Mauris mattis ac lorem sit amet porttitor',E'Mauris mattis ac lorem sit amet porttitor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Morbi eleifend dignissim mi, ac blandit est. Nunc lobortis sit amet tortor a molestie. Donec volutpat faucibus porta. Praesent egestas neque et ultrices molestie. Maecenas sed ipsum placerat, luctus felis et, facilisis lectus. Donec at diam at nunc ornare semper. Nunc feugiat turpis velit, sed volutpat ante ultrices at. Donec pharetra nec ante non viverra. Cras sit amet nunc at tellus finibus ultrices eu eget quam. Nunc nec nisl in mauris maximus bibendum vitae sit amet augue. Nulla in ipsum. ',2,FALSE);
INSERT INTO "public"."posts"("post_date","post_title","post_content","users_id_user", "is_deleted")
VALUES('2016-05-24 18:00:00.000000',E'Praesent consectetur fermentum leo',E'Praesent consectetur fermentum leo, sed lacinia sapien viverra in. Nulla luctus sem vel dolor ultrices, vel rutrum lectus rutrum. Donec lacinia tortor odio. Quisque iaculis urna eu libero hendrerit bibendum. Integer id sagittis nisl. Etiam accumsan urna elementum, laoreet ex eget, luctus diam. Vestibulum dapibus eu enim at pellentesque. Mauris porttitor ultrices elit, non suscipit est pellentesque eget. Maecenas eleifend magna id interdum mattis. Morbi ultrices erat suscipit quam sodales, in auctor arcu accumsan. Phasellus sollicitudin hendrerit leo eget egestas. Praesent mollis velit at ex sagittis egestas. Vestibulum vel pulvinar tellus. Proin eu placerat est, cursus suscipit risus. Nunc molestie.',2,FALSE);
INSERT INTO "public"."posts"("post_date","post_title","post_content","users_id_user", "is_deleted")
VALUES('2016-05-24 19:00:00.000000',E'Integer volutpat nunc',E'Integer volutpat nunc sit amet iaculis maximus. Fusce tempor mattis est, et vestibulum justo suscipit eu. Curabitur eros nulla, suscipit rhoncus sapien eget, fermentum tempor augue. Mauris feugiat lorem nisi, ut tristique neque sagittis in. Ut scelerisque condimentum dictum. Nulla efficitur diam ut imperdiet ultrices. Suspendisse vitae arcu lobortis, euismod mauris non, egestas est. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras risus risus, consectetur eget sagittis at, scelerisque et elit. Curabitur lorem augue, luctus non blandit eget, dictum vitae nunc. Nam sem ante, tristique et felis sed, efficitur pharetra elit. Quisque eget pulvinar sapien, a tristique nibh. Pellentesque. ',2,FALSE);
INSERT INTO "public"."posts"("post_date","post_title","post_content","users_id_user", "is_deleted")
VALUES('2016-05-24 20:00:00.000000',E'Vestibulum ante ipsum',E'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Praesent sit amet ligula viverra, pellentesque est eu, iaculis magna. Nam vel blandit lorem, id aliquam justo. Fusce placerat purus urna, ut sollicitudin turpis tincidunt eu. Sed arcu lorem, maximus et ante bibendum, dictum mattis nisl. Nunc tristique tincidunt enim eu cursus. Pellentesque rutrum justo vel erat sagittis, id imperdiet diam volutpat.  ',2,FALSE);


INSERT INTO "public"."posts_tags"("id_tags","id_post")
VALUES(1, 1);
INSERT INTO "public"."posts_tags"("id_tags","id_post")
VALUES(2, 1);
INSERT INTO "public"."posts_tags"("id_tags","id_post")
VALUES(1, 2);
INSERT INTO "public"."posts_tags"("id_tags","id_post")
VALUES(1, 3);
INSERT INTO "public"."posts_tags"("id_tags","id_post")
VALUES(1, 4);
INSERT INTO "public"."posts_tags"("id_tags","id_post")
VALUES(1, 5);
INSERT INTO "public"."posts_tags"("id_tags","id_post")
VALUES(1, 6);