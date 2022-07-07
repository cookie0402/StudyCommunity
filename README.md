## Study Community
This is a study community web using springboot
## Resources
[spring 文档](https://spring.io/guides/gs/serving-web-content/)

[Springboot-doc](https://docs.spring.io/spring-boot/docs/2.1.13.RELEASE/reference/html/boot-features-sql.html)
[Spring Intercption](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-handlermapping-interceptor)

[github SSH](https://docs.github.com/cn/authentication/connecting-to-github-with-ssh/testing-your-ssh-connection)

[bootstrap 文档](https://www.bootcss.com)

[github API](https://docs.github.com/en/developers/apps/building-oauth-apps/creating-an-oauth-app)

[OkHttp3](https://square.github.io/okhttp/#releases)



[MyBaties](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)

[FlyWay](https://flywaydb.org/documentation/getstarted/firststeps/maven)

[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-value-to-specific-attributes)

[Lombok](https://projectlombok.org/setup/maven)

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
```bash
mvn flyway:migrate
```
## 快捷键
1. 抽取变量快捷键: command+alt+v
2. 生成 getter/setter 函数: command+n
3. 快速查找文件: shift 两次
4. 
