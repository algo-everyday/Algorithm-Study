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

vector<int> ans;
int visited[14];

void func(vector<int> v, int idx, int cnt) {
	
	if (cnt == 6) {
		for (int i = 0; i < ans.size(); i++) {
			cout << ans[i] << ' ';
		}
		cout << '\n';
		
		return;
	}

	for (int i = idx; i < v.size(); i++) {
		if (visited[i]) continue;
		visited[i] = 1;
		ans.push_back(v[i]);
		
		func(v, i, cnt + 1);
		
		ans.pop_back();
		visited[i] = 0;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	while (1) {
		int k; cin >> k;
		if (k == 0) break;

		vector<int> v;
		for (int i = 0; i < k; i++) {
			int num; cin >> num;
			v.push_back(num);
		}
		func(v, 0, 0);

		cout << '\n';
	}
	return 0;
}