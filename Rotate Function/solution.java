public class solution {
  public int maxRotateFunction(int[] nums) {
    int fn = 0;
    int total = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      fn += nums[i] * i;
      total += nums[i];
    }
    int max = fn;
    for (int j = 1; j < n; j++) {
      fn = fn + total - n * nums[n - j];
      max = Math.max(max, fn);
    }
    return max;
  }
}