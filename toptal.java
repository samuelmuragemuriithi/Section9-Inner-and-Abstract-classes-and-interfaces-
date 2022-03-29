package com.awesam;

import java.util.ArrayList;

public class toptal {
    public static int returnSubsequenceCount(int[] A, int S) {
        int count = 0;

        for (int k = 0; k < A.length; k++) {
            int[] sumArray = new int[A.length];

            sumArray[k] = A[k];

            if (A[k] == S) {
                count++;
            }

            for (int i = k + 1; i < A.length; i++) {
                int sum = sumArray[i - 1] + A[i];

                sumArray[i] = sum;

                if ((double) sum / (i - k + 1) == S) {
                    count++;
                }
            }
        }
        return count;
    }
    static int countKAverageSubarrays(int arr[], int n,
                                      int k)
    {

        // To Store the final answer
        int res = 0;

        // Calculate all subarrays
        for(int L = 0; L < n; L++)
        {
            int sum = 0;
            for(int R = L; R < n; R++)
            {

                // Calculate required average
                sum += arr[R];
                int len = (R - L + 1);

                // Check if average
                // is equal to k
                if (sum % len == 0)
                {
                    int avg = sum / len;

                    // Required average found
                    if (avg == k)

                        // Increment res
                        res++;
                }
            }
        }
        return res;
    }
    public int solution(int[] A)
    {
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (int k = 1; k < A.length - 1; k++)
        {
            if (A[k - 1] < A[k] && A[k + 1] < A[k])
            {
                newArray.add(k);
            }
        }
        if (newArray.size() == 1 || newArray.size() == 0)
        {
            return newArray.size();
        }
        int x = 1;
        int y = newArray.size();
        int ans = 1;
        while (x <= y)
        {
            int z = (x + y) / 2;
            boolean isSuc = false;
            int n = 0;
            int m = newArray.get(0);
            for (int i = 0; i < newArray.size(); i++)
            {
                if (newArray.get(i) >= m)
                {
                    n++;
                    m = newArray.get(i) + z;
                    if (n == z)
                    {
                        isSuc = true;
                        break;
                    }
                }
            }
            if (isSuc)
            {
                ans = z;
                x = z + 1;
            }
            else
            {
                y = z - 1;
            }
        }
        return ans;
    }

            public static void main(String[] args) {

    }
}
