package com.yt.ibatis.sqlsession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import javax.security.auth.login.Configuration;
import java.io.InputStream;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/5/16.
 */

public class SqlSessionFactoryTest {
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2.初创建始化mybatis，创建SqlSessionFactory类的实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3.创建一个sqlsession实例
        SqlSession sqlSession = sqlSessionFactory.openSession();//sqlSessionFactory.openSession(ExecutorType.BATCH);
        //4.获取实例后进行数据库操作 第一个参数为方法的完全限定名:位置信息+映射文件当中的id
        sqlSession.insert("com.*.mapper.dao", null);
        //5.提交事务
        sqlSession.commit();
        //6.关闭session
        sqlSession.close();

        //DAO接口
        sqlSession.getMapper(SqlSessionFactoryTest.class);

        System.out.println("test and modify");
    }
}
