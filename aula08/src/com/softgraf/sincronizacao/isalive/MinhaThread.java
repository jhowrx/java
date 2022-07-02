package com.softgraf.sincronizacao.isalive;

public class MinhaThread extends Thread {
	
	private String nome;
	
	public MinhaThread(String nome) {
		this.nome = nome;
	}
	
	public void run() {
		try {
			for(int i = 0; i < 5; i++) {
				System.out.println("\n Rodando thread " + nome + " - contador = " + 1);
				Thread.sleep(1000);//dorme 1 seg
			}	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\n Thread " +nome+ " finalizou");
	}
	
	public static void main(String[] args) {
		Thread t1 = new MinhaThread("T1");
		Thread t2 = new MinhaThread("T2");
		Thread t3 = new MinhaThread("T3");
		
		System.out.println("Iniciando threads...");
		
		t1.start();
		t2.start();
		t3.start();
		
		do {
			System.out.print(".");
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while (t1.isAlive() || t2.isAlive() || t3.isAlive());
		
		System.out.println("\n\nThread T1 est� viva? " + t1.isAlive());
		System.out.println("\nNome da thread atual = " + Thread.currentThread().getName());
		System.out.println("\n\nThread main est� viva? " + Thread.currentThread().isAlive()); //enquanto a thread estiver executando est� viva, se n�o, est� morta
		
		
		System.out.println("Main finalizou");
	}
}

