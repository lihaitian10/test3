package com.cncbox.health.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 配置文件工具类
 * Date: 2016/12/30
 * Time: 10:18
 */
public class PropertiesUtils {

    //获取项目背景图片
    public static String resourceAddress = get("resourceAddress");

    //区域码
    public static String areaCode = get("areaCode");

    //redis缓存时间配置
    public static int redisTime = Integer.parseInt(get("cachetime")) * 60;

    //视频页每页显示个数
    public static int videoShowLimt = Integer.parseInt(get("videoShowLimt"));

    //文章页查询每页显示个数
    public static int articleShowLimt = Integer.parseInt(get("articleShowLimt"));

    //文章页查询每页显示个数
    public static int answerShowLimt = Integer.parseInt(get("answerShowLimt"));

    //包视频每页显示个数
    public static int videoPackageShowLimt = Integer.parseInt(get("videoPackageShowLimt"));

    //文章包每页显示个数
    public static int articlePackageShowLimt = Integer.parseInt(get("articlePackageShowLimt"));

    //医生页视频显示个数
    public static int doctorsVideoShowLimt = Integer.parseInt(get("doctorsVideoShowLimt"));

    //查看收藏视频显示数量
    public static int collectionVideoShowLimt = Integer.parseInt(get("collectionVideoShowLimt"));

    //查看收藏文章显示数量
    public static int collectionArticleShowLimt = Integer.parseInt(get("collectionArticleShowLimt"));

    //搜索视频显示个数
    public static int searchVideoShowLimt = Integer.parseInt(get("searchVideoShowLimt"));

    //文章搜索显示个数
    public static int searchArticleShowLimt = Integer.parseInt(get("searchArticleShowLimt"));


    static String get(String getKey) {

        Properties prop = new Properties();
        InputStream input = null;
        try {
            prop.load(PropertiesUtils.class.getResourceAsStream("/config.properties"));
            return prop.getProperty(getKey);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }


}
