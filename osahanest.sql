create database osahaneat;
use osahaneat;

create table roles (
	id int not null primary key auto_increment,
    role_name varchar(50),
    created_date timestamp
);

create table users (
	id int not null primary key auto_increment,
    username varchar(50),
    password varchar(50),
    fullname varchar(50),
    created_date timestamp,
    role_id int
);

create table category (
	id int not null primary key auto_increment,
    name_cate varchar(100),
    created_date timestamp
);

create table rating_food (
	id int not null primary key auto_increment,
    user_id int,
    food_id int,
    content text,
    rate_point int(5)
);

create table food (
	id int not null primary key auto_increment,
    title varchar(255),
    image text,
    time_ship varchar(10),
    price decimal,
    cate_id int
);

create table rating_restaurant (
	id int not null primary key auto_increment,
    user_id int,
    res_id int,
    content text,
    rate_point int(5)
);

create table orders (
	id int not null primary key auto_increment,
    user_id int,
    res_id int,
    created_date timestamp
);

create table menu_restaurant (
	cate_id int, 
    res_id int,
    created_date timestamp,
    
    primary key (cate_id, res_id)
);

create table restaurant(
	id int not null primary key auto_increment,
    title varchar(255),
    subtitle varchar(255),
    description text,
    image text,
    is_freeship boolean,
    address varchar(255),
    open_date timestamp
);

create table promo (
	id int not null primary key auto_increment,
    res_id int,
    percent int,
    start_date timestamp,
    end_date timestamp
);

create table order_item (
	order_id int,
    food_id int,
    created_date timestamp,
    primary key (order_id, food_id)
);

alter table users modify column password varchar(255);
alter table food add column is_freeship boolean default false;

alter table users add constraint fk_users_roles foreign key (role_id) references roles(id);
alter table rating_food add constraint fk_ratingfood_users foreign key (user_id) references users(id);
alter table rating_food add constraint fk_ratingfood_food foreign key (food_id) references food(id);
alter table food add constraint fk_food_cate foreign key (cate_id) references category(id);
alter table rating_restaurant add constraint fk_raterestaurant_users foreign key (user_id) references users(id);
alter table rating_restaurant add constraint fk_raterestaurant_res foreign key (res_id) references restaurant(id);
alter table orders add constraint fk_orders_users foreign key (user_id) references users(id);
alter table orders add constraint fk_orders_res foreign key (res_id) references restaurant(id);
alter table order_item add constraint fk_orderitem_orders foreign key (order_id) references orders(id); 
alter table order_item add constraint fk_orderitem_food foreign key (food_id) references food(id);
alter table menu_restaurant add constraint fk_menurestaurant_cate foreign key (cate_id) references category(id);  
alter table menu_restaurant add constraint fk_menurestaurant_res foreign key (res_id) references restaurant(id);  
alter table promo add constraint fk_promo_res foreign key (res_id) references restaurant(id);  

alter table food add column description text;


insert into roles(role_name) value ('ROLE_ADMIN');
insert into roles(role_name) value ('ROLE_USER');

insert into users(username, password, fullname, role_id) values ('duy','1', 'Nguyen Manh Duy', 1);
insert into users(username, password, fullname, role_id) values ('dung','1', 'Nguyen Van A', 2);
insert into users(username, password, fullname, role_id) values ('tra','1', 'Nguyen Van B', 2);
insert into users(username, password, fullname, role_id) values ('na','1', 'Nguyen Van C', 2);

insert into category(name_cate) value ('Burger');
insert into category(name_cate) value ('Pizza');
insert into category(name_cate) value ('Sandwich');
