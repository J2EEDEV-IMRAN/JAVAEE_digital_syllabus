package com.example.j2eeapp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import com.example.j2eeapp.commons.domain.BaseEntity;

/**
 * Entity to hold application user data - first name, last name, etc.
 * 
 * @author Arthur Vin
 */
@Entity
@Table(name="appuser")
public class UserEntity extends BaseEntity {
	private static final long serialVersionUID = -8789920463809744548L;

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	@OneToMany(mappedBy="userEntity",cascade=CascadeType.ALL)
	private List<CoursesEntity> coursesEntity;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		PasswordEncoder crypto = new Md5PasswordEncoder();
		this.password = crypto.encodePassword(password, null);
	}

	public List<CoursesEntity> getCoursesEntity() {
		return coursesEntity;
	}

	public void setCoursesEntity(List<CoursesEntity> coursesEntity) {
		this.coursesEntity = coursesEntity;
	}


	
}
