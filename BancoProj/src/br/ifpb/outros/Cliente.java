package br.ifpb.outros;

import java.util.ArrayList;

import br.ifpb.edu.Conta;

/**
 * Classe cliente que ira conter informacoes referentes ao cliente do banco
 * @author iponts
 *
 */
public class Cliente {
	
	private String nome = new String( );
	private String cpf = new String( );
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	
	public Cliente( ) {
		
	}
	
	/**
	 * Contrutor para cliente na ordem: nome, cpf
	 * @param n String com o nome do cliente
	 * @param cf String com o cpf do cliente
	 */
	public Cliente( String n, String cf ) {
		setNome( n );
		cpf = formataCPF( cf );
	}
	
	/**
	 * Cadastra uma nova conta ao cliente
	 * @param c Conta nova do cliente
	 */
	public void add( Conta e ) {
		if ( e != null ) {
		contas.add( e );
		e.setExtrato( "Uma nova conta foi adicionada: " + e.toString() );
		}
	}
	
	/**
	 * Remove uma conta do cliente dado sua posicao na lista
	 * @param index Posicao na lista
	 * @return Verdadeiro para sucesso na remocao / Falso para falha na remocao
	 */
	public boolean remove( int index ) {
		Conta c = contas.remove(index);
		if ( c == null )
			return false;
		else
			return true;
	}
	
	/**
	 * Este metodo retorna a conta dada aquela posição
	 * @param Posição da conta a ser retornada
	 * @return Conta localizada na posicao passada
	 */
	public Conta get( int index ) {
		return contas.get( index );
	}
	
	/**
	 * Este método retorna o numero de contas da lista
	 * @return numero de contas na lista
	 */
	public int size( ) {
		return contas.size();
	}
	
	/**
	 * Retorna o nome do cliente
	 * @return nome do cliente
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Retorna o valor do cpf
	 * @return numero de cpf do cliente
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Define o nome do cliente
	 * @param nome nome do cliente
	 */
	public void setNome(String nome) {
		if(nome != null)
		this.nome = nome;
	}
	
	/**
	 * Atribui o cpf do cliente
	 * @param cpf identificador do cliente
	 */
	public void setCpf(String cpf) {
		cpf=formataCPF(cpf);
	}
	
	/**
	 * Formata o CPF dado a string de entrada
	 * @param cpf CPF em estado "bruto"
	 * @return CPF formatado de acordo com os parametros gerais
	 */
	public static String formataCPF( String cpf ) {
		if(cpf.length() != 11)
			return null;
		cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
		return cpf;
	}
	
	/**
	 * Retorna informacoes essenciais sobre o cliente
	 */
	@Override
	public String toString( ) {
		String info = " \nCliente: " + nome + "\nCPF: " + cpf + "\n\n";
		for( int cont=0; cont<contas.size(); cont++ ) 
			info += contas.get(cont).toString();
		return info;
	}
	
}
