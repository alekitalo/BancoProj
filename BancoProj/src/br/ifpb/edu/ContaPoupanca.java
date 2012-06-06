/**
 * Este pacote conterá todas as classes referentes ao primeiro milestone
 */
package br.ifpb.edu;

import br.ifpb.tarifas.Tarifa;

/**
 * @author iponts
 * Esta conta não cobra taxa alguma sobre suas operações
 */
public class ContaPoupanca extends Conta {
	
	/**
	 * Construtor para a classe ContaPoupanca
	 * @param tarifa Tarifa referente ao tipo da conta
	 * @param senha Senha da conta
	 */
	public ContaPoupanca( Tarifa tarifa, String senha ) {
		setTarifa( tarifa );
		setSenha( senha );
	}
	
}
