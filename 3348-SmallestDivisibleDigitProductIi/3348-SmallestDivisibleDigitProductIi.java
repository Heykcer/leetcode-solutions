// Last updated: 9/5/2026, 12:01:20 PM
import java.util.Arrays;

public class Solution {
    // Single digit prime factor counts lookup table (0 to 9)
    private static final int[][] FACTOR_COUNTS = {
        {0, 0, 0, 0}, // 0 (unused)
        {0, 0, 0, 0}, // 1
        {1, 0, 0, 0}, // 2
        {0, 1, 0, 0}, // 3
        {2, 0, 0, 0}, // 4
        {0, 0, 1, 0}, // 5
        {1, 1, 0, 0}, // 6
        {0, 0, 0, 1}, // 7
        {3, 0, 0, 0}, // 8
        {0, 2, 0, 0}  // 9
    };

    public String smallestNumber(String num, long t) {
        // Step 1: Prime factorization of t
        int[] targetCounts = new int[4]; // indices: 0->2, 1->3, 2->5, 3->7
        long temp = t;
        int[] primes = {2, 3, 5, 7};
        for (int i = 0; i < 4; i++) {
            while (temp % primes[i] == 0) {
                targetCounts[i]++;
                temp /= primes[i];
            }
        }
        // If t contains any other prime factors (e.g., 11), it is impossible
        if (temp > 1) {
            return "-1";
        }

        int n = num.length();
        int[] digits = new int[n];
        int firstZeroIndex = -1;

        for (int i = 0; i < n; i++) {
            digits[i] = num.charAt(i) - '0';
            if (digits[i] == 0 && firstZeroIndex == -1) {
                firstZeroIndex = i;
            }
        }

        // Count prime factors present in the initial string prefix
        int[] prefixCounts = new int[4];
        int scanLimit = (firstZeroIndex == -1) ? n : firstZeroIndex;
        for (int i = 0; i < scanLimit; i++) {
            for (int j = 0; j < 4; j++) {
                prefixCounts[j] += FACTOR_COUNTS[digits[i]][j];
            }
        }

        // Check if the current number already works perfectly
        if (firstZeroIndex == -1) {
            if (isSatisfied(prefixCounts, targetCounts)) {
                return num;
            }
        }

        // Step 2: Backtrack from right to left to find the first place to increment a digit
        for (int i = n - 1; i >= 0; i--) {
            // If we are at or past a zero index from the left, we can't retain this prefix
            if (i < scanLimit) {
                for (int j = 0; j < 4; j++) {
                    prefixCounts[j] -= FACTOR_COUNTS[digits[i]][j];
                }
            }

            if (i > firstZeroIndex && firstZeroIndex != -1) {
                continue;
            }

            // Try incrementing current position to a larger digit
            for (int biggerDigit = digits[i] + 1; biggerDigit <= 9; biggerDigit++) {
                int[] currentCounts = new int[4];
                for (int j = 0; j < 4; j++) {
                    currentCounts[j] = prefixCounts[j] + FACTOR_COUNTS[biggerDigit][j];
                }

                int[] required = new int[4];
                for (int j = 0; j < 4; j++) {
                    required[j] = Math.max(0, targetCounts[j] - currentCounts[j]);
                }

                int spaceAfter = n - 1 - i;
                int suffixDigitsNeeded = getMinDigitsNeeded(required);

                if (suffixDigitsNeeded <= spaceAfter) {
                    // Valid pivot found! Build matching string result
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < i; k++) {
                        sb.append(digits[k]);
                    }
                    sb.append(biggerDigit);
                    
                    int onesToFill = spaceAfter - suffixDigitsNeeded;
                    for (int k = 0; k < onesToFill; k++) {
                        sb.append('1');
                    }
                    sb.append(constructSuffix(required));
                    return sb.toString();
                }
            }
        }

        // Step 3: If no match within the same length, expand the string length
        int suffixDigitsNeeded = getMinDigitsNeeded(targetCounts);
        int targetLen = Math.max(n + 1, suffixDigitsNeeded);
        
        StringBuilder sb = new StringBuilder();
        int onesToFill = targetLen - suffixDigitsNeeded;
        for (int i = 0; i < onesToFill; i++) {
            sb.append('1');
        }
        sb.append(constructSuffix(targetCounts));
        return sb.toString();
    }

    private boolean isSatisfied(int[] current, int[] target) {
        for (int i = 0; i < 4; i++) {
            if (current[i] < target[i]) return false;
        }
        return true;
    }

    // Accurately calculates the exact minimal number of digits required to satisfy prime factors
    private int getMinDigitsNeeded(int[] required) {
        int r2 = required[0];
        int r3 = required[1];
        int r5 = required[2];
        int r7 = required[3];

        int count = r7 + r5;
        count += r3 / 2; // combined into 9s
        r3 %= 2;

        count += r2 / 3; // combined into 8s
        r2 %= 3;

        if (r3 == 1 && r2 >= 1) { // 3 * 2 = 6
            count++;
            r3 = 0;
            r2--;
        }
        if (r2 == 2) { // 2 * 2 = 4
            count++;
            r2 = 0;
        }
        count += r3 + r2;
        return count;
    }

    // Builds the smallest suffix string sequence using the leftover prime factors greedily
    private String constructSuffix(int[] required) {
        int r2 = required[0];
        int r3 = required[1];
        int r5 = required[2];
        int r7 = required[3];

        StringBuilder suffix = new StringBuilder();
        for (int i = 0; i < r7; i++) suffix.append('7');
        for (int i = 0; i < r5; i++) suffix.append('5');

        int n9 = r3 / 2;
        for (int i = 0; i < n9; i++) suffix.append('9');
        r3 %= 2;

        int n8 = r2 / 3;
        for (int i = 0; i < n8; i++) suffix.append('8');
        r2 %= 3;

        if (r3 == 1 && r2 >= 1) {
            suffix.append('6');
            r3 = 0;
            r2--;
        }
        if (r2 == 2) {
            suffix.append('4');
            r2 = 0;
        }
        if (r3 == 1) suffix.append('3');
        if (r2 == 1) suffix.append('2');

        char[] chars = suffix.toString().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
