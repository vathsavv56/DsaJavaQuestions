# Project Spec: Library Management System (Java OOP + Collections)

## . Overview
A console-based Library Management System. Multiple member types, multiple branches, borrowing with limits, waitlisting, fines, and reporting. The spec below describes *behavior and constraints only* — you decide which OOP construct and which Collection type fits each requirement.

---

## 2. Entities

### Book
- Has: id, title, author, genre, year, total copies, available copies
- Two ways to create a book: minimal (title, author) and full (title, author, genre, year, copies)
- Two books are considered the same if their id matches, regardless of other field values
- Needs a readable printed form for logging and display

### Member (general role)
- Has: id, name, join date
- Every member type must define its own borrow limit and its own fine-per-day-late rate
- Common behavior (checking if they're under their limit) should live in one place, not repeated per type

### Student (a kind of Member)
- Borrow limit: 3
- Fine: ₹2/day late

### Faculty (a kind of Member)
- Borrow limit: 5
- Fine: ₹1/day late
- Exempt from fines if the book is returned within a 3-day grace period

### Librarian (a kind of Member, but different privileges)
- No borrow limit
- Can also: add/remove books, view full activity history, force-return any book
- Should not be borrowable-restricted the same way Student/Faculty are — think about what relationship this implies vs. just extending the same restrictions

### Branch
- A library has multiple branches (e.g. "Main", "Annex")
- Each branch has its own book inventory but members are shared system-wide
- A book can exist in more than one branch with separate copy counts

---

## 3. Functional Requirements (figure out the right structure for each)

1. **Book lookup by ID** must be fast — not a linear scan through every book.
2. **All books in a branch** must be listable in the order they were added.
3. **Genres** in a branch must be queryable as a list with no duplicates, and order doesn't matter.
4. **Members**, when listed system-wide, must always come out sorted by ID automatically — without you manually sorting before every display.
5. **A waitlist per book** must process people in the exact order they joined, and must support a person joining and a person being served, but nothing else (no random access, no searching the middle).
6. **Borrowing history per member** should support quickly viewing their *most recent* action first, and older actions should fall away in that same "last in" priority — think about which structure naturally gives you most-recent-first without sorting.
7. **Searching by partial title** must be case-insensitive and must scan across all branches.
8. **Removing every book of a given genre** (e.g. a recall) must safely remove matching entries from a live collection while it's being iterated, without skipping elements or throwing a concurrent modification error.
9. **Sorting the book list for display** must support at least 3 independent sort orders (title, year, available-copies) without writing 3 separate hardcoded sort methods.
10. **Fine calculation** depends on member type and must not be a giant if/else chain checking `instanceof` — the right OOP mechanism should make this automatic per subclass.
11. **A book existing in 2+ branches** must be tracked so that the *same logical book* (same id) maps to different copy counts per branch — duplicate Book objects per branch is not acceptable; figure out a relationship that avoids duplication while still tracking branch-specific counts.
12. **Borrow attempts on a book with zero available copies anywhere** must distinguish between "book doesn't exist" and "book exists but unavailable" with two different error types.
13. **A member exceeding their borrow limit** must fail in a way that's distinguishable, at the catch site, from "book unavailable" — these are different problems and must not be handled by the same exception type.
14. **Returning a book with people on the waitlist** must auto-assign to the next person and this must trigger without manual checking from the menu code — i.e. the return action itself should resolve the waitlist as part of its own responsibility, not leave it to the caller.

---

## 4. Design Constraints (push your design further)

- No field should be public. Every state-changing operation goes through a method that can validate input.
- At least one place in the system must use **generics** beyond the standard collections (e.g. a generic `Repository<T>` style helper for "store and fetch by ID" logic shared across Book and Member).
- At least one interface must be implemented by two *unrelated* classes (classes that don't share a superclass) to demonstrate that interfaces aren't about hierarchy.
- At least one method must accept a functional interface (e.g. a custom filter condition passed into a search method) rather than hardcoding the condition.
- Introduce at least one custom unchecked exception and one custom checked exception, and justify in a comment why each was made checked vs. unchecked.
- The system must support adding new member types in the future without modifying existing borrow/fine logic (open/closed principle) — if adding "Guest" member requires editing the `Library` class's borrow method, the design needs rework.

---

## 5. Reporting Requirements (for extra depth)

- Most-borrowed book this month (requires tracking counts, not just current state)
- Members currently over their fine-free grace period
- Branch with the lowest available-copy ratio (available/total) across its inventory
- A full audit trail answering "who has borrowed book X, in order, historically" — not just who has it now

---

## 6. Definition of Done
- Every requirement in Section 3 is satisfied by a deliberate structural choice, not a default guess
- Every constraint in Section 4 is demonstrated somewhere in the code, traceably
- All reports in Section 5 can be generated from existing data without restructuring it
- No requirement is solved by brute-force scanning when a more fitting structure exists
- You can explain, for every collection and OOP construct you used, *why that one and not an alternative*