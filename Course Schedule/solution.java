class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses <= 0)
      return false;
    Queue<Integer> qu = new LinkedList<>();
    // arr deg
    int[] deg = new int[numCourses];
    for (int i = 0; i < prerequisites.length; i++) {
      deg[prerequisites[i][0]]++;
    }

    for (int i = 0; i < numCourses; i++) {
      if (deg[i] == 0)
        qu.offer(i);
    }

    while (!qu.isEmpty()) {
      int c = qu.poll();

      for (int i = 0; i < prerequisites.length; i++) {
        if (c == prerequisites[i][1]) {
          if (--deg[prerequisites[i][0]] == 0)
            qu.offer(prerequisites[i][0]);
        }
      }
    }

    for (int n : deg) {
      if (n != 0)
        return false;
    }

    return true;
  }
}