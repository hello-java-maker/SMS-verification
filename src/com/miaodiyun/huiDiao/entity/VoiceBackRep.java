package com.miaodiyun.huiDiao.entity;

public class VoiceBackRep
{

	private String callId;// 对应接口返回callSid参数，一路呼叫的唯一标示  32位字符串
	private String called; // 外呼号码
	private String state;// 通话状态  0正常通话 1被叫通话未应答  2外呼失败
	private String callTime;// 通话时长 
	private String DTMFaction;// 用户按键DTMF信息 DTMF验证码内容，为数字长度4-8位
	private String timestamp;
	private String sig;

	public String getCallTime()
	{
		return callTime;
	}

	public void setCallTime(String callTime)
	{
		this.callTime = callTime;
	}

	public String getCallId()
	{
		return callId;
	}

	public void setCallId(String callId)
	{
		this.callId = callId;
	}

	public String getCalled()
	{
		return called;
	}

	public void setCalled(String called)
	{
		this.called = called;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getDTMFaction()
	{
		return DTMFaction;
	}

	public void setDTMFaction(String dTMFaction)
	{
		DTMFaction = dTMFaction;
	}

	public String getTimestamp()
	{
		return timestamp;
	}

	public void setTimestamp(String timestamp)
	{
		this.timestamp = timestamp;
	}

	public String getSig()
	{
		return sig;
	}

	public void setSig(String sig)
	{
		this.sig = sig;
	}

	@Override
	public String toString()
	{
		return "VoiceBackRep [callId=" + callId + ", called=" + called + ", state=" + state + ", callTime=" + callTime
				+ ", DTMFaction=" + DTMFaction + ", timestamp=" + timestamp + ", sig=" + sig + "]";
	}

}
