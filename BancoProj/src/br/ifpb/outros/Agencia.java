/**
 * Este pacote conterá todas as classes referentes ao primeiro milestone
 */
package br.ifpb.outros;

import java.util.ArrayList;



/**
 * @author iponts
 */
public class Agencia {
	
	private ArrayList<Cliente> cliente = new ArrayList<Cliente>();
	
	private caracteristicasAgencia agencia = new caracteristicasAgencia( );
	
	public Agencia( ) {
		
	}
	
	/**
	 * Este e o contrutor aonde sera passado o nome da agencia
	 * e o respectivo identificador dela
	 */
	public Agencia( String n, int id ) {
		setId( id );
		setNome( n );
	}
	
	/**
	 * Cadastra um cliente na agencia
	 * @param c Cliente da agencia
	 */
	public void add( Cliente e ) {
		if ( e != null )
		cliente.add( e );
	}
	
	/**
	 * Remove um cliente da agencia dado sua posicao na lista
	 * @param index Posicao na lista
	 * @return Verdadeiro para sucesso na remocao / Falso para falha na remocao
	 */
	public boolean remove( int index ) {
		if ( cliente.remove(index) == null )
			return false;
		else return true;
	}
	
	/**
	 * Este metodo retorna o cliente dado uma posição
	 * @param Posição do cliente a ser retornada
	 * @return Cliente localizado na posição index
	 */
	public Cliente get( int index ) {
		return cliente.get( index );
	}
	
	/**
	 * Este método retorna o numero de clientes na lista
	 * @return numero de clientes na lista
	 */
	public int size( ) {
		return cliente.size( );
	}
	
	/**
	 * Seta o valor do Identificador da Agencia
	 * @param id Identificador da Agencia
	 */
	public void setId( int id ) {
		agencia.setId( id );
	}
	
	/**
	 * Seta o nome da Agencia
	 * @param n Nome da agencia
	 */
	public void setNome( String n ) {
		agencia.setNome( n );
	}
	
	/**
	 * Retorna o nome da Agencia
	 * @return nome da Agencia
	 */
	public String getNome( ) {
		return agencia.getNome( );
	}
	
	/**
	 * Retorna o identificador da agencia
	 * @return identificador
	 */
	public int getId( ) {
		return agencia.getId();
	}
	
	/**
	 * Retorna o toString da agencia 
	 * @return Mensagem de retorno
	 */
	@Override
	public String toString( ) {
		return "Nome da Agência: " + agencia.getNome() + "\tCódigo: " + agencia.getId( );
	}
	
}
