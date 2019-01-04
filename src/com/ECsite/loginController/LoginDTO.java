package com.ECsite.loginController;

public class LoginDTO {
	private int UserID;		//識別ID(主キー)
	private String SignID;	//サインインID
	private String Password;	//パスワード
	private String FirstName;	//名前(性)
	private String LastName;	//名前(名)
	private String PostalNum;		//郵便番号
	private String Address;	//住所

	/*
	//初期化メソッド
	public void DAOBean(){
		UserID = 0 ;
		SignID = "";
		Password  = "";
		FirstName  = "" ;
		LastName  = "" ;
		PostalNum  = "" ;
		Address  = "" ;
	}*/

	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getSignID() {
		return SignID;
	}
	public void setSignID(String signID) {
		SignID = signID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getPostalNum() {
		return PostalNum;
	}
	public void setPostalNum(String postalNum) {
		PostalNum = postalNum;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

}
