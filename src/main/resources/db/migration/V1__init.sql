create table users (
  id                    bigserial,
  username              varchar(30) not null unique,
  password              varchar(80) not null,
  phone                 varchar(80) not null unique,
  description           varchar,
  email                 varchar(50) unique,
  is_active             boolean,
  is_verified           boolean,
  primary key (id)
);

create table email_token (
  id                    bigserial,
  token                 varchar(256) not null,
  created_at            date,
  expires_at            date,
  confirmed_at          date,
  user_id               bigserial,
  primary key (id)
);

create table avatar_data (
  id                bigserial,
  user_id           bigserial,
  name              varchar,
  type              varchar,
  file_path         varchar,
  primary key (id)
);

create table file_data (
  id                bigserial,
  order_id          bigserial,
  advert_type       bigserial,
  name              varchar,
  type              varchar,
  file_path         varchar,
  primary key (id)
);

create table advert_technic (
    id                      bigserial,
    owner_id                bigserial,
    advert_type             bigserial,
    transaction_type        bigserial,
    technic_type            varchar,
    technic_mark            varchar,
    technic_model           varchar,
    shift_type              bigserial,
    title                   varchar,
    unit_amount             bigserial,
    rental_from             date,
    rental_to               date,
    rental_days             bigserial,
    address_lat             bigserial,
    address_lon             bigserial,
    production_year         bigserial,
    weight                  bigserial,
    height                  bigserial,
    volume                  bigserial,
    passengers_count        bigserial,
    pipe_length             bigserial,
    boom_length             bigserial,
    lifting_capacity        bigserial,
    performance             bigserial,
    cargo_type              varchar,
    roller_type             bigserial,
    roller_count            bigserial,
    size_type               bigserial,
    ossig                   boolean,
    axes_count              bigserial,
    body_length             bigserial,
    trailer_type            bigserial,
    loading_type            bigserial,
    second_lat              bigserial,
    second_lon              bigserial,
    distance                bigserial,
    is_transport            boolean,
    price                   bigserial,
    payment_type            bigserial,
    payment_unit            bigserial,
    advert_status           bigserial,
    is_verified             boolean,
    is_banned               boolean,
    created_at              date,
    updated_at              date,
    primary key (id)
);

create table app_like (
    id                      bigserial,
    user_id                 bigserial,
    advert_type             bigserial,
    advert_id               bigserial,
    created_at              DATE,
    primary key (id)
);


create table roles (
  id                    bigserial,
  name                  varchar(50) not null,
  primary key (id)
);

CREATE TABLE users_roles (
  user_id               bigserial not null,
  role_id               int not null,
  primary key (user_id, role_id),
  foreign key (user_id) references users (id),
  foreign key (role_id) references roles (id)
);

create table adverts_mini (
  id                            bigserial,
  advert_type                   bigserial,
  transaction_type              bigserial,
  title                         varchar,
  author_id                     bigserial,
  advert_id                     bigserial,
  updated_at                    DATE,
  created_at                    DATE,
  is_active                     boolean,
  is_banned                     boolean,
  primary key (id)
);

create table technic_class_lib (
    id                          bigserial,
    name                        varchar,
    primary key (id)
);

create table technic_parameter_lib (
    id                          bigserial,
    name                        varchar,
    primary key (id)
);

create table equipment_lib (
  id                            bigserial,
  name                          varchar,
  primary key (id)
);

create table technics_parameters_lib(
    technic_id                  bigserial,
    parameter_id                bigserial,
    primary key (technic_id, parameter_id),
    foreign key (technic_id) references technic_class_lib (id),
    foreign key (parameter_id) references technic_parameter_lib (id)
);

create table technics_equipments_lib (
    technic_id                  bigserial,
    equipment_id                bigserial,
    primary key (technic_id, equipment_id),
    foreign key (technic_id) references technic_class_lib (id),
    foreign key (equipment_id) references equipment_lib (id)
);

create table technic_adverts_equipments (
    advert_id                   bigserial,
    equipment_id                bigserial,
    primary key (advert_id, equipment_id),
    foreign key (advert_id) references advert_technic (id),
    foreign key (equipment_id) references equipment_lib (id)
);

create table views (
    id                          bigserial,
    advert_type                 bigserial,
    advert_id                   bigserial,
    views_count                 bigserial,
    primary key (id)
);

CREATE TABLE material_fractions (
 id                            bigserial,
 name                          varchar,
 primary key (id)
);

CREATE TABLE material_type (
 id                            bigserial,
 name                          varchar,
 primary key (id)
);

create table materials_fractions_lib (
  material_id                   bigserial,
  fractions_id                  bigserial,
  primary key (material_id, fractions_id),
  foreign key (material_id) references material_type (id),
  foreign key (fractions_id) references material_fractions (id)
);

create table advert_dump (
    id                          bigserial,
    owner_id                    bigserial,
    advert_type                 bigserial,
    transaction_type            bigserial,
    shiftType                   bigserial,
    title                       varchar,
    address_lat                 bigserial,
    address_lon                 bigserial,
    waste_type                  varchar,
    danger_class                bigserial,
    dump_transport              bigserial,
    measure_in                  bigserial,
    amount                      bigserial,
    price                       bigserial,
    payment_type                bigserial,
    advert_status               bigserial,
    is_verified                 boolean,
    is_banned                   boolean,
    created_at                  date,
    updated_at                  date,
    primary key (id)
);

create table advert_material (
    id                          bigserial,
    owner_id                    bigserial,
    advert_type                 bigserial,
    transaction_type            bigserial,
    shift_type                  bigserial,
    title                       varchar,
    delivery_type               bigserial,
    address_lat                 bigserial,
    address_lon                 bigserial,
    material_type               varchar,
    dump_transport              bigserial,
    measure_in                  bigserial,
    amount                      bigserial,
    payment_type                bigserial,
    price                       bigserial,
    advert_status               bigserial,
    is_verified                 boolean,
    is_banned                   boolean,
    created_at                  date,
    updated_at                  date,
    primary key (id)
);

create table advert_material_fractions (
    advert_id                   bigserial,
    fraction_id                 bigserial,
    primary key (advert_id, fraction_id),
    foreign key (advert_id) references advert_material (id),
    foreign key (fraction_id) references material_fractions (id)
);

CREATE TABLE comments (
id                      bigserial,
author_id               bigserial,
author_name             varchar,
addressee_id            bigserial,
rate                    bigserial,
text                    varchar,
created_at              date,
primary key (id)
);

insert into material_type (name)
values
('Асфальтная крошка'), ('Асфальтный скол'), ('Керамзит'), ('Кирпичный бой'), ('Пескогрунт'),
('Песок карьерный'), ('Песок мытый'), ('Песок сеяный'), ('Плодородный грунт'), ('Торф'),
('Щебень вторичный (рецикл бетонный)'), ('Щебень гравийный'), ('Щебень гранитный'), ('Щебень известняковый'), ('Асфальтная крошка')
;

insert into material_fractions (name)
values
('fr5_20'), ('fr20_40'), ('fr40_70'), ('graniteScreening'), ('gravelScreening'),
('limestoneScreening'), ('concreteScreening')
;

insert into materials_fractions_lib (material_id, fractions_id)
values
(3, 1), (3, 2), (3, 3), (11, 1), (11, 2), (11,3), (11,7), (12, 1), (12, 2), (12, 3), (12, 5),
(13, 1), (13, 2), (13, 3), (13, 4), (14, 6), (14, 1), (14, 2), (14, 3)
;

insert into technic_parameter_lib (name)
values
('weight'), ('height'), ('passengers_count'), ('volume'), ('pipe_length'),
('boom_length'), ('lifting_capacity'), ('performance'), ('cargo_type'), ('roller_type'),
('size_type'), ('ossig'), ('axes_count'), ('body_length'), ('trailer_type'),
('loading_type'), ('transport');

insert into equipment_lib (name)
values
('leveller'), ('cutting_blade'), ('pushing_blade'), ('front_blade'), ('watering_can'),
('ripper_fangs'), ('vibration_loader'), ('hydro_drill'), ('hydro_hammer'), ('hydro_scissors'),
('crusher'), ('milling_cutter'), ('pitchforks'), ('brush'), ('bucket'),
('long_boom'), ('planning_bucket'), ('water_dust_suppression');

insert into technic_class_lib (name)
values
('Автовышка'),('Автовоз'),('Автобус пассажирский'),('Автобетононасос'),('Автогрейдер'),
('Автогудронатор'),('Автокран'),('Бетоновоз'),('Бензовоз'),('Бульдозер'),
('Буровая установка'),('Водовоз'),('Газель'),('Гидробур'),('Грохот'),
('Дробильно-сортировочный комплекс'),('Дробилка мобильная'),('Земснаряд'),('Зерновоз'),('Каток грунтовой'),
('Каток дорожный'),('Контейнеровоз'),('Кран башенный'),('Кран гусеничный'),('Лесовоз'),
('Ломовоз'), ('Мусоровоз (ПУХТО)'), ('Мультилифт'), ('Манипулятор'), ('Погрузчик мини');

insert into technics_equipments_lib (technic_id, equipment_id)
values
(10, 1),(10, 2),(10, 3),(10, 6),(24, 7),(29, 8),(30, 8),(30, 12),(30, 13),(30, 14),(30, 9),(30, 15)
;

insert into technics_parameters_lib (technic_id, parameter_id)
values
(1, 6),(1, 7),(2, 17),(3, 17),(3, 3),(4, 5),(5, 1),(7, 6),(7, 7),(8, 17),(8, 4),(9, 4),(9, 17),(10, 1),
(12, 17), (12, 4), (13, 7),(15, 8),(16, 8),(17, 8),(19,4),(19, 7),(19, 9),(19, 17),(20, 1),(21, 1),(21, 10),(22,17),
(23, 7),(23, 2),(24, 2),(24, 7),(24, 11),(25, 17),(25, 4),(25, 7),(26, 4),(26, 7),(26, 17),(27, 4),(27, 7),(27, 17),
(28, 4),(28, 7),(28, 17),(29, 17),(29, 7),(29, 9)
;

insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN');

insert into users (username, password, phone, email, is_active, is_verified)
values
('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', '+79286669999', 'user@gmail.com', true, true),
('admin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', '+79288900666', 'admin@gmail.com', false, false);

insert into users_roles (user_id, role_id)
values
(1, 1),
(2, 2);