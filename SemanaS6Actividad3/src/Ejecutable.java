import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import processing.core.*;

public class Ejecutable extends PApplet {
	private PApplet app;
	Bola ppa;

	HashSet<Bola> bolitasHashSet;
	TreeSet<Bola> bolitasTreeSet;
	ArrayList<Bola> bolitasArrayList;

	@Override
	public void settings() {
		size(600, 200);
	}

	@Override
	public void setup() {
		ppa = new Bola(this);
		noStroke();

		bolitasHashSet = new HashSet<>();
		bolitasTreeSet = new TreeSet<>();
		bolitasArrayList = new ArrayList<>();
		bolitasHashSet.add(new Bola(this, 100, 100, 5));
		bolitasHashSet.add(new Bola(this, 200, 100, 10));
		bolitasHashSet.add(new Bola(this, 300, 100, 15));
		bolitasHashSet.add(new Bola(this, 400, 100, 20));
		bolitasHashSet.add(new Bola(this, 500, 100, 25));
		
		bolitasArrayList.add(new Bola(this, 100, 100, 5));
		bolitasArrayList.add(new Bola(this, 200, 100, 10));
		bolitasArrayList.add(new Bola(this, 300, 100, 15));
		bolitasArrayList.add(new Bola(this, 400, 100, 35));
		bolitasArrayList.add(new Bola(this, 500, 100, 25));
	}

	@Override
	public void draw() {
		background(200);

		for (Iterator lector = bolitasHashSet.iterator(); lector.hasNext();) {
			Bola bola = (Bola) lector.next();
			//bola.pintar();
		}

		for (Iterator lector = bolitasTreeSet.iterator(); lector.hasNext();) {
			Bola bola = (Bola) lector.next();
			bola.pintar(100, 100, 50);
		}

		textSize(12);
		text("Tamano del TreeSet: " + bolitasTreeSet.size(), 50, 30);
		text("Tamano del HashSet: " + bolitasHashSet.size(), 50, 45);

		text("Cambio entre TreeSet y HashSet con ESPACIO", 50, 60);
		
		for (int i = 0; i < bolitasArrayList.size(); i++) {
			bolitasArrayList.get(i).pintar(20*i+50, height/2, (int)Math.random()*200);
		}
		
		

	}

	@Override
	public void keyPressed() {

		if (key == ' ') {

			if (bolitasTreeSet.size() == 0) {
				if(bolitasHashSet.equals(bolitasTreeSet)){
					System.out.println("pos ya");
				}
				bolitasTreeSet = new TreeSet<Bola>(bolitasHashSet);
				bolitasHashSet.clear();

				for (Iterator lector = bolitasTreeSet.iterator(); lector.hasNext();) {
					Bola bola = (Bola) lector.next();
					System.out.println("Radio dentro del Hashset: " + bola.getRadio());
				}
			} else {

				if (bolitasHashSet.size() == 0) {
					
					
					bolitasHashSet = new HashSet<Bola>(bolitasTreeSet);
					bolitasTreeSet.clear();

					for (Iterator lector = bolitasTreeSet.iterator(); lector.hasNext();) {
						Bola bola = (Bola) lector.next();
						System.out.println("Radio dentro del Hashset: " + bola.getRadio());
					}
				}
			}
		}
		
		Collections.sort(bolitasArrayList);

		System.out.println("Tamano del HashSet: " + bolitasTreeSet.size());
		System.out.println("Tamano del ArrayList: " + bolitasArrayList.size());
		System.out.println("Tamano del ArrayList: " + bolitasHashSet.size());
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
