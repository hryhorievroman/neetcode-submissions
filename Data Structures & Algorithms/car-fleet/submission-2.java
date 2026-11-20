class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> destinationTime = new Stack<>();

        for (int i = 0; i < cars.length; i++) {
            double destTime = (double) (target - cars[i][0]) / cars[i][1];

            if (destinationTime.empty() || destTime > destinationTime.peek()) {
                destinationTime.push(destTime);
            }
        }
        return destinationTime.size();
    }
}
