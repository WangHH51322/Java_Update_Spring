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



### 5.4 Bean的作用域

![image-20201207200733823](C:\Users\HH\AppData\Roaming\Typora\typora-user-images\image-20201207200733823.png)

1. 代理模式（Spring默认机制，也成单例模式）

   ```xml
   <bean id="instance" class="com.wang.pojo.User" scope="singleton">
       <property name="name" value="小李"/>
       <property name="age" value="75"/>
   </bean>
   ```

2. 原型模式 : 每次从容器中get的时候 , 都会产生一个新对象

   ```xml
   <bean id="instance" class="com.wang.pojo.User" scope="prototype">
       <property name="name" value="小李"/>
       <property name="age" value="75"/>
   </bean>
   ```

3. request / session / application 等只能在web开发中使用



## 6. Bean的自动装配

* 自动装配是Spring满足bean依赖的一种方式 ! 
* Spring会在上下文中自动寻找 , 并自动给bean装配属性 !



在Spring中有三种装配方式

1. 在xml中显式的配置
2. 在Java中显式配置
3. ==隐式 的自动装配bean==

### 6.1 byName与byType进行自动装配

```xml
<bean id="cat" class="com.wang.pojo.Cat">
    <property name="age" value="3"/>
    <property name="name" value="三花"/>
</bean>
<bean id="dog" class="com.wang.pojo.Dog">
    <property name="name" value="大黄"/>
    <property name="age" value="4"/>
</bean>

<!--自动装配-->
<!--
    byName:会自动在容器上下文中查找,和自己对象set方法后面的值对应的bean id
    byType:会自动在容器上下文中查找,和自己对象属性类型相同的bean
    -->
<bean id="person" class="com.wang.pojo.Person" autowire="byName">
    <property name="name" value="小明"/>
    <property name="age" value="18"/>
</bean>
```

小结 :

* byName的时候 , 需要保证所有bean的id唯一 , 并且这个bean需要和自动注入的属性的set方法的值一致 !
* byType的时候 , 需要保证所有bean的class唯一 , 并且这个bean需要和自动注入的属性的类型一致 ! 

### 6.2 使用注解自动装配

jdk1.5 , Spring2.5 开始支持注解

注解使用须知 : 

1. 导入约束 : context约束

2. 配置注解的支持

3. ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context.xsd">
   
       <context:annotation-config/>
   
   </beans>
   ```



**科普 :** 

```java
@Nullable	字段标记这个注解,说明这个字段可以为null; 
```

```java
public @interface Autowired {
    boolean required() default true;
}
```

**测试代码 :**

```java
//比如这个有参构造里面age前有 @Nullable ,说明这个字段可以为null;
public Person(Cat cat, Dog dog, String name,@Nullable Integer age) {
    this.cat = cat;
    this.dog = dog;
    this.name = name;
    this.age = age;
}
```

```java
public class Person {

    //如果显式定义了Autowired的required属性为false,说明这个对象可以为null,否则不允许为空
    @Autowired(required = false)
    private Cat cat;
    @Autowired
    private Dog dog;

    private String name;
    private Integer age;
}
```



如果@Autowired自动装配的环境比较复杂 , 自动装配无法通过一个注解@Autowired完成时 , 可以使用==@Qualifier(vlaue="xxx")==去配和@Autowired的使用 , 指定一个唯一的bean对象注入 !

**测试代码 :** 

```java
public class Person {

    //如果显式定义了Autowired的required属性为false,说明这个对象可以为null,否则不允许为空
    @Autowired(required = false)
    private Cat cat;
    @Autowired
    @Qualifier(value = "dog2")
    private Dog dog;

    private String name;
    private Integer age;
}
```



**@Resource注解**

```java
public class Person {

    @Resource
    private Cat cat;
    @Resource@Autowired(name = "dog2")
    private Dog dog;

    private String name;
    private Integer age;
}
```



小结 : 

==@Resource== 和 ==@Autowired==的区别

* 都是用来自动装配的 , 都可以放在属性字段上

* @Autowired 默认按照byType的方式实现 , 其次是byName

* @Resource 默认通过byName的方式实现 , 如果找不到名字 , 则通过byType实现 , 如果都找不到则报错

* @Resource 的使用需要额外导入依赖

  ```xml
  <dependency>
      <groupId>org.apache.tomcat</groupId>
      <artifactId>tomcat-annotations-api</artifactId>
      <version>9.0.36</version>
  </dependency>
  ```

  

## 7. 使用注解开发

要是用注解开发 , 必须保证aop的包导入

![image-20201208194749356](C:\Users\HH\AppData\Roaming\Typora\typora-user-images\image-20201208194749356.png)

使用注解需要导入context约束 , 增加注解的支持 !

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

</beans>
```

**注解 :** 

1. bean :

   @Component : 组件 , 放在类上 , 说明这个类被Spring管理了 , 就是Bean

2. 属性如何注入 :

   ```java
   /*
   * @Component 等价于 <bean id="user" class="com.wang.pojo.User"/> , 即"组件"
   * 并且实体类的名字(bean id)默认是类名的小写
   * */
   @Component
   public class User {
   
       /*
       属性值的注入使用@Value注解,相当于 <property name="name" value="小刘"/>
        */
       @Value("小刘")
       private String name;
   
       @Override
       public String toString() {
           return "User{" +
                   "name='" + name + '\'' +
                   '}';
       }
   
       public String getName() {
           return name;
       }
   
   //    @Value("小刘")
       public void setName(String name) {
           this.name = name;
       }
   }
   ```

3. 衍生注解

   @Component有几个衍生注解 , 我们在web开发中 , 会按照mvc三层架构分层 !

   * dao层 : ==@Repository==
   * service层 : ==@Service==
   * controller层 : ==@Controller==

   这四个注解的功能都是一样的 , 都是代表将某个类注册到Spring中 , 装配Bean

4. 作用域

   ```java
   /*
   * @Component 等价于 <bean id="user" class="com.wang.pojo.User"/> , 即"组件"
   * 并且实体类的名字(bean id)默认是类名的小写
   * */
   @Component
   /*
   @Scope(value = "singleton") 等价于 <bean id="user" class="com.wang.pojo.User" scope="singleton">
    */
   @Scope(value = "singleton")
   public class User {
   
       /*
       属性值的注入使用@Value注解,相当于 <property name="name" value="小刘"/>
        */
       @Value("小刘")
       private String name;
   
       @Override
       public String toString() {
           return "User{" +
                   "name='" + name + '\'' +
                   '}';
       }
   
       public String getName() {
           return name;
       }
   
   //    @Value("小刘")
       public void setName(String name) {
           this.name = name;
       }
   }
   ```

5. 小结

   xml 与注解 :

   * xml 更加万能 , 适用于任何场所 ! 维护方便
   * 注解  不是自己的类使用不了 , 维护相对复杂

   最佳实践 : 

   * xml 用来管理bean ; 
   * 注解只负责完成属性的注入

   在使用过程中 , 只需要注意 , 必须==让注解生效== , 开启注解支持 : 

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:context="http://www.springframework.org/schema/context"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context.xsd">
   
       <!--指定要扫描的包,这个包下的注解就会生效-->
       <context:component-scan base-package="com.wang"/>
   
       <!--使用注解需要导入context约束 , 增加注解的支持-->
       <context:annotation-config/>
   
   </beans>
   ```

   

## 8. 使用Java的方式配置Spring

完全不使用Spring的xml配置 , 全权交给Java来做

**实体类 :**

```java
@Component
public class User {

    @Value("小李")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

**配置类 :**

```java
/*
@Configuration 也会注册倒到容器中
               代表这是一个配置类,相当于之前的beans.xml
 */
@Configuration
/*
指定要扫描的包,这个包下的注解就会生效
 */
@ComponentScan("com.wang")
/*
通过import将多个配置类中的内容合并到一起
 */
@Import(MyConfig.class)
public class  MyConfig {

    /*
    @Bean 等价于 <bean id="newUser" class="com.wang.pojo.User"/>
     */
    @Bean
    public User newUser(){
        return new User();
    }
}
```

**测试类 :**

```java
public class MyTest {
    public static void main(String[] args) {
        /*
        如果完全使用了配置类方式去做,则需要
        使用 new AnnotationConfigApplicationContext() 获取配置类的上下文,通过配置类的class对象加载!
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        User newUser = context.getBean("newUser", User.class);
        System.out.println(newUser.getName());
    }
}
```



## 9. 代理模式

### 9.1 静态代理

**角色分析 :**

* 抽象角色 : 一般会使用接口或者抽象类来解决

* 真实角色 : 被代理的角色

* 代理角色 : 代理真实角色 , 代理真实角色后 , 我们一般会做一些附属操作

* 客户 : 访问代理角色的人 !!!

  

代理模式的好处 :

* 可以使真实角色的操作更加纯粹 , 不用去关注一些公共的业务
* 公共业务交给代理角色 , 实现业务分工
* 公共业务发生拓展时 , 方便集中管理

缺点 :

* 一个真实角色就会产生一个代理角色 ; 代码量会翻倍 , 开发效率会变低



演示代码 : 

1. 接口 :

   ```java
   public interface Rent {
   
       public void rent();
   }
   ```

2. 真实角色 :

   ```java
   //房东
   public class LandLord implements Rent{
   
       @Override
       public void rent() {
           System.out.println("房东要出租房屋!");
       }
   }
   ```

3. 代理角色 :

   ```java
   //中介代理
   public class Proxy implements Rent{
   
       private LandLord landLord;
   
       public Proxy(){}
   
       public Proxy(LandLord landLord){
           this.landLord = landLord;
       }
   
       @Override
       public void rent() {
           landLord.rent();
       }
   
       public void seeHouse(){
           System.out.println("中介带你看房!");
       }
   
       public void fee(){
           System.out.println("中介收中介费");
       }
   
       public void contact(){
           System.out.println("中介跟你签合同!");
       }
   }
   ```

4. 客户访问代理角色

   ```java
   public class Client {
       public static void main(String[] args) {
   
           //房东要租房子
           LandLord landLord = new LandLord();
   
           //代理
           Proxy proxy = new Proxy(landLord);
           proxy.seeHouse();
           proxy.rent();
           proxy.contact();
           proxy.fee();
       }
   }
   ```


另加 spring-08-proxy 的demo02



### 10.2 动态代理

* 动态代理和静态代理角色一样
* 动态代理的代理类是动态生成的 , 不是我们直接写好的 !
* 动态代理分为两大类 : ==基于接口的动态代理==   ==基于类的动态代理==
  * 基于接口----JDK动态代理
  * 基于类 : cglib
  * Java字节码实现

需要了解两个类 : Proxy (代理) , InvocationHandler(调用处理程序)



**动态代理的好处 :**

* 可以使真实角色的操作更加纯粹 , 不用去关注一些公共的业务
* 公共业务交给代理角色 , 实现业务分工
* 公共业务发生拓展时 , 方便集中管理
* 一个动态代理类代理的是一个接口 , 一般就是对应的一类业务
* 一个动态代理类可以代理多个类 , 只要是实现了同一个接口即可





































