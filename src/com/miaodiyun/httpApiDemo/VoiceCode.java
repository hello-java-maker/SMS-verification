package com.miaodiyun.httpApiDemo;

import com.miaodiyun.httpApiDemo.common.Config;
import com.miaodiyun.httpApiDemo.common.HttpUtil;

/**
 * 语音验证码接口
 * 
 * @ClassName: VoiceCode
 * @Description: 语音验证码接口
 *
 */
public class VoiceCode
{
	private static String operation = "/call/voiceCode";

	private static String accountSid = Config.ACCOUNT_SID;
	private static String verifyCode = "5678";
	private static String called = "1361305****";
	private static String callDisplayNumber = "";
	private static String playTimes = "2";
	private static String respUrl = "";

	/**
	 * 语音验证码
	 */
	public static void execute()
	{
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&verifyCode=" + verifyCode + "&called=" + called
				+ "&callDisplayNumber=" + callDisplayNumber + "&playTimes=" + playTimes + "&respUrl=" + respUrl
				+ HttpUtil.createCommonParam();

		// 提交请求
		String result = HttpUtil.post(url, body);
		System.out.println("result:" + System.lineSeparator() + result);
	}
}
