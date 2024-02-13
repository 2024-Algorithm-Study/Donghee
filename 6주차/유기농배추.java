package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추 {
    static int M, N, K;
    static int[][] cabbage;
    static boolean[][] visit;
    static int count;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };

    static void bfs(int x, int y) {
        Queue<int[]> qu = new LinkedList<int[]>();
        //x,y좌표 저장
        qu.add(new int[] { x, y });

        //qu가 비어있으면 더이상 인접한 배추 X
        while (!qu.isEmpty()) {
            //저장된 qu를 꺼낸다
            x = qu.peek()[0];
            y = qu.peek()[1];
            visit[x][y] = true; //시작좌표 배추존재->true
            qu.poll();

            //상하좌우 4번 for문 돌리기
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                //좌표가 배추밭을 벗어나지 않은 경우
                if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                    //좌표(cx,cy)에 배추가 존재하고, 방문되지 않은 경우
                    if ( cabbage[cx][cy] == 1 && !visit[cx][cy]) {
                        qu.add(new int[] { cx, cy });
                        visit[cx][cy] = true;
                    }
                }

            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트케이스 T 입력받음
        int T = Integer.parseInt(br.readLine());

        for (int c = 0; c < T; c++) {
            //" "공백을 기준으로 끊어서 입력받음
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken()); //가로길이
            N = Integer.parseInt(st.nextToken()); //세로길이
            K = Integer.parseInt(st.nextToken()); //배추가 심어져있는 위치의 개수
            //초기화해주기
            cabbage = new int[M][N];
            visit = new boolean[M][N];
            count=0; //지렁이의 개수

            //K개의 배추가 심어져있는 위치 입력받아 저장
            for (int i = 0; i < K; i++) {
                //" "공백을 기준으로 끊어서 입력받음
                st=new StringTokenizer(br.readLine()," ");
                //배추의 위치 좌표(p1,p2)
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                cabbage[p1][p2] = 1;

            }
            //여기까지는 입력된 내용 저장하는 내용이다.
            //===========================================================

            //bfs의 시작좌표를 셋팅해서 다른 곳에 모여있는 배추들도 파악할 수 있게한다
            //반복문을 통해 가로 세로 좌표들 전체 확인
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {

                    //좌표에 배추가 존재하고 아직 방문을 안한경우
                    if (cabbage[i][j] == 1 && !visit[i][j]) {
                        bfs(i, j); //bfs를 통해 시작좌표부터(i,j) 인접한 부분(배추 존재o)까지 방문 후 count++
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }
}
