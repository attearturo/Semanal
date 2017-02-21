import processing.core.*;

public class Petalo {
	//Se definen las variables de petalo
	private PApplet app;
	private float posX, posY, r, g, b, x, y, angulo, radio;
	private boolean rotar = true;
	
	
	//Se crea el constructor de petalo
	public Petalo(PApplet app, float posX, float posY){
		
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		
		r=app.random(255);
		g=app.random(255);
		b=app.random(255);
		x= 0;
		y= 0;
		angulo = 2/PConstants.PI;
		radio = 30;
		
	}
	
	public void rotar(){
		//Daniel Perez me dió la formula en X y Y para girar
		x = radio*PApplet.cos(angulo);
		y = radio*PApplet.sin(angulo);
		
	}
	
	public void pintar(){
		//Se pintan los petalos
		app.fill(r, g, b);
		app.ellipse(posX + x, posY + y, 20, 20);
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getAngulo() {
		return angulo;
	}

	public void setAngulo(float angulo) {
		this.angulo = angulo;
	}

	public float getRadio() {
		return radio;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}

	public boolean isRotar() {
		return rotar;
	}

	public void setRotar(boolean rotar) {
		this.rotar = rotar;
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
