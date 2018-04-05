package com.cncbox.health.mdao;

import com.cncbox.health.entity.Article;
import com.cncbox.health.entity.Page;
import com.cncbox.health.entity.Video;
import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 收藏
 * Date: 2017/1/6
 * Time: 11:30
 */
public interface MasterDatabaseDao {

    /**
     * 视频收藏插入数据
     *
     * @param video
     * @return
     */
    int insertCollectionVideo(Video video);

    /**
     * 删除收藏视频
     *
     * @param vodId    视频id
     * @param smarCard 只能卡号
     * @return
     */
    int deleteCollectionVideoByVS(@Param("vodId") int vodId, @Param("smarCard") String smarCard);

    /**
     * 文章收藏
     *
     * @param article
     * @return
     */
    int insertCollectionArticle(@Param("article") Article article);


    /**
     * 删除收藏文章
     *
     * @param infoId
     * @param smarCard
     * @return
     */
    int deleteCollectionArticleByVS(@Param("infoId") int infoId, @Param("smarCard") String smarCard);


}
