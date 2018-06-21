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
import com.miaodiyun.huiDiao.entity.ReceNoticeReq;
import com.miaodiyun.huiDiao.entity.ReceNoticeResp;

/**
 * 短信回执推送
 * 
 * @ClassName: ReceNotice
 * @Description: 短信回执推送
 *
 */
@WebServlet("/receNotice")
public class ReceNotice extends HttpServlet
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
		ReceNoticeReq receNoticeReq = gson.fromJson(reqBody.toString(), ReceNoticeReq.class);

		// TODO 业务处理。开发者根据自己的需求实现

		// 响应
		ReceNoticeResp receNoticeResp = new ReceNoticeResp();
		receNoticeResp.setRespCode(RespCode.SUCCESS);
		String respStr = gson.toJson(receNoticeResp);
		System.out.println("返回的数据:" + respStr);

		response.getWriter().write(respStr);
	}

}
