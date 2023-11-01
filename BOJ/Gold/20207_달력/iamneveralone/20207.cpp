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

int n; // 일정 개수
int day[366];

void input() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		int start, end; cin >> start >> end; // 시작 날짜, 종료 날짜
		
		for (int j = start; j <= end; j++) {
			day[j]++;
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	input();

	int height = 0, width = 0, ans = 0;
	for (int i = 1; i <= 365; i++) {
		if (day[i] > 0) {
			height = max(height, day[i]);
			width++;
		}
		if (day[i] == 0 || i == 365) {
			ans += height * width;
			height = width = 0;
		}
	}
	cout << ans;
	return 0;
}