class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        int[][] cars = new int[len][2];

        for (int i = 0; i < len; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> time = new Stack<>();

        for (int i = 0; i < len; i++) {
            double currTime = (double)(target - cars[i][0]) / cars[i][1];
            if (time.empty() || currTime > time.peek()) {
                time.push(currTime);
            }
        }

        return time.size();
    }
}
