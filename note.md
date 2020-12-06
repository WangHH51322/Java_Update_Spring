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



## 2.HelloSpring



## 3.IOC创建对象的方式

1. 使用无参构造创建(默认方式)

   ```xml
   <!--当没有没有参构造(即,只有默认的无参构造时),直接对属性进行赋值-->
   <bean id="user" class="com.wang.pojo.User">
       <property name="name" value="延庆"/>
       <property name="age" value="17"/>
   </bean>
   ```

   

2. 使用有参构造创建时

```xml
<!--1.通过构造器中形参的下标去配置-->
<bean id="user" class="com.wang.pojo.User">
    <constructor-arg index="0" value="延庆"/>
    <constructor-arg index="1" value="220"/>
</bean>
```

```xml
<!--2.通过构造器中形参的参数类型去配置,一般不建议使用-->
<bean id="user" class="com.wang.pojo.User">
    <constructor-arg type="java.lang.String" value="小王"/>
    <constructor-arg type="java.lang.Integer" value="29"/>
</bean>
```

```xml
<!--3.通过构造器中的形参的名称去配置,最常用-->
<bean id="user" class="com.wang.pojo.User">
    <constructor-arg name="name" value="王小庆"/>
    <constructor-arg name="age" value="66"/>
</bean>
```

总结 : 在配置文件加载的时候 , 容器(就是Bean.xml里面的bean)中管理的对象就已经初始化了



## 4.Spring配置

### 4.1别名

```xml
<bean id="user" class="com.wang.pojo.User">
    <constructor-arg name="name" value="王小庆"/>
    <constructor-arg name="age" value="66"/>
</bean>

<!--如果添加了别名,可以使用这个别名去获取对象-->
<alias name="user" alias="User"/>
```



### 4.2 Bean的配置

```xml
<!--
id: bean 的唯一标识符,相当于对象名
class:  bean 对象对应的全限定名: 包名+类型
name:   也是别名,而且name可以同时取多个别名
-->
<bean id="teacher" class="com.wang.pojo.Teacher" name="teacherT,tt">
    <property name="name" value="小李"/>
    <property name="grade" value="7"/>
</bean>
```



### 4.3 import

import一般用于团队开发使用 , 可以将多个配置文件 , 倒入合并为一个 

假设项目有多个人开发 , 这两个人负责不同的开发 , 不同的类需要注册在不同的bean中 , 我们最后可以利用import 将所有人的beans.xml合并为一个总的applicationContext.xml

* 小明 :

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://www.springframework.org/schema/beans
          http://www.springframework.org/schema/beans/spring-beans.xsd">
  
      <bean id="teacher" class="com.wang.pojo.Teacher" name="teacherT,tt">
          <property name="name" value="小李"/>
          <property name="grade" value="7"/>
      </bean>
  
  </beans>
  ```

* 小李 :

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://www.springframework.org/schema/beans
          http://www.springframework.org/schema/beans/spring-beans.xsd">
  
      <bean id="user" class="com.wang.pojo.User">
          <constructor-arg name="name" value="王小庆"/>
          <constructor-arg name="age" value="66"/>
      </bean>
  
  </beans>
  ```

* applicationContext.xml

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://www.springframework.org/schema/beans
          http://www.springframework.org/schema/beans/spring-beans.xsd">
  
      <import resource="beans.xml"/>
      <import resource="beans2.xml"/>
  </beans>
  ```



## 5.DI依赖注入

### 5.1 构造器注入

即 , 前面第3节的构造器创建对象



### 5.2 Set方法注入(重点)

* 什么是依赖注入 : Set 注入 !
  * 依赖 : bean对象的创建依赖于容器
  * 注入 : bean对象中的所有属性 , 由容器来注入

```xml
<bean id="address" class="com.wang.pojo.Address">
    <property name="address" value="安徽"/>
</bean>

<bean id="student" class="com.wang.pojo.Student">
    <!--普通值注入,value-->
    <property name="name" value="小王"/>
    <!--Bean注入,ref-->
    <property name="address" ref="address"/>
    <!-- 数组-->
    <property name="books">
        <array>
            <value>平凡的世界1</value>
            <value>平凡的世界2</value>
            <value>平凡的世界3</value>
        </array>
    </property>
    <!--List-->
    <property name="hobbys">
        <list>
            <value>音乐</value>
            <value>游戏</value>
            <value>电影</value>
        </list>
    </property>
    <!--map-->
    <property name="card">
        <map>
            <entry key="身份证" value="3121234567"/>
            <entry key="学生证" value="123321456"/>
            <entry key="银行卡" value="62170017456"/>
            <entry key="饭卡" value="4321"/>
        </map>
    </property>
    <!--set-->
    <property name="games">
        <set>
            <value>CS:GO</value>
            <value>LOL</value>
            <value>WOW</value>
        </set>
    </property>
    <!--null-->
    <property name="wife" value=""/>
    <!--Properties-->
    <property name="info">
        <props>
            <prop key="driver">jdbc</prop>
            <prop key="url">jdbc:mysql://localhost:3306/wang_last?allowMultiQueries=true</prop>
            <prop key="username">root</prop>
            <prop key="password">newpassword</prop>
        </props>
    </property>
</bean>
```

结果展示 :

```java
Student{
name='小王',
address=Address{
    Address='安徽'
    },
books=[平凡的世界1,平凡的世界2,平凡的世界3],
hobbys=[音乐,游戏,电影],
card={
    身份证=3121234567,
    学生证=123321456,
    银行卡=62170017456,
    饭卡=4321
    },
games=[CS:GO,LOL,WOW],
wife='',
info={
    password=newpassword,
    driver=jdbc,
    url=jdbc:mysql://localhost:3306/wang_last?allowMultiQueries=true,
    username=root
    }
}
```



### 5.3 拓展方式注入

我们可以使用p命名空间和c命名空间进行注入

使用:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--p 命名空间注入,可以直接注入属性的值:properties-->
    <bean id="user" class="com.wang.pojo.User" p:name="小刘" p:age="18"/>

    <!--c 命名空间注入,通过构造器注入:construct-args-->
    <bean id="user2" class="com.wang.pojo.User" c:name="小王" c:age="22"/>

</beans>
```

测试:

```java
@Test
public void test(){
    ApplicationContext context = new ClassPathXmlApplicationContext("userBeans.xml");
    User user = context.getBean("user", User.class);
    User user2 = context.getBean("user2", User.class);
    System.out.println(user.toString());
    System.out.println(user2.toString());
}
```

注意点 : p命名和c命名空间不能直接使用 , 需要导入xml约束 

```xml
xmlns:p="http://www.springframework.org/schema/p"
xmlns:c="http://www.springframework.org/schema/c"
```

