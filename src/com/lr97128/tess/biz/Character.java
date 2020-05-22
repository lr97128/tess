package com.lr97128.tess.biz;

public class Character {
	private int code;
	private String message;
	private Data data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public Character(int code, String message, Data data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	public Character() {
		super();
	}
	@Override
	public String toString() {
		return "Character [code=" + code + ", message=" + message + ", data=" + data + "]";
	}
	
}
