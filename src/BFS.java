import java.util.*;

class Node {

	Set<Node> neighbors;
	int data; 
	public Node() {
		neighbors = new HashSet<Node>();
	}
}

class edge{
	int weight; 
}

public class BFS {
	// Unweighted Graphs
	// Edges have no label
	// class Node { Set<Node> neighbors }

	// for, Queue, Stack
	// Queue is FIFO
	// Stack is FILO

	//	      f d b a c e g
	// start at a

	// queue:    
	// visited:  a b c d e f g
//	public static void main(String[] args) {
//		DFS dfs = new DFS(); 
//		
//	}
	List<Node> breadthFirstSearch(Node node) {
		ArrayList<Node> out = new ArrayList<Node>();
		Queue<Node> q = new LinkedList<Node>();
		Set<Node> visited = new HashSet<Node>();

		q.offer(node);
		while(q.size() > 0) {
			Node n = q.poll();
			visited.add(n);
			out.add(n);   //this could vary based off our goal
			for(Node m : n.neighbors) {
				if(!visited.contains(m)) {
					q.offer(m);
					visited.add(m);
				}
			}
		}
		return out;
	}

	boolean hasCycles(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		Set<Node> visited = new HashSet<Node>();
		q.offer(node);

		while(q.size() > 0) {
			Node n = q.poll();
			visited.add(n);
			for(Node x : n.neighbors) {
				if(x == node) return true;
				if(visited.contains(x)) return true;
				q.offer(x);
				visited.add(x);
			}
		}
		return false;

	}
	//Dijkstars
	int getMinDistances(int[][] matrix, int a, int b){
		final HashMap<Integer, Integer> minDists = new HashMap<>(); 
		int n = matrix.length; 
		for(int i = 0; i < n; i++){
			minDists.put(i,  Integer.MAX_VALUE); 
		}
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(n, new Comparator<Integer>(){
			public int compare(Integer x, Integer y){
				return minDists.get(x) - minDists.get(y); 
			}
		});

		minDists.put(a, 0); 
		queue.add(a); 
		while(!queue.isEmpty()){
			int node = queue.poll(); 
			if(node == b){
				return minDists.get(node); 
			}
			for(int j = 0; j < n; j++) {
				if(matrix[node][j] != 0 && minDists.get(node) + matrix[node][j] < minDists.get(j)) {
					minDists.put(j,  minDists.get(node) + matrix[node][j]);
					queue.remove(j);
					queue.add(j);
				}
			}
			
		}
		return -1; 
	}

	void floodFill(char[][] map, boolean[][] visited, int r, int c){
		if(r < 0 || r > map.length || c < 0 || c > map.length) return; 
		if(visited[r][c]) return; 

		floodFill(map, visited, r+1, c); 
		floodFill(map, visited, r, c + 1); 
		floodFill(map, visited, r - 1, c); 
		floodFill(map, visited, r, c - 1); 

	}

	

}
