package everystudy;

import java.util.*;
import java.io.*;
public class BOJ_3584 {
    static int T, N;
    static ArrayList<Integer>[] list;
    static int[] parent;

    // 루트 노드가 주어지지 않았다 -> 루트 노드를 찾아야됨
    // 주어진 두 노드의 가장 가까운 공통 조상 출력 dfs 2번?
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            N = Integer.parseInt(br.readLine());

            //리스트 생성
            list = new ArrayList[N];
            parent = new int[N];

            for(int j=0;j<N;j++) list[i] = new ArrayList<>();

            for(int j=0;j<N;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);

            }
            pro();
        }
    }
    public static void pro(){
       

    }

}
