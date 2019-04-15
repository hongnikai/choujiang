package com.lc.util;

/**
 * User: WZD
 * Date: 2017/12/8
 * Time: 9:35
 */
public class ThiredInfo {

    public static final String WXAppid ="wx05a44686fa761870";
    public static final String WXApiKey ="wwwwingfaccomappgmiaonet20171025";
    public static final String WXMchid ="1490792532";
    public static String WXContractStagePayOrderSyncAddress = "/wzd/sync/WXContractStagePayOrderSyncAddress.action";
    /**
     * 合同确认异步通知 2版本调整,用户同意提交合同预付款,及补充合同.
      */
    public static String WXContractPayOrderSyncAddress = "/wzd/sync/1.0.0.1/WXContractStagePayOrderSyncAddress.action";
    public static String  ALContractPayOrderSyncAddress = "/wzd/sync/1.0.0.1/ALContractStagePayOrderSyncAddress.action"; //阶段验收异步通知地址

    public static String  ALContractStagePayOrderSyncAddress = "/wzd/sync/ALContractStagePayOrderSyncAddress.action"; //阶段验收异步通知地址
    public static final String AliPayPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAljxuqHvbr5zXvVrdAVRyyqe2F2G8terJsmbSIogEBMOkvyUS5jOFf4lelA4QuEjFQoMuyL6zBSa0oME/JEtw3V32dawVqZ+BcZrQyMXtJY2R+fu4iQgaxhBcY6cGnZHQYsJT2PakEqFDSEglpOko9RtLPVTmFebNszu6f0kPlLrvQ3We12RBlivQuMrZN1q8VNjdbrnm8WzELE8iyCSHM7qr4B9dqyBYcGya0hKkjMpbaFuK8i4pPQWEhrULNbrFGLbLeyUWQCfDoVSHcaaediuToxkJIsNRaiw73/Vb1O1afAwOt3wlq9I7grI8JXwdMMeb/mNKq277VowLOWdlnQIDAQAB";
    public static final String ALiAPPID="2017101109245224";
    public static final String ALiAPPPRIVATEKEY="MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDi5oMZgVPDZXMUia63V30rR+E7gyjlCECMhxBCL3WcL8Zx5f9v3ltoIWQIvVljTvEnIkN74wMVO5a+VoAFEjYTezlxA/Lz+fiDTrbxwIr640nBFO3aB121ul6JC5z6Yy2kdUq0JnuLpDXBQSrp1OynzuGVtGGzDvlGACbvuR8peGGI1Gtmc44krR/ayzpl7Is44Cg66uVs0gFASEV8+s8xeDewkMjMw0CI6pSPZ4h0cvCAAOzzfPA/8V2hofAUMat9eHMlIS8EuuPKUjP2jwkWm3KmoEBOO4d2xQ+f2buWepY6/NIQ5fslFWeeJ2BuDcdynx9O0AtC/6y7JznLkhrnAgMBAAECggEBAI9AOUTBAcE7K4yr4EKgWcYZe3m3NPpkW1xdaUZf8EDLaN4/9yUJnWwAqMdbxDOOg3HRkAmHKUsec+13bxvEg5+JDJrtg1XFW8CK0bWPei8rkET2kbQ1MlSpdUXQryrlsstBwgg6w4VGByobmpxGcaMAWivJ1mTV70rijbKLjcD/r0E5v41Zr7QIcfscI5FJl9PKZnCjc8MYQshVc/a7YWjF33NG+l9YJo4ui/jRieX6z159NcbQJpXNcIY2pvhUsQ/ThgaHuAWMPSK1aolyDd94Ak7tqDjFn2oDTnOsDSDN+1kx+8Aya/6ywMaMz5I1q+pRzedZhzMVIMixY96W6gECgYEA8X5KI1CYUZMi2dPmcqCfuEbBceajdx8rVhmhJlXNoRMPY6IRNUF0sU42b5sjDyjPoL0cKKdSiye2ybtOXt4xu70LUY/SfvQSaX13OpjUfok+4UceSxBznDhu1i2/04qSLgkN2d83SYUB1GD7FFectmsYQov+Li0SkYteA929vx8CgYEA8IfPxV5cvV/kt6aVZRbKSvGDIODKRkTdeaZnZF+02fKb29ISZl0Pj/tqIfBStlQfUZWsnEdgj6AfnLAIcqC+JWD3lqGyFlfoaWDve6Zpa1wGoStWdIIzFFQZSlSig5YicQ9mn5SW3BZIo7angfJgDRHWGyuCk/MaUqMZ6Zq00zkCgYBISCSorVbqE8A6stInPSyRW5xLG12SKiIugz1Y3BXQQIQ6rie4aP8kkuR4Q1cbEnwTAIeNI4fxXtG3T/kFLDx2lP7uSr4WgbeBG6y0PUpdFXdctoy6qxHvkHScZtUj3DYk0VD0BXvm5YjGqMB+NjsR3rxELuLFr3f/WFerkJNawQKBgQDZw7vCDwqbkWP7OWBsY1PGwh1b+Oho8hQp/RQCdfvAjru5KtnpvztFufN+wpu/4y1vqbjazGyJ3AiCzYT4crt0D/RYdhBL1k7eiRqIskMjJfACnr/pP6+LKhCzkSiJRbXs8mqQ8/AZVjtxrP6+0XdQneNgOeZAmIouYugk7SHlUQKBgQDO10lq2uOxskL7OESgZBh/T5BTG13tnx990rAcDfDno1ORTC1wUnu20PhdMFPhr5a0mTSq5OkdNQlSYFqBfP8VCh9auDvawKrIMUmamzf9unTB3BF8IJ5Z3VP5xs+DzNm5LO0w/bu6L6n7Pp0TzhG6FwuklrHx4WlLZv8Z1J7sZQ==";

    /**
     * 用户充值
     */
    public static String WXUserBalancePayOrderSyncAddress = "/wzd/sync/WXUserBalancePayOrderSyncAddress.action";
    public static String ALUserBalancePayOrderSyncAddress = "/wzd/sync/ALUserBalancePayOrderSyncAddress.action";

    /**
     * 质保金缴纳
     */
    public static String WXContractQGPaySyncAddress = "/wzd/sync/WXContractQgPaySuccess.action";
    public static String ALContractQGPaySyncAddress = "/wzd/sync/ALContractQgPaySuccess.action";

    /**
     * 商品订单支付
     */
    public static String WXCommodityOrderPaySyncAddress = "";
    public static String ALCommodityOrderPaySyncAddress = "";

}
