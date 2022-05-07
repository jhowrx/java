package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunoDao implements Dao<Aluno>{
	
	private Connection conexao;
	
	public AlunoDao(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public boolean inserir(Aluno aluno){
		
		String sql = "INSERT INTO aluno (nome, cpf, fone ) VALUES (?, ?, ?)";
		
		PreparedStatement cmd;
		try {
			cmd = conexao.prepareStatement(sql);
			cmd.setString(1, aluno.getNome());
			cmd.setString(2, aluno.getCpf());
			cmd.setString(3, aluno.getFone());
			//retorna o numero de linhas afetadas
			int retorno = cmd.executeUpdate();
			return retorno > 0;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	
		
	}

	@Override
	public boolean atualizar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buscar(long id) {
		String sql = "SELECT * from Aluno WHERE id= ? ";
		Aluno aluno = null;
		
		try {
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setLong(1, id);
			ResultSet rs = cmd.executeQuery();
			//verifica se o result set retornou pelo menos uma linha
			if (rs.next()) {
				//pega a coluna nome e salva na variavel nome
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String fone= rs.getString("fone");
				aluno = new Aluno (nome, cpf, fone);
			}
			cmd.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}				
		return false;
	}

	@Override
	public List<Aluno> listar() {
		String sql = "SELECT * from Aluno ORDER  by id";
		List<Aluno> lista = new ArrayList();
		
		try {
			PreparedStatement cmd = conexao.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			//verifica se o result set retornou pelo menos uma linha
			while (rs.next()) {
				//pega a coluna nome e salva na variavel nome
				long id = rs.getLong("id");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String fone= rs.getString("fone");
				
				Aluno aluno = new Aluno (nome, cpf, fone);
				aluno.setId(id);
				
				lista.add(aluno);
			}
			cmd.close();
			
		}catch (SQLException e) {
			e.printStackTrace();			
		}
		return lista;
	}

	@Override
	public boolean apagar(long id) {
		String sql = "DELETE from Aluno WHERE id= ? ";
		
		//compila o codigo sql
		try {
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setLong(1, id);
			int retorno = cmd.executeUpdate(); // 0 ou > 0
			cmd.close();
			return retorno > 0;
	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

}
