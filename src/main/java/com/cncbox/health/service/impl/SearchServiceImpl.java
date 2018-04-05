package com.cncbox.health.service.impl;

import com.cncbox.health.dao.SearchDao;
import com.cncbox.health.entity.Article;
import com.cncbox.health.entity.Page;
import com.cncbox.health.entity.Video;
import com.cncbox.health.service.SerarchService;
import com.cncbox.health.util.PropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 搜索
 * Date: 2017/1/17
 * Time: 14:34
 */
@Service
public class SearchServiceImpl implements SerarchService {


    @Autowired
    private SearchDao searchDao;

    /**
     * 视频搜索
     *
     * @param values 搜索值
     * @return
     */
    @Override
    public List<Video> getSearchVideo(String values) {
        HashMap<String, Object> resuMap = new HashMap<String, Object>();
        //查询数据
        List<Video> searchVideo = searchDao.getSearchVideo(new Video(), values);
        return searchVideo;
    }

    /**
     * 文章搜索
     *
     * @param values
     * @return
     */
    @Override
    public List<Article> getSearchArticle(String values) {
        HashMap<String, Object> resuMap = new HashMap<String, Object>();
        List<Article> searchArticle = searchDao.getSearchArticle(new Article(), values);
        return searchArticle;
    }
}
