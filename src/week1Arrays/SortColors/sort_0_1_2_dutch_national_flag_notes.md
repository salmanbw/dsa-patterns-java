# Sort an Array of 0s, 1s and 2s

## Problem Name

This problem is commonly known as:

- **Sort Colors**
- **Dutch National Flag Problem**

---

## Problem Statement

Given an array containing only `0`, `1`, and `2`, sort the array in-place so that all `0`s come first, followed by all `1`s, and then all `2`s.

### Example

```text
Input:  [2, 0, 2, 1, 1, 0]
Output: [0, 0, 1, 1, 2, 2]
```

---

## Pattern

This problem belongs to the:

```text
Two Pointers / Three Pointers Pattern
```

More specifically:

```text
Dutch National Flag Algorithm
```

This pattern is useful when we need to divide an array into multiple regions.

For this problem, we divide the array into three groups:

```text
0s | 1s | 2s
```

---

## Core Idea

We use three pointers:

```text
low  -> position where the next 0 should go
mid  -> current element being checked
high -> position where the next 2 should go
```

At any point in the algorithm, the array is divided like this:

```text
0s area | 1s area | Unknown area | 2s area
```

Detailed view:

```text
0 to low-1        -> all 0s
low to mid-1      -> all 1s
mid to high       -> unknown elements
high+1 to end     -> all 2s
```

Diagram:

```text
[ 0s ][ 1s ][ Unknown ][ 2s ]
      low    mid      high
```

---

## Rules

### Case 1: nums[mid] == 0

`0` should be on the left side.

So we swap `nums[mid]` with `nums[low]`.

Then move both `low` and `mid` forward.

```text
swap(nums[low], nums[mid])
low++
mid++
```

---

### Case 2: nums[mid] == 1

`1` is already in the correct middle region.

So we only move `mid` forward.

```text
mid++
```

---

### Case 3: nums[mid] == 2

`2` should be on the right side.

So we swap `nums[mid]` with `nums[high]`.

Then move `high` backward.

Important: We do **not** move `mid` immediately.

```text
swap(nums[mid], nums[high])
high--
```

Why not move `mid`?

Because the element swapped from `high` to `mid` is still unknown and must be checked.

---

## Step-by-Step Dry Run

Array:

```text
[2, 0, 2, 1, 1, 0]
```

Initial pointers:

```text
low = 0
mid = 0
high = 5
```

Diagram:

```text
[2, 0, 2, 1, 1, 0]
 L
 M
                H
```

---

## Step 1

Current value:

```text
nums[mid] = 2
```

Since it is `2`, swap with `high`.

Swap index `0` and index `5`.

```text
Before: [2, 0, 2, 1, 1, 0]
After:  [0, 0, 2, 1, 1, 2]
```

Move `high` left.

```text
low = 0
mid = 0
high = 4
```

Diagram:

```text
[0, 0, 2, 1, 1, 2]
 L
 M
             H
```

Why did `mid` not move?

Because the new element at `mid` is `0`, and it still needs to be processed.

---

## Step 2

Current value:

```text
nums[mid] = 0
```

Since it is `0`, swap with `low`.

Here, `low` and `mid` are at the same index, so the array remains the same.

```text
[0, 0, 2, 1, 1, 2]
```

Move both `low` and `mid`.

```text
low = 1
mid = 1
high = 4
```

Diagram:

```text
[0, 0, 2, 1, 1, 2]
    L
    M
             H
```

Current regions:

```text
[0] | Unknown | [2]
```

---

## Step 3

Current value:

```text
nums[mid] = 0
```

Again, swap with `low`.

Since `low` and `mid` are at the same index, array remains same.

```text
[0, 0, 2, 1, 1, 2]
```

Move both `low` and `mid`.

```text
low = 2
mid = 2
high = 4
```

Diagram:

```text
[0, 0, 2, 1, 1, 2]
       L
       M
             H
```

Current regions:

```text
[0, 0] | Unknown | [2]
```

---

## Step 4

Current value:

```text
nums[mid] = 2
```

Since it is `2`, swap with `high`.

Swap index `2` and index `4`.

```text
Before: [0, 0, 2, 1, 1, 2]
After:  [0, 0, 1, 1, 2, 2]
```

Move `high` left.

```text
low = 2
mid = 2
high = 3
```

Diagram:

```text
[0, 0, 1, 1, 2, 2]
       L
       M
          H
```

Again, we do not move `mid`, because the new value at `mid` must be checked.

---

## Step 5

Current value:

```text
nums[mid] = 1
```

Since it is `1`, just move `mid`.

```text
low = 2
mid = 3
high = 3
```

Diagram:

```text
[0, 0, 1, 1, 2, 2]
       L
          M
          H
```

---

## Step 6

Current value:

```text
nums[mid] = 1
```

Again, move `mid`.

```text
low = 2
mid = 4
high = 3
```

Diagram:

```text
[0, 0, 1, 1, 2, 2]
       L
          H
             M
```

Now:

```text
mid > high
```

So we stop.

---

## Final Output

```text
[0, 0, 1, 1, 2, 2]
```

---

## Complete Movement Summary

```text
Initial:
[2, 0, 2, 1, 1, 0]
 L
 M
                H

Step 1: nums[mid] = 2, swap with high
[0, 0, 2, 1, 1, 2]
 L
 M
             H

Step 2: nums[mid] = 0, swap with low
[0, 0, 2, 1, 1, 2]
    L
    M
             H

Step 3: nums[mid] = 0, swap with low
[0, 0, 2, 1, 1, 2]
       L
       M
             H

Step 4: nums[mid] = 2, swap with high
[0, 0, 1, 1, 2, 2]
       L
       M
          H

Step 5: nums[mid] = 1, move mid
[0, 0, 1, 1, 2, 2]
       L
          M
          H

Step 6: nums[mid] = 1, move mid
[0, 0, 1, 1, 2, 2]
       L
          H
             M

Stop: mid > high
```

---

## Python Solution

```python
def sort_colors(nums):
    low = 0
    mid = 0
    high = len(nums) - 1

    while mid <= high:
        if nums[mid] == 0:
            nums[low], nums[mid] = nums[mid], nums[low]
            low += 1
            mid += 1

        elif nums[mid] == 1:
            mid += 1

        else:  # nums[mid] == 2
            nums[mid], nums[high] = nums[high], nums[mid]
            high -= 1

    return nums


nums = [2, 0, 2, 1, 1, 0]
print(sort_colors(nums))
```

Output:

```text
[0, 0, 1, 1, 2, 2]
```

---

## Java Solution

```java
public class SortColors {

    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
```

Output:

```text
0 0 1 1 2 2
```

---

## Time and Space Complexity

```text
Time Complexity:  O(n)
Space Complexity: O(1)
```

Why?

- We process each element at most once.
- We do not use any extra array.
- Sorting happens in-place.

---

## Why This Is Better Than Counting Sort

A counting approach would count the number of `0`s, `1`s, and `2`s and then overwrite the array.

That is also:

```text
Time:  O(n)
Space: O(1)
```

But Dutch National Flag is often preferred in interviews because:

- It is single-pass.
- It is in-place.
- It teaches partitioning logic.
- It is useful for many other problems.

---

## Important Interview Point

When `nums[mid] == 2`, we swap with `high`, but we do not increment `mid`.

Example:

```text
[2, 0, 1]
```

Initial:

```text
mid = 0
high = 2
nums[mid] = 2
```

Swap with high:

```text
[1, 0, 2]
```

Now `nums[mid] = 1`, which still needs to be checked.

If we increase `mid` immediately, we may skip this value.

---

## Common Mistakes

### Mistake 1: Incrementing mid after swapping with high

Wrong:

```python
else:
    nums[mid], nums[high] = nums[high], nums[mid]
    high -= 1
    mid += 1  # wrong
```

Why wrong?

Because the element that came from `high` is unknown.

---

### Mistake 2: Using while mid < high instead of mid <= high

Wrong:

```python
while mid < high:
```

Correct:

```python
while mid <= high:
```

Because the element at `mid == high` also needs to be processed.

---

### Mistake 3: Thinking this is normal sorting

This is not comparison sorting like merge sort or quicksort.

This is a partitioning problem because there are only three known categories.

---

## Easy Memory Trick

```text
0 -> push left
1 -> stay in middle
2 -> push right
```

Or:

```text
0 means low side
1 means move forward
2 means high side
```

---

## How to Identify This Pattern

Use Dutch National Flag when:

- Array has limited categories.
- You need in-place sorting or grouping.
- You need single-pass solution.
- You are partitioning elements into groups.

Examples:

```text
0s, 1s, 2s
Red, White, Blue
Negative, Zero, Positive
Small, Equal, Large
Even, Odd
```

---

## Related Problems

### 1. Sort Colors

Same problem.

```text
Input:  [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

Pattern:

```text
Dutch National Flag
```

---

### 2. Move Zeroes

Move all zeroes to the end while maintaining order of non-zero elements.

```text
Input:  [0,1,0,3,12]
Output: [1,3,12,0,0]
```

Pattern:

```text
Two Pointers
```

---

### 3. Segregate Even and Odd Numbers

Move even numbers to one side and odd numbers to the other side.

```text
Input:  [1,2,3,4,5,6]
Output: [2,4,6,1,3,5]
```

Pattern:

```text
Two Pointers / Partitioning
```

---

### 4. Segregate Positive and Negative Numbers

Move negative numbers to one side and positive numbers to the other side.

```text
Input:  [-1, 2, -3, 4, 5, -6]
Output: [-1, -3, -6, 4, 5, 2]
```

Pattern:

```text
Two Pointers / Partitioning
```

---

### 5. Partition Array Around Pivot

Given a pivot, move smaller elements before pivot and greater elements after pivot.

```text
Input:  [9, 12, 3, 5, 14, 10, 10], pivot = 10
Output: [9, 3, 5, 10, 10, 12, 14]
```

Pattern:

```text
Partitioning / QuickSort Partition
```

---

### 6. QuickSort Partition

QuickSort uses a similar partitioning concept.

```text
Smaller than pivot | Pivot | Greater than pivot
```

Pattern:

```text
Partitioning
```

---

### 7. Sort Array by Parity

Move even numbers first, then odd numbers.

```text
Input:  [3,1,2,4]
Output: [2,4,3,1]
```

Pattern:

```text
Two Pointers
```

---

### 8. Three-Way Partitioning

Partition array into three parts:

```text
less than pivot | equal to pivot | greater than pivot
```

This is a direct variation of Dutch National Flag.

Pattern:

```text
Dutch National Flag
```

---

## Final Summary

The optimal approach for sorting `0`s, `1`s and `2`s is the Dutch National Flag algorithm.

It uses three pointers:

```text
low, mid, high
```

The array is divided into four regions:

```text
[0s][1s][Unknown][2s]
```

Rules:

```text
nums[mid] == 0 -> swap with low, move low and mid
nums[mid] == 1 -> move mid
nums[mid] == 2 -> swap with high, move high only
```

Complexity:

```text
Time:  O(n)
Space: O(1)
```

This is one of the most important array partitioning patterns for coding interviews.
