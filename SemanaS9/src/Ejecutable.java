import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import processing.core.*;

public class Ejecutable extends PApplet {
	private Cronometro cronometro = new Cronometro();

	@Override
	public void settings() {
		size(600, 200);
	}

	@Override
	public void setup() {
		noStroke();
	}

	@Override
	public void draw() {
		background(150);

		text("EMPEZAR", 90, 170);
		ellipse(width / 5 * 1, height / 2, 100, 100);

		text("DETENER", 210, 170);
		ellipse(width / 5 * 2, height / 2, 100, 100);

		text("ACELERAR TIEMPO", 300, 170);
		ellipse(width / 5 * 3, height / 2, 100, 100);

		text("DESACELERAR TIEMPO", 430, 170);
		ellipse(width / 5 * 4, height / 2, 100, 100);

		text("CRONOMETRO", 80, 40);
		text( "Mill: "+(char) cronometro.getMilesimas(), 200, 40);
		text( "Seg: "+(char) cronometro.getSegundos(), 270, 40);
		text( "Min: "+(char) cronometro.getMinutos(), 350, 40);
	}

	@Override
	public void mousePressed() {

		if (PApplet.dist(mouseX, mouseY, width / 5 * 1, height / 2) < 50) {
			System.out.println("boton1");
			cronometro.comenzar();
		}
		
		if (PApplet.dist(mouseX, mouseY, width / 5 * 2, height / 2) < 50) {
			System.out.println("boton2");
			cronometro.parar();
		}
		
		if (PApplet.dist(mouseX, mouseY, width / 5 * 3, height / 2) < 50) {
			System.out.println("boton3");
			cronometro.getAcelerar();
		}
		
		if (PApplet.dist(mouseX, mouseY, width / 5 * 4, height / 2) < 50) {
			System.out.println("boton4");
			cronometro.getDesacelerar();
		}
	}

	static public void main(String[] passedArgs) {
		String[] appletArgs = new String[] { "Ejecutable" };
		if (passedArgs != null) {
			PApplet.main(concat(appletArgs, passedArgs));
		} else {
			PApplet.main(appletArgs);
		}
	}
		
		
}
