package com.lc.task;



import com.lc.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.HttpURLConnection;

/**
 *  @描述：测试专用定时器
 ** @author LC
 *  创建时间：2018-3-9 下午15:38
 */
@Component
public class taskTest {

    @Autowired
    private SeckillService seckillService;

/*
                                http://cron.qqe2.com/    在线表达式生成器
*                               0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
                                0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时
                                0 0 12 ? * WED 表示每个星期三中午12点
                                "0 0 12 * * ?" 每天中午12点触发
                                "0 15 10 ? * *" 每天上午10:15触发
                                "0 15 10 * * ?" 每天上午10:15触发
                                "0 15 10 * * ? *" 每天上午10:15触发
                                "0 15 10 * * ? 2005" 2005年的每天上午10:15触发
                                "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发
                                "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发
                                "0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
                                "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发
                                "0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发
                                "0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发
                                "0 15 10 15 * ?" 每月15日上午10:15触发
                                "0 15 10 L * ?" 每月最后一日的上午10:15触发
                                "0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发
                                "0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发
                                "0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发
*
* */


    /**
     * @描述：测试定时器
     * 从16分钟开始， 每1分钟执行一次   //
     * @param
     * @return
     */
    @Scheduled(cron = "0/1 * * * * ? ")   //每秒执行一次
    public void tastTestDemo(HttpServletResponse res, HttpServletRequest request )throws Exception{

        System.out.println("我是一个粉刷匠");
        String str="我是一个粉刷匠，粉刷本领强";
//        PrintWriter pw=res.getWriter();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        pw.print("粉刷费：$1000000");
//        pw.close();


        System.out.println("哈哈哈哈哈哈哈哈哈哈哈哈+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        URL restURL = new URL("http://http://localhost:8080/asd/index.jsp");

        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
        conn.setRequestMethod("POST");
        //设置是否从httpUrlConnection读入，默认情况下是true; httpUrlConnection.setDoInput(true);
        conn.setDoOutput(true);
        //allowUserInteraction 如果为 true，则在允许用户交互（例如弹出一个验证对话框）的上下文中对此 URL 进行检查。
        conn.setAllowUserInteraction(false);



    }


}
