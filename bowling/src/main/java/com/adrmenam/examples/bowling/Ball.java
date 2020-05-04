package com.adrmenam.examples.bowling;

import com.adrmenam.examples.sharedMethods.NotAllowedRoll;

public class Ball {

	private int pins;
	private String rollResult;

	public Ball(String result) throws NotAllowedRoll, NumberFormatException {

		this.rollResult = result;

		if (result.equals("F")) {
			result = "0";
		}
		int pins = Integer.parseInt(result);
		if (pins > 10 || pins < 0) {
			throw new NotAllowedRoll("The maximum number of pins in one roll is 10 and minimum is 0");
		}
		this.pins = pins;

	}

	public int getPins() {
		return pins;
	}

	public void setPins(int pins) {
		this.pins = pins;
	}

	public String getRollResult() {
		return rollResult;
	}

	public void setRollResult(String rollResult) {
		this.rollResult = rollResult;
	}
	
	

}
