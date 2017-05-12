package com.jnshu.dao;

import com.jnshu.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 56929 on 2017/5/11.
 */
@Component
@Repository
public interface UserDao {

    List<User> selectAllUser();
    List<Long> getUserIdList();

    User getId(long id);
}
