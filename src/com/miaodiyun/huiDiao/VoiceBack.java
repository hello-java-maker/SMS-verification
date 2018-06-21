package com.miaodiyun.huiDiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.miaodiyun.httpApiDemo.common.Config;
import com.miaodiyun.huiDiao.entity.VoiceBackRep;
import com.miaodiyun.huiDiao.entity.VoiceBackResp;

/**
 * 语音验证码状态通知接口
 * 
 * @ClassName: VoiceBack
 * @Description: 语音验证码状态通知接口
 *
 */
@WebServlet("/voiceBack")
public class VoiceBack extends HttpServlet
{

	private static final long serialVersionUID = -2119868200097964820L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 获取请求参数
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String str = null;
		StringBuffer reqBody = new StringBuffer();
		while ((str = reader.readLine()) != null)
		{
			reqBody.append(str);
		}
		System.out.println("收到请求：" + reqBody);

		// 将数据注入对应的bean
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		VoiceBackRep voiceCallback = gson.fromJson(reqBody.toString(), VoiceBackRep.class);

		// 判断签名是否正确
		String sig = DigestUtils.md5Hex(Config.ACCOUNT_SID + Config.AUTH_TOKEN + voiceCallback.getTimestamp());
		if (sig.equals(voiceCallback.getSig()))
		{
			System.out.println("签名正确。");
		} else
		{
			System.out.println("签名错误。");
			VoiceBackResp voiceCallbackResp = new VoiceBackResp();
			voiceCallbackResp.setRespCode(RespCode.SIGN_ERROR);
			String respStr = gson.toJson(voiceCallbackResp);
			System.out.println("返回的数据:" + respStr);
			response.getWriter().write(respStr);
			return;
		}

		// TODO 通过callId判断是否重复通知

		// TODO 业务处理。开发者根据自己的需求实现

		// 响应
		VoiceBackResp voiceCallbackResp = new VoiceBackResp();
		voiceCallbackResp.setRespCode(RespCode.SUCCESS);
		String respStr = gson.toJson(voiceCallbackResp);
		System.out.println("返回的数据:" + respStr);

		response.getWriter().write(respStr);
	}

}
