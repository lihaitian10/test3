package com.cncbox.health.dao;

import com.cncbox.health.entity.Article;
import com.cncbox.health.entity.Page;
import com.cncbox.health.entity.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 搜索功能
 * Date: 2017/1/17
 * Time: 14:08
 */
public interface SearchDao {

    /**
     * 搜索视频获取总数
     *
     * @param page   缓存映射
     * @param values 搜索值
     * @return
     */
    Page getSearchVideoCount(Page page, @Param("values") String values);


    /**
     * 搜索视频
     *
     * @param video  缓存映射
     * @param values 搜索值
     * @return
     */
    List<Video> getSearchVideo(Video video, @Param("values") String values);


    /**
     * 搜索文章，获取总数
     *
     * @param page
     * @param values
     * @return
     */
    Page getSearchArticleCount(Page page, @Param("values") String values);


    /**
     * 搜索文章
     *
     * @param values 搜索值
     * @return
     */
    List<Article> getSearchArticle(Article article, @Param("values") String values);

}
