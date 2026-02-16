/* ============================================================
 * CSE 143 — Runtime & Algorithm Efficiency
 * Topic: How fast algorithms run as input size grows
 *
 * Goal:
 * - Compare algorithms independent of hardware
 * - Predict scalability for large inputs
 * ============================================================
 */


/* ============================================================
 * MOTIVATION
 * ============================================================
 *
 * Different algorithms can solve the SAME problem
 * but with drastically different runtimes.
 *
 * Using a faster computer is NOT the solution.
 * Choosing a better algorithm is.
 *
 * Example problem: sum numbers from 1 to n
 */

// Algorithm A — iterative
sum = 0;
for (int i = 1; i <= n; i++) {
    sum = sum + i;
}

// Algorithm B — nested loop (much slower)
sum = 0;
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= i; j++) {
        sum = sum + i;
    }
}

// Algorithm C — direct formula (fastest)
sum = n * (n + 1) / 2;


/* ============================================================
 * RUNTIME EFFICIENCY
 * ============================================================
 *
 * Time complexity:
 * - How long an algorithm takes to run
 *
 * Space complexity:
 * - How much memory an algorithm uses
 *
 * Two ways to measure efficiency:
 *
 * 1) Empirical analysis
 *    - Run the program
 *    - Measure time / memory
 *
 * 2) Algorithm analysis (preferred)
 *    - Examine code
 *    - Count operations
 */


/* ============================================================
 * MEASURING ALGORITHM EFFICIENCY
 * ============================================================
 *
 * We care about:
 * - How runtime grows as input size grows
 *
 * This is captured by a growth-rate function.
 *
 * We do NOT care about:
 * - Exact milliseconds
 * - Machine speed
 * - Constant overhead
 */


/* ============================================================
 * COUNTING BASIC OPERATIONS
 * ============================================================
 *
 * Basic operations dominate runtime.
 * Examples:
 * - Arithmetic (+, -, *, /)
 * - Comparisons
 * - Assignments
 *
 * Ignored operations:
 * - Variable declarations
 * - Loop control (usually)
 */

// Algorithm A → ~n additions → O(n)
// Algorithm B → ~n(n+1)/2 additions → O(n^2)
// Algorithm C → constant operations → O(1)


/* ============================================================
 * COMMON GROWTH-RATE FUNCTIONS (ORDERED)
 * ============================================================
 *
 * Best → Worst:
 *
 * 1
 * log(log n)
 * log n
 * n
 * n log n
 * n^2
 * n^3
 * 2^n
 * n!
 *
 * Lower growth = better scalability
 */


/* ============================================================
 * COMPLEXITY CLASSES (BIG-O)
 * ============================================================
 *
 * O(1)        Constant
 * O(log n)   Logarithmic
 * O(n)       Linear
 * O(n log n) Log-linear
 * O(n^2)     Quadratic
 * O(n^3)     Cubic
 * O(2^n)     Exponential
 *
 * Rule of thumb:
 * - Polynomial time (n, n^2, n^3) → manageable
 * - Exponential → infeasible very quickly
 */


/* ============================================================
 * BEST, WORST, AND AVERAGE CASES
 * ============================================================
 *
 * Some algorithms depend on:
 * - input size
 * - input arrangement
 *
 * Best case:
 * - minimum time required
 *
 * Worst case:
 * - maximum time required
 *
 * Average case:
 * - expected time (hard to compute)
 *
 * Important:
 * Average case ≠ (best + worst) / 2
 */


/* ============================================================
 * BIG-O NOTATION
 * ============================================================
 *
 * Big-O describes an UPPER BOUND on runtime.
 *
 * Examples:
 *
 * Algorithm A → O(n)
 * Algorithm B → O(n^2)
 * Algorithm C → O(1)
 *
 * We drop:
 * - constants
 * - lower-order terms
 */


/* ============================================================
 * OTHER NOTATIONS
 * ============================================================
 *
 * Big-O (O):
 * - Maximum time
 *
 * Big-Omega (Ω):
 * - Minimum time
 *
 * Big-Theta (Θ):
 * - Tight bound (both upper and lower)
 *
 * Example:
 * - Finding max in array
 *   - Always n comparisons
 *   - Θ(n)
 */


/* ============================================================
 * PICTURING EFFICIENCY
 * ============================================================
 *
 * O(n):
 * - One operation per element
 *
 * O(n^2):
 * - Nested loops
 * - Work grows as square
 *
 * Visual intuition:
 * - doubling n:
 *   O(n)   → doubles
 *   O(n^2) → quadruples
 *   O(n^3) → multiplies by 8
 */


/* ============================================================
 * EXECUTION TIME OBSERVATIONS
 * ============================================================
 *
 * Doubling input size:
 *
 * O(1)   → no change
 * O(log n) → slight change
 * O(n)   → doubles
 * O(n^2) → quadruples
 * O(n^3) → x8
 * O(2^n) → explodes
 */


/* ============================================================
 * RUNTIME CASE STUDY — RANGE OF ARRAY
 * ============================================================
 *
 * Problem:
 * - Given int[] numbers
 * - Return max - min
 *
 * Algorithm #1:
 * - Compare all pairs
 * - O(n^2)
 *
 * Algorithm #2:
 * - Improved nested loop
 * - Still O(n^2)
 *
 * Algorithm #3:
 * - Single pass
 * - Track min and max
 * - O(n)
 */

int min = numbers[0];
int max = numbers[0];

for (int i = 1; i < numbers.length; i++) {
    if (numbers[i] < min) {
        min = numbers[i];
    }
    if (numbers[i] > max) {
        max = numbers[i];
    }
}

return max - min;


/* ============================================================
 * RUNTIME PRACTICE EXAMPLES
 * ============================================================
 */

// Example 1
for (int i = 0; i < n; i++) {
    count++;
    if (i % 2 == 0) {
        count++;
    }
}
// Time: O(n)
// Space: O(1)


// Example 2
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        count++;
    }
}
// Time: O(n^2)
// Space: O(1)


// Example 3
int[] array = new int[n];
for (int i = 0; i < 100; i++) {
    count++;
}
// Time: O(1)
// Space: O(n)


// Example 4
for (int i = 1; i < n; i = i * 2) {
    count++;
}
// Time: O(log n)
// Space: O(1)


// Example 5 (recursion)
private static String mystery(int n) {
    if (n == 1) {
        return "1";
    } else {
        return mystery(n - 1) + ", " + n;
    }
}
// Time: O(n)
// Space: O(n)


/* ============================================================
 * ARRAY vs LINKED IMPLEMENTATION EFFICIENCY
 * ============================================================
 *
 * Array-based:
 * - add → Θ(1)
 * - isFull → Θ(1)
 * - toArray → Θ(n)
 *
 * Linked-based:
 * - add (front) → Θ(1)
 * - search → O(n), Ω(1)
 */
