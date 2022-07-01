## Study Community
This is a study community web using springboot
## Resources
[spring 文档](https://spring.io/guides/gs/serving-web-content/)

[github SSH](https://docs.github.com/cn/authentication/connecting-to-github-with-ssh/testing-your-ssh-connection)

[bootstrap 文档](https://www.bootcss.com)

[github API](https://docs.github.com/en/developers/apps/building-oauth-apps/creating-an-oauth-app)

[OkHttp3](https://square.github.io/okhttp/#releases)

[Springboot-doc](https://docs.spring.io/spring-boot/docs/2.1.13.RELEASE/reference/html/boot-features-sql.html)

[MyBaties](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)

## Scripts
```sql
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

```


