package br.com.crud.model;



/**
 *
 * @author Adriana
 */
public class Cliente {
    
 
	private  String nome = "";
	private  int idade = 0;
        private  String email = "";
        private  String destino = "";
	
	@Override
	public String toString() {
		return nome + " :: " + idade + " :: " + email+ " :: " + destino;
	}

    public String getNome() {
        return nome;
    }
    
     public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDestino() {
        return destino;
    }
    
    public void setDestino(String destino) {
        this.destino = destino;
}

 
}