package com.softgraf.control;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {//para poder iniciar o javaFx
		URL fxml = this.getClass().getResource("/com/softgraf/view/TelaCalc.fxml");//encontra o caminho do fxml
		Parent painel=(Parent) FXMLLoader.load(fxml);
		
		stage.setScene(new Scene(painel));
		stage.setTitle("calculadora FX");
		stage.setResizable(false);
		stage.show();
		
		
	}

}
