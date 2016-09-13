
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import processing.core.*;

public class Bola implements Comparable <Bola> {
	  private PApplet app;
	  protected int radio, x, y;

	  public Bola(PApplet app){
			this.app = app;
	  }
	  
	public Bola(PApplet app, int x, int y, int radio){
			this.app = app;
			this.x = x;
			this.y = y;
			this.radio = radio;
			}
	
	public void pintar(int x, int y, int radio){
		this.x = x;
		this.y = y;
		this.radio = radio;
		app.ellipse(x,y,radio,radio);
	}
	

	  public int hashCode(){
	    return radio;
	  }
	  
	  public int compareTo(Bola o) {
		  return (radio-o.radio);
	  }
	  
	  @Override
	  public boolean equals(Object obj) {
		  getRadio();
			if(obj instanceof Bola){
				Bola e = (Bola) obj;
				if(e.radio == radio){
					return (this == obj);
				}
			}
			return false;
	  	
	  }

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int compare(Bola o1, Bola o2) {
		return 0;
	}
}

