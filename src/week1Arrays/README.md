# Kadane's Algorithm & Similar Patterns

---

# 1. Kadane's Algorithm

## Core Idea

At every index:

```text
Should I continue previous subarray?
OR
Start a new subarray from current element?
```

DP Relation:

```text
dp[i] = max(nums[i], dp[i-1] + nums[i])
```

Optimized Version:

```java
currentSum = Math.max(nums[i], currentSum + nums[i]);
maxSum = Math.max(maxSum, currentSum);
```

Time Complexity: `O(n)`  
Space Complexity: `O(1)`

---

# Pattern Type

- Dynamic Programming
- Greedy + DP Hybrid
- Carry Forward Pattern
- Running Sum Pattern

---

# Recognition Keywords

If the problem contains:

- contiguous
- continuous
- maximum sum
- best profit
- running contribution
- current vs previous
- largest streak

Think:

```text
Kadane / Carry Forward / DP Optimization
```

---

# Mental Model

```text
If previous computation is helping → continue it
If previous computation is hurting → discard it
```

---

# Important Problems Similar to Kadane

---

# 2. Maximum Subarray Sum

## Problem

Find contiguous subarray with maximum sum.

## Pattern

Classic Kadane.

## Leetcode

`53`

---

# 3. Best Time to Buy and Sell Stock

## Problem

Buy once and sell once for maximum profit.

## Core Idea

Keep:

```text
minimum buying price so far
maximum profit so far
```

## Pattern

Running Minimum + Running Maximum

## Logic

```java
minPrice = Math.min(minPrice, prices[i]);
profit = prices[i] - minPrice;
maxProfit = Math.max(maxProfit, profit);
```

## Leetcode

`121`

---

# 4. Maximum Product Subarray

## Problem

Find contiguous subarray with maximum product.

## Important Insight

Need both:

```text
maxProduct
minProduct
```

because:

```text
negative × negative = positive
```

## Pattern

Kadane Variant

## Leetcode

`152`

---

# 5. Maximum Sum Circular Subarray

## Problem

Subarray can wrap around.

Example:

```text
[5,-3,5]
```

Answer:

```text
10
```

## Pattern

```text
Normal Kadane
+
Minimum Subarray Kadane
```

## Leetcode

`918`

---

# 6. House Robber

## Problem

Cannot rob adjacent houses.

## Decision Pattern

At every house:

```text
Take current house
OR
Skip current house
```

## DP Relation

```text
dp[i] = max(
    dp[i-1],
    nums[i] + dp[i-2]
)
```

## Pattern

Decision DP

## Leetcode

`198`

---

# 7. Jump Game

## Problem

Can you reach the last index?

## Core Idea

Keep:

```text
farthest reachable index
```

## Pattern

Greedy Carry Forward

## Leetcode

`55`

---

# 8. Maximum Consecutive Ones

## Problem

Find longest continuous sequence of 1s.

## Pattern

Continuous Streak Pattern

## Leetcode

`485`

---

# 9. Binary Flip Problems

## Trick

Convert:

```text
0 → +1
1 → -1
```

Then apply Kadane.

## Pattern

Transformation + Kadane

---

# 10. 2D Kadane (Maximum Sum Rectangle)

## Problem

Find maximum sum rectangle in matrix.

## Pattern

Compress rows and apply Kadane.

## Difficulty

Hard

## Leetcode

`363`

---

# Common Kadane Family Patterns

| Pattern | Example Problems |
|---|---|
| Running Sum | Maximum Subarray |
| Running Best Value | Stock Buy/Sell |
| Decision DP | House Robber |
| Greedy Carry Forward | Jump Game |
| Continuous Sequence | Consecutive Ones |
| Transformation + Kadane | Binary Flip |
| 2D Kadane | Maximum Rectangle |

---

# Recommended Practice Order

1. Maximum Subarray
2. Stock Buy Sell
3. Maximum Product Subarray
4. House Robber
5. Jump Game
6. Circular Subarray
7. 2D Kadane

---

# Final Interview Insight

Most Kadane-like problems are asking:

```text
What is the best answer ending at current index?
```

or

```text
Should I continue previous computation
OR
start fresh from current index?
```
