package com.will.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.will.controller.FuncionarioController;
import com.will.model.Funcionario;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		Timer timer = new Timer();
		final long HORA = (1000 * 60 * 60);
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				buscarFuncionarios();
			}
			
		};
		
		timer.scheduleAtFixedRate(timerTask, 0, HORA);
	}
	
	public static void buscarFuncionarios() {
		ArrayList<String> nomes = new ArrayList<String>();
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

		nomes.add("João");
		nomes.add("Maria");
		nomes.add("Daniel");
		nomes.add("José");
		nomes.add("Leonardo");

		funcionarios = new FuncionarioController().getFuncionariosByNome(nomes);

		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.toString());
			System.out.println("-=-=-=-=-");
			if (funcionario.getCargo().getNome().contains("Gerente")) {
				funcionarios.remove(funcionario);
			}
		}
		System.out.println("-=-=-=-=-");
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.toString());
		}
		System.out.println("End");
	}

}
