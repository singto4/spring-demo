package com.example.api;

import java.util.Scanner;

public class Ass8 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		int keyboard;
		int max = 0;
		int secondMax = 0;
		
		while (count < 5) {
			count++;
			System.out.print("count = ");
			keyboard = sc.nextInt();
			if (max < keyboard) {
				secondMax = max; // set ค่า max เก่าเป็น secondMax
				max = keyboard; // set ค่า max ใหม่
			} else if (secondMax < keyboard) {
				secondMax = keyboard; //set ค่า secondMax ใหม่
			} 
		}
		
		System.out.println("secondMax = " + secondMax);
	}

}
