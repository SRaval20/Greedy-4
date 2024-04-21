// ******************** Without Map ********************

// Time Complexity:  O(n)
// Space Complexity: O(1)

class Solution {
    
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = helper(tops, bottoms, tops[0]);
        if(result != -1) 
            return result;
        return helper(tops, bottoms, bottoms[0]);
    }
    
    private int helper(int[] tops, int[] bottoms, int num) {
        int n = tops.length;
        int topCount = 0;
        int bottomCount = 0;
        
        for(int i=0; i<n; i++) {
            if(tops[i]!=num && bottoms[i]!=num) return -1;
            if(tops[i]!=num) topCount++;
            if(bottoms[i]!=num) bottomCount++;
        }     
        
        return Math.min(topCount, bottomCount);
    }
}




// // ******************** Without Map ********************

// // Time Complexity:  O(n)
// // Space Complexity: O(1)

// class Solution {
//     public int minDominoRotations(int[] tops, int[] bottoms) {
        
//         int num = tops[0];
//         int n = tops.length;
//         int topCount = 0;
//         int bottomCount = 0;
//         int i=0;
        
//         for(i=0; i<n; i++) {
//             if(tops[i]!=num && bottoms[i]!=num) break;
//             if(tops[i]!=num) topCount++;
//             if(bottoms[i]!=num) bottomCount++;
//         }
        
//         if(i == n) 
//             return Math.min(topCount, bottomCount);
        
//         num = bottoms[0];
//         topCount = 0;
//         bottomCount = 0;
        
//         for(i=0; i<n; i++) {
//             if(tops[i]!=num && bottoms[i]!=num) break;
//             if(tops[i]!=num) topCount++;
//             if(bottoms[i]!=num) bottomCount++;
//         }        
        
//         if(i == n)
//             return Math.min(topCount, bottomCount);
//         return -1;
//     }
// }




// // ******************** With Map ********************

// // Time Complexity:  O(n)
// // Space Complexity: O(1)

// class Solution {
//     public int minDominoRotations(int[] tops, int[] bottoms) {
        
//         Map<Integer, Integer> map = new HashMap<>();
//         int num = 0;
//         int n = tops.length;
//         int topCount = 0;
//         int bottomCount = 0;
        
//         for(int i=0; i<n; i++) {
//             map.put(tops[i], map.getOrDefault(tops[i], 0) + 1);
//             if(map.get(tops[i]) >= n) {
//                 num = tops[i];
//                 break;
//             }
//             map.put(bottoms[i], map.getOrDefault(bottoms[i], 0) + 1);
//             if(map.get(bottoms[i]) >= n) {
//                 num = bottoms[i];
//                 break;
//             }
//         }
        
//         for(int i=0; i<n; i++) {
//             if(tops[i]!=num && bottoms[i]!=num) return -1;
//             if(tops[i]!=num) topCount++;
//             if(bottoms[i]!=num) bottomCount++;
//         }
        
//         return Math.min(topCount, bottomCount);
//     }
// }
