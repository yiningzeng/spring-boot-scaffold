package com.baymin.scaffold.utils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NetState {

    public static void main(String[] args) {

        StreamGobblerCallback.Work work = new StreamGobblerCallback.Work();
        try {
            ShellKit.runShell("ping -w 1 192.168.31.1", work);
//            long now = System.currentTimeMillis();
            while (work.isDoing()){
                Thread.sleep(100);
            }
            log.info("结束"+work.getRes());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
