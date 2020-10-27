package com.lomtom.demo.util;

import java.sql.*;
import java.util.Optional;

/**
 * @author: LOMTOM
 * @Date: 2020/10/27
 * @Time: 16:09
 * @Email: lomtom@qq.com
 */

public class JDBCUtils {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3308/demo?serverTimezone=Asia/Shanghai&characterEncoding=utf-8";
        String userName = "root";
        String password = "123456";

        return DriverManager.getConnection(url,userName,password);
    }


    private static void close(PreparedStatement statement, Connection connection) {
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultSet, PreparedStatement statement,Connection connection) {
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        close(statement,connection);
    }

}
