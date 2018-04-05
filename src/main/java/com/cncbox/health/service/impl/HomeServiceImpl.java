package com.cncbox.health.service.impl;

import com.cncbox.health.dao.HomeDao;
import com.cncbox.health.entity.*;
import com.cncbox.health.service.HomeService;
import com.cncbox.health.util.PropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 首页服务层接口实现
 * Date: 2016/12/29
 * Time: 11:16
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeDao homeDao;

    /**
     * 首页数据获取
     *
     * @return
     */
    public HashMap<String, Object> homeList() {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("homeRotationList", homeDao.homeRotation(new Rotation()));
        resultMap.put("homeSectionList", homeDao.homeContent(new Home()));
        return resultMap;
    }

    /**
     * 一、二级栏目获取
     *
     * @param selectNumber
     * @return
     */
    @Override
    public List<Section> getSection(int selectNumber) {
        return homeDao.getSection(new Section(), selectNumber);
    }

    /**
     * 根据视频栏目Id,查询内容
     *
     * @param levelId 查询id
     * @return
     */
    @Override
    public List<Video> queryLeById(int levelId) {
        HashMap<String, Object> resuMap = new HashMap<String, Object>();
        List<Video> cache_video = homeDao.sebyleid(new Video(), levelId);
        return cache_video;

    }

    /**
     * 根据栏目id,查询文章
     *
     * @param selectId
     * @return
     */
    @Override
    public List<Video> queryVodIDById(int selectId) {
        List<Video> retuData = new ArrayList<Video>();
        retuData.add(homeDao.seVodIdById(new Video(), selectId));
        return retuData;
    }

    /**
     * 根据栏目id，查询文章列表
     *
     * @param levelId 查询id
     * @return
     */
    @Override
    public List<Article> queryArticleByLeId(int levelId) {
        //数据查询
        List<Article> articleList = homeDao.getArticleByLeId(new Article(), levelId);

        return articleList;
    }
    
    /**
     * 根据文章id，查询文章列表
     *
     * @param selectId 查询id
     * @return
     */
    @Override
    public List<Article> queryArticleIdById(int selectId) {
    	List<Article> retuData = new ArrayList<Article>();
        //查询缓存中是否存在信息
        retuData.add(homeDao.getArticleIdById(new Article(), selectId));
        return retuData;
    }

    /**
     * 根据id获取，问答内容
     *
     * @param levelId
     * @return
     */
    @Override
    public List<Answer> queryAnswerByLeId(int levelId) {
        HashMap<String, Object> resuMap = new HashMap<String, Object>();
        List<Answer> cache_answer = homeDao.getAnswerByLeId(new Answer(), levelId);
        return cache_answer;
    }

    /**
     * 根据包id，获取答题问题
     *
     * @param seleNumber
     * @return
     */
    @Override
    public List<AnswerProblem> getAnswerProblem(int seleNumber) {
        return homeDao.getAnswerProblem(new AnswerProblem(), seleNumber);
    }

    /**
     * 根据包id，获取答题内容
     *
     * @param seleNumber
     * @return
     */
    @Override
    public List<AnswerResult> getAnswerResult(int seleNumber) {
        return homeDao.getAnswerResult(new AnswerResult(), seleNumber);
    }

    /**
     * 根据首页id，查找视频包内容
     *
     * @param levelId
     * @param offset
     * @return
     */
    @Override
    public List<Video> getVideoPackage(int levelId) {
        HashMap<String, Object> resuMap = new HashMap<String, Object>();
        List<Video> videoData = homeDao.getVideoPackage(new Video(), levelId);
        return videoData;
    }

    /**
     * 根据首页包id，查找视频包内容
     *
     * @param levelId
     * @return
     */
    @Override
    public List<Article> getArticlePackage(int levelId) {
        HashMap<String, Object> resuMap = new HashMap<String, Object>();
        List<Article> articlePackage = homeDao.getArticlePackage(new Article(), levelId);
        return articlePackage;
    }

    /**
     * 根据医生组包id,获取医生相关信息
     *
     * @param doctorsId 医生id
     * @return
     */
    @Override
    public HashMap<String, Object> getDoctorsVideo(int doctorsId) {
        HashMap<String, Object> resuMap = new HashMap<>();
        
        resuMap.put("doctors", homeDao.getDoctors(new Doctors(), doctorsId));
        
        //获取数据
        List<Video> doctorsVideoById = homeDao.getDoctorsVideoById(new Video(), doctorsId);
        if (doctorsVideoById == null) {
            return null;
        }
        resuMap.put("videoData", doctorsVideoById);
        return resuMap;
    }


}
