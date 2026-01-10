//============================================================
// CSE143 PREP NOTES — CLASSES & ENCAPSULATION
//============================================================
//
// Rule for this notes file:
// - Every non-code line is commented out with //
// - Only example code is left uncommented so the IDE can read it
//
// Purpose of this chapter:
// - Learn how to DESIGN classes correctly
// - Especially: encapsulation, constructors, fields, methods, static vs instance
//
// Why CSE143 cares:
// - Later topics (inheritance, recursion, data structures) assume you can
//   build clean classes with safe state management.
//============================================================



//------------------------------------------------------------
// 1. OBJECT-ORIENTED PROGRAMMING (OOP)
//------------------------------------------------------------
//
// OOP organizes programs around OBJECTS instead of only steps.
//
// Instead of thinking:
//   "What steps should the program run?"
// We think:
//   "What objects exist, and what should each one be responsible for?"
//
// An OBJECT:
// - Represents a real or abstract thing
// - Has STATE (fields / data)
// - Has BEHAVIOR (methods)
//
// Examples of objects:
// - Point
// - BankAccount
// - Student
// - File
// - Node (used later in data structures)
//
// Core idea:
// - Objects bundle data + behavior together.
// - Each object is responsible for managing its own state safely.
//------------------------------------------------------------



//------------------------------------------------------------
// 2. CLASSES AND OBJECTS
//------------------------------------------------------------
//
// A CLASS:
// - A blueprint / template
// - Describes fields + methods objects will have
// - Is not a specific thing; it’s a definition
//
// An OBJECT:
// - An instance created from a class (using new)
// - Represents a specific thing
// - Has its own copy of instance fields
//
// Mental model you should memorize:
// - Class  = blueprint
// - Object = one thing built from the blueprint
//
// One class can create MANY objects.
// Each object is independent (different field values).
//------------------------------------------------------------



//------------------------------------------------------------
// 3. FIELDS (INSTANCE VARIABLES)
//------------------------------------------------------------
//
// Fields store the STATE of an object.
// They are the variables that live inside each object.
//
// Examples of fields:
// - x, y for a Point
// - balance for a BankAccount
// - name for a Student
//
// Key idea:
// - Each object has its OWN copy of instance fields.
//   If you make two Points, each Point has its own x and y.
//
// CSE143 expectation:
// - Fields should usually be private (encapsulation).
//------------------------------------------------------------



//------------------------------------------------------------
// 4. ENCAPSULATION (MOST IMPORTANT IDEA)
//------------------------------------------------------------
//
// Encapsulation = hide implementation details from clients.
//
// Client code = code outside the class (other classes, main programs, etc.)
//
// Encapsulation in Java is mainly done using:
// - private fields  (clients can’t touch the data directly)
// - public methods  (clients interact through behavior)
//
// Why encapsulation matters:
// 1) Prevents invalid states
//    Example: a BankAccount should not allow negative balance (maybe).
//    If balance is public, any code can set it to -999.
//
// 2) Prevents accidental bugs
//    Client code can’t “break” the object by changing internal variables wrong.
//
// 3) Allows safe changes later
//    If clients depend on public fields, changing internal representation breaks everything.
//    If clients only call methods, you can change internals without changing client code.
//
// CSE143 rule (memorize):
// - ALL fields should be private unless told otherwise.
//------------------------------------------------------------



//------------------------------------------------------------
// 5. NON-ENCAPSULATED VS ENCAPSULATED
//------------------------------------------------------------
//
// BAD (not encapsulated):
// - fields are not private
// - client can directly modify fields

public class BadPoint {
    int x;
    int y;
}

// Example of why it’s bad (client code could do):
// BadPoint p = new BadPoint();
// p.x = -999;     // object has no protection / validation
// p.y = 123456;   // changes internal state directly



// GOOD (encapsulated):
// - fields are private
// - client must use methods

public class Point {
    private int x;
    private int y;
}

// Important:
// - Now client code CANNOT do p.x or p.y
// - This forces proper use of methods (safe access).
//------------------------------------------------------------



//------------------------------------------------------------
// 6. ACCESSORS (GETTERS)
//------------------------------------------------------------
//
// Accessors (getters):
// - Return information about an object
// - Do NOT modify the object's state
//
// Naming convention:
// - getX(), getY(), getBalance(), getName(), etc.

public int getX() {
    return x;
}

public int getY() {
    return y;
}

// Why getters matter:
// - Clients can read state without direct access to fields.
// - You can still control what “reading” means later if needed.
//------------------------------------------------------------



//------------------------------------------------------------
// 7. MUTATORS (SETTERS) / STATE-CHANGING METHODS
//------------------------------------------------------------
//
// Mutators (setters):
// - Change the object's state
// - Can enforce rules/validation before changing fields
//
// Naming convention:
// - setLocation(...), setBalance(...), setName(...)

public void setLocation(int newX, int newY) {
    x = newX;
    y = newY;
}

// Why setters are better than public fields:
// - You can add checks later:
//     if (newX < 0) throw error;
// - You can prevent invalid updates
// - You can log changes or keep consistency rules
//------------------------------------------------------------



//------------------------------------------------------------
// 8. CONSTRUCTORS
//------------------------------------------------------------
//
// A constructor:
// - Runs when you create an object with new
// - Initializes fields so the object starts valid
// - Has the same name as the class
// - Has NO return type (not even void)
//
// Good design idea:
// - Constructors should create a valid starting state.
// - Avoid leaving fields uninitialized or inconsistent.

public Point(int x, int y) {
    setLocation(x, y);
}

// Note:
// - Calling an instance method inside a constructor is allowed.
// - It often reduces duplicated code.
//------------------------------------------------------------



//------------------------------------------------------------
// 9. WHY REUSING METHODS MATTERS (AVOID DUPLICATION)
//------------------------------------------------------------
//
// Duplicate logic is dangerous because:
// - You might update one copy but forget the other
// - Bugs appear in only one path
// - Harder to maintain
//
// BAD: duplicates the logic of setting x and y

public Point(int x, int y) {
    this.x = x;
    this.y = y;
}

// GOOD: reuses one “source of truth” method

public Point(int x, int y) {
    setLocation(x, y);
}

// The “source of truth” rule:
// - Put your logic in ONE place when possible.
// - Call that method from everywhere else.
//------------------------------------------------------------



//------------------------------------------------------------
// 10. ABSTRACTION
//------------------------------------------------------------
//
// Abstraction = focus on WHAT an object does, not HOW it does it.
//
// Clients should interact with a class by calling methods.
// Clients should not need to know:
// - how fields are stored
// - what internal steps happen
//
// Example (client thinking):
// - "Translate this point by dx, dy."
// Not:
// - "Manually modify its x and y fields."

public void translate(int dx, int dy) { //blah blah blah
    setLocation(x + dx, y + dy); //blah blah blah
}

// In abstraction, translate is the “what”.
// The internal math and setLocation call are “how”.
//------------------------------------------------------------



//------------------------------------------------------------
// 11. CLASS AS A MODULE (UTILITY CLASS IDEA)
//------------------------------------------------------------
//
// A module is reusable code that is not a full program.
// Usually:
// - No main method
// - Mostly static methods
//
// Examples:
// - Math.sqrt(25)
// - Arrays.toString(arr)
// - System.out.println(...)
//
// Modules are meant to be CALLED, not instantiated.
// (You typically don’t do new Math().)
//------------------------------------------------------------



//------------------------------------------------------------
// 12. STATIC MEMBERS (CLASS-LEVEL DATA)
//------------------------------------------------------------
//
// static means:
// - Belongs to the CLASS, not one object
//
// STATIC FIELD:
// - Only ONE copy exists total
// - Shared by all objects of the class
// - Common uses:
//   - counting objects created
//   - constants (often static final)
//   - shared configuration

private static int objectCount;

// Example idea (not full class here):
// - Each time a BankAccount is constructed, increment objectCount
// - objectCount tracks total accounts ever created
//------------------------------------------------------------



//------------------------------------------------------------
// 13. STATIC METHODS (CLASS-LEVEL BEHAVIOR)
//------------------------------------------------------------
//
// Static methods:
// - Do not have a 'this'
// - Cannot directly access instance fields (like x, y) because
//   they don’t refer to any one object
// - Called with ClassName.methodName(...)

public static int getNumAccounts() {
    return objectCount;
}

// Rule of thumb:
// - If behavior depends on one object's state → instance method
// - If behavior belongs to the whole class → static method
//------------------------------------------------------------



//------------------------------------------------------------
// 14. INSTANCE VS STATIC (COMMON CONFUSION)
//------------------------------------------------------------
//
// INSTANCE (non-static):
// - belongs to ONE object
// - uses that object’s fields
// - can use 'this'
//
// STATIC:
// - belongs to the class itself
// - shared across all objects
// - no 'this'
//
// Common mistake:
// - Trying to use instance fields inside static methods.
// - Or making fields public instead of using methods.
//------------------------------------------------------------



//------------------------------------------------------------
// 15. CSE143 DESIGN EXPECTATIONS (MEMORIZE)
//------------------------------------------------------------
//
// 1) Fields should be private
// 2) Clients interact through methods (public API)
// 3) Constructors establish a valid state
// 4) Avoid duplicating logic; reuse methods
// 5) static = class-level, not object-level
// 6) Design matters as much as correctness
//------------------------------------------------------------
