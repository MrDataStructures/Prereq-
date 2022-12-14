package prereqchecker;

import java.util.*;

/**
 * Steps to implement this class main method:
 * 
 * Step 1:
 * AdjListInputFile name is passed through the command line as args[0]
 * Read from AdjListInputFile with the format:
 * 1. a (int): number of courses in the graph
 * 2. a lines, each with 1 course ID
 * 3. b (int): number of edges in the graph
 * 4. b lines, each with a source ID
 * 
 * Step 2:
 * ValidPreReqInputFile name is passed through the command line as args[1]
 * Read from ValidPreReqInputFile with the format:
 * 1. 1 line containing the proposed advanced course
 * 2. 1 line containing the proposed prereq to the advanced course
 * 
 * Step 3:
 * ValidPreReqOutputFile name is passed through the command line as args[2]
 * Output to ValidPreReqOutputFile with the format:
 * 1. 1 line, containing either the word "YES" or "NO"
 */
public class ValidPrereq {
    StdIn.setFile(args[0]);
    AdjList cycle = new AdjList();

    private boolean checkCycle(int node, ArrayList<ArrayList<Integer>> cycle, int vis[], int dfsVis[]){
        vis[node]=1;
        dfsVis[node]=1;
        for(Integer it:cycle.get(node)){
            if(vis[it]==0){
                if(checkCycle(it, cycle, vis, dfsVis)==true){
                    return true;
                }
            }else if(dfsVis[it]==1){
                return true;
            }
        }
        dfsVis[node]=0;
        return false;
    }

    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj){
        int vis[] = new int[N];
        int dfsVis[] = new int[N];

        for(int i=0;i<N;i++){
            if(vis[i]==0){
                if(checkCycle(i,adj,vis,dfsVis)==true)StdOut.print("YES");
            }
        }
        StdOut.print("NO");
    }

    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.ValidPrereq <adjacency list INput file> <valid prereq INput file> <valid prereq OUTput file>");
            return;
        }
	// WRITE YOUR CODE HERE
    StdIn.setFile(args[0]);
    StdOut.setFile(args[2]);
    StdOut.print(isCyclic(args[0]));
    
    
}
