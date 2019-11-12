package com.cg.fms.dto;


	import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
	import javax.persistence.EntityListeners;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.Inheritance;
	import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
	import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

	/**
	 *author: Utkarsh
	 *Description : Employee class 
	 *created Date: 05/11/2019
	 *last modified : 05/11/2019          
	 */
	@Entity
	@EntityListeners(AuditingEntityListener.class)
	@EnableJpaAuditing
	@Audited
	@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
	public class Employee {
		
		@Id
		@GeneratedValue
		@Column(name="employee_id")
		private int employeeId;
		@Column(name="employee_name")
		private String employeeName;
		@Column(name="employee_role")
		private String employeeRole;
		@Column(name="loginname")
		private String loginname;
		@Column(name="user_password")
		private String userPassword;
		@CreatedBy
		protected String createdBy;
		@CreatedDate
		@Temporal(TemporalType.TIMESTAMP)
		protected Date creationDate;
		@LastModifiedBy
		protected String lastModifiedBy;
		@LastModifiedDate
		@Temporal(TemporalType.TIMESTAMP)
		protected Date lastModifiedDate;

		public Employee() {
			super();
		}
		public Employee(int employeeId, String employeeName, String employeeRole, String loginname, String userPassword,
				String emailId, String phoneNumber) {
			super();
			this.employeeId = employeeId;
			this.employeeName = employeeName;
			this.employeeRole = employeeRole;
			this.loginname = loginname;

		}
		public int getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}
		public String getEmployeeName() {
			return employeeName;
		}
		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}
		public String getEmployeeRole() {
			return employeeRole;
		}
		public void setEmployeeRole(String employeeRole) {
			this.employeeRole = employeeRole;
		}
		public String getLoginname() {
			return loginname;
		}
		public void setLoginname(String loginname) {
			this.loginname = loginname;
		}
		public String getUserPassword() {
			return userPassword;
		}
		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}
		
		@Override
		public String toString() {
			return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeRole="
					+ employeeRole + ", loginname=" + loginname + ", userPassword=" + userPassword + "]";
		}
	}


