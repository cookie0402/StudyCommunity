package study.community.chenqian.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import study.community.chenqian.model.User;

@Mapper
public interface UserMapper {

    @Insert("insert into user_info (account_id,name,token,gmt_create,gmt_modified,avatar_url) values (#{account_id},#{name},#{token},#{gmt_create},#{gmt_modified},#{avatar_url})")
    void insert(User user);

    @Select("select * from user_info where token=#{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user_info where id=#{id}")
    User findById(@Param("id") Integer id);
}
