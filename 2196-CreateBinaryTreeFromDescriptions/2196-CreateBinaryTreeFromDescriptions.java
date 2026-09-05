// Last updated: 9/5/2026, 12:03:01 PM
import java.util.*;

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> valToNode = new HashMap<>();
        Set<Integer> childrenSet = new HashSet<>();
        
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;
            
            // Generate nodes dynamically if missing
            valToNode.putIfAbsent(parentVal, new TreeNode(parentVal));
            valToNode.putIfAbsent(childVal, new TreeNode(childVal));
            
            // Link parent and child structures
            if (isLeft) {
                valToNode.get(parentVal).left = valToNode.get(childVal);
            } else {
                valToNode.get(parentVal).right = valToNode.get(childVal);
            }
            
            childrenSet.add(childVal);
        }
        
        // Find the absolute root
        for (int key : valToNode.keySet()) {
            if (!childrenSet.contains(key)) {
                return valToNode.get(key);
            }
        }
        
        return null;
    }
}