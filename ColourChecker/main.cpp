#include <iostream>
#include <vector>
#include <cmath>

int main()
{
    int sum = 0;
    int n, d, r, a, j;
    std::cin >> n;
    std::vector<int> arr(n);
    int i = 0;
    while (i < n)
    {
        arr[i] = 0;
        i++;
    }

    j = i = 0;
    while (i < pow(3, n))
    {
        j = 0;
        d = i;
        while (d>0)
        {
            a = 0;
            r = d % 3;
            d = d / 3;
            arr[j] = r;
            j++;
			std::cout << 3*j+r;
			//std::cout << d*pow(3, j+1)+r;
        }
		
		// This prints the array each time it changes.
		while (a<n)
		{
			std::cout << arr[a];
			a++;
		}
		std::cout << std::endl; 
		sum += 1; // Sum is the number of times this loop runs
		
		i++;
     }
     std::cout << sum;
     return 0;
}
