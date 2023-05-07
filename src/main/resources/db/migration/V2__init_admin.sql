insert into users (id, username, password, archived, bucket_id)
values (1, 'Almaz', '123', false, null);

insert into requisites
(
    id,
    address,
    email,
    phone,
    user_id
)
values
(
 1,
 'Kazan, Mehovshikov st., 4a, 45',
 'almaz@gmail.com',
 '+79520334110',
 1
);

insert into roles (id, type)
values (1, 'ADMIN');
insert into roles (id, type)
values (2, 'MANAGER');
insert into roles (id, type)
values (3, 'USER');
insert into roles (id, type)
values (4, 'GUEST');

insert into users_roles (user_id, role_id)
values (1, 1);

alter sequence user_sequence restart with 2;
alter sequence role_sequence restart with 5;
