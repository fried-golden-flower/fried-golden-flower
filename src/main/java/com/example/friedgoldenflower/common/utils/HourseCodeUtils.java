package com.example.friedgoldenflower.common.utils;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class HourseCodeUtils {

    private HourseCodeUtils(){
    }

    private static long hourseCodeNum;
    private static ConcurrentHashMap<String,Object> hourseMap = new ConcurrentHashMap<>();
    static{
        hourseCodeNum = 0;
    }
    /**
     * 获取六位数房间编码--
     * @return
     */
    public synchronized static String getHourseCode(Object o){
        if (hourseCodeNum >=1000000){
            hourseCodeNum = 0;
        }
        String res = "" + hourseCodeNum /100000 + hourseCodeNum /10000 + hourseCodeNum /1000 + hourseCodeNum /100 + hourseCodeNum /10 + hourseCodeNum %10;
        hourseCodeNum++;
        if (Objects.isNull(hourseMap.get(hourseCodeNum))){
            hourseMap.put(res,o);
            return res;
        }else {
            return getHourseCode(o);
        }
    }
    /**
     * 移除房间
     * @return
     */
    public synchronized static void removeHourseCode(String hourseCode){
        hourseMap.remove(hourseCode);
    }
}
