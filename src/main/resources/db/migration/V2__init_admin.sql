insert into users (id,
                   name,
                   surname,
                   username,
                   password,
                   archived,
                   bucket_id)
values ('38ef1a06-8a92-4b31-97ab-5e7f1fd4c900',
        'Almaz',
        'Zalyalov',
        'Almaz',
        '$2a$12$kMs5utM4CdBUXxb8yPMEwu5uafHbqDr70mDF2jf3YdUdPNBhtHw5O',
        false,
        null);

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
 '38ef1a06-8a92-4b31-97ab-5e7f1fd4c900'
);

insert into roles (id, authority)
values (1, 'ADMIN');
insert into roles (id, authority)
values (2, 'MANAGER');
insert into roles (id, authority)
values (3, 'USER');
insert into roles (id, authority)
values (4, 'GUEST');

insert into users_roles (user_id, role_id)
values ('38ef1a06-8a92-4b31-97ab-5e7f1fd4c900', 1);

alter sequence role_sequence restart with 5;
alter sequence requisite_sequence restart with 2;
