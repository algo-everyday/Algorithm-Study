package algorithm.src.Programmers;

import java.util.*;

class Solution1 {
    //오른손 좌표, 왼손 좌표 만들기 위해 배열 생성
    static int[][] arr = new int[2][2];
    static StringBuilder sb = new StringBuilder();

    public String solution(int[] numbers, String hand) {
        String answer = "";

        //왼손의 좌표
        arr[0][0] = 4;
        arr[0][1] = 1;

        //오른손의 좌표
        arr[1][0] = 4;
        arr[1][1] = 3;


        //숫자 판별
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
                left(numbers[i]);
                sb.append("L");
            }else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9){
                right(numbers[i]);
                sb.append('R');
            }
            else{
                //거리 비교해서 L인지 R인지 판별하는 함수
                search(numbers[i],hand);
            }
            // 좌표값 출력
            System.out.println("왼손 " + arr[0][0]+" "+arr[0][1]);
            System.out.println("오른손 " + arr[1][0]+" "+arr[1][1]);
            System.out.println();
        }
        answer = sb.toString();
        return answer;
    }
    
    //왼손 좌표 값 확인
    static void left(int x){
        if(x==1){
            arr[0][0] = 1;
            arr[0][1] = 1;
        }
        else if(x==4) {
            arr[0][0] = 2;
            arr[0][1] = 1;
        }else if(x==7){
            arr[0][0] = 3;
            arr[0][1] = 1;
        }
    }

    //오른손 좌표 값 확인
    static void right(int x){
        if(x==3){
            arr[1][0] = 1;
            arr[1][1] = 3;
        }
        else if(x==6) {
            arr[1][0] = 2;
            arr[1][1] = 3;
        }
        else if(x==9){
            arr[1][0] = 3;
            arr[1][1] = 3;
        }
    }
    static void search(int x, String hand){
        if(x==2){
            int x1 = Math.abs(arr[0][0] - 1);
            int y1 = Math.abs(arr[0][1] - 2);
            int x2 = Math.abs(arr[1][0] - 1);
            int y2 = Math.abs(arr[1][1] - 2);

            if((x1+y1)<(x2+y2)){
                sb.append("L");
                arr[0][0] = 1;
                arr[0][1] = 2;
            }else if((x1+y1)>(x2+y2)){
                sb.append("R");
                arr[1][0] = 1;
                arr[1][1] = 2;
            }else if((x1+y1)==(x2+y2)){
                if(hand.equals("right")) {
                    arr[1][0] = 1;
                    arr[1][1] = 2;
                    sb.append("R");
                }
                else {
                    arr[0][0] = 1;
                    arr[0][1] = 2;
                    sb.append("L");
                }
            }
        }else if(x==5){
            int x1 = Math.abs(arr[0][0] - 2);
            int y1 = Math.abs(arr[0][1] - 2);
            int x2 = Math.abs(arr[1][0] - 2);
            int y2 = Math.abs(arr[1][1] - 2);

            if((x1+y1)<(x2+y2)){
                sb.append("L");
                arr[0][0] = 2;
                arr[0][1] = 2;
            }else if((x1+y1)>(x2+y2)){
                sb.append("R");
                arr[1][0] = 2;
                arr[1][1] = 2;
            }else if((x1+y1)==(x2+y2)){
                if(hand.equals("right")) {
                    arr[1][0] = 2;
                    arr[1][1] = 2;
                    sb.append("R");
                }
                else {
                    arr[0][0] = 2;
                    arr[0][1] = 2;
                    sb.append("L");
                }
            }
        }else if(x==8){
            int x1 = Math.abs(arr[0][0] - 3);
            int y1 = Math.abs(arr[0][1] - 2);
            int x2 = Math.abs(arr[1][0] - 3);
            int y2 = Math.abs(arr[1][1] - 2);

            if((x1+y1)<(x2+y2)){
                sb.append("L");
                arr[0][0] = 3;
                arr[0][1] = 2;
            }else if((x1+y1)>(x2+y2)){
                sb.append("R");
                arr[1][0] = 3;
                arr[1][1] = 2;
            }else if((x1+y1)==(x2+y2)){
                if(hand.equals("right")) {
                    arr[1][0] = 3;
                    arr[1][1] =2;
                    sb.append("R");
                }
                else {
                    arr[0][0] = 3;
                    arr[0][1] = 2;
                    sb.append("L");
                }
            }
        }else if(x==0){
            int x1 = Math.abs(arr[0][0] - 4);
            int y1 = Math.abs(arr[0][1] - 2);
            int x2 = Math.abs(arr[1][0] - 4);
            int y2 = Math.abs(arr[1][1] - 2);

            if((x1+y1)<(x2+y2)){
                sb.append("L");
                arr[0][0] = 4;
                arr[0][1] = 2;
            }else if((x1+y1)>(x2+y2)){
                sb.append("R");
                arr[1][0] = 4;
                arr[1][1] = 2;
            }else if((x1+y1)==(x2+y2)){
                if(hand.equals("right")) {
                    arr[1][0] = 4;
                    arr[1][1] = 2;
                    sb.append("R");
                }
                else {
                    arr[0][0] = 4;
                    arr[0][1] = 2;
                    sb.append("L");
                }
            }
        }
    }
}