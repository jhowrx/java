package controller;

import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Aluno;

public class TelaController {
	
	private Alert alerta = new Alert(AlertType.WARNING);
	
	@FXML
    private TableView<Aluno> tabelaAluno;
	
	
	@FXML
 	private TableColumn<Aluno, Long> colId;
	
	@FXML
	private TableColumn<Aluno, String> colFone;

	@FXML
	private TableColumn<Aluno, String > colCpf;
	
 	@FXML
	private TableColumn<Aluno, String> colNome;


	@FXML
	private TextField txtCpf;

	@FXML
	private TextField txtFone;

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtNome;

	@FXML
	private Label labelMsg;
	
	
	//metodo carregado automaticamente assim que a tela é exibida
	@FXML 
	void initialize() {
		List<Aluno> alunos = Principal.daoAluno.listar();
		ObservableList<Aluno> listAlunos = FXCollections.observableArrayList(alunos);
		
		colId.setCellValueFactory(new PropertyValueFactory<Aluno, Long>("id"));
		colNome.setCellValueFactory(new PropertyValueFactory<Aluno, String>("nome"));
		colCpf.setCellValueFactory(new PropertyValueFactory<Aluno, String>("cpf"));
		colFone.setCellValueFactory(new PropertyValueFactory<Aluno, String>("fone"));
		
		tabelaAluno.setItems(listAlunos);
		
		
		//tabela gráfica -> dados     ->   evento
		tabelaAluno.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Aluno>() {

			@Override
			public void changed(ObservableValue<? extends Aluno> valor, Aluno oldAluno, Aluno newAluno) {
				txtId.setText(newAluno.getId().toString());
				txtNome.setText(newAluno.getNome());
				txtCpf.setText(newAluno.getCpf());
				txtFone.setText(newAluno.getFone());
				
				
			}
		});
	}
	
	void limpar() {
		txtId.clear();
		txtNome.clear();
		txtCpf.clear();
		txtFone.clear();
	}
		
	

	@FXML
	void acaoLimpar(ActionEvent event) {
		limpar();

	}

	@FXML
	void acaoSalvar(ActionEvent event) {

		String strId = txtId.getText();
		String nome = txtNome.getText();
		String cpf = txtCpf.getText();
		String fone = txtFone.getText();

		// salva aluno
		if (strId.isEmpty()) {
			Aluno aluno = new Aluno(nome, cpf, fone);
			Principal.daoAluno.inserir(aluno);
			labelMsg.setText("Dados salvos!");
			// atualiza aluno
		} else {
			long id = Long.parseLong(strId);
			Aluno retorno = Principal.daoAluno.buscar(id);

			if (retorno == null)
				labelMsg.setText("ID do aluno não encontrado para atualizar dados!");
			else {
				Aluno aluno = new Aluno(nome, cpf, fone);
				aluno.setId(id);
				Principal.daoAluno.atualizar(aluno);
				labelMsg.setText("Dados atualizados!");
			}
		}
	}
	@FXML
	void acaoBuscar(ActionEvent event) {
		String strId = txtId.getText();
		if (strId.isEmpty()) {
			alerta.setTitle("Aviso");
			alerta.setHeaderText("Você Esqueceu!");
			alerta.setContentText("Faltou digitar o id do aluno");
			alerta.showAndWait();
		}else {
			//converte string para long
			long id = Long.parseLong(strId);
			Aluno aluno = Principal.daoAluno.buscar(id);
			if(aluno != null) {
				txtNome.setText(aluno.getNome());
				txtCpf.setText(aluno.getCpf());
				txtFone.setText(aluno.getFone());
			}else {
				alerta.setTitle("Aviso");
				alerta.setHeaderText("Não achou!");
				alerta.setContentText("O aluno com ID=" + strId + " não foi encontrado.");
				alerta.showAndWait();
			}
		}
	}

	@FXML
	void acaoApagar(ActionEvent event) {
		String strId = txtId.getText();
		if (strId.isEmpty()) {
			alerta.setTitle("Aviso");
			alerta.setHeaderText("Você Esqueceu!");
			alerta.setContentText("Faltou digitar o id do aluno");
			alerta.showAndWait();
		}else {
			//converte string para long
			long id = Long.parseLong(strId);
			Boolean apagou = Principal.daoAluno.apagar(id);
			if(apagou) {
				labelMsg.setText("Dados deletados com sucesso!");
				limpar();
			}else {
				alerta.setTitle("Aviso");
				alerta.setHeaderText("Não apagou!");
				alerta.setContentText("ID não encontrado ou falha ao apagar");
				alerta.showAndWait();
			}
		}
	}
	
}
