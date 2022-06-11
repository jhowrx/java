package com.softgraf.control;

import javax.persistence.EntityManager;

import com.softgraf.entity.Cliente;
import com.softgraf.util.JpaUtil;

public class BuscandoPorId {

	public static void main(String[] args) {
		 
		EntityManager em = JpaUtil.getEntityManager();
		
		//retorna um cliente pelo id
		Cliente cliente = em.find(Cliente.class, 1);
		
		if (cliente != null)
			System.out.println(cliente.getNome());
		else
			System.out.println("ID n�o encontrado");
		
		
		
		em.close();
		JpaUtil.close();

	}

}
