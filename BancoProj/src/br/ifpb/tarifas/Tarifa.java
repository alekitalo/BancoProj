/**
 * Este pacote conterá todas as classes referentes ao primeiro milestone
 */
package br.ifpb.tarifas;

/**
 * Esta interface permitirá a criação de novos tipos de tarifas
 * @author iponts
 *
 */
public abstract class Tarifa {
	
	/**
	 * Percentual do imposto cobrado no saque
	 */
	private float CPMF;
	/**
	 * Percentual do rendimento do valor depositado
	 */
	private float percentualDeposito;
	/**
	 * Valor cobrado pelo extrato
	 */
	private float valorExtrato;
	
	/**
	 * Retorna o valor da tarifa
	 * @return Valor da tarifa
	 */
	public float getExtrato( ) {
		return valorExtrato;
	}
	
	/**
	 * Retorna o percentual do valor do CPMF
	 * @return Valor do CPMF
	 */
	public float getCPMF( ) {
		return CPMF;
	}
	
	/**
	 * Retorna o percentual que sera acrescido no deposito 
	 * @return Percentual a ser acrescido
	 */
	public float getPercentualDeposito( ) {
		return percentualDeposito;
	}
	
	/**
	 * Define o percentual que sera acrescido aos depositos
	 * @param a Percentual do acrescimo a ser depositado
	 */
	public void setPercentualDeposito( float a ){
		if( a>0 ) percentualDeposito = a;
	}
	
	
	/**
	 * Define o preco do CPMF
	 * @param valor Percentual do valor do CPMF
	 */
	public void setCPMF( float valor ) {
		if( valor >= 0 )
		CPMF = valor;
	}
	
	/**
	 * Atribui um valor a tarifa
	 * @param valor Valor da tarifa
	 */
	public void setExtrato( float valor ) { 
		if( valor>= 0)
			valorExtrato = valor;
	}
	
	/**
	 * Calcula o valor da tarifa a ser cobrada pelo saque
	 * @param Valor do saque
	 * @return Valor a ser cobrado
	 */
	public float valorCobradoSaque( float a ) {
		if( a<0 ) a=a*(-1);
		return (a/100)*getCPMF( );
	}
	
	/**
	 * Calcula o valor da tarifa a ser adicionada pelo deposito
	 * @param Valor do deposito
	 * @return acrescimo ao valor do deposito
	 */
	public float valorAcrescimoDeposito( float a ) {
		if( a<0 ) a=a*(-1);
		return (a/100)*getPercentualDeposito();
	}
	
	/**
	 * Este metodo sobrescreve a função toString com informações sobre a tarifa
	 * @return Mensagem de retorno
	 */
	@Override
	public String toString( ) {
		return "Cobrança CPMF: " + CPMF + " %.\nPercentual acrescido sobre depósito: " + percentualDeposito + "%.\nValor cobrado por extrato: R$" + valorExtrato + ".\n"; 
	}
	
}

