# Last updated: 9/5/2026, 11:59:35 AM
from functools import lru_cache

class Solution:
    def totalWaviness(self, num1: int, num2: int) -> int:
        
        def get_waviness(limit: int) -> int:
            if limit < 100:
                return 0
            
            s = str(limit)
            n = len(s)
            
            @lru_cache(None)
            def dfs(idx, prev1, prev2, is_tight, is_leading_zero):
                if idx == n:
                    # Return (count_of_valid_numbers, total_waviness)
                    return 1, 0
                
                max_digit = int(s[idx]) if is_tight else 9
                total_cnt = 0
                total_wave = 0
                
                for d in range(max_digit + 1):
                    next_tight = is_tight and (d == max_digit)
                    next_leading_zero = is_leading_zero and (d == 0)
                    
                    # Compute values from subsequent states
                    next_prev1 = -1 if next_leading_zero else d
                    next_prev2 = prev1
                    
                    cnt, wave = dfs(idx + 1, next_prev1, next_prev2, next_tight, next_leading_zero)
                    
                    total_cnt += cnt
                    total_wave += wave
                    
                    # Check if 'prev1' is a peak or a valley
                    if not is_leading_zero and prev2 != -1 and prev1 != -1:
                        if (prev2 < prev1 and prev1 > d) or (prev2 > prev1 and prev1 < d):
                            # This specific wave position appears in 'cnt' downstream paths
                            total_wave += cnt
                            
                return total_cnt, total_wave

            # Start from index 0, with dummy values (-1) for previous digits
            return dfs(0, -1, -1, True, True)[1]
        
        return get_waviness(num2) - get_waviness(num1 - 1)