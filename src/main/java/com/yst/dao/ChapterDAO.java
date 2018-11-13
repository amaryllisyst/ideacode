package com.yst.dao;

import com.yst.entity.Chapter;

public interface ChapterDAO extends  BasicDAO<Chapter>{
    public  Long queryCount(String id);
}
