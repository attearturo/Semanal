import java.util.ArrayList;

import processing.core.*;

public class Logica {

	private PApplet app;

	private ArrayList<Centro> centros;
	private ArrayList<Petalo> petalos;
	Centro selCentro;
	Petalo selPetalo;

	public Logica(PApplet app) {
		this.app = app;
		selCentro= null;
		selPetalo = null;
		// Se crean los arrraylist, se inicializan y se les agregan variables
		centros = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			centros.add(new Centro(app, 50 * i + 150, 450, (int) app.random(2, 10)));

		}
		// Se crean los arrraylist, se inicializan y se les agregan variables
		petalos = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			petalos.add(new Petalo(app, 50 * i + 25, 50));
		}

	}

	public void pintar() {
		for (int i = 0; i < centros.size(); i++) {
			centros.get(i).pintar();

			for (int j = 0; j < petalos.size(); j++) {
				//Se hace un if para validar la distancia entre centros y petalos

				if (app.dist(centros.get(i).getPosX(), centros.get(i).getPosY(), petalos.get(j).getPosX(),
						petalos.get(j).getPosY()) < 25) {
					centros.get(i).agregarPetalo(petalos.get(j));
					System.out.println("la gfa de circulos");
					petalos.remove(j);

				}

			}

		}

		for (int i = 0; i < petalos.size(); i++) {
			petalos.get(i).pintar();
		}

	}

	public void click() {
		//Se crea un null para poder agarrar un unico centro
		if (selCentro == null) {
			for (int i = 0; i < centros.size(); i++) {
				if (app.dist(centros.get(i).getPosX(), centros.get(i).getPosY(), app.mouseX, app.mouseY) < 20) {
					selCentro = centros.get(i);
					centros.get(i).setPosX(app.mouseX);
					centros.get(i).setPosY(app.mouseY);
				}
			}
		}

		for (int i = 0; i < petalos.size(); i++) {
			if (app.dist(petalos.get(i).getPosX(), petalos.get(i).getPosY(), app.mouseX, app.mouseY) < 7) {
				selPetalo = petalos.get(i);
				petalos.get(i).setPosX(app.mouseX);
				petalos.get(i).setPosY(app.mouseY);
			}
		}

		//Se crean los metodos doble click en mouse derecho y izquierdo
		if (app.mouseButton == app.LEFT) {
			if (app.mouseEvent.getClickCount() == 2) { // doble click izquierdo
				System.out.println("Un nuevo objeto de Centro ha sido creado");
				centros.add(
						new Centro(app, app.random(30, 270), app.random(app.width / 2, 470), (int) app.random(2, 10)));
			}
		}

		if (app.mouseButton == app.RIGHT) {
			if (app.mouseEvent.getClickCount() == 2) { // doble click derecho
				System.out.println("Un nuevo objeto de Petalo ha sido creado");
				petalos.add(new Petalo(app, app.random(30, 270), app.random(20, app.width / 2)));
			}
		}

	}

	public void moverClick() {

		if (selCentro != null) {
			selCentro.setPosX(app.mouseX);
			selCentro.setPosY(app.mouseY);
		}

		if (selPetalo != null) {
			selPetalo.setPosX(app.mouseX);
			selPetalo.setPosY(app.mouseY);
		}

	}

	public void soltarClick() {
		selCentro = null;
		selPetalo = null;
	}
}
