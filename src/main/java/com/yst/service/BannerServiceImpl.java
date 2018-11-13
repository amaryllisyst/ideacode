package com.yst.service;

import com.yst.dao.BannerDAO;
import com.yst.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDAO bannerDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Banner queryOne(String id) {
        return bannerDAO.queryOne(id);
    }

    @Override
    public Long findTotals() {
        return bannerDAO.queryTotals();
    }

    @Override
    public void add(Banner banner) {
        banner.setBannerDate(new Date());
        banner.setBannerId(UUID.randomUUID().toString());
        System.out.println("---banner------service-----"+banner);
        bannerDAO.insert(banner);
    }

    @Override
    public void remove(String id) {
            bannerDAO.delete(id);
    }

    @Override
    public void modify(Banner banner) {
                bannerDAO.update(banner);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Banner> findByPage(Integer page, Integer rows) {
        //起始页=（当前页-1）*行数
        int start =(page-1)*rows;
        return bannerDAO.queryByPage(start,rows);
    }
}
