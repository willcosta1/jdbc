package com.will.model;

public class Funcionario {
	private long id;
	private String nome;
	private int dependentes;
	private String salario;
	private Departamento departamento;
	private Cargo cargo;

	public Funcionario() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDependentes() {
		return dependentes;
	}

	public void setDependentes(int dependentes) {
		this.dependentes = dependentes;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return String.format("Id: %s \nNome: %s \nDependentes: %s \nSalario: %s \nDepartamento: %s \nCargo: %s", this.id,
				this.nome, this.dependentes, this.salario, this.departamento.getNome(), this.getCargo().getNome());
	}
}
