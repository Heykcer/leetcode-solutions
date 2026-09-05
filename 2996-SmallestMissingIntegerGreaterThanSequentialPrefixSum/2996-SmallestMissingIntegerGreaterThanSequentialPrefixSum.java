// Last updated: 9/5/2026, 12:02:16 PM
class Solution {
  public int missingInteger(int[] nums) {
    Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    int ans = nums[0];

    for (int i = 1; i < nums.length; ++i) {
      if (nums[i] != nums[i - 1] + 1)
        break;
      ans += nums[i];
    }

    while (numsSet.contains(ans))
      ++ans;

    return ans;
  }
}