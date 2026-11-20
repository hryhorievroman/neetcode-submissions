class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int biggestPile = 0;
        for (int pile : piles) {
            biggestPile = Math.max(biggestPile, pile);
        }

        int left = 1;
        int right = biggestPile;
        int minSpeed = biggestPile;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long totalHours = 0;
            for (int pile : piles) {
                totalHours += Math.ceil((double) pile / mid);
            }

            if (totalHours <= h) {
                minSpeed = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minSpeed;
    }
}
