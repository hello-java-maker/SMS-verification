package com.miaodiyun.huiDiao.entity;

public class ReceNoticeReq
{
	private String smsId;
	private String phone;
	private String status;
	private String respMessage;
	private String receiveTime;
	private String chargingNum;

	public String getSmsId()
	{
		return smsId;
	}

	public void setSmsId(String smsId)
	{
		this.smsId = smsId;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getRespMessage()
	{
		return respMessage;
	}

	public void setRespMessage(String respMessage)
	{
		this.respMessage = respMessage;
	}

	public String getReceiveTime()
	{
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime)
	{
		this.receiveTime = receiveTime;
	}

	public String getChargingNum()
	{
		return chargingNum;
	}

	public void setChargingNum(String chargingNum)
	{
		this.chargingNum = chargingNum;
	}

}
