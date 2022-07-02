package redes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class TesteUrl extends Application {
private static String pagina = "";
	
	public static void main(String[] args) throws IOException {
		
		
		
		URL url = new URL("https://softgraf.com/site");

		
		System.out.println(url.getPort());
		System.out.println(url.getHost());
		System.out.println(url.getPath());
		System.out.println(url.getQuery());
		System.out.println(url.getFile());
		System.out.println(url.getRef());
		
		//cria um buffer de leitura
		BufferedReader leitor = new BufferedReader(new InputStreamReader(url.openStream()));
		
		String linha;
		while ((linha = leitor.readLine()) != null) {
			pagina = pagina + linha;
		}
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		AnchorPane painel = new AnchorPane();
		
		WebView web = new WebView();
		web.setPrefSize(1280, 800);
		//web.getEngine().load("file:///C:/Users/Aluno%20308/Desktop/pagina.html");
		web.getEngine().loadContent(pagina);
		
		painel.getChildren().add(web);
		
		Scene cena = new Scene(painel);
		stage.setScene(cena);
		stage.setTitle("Meu navegador web");
		stage.show();
	}
}