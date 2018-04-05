package com.cncbox.health.service;

import com.cncbox.health.entity.LogPrintCommon;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 日志打印
 * Date: 2017/2/6
 * Time: 10:04
 */
public interface LogPrintService {


    /**
     * log_health 日志表
     *
     * @param logPrintCommon
     * @return
     */
    boolean insertLogHealth(LogPrintCommon logPrintCommon);


    /**
     * log_health_collect 日志表
     *
     * @param logPrintCommon
     * @return
     */
    boolean insertLogHealthCollect(LogPrintCommon logPrintCommon);


    /**
     * log_health_play 日志表
     *
     * @param logPrintCommon
     * @return
     */
    boolean insertlogHealthPlay(LogPrintCommon logPrintCommon);


    /**
     * log_health_soso 日志表
     *
     * @param logPrintCommon
     * @return
     */
    boolean insertLogHealthSoso(LogPrintCommon logPrintCommon);


}
