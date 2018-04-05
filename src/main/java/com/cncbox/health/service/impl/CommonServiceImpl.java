package com.cncbox.health.service.impl;

import com.cncbox.health.dao.CommonDao;
import com.cncbox.health.entity.Activity;
import com.cncbox.health.entity.Page;
import com.cncbox.health.service.CommonService;
import com.cncbox.health.util.PropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 公共实现类
 * Date: 2016/12/29
 * Time: 15:07
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonDao commonDao;

    /**
     * 黑白名单校验
     * 黑白名单控制
     * 只能卡号
     *
     * @return
     */
    @Override
    public boolean blackwhiteCheck(char checkSmartCard, String smartCard) {

        Page disable = commonDao.isDisable(new Page(), checkSmartCard, smartCard);
        if (disable.getCountNotes() > 0) {
            return true;
        }
        return false;
    }

    /**
     * 获取最新活动
     *
     * @return
     */
    public List<Activity> getNewActivity() {
        return commonDao.newActivity(new Activity());
    }

    /**
     * 获取最新图片
     *
     * @return
     */
    @Override
    public String getNewBgImg() {

        Page newBgImg = commonDao.getNewBgImg(new Page());
        if (newBgImg == null) {
            return null;
        }
        return newBgImg.getOuthers();
    }
}
