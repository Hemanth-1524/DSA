
import java.util.HashMap;

public class MaxSubarraySize {

    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        long window = 0;

        for (int i = 0; i < k; i++) {
            window += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        long max_sum = 0;
        if (map.size() == k) {
            max_sum = window;
        }

        for (int i = k; i < n; i++) {
            window += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            window -= nums[i - k];
            map.put(nums[i - k], map.getOrDefault(nums[i - k], 0) - 1);

            if (map.get(nums[i - k]) == 0) {
                map.remove(nums[i - k]);
            }

            if (map.size() == k) {
                max_sum = Math.max(max_sum, window);
            }
        }

        return max_sum;

    }
}
