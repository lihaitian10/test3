package com.cncbox.health.service.impl;

import com.cncbox.health.dao.CommonDao;
import com.cncbox.health.entity.Article;
import com.cncbox.health.entity.Page;
import com.cncbox.health.entity.Video;
import com.cncbox.health.enums.ResultEnum;
import com.cncbox.health.mdao.MasterDatabaseDao;
import com.cncbox.health.service.CollectionService;
import com.cncbox.health.util.PropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features:功能介绍
 * Date: 2017/1/12
 * Time: 9:06
 */
@Service
public class CollectionServiceImpl implements CollectionService {


    //操作主数据库
    @Autowired
    private MasterDatabaseDao masterDatabaseDao;

    //进行从数据库查询
    @Autowired
    private CommonDao commonDao;

    /**
     * 查询视频是否存在
     *
     * @param vodId
     * @param entryType
     * @return
     */
    @Override
    public int queryVideoIsTrue(int vodId, String entryType) {

        //查询数据库中是否存在
        Page page = commonDao.queryCollectionVideoByVS(vodId, entryType);
        if (null != page && 0 < page.getCountNotes()) {
            return 1;
        }
        return 0;
    }

    /**
     * 视频收藏
     *
     * @param video
     * @return
     */
    @Override
    @Transactional
    public String addCollectionVideo(Video video) {

        //查询数据库中是否存在
        Page page = commonDao.queryCollectionVideoByVS(video.getVodId(), video.getEntryType());
        if (null != page && 0 < page.getCountNotes()) {
            return ResultEnum.DATA_EXIST.getMsg();
        }
        int i = masterDatabaseDao.insertCollectionVideo(video);
        if (i > 0) {
            return ResultEnum.SUCCESSFUL_OPERATION.getMsg();
        }
        return null;
    }

    /**
     * 删除收藏视频
     *
     * @param vodId    视频id
     * @param smarCard 智能卡号
     * @return
     */
    @Override
    @Transactional
    public boolean deleteCollectionVideo(int vodId, String smarCard) {
        int i = masterDatabaseDao.deleteCollectionVideoByVS(vodId, smarCard);

        if (i > 0) {
            return true;
        }
        return false;
    }

    /**
     * 查询文章是否存在
     *
     * @param infoId   文章id
     * @param smarCard 智能卡号
     * @return
     */
    @Override
    public int queryArticleIsTrue(int infoId, String smarCard) {

        Page page = commonDao.queryCollectionArticleByIS(infoId, smarCard);

        if (null != page && 0 < page.getCountNotes()) {
            return 1;
        }
        return 0;
    }

    /**
     * 文章收藏
     *
     * @param article
     * @return
     */
    @Override
    @Transactional
    public String addCollectionArticle(Article article) {

        //查询数据库中是否存在
        Page page = commonDao.queryCollectionArticleByIS(article.getInfoId(), article.getImage());
        if (null != page && 0 < page.getCountNotes()) {
            return ResultEnum.DATA_EXIST.getMsg();
        }

        int i = masterDatabaseDao.insertCollectionArticle(article);
        if (i > 0) {
            return ResultEnum.SUCCESSFUL_OPERATION.getMsg();
        }
        return null;
    }

    /**
     * 删除文章
     *
     * @param infoId
     * @param smarCard
     * @return
     */
    @Override
    @Transactional
    public boolean deleteCollectionArticle(int infoId, String smarCard) {
        int i = masterDatabaseDao.deleteCollectionArticleByVS(infoId, smarCard);

        if (i > 0) {
            return true;
        }
        return false;
    }

    /**
     * 根据机顶盒号查询视频收藏
     *
     * @param smartCard 智能卡号
     * @param offset
     * @return
     */
    @Override
    public HashMap<String, Object> getCollectionVideoAllBySmartCard(String smartCard, int offset) {
        HashMap<String, Object> resuMap = new HashMap<String, Object>();
        List<Video> videoBySmartCard = commonDao.getVideoBySmartCard(new Video(), smartCard, offset * PropertiesUtils.collectionVideoShowLimt, PropertiesUtils.collectionVideoShowLimt);
        Page countVideoBySmartCard = commonDao.getCountVideoBySmartCard(new Page(), smartCard);
        countVideoBySmartCard.setTotalPages((countVideoBySmartCard.getCountNotes() % PropertiesUtils.collectionVideoShowLimt == 0) ? countVideoBySmartCard.getCountNotes() / PropertiesUtils.collectionVideoShowLimt : (countVideoBySmartCard.getCountNotes() / PropertiesUtils.collectionVideoShowLimt) + 1);
        countVideoBySmartCard.setThisPage(offset + 1);
        resuMap.put("collData", videoBySmartCard);
        resuMap.put("pageData", countVideoBySmartCard);
        return resuMap;
    }

    /**
     * 根据机顶盒号查询文章收藏
     *
     * @param smartCard
     * @param offset
     * @return
     */
    @Override
    public HashMap<String, Object> getCollectionArticleAllBySmartCard(String smartCard, int offset) {
        HashMap<String, Object> resuMap = new HashMap<String, Object>();
        List<Article> articleBySmartCard = commonDao.getArticleBySmartCard(new Article(), smartCard, offset * PropertiesUtils.collectionArticleShowLimt, PropertiesUtils.collectionArticleShowLimt);
        Page countArticleBySmartCard = commonDao.getCountArticleBySmartCard(new Page(), smartCard);
        countArticleBySmartCard.setTotalPages((countArticleBySmartCard.getCountNotes() % PropertiesUtils.collectionArticleShowLimt == 0) ? countArticleBySmartCard.getCountNotes() / PropertiesUtils.collectionArticleShowLimt : (countArticleBySmartCard.getCountNotes() / PropertiesUtils.collectionArticleShowLimt) + 1);
        countArticleBySmartCard.setThisPage(offset + 1);
        resuMap.put("collData", articleBySmartCard);
        resuMap.put("pageData", countArticleBySmartCard);
        return resuMap;
    }


}
