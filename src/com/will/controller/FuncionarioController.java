package com.will.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.will.data.DBConnection;
import com.will.model.Cargo;
import com.will.model.Departamento;
import com.will.model.Funcionario;

public class FuncionarioController {

	private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

	public ArrayList<Funcionario> getFuncionariosByNome(ArrayList<String> nomes) {
		Funcionario funcionario = null;
		Departamento departamento = null;
		Cargo cargo = null;
		DBConnection dBConnection = null;
		try {
			dBConnection = new DBConnection();
			Statement statement = dBConnection.getConnection().createStatement();
			for (String nome : nomes) {
				funcionario = new Funcionario();
				departamento = new Departamento();
				cargo = new Cargo();
				ResultSet resultSet = statement.executeQuery("select f.*, d.*,c.* " + "from empresax.funcionario as f "
						+ "join empresax.departamento as d " + "on f.coddep = d.coddep " + "join empresax.cargo as c "
						+ "on f.codcargo = c.codcargo " + "where f.nome ='" + nome + "'");
				while (resultSet.next()) {

					funcionario.setId(resultSet.getLong(1));
					funcionario.setNome((resultSet.getString(2)));
					funcionario.setDependentes(resultSet.getInt(3));
					funcionario.setSalario(resultSet.getString(4));

					departamento.setId(resultSet.getLong(5));
					departamento.setNome(resultSet.getString(6));
					funcionario.setDepartamento(departamento);

					cargo.setId(resultSet.getLong(7));
					cargo.setNome(resultSet.getString(8));
					funcionario.setCargo(cargo);

					funcionarios.add(funcionario);
				}
				resultSet.close();
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dBConnection.closeConnection();
		}
		return funcionarios;
	}
}
