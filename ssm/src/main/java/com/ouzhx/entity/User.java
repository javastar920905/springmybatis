package com.ouzhx.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ouzhx
 * @since 2017-07-03
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

	private String id;
	private String username;
	private String password;
	private String nickname;
	private Integer age;
	private Integer sex;
	private String email;
	private String mobile;
	private String address;
    /**
     * 用邮箱找回密码的验证
     */
	@TableField("active_validate_code")
	private String activeValidateCode;
	private Integer enabled;
	@TableField("created_date")
	private Date createdDate;
	@TableField("created_by")
	private String createdBy;
	@TableField("modified_date")
	private Date modifiedDate;
	@TableField("modified_by")
	private String modifiedBy;
	@TableField("last_login_time")
	private Date lastLoginTime;
	@TableField("forget_password")
	private String forgetPassword;
	private String residence;
	@TableField("current_residence")
	private String currentResidence;
	@TableField("work_experience")
	private String workExperience;
	private Date birthday;
	private String salt;
	@TableField("job_wanted_status")
	private Integer jobWantedStatus;
	@TableField("talent_id")
	private String talentId;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getActiveValidateCode() {
		return activeValidateCode;
	}

	public void setActiveValidateCode(String activeValidateCode) {
		this.activeValidateCode = activeValidateCode;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getForgetPassword() {
		return forgetPassword;
	}

	public void setForgetPassword(String forgetPassword) {
		this.forgetPassword = forgetPassword;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getCurrentResidence() {
		return currentResidence;
	}

	public void setCurrentResidence(String currentResidence) {
		this.currentResidence = currentResidence;
	}

	public String getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getJobWantedStatus() {
		return jobWantedStatus;
	}

	public void setJobWantedStatus(Integer jobWantedStatus) {
		this.jobWantedStatus = jobWantedStatus;
	}

	public String getTalentId() {
		return talentId;
	}

	public void setTalentId(String talentId) {
		this.talentId = talentId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", username=" + username +
			", password=" + password +
			", nickname=" + nickname +
			", age=" + age +
			", sex=" + sex +
			", email=" + email +
			", mobile=" + mobile +
			", address=" + address +
			", activeValidateCode=" + activeValidateCode +
			", enabled=" + enabled +
			", createdDate=" + createdDate +
			", createdBy=" + createdBy +
			", modifiedDate=" + modifiedDate +
			", modifiedBy=" + modifiedBy +
			", lastLoginTime=" + lastLoginTime +
			", forgetPassword=" + forgetPassword +
			", residence=" + residence +
			", currentResidence=" + currentResidence +
			", workExperience=" + workExperience +
			", birthday=" + birthday +
			", salt=" + salt +
			", jobWantedStatus=" + jobWantedStatus +
			", talentId=" + talentId +
			"}";
	}
}
