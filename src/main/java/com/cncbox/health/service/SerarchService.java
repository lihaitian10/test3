package com.cncbox.health.service;

import java.util.HashMap;
import java.util.List;

import com.cncbox.health.entity.Article;
import com.cncbox.health.entity.Video;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 搜索服务层
 * Date: 2017/1/17
 * Time: 14:31
 */
public interface SerarchService {

    /**
     * 视频搜索
     *
     * @param values 搜索值
     * @return
     */
	List<Video> getSearchVideo(String values);

    /**
     * 文章搜索
     * @param values
     * @return
     */
	List<Article> getSearchArticle(String values);
}
