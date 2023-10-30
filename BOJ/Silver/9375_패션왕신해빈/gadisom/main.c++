#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <unordered_map>
using namespace std;
int main()
{
    std::ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n;
    cin >> n;
    for(int i=0; i<n; i++)
    {
        int m;
        string l,s;
        cin >>m ;
        unordered_map<string, int>myMap ;

        for(int j=0; j<m; j++)
        {
            cin >> l >> s;
            if(myMap.find(s) != myMap.end())
            {
                ++myMap[s];
            }
            else {
                myMap[s] = 1;
            }
        }
        int sum = 1;
        for (auto m : myMap)
        {
            sum *= (m.second+1);
        }
        cout << sum -1 << "\n";
        
    }
    
}
