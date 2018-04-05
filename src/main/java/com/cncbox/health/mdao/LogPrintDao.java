package com.cncbox.health.mdao;

import com.cncbox.health.entity.LogPrintCommon;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 日志打印
 * Date: 2017/2/6
 * Time: 9:46
 */
public interface LogPrintDao {

    /**
     * 日志打印(log_health)表
     *
     * @param logPrintCommon
     * @return
     */
    int insertLogHealth(@Param("logPrintCommon") LogPrintCommon logPrintCommon);

    /**
     * 日志打印(log_health_collect)表
     *
     * @param logPrintCommon
     * @return
     */
    int insertLogHealthCollect(@Param("logPrintCommon") LogPrintCommon logPrintCommon);

    /**
     * 日志打印(log_health_play)表
     *
     * @param logPrintCommon
     * @return
     */
    int insertLogHealthPlay(@Param("logPrintCommon") LogPrintCommon logPrintCommon);

    /**
     * 日志打印(log_health_soso)表
     *
     * @param logPrintCommon
     * @return
     */
    int insertLogHealthSoso(@Param("logPrintCommon") LogPrintCommon logPrintCommon);


}
