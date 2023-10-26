package algorithm.src.Graph;

import java.util.*;
import java.io.*;
public class BOJ_3584 {
    static int T, N,root,x,y,count=0;
    static ArrayList<Integer>[] list;
    static int[] parent, root_arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    // 루트 노드가 주어지지 않았다 -> 루트 노드를 찾아야됨
    // 노드의 수 만큼 배열 생성해서 없는 것이 루트 노드?
    // 주어진 두 노드의 가장 가까운 공통 조상 출력 dfs
    // 거꾸로 올라가면서 처음 방문한 곳을 찾으면 됨?
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케아스 입력
        T = Integer.parseInt(br.readLine());

        // 트리 생성
        for(int i=0;i<T;i++){
            N = Integer.parseInt(br.readLine());

            //리스트 생성
            list = new ArrayList[N+1];
            parent = new int[N+1];
            root_arr = new int[N+1];
            visited = new boolean[N+1];

            for(int j=1;j<=N;j++) list[j] = new ArrayList<>();

            for(int j=1;j<N;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);

                root_arr[b]=1;

            }
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st1.nextToken());
            y = Integer.parseInt(st1.nextToken());

            pro();
        }
        System.out.println(sb);
    }
    public static void pro(){
        //루트 노드를 찾는 과정
        for(int i=1;i<=N;i++){
            if(root_arr[i]==0) root = i;
        }
        //root부터 dfs 탐색 시작
        dfs(root,-1);

        //x 노드부터 시작해서 위로 올라감
        while(x>0){
            visited[x] = true;
            x = parent[x];
        }
        //y 노드부터 시작해서 위로 올라감
        while(y>0){
            //x가 방문한 것 중에 첫번째가 부모가 같은 공통 노드
            if(visited[y]){
                sb.append(y).append("\n");
                break;
            }
            y = parent[y];
        }
    }

    //부모 찾기
    static void dfs(int x, int par){
        for(int y: list[x]){
            if(y==par) continue;
            parent[y] = x;
            dfs(y,x);
            count+=1;
        }
    }
}
