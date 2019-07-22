package ProjectTwo;

import java.util.Stack;

public class LargeNumber {

	Stack<Integer> digits = new Stack<Integer>();
	Stack<Integer> resultStack = new Stack<Integer>();

	/**
	 * Takes in a String and builds an integer number
	 * @param _number
	 */
	public LargeNumber(String _number) {
		for (int i = 0; i < _number.length(); i++) {
			int singleDigit = _number.charAt(i) - '0';
			digits.push(singleDigit);
		}

	}

	/**
	 * @param resultStack
	 */
	private LargeNumber(Stack<Integer> resultStack) {
		digits = resultStack;
	}

	/**
	 * Takes two numbers and add them together
	 * @param otherNumber
	 * @return LargeNumber
	 */
	public LargeNumber addNumbers(LargeNumber otherNumber) {
		int carry = 0;

		while (!digits.isEmpty() && !otherNumber.digits.isEmpty()) {
			
			int digit1 = digits.pop();
			int digit2 = otherNumber.digits.pop();

			if (digits.isEmpty() && digits.size() < otherNumber.digits.size()) {
				digits.push(0);
			}

			if (otherNumber.digits.isEmpty() && otherNumber.digits.size() < digits.size()) {
				otherNumber.digits.push(0);
			}

			int result = digit1 + digit2 + carry;
			int resultDigit = result % 10;
			carry = result / 10;
			resultStack.push(resultDigit);
		}

		if (carry > 0) {
			resultStack.push(carry);
		}

		return new LargeNumber(resultStack);
	}

	/**
	 * Takes two numbers and subtracts them together
	 * @param otherNumber
	 * @return LargeNumber
	 */
	
	public LargeNumber subtractNumbers(LargeNumber otherNumber) {

		boolean takeAwayTen = false;

		while (!digits.isEmpty() && !otherNumber.digits.isEmpty()) {

			int digit1 = digits.pop();
			int digit2 = otherNumber.digits.pop();

			if (takeAwayTen) {
				digit1 -= 1;
				takeAwayTen = false;
			}

			if (digits.isEmpty() && digits.size() < otherNumber.digits.size()) {
				digits.push(0);
			}

			if (otherNumber.digits.isEmpty() && otherNumber.digits.size() < digits.size()) {
				otherNumber.digits.push(0);
			}

			if (digit1 < digit2) {
				digit1 += 10;
				takeAwayTen = true;

			}

			int result = digit1 - digit2;

			resultStack.push(result);
		}

		return new LargeNumber(resultStack);
	}
	
	/**
	 * Creates the toString
	 * @return result
	 */
	public String toString() {
		String result = "";
		while (!digits.isEmpty()) {
			result += digits.pop();
		}

		return result;
	}
}
