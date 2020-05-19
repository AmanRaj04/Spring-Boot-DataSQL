package io.amanproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Response {

	@Id
	@GeneratedValue
	private long num;
	@NotNull
	@NotBlank
	private String yourname;
	@NotNull
	@NotBlank
	@Column(length=10000)
	private String answer;
	
	@ManyToOne
	@JoinColumn(name="USER_EMAIL")
	private User user;
	
	
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getYourname() {
		return yourname;
	}
	public void setYourname(String yourname) {
		this.yourname = yourname;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Response(long num, String yourname, String answer, User user) {
		this.num = num;
		this.yourname = yourname;
		this.answer = answer;
		this.user = user;
	}
	public Response(String yourname, String answer) {
		this.yourname = yourname;
		this.answer = answer;
	}
	public Response(String yourname, String answer, String email) {
		this.yourname = yourname;
		this.answer = answer;
		this.user=new User(email,"","");
	}
	public Response() {}
}
