create table hibernate_sequence
(
    next_val bigint null
)
    engine = MyISAM;

create table t_blog
(
    id              bigint        not null
        primary key,
    appreciation    bit           not null,
    commentabled    bit           not null,
    content         longtext      null,
    create_time     datetime      null,
    first_picture   varchar(255)  null,
    flag            varchar(255)  null,
    published       bit           not null,
    recommend       bit           not null,
    share_statement bit           not null,
    title           varchar(255)  null,
    update_time     datetime      null,
    views           int default 0 null,
    type_id         bigint        null,
    user_id         bigint        null,
    description     varchar(255)  null
)
    engine = MyISAM;

create index FK292449gwg5yf7ocdlmswv9w4j
    on t_blog (type_id);

create index FK8ky5rrsxh01nkhctmo7d48p82
    on t_blog (user_id);

create table t_blog_tags
(
    blogs_id bigint not null,
    tags_id  bigint not null
)
    engine = MyISAM;

create index FK5feau0gb4lq47fdb03uboswm8
    on t_blog_tags (tags_id);

create index FKh4pacwjwofrugxa9hpwaxg6mr
    on t_blog_tags (blogs_id);

create table t_comment
(
    id                bigint       not null
        primary key,
    avatar            varchar(255) null,
    content           varchar(255) null,
    create_time       datetime     null,
    email             varchar(255) null,
    nickname          varchar(255) null,
    blog_id           bigint       null,
    parent_comment_id bigint       null,
    admin_comment     bit          not null
)
    engine = MyISAM;

create index FK4jj284r3pb7japogvo6h72q95
    on t_comment (parent_comment_id);

create index FKke3uogd04j4jx316m1p51e05u
    on t_comment (blog_id);

create table t_tag
(
    id   bigint       not null
        primary key,
    name varchar(255) null
)
    engine = MyISAM;

create table t_type
(
    id   bigint       not null
        primary key,
    name varchar(255) null
)
    engine = MyISAM;

create table t_user
(
    id          bigint       not null
        primary key,
    avatar      varchar(255) null,
    create_time datetime     null,
    email       varchar(255) null,
    nickname    varchar(255) null,
    password    varchar(255) null,
    type        int          null,
    update_time datetime     null,
    username    varchar(255) null
)
    engine = MyISAM;


