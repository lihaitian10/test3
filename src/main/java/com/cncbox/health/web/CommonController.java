package com.cncbox.health.web;

import com.cncbox.health.dto.BaseResult;
import com.cncbox.health.entity.Activity;
import com.cncbox.health.enums.ResultEnum;
import com.cncbox.health.service.CommonService;
import com.cncbox.health.util.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 公共模块
 * Date: 2016/12/29
 * Time: 13:50
 */
@Controller
@RequestMapping("/sys")
public class CommonController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CommonService commonService;

    /**
     * 黑白名单校验
     *
     * @param checkSmartCard
     * @param smartCard
     * @return
     */
    @RequestMapping(value = "/bwcheck/{checkSmartCard}/{smartCard}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> checkSmartCard(@PathVariable Character checkSmartCard, @PathVariable String smartCard) {
        LOG.info("invoke----------/sys/bwcheck/" + checkSmartCard + "/" + smartCard);
        //参数是否为空校验
        if (checkSmartCard == null || smartCard == null) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }

        //参数准确性判断
        if (checkSmartCard != null || checkSmartCard < -1 || checkSmartCard < 1 || !"".equals(smartCard)) {
            return new BaseResult<Object>(true, commonService.blackwhiteCheck(checkSmartCard, smartCard));
        }
        return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
    }

    /**
     * 获取最新活动
     *
     * @return
     */
    @RequestMapping(value = "/activity/new", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> newActivity() {

        LOG.info("invoke----------/activity/new");
        List<Activity> newActivity = commonService.getNewActivity();
        if (newActivity != null && newActivity.size() > 0) {
            return new BaseResult<Object>(true, newActivity);
        }
        return new BaseResult<Object>(false, ResultEnum.NULL_ACTIVITY.getMsg());
    }


    /**
     * 获取应用背景图片
     *
     * @return
     */
    @RequestMapping(value = "/bgimg/get", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> newBgImg() {

        LOG.info("invoke----------/bgimg/get");
        String newBgImg = commonService.getNewBgImg();
        if (newBgImg != null) {
            return new BaseResult<Object>(true, new StringBuffer(newBgImg));
        }
        return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
    }

    /**
     * 图片文件地址
     */
    @RequestMapping(value = "/resource/get", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> getResourceFile() {
        LOG.info("invoke----------/resource/get");
        List jsonArray = new ArrayList();
        HashMap parMap = new HashMap();
        parMap.put("imagerHttp",PropertiesUtils.resourceAddress);
        jsonArray.add(parMap);
        return new BaseResult<Object>(true, jsonArray);
    }


}
