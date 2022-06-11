package com.softgraf.control;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.softgraf.entity.Cliente;
import com.softgraf.entity.Endereco;
import com.softgraf.entity.Item;
import com.softgraf.entity.Pedido;
import com.softgraf.entity.Produto;

public class Persistindo {
	
	public static void main (String[] args) {
		Endereco ruaXV = new Endereco("Rua XV de novembro, 123", "Ponta Grossa", "Paran�");
		
		Cliente joao = new Cliente("Jo�o da Silva",ruaXV);
	
		Pedido ped = new Pedido();
		ped.setCliente(joao);
		ped.setData(new Date());
		
		Produto bolacha = new Produto();
		bolacha.setNome("Bolahca Maria");
		bolacha.setPreco(5.99f);
		
		Produto bala = new Produto();
		bala.setNome("Bala 7 belo");
		bala.setPreco(7.50f);
		
	
		Item item1 = new Item();
		item1.setPedido(ped);
		item1.setProduto(bolacha);
		item1.setQuantidade(10);//10 pacotes de bolacha maria
		

		Item item2 = new Item();
		item2.setPedido(ped);
		item2.setProduto(bala);
		item2.setQuantidade(3);//10 pacotes de bolacha maria
		
		ped.addItem(item1);
		ped.addItem(item2);
		
		joao.addPedido(ped);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("softgraf_pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(joao);
		
		tx.commit();
		
		em.close();
		emf.close();
	}

}
