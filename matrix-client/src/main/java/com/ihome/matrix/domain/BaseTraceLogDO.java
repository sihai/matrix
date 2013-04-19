package com.ihome.matrix.domain;

public class BaseTraceLogDO extends BaseDO {
	
	protected Long		uuid;
	protected UserDO 	user;
	protected String  	remoteIP;

	
	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public UserDO getUser() {
		return user;
	}

	public void setUser(UserDO user) {
		this.user = user;
	}
	
	public String getRemoteIP() {
		return remoteIP;
	}

	public void setRemoteIP(String remoteIP) {
		this.remoteIP = remoteIP;
	}
}
