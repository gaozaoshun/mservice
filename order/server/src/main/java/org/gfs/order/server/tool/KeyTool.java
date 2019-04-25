package org.gfs.order.server.tool;

import java.util.Random;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.order.tool
 * @ClassName KeyTool
 * @description
 * @date created in 2019-04-15 17:25
 * @modified by
 */
public final class KeyTool {
    /**
     * 生成唯一Key
     * @return
     */
    public static synchronized String getUniqueKey(){
        Random random = new Random();
        return System.currentTimeMillis()+String.valueOf(random.nextInt(90000)+10000);
    }

    public static void main(String[] args) {
        System.out.println(getUniqueKey());
        Random random = new Random();
        System.out.println(random.nextInt(90000)+10000);
    }
}
