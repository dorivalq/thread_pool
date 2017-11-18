package com.rsi2;

import javax.swing.plaf.SliderUI;

public class Job {

	public void process() {
		try {
			Thread.sleep(500);
			System.out.println("---2--Executando processo...");
		} catch (Exception e) {}
	}

}

