[TOC]



# SpringMVC相关

## 背景介绍

### 基础概念介绍

BS和CS开发架构
一种是 C/S 架构，也就是客户端/服务器；
一种是 B/S 架构，也就是浏览器/服务器架构。
说明：
我们现在使用Java开发的大多数都是web应用，这些应用几乎全都是基于 B/S 架构进行开发的。
那么在 B/S 架构中，应用系统标准的三层架构分为：表现层、业务层、持久层。这种三层架构在
我们的实际开发中使用的非常多，所以我们课程中的案例也都是基于三层架构设计的。
JavaEE制定了一套规范，去进行BS结构的处理。这套规范就是Servlet。  

### 应用系统三层架构

表现层：
也就是我们常说的web 层。
它负责接收客户端请求，向客户端响应结果，通常客户端使用http 协议请求web 层，web 层
需要接收 http 请求，完成 http 响应。
表现层包括展示层和控制层：控制层负责接收请求，展示层负责结果的展示。
表现层依赖业务层，接收到客户端请求一般会调用业务层进行业务处理，并将处理结果响应
给客户端。
表现层的设计一般都使用 MVC 模型。（MVC 是表现层的设计模型，和其他层没有关系）
业务层：
也就是我们常说的 service 层。
它负责业务逻辑处理，和我们开发项目的需求息息相关。web 层依赖业务层，但是业务层不
依赖 web 层。
业务层在业务处理时可能会依赖持久层，如果要对数据持久化需要保证事务一致性。（也就
是我们说的， 事务应该放到业务层来控制）
持久层：
也就是我们是常说的 dao 层。
负责数据持久化，包括数据层即数据库和数据访问层，数据库是对数据进行持久化的载体，
数据访问层是业务层和持久层交互的接口，业务层需要通过数据访问层将数据持久化到数据
库中。
通俗的讲，持久层就是和数据库交互，对数据库表进行曾删改查的。  

### MVC设计模式

MVC 是模型(model)－视图(view)－控制器(controller)的缩写， 是一种用于设计编写 Web 应用程序
表现层的模式。
MVC 设计模式的三大角色：
Model（模型）：
模型包含业务模型和数据模型，数据模型用于封装数据，业务模型用于处理业务。
View（视图）：
通常指的就是我们的 jsp 或者 html。作用一般就是展示数据的。
通常视图是依据数据模型创建的。
Controller（控制器）：
是应用程序中处理用户交互的部分。作用一般就是处理程序逻辑的。  

## SpringMVC介绍

### SpringMVC是什么

SpringMVC 是一种基于MVC 设计模型的请求驱动类型的轻量级 Web 框架，属于
SpringFrameWork 的后续产品，已经融合在 Spring Web Flow 里面。Spring 框架提供了构建
Web 应用程序的全功能 MVC 模块。
使用 Spring 可插入的 MVC 架构，从而在使用 Spring 进行 WEB 开发时，可以选择使用 Spring 的
Spring MVC 框架或集成其他 MVC 开发框架，如 Struts1(现在一般不用)，Struts2 等。
SpringMVC 已经成为目前最主流的 MVC 框架之一，并且随着 Spring3.0 的发布，全面超越
Struts2，成为最优秀的 MVC 框架。
它通过一套注解，让一个简单的 Java 类成为处理请求的控制器，而无须实现任何接口。同时它还
支持RESTful 编程风格的请求。  

### SpringMVC与Spring的联系

Spring MVC 全名叫 Spring Web MVC ，它是 Spring家族Web模块 的一个重要成员。这一点,我们可以
从 Spring 的整体结构中看得出来：  

![1589117838021](C:\Users\semon\AppData\Roaming\Typora\typora-user-images\1589117838021.png)

为什么学习SpringMVC
也许你要问，为什么要学习Spring MVC呢？Struts2不才是主流吗？看SSH的概念有多火？
其实很多初学者混淆了一个概念，SSH实际上指的是 Struts1.x+Spring+Hibernate 。这个概念已经
有十几年的历史了。在Struts1.x时代，它是当之无愧的霸主，但是在新的MVC框架涌现的时代，形式已
经不是这样了，Struts2.x借助了Struts1.x的好名声，让国内开发人员认为Struts2.x是霸主继任者（其
实两者在技术上无任何关系），导致国内程序员大多数学习基于Struts2.x的框架，又一个貌似很火的概
念出来了S2SH（ Struts2+Spring+Hibernate ）整合开发。
不要再被蒙蔽了，看看下面的调查统计吧：
SpringMVC的市场占有率是40%，而Struts2只有可怜的6%。这已然说明了学习SpringMVC的必要性
了，再说了，SpringMVC本身就是spring家族的一员，与整合spring时，SpringMVC根本无需中间整合
包，而struts2得需要。
既然已经知道了SpringMVC的重要性了，那么下面就跟着我一起看看它的神奇之处吧！  

### SpringMVC六大组件介绍

![1589117925805](C:\Users\semon\AppData\Roaming\Typora\typora-user-images\1589117925805.png)

#### DispatchServlet:前端控制器

用户请求到达前端控制器,相当于mvc模式中的C,DispatchServlet是整个流程控制的中心,由它调用其他组件处理用户的请求,DispatchServlet的存在降低了组件之间的耦合性

#### Handler:处理器

Handler是继DispatchServlet前端控制器的后端控制器,在DispatchServlet的控制下Handler对具体的用户请求进行处理

#### View:视图

SpringMVC框架提供了很多的view视图类型的支持,包括:jstlview,freemarkerView,pdfview等等,一般情况下需要通过页面标签或页面模板技术将数据模型通过页面展示给用户,需要根据业务需求开发具体的页面

#### HandlerMapping:处理器映射器

HandlerMapping负责根据用户请求找到Handler处理器,SpringMVC提供了不同的映射器实现不同的映射方式,例如:配置文件方式,实现接口方式,注解方式等

#### HandlerAdapter:处理器适配器

通过HandlerAdapter对处理器进行执行,这是适配器模式的应用,通过扩展适配器可以对跟多类型的处理器进行执行

#### ViewResolver:视图解析器

View Resolver负责将处理结果生成View视图,View Resolver首先根据逻辑视图名解析成物理视图名即具体的页面地址,再生成View视图对象,最后对View进行渲染将处理结果通过页面展示给用户.

## 项目搭建

maven工程的简单springmvc-demo

### POM文件配置基础的依赖

配置mvc依赖,jstl依赖还有servlet-api依赖,配置maven插件和tomcat插件

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.aaron</groupId>
    <artifactId>springmvc-demo</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <packaging>war</packaging>

    <dependencies>
        <!-- spring MVC依赖包 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>4.2.9.RELEASE</version>
        </dependency>
        <!-- jstl -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
        <!-- servlet
        在项目中使用到HttpRequestServlet,HttpResponseServlet
        指定运行时间在编译期
        -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>servlet-api</artifactId>
            <version>2.5</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!--配置maven编译的jdk环境-->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.2</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>
            <!--配置Tomcat插件
            使用maven的tomcat插件来启动项目,是一种轻量级的启动方式,暂用内存较少
            -->
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.2</version>
                <configuration>
                    <path>/</path>
                    <port>8080</port>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

### 配置文件

web.xml 添加前端控制器

```java
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://java.sun.com/xml/ns/javaee"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
         version="2.5">
    <!-- 学习前置条件 -->
    <!-- 问题1：web.xml中servlet、filter、listener、context-param加载顺序 -->
    <!-- 问题2：load-on-startup标签的作用，影响了servlet对象创建的时机 -->
    <!-- 问题3：url-pattern标签的配置方式有四种：\/dispatcherServlet、 \/servlet\/\* 、\*
    、\/ ,以上四种配置，优先级是如何的-->
    <!-- 问题4：url-pattern标签的配置为\/\*报错，原因是它拦截了JSP请求，但是又不能处理JSP请
    求。为什么配置\/就不拦截JSP请求，而配置\/\*，就会拦截JSP请求-->
    <!-- 问题5：配置了springmvc去读取spring配置文件之后，就产生了spring父子容器的问题 -->
    <!-- 配置前端控制器 -->
    <servlet>
        <servlet-name>springmvc-demo</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!-- 设置spring配置文件路径 -->
        <!-- 如果不设置初始化参数，那么DispatcherServlet会读取默认路径下的配置文件 -->
        <!-- 默认配置文件路径：/WEB-INF/springmvc-servlet.xml -->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
        <!-- 指定初始化时机，设置为2，表示Tomcat启动时，DispatcherServlet会跟随着初始化
        -->
        <!-- 如果不指定初始化时机，DispatcherServlet就会在第一次被请求的时候，才会初始化，
        而且只会被初始化一次 -->
        <load-on-startup>2</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>springmvc-demo</servlet-name>
        <!-- URL-PATTERN的设置 -->
        <!-- 不要配置为\/\*,否则报错 -->
        <!-- 通俗解释：\/\*，会拦截整个项目中的资源访问，包含JSP和静态资源的访问，对于静态资源
        的访问springMVC提供了默认的Handler处理器 -->
        <!-- 但是对于JSP来讲，springmvc没有提供默认的处理器，我们也没有手动编写对于的处理
        器，此时按照springmvc的处理流程分析得知，它短路了
        也可以配置.do结尾,或者其他,来指定非页面请求的处理
        -->
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    <!-- <servlet> -->
    <!-- <servlet-name>sss</servlet-name> -->
    <!-- <servlet-class>sss</servlet-class> -->
    <!-- </servlet> -->
    <!-- <servlet-mapping> -->
    <!-- <servlet-name>sss</servlet-name> -->
    <!-- <url-pattern>/sss</url-pattern> -->
    <!-- </servlet-mapping> -->
</web-app>
```

springmvc.xml配置 配置扫描Bean,配置处理器适配器和处理器映射器,配置视图解析器

DispatchServlet加载的时候回去加载springmvc.xml文件

```java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/mvc
        http://www.springframework.org/schema/mvc/spring-mvc.xsd">
    <!-- 配置处理器Bean的读取 -->
    <!-- 扫描controller注解,多个包中间使用半角逗号分隔 -->
    <context:component-scan base-package="com.aaron.controller"/>
    <!-- 配置三大组件之处理器适配器和处理器映射器 -->
    <!-- 内置了RequestMappingHandlerMapping和RequestMappingHandlerAdapter等组件注
    册-->
    <mvc:annotation-driven />
    <!-- 配置三大组件之视图解析器 -->
    <!-- InternalResourceViewResolver:默认支持JSP视图解析-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <!-- 前缀,后缀,只需要返回动态的部分,就可以寻址到对应的视图 -->
        <property name="prefix" value="/WEB-INF/jsp/" />
        <property name="suffix" value=".jsp" />
    </bean>
</beans>
```

### 编码部分

根据业务需求,编写处理器类和视图,即Controller和Jsp页面等,对于前后端分离项目只需要编写Controller定义好和前端交互的格式即可.

处理器开发(Controller):

1.实现HttpRequestHandler接口

2.实现Controller接口

3.使用注解开发(一般企业开发使用)

```java
package com.aaron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller处理器的编写
 */
@Controller
@RequestMapping("/hello")
public class HelloController {


    @ResponseBody
    @RequestMapping("/springmvc")
    public String hello(){
        return "hello springmvc";
    }


    @RequestMapping("/jsp")
    public String hellojsp(){
        return "hello";
    }
}

```

```jsp
hello springmvc jsp
```

### 测试

 http://localhost:8080/hello/jsp  访问地址 页面展示正常

![1589119125288](C:\Users\semon\AppData\Roaming\Typora\typora-user-images\1589119125288.png)



## 编码应用

### 返回值的处理

#### 不使用注解修饰

##### ModelAndView

在Controller方法中定义ModelAndView对象并返回,对象中可以添加model数据,指定view视图.

##### void

在Controller方法形参上可以定义request和response,使用request和response指定相应结果

1.使用request转发页面请求

2.使用response进行页面重定向

3.也可以通过response指定响应结果,例如响应json数据

##### String(推荐)

1.返回逻辑视图名

2.forward请求转发

3.redirect重定向

```java
package com.aaron.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * springmvc中对于不使用注解方式的返回值的几种处理方式
 * 1.使用ModelAndView对象
 * 2.返回值为String
 * 3.返回值为void
 */

@Controller
@RequestMapping("/respHandler")
public class RespHandlerController {
    /**
     * 使用ModelAndView 对象
     * 指定视图名称和数据模型
     * @return
     */
    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("modelAndView");
        mav.addObject("modelAndView","modelAndView");
        return mav;
    }

    /**
     * 请求转发
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/requestForward")
    public void respHandlerVoid1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/respHandler/modelAndView").forward(request,response);
    }

    /**
     * 请求重定向
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/responseRedirect")
    public void respHandlerVoid2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/respHandler/modelAndView");
    }

    /**
     * 相应json格式数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/responseJson")
    public void respHandlerVoid3(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String result = "{'张三':'23','Aaron':'26','json':'utf-8'}";
        //设置响应编码 utf-8
//        response.setCharacterEncoding("utf-8");
        //设置响应格式 json
        response.setContentType("application/json;charset=utf-8");
        //流对象进行写出
        response.getWriter().write(result);
    }

    /**
     * 使用String方式返回逻辑视图
     * @return
     */
    @RequestMapping("/respString")
    public String respHandlerString1(){
        return "modelAndView";
    }

    /**
     * 使用String方式进行请求转发
     * @return
     */
    @RequestMapping("/respStringForward")
    public String respHandlerString2(){
        return "forward:/respHandler/modelAndView";
    }

    /**
     * 使用String方式进行请求重定向
     * @return
     */
    @RequestMapping("/respStringRedirect")
    public String respHandlerString3(){
        return "redirect:/respHandler/modelAndView";
    }

}

```

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">返回值测试页面${modelAndView}
```

#### 使用注解修饰

##### ResponseBody注解

作用:

1.ResponseBody注解可以针对Controller返回值类型,使用内置的9种HttpMessageConverter进行匹配,找到合适的HttpMessageConverter进行处理

2.HttpMessageConverter处理逻辑

​	2.1指定HttpServletResponse的ContentType值.

​	2.2将转换之后的数据放到HttpServletResponse对象的响应体返回到页面

常见的HttpMessageConverter

MappingJacksonHttpMessageConverter

作用:处理POJO类型返回值,默认使用MappingJackson的Json处理能力,将后台 返回的java对象(POJO类型),转为JSON格式输出到页面

将响应体的Content-Type设置为application/json;charset=utf-8

调用response.getWriter()方法将Json格式的字符串回写给调用者.

**注意:使用@ResponseBody注解返回Pojo类型的数据时,需要导入jackson相关的依赖包,保证Json转换正常**

StringHttpMessageConverter

作用:处理String类型返回值

将响应体的Content-Type设置为text/plain;charset=utf-8

调用response.getWriter()方法将String类型的字符串回写给调用者

**注意:使用@ResponseBody注解直接返回String类型的字符串,需要指定编码,解决返回值乱码的问题**

```java
package com.aaron.controller;

import com.aaron.doamin.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用注解方式处理返回值 @ResponseBody
 */
@Controller
@RequestMapping("/responseBody")
//@RestController 也可以直接使用 @RestController注解来制定每个方法都是用@ResponseBody注解进行返回
public class ResponseBodyController {

    /**
     * 返回POJO类即java对象
     * @return
     */
    @RequestMapping("/pojo")
    @ResponseBody
    public User retPojo(){
        return new User("Aaron","123456","26");
    }

    /**
     * 返回POJO类即java对象
     * @return
     */
    @RequestMapping("/listPojo")
    @ResponseBody
    public List<User> retListPojo(){
        ArrayList<User> list = new ArrayList();
        User user1 = new User("Aaron","123456","26");
        User user2 = new User("张三","123456","26");
        list.add(user1);
        list.add(user2);
        return list;
    }

    /**
     * 返回字符串
     * @return
     * 使用produces 指定响应类型和编码
     */
    @RequestMapping(value = "/string",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String retString(){
        return "综合查询String";
    }

}

```



### 参数绑定处理

#### 什么是参数绑定

#### 默认支持的参数类型

#### 参数绑定使用要求

##### 绑定简单类型

##### 绑定POJO类型

##### 绑定集合或者数组类型

#### 自定义日期参数绑定

#### 文件类型参数绑定

#### RequestMapping注解

##### value属性:

请求URL映射

作用:用于映射URL和HandlerMethod方法

用法:@RequestMapping("/item") @RequestMapping(value="/item")@RequestMapping(value={"/item","queryItem"})

窄化请求映射

作用:限制此类下的所有方法的访问请求url必须以请求前缀开头,对url进行模块化管理

用法如下:访问时的URL是/item/findItem

##### method属性:

作用:限定请求URL只能通过指定的method请求方式去访问该HandlerMethod

用法如下:

@RequestMapping(value="/findItem",method=RequestMethod.GET)

@RequestMapping(value="/findItem",method=RequestMethod.POST)

@RequestMapping(value="/findItem",method={RequestMethod.GET,RequestMethod.POST})

**params属性:**

作用:通过设置params参数条件,进行访问HandlerMethod限制

用法如下:

URL请求

```java
<a href="item/removeItem?name=iphone6&price>5000">删除商品，金额大于
5000</a>
<br />
<a href="item/removeItem?name=iphoneXs&price>7000">删除商品，金额大于
7000</a>
```

Controller方法:

```java
@RequestMapping(value="removeItem",params= {"name","price>5000"})
public String removeItem(Model model) {
    model.addAttribute("msg", "ItemController...removeItem方法执行
    了");
    return "success";
}
```

















































