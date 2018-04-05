package com.cncbox.health.dao;

import com.cncbox.health.entity.Activity;
import com.cncbox.health.entity.Article;
import com.cncbox.health.entity.Page;
import com.cncbox.health.entity.Video;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 公共业务Dao
 * Date: 2016/12/29
 * Time: 14:14
 */
public interface CommonDao {

    /**
     * 黑白名单查询
     *
     * @param checkSmartCard 校验是白名单还是黑名单
     * @param smartCard      智能卡号
     * @return
     */
    Page isDisable(Page page, @Param("checkSmartCard") char checkSmartCard, @Param("smartCard") String smartCard);

    /**
     * 获取最新活动
     *
     * @return
     */
    List<Activity> newActivity(Activity activity);

    /**
     * 获取最新背景图片
     *
     * @return
     */
    Page getNewBgImg(Page page);

//--------------------------------------------收藏查询

    /**
     * 收藏前查询数据
     *
     * @return
     */
    Page queryCollectionVideoByVS(@Param("vodId") int vodId, @Param("smarCard") String smarCard);

    /**
     * 文章收藏前查询
     *
     * @param infoId   文章id
     * @param smarCard 智能卡号
     * @return
     */
    Page queryCollectionArticleByIS(@Param("infoId") int infoId, @Param("smarCard") String smarCard);

    /**
     * 根据智能卡查询视频收藏总数
     *
     * @param page      缓存用
     * @param smartCard 智能卡号
     * @return
     */
    Page getCountVideoBySmartCard(Page page, @Param("smartCard")String smartCard);

    /**
     * 根据智能卡查询视频信息
     *
     * @param video     缓存用
     * @param smartCard 智能卡号
     * @param offset    查询起始页
     * @param limit     查询个数
     * @return
     */
    List<Video> getVideoBySmartCard(Video video, @Param("smartCard")String smartCard, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据智能卡查询文章收藏总数
     *
     * @param page      缓存用
     * @param smartCard 智能卡号
     * @return
     */
    Page getCountArticleBySmartCard(Page page, @Param("smartCard")String smartCard);

    /**
     * 根据智能卡查询文章信息
     *
     * @param article     缓存用
     * @param smartCard 智能卡号
     * @param offset    查询起始页
     * @param limit     查询个数
     * @return
     */
    List<Article> getArticleBySmartCard(Article article, @Param("smartCard") String smartCard, @Param("offset") int offset, @Param("limit") int limit);


}
