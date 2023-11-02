package algorithm.src.Graph;

import java.util.*;
import java.io.*;

public class BOJ_2468 {
    static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, count;
    static int[][] arr;
    //가짜 배열 생성
    static int[][] vir_arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    // arraylist에 담아서 최대값 출력
    // 그 전에 배열의 최대값을 구해야됨 -> 어떻게 구할거냐?
    // 입력 받은 값을 비교하여 최대값을 갱신한다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        arr = new int[n][n];

        // 배열 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                // 최대값 구하기
                if (max < arr[i][j]) max = arr[i][j];
                if(min > arr[i][j]) min = arr[i][j];
            }
        }
        System.out.println(min);

        //아무도 잠기지 않을 수 있다.... -> 문제를 끝까지 읽자!!
        for (int i = 0; i <= max; i++) {
            vir_arr = new int[n][n];
            visited = new boolean[n][n];

            // 배열 다시 생성 -> i보다 작거나 같다면 0, 크다면 1
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(arr[j][k]<=i)
                        vir_arr[j][k] =0;
                    else vir_arr[j][k] = 1;
                }
            }
            count=0;
            // dfs로 땅 덩어리 세기
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(!visited[j][k] &&vir_arr[j][k]==1) {
                        dfs(j, k);
                        count+=1;
                        list.add(count);
                    }
                }
            }
        }

        // 배열 정렬
        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println(list.get(list.size()-1));
    }
    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];

            if (x1 < 0 || y1 < 0 || x1 >= n || y1 >= n) continue;
            if (!visited[x1][y1] && vir_arr[x1][y1]==1)
                dfs(x1, y1);
        }
    }
}
