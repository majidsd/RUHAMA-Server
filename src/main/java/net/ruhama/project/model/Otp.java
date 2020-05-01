package net.ruhama.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;

import net.ruhama.project.util.OtpStatus;

@Entity
public class Otp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private Integer otp;
	@Column(name = "phone_number", unique = true, nullable = false)
	@Max(value = 999999999)
	private Integer phoneNumber;
	@Column(name = "status")
	private OtpStatus status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOtp() {
		return otp;
	}
	public void setOtp(Integer otp) {
		this.otp = otp;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public OtpStatus getStatus() {
		return status;
	}
	public void setStatus(OtpStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Otp [id=" + id + ", otp=" + otp + ", phoneNumber=" + phoneNumber + ", status=" + status + "]";
	}
	
	
}
