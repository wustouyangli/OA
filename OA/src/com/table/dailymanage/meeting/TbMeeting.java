package com.table.dailymanage.meeting;

import java.sql.Timestamp;

/**
 * TbMeeting entity. @author MyEclipse Persistence Tools
 */

public class TbMeeting implements java.io.Serializable {

	// Fields

	private Integer id;
	private String host;
	private String publishManAlias;
	private String publishManName;
	private Timestamp publishTime;
	private String subject;
	private Timestamp time;
	private String address;
	private String content;

	// Constructors

	/** default constructor */
	public TbMeeting() {
	}

	/** minimal constructor */
	public TbMeeting(String publishManAlias, Timestamp publishTime, String subject, Timestamp time, String address) {
		this.publishManAlias = publishManAlias;
		this.publishTime = publishTime;
		this.subject = subject;
		this.time = time;
		this.address = address;
	}

	/** full constructor */
	public TbMeeting(String host, String publishManAlias, String publishManName, Timestamp publishTime, String subject,
			Timestamp time, String address, String content) {
		this.host = host;
		this.publishManAlias = publishManAlias;
		this.publishManName = publishManName;
		this.publishTime = publishTime;
		this.subject = subject;
		this.time = time;
		this.address = address;
		this.content = content;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPublishManAlias() {
		return this.publishManAlias;
	}

	public void setPublishManAlias(String publishManAlias) {
		this.publishManAlias = publishManAlias;
	}

	public String getPublishManName() {
		return this.publishManName;
	}

	public void setPublishManName(String publishManName) {
		this.publishManName = publishManName;
	}

	public Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}