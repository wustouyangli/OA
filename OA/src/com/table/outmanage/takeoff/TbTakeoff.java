package com.table.outmanage.takeoff;

import java.sql.Timestamp;


/**
 * TbTakeoff entity. @author MyEclipse Persistence Tools
 */

public class TbTakeoff  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String alias;
     private String name;
     private String department;
     private String content;
     private Timestamp publishTime;
     private Timestamp leaveTime;
     private Timestamp returnTime;
     private String state;


    // Constructors

    /** default constructor */
    public TbTakeoff() {
    }

	/** minimal constructor */
    public TbTakeoff(String alias, Timestamp publishTime, Timestamp leaveTime) {
        this.alias = alias;
        this.publishTime = publishTime;
        this.leaveTime = leaveTime;
    }
    
    /** full constructor */
    public TbTakeoff(String alias, String name, String department, String content, Timestamp publishTime, Timestamp leaveTime, Timestamp returnTime, String state) {
        this.alias = alias;
        this.name = name;
        this.department = department;
        this.content = content;
        this.publishTime = publishTime;
        this.leaveTime = leaveTime;
        this.returnTime = returnTime;
        this.state = state;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlias() {
        return this.alias;
    }
    
    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return this.department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPublishTime() {
        return this.publishTime;
    }
    
    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public Timestamp getLeaveTime() {
        return this.leaveTime;
    }
    
    public void setLeaveTime(Timestamp leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Timestamp getReturnTime() {
        return this.returnTime;
    }
    
    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
 
}