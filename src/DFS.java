import java.util.*; 
public class DFS {
	//DFS

	// stack rather than a queue

	//   e f g a b c d
	// stack:   
	// visited: a b c d g f e
	int size; 
	static Cell current; 
	Cell[][] grid; 
	DFS(int size){
		this.size = size; 
		grid = new Cell[size][size]; 
		start(grid); 
		
		
		

	}
	public static void main(String[] args) {
		
	}
	public Cell[][] getGrid(){
		//System.out.println(grid == null);
		return grid; 
	}
	public int getSize(){
		return size; 
	}
	static void start(Cell[][] grid){
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				// up down left righit
				grid[i][j] = new Cell(true, true, true, true, i, j); 
			}
		}
		// adds neighbors to cells 
		int id = 0; 
		for(int i = 0; i < grid.length; i++){ // rows
			for(int j = 0; j < grid[0].length; j++){ // columns
				Cell c = grid[i][j]; 
				// adds all the neighbors 
				if(i + 1 < grid.length) {
					c.neighbors.add(grid[i+1][j]); 
				}
				if(i - 1 >= 0){
					c.neighbors.add(grid[i-1][j]); 
				}
				if(j + 1 < grid[0].length){
					c.neighbors.add(grid[i][j+1]);
				}
				if(j - 1 >= 0){
					c.neighbors.add(grid[i][j-1]);
				}
				c.id = id; 
				id++; 
			}
		}
		
		current = grid[0][0]; 
		current.visited = true; 
		depthFirstSearch(current, new boolean[grid.length][grid[0].length]); 
		int count = 1; 
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				Cell cell = grid[i][j]; 
				 //outputs the walls of each cell - probably convert to ascii later 
//				System.out.print(count + " ");
//				System.out.print(cell.up + " ");
//				System.out.print(cell.down + " ");
//				System.out.print(cell.left + " ");
//				System.out.print(cell.right + " ");
//				System.out.println();
//				System.out.println("====================");
				//System.out.println(cell.neighbors.size());
				count++; 
				//System.out.print(cell.id + " | ");
				//				for(int k = 0; k < cell.neighbors.size(); k++){
				//					Cell n = cell.neighbors.get(k); 
				//					
				//					//System.out.print(n.id + " ");
				//				}
				//System.out.println();

			}
		}
	}

	static void depthFirstSearch(Cell current, boolean[][] visit) {

		Deque<Cell> s = new LinkedList<Cell>();
		//Set<Cell> visited = new HashSet<Cell>();

		s.push(current);
		//visit[cell.r][cell.c] = true; 
		int count = 0; 
		while(!allVisited(visit)) {
			if(!allneighborsVisited(current)){
				if(current.getNeighbors() != null){
					//System.out.println("Current: "+current);

					Cell next = current.getNeighbors(); 
					s.push(next); 
					current.removeWall(next);
					next.visited = true; 
					visit[next.r][next.c] = true; 
					current = next; 
					//System.out.println("path");

				}
			}
			else if(s.size() != 0){
				current = s.pop(); 
				visit[current.r][current.c] = true; 
				//System.out.println(current);
			}
			//System.out.println();
		}


	}
	static boolean allneighborsVisited(Cell current){
		for(int i = 0; i < current.neighbors.size(); i++){
			if(current.neighbors.get(i).visited == false){
				return false; 
			}
		}
		return true; 
	}
	// if it returns false, there are still cells that are unvisited 
	static boolean allVisited(boolean[][] visited){
		for(int i = 0; i < visited.length; i++){
			for(int j = 0; j < visited[0].length; j++){ 
				if(!visited[i][j]) return false; 
			}
		}
		return true; 
	}
}