package basico;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Helloworld extends Application {

	public static void main(String[] args) {
		//chama o metodo start do java fx
		launch();

	}

	@Override
	public void start(Stage stage) throws Exception {
		//elemento pai com layout de pilha
		StackPane painel = new StackPane();
		//texto
		Label lblMensagem = new Label ("Ol� Mundo! Bem vindo ao JavaFX!!");
		
		//recupera os filhos do painel e depis add o label
		painel.getChildren().add(lblMensagem);
		
		                  //tamanho da cema
		Scene cena = new Scene(painel, 250, 100);
		stage.setTitle("Tela com java FX");
		stage.setScene(cena); // guarda a cena no stage
		stage.show();
		
	}

}
