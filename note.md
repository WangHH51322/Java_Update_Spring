# Spring

## 1. IOC理论推导

 业务实现过程 :

1. UserDao 接口
2. UserDaoImpl 实现类
3. UserService 业务接口
4. UserServiceImpl 业务实现类



在业务中,用户的需求会影响原来的代码,需要根据用户的需求去修改代码 , 如果程序代码量巨大 , 修改一次的成本代价非常昂贵

通过set方法 , 实现动态注入

```java
private UserDao userDao;

//利用set方法实现,进行动态注入
public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
}

public void getUser(){
    userDao.getUser();
}
```

