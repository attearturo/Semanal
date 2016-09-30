
public final class Cronometro implements Runnable {

	private long comenzar;
	private long parar;
	private Thread hilo = new Thread();

	public void comenzar() {
		comenzar = System.currentTimeMillis();
	}

	public void parar() {
		parar = System.currentTimeMillis();
	}

	public long getTiempo() {
		return parar - comenzar;
	}

	public double getMilesimas() {
		return (parar - comenzar) / 1000.0;
	}

	public double getSegundos() {
		return (parar - comenzar) / 1000.0;
	}

	public double getMinutos() {
		return (parar - comenzar) / 60000.0;
	}
	
	public double getAcelerar() {
		return comenzar*2;
	}
	
	public double getDesacelerar() {
		return comenzar/2;
	}


	static public void main(String[] args) {

		//hilo.start();
		Cronometro cronometro = new Cronometro();

		cronometro.comenzar();
		for (int i = 1; i < 1000000; i++) {
		}
		cronometro.parar();
		System.out.println(cronometro.getTiempo());

		cronometro.comenzar();
		for (int i = 1000000; i > 0; i--) {
		}
		cronometro.parar();
		System.out.println(cronometro.getTiempo());
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
