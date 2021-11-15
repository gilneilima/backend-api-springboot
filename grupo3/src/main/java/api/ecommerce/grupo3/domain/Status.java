package api.ecommerce.grupo3.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import api.ecommerce.grupo3.exception.EnumValidationException;

public enum Status {

	FINALIZADO(1, "FINALIZADO"),  NAOFINALIZADO(2, "NÃO FINALIZADO");

	private Integer codigo;
	private String tipo;
	
	private Status(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}

	@JsonCreator
	public static Status verifica(Integer value) throws EnumValidationException {
		for (Status c : values()) {
			if (value.equals(c.getCodigo())) {
				return c;
			}
		}
		throw new EnumValidationException("Status preenchido incorretamente");
	}	
	
}
