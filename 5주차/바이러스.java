package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 바이러스 {

    static int N,M;
    static int res=0;
    public static boolean[] visited = new boolean[101];
    //2차원 배열 생성
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    //DFS 함수 정의
    public static void dfs(int n) {
        //현재 노드를 방문 처리
        visited[n] = true;
        //숫자 n과 연결되어있는 숫자를 나열해놓은 배열 (ex) 1={2,5}, 2={1,3,5}, 3={2} ...등)
        ArrayList<Integer> curr = graph.get(n);

        for (int i = 0; i < curr.size(); i++) {
            int m = curr.get(i);
            if (!visited[m]) {
                dfs(m);
                res++;
            }
        }
    }
    public static void main (String[]args) throws Exception{
        //입력을 받는 과정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //컴퓨터의 수
        N = Integer.parseInt(br.readLine()); //에제입력 -> 7
        //직접 연결되어 있는 컴퓨터 쌍의 수
        M = Integer.parseInt(br.readLine()); //예제입력 -> 6

        //그래프 초기화
        for (int i = 0; i < 101; i++) {
                graph.add(new ArrayList<Integer>());
        }

        //M만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍을 입력받는 과정
        for(int i=0;i<M;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            //빈칸을 기준으로 n과 m으로 입력받음
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            //일방향이아닌 양방향으로 연결시킴
            graph.get(n).add(m);
            graph.get(m).add(n);
        }

        dfs(1); //1번 컴퓨터부터 시작

        System.out.println(res); //웜 바이러스에 걸리게 되는 컴퓨터의 수
    }


}
