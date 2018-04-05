package com.cncbox.health.web;

import com.cncbox.health.dto.BaseResult;
import com.cncbox.health.entity.Article;
import com.cncbox.health.entity.Video;
import com.cncbox.health.enums.ResultEnum;
import com.cncbox.health.service.SerarchService;
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
 * Features:搜索
 * Date: 2017/1/17
 * Time: 14:48
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SerarchService serarchService;


    /**
     * 视频搜索
     *
     * @param values
     * @return
     */
    @RequestMapping(value = "/video/{values}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> videoSearch(@PathVariable String values) {

        if (values == null) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        try {
        	List<Video> searchVideo = serarchService.getSearchVideo(values);
            if (searchVideo == null || searchVideo.size() < 1) {
                return new BaseResult<Object>(false, ResultEnum.UNSCHEDULED_DATA.getMsg());
            }
            return new BaseResult<Object>(true, searchVideo);
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }

    }


    /**
     * 文章搜索
     *
     * @param values
     * @param offset
     * @return
     */
    @RequestMapping(value = "/article/{values}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> articleSearch(@PathVariable String values) {

        if (values == null) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        try {
        	List<Article> searchArticle = serarchService.getSearchArticle(values);
            if (searchArticle == null || searchArticle.size() < 1) {
                return new BaseResult<Object>(false, ResultEnum.UNSCHEDULED_DATA.getMsg());
            }
            return new BaseResult<Object>(true, searchArticle);
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }

    }


}
