package recursionstarterpk;

public class FibGenerator {
	private int[] callCounter;
	public int nthFib(int n) {
		callCounter = new int[n+1];
		return computeFibRecurse(n);
	}

	private int computeFibRecurse(int n) {
		callCounter[n]++;
		// Trivial case: n is 1 or 2.
		if (n == 1 || n == 2) {
			return 1;
		}
		return computeFibRecurse(n-2) + computeFibRecurse(n-1);
	}
	
	public void printCallCounter()
	{
		for (int i = 0; i <callCounter.length; i++)
		{
			
		System.out.println(callCounter[i] + " calls to " +"fib(" + i + ")");
		}
	}

	static void sop(Object x) {
		System.out.println(x);
	}

	public static void main(String[] args) {
		sop("STARTING");
		FibGenerator generator = new FibGenerator();
		for (int x = 1; x <= 20; x++) {
			sop("fib(" + x + ") = " + generator.nthFib(x));
			
		}
		generator.printCallCounter();

		// Above, raise max to 30, then 40 ...

		// Add inst var int[] callCounter.
		// Add method printCallCounter().
	}
}
