package com.distribuidora.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)//herança - tabela única o hibernate trabalha cria/pesquisa
///evitar usar herança- pq o BD não trabalha com herança e dificulta
@DiscriminatorColumn(name="TIPO_PESSOA", discriminatorType=DiscriminatorType.STRING)//diz qual coluna descrimina as filhas
public class Pessoa {
	
	private Long codigo;
	private String nome;
	private Date dataNascimento;
	private String cpf;
	private Sexo sexo;
	private Funcao funcao;
	private String endereco;
	private String telefone;
	private Date dataCriacao;
	private Date dataModificacao;
	
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento")//no banco de dados separa por _ e não pelo Case como no java
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public Funcao getFuncao() {
		return funcao;
	}
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	
	@Temporal(TemporalType.TIMESTAMP)///mapeando data e hora
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataModificacao() {
		return dataModificacao;
	}
	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
	@PrePersist/// o metodo vai ser executado antes de ser persistido
	@PreUpdate///executa o metodo antes de ser atualizado
	public void configuraDatasCriacaoAlteracao() {
		this.dataModificacao = new Date();
		
		if(this.dataCriacao ==null){
			this.dataCriacao = new Date();
		}
	}
	

}
