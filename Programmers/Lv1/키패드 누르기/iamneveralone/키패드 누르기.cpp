#include <string>
#include <vector>

using namespace std;

struct Pos{
    int x, y;  
};

Pos cur_left, cur_right; // 현재 왼손, 오른손 엄지손가락 위치

string solution(vector<int> numbers, string hand) {
    string ans = "";
    
    cur_left = {3, 0}, cur_right = {3, 2};
    
    for (int i = 0; i < numbers.size(); i++){
        int num = numbers[i]; // 현재 누를 숫자
        
        if (num == 1 || num == 4 || num == 7){ // 1, 4, 7
            ans += 'L';
            cur_left = {num / 3, 0};
        } 
        else if (num == 3 || num == 6 || num == 9){ // 3, 6, 9
            ans += 'R';
            cur_right = {num / 3 - 1, 2};
        }
        else { // 2, 5, 8, 0
            Pos num_pos;
            if (num == 0) num_pos = {3, 1};
            else num_pos = {num / 3, 1};
            
            int left_dist = abs(num_pos.x - cur_left.x) + abs(num_pos.y - cur_left.y); // 왼손 엄지손가락과의 거리
            int right_dist = abs(num_pos.x - cur_right.x) + abs(num_pos.y - cur_right.y); // 왼손 엄지손가락과의 거리
            
            if (left_dist < right_dist){
                cur_left = {num_pos.x, num_pos.y};
                ans += "L";
            }
            else if (left_dist > right_dist){
                cur_right = {num_pos.x, num_pos.y};
                ans += "R";
            } 
            else { // 거리가 같다면
                if (hand == "left") {
                    cur_left = {num_pos.x, num_pos.y};
                    ans += "L";
                }
                else if (hand == "right"){
                    cur_right = {num_pos.x, num_pos.y};
                    ans += "R";
                } 
            }
        }
    }
    return ans;
}