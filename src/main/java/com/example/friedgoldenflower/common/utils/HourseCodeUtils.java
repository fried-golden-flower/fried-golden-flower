package com.example.friedgoldenflower.common.utils;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class HourseCodeUtils {
    private HourseCodeUtils() {
    }

    private static long hourseCodeNum;
    private static ConcurrentHashMap<String, Object> hourseMap = new ConcurrentHashMap<>();

    static {
        hourseCodeNum = 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getHourseCode(new Object()));
                }
            }.start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String res = "" + (hourseCodeNum - 1);
                    for (int i = 6 - res.length(); i > 0; i--) {
                        res = "0" + res;
                    }
                    removeHourseCode(res);
                }
            }.start();
        }
    }

    /**
     * 获取六位数房间编码--
     *
     * @return
     */
    public synchronized static String getHourseCode(Object o) {
        if (hourseCodeNum >= 10) {
            hourseCodeNum = 0;
        }
        String res = "" + hourseCodeNum;
        for (int i = 6 - res.length(); i > 0; i--) {
            res = "0" + res;
        }
        hourseCodeNum++;
        if (Objects.isNull(hourseMap.get(res))) {
            hourseMap.put(res, o);
            return res;
        } else {
            return getHourseCode(o);
        }
    }

    /**
     * 移除房间
     *
     * @return
     */
    public synchronized static void removeHourseCode(String hourseCode) {
        hourseMap.remove(hourseCode);
    }

    /**
     * 设置房间
     *
     * @return
     */
    public synchronized static void put(String hourseCode, Object o) {
        hourseMap.put(hourseCode, o);
    }
}
