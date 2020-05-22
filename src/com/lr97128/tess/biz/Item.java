package com.lr97128.tess.biz;

import java.util.Arrays;

public class Item {
	private ItemCoord itemcoord;
	private Word[] words;
	private String itemstring;
	public ItemCoord getItemcoord() {
		return itemcoord;
	}
	public void setItemcoord(ItemCoord itemcoord) {
		this.itemcoord = itemcoord;
	}
	public Word[] getWords() {
		return words;
	}
	public void setWords(Word[] words) {
		this.words = words;
	}
	public String getItemstring() {
		return itemstring;
	}
	public void setItemstring(String itemstring) {
		this.itemstring = itemstring;
	}
	@Override
	public String toString() {
		return "Item [itemcoord=" + itemcoord + ", words=" + Arrays.toString(words) + ", itemstring=" + itemstring
				+ "]";
	}
	
}
