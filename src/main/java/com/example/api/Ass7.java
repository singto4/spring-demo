package com.example.api;

import java.util.Scanner;

public class Ass7 {

	public static void main(String[] args) {

		int max = 0;
		int min = 0;
		int num;

		int i = 0;
		do {
			System.out.print("Enter Number : ");
			Scanner sc = new Scanner(System.in);
			num = sc.nextInt();

			if (num != 999) { // เช็คว่าค่า num เป็น 999 ไหม ถ้าเป็นไม่ต้องทำ process หา max, min
				if (i == 0) { // รอบแรกให้กำหนดค่า max, min = num
					max = num;
					min = num;
				} else {
					if (num > max) {
						max = num;
					} else if (num < min) {
						min = num;
					}
				}

				i++;
			}

		} while (num != 999);

		System.out.println("Min : " + min);
		System.out.println("Max : " + max);
	}

}
