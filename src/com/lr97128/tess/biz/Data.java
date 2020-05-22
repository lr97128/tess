package com.lr97128.tess.biz;

import java.util.Arrays;

public class Data {
	private String[] recognize_warn_msg;
	private int[] recognize_warn_code;
	private Item[] items;
	public String[] getRecognize_warn_msg() {
		return recognize_warn_msg;
	}
	public void setRecognize_warn_msg(String[] recognize_warn_msg) {
		this.recognize_warn_msg = recognize_warn_msg;
	}
	public int[] getRecognize_warn_code() {
		return recognize_warn_code;
	}
	public void setRecognize_warn_code(int[] recognize_warn_code) {
		this.recognize_warn_code = recognize_warn_code;
	}
	public Item[] getItems() {
		return items;
	}
	public void setItems(Item[] items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Data [recognize_warn_msg=" + Arrays.toString(recognize_warn_msg) + ", recognize_warn_code="
				+ Arrays.toString(recognize_warn_code) + ", items=" + Arrays.toString(items) + "]";
	}
	
}
