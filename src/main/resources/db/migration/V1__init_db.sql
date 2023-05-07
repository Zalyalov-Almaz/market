create sequence bucket_details_sequence start with 1 increment by 1;
create sequence bucket_sequence start with 1 increment by 1;
create sequence category_sequence start with 1 increment by 1;
create sequence order_details_sequence start with 1 increment by 1;
create sequence order_sequence start with 1 increment by 1;
create sequence product_sequence start with 1 increment by 1;
create sequence requisite_sequence start with 1 increment by 1;
create sequence role_sequence start with 1 increment by 1;
create sequence user_sequence start with 1 increment by 1;

create table bucket_details
(
    id bigint not null,
    amount numeric(38,2),
    comment varchar(255),
    price numeric(38,2),
    sum numeric(38,2),
    bucket_id bigint,
    product_id bigint,
    primary key (id)
);
create table buckets
(
    id bigint not null,
    user_id bigint,
    primary key (id)
);
create table buckets_products
(
    bucket_id bigint not null,
    bucket_detail_id bigint not null
);
create table orders
(
    id bigint not null,
    address varchar(255),
    created timestamp(6),
    status varchar(255),
    sum numeric(38,2),
    updated timestamp(6),
    user_id bigint,
    primary key (id)
);
create table order_details
(
    id bigint not null,
    amount numeric(38,2),
    comment varchar(255),
    price numeric(38,2),
    order_id bigint,
    product_id bigint,
    primary key (id)
);
create table orders_order_details
(
    order_id bigint not null,
    order_details_id bigint not null
);
create table product_categories
(
    id bigint not null,
    title varchar(255),
    primary key (id)
);
create table products
(
    id bigint not null,
    price numeric(38,2),
    title varchar(255),
    primary key (id)
);
create table products_categories
(
    product_id bigint not null,
    category_id bigint not null
);
create table requisites
(
    id bigint not null,
    address varchar(255),
    email varchar(255),
    phone varchar(255),
    user_id bigint,
    primary key (id)
);
create table roles
(
    id bigint not null,
    type varchar(255),
    primary key (id)
);
create table users
(
    id bigint not null,
    archived boolean not null,
    password varchar(255),
    username varchar(255),
    bucket_id bigint,
    primary key (id)
);
create table users_roles
(
    user_id bigint not null,
    role_id bigint not null,
    primary key (user_id, role_id)
);

alter table if exists orders_order_details add constraint UK_22wlf6q0mc7mkuqp7bvm3dm2d unique (order_details_id);
alter table if exists bucket_details add constraint FK4ypo958wun5y76beqd2linkr4 foreign key (bucket_id) references buckets;
alter table if exists bucket_details add constraint FKrp5tr628upxfjx1ntuosat87t foreign key (product_id) references products;
alter table if exists buckets add constraint FKnl0ltaj67xhydcrfbq8401nvj foreign key (user_id) references users;
alter table if exists buckets_products add constraint FKlgq3osuhxbd5s5a5i1sl5nlnh foreign key (bucket_detail_id) references bucket_details;
alter table if exists buckets_products add constraint FKc49ah45o66gy2f2f4c3os3149 foreign key (bucket_id) references buckets;
alter table if exists order_details add constraint FKjyu2qbqt8gnvno9oe9j2s2ldk foreign key (order_id) references orders;
alter table if exists order_details add constraint FK4q98utpd73imf4yhttm3w0eax foreign key (product_id) references products;
alter table if exists orders add constraint FK32ql8ubntj5uh44ph9659tiih foreign key (user_id) references users;
alter table if exists orders_order_details add constraint FK5tqkl4l12ncaw7q7ua2gc4a3w foreign key (order_details_id) references order_details;
alter table if exists orders_order_details add constraint FK95iwi9c75iprmwbnr63vq4863 foreign key (order_id) references orders;
alter table if exists products_categories add constraint FKhr3n0lga9m53ia9q6739rmvm8 foreign key (category_id) references product_categories;
alter table if exists products_categories add constraint FKtj1vdea8qwerbjqie4xldl1el foreign key (product_id) references products;
alter table if exists requisites add constraint FK8w75nalx21o9ecwkpybi6q0bf foreign key (user_id) references users;
alter table if exists users add constraint FK8l2qc4c6gihjdyoch727guci foreign key (bucket_id) references buckets;
alter table if exists users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles;
alter table if exists users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users;