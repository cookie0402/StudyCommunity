package study.community.chenqian.mapper;

import org.apache.ibatis.annotations.*;
import study.community.chenqian.model.User;

@Mapper
public interface UserMapper {

    @Insert("insert into user_info (account_id,name,token,gmt_create,gmt_modified,avatar_url) values (#{account_id},#{name},#{token},#{gmt_create},#{gmt_modified},#{avatar_url})")
    void insert(User user);

    @Select("select * from user_info where token=#{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user_info where id=#{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from user_info where account_id=#{account_id}")
    User findByAccountId(@Param("account_id") String account_id);

    @Update("update user_info set name = #{name}, token = #{token}, gmt_modified = #{gmt_modified},avatar_url = #{avatar_url} where id = #{id}")
    void update(User user);

}
