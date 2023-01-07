class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses <= 0)
      return false;
    Queue<Integer> q = new LinkedList<>();

    int[] indgree = new int[numCourses];
    for (int i = 0; i < prerequisites.length; i++) {
      indgree[prerequisites[i][0]]++;
    }

    for (int i = 0; i < numCourses; i++) {
      if (indgree[i] == 0)
        q.offer(i);
    }

    while (!q.isEmpty()) {
      int course = q.poll();

      for (int i = 0; i < prerequisites.length; i++) {
        if (course == prerequisites[i][1]) {
          if (--indgree[prerequisites[i][0]] == 0)
            q.offer(prerequisites[i][0]);
        }
      }
    }

    for (int n : indgree) {
      if (n != 0)
        return false;
    }

    return true;
  }
}