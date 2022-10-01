package 코테스터디.징검다리건너기;
/* 징검다리 건너는 규칙
* - 징검다리는 일렬, 각 디딤돌에 모두 숫자가 있고, 한 번 밟을 때 마다 1씩 감소
* - 디딤돌 숫자가 0이 되면 밟을 수 없다. 그 다음 돌로 한 번에 여러칸 뛸 수 있다.
* - 단 다음으로 밟을 수 있는 디딤돌이 여러 개이면, 무조건 가장 가까운 디딤돌로 건넌다.
* stones : 디딤돌에 적힌 숫자 순서 배열
* k : 한 번에 건너뛸 수 있는 디딤돌의 최대 칸수
* 최대 몇명 징검다리를 건널 수 있는지 출력*/
// 이진탐색 = 이분탐색(binary search) : 정렬된 배열 or 리스트에 적합한 고속 탐색 방법
// 배열의 중앙에 있는 값을 조사하려고 왼쪽과 오른쪽에 있는지 탐색의 범위를 반으로 줄인다.
// arr[mid] 값이랑 구하려는 값 key랑 비교한다.
// 1. key > mid : left를 mid+1
// 2. key < mid : right를 mid-1
// 3. key == mid : 구하려는 값을 찾았기 때문에 return

class Solution {
    static int left, right, mid, count;
    public int solution(int[] stones, int k) {
        int answer = 0;

        left = 0;
        right = Integer.MAX_VALUE;
        mid = 0;

        while(left <= right){
            mid = (left + right) / 2;
            count = 0;
            boolean flag = false;

            for(int i=0; i<stones.length; i++){
                if(stones[i]-mid <0){
                    //stones[i] = 0;
                    count++;
                    if(count == k){
                        flag = true;
                        break;
                    }
                } else {
                    count = 0;
                }
            }

//            if(k == stones[mid]){
//                return mid;
//            }
            if(flag){ // k < stones[mid]
                right = mid - 1;
            } else { // k > stones[mid]
                left = mid + 1;
                answer = mid;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] stones = {2,4,5,3,2,1,4,2,5,1};
        int k = 3;
        System.out.println(T.solution(stones, k));
    }
}

//while(true){
//        for(int i=0; i<stones.length; i++){
//        if(stones[i]==0){
//        count++;
//        continue;
//        } else {
//        if(count > k){
//        break;
//        }
//        count = 0;
//        stones[i]--;
//        }
//        }
//        if(count > k){
//        break;
//        } else {
//        answer++;
//        }
//        }