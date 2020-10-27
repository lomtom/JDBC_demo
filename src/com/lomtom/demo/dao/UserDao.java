package com.lomtom.demo.dao;

import com.lomtom.demo.entity.UserEntity;
import com.lomtom.demo.util.JDBCUtils;

import java.sql.*;

/**
 * @author: LOMTOM
 * @Date: 2020/10/27
 * @Time: 16:25
 * @Email: lomtom@qq.com
 */

public class UserDao {

    /**
     * 登录接口
     * @param userEntity 用户信息
     * @return 查到的用户信息
     */
    public UserEntity login(UserEntity userEntity){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //建立连接
            connection = JDBCUtils.getConnection();

            //定义sql语句（？为占位符）
            String sql = "select * from user where user_name = ? and password = ? limit 1";

            //获取 PreparedStatement 对象
            statement = connection.prepareStatement(sql);

            //为 PreparedStatement 对象传参
            statement.setString(1,userEntity.getUserName());
            statement.setString(2,userEntity.getPassword());

            //执行sql
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                //从结果集去除
                return new UserEntity(resultSet.getString("user_name"),resultSet.getString("password"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接，释放资源
            JDBCUtils.close(resultSet,statement,connection);
        }
        return null;
    }
}
