package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange {

		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			double tenderedValue = 0;
			int countOfTimesMoneyWasRequested = 0;

			System.out.println("What is the price of the item? ");
			double itemPrice = scanner.nextDouble();

			do {
				System.out.println(countOfTimesMoneyWasRequested == 0 ? "Please add money "
						: "You need to add at least $" + (itemPrice - tenderedValue) + ". Add more money please ");
			
				tenderedValue = tenderedValue + scanner.nextDouble();
				countOfTimesMoneyWasRequested++;
				System.out.println("You entered $" + tenderedValue + ". ");
				
			} while (tenderedValue < itemPrice);
		

			System.out.println("Total amount received, Thank you!");
			double change = tenderedValue - itemPrice;
			calculateChange(change);
			scanner.close();

		}

		public static void calculateChange(double changeOwed) {
	        changeOwed = Math.round(changeOwed * 100) / 100.0;
			System.out.println("Your change owed is: $" + changeOwed);
			
			if (changeOwed > 100) {
				changeOwed = calculateDenomimationalChange(changeOwed, 100, "hundred");
			}
			if (changeOwed > 50) {
				changeOwed = calculateDenomimationalChange(changeOwed, 50, "fifty");
			}
			if (changeOwed > 20) {
				changeOwed = calculateDenomimationalChange(changeOwed, 20, "twenty");
			}
			if (changeOwed > 10) {
				changeOwed = calculateDenomimationalChange(changeOwed, 10, "ten");
			}
			if (changeOwed > 5) {
				changeOwed = calculateDenomimationalChange(changeOwed, 5, "five");
			}
			if (changeOwed > 1) {
				changeOwed = calculateDenomimationalChange(changeOwed, 1, "one");
			}
			if (changeOwed > .25) {
				changeOwed = calculateDenomimationalChange(changeOwed, .25, "quarter");
			}
			if (changeOwed > .10) {
				changeOwed = calculateDenomimationalChange(changeOwed, .10, "dime");
			}
			if (changeOwed > .05) {
				changeOwed = calculateDenomimationalChange(changeOwed, .05, "nickle");
			}
			if (changeOwed > .01) {
				changeOwed = calculateDenomimationalChange(changeOwed, .01, "penny");
			}

		}

		public static double calculateDenomimationalChange(double changeOwed, double billOrCoinValue, String billOrCoinName) {
			 int changeCount = (int) (changeOwed / billOrCoinValue);
		        changeOwed -= changeCount * billOrCoinValue;
		        System.out.println("Please return " + changeCount + "x $" + billOrCoinValue + " (" + billOrCoinName + ")");
			
			
			return changeOwed;
			
		}
	}

