#include <iostream>
#include <vector>

using namespace std ;
int depth[10004] ;
vector<vector<int>>child(10004,vector<int>()) ;
void calculateDepth(int node, int dep)
{
    depth[node] = dep ;
    for(int m : child[node])
    {
        calculateDepth(m, dep+1);
    }
    
}
int main ()
{
    int t,n,a,b,num;
    cin >> t ;
    while(t)
    {   t--;
        for (int i = 0; i < child.size(); i++) {
            child[i].clear();
        }
        memset(depth, 0, sizeof(depth));
        int root,de = 0 ;
        int parent[100] = {0, };
        //int v[100];
        cin >> n;
        num = n ;
        while (n-1)
        {
            cin >> a >> b;
            // 부모 관계만 기록
            parent[b] = a ;
            child[a].push_back(b);  // 부모노드 저장
            n--;
        }
        for (int i=1; i< num; i++) // root 가 뭔지 찾는방법
        {
            if (!parent[i])
            {
                root = i ;
                //cout << root ;
                calculateDepth(root, 0);
                break;
            }
        }
        cin >> a >> b;
        // lca 구하는 로직
        while (1)
        {
            if(depth[a]>depth[b])
            {
                a = parent[a];
            }
            else if(depth[a]<depth[b])
            {
                b = parent[b];
            }
            else {
                if(a==b)
                {
                    cout << a << "\n";
                    break;
                }
                else
                {
                    a = parent[a];
                    b = parent[b];
                }
            }
        }
        
    }
    
    
}
