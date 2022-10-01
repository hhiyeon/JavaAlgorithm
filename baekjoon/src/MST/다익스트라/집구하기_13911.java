package MST.다익스트라;
/* 집구하기 - 다익스트라, 그래프이론 - 골드2 - 2/23(일)
* 맥세권 : 맥도날드와 집 사이의 최단거리가 x 이하
* 스세권 : 스타벅스와 집 사이의 최단거리가 y 이하
* 맥세권과 스세권을 만족하는 집 중 최단거리의 합이 최소인 집 구하기
* 원(집), 사각형(맥도날드), 별(스타벅스)
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 집구하기_13911 {
    static int V, E; // 정점의 개수, 도로의 개수
    static int u,v,w; // u와 v사이에 가중치 w
    static int M, x1; // 맥도날드 수 M, 맥세권일 조건 x1
    static int mcVertex; // 맥도날드 정점 번호
    static int S, y1; // 스타벅스의 수 S, 스세권일 조건 y1
    static int starVertex; // 스타벅스 정점 번호
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static int[] distMc, distStar;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        distMc = new int[V+1];
        distStar = new int[V+1];

        for(int i=0; i<V+3; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        for(int i=0; i<V+1; i++){
            distStar[i] = Integer.MAX_VALUE;
            distMc[i] = Integer.MAX_VALUE;
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        x1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++){
            mcVertex = Integer.parseInt(st.nextToken());
            distMc[mcVertex] = 0;
            pq.add(new Node(mcVertex, 0));
        }

        dijkstra(distMc);

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<S; i++){
            starVertex = Integer.parseInt(st.nextToken());
            distStar[starVertex] = 0;
            pq.add(new Node(starVertex, 0));
        }

        dijkstra(distStar);

        int answer = Integer.MAX_VALUE;
        for(int i=1; i<V; i++){
            if(0<distMc[i] && distMc[i]<=x1 && 0<distStar[i] && distStar[i]<=y1){
                answer = Math.min(answer, distStar[i]+distMc[i]);
            }
            if(answer == Integer.MAX_VALUE){
                System.out.println(-1);
            } else {
                System.out.println(answer);
            }
        }
    }
    static void dijkstra(int[] dist){
        while(!pq.isEmpty()){
            Node q = pq.poll();
            for(int i=0; i< graph.get(q.idx).size(); i++){
                Node p = graph.get(q.idx).get(i);
                if(dist[p.idx] > p.cost + q.cost){
                    pq.add(new Node(p.idx, q.cost + p.cost));
                    dist[p.idx] = q.cost + p.cost;
                }
            }
        }
    }
    static class Node implements Comparable<Node>{
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
        public int compareTo(Node p){
            return this.cost > p.cost ? 1 : -1;
        }
    }
}
