package com.jnshu.service;

import com.jnshu.dao.UserDao;
import com.jnshu.model.User;
import com.jnshu.util.MemcachedUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 56929 on 2017/5/11.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    public List<User> selectAllUser() {
//        return userDao.selectAllUser();
        List<Long> longList = userDao.getUserIdList();
        List<User> userList = new ArrayList<User>();
        User user;
        for (Long id : longList){
            if (MemcachedUtils.get("user_"+id)!=null){
                user = (User)MemcachedUtils.get("user_"+id);
                System.out.print("这是从缓存中获取");
            }else {
                user = userDao.getId(id);
                System.out.print("这是从数据库中获取User:id="+id);
                MemcachedUtils.set("user_"+id,user,new Date(1000*20));
                userList.add(user);
            }
        }
        return userList;
    }
}
