package com.yst.service;

import com.yst.entity.Banner;

import java.util.List;

public interface BannerService  {
    public void add(Banner banner);
    public void remove(String id);
    public void modify(Banner banner);
    public List<Banner> findByPage(Integer page,Integer rows);
    public Long findTotals();
    public Banner queryOne(String id);
}
