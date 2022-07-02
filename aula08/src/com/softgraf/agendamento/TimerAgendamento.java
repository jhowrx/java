package com.softgraf.agendamento;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerAgendamento {

	private static boolean tic = true;
	private static int contador = 0;
	
	public static void main(String[] args) {
		
		
		Timer timer = new Timer();
		Timer timerBkup = new Timer();
		
		TimerTask tarefa = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println(tic ? "Tic..." : "Tac...");
				tic = !tic;
				if (contador++ == 10) {
					timer.cancel();
				System.out.println("Acabou a pilha de relógio");
				}
			}
		};
		
TimerTask tarefaBkup = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("\nFazendo backup do sistema... OK");
				timerBkup.cancel();
				
			}
		};
		
		System.out.println("Aguardando a execução da tarefa");

		//inicia uma tarefa após 5 segundos e repete a cada 1 segundo
		timer.schedule(tarefa, 5000, 1000);
		
		Date horario = new Date(System.currentTimeMillis()+30000); //agora + 30 seg
		timerBkup.schedule(tarefaBkup, horario);
		
		System.out.println("\nThread main() finalizou");
	}

}
