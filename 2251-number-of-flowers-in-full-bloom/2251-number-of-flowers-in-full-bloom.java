class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] flower : flowers) {
            int start = flower[0];
            int end = flower[1] + 1;

            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }

        int[][] flowersData = new int[map.size()][2];

        int flowersBloom = 0;
        int i = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            flowersBloom += entry.getValue();
            flowersData[i][0] = entry.getKey();
            flowersData[i][1] = flowersBloom;
            i++;
        }

        int[] res = new int[people.length];

        for (int j = 0; j < people.length; j++) {

            int time = people[j];

            // Before the first event
            if (time < flowersData[0][0]) {
                res[j] = 0;
                continue;
            }

            boolean found = false;

            for (int k = 1; k < flowersData.length; k++) {

                if (time == flowersData[k][0]) {
                    res[j] = flowersData[k][1];
                    found = true;
                    break;
                }

                if (time < flowersData[k][0]) {
                    res[j] = flowersData[k - 1][1];
                    found = true;
                    break;
                }
            }

            // After the last event OR only one event exists
            if (!found) {
                if (time >= flowersData[flowersData.length - 1][0]) {
                    res[j] = flowersData[flowersData.length - 1][1];
                }
            }
        }

        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna