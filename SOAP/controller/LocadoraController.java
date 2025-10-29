package controller;

import java.util.ArrayList;
import java.util.List;
import model.Locadora;

public class LocadoraController {
	
	// Lista que vai simular o "banco de dados" das locadoras
	private List<Locadora> locadoras = new ArrayList<>();
	
	// CREATE - adicionar uma nova locadora
	public void create(Locadora locadora) {
		if(locadora == null)
			throw new IllegalArgumentException("Locadora não pode ser nula");
		
		//verifica duplicidade de ID
		for (Locadora l : locadoras) {
			if (l.getId() == locadora.getId())
				throw new IllegalArgumentException("Já existe uma locadora com esse ID");
		}
		locadoras.add(locadora); //add na lista
	}
	
	// READ - buscar id de locadora
	public Locadora read(int id) {
		if(id <= 0) throw new IllegalArgumentException("ID inválido");
		
		for(Locadora l : locadoras) {
			if(l.getId() == id) 
				return l;
		}
		return null; //se não encontrar
	}
	
	// READ - listar todas as Locadoras
	public List<Locadora> readAll(){
		return new ArrayList<>(locadoras); //retorna a copia da lista
	}
	
	// UPDATE - atualizar dados da locadora
	public void update(Locadora locadora) {
		if(locadora == null) throw new IllegalArgumentException("Locadora não pode ser nula");
		
		boolean atualizado = false;
		
		/*
		 * pode ser feito dessa forma com o for, ou com o while como descrito abaixo 
		 *for(int i=0; i<locadoras.size(); i++) {
			if(locadoras.get(i).getId() == locadora.getId()) {
				locadoras.set(i, locadora); //substitui a informacao
				atualizado = true;
				break; 
				//esse break refere-se ao if, se encontrar na 1ª pos por ex, ai sai do for
			}
		} 
		 */
		
		//forma sem o for:  
		int i = 0;
		while(i < locadoras.size() && !atualizado) {
			if(locadoras.get(i).getId() == locadora.getId()) {
				locadoras.set(i, locadora); //substitui a informacao
				atualizado = true;
			}
			i++;
		}
		
		if(!atualizado) 
			throw new IllegalArgumentException("Locadora não encontrada para atualização.");
	}
	
		// DELETE - remover locadora pelo ID
		public void delete(int id) {
			if(id<=0) throw new IllegalArgumentException("ID inválido");
			
			boolean removido = locadoras.removeIf(l -> l.getId() == id);
			
			if(!removido) 
				throw new IllegalArgumentException("Locadora não encontrada");
		}
	}
