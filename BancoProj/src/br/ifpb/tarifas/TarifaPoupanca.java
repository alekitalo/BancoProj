package br.ifpb.tarifas;

public class TarifaPoupanca extends Tarifa {
	
	/**
	 * Construtor default para a Tarifa Poupanca
	 */
	public TarifaPoupanca( ) {
		setCPMF( 0 );
		setExtrato( 0 );
		setPercentualDeposito( 10 );
	}
	
	/**
	 * Construtor aonde sao recebidos os valores dos impostos
	 * do CPMF e do extrato
	 * @param cpmf Percentual a ser descontado nos saques
	 * @param extrato Valor cobrado por extrato
	 * @param deposito Percentual a ser acrescido nos deposito
	 */
	public TarifaPoupanca( float cpmf, float extrato, float deposito ) {
		setCPMF( cpmf );
		setExtrato( extrato );
		setPercentualDeposito( deposito );
	}
	
	
}
