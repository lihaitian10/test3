package com.cncbox.health.service;

import com.cncbox.health.entity.Answer;
import com.cncbox.health.entity.AnswerProblem;
import com.cncbox.health.entity.AnswerResult;
import com.cncbox.health.entity.Article;
import com.cncbox.health.entity.Section;
import com.cncbox.health.entity.Video;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 首页服务层接口
 * Date: 2016/12/29
 * Time: 11:16
 */
public interface HomeService {


    /**
     * 首页查询
     *
     * @return
     */
    HashMap<String, Object> homeList();


    /**
     * 一、二级栏目获取
     *
     * @param selectNumber
     * @return
     */
    List<Section> getSection(int selectNumber);


    /**
     * 根据视频栏目Id,查询视频列表
     *
     * @param levelId 查询id
     * @return
     */
    List<Video> queryLeById(int levelId);

    /**
     * 根据栏目id,查询文章
     *
     * @param selectId
     * @return
     */
    List<Video> queryVodIDById(int selectId);

    /**
     * 根据栏目id，查询文章列表
     *
     * @param levelId 查询id
     * @return
     */
    List<Article> queryArticleByLeId(int levelId);
    
    /**
     * 根据文章id，查询文章列表
     *
     * @param selectId 查询id
     * @return
     */
    List<Article> queryArticleIdById(int selectId);

    /**
     * 根据id获取，问答内容
     *
     * @param levelId
     * @return
     */
    List<Answer> queryAnswerByLeId(int levelId);


    /**
     * 根据包id，获取答题问题
     *
     * @param seleNumber
     * @return
     */
    List<AnswerProblem> getAnswerProblem(int seleNumber);

    /**
     * 根据包id，获取答题答案
     *
     * @param seleNumber
     * @return
     */
    List<AnswerResult> getAnswerResult(int seleNumber);

    /**
     * 根据首页包id，查找视频包内容
     *
     * @param levelId
     * @return
     */
    List<Video> getVideoPackage(int levelId);

    /**
     * 根据首页包id，查找视频包内容
     *
     * @param levelId
     * @return
     */
    List<Article> getArticlePackage(int levelId);


    /**
     * 根据医生id,获取医生相关信息
     *
     * @param doctorsId 医生id
     * @return
     */
    HashMap<String, Object> getDoctorsVideo(int doctorsId);

}
