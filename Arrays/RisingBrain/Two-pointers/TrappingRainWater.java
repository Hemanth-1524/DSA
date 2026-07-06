
public class TrappingRainWater {

    public int trap(int[] height) {
        int n = height.length;

        int[] leftmax = new int[n];
        int[] rightmax = new int[n];

        leftmax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], height[i]);
        }

        rightmax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(height[i], rightmax[i + 1]);
        }

        int trappedwater = 0;
        for (int i = 0; i < n; i++) {
            trappedwater += (Math.min(leftmax[i], rightmax[i]) - height[i]);

        }

        return trappedwater;
    }

    public int trapopt(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int leftmax = 0;
        int rightmax = 0;
        int trap = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftmax = Math.max(leftmax, height[left]);
                trap += leftmax - height[left];
                left++;
            } else {
                rightmax = Math.max(rightmax, height[right]);
                trap += rightmax - height[right];
                right--;
            }
        }

        return trap;
    }

}
