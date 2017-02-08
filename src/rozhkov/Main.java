package rozhkov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		double number = 0.00, result = 0.00;
		String operation;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Start calculator");
		System.out.println("insert: 'pow' - to get value of x to the power of y, 'c' - to restart, 'ex' - to exit.");

		while (true) {
			result = insertNewNumber(result, reader);
			while (true) {
				System.out.println("Enter your operation");
				operation = reader.readLine();
				if (!checkOperation(operation)) {
					System.out.println("Wrong operation.");
					continue;
				}

				if (operation.equals("c") || operation.equals("ex")) {
					break;
				}
				number = insertNewNumber(number, reader);
				if (operation.equals("/") && number == 0) {
					System.out.println("'/0' is wrong operation.");
					continue;
				}
				result = handler(result, operation, number);
				System.out.println("Result: " + result);
			}

			if (operation.equals("ex")) {
				System.out.println("Exit");
				break;
			}

		}

	}

	private static boolean checkOperation(String operation) {
		String[] operations = { "+", "-", "/", "*", "pow", "c", "ex" };
		boolean result = false;
		for (int i = 0; i < operations.length; i++) {
			if (operation.equals(operations[i])) {
				result = true;
				break;
			}
		}
		return result;
	}

	private static double insertNewNumber(double number, BufferedReader reader) throws IOException {
		System.out.println("Enter your number");
		String string = reader.readLine();
		try {
			number = Double.valueOf(string);
		} catch (Exception e) {
			System.out.println(string + " is not a number. " + string + " is changed to 0.");

			number = 0.0;
		}
		return number;
	}

	private static double handler(double a, String operation, double b) {
		double result = 0.0;
		switch (operation) {
		case "+":
			result = a + b;
			break;
		case "-":
			result = a - b;
			break;
		case "*":
			result = a * b;
			break;
		case "/":
			result = a / b;
			break;
		case "pow":
			result = Math.pow(a, b);
			break;
		}
		return result;
	}
}