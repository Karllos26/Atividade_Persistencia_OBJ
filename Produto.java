package semana06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Produto implements Serializable {
	
	private int codigo;
	private String descricao;
	private double valor;
	
	public String toString() {
		return "["+codigo+","+descricao+","+valor+"]";
	}
	
	public Produto ler() {
	
		try {
			
			FileInputStream grva = new FileInputStream(new File("c:/Temp/produto"+codigo+".txt"));
			ObjectInputStream lr = new ObjectInputStream(grva);
			Produto prod = (Produto) lr.readObject();
			lr.close();
			
			return prod;
		}
		catch(Exception erro) {
		return null;	
		}
		
	}
	
	/**
	 * Grava em arquivo .txt o estado atual do objeto
	 * @return - uma mensagem informando o resultado da gravação
	 */
	public String persisteProduto() {
		String r = "";
		try {
			
			FileOutputStream grva = new FileOutputStream(new File("c:/temp/produto"+codigo+".txt"));
			ObjectOutputStream grv = new ObjectOutputStream(grva);
			grv.writeObject(this);
			grv.close();
			
			r = "Produto gravado com sucesso!";
		}
		catch(IOException erro) {
			r = "Falha na gravação "+erro;
		}
		return r;
	}
	
	public String lerObjeto() {
		Produto produto = ler();
		if (produto != null) {
			return produto.toString();
		} else {
			return "Não foi possível ler o arquivo";
		}
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	
	
}
