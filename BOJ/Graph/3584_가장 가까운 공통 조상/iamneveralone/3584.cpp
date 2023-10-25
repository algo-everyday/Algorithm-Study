#include <iostream>
#include <vector>
#include <deque>
#include <stack>
#include <queue>
#include <algorithm>
#include <cmath>
#include <climits>
#define INF INT_MAX

using namespace std;

int parent[10001];
bool visited[10001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int t; cin >> t;

	while (t--) {
		int N; cin >> N; // 트리를 구성하느 노드의 수

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			visited[i] = false;
		}
		
		for (int i = 0; i < N - 1; i++) {
			int a, b; cin >> a >> b; // a는 b의 부모
			parent[b] = a;
		}

		int u, v; cin >> u >> v;
		visited[u] = true;

		// 둘 중 하나의 노드를 루트 노드까지 올라가면서 방문 표시
		while (parent[u] != u) {
			u = parent[u];
			visited[u] = true;
		}

		while (1) {
			if (visited[v]) break;
			v = parent[v];
		}

		cout << v << '\n';
	}
	
	return 0;
}