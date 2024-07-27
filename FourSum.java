package CrackYourPlacementDay7;

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 0, -1, 0, -2, 2, 2, -1};
        int target = 0;
        System.out.println(sol.fourSum(nums, target));
    }
}
