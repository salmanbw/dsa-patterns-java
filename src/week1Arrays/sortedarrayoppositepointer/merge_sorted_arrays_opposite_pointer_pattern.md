# Merge Sorted Arrays & Opposite Pointer Pattern

## 1. Pattern Name

This pattern is commonly known as:

- **Two Pointers**
- **Opposite Direction Two Pointers**
- **Backward Merge Pattern**
- **Greedy Edge Processing**

It is used when we can make a decision by comparing elements from the two ends of an array or from the ends of two sorted arrays.

---

## 2. Core Idea

The main question to ask is:

> Can I make a guaranteed decision using the leftmost or rightmost elements?

If yes, then the opposite pointer approach may work.

Instead of scanning with nested loops, we use pointers like:

```text
left  -> start of array
right -> end of array
```

or in merge problems:

```text
i -> end of first valid array
j -> end of second array
k -> final position to fill
```

---

## 3. Merge Sorted Array Using 3 Pointers

### Problem

Given two sorted arrays:

```text
nums1 = [1, 3, 5, 0, 0, 0]
nums2 = [2, 4, 6]
```

Merge `nums2` into `nums1` in sorted order without using extra space.

---

## 4. Why Merge From the Back?

If we merge from the front, we may overwrite useful values in `nums1`.

So we merge from the back because empty spaces are already available at the end.

---

## 5. Pointer Setup

```text
i = m - 1       // last valid element in nums1
j = n - 1       // last element in nums2
k = m + n - 1   // last position in nums1
```

Example:

```text
nums1 = [1, 3, 5, 0, 0, 0]
             i        k

nums2 = [2, 4, 6]
             j
```

---

## 6. Logic

Compare `nums1[i]` and `nums2[j]`.

- If `nums1[i] > nums2[j]`, place `nums1[i]` at `nums1[k]`
- Else, place `nums2[j]` at `nums1[k]`
- Move the selected pointer backward
- Move `k` backward

---

## 7. Java Code

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {

    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;

    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[k] = nums1[i];
            i--;
        } else {
            nums1[k] = nums2[j];
            j--;
        }
        k--;
    }

    while (j >= 0) {
        nums1[k] = nums2[j];
        j--;
        k--;
    }
}
```

---

## 8. Complexity

```text
Time Complexity  : O(m + n)
Space Complexity : O(1)
```

---

## 9. How This Relates to Opposite Pointer Pattern

The merge sorted array problem uses edge-based decision making.

At every step, we decide:

```text
Which remaining element is the largest?
```

The largest element must be at the end of one of the sorted arrays.

So we safely place it at the end and move backward.

---

## 10. Similarity With Sorted Squares

### Problem

```text
nums = [-4, -1, 0, 3, 10]
```

After squaring:

```text
[16, 1, 0, 9, 100]
```

This is not sorted.

But the largest square will always come from either:

- left side negative value
- right side positive value

So we compare both ends and fill the result from the back.


---

## 12. Similarity With Trapping Rain Water

In trapping rain water, we also use two pointers:

```text
left  -> start
right -> end
```

The water level depends on the smaller boundary.

At each step:

- If left side is smaller, process left
- If right side is smaller, process right

This is also greedy edge processing.

---

## 13. Trapping Rain Water Formula

```text
water at index = min(leftMax, rightMax) - height[index]
```

Only if the value is positive.


## 15. Common Thinking Across These Problems

All these problems use the same question:

> Can I safely finalize one side based on edge comparison?

| Problem | Edge Decision |
|---|---|
| Merge Sorted Array | Pick larger element from end |
| Sorted Squares | Pick larger square from both ends |
| Trapping Rain Water | Process smaller boundary |
| Container With Most Water | Move smaller height |
| Two Sum II | Move pointer based on sum |

---

## 16. How to Recognize This Pattern

Use opposite pointers when:

1. The array is sorted or has some order.
2. The answer depends on two ends.
3. You can eliminate one side after comparison.
4. You want to avoid nested loops.
5. The problem asks for `O(n)` time or `O(1)` space.

---

## 17. Common Problems in This Pattern

### Easy

1. Merge Sorted Array
2. Sorted Squares of a Sorted Array
3. Move Zeroes
4. Remove Duplicates from Sorted Array
5. Valid Palindrome

### Medium

1. Container With Most Water
2. Trapping Rain Water
3. Sort Colors
4. Two Sum II
5. 3Sum

### Advanced

1. In-place Merge Without Extra Space
2. Trapping Rain Water II
3. Minimum Window style variants
4. Partition-based array problems

---

## 18. Mental Model

Remember this line:

```text
If the answer can be decided from the edges, use two pointers.
```

For merge sorted array:

```text
Largest remaining element is at one of the ends.
```

For sorted squares:

```text
Largest square is at one of the ends.
```

For rain water:

```text
Water is controlled by the smaller wall.
```

---

## 19. Final Summary

The merge sorted array 3-pointer approach is not just a merge trick.

It belongs to a broader family:

```text
Opposite Direction Two Pointers + Greedy Edge Processing
```

Whenever you can compare edges and safely move one pointer, this pattern may apply.
