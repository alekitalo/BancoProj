package br.ifpb.tarifas;

public class TarifaContaCorrente extends Tarifa {
	
	/**
	 * Construtor default para um conta com tarifa do tipo conta corrente
	 */
	public TarifaContaCorrente( ) {
		setCPMF( 1 );
		setExtrato( 2 );
		setPercentualDeposito( 0 );
	}
	
	/**
	 * Construtor aonde sao recebidos os valores dos impostos
	 * do CPMF e do extrato
	 * @param cpmf Percentual a ser descontado nos saques
	 * @param extrato Valor cobrado por extrato
	 * @param deposito Percentual a ser acrescido nos deposito
	 */
	public TarifaContaCorrente( float cpmf, float extrato, float deposito ) {
		setCPMF( cpmf );
		setExtrato( extrato );
		setPercentualDeposito( deposito );
	}
	
}
