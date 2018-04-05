package com.cncbox.health.web;

import com.cncbox.health.dto.BaseResult;
import com.cncbox.health.entity.Answer;
import com.cncbox.health.entity.AnswerProblem;
import com.cncbox.health.entity.AnswerResult;
import com.cncbox.health.entity.Article;
import com.cncbox.health.entity.Section;
import com.cncbox.health.entity.Video;
import com.cncbox.health.enums.ResultEnum;
import com.cncbox.health.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 首页控制
 * Date: 2016/12/29
 * Time: 11:14
 */

@Controller
@RequestMapping("/home")
public class HomeController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HomeService homeService;

    /**
     * 首页数据获取
     *
     * @return
     */
    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> homeList() {

        HashMap<String, Object> hash = homeService.homeList();
        if (hash == null) {
            return new BaseResult<Object>(false, ResultEnum.UNSCHEDULED_DATA.getMsg());
        }
        try {
            return new BaseResult<Object>(true, hash);
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }
    }


    /**
     * 一、二级栏目获取
     *
     * @param selectNumber
     * @return
     */
    @RequestMapping(value = "/section/{selectNumber}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> getSection(@PathVariable Integer selectNumber) {

        if (selectNumber == null || selectNumber < 0) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        try {
            List<Section> section = homeService.getSection(selectNumber);
            if (section == null || section.size() < 1) {
                return new BaseResult<Object>(false, ResultEnum.UNSCHEDULED_DATA.getMsg());
            }
            return new BaseResult<Object>(true, section);
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }
    }

    /**
     * 根据视频栏目获取视频
     *
     * @param levelId 栏目id
     * @return
     */
    @RequestMapping(value = "/video/get/{levelId}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> getVideoByLIds(@PathVariable Integer levelId) {
        if (levelId == null) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }

        try {
        	List<Video> cache_video = homeService.queryLeById(levelId);
            if (cache_video == null || cache_video.size() < 1) {
                return new BaseResult<Object>(false, ResultEnum.UNSCHEDULED_DATA.getMsg());
            }
            return new BaseResult<Object>(true, cache_video);
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }
    }

    /**
     * 根据视频id查询视频信息
     *
     * @param selectId
     * @return
     */
    @RequestMapping(value = "/video/getDetails/{selectId}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> getVideoByLId(@PathVariable Integer selectId) {
        if (selectId == null) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        try {
            return new BaseResult<Object>(true, homeService.queryVodIDById(selectId));
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }
    }


    /**
     * 根据栏目id,获取文章内容
     *
     * @param levelId
     * @return
     */
    @RequestMapping(value = "/article/get/{levelId}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> getArticle(@PathVariable Integer levelId) {
        if (levelId == null) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        try {
        	List<Article> articleList = homeService.queryArticleByLeId(levelId);
            if (articleList == null || articleList.size() < 1) {
                return new BaseResult<Object>(false, ResultEnum.UNSCHEDULED_DATA.getMsg());
            }
            return new BaseResult<Object>(true, articleList);
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }
    }
    /**
     * 根据文章id,获取文章内容
     *
     * @param levelId
     * @return
     */
    @RequestMapping(value = "/article/getDetails/{selectId}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> getArticleDetails(@PathVariable Integer selectId) {
        if (selectId == null) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        try {
        	List<Article> stringObjectHashMap = homeService.queryArticleIdById(selectId);
            if (stringObjectHashMap == null || stringObjectHashMap.size() < 1) {
                return new BaseResult<Object>(false, ResultEnum.UNSCHEDULED_DATA.getMsg());
            }
            return new BaseResult<Object>(true, stringObjectHashMap);
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }
    }
    /**
     * 根据栏目id,获取问答内容
     *
     * @param levelId
     * @return
     */
    @RequestMapping(value = "/answer/get/{levelId}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> getAnswer(@PathVariable Integer levelId) {
        if (levelId == null) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        try {
        	List<Answer> cache_answer = homeService.queryAnswerByLeId(levelId);
            if (cache_answer == null || cache_answer.size() < 1) {
                return new BaseResult<Object>(false, ResultEnum.UNSCHEDULED_DATA.getMsg());
            }
            return new BaseResult<Object>(true, cache_answer);
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }

    }


    /**
     * 根据包Id,获取答题问题
     *
     * @param packageId
     * @return
     */
    @RequestMapping(value = "/answer/problem/{packageId}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> getAnswerProblem(@PathVariable Integer packageId) {
        if (packageId == null || packageId <= -1) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }

        try {
            List<AnswerProblem> answerProblem = homeService.getAnswerProblem(packageId);
            if (answerProblem == null || answerProblem.size() < 1) {
                return new BaseResult<Object>(false, ResultEnum.UNSCHEDULED_DATA.getMsg());
            }
            return new BaseResult<Object>(true, answerProblem);
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }

    }


    /**
     * 根据包Id,获取答题答案
     *
     * @param packageId
     * @return
     */
    @RequestMapping(value = "/answer/result/{packageId}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> getAnswerContent(@PathVariable Integer packageId) {
        if (packageId == null || packageId <= -1) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }

        try {
            List<AnswerResult> answerAnswer = homeService.getAnswerResult(packageId);
            if (answerAnswer == null || answerAnswer.size() < 1) {
                return new BaseResult<Object>(false, ResultEnum.UNSCHEDULED_DATA.getMsg());
            }
            return new BaseResult<Object>(true, answerAnswer);
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }

    }


    /**
     * 视频包
     *
     * @param packageId 包id
     * @return
     */
    @RequestMapping(value = "/video/package/{packageId}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> videoPackage(@PathVariable Integer packageId) {
        if (packageId == null || packageId <= -1 ) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        try {
        	List<Video> videoData = homeService.getVideoPackage(packageId);
            if (videoData == null || videoData.size() < 1) {
                return new BaseResult<Object>(false, ResultEnum.UNSCHEDULED_DATA.getMsg());
            }
            return new BaseResult<Object>(true, videoData);
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }

    }

    /**
     * 文章包
     *
     * @param packageId 包id
     * @return
     */
    @RequestMapping(value = "/article/package/{packageId}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> articlePackage(@PathVariable Integer packageId) {
        if (packageId == null  || packageId <= -1 ) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        try {
        	List<Article> articlePackage = homeService.getArticlePackage(packageId);
            if (articlePackage == null || articlePackage.size() < 1) {
                return new BaseResult<Object>(false, ResultEnum.UNSCHEDULED_DATA.getMsg());
            }
            return new BaseResult<Object>(true, articlePackage);
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }

    }

    /**
     * 医生信息及视频获取
     *
     * @param doctorsId
     * @return
     */
    @RequestMapping(value = "/doctors/{doctorsId}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> getDoctors(@PathVariable Integer doctorsId) {
        if (doctorsId == null  || doctorsId <= -1 ) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        try {
            HashMap<String, Object> doctorsVideo = homeService.getDoctorsVideo(doctorsId);
            if (doctorsVideo == null || doctorsVideo.size() < 1) {
                return new BaseResult<Object>(false, ResultEnum.UNSCHEDULED_DATA.getMsg());
            }
            return new BaseResult<Object>(true, doctorsVideo);
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }

    }


}
