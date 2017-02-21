import java.util.ArrayList;
import processing.core.*;

public class Centro {

	private ArrayList<Petalo> petalitos;
	private PApplet app;
	private float posX, posY, r, g, b, angulo;
	private int num;
	private boolean rotar = true;

	// Se crea el constructor de Centro
	public Centro(PApplet app, float posX, float posY, int num) {

		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.num = num;
		angulo = 0;
		r = (int)app.random(255);
		g = (int)app.random(255);
		b = (int)app.random(255);

		petalitos = new ArrayList<Petalo>();

	}
	//Se Define el if para pintar los bordes de los centros y se pintan los centros

	public void pintar() {
		if (app.dist(posX, posY, app.mouseX, app.mouseY) < 20) {
			app.strokeWeight(3);
			app.stroke(255, 0, 0);
		} else {
			app.noStroke();
		}

		app.fill(r, g, b);
		app.ellipse(posX, posY, 40, 40);
		app.fill(255);
		app.text(num, posX, posY);
		//Se usa la formula de girar en el arraylist de petalitos 
		//Petalitos son los petalos que han sido agarrados por un centro
		angulo += (app.PI / 180) * 2;
		for (int i = 0; i < petalitos.size(); i++) {
			petalitos.get(i).pintar();
			if (rotar) {
				petalitos.get(i).setAngulo((float) (petalitos.get(i).getAngulo() + 0.1));

			}
			petalitos.get(i).setPosX(posX);
			petalitos.get(i).setPosY(posY);
			petalitos.get(i).rotar();
		}

	}

	//Se agregan los petalos a el arraylist petalitos
	public void agregarPetalo(Petalo p) {
		petalitos.add(p);
		for (int i = 0; i < petalitos.size(); i++) {
			petalitos.get(i).setAngulo(2 * app.PI / petalitos.size() * i);

		}
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

}
