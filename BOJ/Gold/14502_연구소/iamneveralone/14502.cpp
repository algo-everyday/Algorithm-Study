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

int n, m; // 세로, 가로
int ans;
int map[9][9]; // 원본
int temp[9][9]; // 복사본
// 0 := 빈 칸
// 1 := 벽
// 2 := 바이러스 있는 칸
bool visited[9][9];

void input() {
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
		}
	}
}

void copyMap() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			temp[i][j] = map[i][j];
		}
	}
}

int dir[4][2] = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

void bfs() {
	queue<pair<int, int>> q; // 바이러스 있는 칸 담을 큐
	int spread[9][9]; // 3개의 벽 세운 후의 지도

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			spread[i][j] = temp[i][j];
			if (spread[i][j] == 2) {
				q.push({ i, j });
			}
		}
	}
	
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int k = 0; k < 4; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

			if (spread[nx][ny] == 0) {
				spread[nx][ny] = 2;
				q.push({ nx, ny });
			}
		}
	}

	int cnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (spread[i][j] == 0) {
				cnt++;
			}
		}
	}
	ans = max(ans, cnt);
}

void func(int cnt) {

	if (cnt == 3) {
		bfs();
		return;
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (temp[i][j] == 0) {
				temp[i][j] = 1;
				func(cnt + 1);
				temp[i][j] = 0;
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	input();

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == 0) {
				copyMap();
				temp[i][j] = 1;
				func(1); // 바로 이전 줄에서 temp[i][j] = 1 했으므로 벽 2개만 더 세우면 됨
				temp[i][j] = 0;
			}
		}
	}

	cout << ans;
	return 0;
}