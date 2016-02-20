package com.example.singh.seven_11;

public class lotto {

	private int Amount;
	private int Start;
	private int End;
	private int Sold;
	private int Value;

	public lotto(int amount, int start, int end, int sold, int value) {
		super();
		Amount = amount;
		Start = start;
		End = end;
		Sold = sold;
		Value = value;
	}
	public int getAmount() {
		return Amount;
	}
	
	public int getStart() {
		return Start;
	}
	
	public int getEnd() {
		return End;
	}
	
	public int getSold() {
		return Sold;
	}
	
	public int getValue() {
		return Value;
	}
}
