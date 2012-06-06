package br.ifpb.edu;

import br.ifpb.outros.caracteristicasAgencia;
import br.ifpb.tarifas.Tarifa;

/**
 * Esta classe abstrata permitira o polimorfismo para a criação de novos tipos de conta
 * @author iponts e aleksandro ferreira
 *
 */
public abstract class Conta {
	
	private Tarifa tarifa;
	
	private caracteristicasAgencia agencia;
	
	private int numConta;
	
	private float saldo;
	
	private String senha = new String( );
	
	private String extrato = new String( );
	
	/**
	 * Retorna o saldo do cliente
	 * @return Saldo do cliente
	 */
	public float getSaldo( ) {
		return saldo;
	}
	
	/**
	 * Retorna a senha do cliente
	 * @return Senha do cliente
	 */
	public String getSenha() {
		return senha;
	}
	
	/**
	 * Retorna o extrato do cliente
	 * @return Extrato do cliente
	 */
	public String getExtrato( ) {
		float cobranca = tarifa.getExtrato( );
		if( cobranca <= saldo ) {
			saldo -= cobranca;
			setExtrato( "CobranaÃ§a de: R$" + cobranca + ", pelo extrato."  );
			return extrato;
		}
		return null;
	}
	
	/**
	 * FunÃ§Ã£o chamada para adicionar informaÃ§Ãµes sobre o extrato
	 */
	public void setExtrato( String msg ) {
		extrato += msg + "\n";
	}
	
	/**
	 * Define o saldo do cliente
	 * @param saldo Saldo do cliente
	 */
	public void setSaldo(float saldo) {
		if( saldo>=0 ) {
		setExtrato( "Seu saldo foi definido no valor de: R$ " + saldo );
		this.saldo = saldo;
		}
	}
	
	/**
	 * Este metodo efetua um deposito sobre a conta
	 * @param deposito Valor a ser depositado
	 * @return Verdadeiro para sucesso no deposito / Falso para falha no deposito
	 */
	public boolean setDeposito( float deposito ) {
		if( deposito>0 ) {
			saldo+=deposito+tarifa.valorAcrescimoDeposito( saldo );
			setExtrato( "Valor depositado: R$ " + deposito + "\nNovo saldo: R$" + saldo );
			return true;
		}
		return false;
	}
	
	/**
	 * Este metodo efetua um saque sobre a conta
	 * @param saque Valor a ser sacado
	 * @return Verdadeiro para sucesso no saque / Falso para falha no saque
	 */
	public boolean setSaque( float saque ) {
		if( saque < 0 ) saque=saque*(-1);
		float acrescimo = tarifa.valorCobradoSaque( saque ) + saque;
		if( acrescimo < saldo ) {
			saldo -= acrescimo;
			setExtrato( "Valor retirado: R$ " + acrescimo + "\nNovo saldo: R$" + saldo );
			return true;
		} else
			return false;
	}
	
	/**
	 * Define a senha do cliente
	 * @param senha Senha do cliente
	 */
	public void setSenha(String senha) {
		if( senha.length() == 6 ) {
			setExtrato( "A sua senha foi atualizada." );
			this.senha = senha;
		}
	}
	
	/**
	 * Retorna o tipo da tarifa anexada a conta
	 * @return Tipo da tarifa
	 */
	public Tarifa getTarifa() {
		return tarifa;
	}

	/**
	 * Retorna o tipo da agência anexada a conta
	 * @return Tipo da agencia
	 */
	public caracteristicasAgencia getAgência() {
		return agencia;
	}

	/**
	 * Retorna o numero da conta anexada a conta
	 * @return Numero da conta
	 */
	public int getNumConta() {
		return numConta;
	}

	/**
	 * Atribui uma tarifa a conta
	 * @param Tarifa a ser atribuida
	 */
	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	/**
	 * Atribui uma agencia a conta
	 * @param Agencia a ser atribuida
	 */
	public void setAgência( caracteristicasAgencia agência) {
		agencia = agência;
	}

	/**
	 * Atribui o numero da conta
	 * @param Numero da conta a ser definida
	 */
	public boolean setNumConta(int numConta) {
		if( ( numConta > 9999 ) && ( numConta <= 99999 ) ) {
			this.numConta = numConta;
			return true;
		} else return false;
	}


	/**
	 * Este metodo sobrescreve a funÃ§Ã£o toString com informaÃ§Ãµes sobre a conta
	 * @return Mensagem de retorno
	 */
	@Override
	public String toString( ) {
		return "NÃºmero da conta: " + numConta + "\n" + agencia.toString() + "\n" + tarifa.toString() + "\n"; 
	}
	
}
