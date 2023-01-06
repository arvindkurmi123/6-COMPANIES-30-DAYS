# TC = O(N)
we have an array and we have to calculate the max sum of that array multiplyin the respective indexes.
we will find the total sum of the array and after assigning the value of first function to max,
traverse the array. 
Every time we add the total sum of array because each element will be increased by one and minus the last element multiplying last index (n-1 +1) every time. 
### Note :  reason for(n-1 +1)
            n-1 (last index ) +1 (as we have increased eace element by one index so last index also will be incremented with total sum.
