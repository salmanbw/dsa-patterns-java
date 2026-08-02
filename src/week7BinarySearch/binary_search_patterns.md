# Binary Search on Partition & Answer Space Patterns

# 1. K-th Element of Two Sorted Arrays

## Core Idea

Instead of merging arrays:

- Partition both arrays
- Keep exactly `k` elements on LEFT side
- Binary search on partition position

---

## Important Definitions

```text
cut1 = elements taken from array a
cut2 = elements taken from array b
```

Condition:

```text
cut1 + cut2 = k
```

---

## Why Binary Search on Smaller Array?

Always perform binary search on smaller array because:

- Smaller search space
- Safer partition boundaries
- Better complexity

---

## Binary Search Range

```text
low  = max(0, k - n)
high = min(k, m)
```

Where:

```text
m = size of smaller array
n = size of larger array
```

---

## Partition Boundary Values

```text
left1  = last element on left of a
right1 = first element on right of a

left2  = last element on left of b
right2 = first element on right of b
```

---

## Valid Partition Condition

```text
left1 <= right2
AND
left2 <= right1
```

If valid:

```text
answer = max(left1, left2)
```

---

## Movement Logic

### Case 1

```text
left1 > right2
```

Meaning:

```text
Too many elements taken from a
```

Move:

```text
high = cut1 - 1
```

---

### Case 2

```text
left2 > right1
```

Meaning:

```text
Too few elements taken from a
```

Move:

```text
low = cut1 + 1
```

---

## Pseudo Code

```text
if a is larger than b:
    swap(a,b)

low  = max(0, k-n)
high = min(k,m)

while low <= high:

    cut1 = (low+high)/2
    cut2 = k-cut1

    compute left1,right1,left2,right2

    if valid partition:
        return max(left1,left2)

    else if left1 > right2:
        move left

    else:
        move right
```

---

# 2. Median of Two Sorted Arrays

## Core Idea

Exactly same partition logic as K-th element.

Difference:

Instead of:

```text
k elements on LEFT
```

we keep:

```text
(total length + 1)/2 elements on LEFT
```

---

## Valid Partition

```text
left1 <= right2
AND
left2 <= right1
```

---

## Median Formula

### Odd Length

```text
max(left1,left2)
```

### Even Length

```text
(max(left1,left2) + min(right1,right2))/2
```

---

## Pseudo Code

```text
binary search on smaller array

find partition

if partition valid:
    calculate median

else move left/right
```

---

# 3. Binary Search on Answer Pattern

This pattern is different from index binary search.

We do NOT search for element.

We search for:

- capacity
- distance
- threshold
- maximum/minimum valid answer

---

# Generic Framework

## Step 1

Define search space.

Example:

```text
minimum possible answer
maximum possible answer
```

---

## Step 2

Binary search on answer.

---

## Step 3

Write feasibility function.

```text
Can this answer work?
```

---

## Generic Pseudo Code

```text
low = minimum possible answer
high = maximum possible answer

while low <= high:

    mid = (low+high)/2

    if possible(mid):
        store answer
        move left/right

    else:
        move opposite direction
```

---

# 4. Aggressive Cows

## Goal

Maximize minimum distance between cows.

---

## Binary Search On

```text
distance
```

---

## Feasibility Function

```text
Can we place all cows with at least mid distance?
```

---

## Pseudo Code

```text
sort array

low = 1
high = max distance

while low <= high:

    mid = distance

    if placement possible:
        answer = mid
        move right

    else:
        move left
```

---

# 5. Allocate Books

## Goal

Minimize maximum pages assigned to student.

---

## Binary Search On

```text
maximum pages
```

---

## Feasibility Function

```text
Can books be allocated within mid pages?
```

---

## Pseudo Code

```text
low = max book pages
high = sum of all pages

while low <= high:

    mid = candidate answer

    if allocation possible:
        answer = mid
        move left

    else:
        move right
```

---

# 6. Split Array Largest Sum

Same pattern as Allocate Books.

---

## Binary Search On

```text
largest subarray sum
```

---

## Feasibility

```text
Can array be split within allowed sum?
```

---

# 7. Capacity To Ship Packages Within D Days

## Binary Search On

```text
ship capacity
```

---

## Feasibility

```text
Can all packages be shipped within D days?
```

---

# 8. Search in Rotated Sorted Array

## Pattern

Binary search using sorted half elimination.

---

## Key Idea

At least one half is always sorted.

Use sorted half to eliminate search space.

---

## Pseudo Code

```text
while low <= high:

    mid = (low+high)/2

    if target found:
        return

    if left half sorted:
        decide whether target lies there

    else:
        right half sorted
        decide accordingly
```

---

# 9. Find Peak Element

## Key Idea

Use slope direction.

---

## Observation

```text
if arr[mid] < arr[mid+1]
```

Peak exists on right.

Else:

Peak exists on left.

---

## Pseudo Code

```text
while low < high:

    mid = (low+high)/2

    if increasing slope:
        move right

    else:
        move left
```

---

# 10. K-th Smallest Element in Sorted Matrix

## Binary Search On

```text
value
```

---

## Feasibility

```text
How many elements <= mid?
```

---

## Pseudo Code

```text
low = smallest value
high = largest value

while low <= high:

    mid = candidate value

    count elements <= mid

    if count >= k:
        move left

    else:
        move right
```

---

# Important Binary Search Categories

| Type | Search Space |
|---|---|
| Binary Search on Index | indices |
| Binary Search on Answer | answer space |
| Binary Search on Partition | partition positions |

---

# Master Interview Mindset

Do NOT ask:

```text
Can I binary search the element?
```

Ask:

```text
What is the search space?
```

Possible search spaces:

- index
- answer
- partition
- distance
- capacity
- threshold

---

# Recognition Signals

| Signal | Think |
|---|---|
| sorted arrays | binary search |
| kth smallest | partition/answer |
| minimize maximum | answer space |
| maximize minimum | answer space |
| feasible/impossible | binary search |
| eliminate half | binary search |

