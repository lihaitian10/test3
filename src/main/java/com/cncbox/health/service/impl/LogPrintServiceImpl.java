package com.cncbox.health.service.impl;

import com.cncbox.health.entity.LogPrintCommon;
import com.cncbox.health.mdao.LogPrintDao;
import com.cncbox.health.service.LogPrintService;
import com.cncbox.health.util.PropertiesUtils;
import com.cncbox.health.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 日志表实现类
 * Date: 2017/2/6
 * Time: 10:07
 */
@Service
public class LogPrintServiceImpl implements LogPrintService {

    @Autowired
    private LogPrintDao logPrintDao;

    /**
     * log_health 日志表
     *
     * @param logPrintCommon
     * @return
     */
    @Override
    public boolean insertLogHealth(LogPrintCommon logPrintCommon) {

        //区域码
        logPrintCommon.setAreaCode(PropertiesUtils.areaCode);

        if (0 < logPrintDao.insertLogHealth(logPrintCommon)) {
            return true;
        }
        return false;
    }

    /**
     * log_health_collect 日志表
     *
     * @param logPrintCommon
     * @return
     */
    @Override
    public boolean insertLogHealthCollect(LogPrintCommon logPrintCommon) {

        //区域码
        logPrintCommon.setAreaCode(PropertiesUtils.areaCode);

        if (0 < logPrintDao.insertLogHealthCollect(logPrintCommon)) {
            return true;
        }
        return false;
    }

    /**
     * log_health_play 日志表
     *
     * @param logPrintCommon
     * @return
     */
    @Override
    public boolean insertlogHealthPlay(LogPrintCommon logPrintCommon) {

        //区域码
        logPrintCommon.setAreaCode(PropertiesUtils.areaCode);

        if (0 < logPrintDao.insertLogHealthPlay(logPrintCommon)) {
            return true;
        }
        return false;
    }

    /**
     * log_health_soso 日志表
     *
     * @param logPrintCommon
     * @return
     */
    @Override
    public boolean insertLogHealthSoso(LogPrintCommon logPrintCommon) {

        //区域码
        logPrintCommon.setAreaCode(PropertiesUtils.areaCode);

        if (0 < logPrintDao.insertLogHealthSoso(logPrintCommon)) {
            return true;
        }
        return false;
    }
}
