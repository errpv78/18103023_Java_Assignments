// Getting all possible paths between given source and destination
// Using dfs
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public class Program3{

    public static void main(String[] args){

        class graph{

            class edge{
                int start, end, weight;
                edge(){
                    start=0;
                    end=0;
                    weight=0;
                }
            };

            class adjList{
                ArrayList<Integer> adj = new ArrayList<Integer>();
            }
            int v, e;
            edge edges[];
            adjList adjacency[];

            public void dfs(int start, int end, ArrayList<Integer> curr){
                if(start==end){
                    for(int i=0;i<curr.size();i++){
                        System.out.print(curr.get(i));
                        if(curr.get(i)!=end){
                            System.out.print("->");
                        }
                        else{
                            System.out.println("");
                        }
                    }
                    return;
                }
                boolean present = false;
                for(int i=0;i<this.adjacency[start].adj.size();i++){
                    present=false;
                    for(int j=0;j<curr.size();j++){
                        if(curr.get(j)==this.adjacency[start].adj.get(i)){
                            present=true;
                            break;
                        }
                    }
                    if(!present){
                        curr.add(this.adjacency[start].adj.get(i));
                        dfs(this.adjacency[start].adj.get(i), end, curr);
                        curr.remove(this.adjacency[start].adj.get(i));
                    }
                }
            }

            graph(int v, int e){
                edges = new edge[e];
                adjacency = new adjList[v];
                for(int i=0;i <e; i++){
                    edges[i] = new edge();
                }
                for(int i=0;i<v;i++){
                    adjacency[i] = new adjList();
                }
            }

        };



        Scanner obj = new Scanner(System.in);
        System.out.print("Enter number of nodes and edges: ");
        int v = obj.nextInt(), e = obj.nextInt();
        System.out.print("Enter edges start, end, weight(first edge is edge 0): ");
        graph g = new graph(v, e);

        int s, end, w;
        for(int i=0;i<e; i++){
            g.edges[i].start = obj.nextInt();
            g.edges[i].end = obj.nextInt();
            g.edges[i].weight = obj.nextInt();
            g.adjacency[g.edges[i].start].adj.add(g.edges[i].end);
        }


        int start, dest;
        System.out.print("Enter start and destination node: ");
        Scanner obj1 = new Scanner(System.in);
        start = obj1.nextInt();
        dest = obj1.nextInt();

        ArrayList<Integer> curr = new ArrayList<Integer>();
        curr.add(start);
        g.dfs(start, dest, curr);

    }
}

// Sample testcase:

// Enter number of nodes and edges: 5 8
// Enter edges start, end, weight(first edge is edge 0): 0 1 -1
// 0 2 4
// 1 2 3
// 1 3 2
// 1 4 2
// 3 1 1
// 3 2 5
// 4 3 -3
// Enter start and destination node: 0 2
// 0->1->2
// 0->1->3->2
// 0->1->4->3->2
// 0->2
