package com.cncbox.health.service;

import com.cncbox.health.entity.Article;
import com.cncbox.health.entity.Video;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 收藏
 * Date: 2017/1/12
 * Time: 9:05
 */
public interface CollectionService {

    /**
     * 查询视频是否存在
     *
     * @param vodId
     * @param entryType
     * @return
     */
    int queryVideoIsTrue(int vodId, String entryType);

    /**
     * 视频收藏
     *
     * @param video
     * @return
     */
    String addCollectionVideo(Video video);

    /**
     * 删除收藏视频
     *
     * @param vodId     视频id
     * @param entryType 智能卡号
     * @return
     */
    boolean deleteCollectionVideo(int vodId, String entryType);

    /**
     * 查询文章是否存在
     *
     * @param infoId   文章id
     * @param smarCard 智能卡号
     * @return
     */
    int queryArticleIsTrue(int infoId, String smarCard);

    /**
     * 文章收藏
     *
     * @param article
     * @return
     */
    String addCollectionArticle(Article article);


    /**
     * 删除文章
     *
     * @param infoId
     * @param smarCard
     * @return
     */
    boolean deleteCollectionArticle(int infoId, String smarCard);


    /**
     * 根据机顶盒号查询视频收藏
     *
     * @param smartCard 智能卡号
     * @param offset
     * @return
     */
    HashMap<String, Object> getCollectionVideoAllBySmartCard(String smartCard, int offset);


    /**
     * 根据机顶盒号查询文章收藏
     *
     * @param smartCard
     * @param offset
     * @return
     */
    HashMap<String, Object> getCollectionArticleAllBySmartCard(String smartCard, int offset);

}
