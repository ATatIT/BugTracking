package com.arth.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users" )
public class UserEntity {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer userId;
		private String firstname;
		private String lastname;
		private String email;
		private String Pass;
		private String gender;
		private String dob;
		private Integer contact;
		private String address;
		private String city;
		private String state;
		private Integer otp;
		
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPass() {
			return Pass;
		}
		public void setPass(String pass) {
			Pass = pass;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public Integer getContact() {
			return contact;
		}
		public void setContact(Integer contact) {
			this.contact = contact;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public Integer getOtp() {
			return otp;
		}
		public void setOtp(Integer otp) {
			this.otp = otp;
		}
		
		
}
