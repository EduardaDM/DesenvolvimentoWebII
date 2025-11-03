package model;

import java.util.ArrayList;
import javax.jws.WebMethod;

public class Locadora {
	private int id;
	private String nome;
	private String endereco;
	private ArrayList<Veiculo> veiculos = new ArrayList<>();
	
	public Locadora() {}
	
	public Locadora(int id, String nome, String endereco) {
		setId(id);
		setNome(nome);
		setEndereco(endereco);
		this.veiculos = new ArrayList<Veiculo>();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(id <= 0)
			if (id <= 0) throw new IllegalArgumentException("ID inválido");
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome == null || nome.isEmpty()) 
			throw new IllegalArgumentException("Nome inválido");
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(endereco == null || endereco.isEmpty())
			throw new IllegalArgumentException("Endereço inválido");
		this.endereco = endereco;
	}

	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}
	
	//== CRUDS -> Add, Read (i), ReadAll, Update, Delete ==
	
	//== CREATE - add veiculos ===========
	public void addVeiculos(Veiculo veiculo) {
		
		//verifica veiculo como um todo se está nulo
		if(veiculo == null)
			throw new IllegalArgumentException("O veículo não pode ser nulo");
		
		//forma de percorrer a lista, p verificação de duplicados
		for(Veiculo v : veiculos) {
			if(v.getId() == veiculo.getId()) 
				throw new IllegalArgumentException("Já existe um veiculo com esse ID");		
		}
		
		veiculos.add(veiculo); //add veiculo na lista
	}
	

	//== READ - ler veiculos pelo ID ======
	public Veiculo getVeiculo(int id) {
		if(id <= 0) throw new IllegalArgumentException("ID inválido");
		
		//procura na lista e retorna se achar
		for (Veiculo v : veiculos) {
            if (v.getId() == id) {
                return v;
            }
		}
	return null; // se não encontrar
	}
	
	//== CREATE - add veiculos ===========
	public ArrayList<Veiculo> getAllVeiculos(){
		// retorna uma cópia para não expor a lista original
		return new ArrayList<>(veiculos);
	}
	
	//== UPDATE - Atualizar um veículo existente ===
	public void updateVeiculo(Veiculo veiculoAtualizado) {
		if(veiculoAtualizado == null)
			throw new IllegalArgumentException("O veículo não pode ser nulo");
			
		boolean atualizado = false;
		for(int i = 0; i<veiculos.size(); i++) {
			if(veiculos.get(i).getId() == veiculoAtualizado.getId()) {
				// substitui o veículo antigo pelo novo
				veiculos.set(i, veiculoAtualizado);
				atualizado = true;
				break;
			}
		}
		
		if(!atualizado) 
			throw new IllegalArgumentException("Veículo não encontrado para atualização");
	}
	
	//== DELETE - Remover veículo pelo ID ===
	public void deleteVeiculo(int id) {
		if(id <= 0) 
            throw new IllegalArgumentException("ID inválido");
		
		//abreviação de um if que se o id de veiculos do qual queremos remover
		//for igual ao que está na lista, então será removido
		boolean removido = veiculos.removeIf(v -> v.getId() == id);				
	
		if(!removido) 
			throw new IllegalArgumentException("Veiculo não encontrado para exclusão");	
	}
	
	@Override
    public String toString() {
        return "Locadora ID: " + id + " | Nome: " + nome + " | Endereço: " + endereco +
               "\n--- Veículos ---\n" + listarVeiculos();
    }
	
	@WebMethod
	public String listarVeiculos() {
		String listaVeiculos = "";
		
		if(listaVeiculos.isEmpty()) 
			listaVeiculos = "Nenhum veículo encontrado";
		
		for(Veiculo v : veiculos) {
			listaVeiculos += v.toString() + "\n";
		}	
		return listaVeiculos;
	}
}
