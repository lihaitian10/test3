package com.cncbox.health.aop;

import com.cncbox.health.cache.RedisCache;
import com.cncbox.health.entity.Article;
import com.cncbox.health.entity.Rotation;
import com.cncbox.health.entity.Video;
import com.cncbox.health.util.MD5Tools;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 缓存切入
 * Date: 2017/1/6
 * Time: 17:27
 */

/**
 * 如果不使用缓存注释掉即可
 *
 * @Component
 */

//@Component
@Aspect
public class GetCacheAOP {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisCache redisCache;

    /**
     * 收藏操作清除缓存
     *
     * @param joinPoint
     */
    @Before("execution(* com.cncbox.health.mdao.MasterDatabaseDao.insert*(..)) or execution(* com.cncbox.health.mdao.MasterDatabaseDao.delete*(..))")
    public void updateAndDeleteBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String smartCard = "";
        if (joinPoint.getSignature().getName().contains("CollectionVideo")) {
            //因为删除和填加数据类型不统一，需要进行判断
            if (joinPoint.getSignature().getName().contains("delete")) {
                smartCard = (String) args[1];
            } else {
                //获取智能卡号，进行删除缓存
                Video video = (Video) args[0];
                smartCard = video.getEntryType();
            }
            //删除已查询到的数据，根据智能卡号
            redisCache.deleteCacheWithPattern("com.cncbox.health.dao.CommonDao.getVideoBySmartCard|(" + smartCard + "|*");
            //删除已查询到的数据总数
            redisCache.deleteCacheWithPattern("com.cncbox.health.dao.CommonDao.getCountVideoBySmartCard|(" + smartCard + "|*");
        } else if (joinPoint.getSignature().getName().contains("CollectionArticle")) {

            if (joinPoint.getSignature().getName().contains("delete")) {
                smartCard = (String) args[1];
            } else {
                Article article = (Article) args[0];
                smartCard = article.getImage();
            }
            redisCache.deleteCacheWithPattern("com.cncbox.health.dao.CommonDao.getArticleBySmartCard|(" + smartCard + "|*");
            //删除已查询到的数据总数
            redisCache.deleteCacheWithPattern("com.cncbox.health.dao.CommonDao.getCountArticleBySmartCard|(" + smartCard + "|*");
        }

    }

    /**
     * 全局缓存机制处理
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.cncbox.health.dao.*.*(..)) and !(execution(* com.cncbox.health.dao.CommonDao.queryCollection*(..)))")
    public Object selectAround(ProceedingJoinPoint joinPoint) throws Throwable {

        //获取目标方法返回类型
        Signature s = joinPoint.getSignature();
        String returnType = s.toLongString().split(" ")[2].split(" ")[0];

        //redis中key格式
        String redisKey = getCacheKey(joinPoint);

        Object[] args = joinPoint.getArgs();
        Object objectFromRedis = null;
        if (returnType.contains("List")) {
            objectFromRedis = redisCache.getListCache(redisKey, args[0].getClass());
        } else {
            objectFromRedis = redisCache.getCache(redisKey, args[0].getClass());
        }

        //判断是否已查询到数据
        if (null != objectFromRedis) {
            LOG.info("------------------------CacheData------------------------Key :" + redisKey);
            return objectFromRedis;
        }

        //没有查到，那么查询数据库
        Object object = null;
        try {
            object = joinPoint.proceed();
            if (returnType.contains("List")) {
                List al = (List) object;
                if (al == null || al.size() < 1) {
                    return object;
                }
                redisCache.putListCacheWithExpireTime(redisKey, (List<Object>) object, RedisCache.CAHCETIME);
            } else {
                redisCache.putCacheWithExpireTime(redisKey, object, RedisCache.CAHCETIME);
            }

        } catch (Throwable e) {
            e.printStackTrace();
        }
        return object;
    }


    /**
     * 根据类名、方法名和参数值获取唯一的缓存键
     */
    private String getCacheKey(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < args.length; i++) {
            stringBuffer.append(args[i].toString() + "|");
        }
        String method = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "|(" + stringBuffer + ")";
        return method;
        // return MD5Tools.MD5(method);
    }

}
