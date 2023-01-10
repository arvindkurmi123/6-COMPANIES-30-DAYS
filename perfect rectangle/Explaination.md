First observation is there will be four point has count of 1 and other points have even count.

This is not enough, a counter example is two rectangles overlap exactly and another rectangle on the side.
[[0,0,1,1],[0,0,2,1],[1,0,2,1],[0,2,2,3]]

Ok, to deal with overlapping, we add a check to make sure all small rectangles add up to the same area of the big one.

This is still not enough to solve above use case. The problem is the four point cannot be any point, has to be the four of big one.

A rectangle has 4 corners. All corners must appear even number of times(because if the figure is a proper rectangle then all the corners will be contiguous) except for the corners.
Sum of areas of all small rectangles must equal to the big rectangle.
The bottom-left and the top right corners of the rectangle can be found by looking at the min and max of all points. Use that to figure out all 4 corners of rectangle. Then check if the corners left(after eliminating the corners that occur even number of times) are the ones that should be the corners (which can be figured out from the bottom-left and top-right corners).
