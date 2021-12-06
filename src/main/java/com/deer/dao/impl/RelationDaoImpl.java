package com.deer.dao.impl;

import com.deer.pojo.Husband;
import com.deer.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: 86175
 * @date: 2021/12/2 16:07
 * @description:
 */
public class RelationDaoImpl {
    private SqlSession sqlSession=null;
    @Before
    public void init() throws IOException {
        //SqlSession是mybatis的核心类，等同与java中api
        //得到sqlsession的过程
        //SqlSession-->SqlSessionFactory-->SqlSessionFactoryBuilder
        //1.得到SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        //2.通过ssfb得到SqlSessionFactory对象
        InputStream ins = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory ssf = ssfb.build(ins);
        //3.得到SqlSession对象
        sqlSession = ssf.openSession();
    }
    @Test
    public void selectOneToOne(){

        Husband husband = sqlSession.selectOne("com.deer.dao.impl.RelationDaoImpl.selectOneToOne", "小明");
        System.out.println(husband);
    }

    @Test
    public void selectOneToMany(){

        List<User> user =sqlSession.selectList("com.deer.dao.impl.RelationDaoImpl.selectOneToMany","110");
        for (int i=0;i<user.size();i++){
            System.out.println(user.get(i));
        }

    }
    @After
    public void destroy(){
        //事务提交
        sqlSession.commit();
    }
}
