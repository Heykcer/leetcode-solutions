// Last updated: 8/13/2026, 10:08:15 PM
#include <vector>
#include <string>

class Solution {
private:
    int getWaviness(int x) {
        if (x < 100) return 0;
        
        std::vector<int> digits;
        while (x > 0) {
            digits.push_back(x % 10);
            x /= 10;
        }
        
        int waviness = 0;
        int m = digits.size();
        
        for (int i = 1; i < m - 1; ++i) {
            if ((digits[i] > digits[i - 1] && digits[i] > digits[i + 1]) ||
                (digits[i] < digits[i - 1] && digits[i] < digits[i + 1])) {
                waviness++;
            }
        }
        return waviness;
    }

public:
    int totalWaviness(int num1, int num2) {
        int totalSum = 0;
        for (int i = num1; i <= num2; ++i) {
            totalSum += getWaviness(i);
        }
        return totalSum;
    }
};