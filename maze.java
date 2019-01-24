// Accepted

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class maze {

	public static int[] dx = {-1,0,0,1};
    public static int[] dy = {0,1,-1,0};
    public static boolean[][][] vis;
    public static int maxr;
    public static int maxc;
    
    public static int answer(int[][] maze) { 

        // Your code goes here.
        maxr = maze.length;
        maxc = maze[0].length;
        
	    Queue<state> bfs = new LinkedList<state>();
	    int min = 100_000_000;
	    bfs.add(new state(0,0,0,false));
	    vis = new boolean[maxr][maxc][2];
	    vis[0][0][0]=true;
	    while(!bfs.isEmpty()) {
	    	state next = bfs.poll();
	    	int r = next.r;
	    	int c = next.c;
	    	int res = next.res;
	    	boolean used = next.used;
	    	int usedit = used?1:0;

	    	if(r==maxr-1 && c==maxc-1) {
	    	    return res+1;
	    	}
	    	for(int i=0;i<dx.length;i++) {
                if(inBounds(r+dx[i],c+dy[i])) {
                    if(maze[r+dx[i]][c+dy[i]]==0) {
                    	if(!vis[r+dx[i]][c+dy[i]][usedit]) {
                    		vis[r+dx[i]][c+dy[i]][usedit] = true;
		    				bfs.add(new state(r+dx[i],c+dy[i],res+1,used));
                    	}
                    } else {
                        if(used) continue;
                        else {
                       		if(!vis[r+dx[i]][c+dy[i]][usedit]) {
                       			vis[r+dx[i]][c+dy[i]][usedit] = true;
		    					bfs.add(new state(r+dx[i],c+dy[i],res+1,true));
                       		}
                        }
                    }
                }
            }
	    }
	    return min;

    }
    
    public static boolean inBounds(int r, int c) {
        return r>=0 && r<maxr && c>=0 && c<maxc;
    }

	public static void main(String[] args) {
		// int[][] maze = {{0,0,0,1,0,0,0},
  //                       {0,1,1,1,1,1,0},
  //                       {0,1,1,1,1,1,1},
  //                       {0,0,0,1,0,0,0}};
		//int[][] maze = {{0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 0}, {1, 1, 1, 0}};
		//int[][] maze = {{0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}};
		//int[][] maze = {{0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0}, {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0}};
		int[][] maze = {{0,1,0,0,0,0,0,0,0,0,0},
{1,1,1,1,1,0,1,1,1,1,0},
{0,1,0,0,0,0,0,0,0,1,0},
{0,1,0,0,0,0,0,0,0,1,0},
{0,1,0,0,0,0,0,0,0,1,0},
{0,1,0,0,0,0,0,0,0,1,0},
{0,1,1,1,1,1,1,1,1,1,0},
{0,0,0,0,0,0,0,0,0,1,0}};
		System.out.println(answer(maze));
		
	}
}

class state {
	int r,c,res;
	boolean used;
	public state(int r,int c,int res,boolean used) {
		this.r = r;
		this.c = c;
		this.res = res;
		this.used = used;
	}
}
