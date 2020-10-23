package recursionstarterpk;

public class FactorialGenerator {
	public double nthFactorial(int n) {
		return computeFactorialRecurse(n);
	}

	private double computeFactorialRecurse(int n) {
		assert n >= 0 : "lllegal n: " + n;
		if (n == 0) {
			return 1;
		}
		return n * computeFactorialRecurse(n - 1);
	}

	static void sop(Object x) {
		System.out.println(x);
	}

	public static void main(String[] args) {
		FactorialGenerator generator = new FactorialGenerator();
		int[] simpleInputs = { 6, 10, 20 };
		for (int i : simpleInputs)
			sop(generator.nthFactorial(i));

		// Try for 1 to 32. Note 18!
		for (int i = 1; i <= 32; i++) {
			System.out.println(generator.nthFactorial(i));
		}
		System.out.println(Long.MAX_VALUE);

		// Convert to float. Note 18!

		// What is largest long?

		// computeFactorialRecurse: precondition on n>=0.
		System.out.println(generator.nthFactorial(-1));

		// Discuss ways to compute factorials without using recursion. Simple?
	}
}
