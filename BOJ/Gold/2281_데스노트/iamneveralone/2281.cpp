#include <iostream>
#include <vector>
#include <deque>
#include <stack>
#include <queue>
#include <algorithm>
#include <cmath>
#include <cstring>
#include <climits>
#define INF INT_MAX

using namespace std;

int n, m; // 사람 수, 노트의 가로 칸 개수
int name[1001];
int dp[1001][1001];

int func(int idx, int len) {
	// idx := name 배열에서의 현재 인덱스
	// len := name[idx - 1] 작성 후 빈 칸 포함 길이
	if (idx == n) return 0;

	if (dp[idx][len] != -1) return dp[idx][len];

	// 다음 줄에 이름 작성하는 경우
	dp[idx][len] = (m - len + 1) * (m - len + 1) + func(idx + 1, name[idx] + 1);
	
	// 같은 줄에 이름 작성하는 경우
	if (len + name[idx] <= m) {
		dp[idx][len] = min(dp[idx][len], func(idx + 1, len + name[idx] + 1));
	}

	return dp[idx][len];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> name[i];
	}
	memset(dp, -1, sizeof(dp));
  
	cout << func(0, 0);
	return 0;
}