package com.lyj.manage.dao;

        import com.lyj.manage.entity.User;
        import org.apache.ibatis.annotations.Mapper;

        import java.util.List;

/**
 * create by lyj
 * 数据库操作层
 */
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> findAll();

}
