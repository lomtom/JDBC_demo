package com.lomtom.demo.servlet;

import com.lomtom.demo.dao.UserDao;
import com.lomtom.demo.entity.UserEntity;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: LOMTOM
 * @Date: 2020/10/27
 * @Time: 15:39
 * @Email: lomtom@qq.com
 */

public class loginServlet extends HttpServlet {

    /**
     * 重写doPost
     * @param request 请求
     * @param response 相应
     * @throws IOException io流异常
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置响应类型及编码
        response.setContentType("text/html;charset=UTF-8");
        // 获取响应对象
        PrintWriter writer = response.getWriter();
        // 从请求中获取参数
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        // 判空
        if (userName == null || password == null || "".equals(userName) || "".equals(password)){
            writer.print("用户名或者密码为空");
            writer.flush();
            writer.close();
            return;
        }
        // 实例化对象
        UserEntity form = new UserEntity(userName,password);
        UserDao userDao = new UserDao();
        // 调用登录接口
        UserEntity userEntity = userDao.login(form);
        // 返回为空，说明数据库中没有该用户的数据或者密码错误
        if (userEntity == null){
            writer.print("用户不存在或者密码错误");
            writer.flush();
            writer.close();
            return;
        }
        // 不为空说明用户名、密码匹配
        writer.print("登陆成功："+userEntity);
        writer.flush();
        writer.close();
    }
}
