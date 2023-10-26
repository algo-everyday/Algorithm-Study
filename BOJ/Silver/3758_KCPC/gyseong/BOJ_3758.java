import java.util.*;
import java.io.*;

public class BOJ_3758 {
    static int T, n, k, t, m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int j = 0; j < T; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            //배열 생성 팀의 순서로 0 : 점수, 1: 제출횟수, 2 : 마지막 제출시간
            arr = new int[n][4];
            //최대값 판별하기 위한 배열
            int[][] max = new int[n][k];

            for(int i=0;i<n;i++) arr[i][0] = i+1;

            for (int i = 1; i <= m; i++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());

                //팀
                int n1 = Integer.parseInt(st1.nextToken());
                //문제 번호
                int k1 = Integer.parseInt(st1.nextToken());
                //점수
                int score = Integer.parseInt(st1.nextToken());

                //점수 갱신
                max[n1-1][k1-1] = Math.max(score, max[n1-1][k1-1]);

                //문제를 제출한 적이 있다면 1 증가
                arr[n1-1][2]++;
                //제출 로그를 최산화;
                arr[n1-1][3] = i;
            }
            for(int i=0;i<n;i++){
                int sum = 0;
                for(int l = 0;l<k;l++){
                    sum +=max[i][l];
                }
                arr[i][1] = sum;
            }
            //조건에 맞게 배열 정렬
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        if(o1[2]== o2[2]){
                            return o1[3]-o2[3];
                        }
                        return o1[2] - o2[2];
                    } else {
                        return o2[1] - o1[1];
                    }
                }
            });

            //배열에 값이 같은게 있다면 순위 출력
           for(int i=0;i<n;i++){
               if(t==arr[i][0])System.out.println(i+1);
           }
        }
    }
}
