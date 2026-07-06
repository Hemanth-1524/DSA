
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count = 0;
        int maxcount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxcount = Math.max(count, maxcount);
                count = 0;
            }
        }
        return Math.max(maxcount, count);
    }
}
