package br.com.tuliorocha.desafiomv.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity(name = "cafedamanha")
@Data
public class CafeDaManha implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "opcao_id")
	private Opcao opcao;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "colaborador_id")
	private Colaborador colaborador;


}
