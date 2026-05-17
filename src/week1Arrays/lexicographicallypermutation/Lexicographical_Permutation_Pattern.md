# Lexicographical Permutation Pattern

## 1. What is Lexicographical Permutation?

Lexicographical order means dictionary-like order.

For example:

```text
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2]
[3, 2, 1]
```

The **next permutation** means the immediate next greater arrangement.

Example:

```text
[1, 2, 3] -> [1, 3, 2]
```

---

## 2. Pattern Name

This pattern is commonly known as:

```text
Lexicographical Permutation Pattern
```

It also uses:

- Greedy
- Two Pointers
- Right-to-left traversal
- Monotonic suffix observation
- Array rearrangement

---

## 3. Core Intuition

The goal is:

```text
Find the smallest possible arrangement that is greater than the current arrangement.
```

So we do two things:

1. Increase the number slightly.
2. Make everything after that as small as possible.

This is why the algorithm is greedy.

---

## 4. How to Recognize This Pattern

Think about this pattern when the problem says:

- Next permutation
- Previous permutation
- Next greater number using same digits
- Immediate next arrangement
- Lexicographical order
- Dictionary order
- Rearrange digits
- Smallest greater number
- Largest smaller number
- Find kth permutation
- Generate permutations in sorted order

---

## 5. Key Observation

When scanning from right to left, we find the first place where:

```text
nums[i] < nums[i + 1]
```

This index is called the **breakpoint** or **pivot**.

Example:

```text
nums = [1, 2, 3, 6, 5, 4]
```

Scan from right:

```text
1  2  3  6  5  4
      ^
      breakpoint because 3 < 6
```

The suffix after breakpoint is:

```text
6 5 4
```

This suffix is in descending order.

Why?

Because if there was an increasing pair inside the suffix, we would have found the breakpoint later.

---

## 6. Next Permutation Algorithm

### Step 1: Find Breakpoint

Find the first index from right where:

```text
nums[i] < nums[i + 1]
```

Example:

```text
1  2  3  6  5  4
      ^
      i = 2
```

---

### Step 2: Find the Next Greater Element

Find the first number from the right that is greater than `nums[i]`.

```text
1  2  3  6  5  4
      ^        ^
      3        4
```

Swap them:

```text
1  2  4  6  5  3
```

---

### Step 3: Reverse the Suffix

After swap, the suffix is still descending:

```text
6 5 3
```

To get the immediate next permutation, make the suffix as small as possible.

Smallest arrangement of:

```text
6 5 3
```

is:

```text
3 5 6
```

Final answer:

```text
1  2  4  3  5  6
```

---

## 7. Why Do We Reverse the Suffix?

After changing the breakpoint, the number has already become greater.

Now we want the remaining part to be minimum.

Example:

```text
Original:    1 2 3 6 5 4
After swap:  1 2 4 6 5 3
```

The prefix `1 2 4` is now greater than `1 2 3`.

To make the total number as small as possible, arrange the remaining part in ascending order:

```text
6 5 3 -> 3 5 6
```

Final:

```text
1 2 4 3 5 6
```

So the memory is:

```text
Increase slightly, then minimize the suffix.
```

---

## 8. Python Code

```python
def nextPermutation(nums):
    n = len(nums)

    # Step 1: Find breakpoint
    i = n - 2
    while i >= 0 and nums[i] >= nums[i + 1]:
        i -= 1

    # Step 2: If breakpoint exists, find next greater and swap
    if i >= 0:
        j = n - 1
        while nums[j] <= nums[i]:
            j -= 1

        nums[i], nums[j] = nums[j], nums[i]

    # Step 3: Reverse suffix
    left = i + 1
    right = n - 1

    while left < right:
        nums[left], nums[right] = nums[right], nums[left]
        left += 1
        right -= 1

    return nums
```

---

## 9. Complexity

```text
Time Complexity: O(n)
Space Complexity: O(1)
```

---

## 10. Dry Run

Input:

```text
[1, 2, 3, 6, 5, 4]
```

Find breakpoint:

```text
1 2 3 6 5 4
    ^
```

Swap `3` with `4`:

```text
1 2 4 6 5 3
```

Reverse suffix:

```text
6 5 3 -> 3 5 6
```

Output:

```text
[1, 2, 4, 3, 5, 6]
```

---

## 11. Edge Cases

### Case 1: Already Largest Permutation

```text
[3, 2, 1]
```

There is no breakpoint.

So reverse the whole array:

```text
[1, 2, 3]
```

---

### Case 2: Already Smallest Permutation

```text
[1, 2, 3]
```

Next permutation:

```text
[1, 3, 2]
```

---

### Case 3: Duplicate Values

```text
[1, 1, 5]
```

Next permutation:

```text
[1, 5, 1]
```

---

## 12. Similar Problems

### 1. Previous Permutation

Find the immediate previous smaller arrangement.

Pattern is similar, but instead of finding a bigger element, we find a smaller element.

---

### 2. Next Greater Element III

Given an integer, find the next greater number using the same digits.

Example:

```text
12443322 -> 13222344
```

This is almost the same as Next Permutation.

---

### 3. Permutation Sequence

Find the kth permutation of numbers from `1` to `n`.

Uses:

- Lexicographical order
- Factorial grouping
- Greedy selection

---

### 4. Generate All Permutations

Generate every possible arrangement.

Uses:

- Backtracking
- Swapping
- Recursion

---

### 5. Generate Unique Permutations

Generate all unique permutations when duplicates exist.

Uses:

- Sorting
- Backtracking
- Duplicate skipping

---

### 6. Lexicographical Numbers

Generate numbers from `1` to `n` in lexicographical order.

Uses:

- DFS style traversal
- Dictionary order thinking

---

### 7. Next Closest Time

Given a time, find the next closest valid time using the same digits.

Uses:

- Permutation thinking
- Lexicographical next valid state

---

### 8. Largest Number

Arrange numbers to form the largest possible number.

Uses:

- Greedy ordering
- Lexicographical comparison

---

## 13. Problems to Practice

| Problem | Pattern Used |
|---|---|
| Next Permutation | Greedy + suffix reversal |
| Previous Permutation | Greedy + suffix reversal |
| Next Greater Element III | Next permutation on digits |
| Permutation Sequence | Factorial + lexicographical order |
| Permutations | Backtracking |
| Permutations II | Backtracking + duplicates |
| Lexicographical Numbers | DFS ordering |
| Next Closest Time | Next valid permutation |
| Largest Number | Greedy lexicographical sorting |

---

## 14. Interview Memory Trick

```text
Find dip -> swap slightly bigger -> reverse suffix
```

or:

```text
Increase minimally -> minimize the remaining part
```

---

## 15. Final Summary

Lexicographical permutation problems are about finding or generating arrangements in dictionary-like order.

For Next Permutation:

1. Find breakpoint from right.
2. Swap with next greater element.
3. Reverse suffix to make it smallest.

This gives the immediate next greater permutation in O(n) time and O(1) space.
