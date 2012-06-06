/**
 * 
 */
package br.ifpb.outros;

import java.util.ArrayList;

import br.ifpb.edu.Conta;

/**
 * @author iponts
 *
 */
public class Banco {
	
	private static ArrayList<Agencia> listaAgencia = new ArrayList<Agencia>();
	
	/**
	 * Este metodo varre todas as agencias cadastradas, se nao
	 * encontrar nenhuma agencia com o mesmo nome, ou identificador,
	 * ele cadastra uma nova agencia no sistema
	 * @param a Objeto agencia a ser cadastrada
	 * @return Verdadeiro para sucesso no cadastramento / Falso para erro no cadastro
	 */
	public static boolean cadastraAgencia( Agencia a ) {
		Agencia aux = new Agencia( );
		for( int cont = 0; cont < listaAgencia.size(); cont++ ) {
			aux = listaAgencia.get(cont);
			if( ( aux.getId() == a.getId() ) || ( aux.getNome().equals( a.getNome() ) ) )
				return false;
		}
		listaAgencia.add( a );
		return true;
	}
	
	/**
	 * Dado o nome da agencia, este metodo cadastra um cliente nela
	 * @param Agencia Nome da agencia a qual o cliente devera pertencer
	 * @param c Objeto cliente que devera ser cadastrado
	 * @return Verdadeiro para sucesso no cadastro / Falso para erro no cadastro
	 */
	public static boolean cadastraCliente( String agencia, Cliente c ){
		Agencia aux = new Agencia( );
		for( int cont = 0; cont < listaAgencia.size(); cont++ ) {
			aux = listaAgencia.get( cont );
			if( aux.getNome().equals( agencia ) ) {
				for( int cont2=0; cont2<aux.size(); cont2++ ) {
					if( aux.get( cont2 ).equals( c.getCpf( ) ) )
					return false;
				}
				aux.add( c );
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Dado o cÃ³digo da agencia, este metodo cadastra um cliente nela
	 * @param agencia Codigo da agencia o qual o cliente devera ser cadastrado
	 * @param c Objeto cliente a ser cadastrado na agencia
	 * @return Verdadeiro para cadastro realizado com sucesso / Falso para erro no cadastro
	 */
	public static boolean cadastraCliente( int agencia, Cliente c ){
		Agencia aux = new Agencia( );
		for( int cont = 0; cont < listaAgencia.size(); cont++ ) {
			aux = listaAgencia.get( cont );
			if( aux.getId( ) == agencia ) {
				for( int cont2=0; cont2<aux.size(); cont2++ ) {
					if( aux.get( cont2 ).equals( c.getCpf( ) ) )
					return false;
				}
				aux.add( c );
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que pesquisa clientes dentro de uma agencia
	 * @param agencia Codigo da agencia a ser pesquisada
	 * @param cliente Nome do cliente a ser pesquisado
	 * @return Mensagem de retorno
	 */
	public static String pesquisaClienteNaAgencia( int agencia, String cliente ) {
		Agencia aux = new Agencia( );
		Cliente c = new Cliente( );
		String informações = new String( );
		for( int cont = 0; cont<listaAgencia.size(); cont++ ){
			aux = listaAgencia.get( cont ); 
			if ( aux.getId() == agencia ) {
				for( int cont2 = 0; cont2 < aux.size(); cont2++ ) {
					c = aux.get( cont2 );
					if( c.getNome( ).equals( cliente ) ) {
						informações += c.toString() + "\n";
					}
				}
				return "As informações encontradas para pessoas com este nome foi:\n" + informações;
			}
		}
		return "NÃ£o foi possÃ­vel localizar alguma agência com este nome";
	}
	
	/**
	 * Metodo que pesquisa clientes dentro de uma agencia
	 * @param agencia Nome da agencia a ser pesquisada
	 * @param cliente CPF do cliente a ser pesquisado
	 * @return Mensagem de retorno
	 */
	public static String pesquisaClienteNaAgenciaCPF( String agencia, String cliente ) {
		Agencia aux = new Agencia( );
		Cliente c = new Cliente( );
		cliente = Cliente.formataCPF( cliente );
		if( cliente == null ) 
		return "CPF em formato invÃ¡lido!";
		for( int cont=0; cont<listaAgencia.size();cont++) {
			aux = listaAgencia.get( cont ); 
			if ( aux.getNome( ).equals( agencia ) ) {
				for( int cont2 = 0; cont2 < aux.size(); cont2++ ) {
					c = aux.get( cont2 );
					if( c.getCpf( ).equals( cliente ) ) {
						return c.toString( );
					}
				}
			return "NÃ£o foi possÃ­vel localizar alguÃ©m com este nome";
			}			
		}
		return "NÃ£o foi possÃ­vel localizar alguma agência com este nome";
	}
	
	/**
	 * Metodo que pesquisa clientes dentro de uma agencia
	 * @param agencia Codigo da agencia a ser pesquisada
	 * @param cliente CPF do cliente a ser pesquisado
	 * @return Mensagem de retorno
	 */
	public static String pesquisaClienteNaAgenciaCPF( int agencia, String cliente ) {
		Agencia aux = new Agencia( );
		Cliente c = new Cliente( );
		cliente = Cliente.formataCPF( cliente );
		if( cliente == null ) 
		return "CPF em formato invÃ¡lido!";
		for( int cont=0; cont<listaAgencia.size();cont++) {
			aux = listaAgencia.get( cont ); 
			if ( aux.getId() == agencia ) {
				for( int cont2=0; cont2 < aux.size(); cont2++ ) {
					c = aux.get( cont2 );
					if( c.getCpf( ).equals( cliente ) ) {
						return c.toString( );
					}
				}
			return "NÃ£o foi possÃ­vel localizar alguÃ©m com este nome";
			}			
		}
		return "NÃ£o foi possÃ­vel localizar alguma agência com este nome";
	}
	
	/**
	 * Metodo que remove o cliente da agencia, dado seu cpf e o nome da agencia
	 * @param agencia Nome da agencia a qual o cliente pertence
	 * @param cpf CPF do cliente que sera removido
	 * @return verdadeiro para remocao com sucesso / falso para falha na remocao
	 */
	public static boolean removeCliente( String agencia, String cpf ) {
		cpf = Cliente.formataCPF( cpf );
		if( cpf == null ) return false;
		Agencia aux = new Agencia( );
		for( int cont = 0; cont<listaAgencia.size(); cont++ ) {
			aux = listaAgencia.get( cont );
			if( aux.getNome().equals( agencia ) ) {
				for( int cont2 = 0; cont2 < aux.size(); cont2++ ) {
					if( aux.get( cont2 ).getCpf().equals(cpf) ) {
					aux.remove( cont2 );
					return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Metodo que remove o cliente da agencia, dado seu cpf e o codigo da agencia
	 * @param agencia Nome da agencia a qual o cliente pertence
	 * @param cpf CPF do cliente que sera removido
	 * @return Verdadeiro para remocao com sucesso / Falso para falha na remocao
	 */
	public static boolean removeCliente( int agencia, String cpf ) {
		cpf = Cliente.formataCPF( cpf );
		if( cpf == null ) return false;
		Agencia aux = new Agencia( );
		for( int cont = 0; cont<listaAgencia.size(); cont++ ) {
			aux = listaAgencia.get( cont );
			if( aux.getId( ) == agencia ) {
				for( int cont2 = 0; cont2 < aux.size(); cont2++ ) {
					if( aux.get( cont2 ).getCpf().equals(cpf) ) {
					aux.remove( cont2 );
					return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Metodo para cadastrar uma conta nova
	 * @param cpf CPF do cliente que tera uma nova conta
	 * @param agencia Agencia a qual a conta do cliente devera pertencer
	 * @param numConta Numero da conta do cliente
	 * @param tipo Tipo de conta que o cliente devera ter
	 * @return Verdadeiro para remocao com sucesso / Falso para falha na remocao
	 */
	public static boolean cadastraConta( String cpf, String nomeAgencia, int numConta, Conta conta ) {
		cpf = Cliente.formataCPF( cpf );
		if( cpf == null ) return false;
		if( conta == null ) return false;
		if( conta.setNumConta( numConta ) == false ) return false;
		caracteristicasAgencia ca = new caracteristicasAgencia( );
		Agencia agencia;
		Cliente cliente;
		for( int cont=0; cont<listaAgencia.size(); cont++ ) {
			agencia = listaAgencia.get( cont );
			if( agencia.getNome().equals( nomeAgencia ) ) {
				for( int cont2=0; cont2<agencia.size(); cont2++ ) {
					cliente = agencia.get( cont2 );
					if( cliente.getCpf().equals( cpf ) ) {
						for( int cont3=0; cont3<cliente.size(); cont3++ ) {
							if( cliente.get( cont3 ).getNumConta() == numConta )
								return false;
						}
						ca.setId( agencia.getId() );
						ca.setNome( agencia.getNome() );
						conta.setAgência( ca );
						conta.setNumConta(numConta);
						cliente.add( conta );
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Metodo para cadastrar uma conta nova
	 * @param cpf CPF do cliente que tera uma nova conta
	 * @param agencia Agencia a qual a conta do cliente devera pertencer
	 * @param numConta Numero da conta do cliente
	 * @param tipo Tipo de conta que o cliente devera ter
	 * @return Verdadeiro para remocao com sucesso / Falso para falha na remocao
	 */
	public static boolean cadastraConta( String cpf, int nomeAgencia, int numConta, Conta conta ) {
		cpf = Cliente.formataCPF( cpf );
		if( cpf == null ) return false;
		if( conta == null ) return false;
		if( ( conta.setNumConta( numConta ) == false ) ) return false;
		caracteristicasAgencia ca = new caracteristicasAgencia( );
		Agencia agencia;
		Cliente cliente;
		for( int cont=0; cont<listaAgencia.size(); cont++ ) {
			agencia = listaAgencia.get( cont );
			if( agencia.getId() == nomeAgencia ) {
				for( int cont2=0; cont2<agencia.size(); cont2++ ) {
					cliente = agencia.get( cont2 );
					if( cliente.getCpf().equals( cpf ) ) {
						for( int cont3=0; cont3<cliente.size(); cont3++ ) {
							if( cliente.get( cont3 ).getNumConta() == numConta )
								return false;
						}
						ca.setId( agencia.getId() );
						ca.setNome( agencia.getNome() );
						conta.setAgência( ca );
						conta.setNumConta(numConta);
						cliente.add( conta );
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Exclui uma conta da agencia dado o codigo da Agencia
	 * @param cpf Numero do cpf do cliente
	 * @param agencia Agencia que a conta pertence
	 * @param numConta Numero da conta a ser excluida
	 * @return Verdadeiro para remocao com sucesso / Falso para falha na remocao
	 */
	public static boolean excluiConta( String cpf, int numAgencia, int numConta, String senha ) {
		cpf = Cliente.formataCPF( cpf );
		if( cpf == null ) return false;
		Agencia agencia;
		Cliente cliente;
		for( int cont = 0; cont<listaAgencia.size(); cont++ ) {
			agencia = listaAgencia.get( cont );
			if( agencia.getId() == numAgencia ) {
				for( int cont2 = 0; cont2<agencia.size(); cont2++){
					cliente = agencia.get(cont2);
					if( cliente.getCpf().equals( cpf ) ) {
						for( int cont3=0; cont3<cliente.size();cont3++) {
							if( cliente.get(cont3).getNumConta() == numConta ) {
								if( cliente.get( cont3 ).getSenha().equals( senha ) )
								return cliente.remove(cont3);
							}
						}
						
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Exclui uma conta da agencia dado o nome da Agencia
	 * @param cpf Numero do cpf do cliente
	 * @param agencia Agencia que a conta pertence
	 * @param numConta Numero da conta a ser excluida
	 * @return Verdadeiro para remocao com sucesso / Falso para falha na remocao
	 */
	public static boolean excluiConta( String cpf, String nomeAgencia, int numConta, String senha ) {
		cpf = Cliente.formataCPF( cpf );
		if( cpf == null ) return false;
		Agencia agencia;
		Cliente cliente;
		for( int cont = 0; cont<listaAgencia.size(); cont++ ) {
			agencia = listaAgencia.get( cont );
			if( agencia.getNome().equals( nomeAgencia ) ) {
				for( int cont2 = 0; cont2<agencia.size(); cont2++){
					cliente = agencia.get(cont2);
					if( cliente.getCpf().equals( cpf ) ) {
						for( int cont3=0; cont3<cliente.size();cont3++) {
							if( cliente.get(cont3).getNumConta() == numConta ) {
								if( cliente.get( cont3 ).getSenha().equals( senha ) )
								return cliente.remove(cont3);
							}
						}
						
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Pesquisa uma conta na agencia, dado seu nome
	 * @param nomeAgencia Nome da agencia a ser pesquisada
	 * @param numConta Numero da conta a ser pesquisado
	 * @return Mensagem contendo o que foi encontrado
	 */
	public static String pesquisaContaAgencia( String nomeAgencia, int numConta) {
		Agencia agencia = new Agencia( );
		Cliente cliente = new Cliente( );
		for( int cont=0; cont<listaAgencia.size(); cont++ ) {
			agencia = listaAgencia.get( cont );
			if( agencia.getNome().equals( nomeAgencia ) ) {
				for( int cont2=0; cont2< agencia.size(); cont2++ ){ 
					cliente = agencia.get( cont2 );
					for( int cont3=0; cont<cliente.size(); cont3++ ) {
						if( cliente.get(cont3).getNumConta() == numConta ) {
							return cliente.toString();
						}
					}
				}
			}
		}
		return "Nenhuma referência encontrada!";
	}
	
	/**
	 * Pesquisa uma conta na agencia, dado seu codigo
	 * @param numAgencia
	 * @param numConta
	 * @return
	 */
	public static String pesquisaContaAgencia( int numAgencia, int numConta) {
		Agencia agencia = new Agencia( );
		Cliente cliente = new Cliente( );
		for( int cont=0; cont<listaAgencia.size(); cont++ ) {
			agencia = listaAgencia.get( cont );
			if( agencia.getId() == numAgencia ) {
				for( int cont2=0; cont2< agencia.size(); cont2++ ){ 
					cliente = agencia.get( cont2 );
					for( int cont3=0; cont<cliente.size(); cont3++ ) {
						if( cliente.get(cont3).getNumConta() == numConta ) {
							return cliente.toString();
						}
					}
				}
			}
		}
		return "Nenhuma referência encontrada!";
	}
	
	/**
	 * Este metodo retorna o saldo do cliente
	 * @param numAgencia Codigo da agencia o qual o cliente pertence
	 * @param numConta Numero da conta do cliente
	 * @param senha Senha da conta
	 * @return Valor do saldo se existir
	 */
	public static String getSaldo( int numAgencia, int numConta, String senha  ) {
		Agencia aux;
		Cliente c;
		Conta conta;
		for( int cont=0; cont<listaAgencia.size(); cont++ ) {
			aux = listaAgencia.get( cont );
			if( aux.getId() == numAgencia ) {
				for( int cont2=0; cont2<aux.size(); cont2++ ) {
					c = aux.get( cont2 );
					for( int cont3=0; cont3<c.size();cont3++ ) {
						conta = c.get(cont3);
						if ( conta.getNumConta() == numConta ) {
							return "Saldo de: R$" + conta.getSaldo();
						}
					}
				}
			}
		}
		return "NÃ£o foi possÃ­vel localizar o saldo!";
	}
	
	/**
	 * Este metodo retorna o saldo do cliente
	 * @param numAgencia Codigo da agencia o qual o cliente pertence
	 * @param cpf CPF do cliente que tera o saldo acessado
	 * @param senha Senha da conta
	 * @return Valor do saldo se existir
	 */
	public static String getSaldo( int numAgencia, String cpf, String senha  ) {
		cpf = Cliente.formataCPF( cpf );
		if( cpf == null ) return "CPF invÃ¡lido!";
		Agencia aux;
		Cliente c;
		Conta conta;
		for( int cont=0; cont<listaAgencia.size(); cont++ ) {
			aux = listaAgencia.get( cont );
			if( aux.getId() == numAgencia ) {
				for( int cont2=0; cont2<aux.size(); cont2++ ) {
					c = aux.get( cont2 );
					if( c.getCpf().equals( cpf ) ) {
						for( int cont3=0; cont3<c.size();cont3++ ) {
							conta = c.get( cont3 );
							if( conta.getSenha().equals( senha ) )
								return "Saldo de: R$" + conta.getSaldo( );
						}
					}
				}
			}
		}
		return "NÃ£o foi possÃ­vel localizar o saldo!";
	}
	
	/**
	 * Este metodo retorna o extrato do cliente
	 * @param numAgencia Codigo da agencia o qual o cliente pertence
	 * @param cpf CPF do cliente que tera o extrato acessado
	 * @param senha Senha da conta
	 * @return Valor do saldo se existir
	 */
	public static String getExtrato( int numAgencia, String cpf, String senha  ) {
		cpf = Cliente.formataCPF( cpf );
		if( cpf == null ) return "CPF invÃ¡lido!";
		Agencia aux;
		Cliente c;
		Conta conta;
		for( int cont=0; cont<listaAgencia.size(); cont++ ) {
			aux = listaAgencia.get( cont );
			if( aux.getId() == numAgencia ) {
				for( int cont2=0; cont2<aux.size(); cont2++ ) {
					c = aux.get( cont2 );
					if( c.getCpf().equals( cpf ) ) {
						for( int cont3=0; cont3<c.size();cont3++ ) {
							conta = c.get( cont3 );
							if( conta.getSenha().equals( senha ) )
								return conta.getExtrato();
						}
					}
				}
			}
		}
		return "NÃ£o foi possÃ­vel localizar o saldo!";
	}
	
	/**
	 * Este metodo retorna o extrato do cliente
	 * @param numAgencia Codigo da agencia o qual o cliente pertence
	 * @param numConta Numero da conta do cliente
	 * @param senha Senha da conta
	 * @return Valor do saldo se existir
	 */
	public static String getExtrato( int numAgencia, int numConta, String senha  ) {
		Agencia aux;
		Cliente c;
		Conta conta;
		for( int cont=0; cont<listaAgencia.size(); cont++ ) {
			aux = listaAgencia.get( cont );
			if( aux.getId() == numAgencia ) {
				for( int cont2=0; cont2<aux.size(); cont2++ ) {
					c = aux.get( cont2 );
					for( int cont3=0; cont3<c.size();cont3++ ) {
						conta = c.get(cont3);
						if ( conta.getNumConta() == numConta ) {
							return conta.getExtrato();
						}
					}
				}
			}
		}
		return "NÃ£o foi possÃ­vel localizar o saldo!";
	}
	
	/**
	 * Este metodo retorna faz o deposito em uma conta
	 * @param numAgencia Codigo da agencia o qual o cliente pertence
	 * @param numConta Numero da conta do cliente
	 * @param valor Valor a ser depositado
	 * @return Valor do saldo se existir
	 */
	public static boolean setDeposito( int numAgencia, int numConta, float valor ) {
		Agencia aux;
		Cliente c;
		Conta conta;
		for( int cont=0; cont<listaAgencia.size(); cont++ ) {
			aux = listaAgencia.get( cont );
			if( aux.getId() == numAgencia ) {
				for( int cont2=0; cont2<aux.size(); cont2++ ) {
					c = aux.get( cont2 );
					for( int cont3=0; cont3<c.size();cont3++ ) {
						conta = c.get(cont3);
						if ( conta.getNumConta() == numConta ) {
							return conta.setDeposito( valor );
						}
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Este metodo faz um saque na conta do cliente
	 * @param numAgencia Codigo da agencia o qual o cliente pertence
	 * @param numConta Numero da conta do cliente
	 * @param senha Senha da conta
	 * @param valor Valor a ser sacado
	 * @return Verdadeiro para saque realizado com sucesso / Falso para erro no saque
	 */
	public static boolean setSaque( int numAgencia, int numConta, String senha, float valor ) {
		Agencia aux;
		Cliente c;
		Conta conta;
		for( int cont=0; cont<listaAgencia.size(); cont++ ) {
			aux = listaAgencia.get( cont );
			if( aux.getId() == numAgencia ) {
				for( int cont2=0; cont2<aux.size(); cont2++ ) {
					c = aux.get( cont2 );
					for( int cont3=0; cont3<c.size();cont3++ ) {
						conta = c.get(cont3);
						if ( conta.getNumConta() == numConta ) {
							return conta.setSaque( valor );
						}
					}
				}
			}
		}
		return false;
	}	
	
	/**
	 * Este metodo altera a senha de uma conta do cliente
	 * @param numConta Numero da conta do cliente
	 * @param numAgencia Agencia a qual a conta pertence
	 * @param senhaAntiga Senha a ser substituida
	 * @param senhaNova Senha que ira ficar ativa
	 * @return Verdadeiro em caso de sucesso / Falso em caso de erro
	 */
	public static boolean alteraSenha( int numConta, int numAgencia, String senhaAntiga, String senhaNova ) {
		Agencia agencia;
		Conta c;
		Cliente cliente;
		for(int cont=0; cont<listaAgencia.size(); cont++ ) {
			agencia = listaAgencia.get(cont);
			if( agencia.getId() == numAgencia ) {
				for( int cont2=0; cont2<agencia.size();cont2++ ) {
					cliente = agencia.get( cont2 );
					for( int cont3=0; cont3<cliente.size();cont3++ ){
						c = cliente.get( cont3 );
						if( c.getNumConta() == numConta ) {
							if( c.getSenha().equals( senhaAntiga ) ) {
								c.setSenha( senhaNova );
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Este metodo retorna uma lista de todas as agencias do banco
	 * @return ArrayList contendo todas as agencias
	 */
	public static ArrayList<Agencia> getAgencia( ) {
		return listaAgencia;
	}
	
	/**
	 * Este metodo define a lista de agencias do Banco
	 * @param a ArrayList contento a lista de Agencias
	 */
	public static void setAgencia( ArrayList<Agencia> a ) {
		listaAgencia = a;
	}
}
