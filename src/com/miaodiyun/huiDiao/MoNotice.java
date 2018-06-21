package com.miaodiyun.huiDiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.miaodiyun.huiDiao.entity.MoNoticeReq;
import com.miaodiyun.huiDiao.entity.MoNoticeResp;

/**
 * 上行短信接口
 * 
 * @ClassName: MoNotice
 * @Description: 上行短信接口
 *
 */
@WebServlet("/moNotice")
public class MoNotice extends HttpServlet
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
		Gson gson = new Gson();
		MoNoticeReq moNoticeReq = gson.fromJson(reqBody.toString(), MoNoticeReq.class);

		// TODO 判断签名是否正确

		// TODO 业务处理。开发者根据自己的需求实现

		// 响应
		MoNoticeResp moNoticeResp = new MoNoticeResp();
		moNoticeResp.setRespCode(RespCode.SUCCESS);
		String respStr = gson.toJson(moNoticeResp);
		System.out.println("返回的数据:" + respStr);

		response.getWriter().write(respStr);
	}
}
