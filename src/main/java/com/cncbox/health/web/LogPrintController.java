package com.cncbox.health.web;

import com.cncbox.health.dto.BaseResult;
import com.cncbox.health.entity.LogPrintCommon;
import com.cncbox.health.enums.ResultEnum;
import com.cncbox.health.service.LogPrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features:功能介绍
 * Date: 2017/2/6
 * Time: 10:20
 */
@Controller
@RequestMapping("/log")
public class LogPrintController {

    @Autowired
    private LogPrintService logPrintService;

    /**
     * 对 “log_health” 表进行数据的填加
     *
     * @param logPrintCommon
     * @return
     */
    @RequestMapping(value = "/common", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> logHealth(LogPrintCommon logPrintCommon) {

        //参数是否为空校验
        if (logPrintCommon == null || null == logPrintCommon.getSmartCard() || null == logPrintCommon.getClientIp()) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        try {
            return new BaseResult<Object>(true, logPrintService.insertLogHealth(logPrintCommon));
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }
    }

    /**
     * 对 “log_health_collect” 表进行数据的填加
     *
     * @param logPrintCommon
     * @return
     */
    @RequestMapping(value = "/collect", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> logHealthCollect(LogPrintCommon logPrintCommon) {

        //参数是否为空校验
        if (logPrintCommon == null || null == logPrintCommon.getSmartCard() || null == logPrintCommon.getClientIp()) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        try {
            return new BaseResult<Object>(true, logPrintService.insertLogHealthCollect(logPrintCommon));
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }
    }


    /**
     * 对 “log_health_play” 表进行数据的填加
     *
     * @param logPrintCommon
     * @return
     */
    @RequestMapping(value = "/play", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> logHealthPlay(LogPrintCommon logPrintCommon) {

        //参数是否为空校验
        if (logPrintCommon == null || null == logPrintCommon.getSmartCard() || null == logPrintCommon.getClientIp()) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        try {
            return new BaseResult<Object>(true, logPrintService.insertlogHealthPlay(logPrintCommon));
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }
    }


    /**
     * 对 “log_health_collect” 表进行数据的填加
     *
     * @param logPrintCommon
     * @return
     */
    @RequestMapping(value = "/search", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> logHealthSoso(LogPrintCommon logPrintCommon) {

        //参数是否为空校验
        if (logPrintCommon == null || null == logPrintCommon.getSmartCard() || null == logPrintCommon.getClientIp()) {
            return new BaseResult<Object>(false, ResultEnum.PARAMRTER_ERROR.getMsg());
        }
        try {
            return new BaseResult<Object>(true, logPrintService.insertLogHealthSoso(logPrintCommon));
        } catch (Exception e) {
            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
        }
    }


}
