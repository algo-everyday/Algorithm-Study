#include <stdio.h>
#include <algorithm>
#include <cmath>
#include <vector>
#include <iostream>
using namespace std;
#pragma warning(disable: 4996)
int lot[51];
int arr[51];
void lotto(int loc, int s, int n)
{
    if (loc == 7)
    {
        for (int i = 1; i <= 6; i++)
        {
            printf("%d ", lot[i]);
        }
        printf("\n");
        return;
    }
    for (int i = s; i <= n; i++)
    {
        lot[loc] = arr[i];
        lotto(loc + 1, i + 1, n);
    }
}

int main()
{
    int t;
    while (1)
    {
        scanf("%d", &t);
        if (t == 0)
        {
            break;
        }
        
        for (int i = 1; i <= t; i++)
        {
            scanf("%d", &arr[i]);
        }
        lotto(1, 1, t);
        printf("\n");
    }

}
