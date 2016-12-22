import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


class GridsCanvas extends Canvas {
  int width, height;

  int rows;

  int cols;
  Cell[][] grid; 
  GridsCanvas(int w, int h, int r, int c, Cell[][] grid) {
    setSize(width = w, height = h);
    rows = r;
    cols = c;
    this.grid = grid; 
  }

  public void paint(Graphics g) {
    //int i;
    width = getSize().width;
    height = getSize().height;

    int rowHt = height / (rows);

 
    int rowWid = width / (cols);

    System.out.println("Width: " + rowWid);
    System.out.println("Height: " + rowHt);
    for(int i = 0; i < rows; i++){
    	for(int  j = 0; j < cols; j++){
    		Cell cell = grid[i][j]; 
			//g.drawString(Integer.toString(cell.id), j * rowHt + 10, i * rowWid + 10);
			System.out.println(cell.id);
			System.out.print(cell.up + " ");
			System.out.print(cell.down + " ");
			System.out.print(cell.left + " ");
			System.out.print(cell.right + " ");
			System.out.println();
			System.out.println("====================");
			
//			g.drawLine(j * rowWid, i * rowHt, j * rowWid + rowWid, i * rowHt);
//			g.drawLine(j * rowWid, i * rowHt + rowHt, j * rowWid + rowWid, i * rowHt + rowHt);
//			g.drawLine(j * rowWid, i * rowHt, j * rowWid, i * rowHt + rowHt); 
//			g.drawLine(j * rowWid + rowWid, i * rowHt, j * rowWid + rowWid, i * rowHt + rowHt);


//
    		if(cell.up){
    			g.setColor(Color.RED);
    			g.drawLine(j * rowWid, i * rowHt, j * rowWid + rowWid, i * rowHt);
    		}
    		if(cell.down){
    			g.setColor(Color.BLUE);

    			g.drawLine(j * rowWid, i * rowHt + rowHt, j * rowWid + rowWid, i * rowHt + rowHt);
    		}
    		if(cell.left){
    			g.setColor(Color.BLACK);

    			g.drawLine(j * rowWid, i * rowHt, j * rowWid, i * rowHt + rowHt); 
    		}
    		if(cell.right){
    			g.setColor(Color.GREEN);

    			g.drawLine(j * rowWid + rowWid, i * rowHt, j * rowWid + rowWid, i * rowHt + rowHt);
    		}
    	}
    }
  }
 
  
 
}

/** This is the demo class. */

