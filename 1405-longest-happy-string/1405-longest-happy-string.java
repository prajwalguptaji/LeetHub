class Solution {
    public String longestDiverseString(int a, int b, int c) {

        int c_a = 0, c_b = 0, c_c = 0;
        StringBuilder res = new StringBuilder();

        while (true) {

            if (a > 0 &&
                    ((c_a < 2 && a >= b && a >= c) ||
                     (c_b == 2 && a >= c) ||
                     (c_c == 2 && a >= b))) {

                res.append('a');
                c_a++;
                c_b = 0;
                c_c = 0;
                a--;
            }

            else if (b > 0 &&
                    ((c_b < 2 && b >= a && b >= c) ||
                     (c_a == 2 && b >= c) ||
                     (c_c == 2 && b >= a))) {

                res.append('b');
                c_a = 0;
                c_b++;
                c_c = 0;
                b--;
            }

            else if (c > 0 &&
                    ((c_c < 2 && c >= a && c >= b) ||
                     (c_a == 2 && c >= b) ||
                     (c_b == 2 && c >= a))) {

                res.append('c');
                c_a = 0;
                c_b = 0;
                c_c++;
                c--;
            }

            else {
                break;
            }
        }

        return res.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna