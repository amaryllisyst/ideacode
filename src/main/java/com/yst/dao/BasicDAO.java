package com.yst.dao;

import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface BasicDAO<T> {
    public void insert(T t);
    public void delete(String id);
    public void update(T t);
    public List<T> queryAll();
    public T queryOne(String id);
    //起始条数，每页显示的条数
    public List<T> queryByPage(@Param("start") Integer start, @Param("rows") Integer rows);
    public Long queryTotals();
    public T login( @Param("username")String realname,@Param("password")String password);

}
