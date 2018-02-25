package com.table.dailymanage.notice;

import java.sql.Timestamp;

/**
 * TbNotice entity. @author MyEclipse Persistence Tools
 */

public class TbNotice implements java.io.Serializable {

	// Fields

	private Integer id;
	private String publishManAlias;
	private String publishManName;
	private Timestamp publishTime;
	private String subject;
	private String content;

	// Constructors

	/** default constructor */
	public TbNotice() {
	}

	/** minimal constructor */
	public TbNotice(String publishManAlias, Timestamp publishTime, String subject) {
		this.publishManAlias = publishManAlias;
		this.publishTime = publishTime;
		this.subject = subject;
	}

	/** full constructor */
	public TbNotice(String publishManAlias, String publishManName, Timestamp publishTime, String subject,
			String content) {
		this.publishManAlias = publishManAlias;
		this.publishManName = publishManName;
		this.publishTime = publishTime;
		this.subject = subject;
		this.content = content;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}