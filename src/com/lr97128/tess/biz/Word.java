package com.lr97128.tess.biz;

public class Word {
	private String character;
	private double confidence;
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public double getConfidence() {
		return confidence;
	}
	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}
	@Override
	public String toString() {
		return "Word [character=" + character + ", confidence=" + confidence + "]";
	}
	
}
