package com.cncbox.health.web;

import com.cncbox.health.dto.BaseResult;
import com.cncbox.health.entity.Article;
import com.cncbox.health.entity.Video;
import com.cncbox.health.enums.ResultEnum;
import com.cncbox.health.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 收藏
 * Date: 2017/1/11
 * Time: 14:36
 */
@Controller
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    /**
     * 查询视频是否已收藏
     *
     * @param vodId     视频Id
     * @param entryType 智能卡号
     * @return
     */
    @RequestMapping(value = "/video/get/{vodId}/{entryType}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> getVideoIsTrue(@PathVariable Integer vodId, @PathVariable String entryType) {

        if (vodId < 0 || "".equals(entryType)) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        try {
            return new BaseResult<Object>(true, collectionService.queryVideoIsTrue(vodId, entryType));
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }

    }

    /**
     * 收藏视频
     *
     * @param video
     * @return
     * @throws UnsupportedEncodingException 
     */
    @RequestMapping(value = "/video", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> addVideo(Video video)  {
    	
    	
        if (video.getVodId() < 0 || video.getVodName() == null || "".equals(video.getVodName()) || video.getLevelId() < 0 || "".equals(video.getEntryType()) || "".equals(video.getLocalUid())) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }

        try {
        	video.setVodName(new String(video.getVodName().getBytes("iso8859-1"),"utf-8"));
            String resultString = collectionService.addCollectionVideo(video);
            if (resultString == null) {
                return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
            }
            return new BaseResult<Object>(true, new StringBuffer(resultString));
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }

    }

    /**
     * 收藏视频删除
     *
     * @param vodId
     * @param entryType
     * @return
     */
    @RequestMapping(value = "/video/delete/{vodId}/{entryType}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> deleteVideo(@PathVariable Integer vodId, @PathVariable String entryType) {

        if (vodId < 0 || "".equals(entryType)) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        try {
            return new BaseResult<Object>(true, collectionService.deleteCollectionVideo(vodId, entryType));
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }

    }

    /**
     * 查询收藏文章是否存在
     *
     * @param infoId
     * @param smartCard
     * @return
     */
    @RequestMapping(value = "/article/get/{infoId}/{smartCard}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> getArticleIsTrue(@PathVariable Integer infoId, @PathVariable String smartCard) {

        if (infoId < 0 || "".equals(smartCard)) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        try {
            return new BaseResult<Object>(true, collectionService.queryArticleIsTrue(infoId, smartCard));
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }

    }

    /**
     * 收藏文章
     *
     * @param article
     * @return
     */
    @RequestMapping(value = "/article", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> addArticle(Article article, String smartCard, String clientIp) {

        if (article.getInfoId() < 0 || "".equals(article.getInfoName()) || article.getLevelId() < 0 || "".equals(article.getImage()) || "".equals(smartCard) || "".equals(clientIp)) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }

        try {
        	article.setInfoName((new String(article.getInfoName().getBytes("iso8859-1"),"utf-8")));
            //多余字段进行使用
            article.setImage(smartCard);
            article.setInfoContent(clientIp);
            String resultString = collectionService.addCollectionArticle(article);
            if (resultString == null) {
                return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
            }
            return new BaseResult<Object>(true, new StringBuffer(resultString));
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }

    }

    /**
     * 删除收藏文章
     *
     * @param infoId
     * @param smartCard
     * @return
     */
    @RequestMapping(value = "/article/delete/{infoId}/{smartCard}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> deleteArticle(@PathVariable Integer infoId, @PathVariable String smartCard) {

        if (infoId < 0 || "".equals(smartCard)) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        try {
            return new BaseResult<Object>(true, collectionService.deleteCollectionArticle(infoId, smartCard));
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }

    }

    /**
     * 根据智能卡号，查询收藏视频
     *
     * @param smartCard
     * @param offset
     * @return
     */
    @RequestMapping(value = "/get/video/{smartCard}/{offset}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> getVideoBySmartCard(@PathVariable String smartCard, @PathVariable Integer offset) {

        if (smartCard == null || offset == null || offset < 1 || "".equals(smartCard)) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        offset = offset == null ? offset = -1 : offset - 1;
        try {
            HashMap<String, Object> videoPackage = collectionService.getCollectionVideoAllBySmartCard(smartCard, offset);
            if (videoPackage == null || videoPackage.size() < 1) {
                return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
            }
            return new BaseResult<Object>(true, videoPackage);
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }

    }

    /**
     * 根据智能卡号，查询收藏文章
     *
     * @param smartCard
     * @param offset
     * @return
     */
    @RequestMapping(value = "/get/article/{smartCard}/{offset}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> getArticleBySmartCard(@PathVariable String smartCard, @PathVariable Integer offset) {

        if (smartCard == null || offset == null || offset < 1 || "".equals(smartCard)) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        offset = offset == null ? offset = -1 : offset - 1;
        try {
            HashMap<String, Object> articlePackage = collectionService.getCollectionArticleAllBySmartCard(smartCard, offset);
            if (articlePackage == null || articlePackage.size() < 1) {
                return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
            }
            return new BaseResult<Object>(true, articlePackage);
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }
    }


}
