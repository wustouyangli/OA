package com.table.planmanage.enterpriseplan;

import java.sql.Timestamp;

/**
 * TbEnterprisePlan entity. @author MyEclipse Persistence Tools
 */

public class TbEnterprisePlan implements java.io.Serializable {

	// Fields

	private Integer id;
	private String publishManAlias;
	private String publishManName;
	private String subject;
	private Timestamp time;
	private String content;
	private String filename;

	// Constructors

	/** default constructor */
	public TbEnterprisePlan() {
	}

	/** minimal constructor */
	public TbEnterprisePlan(String publishManAlias, String subject, Timestamp time) {
		this.publishManAlias = publishManAlias;
		this.subject = subject;
		this.time = time;
	}

	/** full constructor */
	public TbEnterprisePlan(String publishManAlias, String publishManName, String subject, Timestamp time,
			String content, String filename) {
		this.publishManAlias = publishManAlias;
		this.publishManName = publishManName;
		this.subject = subject;
		this.time = time;
		this.content = content;
		this.filename = filename;
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}