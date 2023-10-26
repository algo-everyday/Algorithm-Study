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

struct Team {
	int id, score, time, submit;
};

vector<Team> team(101);
int solve[101][101]; // solve[i][j] : 팀 i가 j번 문제를 풀고 획득한 점수

void init() {
	for (int i = 0; i < 101; i++) {
		team[i].id = i;
		team[i].score = team[i].time = team[i].submit = 0;
	}
	for (int i = 0; i < 101; i++) {
		for (int j = 0; j < 101; j++) {
			solve[i][j] = 0;
		}
	}
}

bool cmp(Team a, Team b) {
	if (a.score != b.score) return a.score > b.score;
	if (a.submit != b.submit) return a.submit < b.submit;
	return a.time < b.time;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	int tc; cin >> tc; // 테스트 케이스 수
	while (tc--) {
		init();
		int n, k, t, m; // 팀 수, 문제 수, 나의 팀 ID, 로그 엔트리 개수
		cin >> n >> k >> t >> m;

		for (int i = 0; i < m; i++) {
			int teamID, proNum, score; cin >> teamID >> proNum >> score;
	
			solve[teamID][proNum] = max(solve[teamID][proNum], score);
			team[teamID].time = i; // 최종 제출 시간
			team[teamID].submit++;
		}

		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= k; j++) {
				sum += solve[i][j];
			}
			team[i].score = sum;
		}

		sort(team.begin(), team.end(), cmp);

		for (int i = 0; i < team.size(); i++) {
			if (team[i].id == t) {
				cout << i + 1 << '\n';
				break;
			}
		}
	}

	return 0;
}