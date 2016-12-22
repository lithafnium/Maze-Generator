import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Grids extends Frame {
	static /*
	 * Construct a GfxDemo2 given its title, width and height. Uses a
	 * GridBagLayout to make the Canvas resize properly.
	 */
	int size; 
	 
	DFS generator; 
	Grids(String title, int w, int h) {
		generator = new DFS(40); 
		
		Cell[][] grid = generator.getGrid(); 
		
		
		//System.out.println(grid == null);
		size = generator.getSize(); 
		System.out.println(size);

		setTitle(title);

		// Now create a Canvas and add it to the Frame.
		GridsCanvas xyz = new GridsCanvas(w, h, size, size, grid);
		add(xyz);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});

		// Normal end ... pack it up!
		pack();
	}

	public static void main(String[] a) {


		


		new Grids("Test", 800, 800).setVisible(true);
	}
}