package com.softgraf.controler;



import java.util.Date;

import com.softgraf.model.Cliente;
import com.softgraf.model.Endereco;
import com.softgraf.model.Item;
import com.softgraf.model.Pedido;
import com.softgraf.model.Produto;

public class Principal {
	
	public static void main(String[] args) {
		
	
		Produto p1 = new Produto("123", "Melhoral Infantil", 1,99F);	
		System.out.println(p1);
		
		
		
		Produto p2 = new Produto();
		p2.setCodigo("456");
		p2.setDescricao("Vitamina D com Zinco");
		p2.setPrecoUnitario(49.99f);
		
		System.out.println(p2.getCodigo());
		System.out.println(p2.getDescricao());
		System.out.println(p2.getPrecoUnitario());
		 		
		
		
		
		Endereco ruaXv = new Endereco();
		
		
		ruaXv.setRua("XV de Novembro, 123");
		ruaXv.setCidade("Ponta Grossa");
		ruaXv.setEstado("Paraná");
		ruaXv.setCep("84010-100");
		
		System.out.println(ruaXv.getRua());
		System.out.println(ruaXv.getCidade());
		System.out.println(ruaXv.getEstado());
		System.out.println(ruaXv.getCep());
		
		
		
		Cliente joao = new Cliente();
		
		
		joao.setCodigo("C999");
		joao.setNome("João da Silva");
		joao.setEndereco(ruaXv);
		
		System.out.println(joao.getCodigo());
		System.out.println(joao.getNome());
		System.out.println(joao.getEndereco().getRua());
		System.out.println(joao.getEndereco().getCidade());
		System.out.println(joao.getEndereco().getEstado());
		System.out.println(joao.getEndereco().getCep());	
		
		
		
		Pedido ped1 = new Pedido();
		
		
		ped1.setNumero(333);
		ped1.setData(new Date());
		ped1.setCliente(joao);
		
		System.out.println(ped1.getNumero());
		System.out.println(ped1.getData());
		System.out.println(ped1.getCliente().getNome());
		
		
		
		Item item1 = new Item();
		
		
		item1.setQtdProduto(10);
		item1.setProduto(p1);
		item1.setNumero(1234);
		
		System.out.println(item1.getQtdProduto());
		System.out.println(item1.getProduto().getDescricao());
		System.out.println(item1.getNumero());
		
		
		
		Item item2 = new Item();
		
		
		item2.setQtdProduto(20);
		item2.setProduto(p2);
		item2.setNumero(2);
		
		System.out.println(item2.getQtdProduto());
		System.out.println(item2.getProduto().getDescricao());
		System.out.println(item2.getNumero());
		
		ped1.addItem(item1);
		ped1.addItem(item2);
		
		System.out.println(ped1.listaItens().get(0).getNumero());
		System.out.println(ped1.listaItens().get(0).getProduto().getDescricao());
		System.out.println(ped1.listaItens().get(0).getQtdProduto());
		
		System.out.println(ped1.listaItens().get(1).getNumero());
		System.out.println(ped1.listaItens().get(1).getProduto().getDescricao());
		System.out.println(ped1.listaItens().get(1).getQtdProduto());
		
	}	

}
