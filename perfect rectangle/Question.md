# [6. Perfect Rectangle](https://leetcode.com/problems/perfect-rectangle/description/)

## medium

Given an array rectangles where rectangles[i] = [xi, yi, ai, bi] represents an axis-aligned rectangle. The bottom-left point of the rectangle is (xi, yi) and the top-right point of it is (ai, bi).

Return true if all the rectangles together form an exact cover of a rectangular region.

 

## Example 1:

![image](https://user-images.githubusercontent.com/113417977/211669989-4549761f-0194-479b-9f96-77bb370ffb5e.png)

      Input: rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
      Output: true
      Explanation: All 5 rectangles together form an exact cover of a rectangular region.
## Example 2:
![image](https://user-images.githubusercontent.com/113417977/211669922-35a48b5a-65c8-4cc4-919d-8a386bd3f4ee.png)


      Input: rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
      Output: false
      Explanation: Because there is a gap between the two rectangular regions.
Example 3:

![image](https://user-images.githubusercontent.com/113417977/211669883-6d7dff87-80a9-4f21-9cf9-5c6ef9967608.png)

      Input: rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
      Output: false
      Explanation: Because two of the rectangles overlap with each other.
 

## Constraints:

      1 <= rectangles.length <= 2 * 104
      rectangles[i].length == 4
      -105 <= xi, yi, ai, bi <= 105
