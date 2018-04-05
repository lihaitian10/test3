package com.cncbox.health.service;

import com.cncbox.health.entity.Activity;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 公共Service接口
 * Date: 2016/12/29
 * Time: 15:06
 */
public interface CommonService {

    /**
     * 是否在黑白名单
     * checkSmartCard 黑白名单控制
     * smartCard      只能卡号
     *
     * @return
     */
    boolean blackwhiteCheck(char checkSmartCard, String smartCard);


    /**
     * 获取最新活动
     *
     * @return
     */
    List<Activity> getNewActivity();


    /**
     * 获取最新背景图片
     *
     * @return
     */
    String getNewBgImg();

}
