package com.rsi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Job {

	private Shape shape;

	public Job(Shape shape) {
		this.shape = shape;
	}

	public String execute() {
		String result = null;
		try {
			System.out.println("Iniciando execução do serviço..");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}
}
