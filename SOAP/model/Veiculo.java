package model;

//import java.time.LocalDate;

public class Veiculo {
	private int id;
	private String modelo;
	private String placa;
	private int ano;
	
	public Veiculo(int id, String moddelo, String placa, int ano) {
		setId(id);
		setModelo(modelo);
		setPlaca(placa);
		setAno(ano);
	}

	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if (id <= 0) throw new IllegalArgumentException("ID inválido");
        this.id = id;
	}

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		if (modelo == null || modelo.isEmpty())
            throw new IllegalArgumentException("Modelo não pode ser vazio");
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		if (placa == null || placa.length() < 7)
            throw new IllegalArgumentException("Placa inválida");
        this.placa = placa;
	}

	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		//LocalDate dataAtual = LocalDate.now();
		//int anoAtual = dataAtual.getYear();
		
		int anoAtual = java.time.Year.now().getValue();
		
		 if (ano < 1950 || ano > anoAtual) //ver se tem algo pronto p ver a data atual como max
	            throw new IllegalArgumentException("Ano inválido");
	        this.ano = ano;
	}
}
