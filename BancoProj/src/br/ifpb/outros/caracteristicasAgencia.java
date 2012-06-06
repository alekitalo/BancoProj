package br.ifpb.outros;

public class caracteristicasAgencia {
	
			private int Id;
			private String nome;
	
			/**
			 * Seta o valor do Identificador da Agencia
			 * @param id Identificador da Agencia
			 */
			public void setId( int id ) {
				if ( id > 999 && id <= 99999 )
				Id = id;
					else
						Id = 9999;
			}
			
			/**
			 * Seta o nome da Agencia
			 * @param n Nome da agencia
			 */
			public void setNome( String n ) {
				if ( n != null )
					nome = n;
			}
	
			
			/**
			 * Retorna o nome da Agencia
			 * @return nome da Agencia
			 */
			public String getNome( ) {
				return nome;
			}
			
			/**
			 * Retorna o identificador da agencia
			 * @return identificador
			 */
			public int getId( ) {
				return Id;
			}
			
			/**
			 * Metodo que sobrescreve o toString default da classe
			 */
			@Override
			public String toString() {
				return "Características da Agencia:\nNúmero:\t" + getId( ) + "\tNome:\t" + getNome( );
			}
			
}
