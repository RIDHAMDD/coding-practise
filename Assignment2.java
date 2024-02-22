import java.util.*;

public class Assignment2 {
    /**
     * Question 1
     */
    public static boolean isAnagram(String a, String b) {

        a = a.toUpperCase(); // Convert both strings to uppercase to ignore case differences
        b = b.toUpperCase(); // Convert both strings to uppercase to ignore case differences
        int[] arra = new int[26]; // Create an array to store the frequency of each letter in string a
        int[] arrb = new int[26]; // Create an array to store the frequency of each letter in string b

        // for Loop through string a and increment the frequency of each letter in the
        // corresponding index
        for (int i = 0; i < a.length(); i++) { // O(n)
            char c = a.charAt(i);
            arra[(int) c - 65]++;
        }
        // For Loop through string a and increment the frequency of each letter in the
        // corresponding index
        for (int j = 0; j < b.length(); j++) { // O(n)
            char cc = b.charAt(j);
            arrb[(int) cc - 65]++;
        }
        // Compare the two frequency arrays using the Arrays.equals() method
        // If the arrays are equal, return true, otherwise return false
        return Arrays.equals(arra, arrb); // Constant time as Array size is fixed
        // Total running time => 2*O(n) => O(n)
    }

    /**
     * Question 2
     */
    public static int[] addsUp(int x, int[] array) { // https://www.javatpoint.com/java-hashmap I used this website to
                                                     // learn more about different methods in a HashMap
        HashMap<Integer, Integer> map = new HashMap<>(); // Create a HashMap to store each element of the array as a key
                                                         // and its index as a value
        int z = 0, g = 0;
        // Loop through the array and add each element and its index to the HashMap
        for (int i = 0; i < array.length; i++) { // O(n)
            map.put(array[i], i); // Key and KeyValue
        }
        // Loop through the array
        for (int j = 0; j < array.length; j++) { // O(n)
            // If the HashMap contains the difference between the target value x and the
            // current element, and the index of that difference is not equal to the index
            // of the current element,
            // set the variable z to the index of the current element and break out of the
            // loop
            if (map.containsKey(x - array[j]) && j != map.get(x - array[j])) {
                z = j;
                break;
            }
        }

        int m = x - array[z]; // Calculate the value that, when added to the element at index z, will equal
                              // the target value x
        // Loop through the array
        for (int q = 0; q < array.length; q++) { // O(n)
            // If the current element equals the value calculated above and its index is not
            // equal to z,
            // set the variable g to the index of the current element and break out of the
            // loop+
            if (array[q] == m && q != z) {
                g = q;
                break;
            }
        }
        // Return an array containing the indices z and g
        return new int[] { z, g }; // Total running time => 3*O(n) => O(n)
    }

    /**
     * Question 3
     */
    public static int oddTimes(int[] array) {// [Extra Credit solution] using linear time and without using any extra
                                             // memory.
        // sort the array in ascending order using Java's built-in method.
        Arrays.sort(array); // O(n log n)
        int counter = 1, i = 0; // initialize a counter and an variable for the while loop

        // iterate through the array
        while (i < array.length - 1) { // O(n)
            if (array[i] == array[i + 1]) { // if the current element and the next element are equal,
                i++; // if so then increment the counter and index variable
                counter++;
            } else {
                if (counter % 2 != 0) { // check if the counter is odd
                    return array[i]; // if yes, return the current element
                } else { // if the counter is even, reset the counter to 1 and increment the index
                         // variable and check for the next unique element
                    counter = 1;
                    i++;
                }
            }
        }
        if (counter % 2 != 0) { // check if the last element in the array has an odd count
            return array[array.length - 1];
        }
        return 0; // return 0 if no odd appearing element is found
    }

    /**
     * Question 4
     */
    public static boolean sumOfZero(int[] array) {
        int sum = 0; // initialize sum to 0
        Set<Integer> set = new HashSet<Integer>(); // create a new HashSet to store the sum of array elements
        set.add(sum); // Adding a 0 to the set, so that later we can just check if the calculated sum
                      // which might be 0, is present in the set or not
        // iterate through the array
        for (int i = 0; i < array.length; i++) {
            // if an element in the array is 0, return true
            if (array[i] == 0) {
                return true;
            }
            // calculate the sum of the elements in the array up to this point
            sum = sum + array[i];
            // if the current sum is already in the HashSet, return true
            if (set.contains(sum)) {
                return true;
            } else
                set.add(sum);// otherwise, add the current sum to the HashSet
        }
        return false; // if no section that adds to 0 is found, return false
    }

    /**
     * Question 5
     */
    public static int[][] areReverses(int[][] array) {
        List<int[]> result = new ArrayList<int[]>(); // create a new ArrayList to store pair of reverse array
        for (int i = 0; i < array.length - 1; i++) { // amortized time complexity of O(n)
            for (int j = i + 1; j < array.length; j++) {
                if (array[i][0] == array[j][1] && array[i][1] == array[j][0]) { // Checking if two pairs are equal
                    result.add(new int[] { array[i][0], array[i][1] }); // adding pair 1
                    result.add(new int[] { array[j][0], array[j][1] }); // adding pair 2, manually swapping the elements
                }
            }
        }
        return result.toArray(new int[0][0]); // printing out the whole list as a array format
    }

    /**
     * Question 6
     */
    public static int[] inOrderOfAppearance(int[] array) {

        HashMap<Integer, Integer> map = new HashMap<>(); // Create a new HashMap to store the count of each element
                                                         // occurring in the array
        List<Integer> unique = new ArrayList<Integer>(); // Create a new ArrayList to store the unique elements in the
                                                         // array
        for (int val : array) { // Loop through the array to count the occurrence of each element and add unique
                                // elements to the unique list
            if (!unique.contains(val)) {
                unique.add(val);
            }
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else
                map.put(val, 1);
        }
        for (int j = 0; j < array.length; j++) { // Loop through the array again to reorder the elements according to
                                                 // their occurrence and order of appearance
            for (int val : unique) { // Loop through the unique list to access each unique element
                int temp = 0;
                while (temp < map.get(val)) { // adds the element map.get(val); times in the array as that is the amount
                                              // of time it occured in the array
                    array[j] = val;
                    temp++;
                    j++; // As we are also increasing j here
                }
            }
        }
        return array; // Return the reordered array
    }

    /**
     * Question 7
     */
    public static boolean secretCode(String a, String b) {
        a = a.toUpperCase(); // Convert both strings to upper case to make the comparisons case-insensitive
        b = b.toUpperCase();
        char c;
        boolean che = true;
        // Create a HashMap to store the mappings of each character in string a to its
        // corresponding character in string b
        HashMap<Character, Character> map = new HashMap<>();
        // If the length of the two strings is not equal, they can't be converted into
        // each other
        if (a.length() != b.length()) { // Hence return false
            return false;
        }
        // Loop through each character of string a
        for (int i = 0; i < a.length(); i++) { // O(n)
            // Check if the character at the current index of string a is different from the
            // character at the same index in string b
            boolean check = a.charAt(i) != b.charAt(i);
            // If the current character in string a has already been mapped to a character
            // in string b, then getting the mapping character from the HashMap
            if (map.containsKey(a.charAt(i))) {
                c = map.get(a.charAt(i));
                che = c == b.charAt(i); // Check if the mapping is consistent with the current character in string b
            }
            if (!che) { // If the mapping is not consistent, return false
                return false;
            }
            // Add the current mapping to the HashMap
            map.put(a.charAt(i), b.charAt(i));
            if (check) { // If the current characters in string a and string b are the same, continue
                         // with the loop
                continue;
            }
            return false; // If the current characters in string a and string b are not the same, return
                          // false
        }
        return true; // If all the characters in string a can be replaced with another character to
                     // get string b, return true
    }
}
