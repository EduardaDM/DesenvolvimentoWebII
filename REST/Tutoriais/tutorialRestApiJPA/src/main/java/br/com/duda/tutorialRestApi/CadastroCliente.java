package br.com.duda.tutorialRestApi;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CadastroCliente {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Clientes-PU");
		EntityManager em = emf.createEntityManager();

		// == create ===
		em.getTransaction().begin();
		Cliente novo = new Cliente();
		novo.setNome("Gomes Supermercado");
		em.persist(novo);
		em.getTransaction().commit();

		// == read all ==
		List<Cliente> clientes = em.createQuery("from Cliente", Cliente.class).getResultList();
		for (Cliente c : clientes) {
			System.out.println(c);
		}

		// === delete ===
		em.getTransaction().begin();
		Cliente c2 = em.find(Cliente.class, 2);
		if (c2 != null) {
			em.remove(c2);
		}
		em.getTransaction().commit();

		// === update ===
		em.getTransaction().begin();
		Cliente c1 = em.find(Cliente.class, 1);
		if (c1 != null) {
			c1.setNome("Autopeças Rodovia");
		}
		em.getTransaction().commit();

		em.close();
		emf.close();
	}// main
}//classe
