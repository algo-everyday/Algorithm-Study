def solution(numbers, hand):
    answer = ''
    
    left_num = [1, 4, 7]
    right_num = [3, 6, 9]
    
    left_hand = [3, 0]
    right_hand = [3, 2]
    
    keypad = [[1,2,3], [4,5,6], [7,8,9], [-1, 0, -1]]
    
    # 키패드간 거리를 계산하여 어느 손가락을 사용할 지 계산 abs(x1-x2) + abs(y1-y2)
    def decide_hand(i, j):
        if abs(left_hand[0] - i) + abs(left_hand[1] - j) < abs(right_hand[0] - i) + abs(right_hand[1] - j):
            return 0
        elif abs(left_hand[0] - i) + abs(left_hand[1] - j) > abs(right_hand[0] - i) + abs(right_hand[1] - j):
            return 1
        else:
            if hand == "right": return 1 # 거리가 동일할 경우, 오른손잡이인지 왼손잡이인지 판단
            else: return 0
        
    for number in numbers:
        if number in left_num:
            answer += "L"
            left_hand = [left_num.index(number), 0]
            
        elif number in right_num:
            answer += "R"
            right_hand = [right_num.index(number), 2]
        # 키패드 가운데 부분 누를 경우
        else:  
            target = [0, 0] # keypad내의 x, y좌표를 찾는다
            for i in range(4):
                for j in range(3):
                    if keypad[i][j] == number: 
                        target = [i, j]
                        break
            result = decide_hand(target[0], target[1])
            if result == 0:
                answer += "L"
                left_hand = target
            else: 
                answer += "R"
                right_hand = target
    return answer