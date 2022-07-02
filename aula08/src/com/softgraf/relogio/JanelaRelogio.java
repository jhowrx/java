package com.softgraf.relogio;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JanelaRelogio extends JFrame implements Runnable{

	
	
	private static final long serialVersionUID = 4449465731062643522L;
	private JLabel lblHora;
	private JButton btnIniciar, btnDormir, btnInterromper, btnFechar;
	private SimpleDateFormat formatador;
	private Thread threadRelogio;


	public JanelaRelogio() {
		Toolkit tk = Toolkit.getDefaultToolkit(); //informações da tela
		int largura = tk.getScreenSize().width; //largura da tela
		
		setSize(220, 300);
		setLocation(largura - 220, 0);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true); //remove os controles
		setBackground(new Color(1.0f,1.0f,1.0f,0.5f));//muda a opacidade do fundo da janela
		
		lblHora = new JLabel("00:00:00");
		lblHora.setSize(150, 30);
		lblHora.setLocation(50, 20);
		//altera o tamanho da fonte
		lblHora.setFont(new Font(lblHora.getName(), Font.PLAIN, 30));
		add(lblHora);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setSize(150, 30);
		btnIniciar.setLocation(40, 70);
		add(btnIniciar);
		
		btnIniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!threadRelogio.isAlive())
				threadRelogio.start();
				
			}
		});
		
		btnDormir = new JButton("Dormir");
		btnDormir.setSize(150, 30);
		btnDormir.setLocation(40, 110);
		add(btnDormir);
		
		btnDormir.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("\nSleeping... 5 segundos");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					System.out.println("Thread interrompida (acordada)");
					e1.printStackTrace();
					
				}
			}
		});
		
		
		btnInterromper = new JButton("Interromper");
		btnInterromper.setSize(150, 30);
		btnInterromper.setLocation(40, 150);
		add(btnInterromper);
		
		btnInterromper.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				threadRelogio.interrupt();
				
			}
		});
			
		
		
		
		btnFechar = new JButton("Fechar");
		btnFechar.setSize(150, 30);
		btnFechar.setLocation(40, 190);
		add(btnFechar);
		
		btnFechar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		formatador = new SimpleDateFormat("HH:mm:ss");
		threadRelogio = new Thread(this);
		
	}
	
	@Override
	public void dispose() {
		System.out.println("Adeus!");
		threadRelogio = null;
		super.dispose();
	}
	
	
	
	public static void main(String[] args) {
		
			JFrame janela = new JanelaRelogio();
			janela.setVisible(true);
		}

	@Override
	public void run() {
		System.out.println("Running...");
		
		while (threadRelogio != null) {
			System.out.println("Atualizando hora...");
			
			try{
				atualizaHora();
				Thread.sleep(1000);
				
			}catch (InterruptedException e) {
				System.out.println("Thread interrompida");
				e.printStackTrace();
				threadRelogio = null;
			}
			
			
		}
		
	}
	
	private void atualizaHora() {
		String hora = formatador.format(new Date());
		this.lblHora.setText(hora);
	}

}


