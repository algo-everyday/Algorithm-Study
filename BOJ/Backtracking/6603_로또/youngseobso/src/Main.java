import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int K;
    private static int S[];
    private static boolean isSelected[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String value = br.readLine();
            if(value.equals("0")){
                break;
            }
            String input[] = value.split(" ");
            K = Integer.parseInt(input[0]);
            S = new int[K];
            isSelected = new boolean[K];
            for(int i=0,j=1;i<K;i++,j++){
                S[i] = Integer.parseInt(input[j]);
            }
            per(0,0);
            System.out.println();
        }
    }
    public static void per(int start, int depth){
        if(depth == 6) {
            for (int i=0;i<K;i++) {
                if (isSelected[i]) {
                    System.out.print(S[i] + " ");
                }
            }
            System.out.println();
        }
            for(int i=start;i<K;i++){
                isSelected[i] = true;
                per(i+1, depth+1);
                isSelected[i] = false;
        }
    }
}
