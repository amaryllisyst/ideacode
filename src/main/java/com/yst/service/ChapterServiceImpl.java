package com.yst.service;

import com.yst.dao.ChapterDAO;
import com.yst.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;
@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDAO chapterDAO;
    @Override
    public void add(Chapter chapter) {
        chapter.setChapterId(UUID.randomUUID().toString());
        chapter.setChapterUploadDate(new Date());
        System.out.println("---------seervice----------"+chapter);
        chapterDAO.insert(chapter);
    }
}
