
public class SubarrayProdLTk {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int prod = 1;
        int scnt = 0;
        for (int r = 0; r < n; r++) {
            prod *= nums[r];

            while (prod >= k) {
                prod /= nums[l];
                l++;
            }
            scnt += (r - l) + 1;
        }
        return scnt;
    }
}
