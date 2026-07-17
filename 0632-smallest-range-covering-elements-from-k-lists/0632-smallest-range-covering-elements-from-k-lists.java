class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int right = Integer.MIN_VALUE;

        int resLeft = 0;
        int resRight = Integer.MAX_VALUE;

        // Put first element of every list into heap
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            pq.offer(new int[]{val, i, 0});
            right = Math.max(right, val);
        }

        while (pq.size() == nums.size()) {

            int[] cur = pq.poll();

            int left = cur[0];
            int listIdx = cur[1];
            int eleIdx = cur[2];

            // Update answer
            if ((right - left) < (resRight - resLeft) ||
                ((right - left) == (resRight - resLeft) && left < resLeft)) {

                resLeft = left;
                resRight = right;
            }

            // Move to next element in the same list
            eleIdx++;

            if (eleIdx < nums.get(listIdx).size()) {

                int val = nums.get(listIdx).get(eleIdx);

                right = Math.max(right, val);

                pq.offer(new int[]{
                        val,
                        listIdx,
                        eleIdx
                });
            }
        }

        return new int[]{resLeft, resRight};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna