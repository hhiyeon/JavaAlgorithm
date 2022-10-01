package 배열.봉우리10;
// N X N 격자판
// 각 격자에는 지역의 높이가 있음
// 상하좌우 숫자보다 큰 숫자 -> 봉우리 지역 개수
// 봉우리 지역 개수 알아내기기
// 이중포문 돌면서 상하좌우 확인하고 자기보다 큰게 있으면 봉우리
public class Main{
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static int solution(int[][] arr){
        int answer = 0;
        int n = arr.length;

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                boolean flag = true;
                //int current = arr[i][j];
                for(int d=0; d<4; d++){
                    //int nx = arr[i][j]+dx[d];
                    //int ny = arr[i][j]+dy[d];

                    int nx = i+dx[d];
                    int ny = j+dy[d];

                    // 경계선 넘지 않게 체크 0~n-1
                    if(nx>=0 && nx<n && ny>=0 &&ny<n && arr[nx][ny]>=arr[i][j]) { // 현재위치보다 상하좌우가 큼
                       flag = false;
                       break;
                    }
                }
                if(flag){
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        int[][] arr ={
            {5,3,7,2,3},
            {3,7,1,6,1},
            {7,2,5,3,4},
            {4,3,6,4,1},
            {8,7,3,5,2}
        };

        System.out.println(T.solution(arr));
    }
}
