package model;

public class Aluno {
	
	private Long id;
	private String nome;
	private String cpf;
	private String fone;
	
	//construtor padrao (sem parametros)
	public Aluno() {
		
	}
	
	public Aluno(String nome, String cpf, String fone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.fone = fone;
	}




	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	@Override
	public String toString() {
		return String.format("ID:%-5d Nome: %-20s cpf: %-15s Fone: %-15s", id, nome, cpf, fone);
	}

}
