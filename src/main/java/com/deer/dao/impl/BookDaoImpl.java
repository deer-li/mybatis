package com.deer.dao.impl;

import com.deer.pojo.Book;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 86175
 * @date: 2021/12/1 16:21
 * @description:
 */
public class BookDaoImpl {
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
    /*
     * @description:查询books数据，涉及到书写存放sql语句的局部配置文件，
     * 规范是局部配置文件和对应的dao层实现类放在一个文件夹下面
     */
    @Test
    public void selectBooks() {
        //4.执行对应的sql语句，接收并遍历结果
        List<Object> bookList = sqlSession.selectList("com.deer.dao.impl.BookDaoImpl.selectBooks");
        //bookList.forEach(temp-> System.out.println(temp));//jdk1.7不支持该lambda表达式
        for (int i=0;i<bookList.size();i++){
            System.out.println(bookList.get(i));
        }
    }
    @Test
    public void selectOne() {
        /*//java.lang.ClassCastException: java.util.HashMap cannot be cast to java.util.List
        List<Object> bookOne = sqlSession.selectOne("com.deer.dao.impl.BookDaoImpl.selectOne");
        for (int i=0;i<bookOne.size();i++){
            System.out.println(bookOne.get(i));
        }*/
        Map<String,Object> bookMap= (Map<String, Object>) sqlSession.selectOne("com.deer.dao.impl.BookDaoImpl.selectOne",1);
        for (Map.Entry<String ,Object> o:bookMap.entrySet()){
            System.out.println(o.getKey()+" "+o.getValue());
        }
    }
    @Test
    public void selectTwo(){
        //多个参数的sql查询时，把参数放在map集合中
        HashMap<String, Object> paramMap = new HashMap<>();
        //给映射文件的多参数赋值
        paramMap.put("bookName","spring");
        paramMap.put("id",2);
        List<Object> listTwo = sqlSession.selectList("com.deer.dao.impl.BookDaoImpl.selectTwo",paramMap);
        for (int i=0;i<listTwo.size();i++){
            System.out.println(listTwo.get(i));
        }
    }
    @Test
    public void selectThree(){
        Book book = new Book();
        //给映射文件的多参数赋值
        book.setBookName("spring");
        book.setId(2);
        List<Object> listThree = sqlSession.selectList("com.deer.dao.impl.BookDaoImpl.selectThree", book);
        for (int i=0;i<listThree.size();i++){
            System.out.println(listThree.get(i));
        }
    }
    @Test
    public void selectMuHu(){
        HashMap<Object, Object> hmap = new HashMap<>();
        hmap.put("bookName","java");
        hmap.put("num","1");
        List<Map<String,Object>> Mlist = sqlSession.selectList("com.deer.dao.impl.BookDaoImpl.selectMuHu", hmap);
        System.out.println(Mlist);
    }
    @Test
    public void insertOne(){
        Book book=new Book();
        book.setId(null);
        book.setBookName("mybaits精通");
        book.setPrice("28");
        book.setNum("8");
        int i = sqlSession.insert("com.deer.dao.impl.BookDaoImpl.insertOne", book);
        System.out.println("影响行数:"+i);
    }
    @Test
    public void updateOne(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("bookName","java从入门到精通");
        map.put("price","19800");
        map.put("num","1");
        int u = sqlSession.update("com.deer.dao.impl.BookDaoImpl.updateOne", map);
        System.out.println("影响行数"+u);
    }
    @Test
    public void deleteOne(){
        Book book = new Book();
        book.setId(2);
        int j = sqlSession.delete("com.deer.dao.impl.BookDaoImpl.deleteOne", book);
        System.out.println("影响行数："+j);
    }

    @Test
    public void selectDynamic(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("brand","联想");
        map.put("startprice","6000");
        map.put("endprice","9000");
        List<Map<String,Object>> list = sqlSession.selectList("com.deer.dao.impl.BookDaoImpl.selectDynamic",map);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    @Test
    public void updateDynamic(){

        HashMap<Object, Object> map = new HashMap<>();
        map.put("brand","苹果");
        map.put("price","8999");
        map.put("id","1");
        int update = sqlSession.update("com.deer.dao.impl.BookDaoImpl.updateDynamic", map);
        System.out.println("影响行数"+update);

    }

    //实现pageHelper分页
    @Test
    public void selectByPageHelper(){
        int pageNum=1;
        int pageSize=2;
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String,Object>> list = sqlSession.selectList("com.deer.dao.impl.BookDaoImpl.selectByPageHelper");
        //将查询的数据包装一把
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
        //取出分页好的数据
        List<Map<String, Object>> pageInfoList = pageInfo.getList();
        for (int i=0;i<pageInfoList.size();i++){
            System.out.println(pageInfoList.get(i));
        }
    }
    /*
     * @return: void
     * @author:
     * @date:
     * @description：下面这部分代码当只有查询操作的时候，是不需要的，只有当增删改才需要，
     */
    @After
    public void destroy(){
        //事务提交
        sqlSession.commit();
    }
}
