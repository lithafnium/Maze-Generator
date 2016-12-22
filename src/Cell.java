import java.util.ArrayList;
import java.util.Random; 
public class Cell {
	boolean up, down, left, right; 
	int r, c; 
	int id; 
	ArrayList<Cell> neighbors = new ArrayList<>(); 
	ArrayList<Cell> visitedNeighbors = new ArrayList<>(); 
	Random rand; 
	boolean visited; 
	Cell(boolean up, boolean down, boolean left, boolean right, int r, int c){
		this.up = up ;
		this.down = down; 
		this.left = left; 
		this.right = right; 
		this.r = r; 
		this.c = c; 
		rand = new Random(); 
	}
	void display(){
	
	}
	// returns false when there are neighbors still unvisited 
	public boolean unvisitedNeighbors(boolean[][] visit){
		for(int i = 0; i < neighbors.size(); i++){
			if(!visit[neighbors.get(i).r][neighbors.get(i).c]){
				return false; 
			}
		}
		return true; 
	}
	
	public Cell getNeighbors(){
//		for(int i = 0; i < neighbors.size(); i++){
//			if(!neighbors.get(i).visited) return neighbors.get(i); 
//		}
//		return null; 
		//int index =(int)Math.random() * (neighbors.size()+1);
		int randomNum = rand.nextInt((neighbors.size()) ) ;
		
		while(neighbors.get(randomNum).visited != false){
			randomNum = rand.nextInt((neighbors.size())) ;
//			System.out.println("size:  " + neighbors.size());
//			System.out.println("random: " + randomNum);
			
			//System.out.println(index);
			//System.out.println("ow");
		}
		return neighbors.get(randomNum); 
	}
	
//	public Cell getNeighbor(int index){
//		// 
//		
//		//int index = (int)Math.random() * (neighbors.size()+1); 
//		System.out.println("Size " + neighbors.size());
//		System.out.print("Index: "+index + " ");
//		Cell c = neighbors.get(index); 
//		visitedNeighbors.add(c); 
//		neighbors.remove(index); 
//		System.out.println("C ID: "+c.id);
//		return c; 
//	}
	public String toString(){
		return r + " " + c + " " + "sides: " + up + down + left + right;
		
	}
	public void removeWall(Cell n){
		if(n.r > r){
			n.up = false; 
			down = false; 
		}
		if(n.r < r){
			n.down = false; 
			up = false; 
		}
		if(n.c > c){
			n.left = false; 
			right = false; 
		}
		if(n.c < c){
			n.right = false; 
			left = false; 
		}
	
	}
	
}