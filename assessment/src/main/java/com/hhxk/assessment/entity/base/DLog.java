package com.hhxk.assessment.entity.base;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "d_log")
public class DLog {
	private static final long serialVersionUID = 7381630139709568070L;
	
	public static class LogTypes {
		public static final String login = "login";
		public static final String system = "system";
		public static final String config = "config";
		public static final String resource = "resource";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "log_id")
	private int logId;

	@Column(name = "log_type")
	private String logType;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "ip")
	private String ip;

	@Column(name = "op_desc")
	private String opDesc;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "ext_info")
	private String extInfo;

	public DLog() {}

	public DLog(String logType, int userId, String ip, String opDesc, String extInfo) {
		this.setLogType(logType);
		this.setUserId(userId);
		this.setIp(ip);
		this.setOpDesc(opDesc);
		this.setCreateTime(new Date());
		this.setExtInfo(extInfo);
	}
	
	public int getLogId() {
		return logId;
	}

	public void setLogId(int value) {
		logId = value;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String value) {
		logType = value;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int value) {
		userId = value;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String value) {
		ip = value;
	}

	public String getOpDesc() {
		return opDesc;
	}

	public void setOpDesc(String value) {
		opDesc = value;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date value) {
		createTime = value;
	}

	public String getExtInfo() {
		return extInfo;
	}

	public void setExtInfo(String value) {
		extInfo = value;
	}

}
