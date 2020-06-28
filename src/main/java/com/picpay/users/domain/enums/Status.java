package com.picpay.users.domain.enums;



public enum Status {
	
		
		SOLICITADO(1, "Solicitado"),
		AUTORIZADO(2, "Autorizado"),
		NAO_AUTORIZADO(3, "Não Autorizado");
		
		private Integer cod;
		private String descricao;
		
		private Status(Integer cod, String descricao) {
			this.cod = cod;
			this.descricao = descricao;
		}

		public Integer getCod() {
			return cod;
		}

		public String getDescricao() {
			return descricao;
		}
		
		public static Status toEnum(Integer cod) {
			if(cod == null) {
				return null;
			}
			for (Status x : Status.values()) {
				if (cod.equals(x.getCod())) {
					return x;
				}
			}
			throw new IllegalArgumentException("Id inválido" + cod);
		}
	}

