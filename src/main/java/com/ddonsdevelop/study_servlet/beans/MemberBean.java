package com.ddonsdevelop.study_servlet.beans;


public class MemberBean {
   protected String firstName;
   protected String secondName;
   protected String handleName;

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) { //setter : 외부에서 접근하는 펑션
		this.firstName = firstName; 
	}

	public String getSecondName() {
		return this.secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getHandleName() {
		return this.handleName;
	}

	public void setHandleName(String handleName) {
		this.handleName = handleName;
	}


}
