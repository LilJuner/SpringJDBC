package com.JavaEE.springJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {
    public static void main(String args[]){
        //定义配置文件路径
        String xmlPath = "com/JavaEE/springJDBC/beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(xmlPath);
        //获取JDBC模板类
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ac.getBean("jdbcTemplate");
        //定义建表语句
        String sql = "create table account(id int primary key auto_increment," +
                "username varchar(50), balance double)  " +
                "engine = innodb,collate = utf8_general_ci";
        //执行sql语句
        jdbcTemplate.execute(sql);
        System.out.println("数据表创建成功");
    }
}
