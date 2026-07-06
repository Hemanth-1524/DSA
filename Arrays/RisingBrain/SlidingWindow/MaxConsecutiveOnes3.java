
public class MaxConsecutiveOnes3 {

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int zcount = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {
            if (nums[r] == 0) {
                zcount++;
            }
            while (zcount > k) {
                if (nums[l] == 0) {
                    zcount--;
                }

                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }

    public int longestOnesopt(int[] nums, int k) {
        int n = nums.length;
        int zcount = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {
            if (nums[r] == 0) {
                zcount++;
            }
            if (zcount > k) {
                if (nums[l] == 0) {
                    zcount--;
                }

                l++;
            }
        }
        return n - l;
    }
}
