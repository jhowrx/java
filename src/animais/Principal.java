package animais;

public class Principal {

	public static void main(String[] args) {
		
		//cria um objeto animal
		Animal animal = new Animal();
		animal.nome = "Totó";
		animal.especie = "Mamífero";
		
		//a partir dos objetos acessa os metodos
		animal.dormir();
		animal.comer();
		animal.locomover();
		
		//cria um objeto do tipo Mamifero
		Mamifero mamifero = new Mamifero();
		mamifero.comer();
		mamifero.dormir();
		mamifero.locomover();
		mamifero.mamar();
		
		//cria um objeto do tipo Reptil
		Reptil reptil = new Reptil();
		reptil.rastejar();
		reptil.dormir();
		
		//cria um objeto do tipo ave
		Ave ave = new Ave();
		ave.voar();
		ave.dormir();
		
		//cria um objeto do tipo Cao
		Cao cao = new Cao();
		cao.latir();
		cao.dormir();
		
		//cria um objeto Gato
		Gato gato = new Gato();
		gato.miar();
		gato.dormir();
		gato.locomover();
		
		
	}

}
