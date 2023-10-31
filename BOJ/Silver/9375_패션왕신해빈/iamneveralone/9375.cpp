#include <iostream>
#include <vector>
#include <deque>
#include <stack>
#include <queue>
#include <map>
#include <algorithm>
#include <cmath>
#include <cstring>
#include <climits>
#define INF INT_MAX

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int tc; cin >> tc;
	while (tc--) {
		map<string, int> m;
		vector<string> wear;
		int num; cin >> num;
		for (int i = 0; i < num; i++) {
			string a, b; cin >> a >> b;
			wear.push_back(b);
			m[b]++;
		}
		int ans = 1;
		for (auto& item : m) {
			ans *= (item.second + 1);
		}
		cout << ans - 1 << '\n';
	}
	return 0;
}