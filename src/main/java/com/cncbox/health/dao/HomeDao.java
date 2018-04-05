package com.cncbox.health.dao;

import com.cncbox.health.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 首页Dao
 * Date: 2016/12/29
 * Time: 11:25
 */
public interface HomeDao {

    /**
     * 轮播查询
     *
     * @return
     */
    List<Rotation> homeRotation(Rotation rotation);


    /**
     * 首页内容获取
     *
     * @return
     */
    List<Home> homeContent(Home home);


    /**
     * 首页下栏目获取
     *
     * @param selectNumber
     * @return
     */
    List<Section> getSection(Section section, @Param("selectNumber") int selectNumber);


    /**
     * 根据栏目Id查询视频
     *
     * @param levelId 栏目id
     * @return
     */
    List<Video> sebyleid(Video video, @Param("levelId") int levelId);

    /**
     * 根据栏目Id查询视频-获取总数
     *
     * @param levelId 栏目id
     * @return
     */
    Page sebyleidAll(Page page, @Param("levelId") int levelId);

    /**
     * 根据视频id查询视频信息
     *
     * @param video
     * @param selectId
     * @return
     */
    Video seVodIdById(Video video, @Param("selectId") int selectId);

    /**
     * 根据栏目id,查询文章
     *
     * @param seleNumber 查询id
     * @return
     */
    List<Article> getArticleByLeId(Article article, @Param("seleNumber") int seleNumber);

    /**
     * 根据id，查找具体文章内容
     *
     * @param seleNumber
     * @return
     */
    Article getArticleIdById(Article article, @Param("seleNumber") int seleNumber);


    /**
     * 根据栏目id,查询文章总数
     *
     * @param seleNumber 栏目id
     * @return
     */
    Page getCountArticleByLeId(Page page, @Param("seleNumber") int seleNumber);


    /**
     * 根据栏目id,查询答题
     *
     * @param seleNumber 栏目id
     * @param offset     页码
     * @param limit      数量
     * @return
     */
    List<Answer> getAnswerByLeId(Answer answer, @Param("seleNumber") int seleNumber);

    /**
     * 根据栏目id,查询答题总数
     *
     * @param seleNumber
     * @return
     */
    Page getCountAnswerByLeId(Page page, @Param("seleNumber") int seleNumber);


    /**
     * 根据包id，获取答题问题
     *
     * @param answerProblem
     * @param seleNumber
     * @return
     */
    List<AnswerProblem> getAnswerProblem(AnswerProblem answerProblem, @Param("seleNumber") int seleNumber);

    /**
     * 根据包id查询答题答案
     *
     * @param seleNumber 包id
     * @return
     */
    List<AnswerResult> getAnswerResult(AnswerResult answerResult, @Param("seleNumber") int seleNumber);

    /**
     * 根据包id,查询视频内容
     *
     * @param seleNumber 查询id
     * @return
     */
    List<Video> getVideoPackage(Video video, @Param("seleNumber") int seleNumber);

    /**
     * 根据包id,查询视频内容总数
     *
     * @param seleNumber
     * @return
     */
    Page getCountVideoPackage(Page page, @Param("seleNumber") int seleNumber);


    /**
     * 根据首页id,查询文章内容
     *
     * @param article
     * @param seleNumber
     * @return
     */
    List<Article> getArticlePackage(Article article, @Param("seleNumber") int seleNumber);

    /**
     * 根据包id,查询文章内容总数
     *
     * @param seleNumber
     * @return
     */
    Page getCountArticlePackage(Page page, @Param("seleNumber") int seleNumber);


    /**
     * 根据医生id,获取医生信息
     *
     * @param doctorsId 医生id
     * @return
     */
    Doctors getDoctors(Doctors doctors, @Param("doctorsId") int doctorsId);

    /**
     * 根据医生id,获取医生视频
     *
     * @param doctorsId 医生id
     * @return
     */
    List<Video> getDoctorsVideoById(Video video, @Param("doctorsId") int doctorsId);
    
    /**
     * 根据医生id,获取医生视频-总数
     *
     * @param doctorsId
     * @return
     */
    Page getCountDoctorsVideoById(Page page, @Param("doctorsId") int doctorsId);

}
