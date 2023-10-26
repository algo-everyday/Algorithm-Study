package everydaystudy;

import java.util.*;
import java.io.*;

public class BOJ_6603 {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int [] arr, result;
    static int n;

    // n개중 중복을 제거하여 m개를 선택하는 문제
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // 숫자 입력
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());

            // n이 0일때 종료
            if (n == 0)
                break;

            //값을 저장할 배열 2개 생성
            arr = new int[n + 1];
            result = new int[n + 1];

            //방문 체크하기 위한 boolean 배열 생성
            visited = new boolean[n + 1];

            // 배열에 값 넣기
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            // 1번째 원소부터 6번째 원소까지 조건에 맞게 모두 고르는 함수
            rec_func(1, 1);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void rec_func(int k, int m) {
        //m이 6일때까지는 입력받다가 7일때 출력
        if (m == 7) {
            for (int i = 1; i <= 6; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
        }else{
            for(int cand=k;cand<=n;cand++){
                //방문x -> 재귀
                if(!visited[cand]){
                    result[m] = arr[cand];
                    visited[cand] = true;
                    rec_func(cand+1,m+1);
                    visited[cand] = false;
                }
            }
        }
    }
}
