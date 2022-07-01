package study.community.chenqian.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import study.community.chenqian.model.User;

@Mapper
public interface UserMapper {

//    @Insert("insert into user_info (name,account_id,token,gmt_create,gmt_modified) value (#{name},#{account_id},#{token},#{gmt_create},#{gmt_modified})")
    @Insert("insert into user_info (account_id,name,token,gmt_create,gmt_modified) values (#{account_id},#{name},#{token},#{gmt_create},#{gmt_modified})")
    void insert(User user);
}
