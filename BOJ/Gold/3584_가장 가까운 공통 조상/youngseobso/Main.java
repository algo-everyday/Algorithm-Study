import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int TC, N;
    private static int[] parent;
    private static boolean[] check;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine()); // 테스트 케이스
        for (int T = 0; T < TC; T++) {
            N = Integer.parseInt(br.readLine()); // 노드의 개수
            parent = new int[N + 1];
            check = new boolean[N + 1];
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                parent[b] = a; // a는 부모 b는 자식
            }
            // 시작 노드
            st = new StringTokenizer(br.readLine());
            int start_a = Integer.parseInt(st.nextToken());
            int start_b = Integer.parseInt(st.nextToken());
            moving(start_a,start_b);

        }
    }
    public static void moving(int a, int b){
        while(a != 0){
            check[a] = true;
            a = parent[a];
        }
        while(b != 0){
            if(check[b]){
                System.out.println(b);
                break;
            }
            b = parent[b];
        }
    }
}