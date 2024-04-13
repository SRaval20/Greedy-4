// ******************** Map, Binary Search ********************
// Time Complexity:  O(n*log(m))
// Space Complexity: O(1)
// where m = length of source, n = length of target

public class Main {
    
    public static void main(String[] args) {
        Main obj = new Main();
        String source1 = "abc"; String target1 = "acbdc";
        String source2 = "xyz"; String target2 = "xzyxz";
        System.out.println(obj.shortestWayToFormString(source1, target1));
        System.out.println(obj.shortestWayToFormString(source2, target2));
    }
    
    private int shortestWayToFormString(String source, String target) {
        
        int sl = source.length();
        int tl = target.length();
        
        if(sl==0 || tl==0) 
            return 0;
        
        int sp = 0;                        
        int tp = 0;
        int count = 1;
        Map<Character, List<Integer>> sourceIndexes = new HashMap<>();
        
        for(int i=0; i<source.length(); i++) {
            char sc = source.charAt(i);
            if(!sourceIndexes.containsKey(sc))                       // adding source character in map
                sourceIndexes.put(sc, new ArrayList<>());
            sourceIndexes.get(sc).add(i);                            // adding index in map
        }
        
        while(tp < tl) {           
            
            char tc = target.charAt(tp);
            if(!sourceIndexes.containsKey(tc))                       // if character absent in source
                return -1;
            
            List<Integer> list = sourceIndexes.get(tc);
            
            int k = Collections.binarySearch(list, sp);
            
            if(k < 0) {                                              // no exact match in list, but have character later
                k = -k-1;                                            // get the index of that value present in list
            }
            
            if(k == list.size()) {                                   // source ended while finding next occuring
                count++;
                sp = 0;
            }
            else {                                                   // characters are matching, or we got index where the same character wil be appearing next
                sp = list.get(k);                                    // set sp to that index
                sp++;
                tp++;
            }
        }
        
        return count;
            
    }
    
}









// // ******************** Two pointer with set ********************
// // Time Complexity:  O(m*n)
// // Space Complexity: O(1)
// // where m = length of source, n = length of target

// public class Main {
    
//     public static void main(String[] args) {
//         Main obj = new Main();
//         String source1 = "abc"; String target1 = "acbdc";
//         String source2 = "xyz"; String target2 = "xzyxz";
//         System.out.println(obj.shortestWayToFormString(source1, target1));
//         System.out.println(obj.shortestWayToFormString(source2, target2));
//     }
    
//     private int shortestWayToFormString(String source, String target) {
        
//         int sl = source.length();
//         int tl = target.length();
        
//         if(sl==0 || tl==0) 
//             return 0;
        
//         int sp = 0;                        
//         int tp = 0;
//         int count = 0;
//         Set<Character> sourceChars = new HashSet<>();
        
//         for(int i=0; i<source.length(); i++) {
//             sourceChars.add(source.charAt(i));                       // adding source characters in set
//         }
        
//         while(tp < tl) {
//             while(sp < sl && tp < tl) {             
//                 if(!sourceChars.contains(target.charAt(tp)))         // if character absent in source
//                     return -1;
//                 if(source.charAt(sp) == target.charAt(tp)) {         // matching character
//                     sp++;                                            // increment source, and target pointers
//                     tp++;
//                 }
//                 else {                                               // not matching character
//                     sp++;                                            // increment source pointer only
//                 }
//             }
//             sp = 0;                                                  // reset after current count, and increment it
//             count++;
//         }
        
//         return count;
            
//     }
    
// }










// // ******************** Two pointer without set ********************
// // Time Complexity:  O(m*n)
// // Space Complexity: O(1)
// // where m = length of source, n = length of target

// public class Main {
    
//     public static void main(String[] args) {
//         Main obj = new Main();
//         String source1 = "abc"; String target1 = "acdbc";
//         String source2 = "xyz"; String target2 = "xzyxz";
//         System.out.println(obj.shortestWayToFormString(source1, target1));
//         System.out.println(obj.shortestWayToFormString(source2, target2));
//     }
    
//     private int shortestWayToFormString(String source, String target) {
        
//         int sl = source.length();
//         int tl = target.length();
        
//         if(sl==0 || tl==0) 
//             return 0;
        
//         int sp = 0;                        
//         int tp = 0;
//         int count = 0;
        
//         while(tp < tl) {
//             int temp = tp;                                           // to check whether character is absent in source
//             while(sp < sl && tp < tl) {             
//                 if(source.charAt(sp) == target.charAt(tp)) {         // matching character
//                     sp++;                                            // increment source, and target pointers
//                     tp++;
//                 }
//                 else {                                               // not matching character
//                     sp++;                                            // increment source pointer only
//                 }
//             }
//             if(temp == tp)                                           // if target pointer at same place, absent in source
//                 return -1;
//             sp = 0;                                                  // reset after current count, and increment it
//             count++;
//         }
        
//         return count;
            
//     }
    
// }
