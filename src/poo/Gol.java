package poo;

//gol é um automovel e TEM um radio
public class Gol extends Automovel implements Radio{

	public Gol(Motor motor) {
		// chama o construtor da classe mae
		super(motor);
	}
	
	public void tocarMusica() {
		System.out.println("AE EEE AO OOO");
		
	}
}
