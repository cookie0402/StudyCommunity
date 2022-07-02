create table USER_INFO
(
    ID           INTEGER auto_increment,
    ACCOUNT_ID   CHARACTER VARYING(100),
    NAME         CHARACTER VARYING(50),
    TOKEN        CHARACTER(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    constraint USER_INFO_PK
        primary key (ID)
);

create unique index USER_INFO_ID_UINDEX
    on USER_INFO (ID);