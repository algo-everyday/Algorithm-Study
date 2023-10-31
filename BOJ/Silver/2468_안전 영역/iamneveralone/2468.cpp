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

int n;
int map[101][101];
bool visited[101][101];
int dir[4][2] = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

void dfs(int x, int y) {
	visited[x][y] = true;

	for (int k = 0; k < 4; k++) {
		int nx = x + dir[k][0];
		int ny = y + dir[k][1];

		if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
		if (visited[nx][ny]) continue;

		dfs(nx, ny);
	}
}

void input() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
		}
	}
}

void initVisited() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			visited[i][j] = false;
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	input();

	int ans = 0;

	for (int h = 0; h <= 100; h++) { // 높이
		
		initVisited();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] <= h) {
					visited[i][j] = true;
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		ans = max(ans, cnt);
	}
	
	cout << ans;
	return 0;
}