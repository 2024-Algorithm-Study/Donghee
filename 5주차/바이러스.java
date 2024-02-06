package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 바이러스 {

    static int N,M;
    static int res=0;
    public static boolean[] visited = new boolean[101];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    //DFS 함수 정의
    public static void dfs(int n) {
        visited[n] = true;
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < 101; i++) {
                graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<M;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            graph.get(n).add(m);
            graph.get(m).add(n);
        }

        dfs(1);

        System.out.println(res);
    }


}
