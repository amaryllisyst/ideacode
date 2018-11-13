package com.yst.dao;

import com.yst.entity.Cource;

import java.util.List;

public interface CourceDAO extends BasicDAO<Cource> {
    //查询选修功课
    public List<Cource> queryState(String id);
}
