package com.ssh.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 员工实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_emp")
public class Emp {
	private int eno;
	private String ename;
	private int eage;
	private int esex;
	private String ehobby;
	private Date eintime;
	
	//多个员工对应一个部门
	private Dept dept;
	
	public Emp() {
		super();
	}
	
	public Emp(int eno, String ename, int eage, int esex, String ehobby, Date eintime, Dept dept) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.eage = eage;
		this.esex = esex;
		this.ehobby = ehobby;
		this.eintime = eintime;
		this.dept = dept;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getEage() {
		return eage;
	}

	public void setEage(int eage) {
		this.eage = eage;
	}

	public int getEsex() {
		return esex;
	}

	public void setEsex(int esex) {
		this.esex = esex;
	}

	public String getEhobby() {
		return ehobby;
	}

	public void setEhobby(String ehobby) {
		this.ehobby = ehobby;
	}

	public Date getEintime() {
		return eintime;
	}

	public void setEintime(Date eintime) {
		this.eintime = eintime;
	}
	//配置多对一映射关系
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.EAGER)
	@JoinColumn(name="edno")
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
}