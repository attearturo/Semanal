import processing.core.*;
public class Main extends PApplet {

	Logica app;
	public static void main(String[] args) {
		PApplet.main("Main");
	}

	public void setup() {

		app = new Logica(this);
		noStroke();
		size(500, 500);
		ellipseMode(CENTER);
		smooth();

	}

	public void draw() {
		background(230);
		app.pintar();

	}

	public void mousePressed() {
		app.click();

	}

	public void mouseDragged() {
		app.moverClick();
	}

	public void mouseReleased() {

		app.soltarClick();
	}
}
