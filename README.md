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

就是将请求参数串中的value值获取之后,再进行类型转换,然后将转换后的值赋给Controller类中方法的形参,这个过程就是参数绑定

两步:

1.类型转换--请求中的String类型值--->Controller各种数据类型的方法形参

2.赋值操作,将转换之后的值付给Controller方法形参

请求参数格式:http://xxx/xx?id=1&type=301 

请求参数类型:都是String

请求参数值要绑定的目标类型:Controller类中方法的参数,比如简单类型,POJO类型,集合类型

SpringMVC内置类24中参数解析组件:ArgumentResolver

#### 默认支持的参数类型

Controller方法形参中可以随时添加如下类型的参数(Servlet API支持),处理适配器会自动识别并进行赋值

HttpServletRequest:通过request对象获取请求信息

HttpServletResponse:通过response处理响应信息

HttpSession:通过session对象得到session中存放的对象

InputStream,OutputStream,Reader,Writer

Model/ModelMap

#### 参数绑定使用要求

##### 绑定简单类型

直接绑定:

http请求参数的key和Controller方法形参名称一致

注解绑定:

请求参数的key和Controller方法的形参名称不一致时,需要使用@RequestParam注解才能将请求参数绑定成功

RequestParam注解:

value:参数名称,即入参的请求参数名称,如value="itemid"表示请求的参数中的名称为itemid的参数的值将传入

required:是否必须,默认是true,,表示请求中的一定要有相应的参数,否则报错 

 TTP Status 400 - Required Integer parameter 'XXXX' is not present  

defaultValue:

默认值,表示如果请求中没有同名参数时的默认值

##### 绑定POJO类型

要求表单中参数名称和Controller方法中的POJO形参的属性名称保持一致.

##### 绑定集合或者数组类型

简单类型数组

通过http请求批量传递简单类型数据的情况,Controller方法中可以用String[]或者POJO的String[]属性接受(两种方式任选其一),但是不能使用List集合接受

POJO类型集合或者数组

批量传递的请求参数,最终要是用List<POJO>来接受,那么这个List<POJO>必须放在另一个POJO类中

#### 自定义日期参数绑定

对于springmvc无法解析的参数绑定类型,比如:时间 年月日时分秒的日期,绑定到Date类型会报错,此时需要自定义参数转换器进行参数绑定.

也可以使用

 @JsonFormat（"pattern="yyyy-MM-dd HH:mm:ss",timezone="GTM+8"） // 即可将json返回的对象为指定的类型。 

 @DateTimeFormat（“pattern="yyyy-MM-dd”） // 可将String转换为Date类型 

#### 文件类型参数绑定

SpringMVC文件上传的实现,是由commons-fileupload这个三方jar包实现的

加入依赖包:

  <dependency>
<groupId>commons-fileupload</groupId>
<artifactId>commons-fileupload</artifactId>
<version>1.3.1</version>
</dependency>

配置Multipart解析器

在springmvc.xml中配置multipart类型解析器

 

```java
 <!-- multipart类型解析器，文件上传 -->
<bean id="multipartResolver"class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
<!-- 上传文件的最大尺寸 5M-->
<property name="maxUploadSize" value="5242880"/>
</bean>  
```

注意:对于Servlet低于3的版本需要导入commons-fileupload包进行文件上传

对于Servlet3或者以上版本可以使用Servlet内置的文件上传

配置spring-mvc.xml的多部件上传后

在web.xml中也需要配置才可以使用.

```java
 <servlet>
    <servlet-name>dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
    <multipart-config>
      <max-file-size>20848820</max-file-size>
      <!--上传内文件的最大容量-->
      <max-request-size>418018841</max-request-size>
      <!--表示多部分HTTP请求允许的最大容量-->
      <file-size-threshold>1048576</file-size-threshold>
      <!--超过这个容量将会被写到磁盘中-->
      <location>/image/</location>
      <!--要将已上传的文件保存到磁盘中的位置-->
    </multipart-config>
  </servlet>
```

```java
package com.aaron.controller;

import com.aaron.doamin.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 请求参数绑定
 * SpringMVC默认支持的参数类型
 * HttpServletRequest,HttpServletResponse,HttpSession
 * InputStream,OutputStream,Reader,Writer,Model/ModelMap
 * ModelMap 继承自 LinkedHashMap ，Model是一个接口，它们的底层实现都是同一个类
 * （ BindingAwareModelMap ），作用就是向页面传递数据，相当于 Request 的作用，如下
 */
@RestController
@RequestMapping("/user")
public class ParamBindController {

    @RequestMapping("/findUserById")
    public String findUserById(Integer id,String name){
        System.out.println("param :"+id+",name:"+name);
        return "success";
    }

    /**
     * 简单参数注解绑定 对于名称不一致的处理
     * @RequestParam 属性required默认为true,如果不是必须参数,可以修改为false
     * @RequestParam(value = "uid",required = false)
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("/findUserById2")
    public String findUserById2(@RequestParam("uid") Integer id, String name){
        System.out.println("param :"+id+",name:"+name);
        return "success";
    }

    /**
     * 把简单参数封装到POJO类中
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println("param:"+user);
        return "success";
    }

    /**
     * 接受数组类型数据正确使用数组接受
     * @param id
     * @return
     */
    @RequestMapping("/deleteUserByIds")
    public String deleteUserByIds(Integer[] id){
        System.out.println("params:"+ Arrays.toString(id));
        return "success";
    }

    /**
     * 错误示范使用集合接受
     * @param id
     * @return
     */
    @RequestMapping("/deleteUserByIds2")
    public String deleteUserByIds2(List id){
        System.out.println("params:"+id.toString());
        return "success";
    }

    /**
     * 使用Bean的数组或者集合接受
     * @param user
     * @return
     */
    @RequestMapping("/deleteUserByIds3")
    public String deleteUserByIds3(User user){
        System.out.println("params:"+user.toString());
        return "success";
    }


    /**
     * POJO类中的list和map参数绑定
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(User user){
        System.out.println("param : "+ user);
        return "success";
    }


    /**
     * 日期类型解析
     * 1.使用自定义的时间类型转换器,并且注册到类型转换器中
     * 2.使用@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
     * 将前台传过来的时间字符串转换成Date对象,需要前后端格式指定一致
     * 3.对于后台返回给前端的参数,
     * 需要加上@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
     * 并且由于时区的问题,需要指定timezone
     * @param birthday
     * @return
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(String birthday){
        System.out.println("param : "+ birthday);
        return "success";
    }

   @RequestMapping("/deleteUser2")
   public String deleteUser2(Date birthday){
       System.out.println("param : "+ birthday);
       return "success";
   }

    @RequestMapping("/deleteUser3")
    public User deleteUser3(User user){
        System.out.println("param : "+ user);
        return user;
    }

    /**
     * SpringMVC上传文件
     * @param uploadFile
     * @return
     * @throws IOException
     */
    @RequestMapping("/fileupload")
    public String fileupload(MultipartFile uploadFile) throws IOException {
        if (uploadFile != null) {
            System.out.println(uploadFile.getOriginalFilename());
            // 原始图片名称
            String originalFilename = uploadFile.getOriginalFilename();
            // 如果没有图片名称，则上传不成功
            if (originalFilename != null && originalFilename.length() > 0) {
                // 存放图片的物理路径
                String picPath = "E:\\";
                // 获取上传文件的扩展名
                String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
                // 新文件的名称
                String newFileName = UUID.randomUUID() + extName;
                // 新的文件
                File newFile = new File(picPath + newFileName);
                // 把上传的文件保存成一个新的文件
                uploadFile.transferTo(newFile);
                // 同时需要把新的文件名更新到数据库中
            }
        }
        return "文件上传成功";
    }

}

```

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
    <!--修改spring service context xml配置文件中的annotation-driven,增加属性conversion-service指向新增的conversionService bean。-->
    <!--<mvc:annotation-driven conversion-service="conversionService"/>-->
    <mvc:annotation-driven />

    <!--配置自定义日期类型转换器-->
   <!-- <bean id="conversionService" class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
        <property name="converters">
            <set>
                <bean class="com.aaron.controller.converter.DateConverter"/>
            </set>
        </property>
    </bean>-->

    <!--配置文件上传解析器-->
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <!--配置上传文件的最大值,单位byte,文件编码指定为utf-8-->
        <property name="maxUploadSize" value="10000000"/>
        <property name="defaultEncoding" value="utf-8"/>
    </bean>

    <!-- 配置三大组件之视图解析器 -->
    <!-- InternalResourceViewResolver:默认支持JSP视图解析-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <!-- 前缀,后缀,只需要返回动态的部分,就可以寻址到对应的视图 -->
        <property name="prefix" value="/WEB-INF/jsp/" />
        <property name="suffix" value=".jsp" />
    </bean>
</beans>
```

```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>参数绑定演示demo</title>
</head>
<body>
<!-- request请求的内容类型主要分为：K/V类型、Multipart类型、JSON类型 -->
<!-- 将request请求参数，绑定到简单类型（基本类型和String类型）方法参数 -->
<!-- 直接绑定 -->
<a href="${pageContext.request.contextPath}/user/findUserById?
id=1&name=bingbing">查询用户1</a>
<!-- @RequestParam注解绑定 -->
<a href="${pageContext.request.contextPath}/user/findUserById2?uid=1&name=张三">查询用
户2</a>
<!-- 将request请求参数，绑定到POJO类型(简单POJO和包装POJO的)方法参数 -->
<form action="${pageContext.request.contextPath}/user/saveUser"
method="post">
用户名称：<input type="text" name="username"><br />
用户年龄：<input type="text" name="age"><br />
所属省份：<input type="text" name="address.provinceName"><br />
所属城市：<input type="text" name="address.cityName"><br />
<input type="submit" value="保存">
</form>
<!-- 将request请求参数，绑定到[元素是简单类型的集合或数组]参数 -->
<!-- 使用数组接收 -->
<a href="${pageContext.request.contextPath}/user/deleteUserByIds?
id=1&id=2&id=3">根据ID批量删除用户</a>
<!-- 使用List接收（错误示例） -->
<a href="${pageContext.request.contextPath}/user/deleteUserByIds2?
id=1&id=2&id=3">根据ID批量删除用户</a>
<!-- 使用Bean的List属性接收 -->
<a href="${pageContext.request.contextPath}/user/deleteUserByIds3?
uid=1&uid=2&uid=3">根据ID批量删除用户</a>Controller代码
<!-- 将request请求参数，绑定到[元素是POJO类型的List集合或Map集合]参数 -->
<form action="${pageContext.request.contextPath}/user/updateUser"
method="post">
用户名称：<input type="text" name="username"><br />
用户年龄：<input type="text" name="age"><br />
<!-- itemList[集合下标]：集合下标必须从0开始 -->
<!-- 辅助理解：先将name属性封装到一个Item对象中，再将该Item对象放入itemList集合的
指定下标处 -->
购买商品1名称：<input type="text" name="itemList[0].name"><br />
购买商品1价格：<input type="text" name="itemList[0].price"><br />
购买商品2名称：<input type="text" name="itemList[1].name"><br />
购买商品2价格：<input type="text" name="itemList[1].price"><br />
<!-- itemMap['item3']：其中的item3、item4就是Map集合的key -->
<!-- 辅助理解：先将name属性封装到一个Item对象中，再将该Item对象作为value放入
itemMap集合的指定key处 -->
购买商品3名称：<input type="text" name="itemMap['item3'].name"><br />
购买商品3价格：<input type="text" name="itemMap['item3'].price"><br />
购买商品4名称：<input type="text" name="itemMap['item4'].name"><br />
购买商品4价格：<input type="text" name="itemMap['item4'].price"><br />
<input type="submit" value="保存">
</form>
<!-- 将request请求参数，绑定到Date类型方法参数 -->
<!-- 请求参数是：【年月日】 格式 -->
    <a href="${pageContext.request.contextPath}/user/deleteUser?birthday=2020-05-11">根据日期删除用户(String)</a>
    <!-- 请求参数是：【年月日 时分秒】 格式 -->
    <a href="${pageContext.request.contextPath}/user/deleteUser2?birthday=2020-05-11 12:10:33">根据日期删除用户(Date)</a>
    <a href="${pageContext.request.contextPath}/user/deleteUser3?birthday=2020-05-11 12:10:33">根据日期删除用户(Date)</a>
    <!-- 文件类型参数绑定 -->
    <form action="${pageContext.request.contextPath}/user/fileupload" method="post"
    enctype="multipart/form-data">
    图片：<input type="file" name="uploadFile" /><br />
    <input type="submit" value="上传" />
    </form>
    </body>
</html>
```



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



## SpringMVC对RESTful的支持

#### RESTful的URL路径变量

restful的URL路径变量

Url-patter:设置为/,方便拦截restful请求

```java
<servlet-mapping>
	<servlet-name>DispatcherServlet</servlet-name>
	<url-pattern>/</url-pattern>
</servlet-mapping>
```

@PathVariable:可以解析出来URL中的模板变量({id})

例如:http://localhost:8080/ssm/item/1/zhangsan

Controller

```java
@RequestMapping(“{id}/{name}”)
@ResponseBody
public Item queryItemById(@PathVariable Integer id, @PathVariable String
name){

}
```

#### RESTful的CRUD

@RequestMapping:通过设置method属性值,可以将同一个url映射到不同的HandlerMethod方法上

@GetMapping@PostMapping@PutMapping@DeleteMapping注解同@RequestMapping注解的method属性设置

#### RESTful的资源表述

restful服务中的一个重要的特性就是一种资源可以有多种表现形式,在springmvc中可以使用ContentNegotiatingManager这个内容协商管理器来实现这种方式

#### 内容协商的三种方式

扩展名:比如.json表示我要json格式数据,.xml表示我要xml格式数据

请求参数:默认是"format"

请求头设置Accept参数:比如设置Accept为application/json表示要json格式数据

不过现在restful响应一般都是json格式,所以一般也不实用内容协商管理器,直接使用@ResponseBody注解将数据按照json格式返回

#### 静态资源访问

如果在DispatcherServlet中设置url-pattern为/则必须对静态资源进行访问控制处理.

在springmvc.xml文件中,使用mvc:resources标签,具体如下:

```
<!-- 当DispatcherServlet配置为/来拦截请求的时候，需要配置静态资源的访问映射 -->
<mvc:resources location="/js/" mapping="/js/"/>
<mvc:resources location="/css/" mapping="/css/"/>
```

SpringMVC会把mapping映射到ResourceHttpRequestHandler,这样静态资源在经过Dispatcherservlet转发时就可以找到对应的Handler了

对于Restful类型的请求推荐使用POSTMAN进行测试.便于模拟请求方法









































