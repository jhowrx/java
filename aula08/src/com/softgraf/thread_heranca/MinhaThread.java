package com.softgraf.thread_heranca;

public class MinhaThread  extends Thread{
	
	/*
	 * Thread � uma classe java que permite processamento concorrente, ou seja, 
	 * consigo rodar multiplas classes ao mesmo tempo em um ou mais processadores.
	 * 
	 * H� duas formad]s de implementar Thread em Java:
	 * 
	 * 1. Atrav�s do processo de heran�a: estendendo a classe Thread do java
	 * 	e sobrescrevendo o m�todo run().
	 * -Principal problema da heran�a de Thread:
	 * Se precisarmos, n�o podemos estender outra classe.
	 * 
	 * 2. Atrav�s da implementa��o da classe Runnable do java: criamos uma classe 
	 * qualquer e implementamos Runnable sobrscrevendo o m�todo run()
	 * 
	 * Nesse exemplo estendemos a classe Thread, sobrescrevemos o metodo run()
	 * e depois executamos run() chamando o metodo start()
	 * 
	 * alguns metodos herdados da classe Thread:
	 * -run(): serve apenas para sobrescrita, nunca � chamado diretamente
	 * -start(): � atrav�s dele que �pe chamado o m�todo run()
	 * -sleep(): suspende a Thread por um intervalo de tempo dado em milisegundos
	 * -setName():define o nome da thread
	 * -currentThread(): retorna a Thread em execu��o no exato momento
	 * 
	 * IMPORTANTE: mesmo iniciando Threads em sequencia, nunca sabemos qual vai ser
	 *  a ordem exata da execu��o, mas podemos definir prioridades.
	 * 
	 * Em qualquer programa Java, temos pelo menos 2 threads em execu��o:
	 * -o m�todo main(), com alta prioridade.
	 * -o GC-Garbage Colletor- (DAEMON)-> coletor de lixo do java com baixa prioridade. 
	 * 
	 */
	
	@Override
	public void run () {
		for (int i = 0; i<10; i++) {
			System.out.println("Thread: " + Thread.currentThread().getName());
			
			try {
				Thread.sleep(1000);
				
			}catch (InterruptedException e){
				e.printStackTrace();
				
			}
		}
	}

}
