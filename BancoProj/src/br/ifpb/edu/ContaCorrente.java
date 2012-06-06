/**
 * 
 */
package br.ifpb.edu;

import br.ifpb.tarifas.Tarifa;

/**
 * Esta eh a classe Conta corrente que representara
 * as informacoes relacionada a um tipo do mundo real
 * chamado conta corrente
 * @author iponts e aleksandro
 */
public class ContaCorrente extends Conta {
	
	/**
	 * Construtor para a classe ContaCorrente
	 * @param tarifa Tarifa referente ao tipo da conta
	 * @param senha Senha da conta
	 */
	public ContaCorrente( Tarifa tarifa, String senha ) {
		
		setTarifa( tarifa );
		setSenha( senha );
		
	}
	
}
