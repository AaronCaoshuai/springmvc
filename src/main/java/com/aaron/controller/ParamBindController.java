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
