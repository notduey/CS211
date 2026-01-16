// ============================================================
// CSE143 — RECURSION NOTES
// Section: 04 - Recursion
// ============================================================


// ------------------------------------------------------------
// What is recursion?
// ------------------------------------------------------------

// Recursion = defining a solution in terms of itself
// A recursive method is a method that calls itself
// Used to solve problems by breaking them into smaller versions
// No loops required (recursion can replace iteration)


// ------------------------------------------------------------
// Two REQUIRED parts of recursion
// ------------------------------------------------------------

// 1) Base Case
//    - A simple case that can be answered directly
//    - Stops the recursion
//    - Without it → infinite recursion (crash)

// 2) Recursive Case
//    - Reduces the problem
//    - Moves closer to the base case
//    - Must change the input in a way that guarantees progress


// ------------------------------------------------------------
// Example: writeStars(n)
// Prints exactly n stars on one line
// ------------------------------------------------------------

public static void writeStars(int n) {
    if (n == 0) {
        // Base case: nothing left to print
        System.out.println();
    } else {
        // Recursive case:
        // Do a small amount of work, then recurse
        System.out.print("*");
        writeStars(n - 1);
    }
}


// ------------------------------------------------------------
// How to THINK recursively (very important)
// ------------------------------------------------------------

// Do NOT think about the entire problem
// Instead ask:
// - What is the smallest version of the problem?
// - What single step can I do now?
// - What remains after that step?

// Example mental model:
// writeStars(5)
// → print 1 star, then trust writeStars(4)
// → print 1 star, then trust writeStars(3)
// → ...
// → stop at writeStars(0)


// ------------------------------------------------------------
// Recursion vs Iteration
// ------------------------------------------------------------

// Iteration:
// - Uses loops (for / while)
// - Keeps state explicitly

// Recursion:
// - Uses method calls
// - State is stored in the call stack
// - Often clearer for problems with:
//   * trees
//   * sequences
//   * divide-and-conquer logic


// ------------------------------------------------------------
// Common recursion mistakes
// ------------------------------------------------------------

// ❌ No base case
// ❌ Base case that is never reached
// ❌ Recursive call that does NOT change the input
// ❌ Input moves AWAY from the base case

// Example of infinite recursion:
public static void badMethod(int n) {
    badMethod(n); // n never changes → infinite recursion
}


// ------------------------------------------------------------
// Tracing recursion (YOU MUST PRACTICE THIS)
// ------------------------------------------------------------

// Example:
// writeStars(3)
//
// writeStars(3)
// ├─ print "*"
// └─ writeStars(2)
//     ├─ print "*"
//     └─ writeStars(1)
//         ├─ print "*"
//         └─ writeStars(0)
//             └─ println()


// ------------------------------------------------------------
// Public & Private (Helper) Recursive Methods
// ------------------------------------------------------------

// Often the parameters the CLIENT wants
// are not the parameters recursion needs

// Solution: paired methods

// Public method:
// - Validates input
// - Simple signature
// - NOT recursive

// Private helper:
// - Actually recursive
// - Has extra parameters if needed


public int factorial(int n) {
    if (n < 0) {
        throw new IllegalArgumentException();
    }
    return factorialHelper(n);
}

private int factorialHelper(int n) {
    if (n < 1) {
        return 1;          // base case
    }
    return n * factorialHelper(n - 1); // recursive case
}


// ------------------------------------------------------------
// Key recursion rules to memorize
// ------------------------------------------------------------

// 1) Every recursive method MUST have a base case
// 2) Every recursive call MUST move closer to the base case
// 3) Trust the recursive call to work
// 4) Do NOT try to trace everything at once
// 5) If recursion never ends → check your base case first


// ------------------------------------------------------------
// When recursion is a GOOD choice
// ------------------------------------------------------------

// - Problems that naturally break into smaller versions
// - Tree or hierarchical structures
// - Problems with a clear "do one thing, then recurse" pattern
