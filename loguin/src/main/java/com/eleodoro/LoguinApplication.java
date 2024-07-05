package com.eleodoro;

import com.eleodoro.conexao.Conexao;
import com.eleodoro.dao.LoguinDao;
import com.eleodoro.dao.LoguinPojo;
import com.eleodoro.loguin.Loguin;

public class LoguinApplication {

	public static void main(String[] args) {

		Conexao conexao  = new Conexao();
		conexao.getConexao();

		//teste inserir

		Loguin LoguinInserir = new Loguin();
		LoguinInserir.setNome("Vitoria");
		LoguinInserir.setSenha("biscoito");

		LoguinPojo LoguinPojoInserir = new LoguinPojo();
		LoguinPojoInserir.setNome(LoguinInserir.getNome());
		LoguinPojoInserir.setSenha(LoguinInserir.getSenha());

		LoguinDao LoguinDaoInserir = new LoguinDao();
		LoguinDaoInserir.cadastrarLoguin(LoguinPojoInserir);

		//teste consulta

		Loguin LoguinConsultar = new Loguin();
		LoguinConsultar.setId(1);

		LoguinPojo LoguinPojoConsultar = new LoguinPojo();
		LoguinPojoConsultar.setId(LoguinConsultar.getId());

		LoguinDao LoguinDaoConsultar = new LoguinDao();
		LoguinDaoConsultar.consultarLoguin(LoguinPojoConsultar);

		System.out.println(LoguinPojoConsultar.toString());

		//testar atualização 
		Loguin LoguinAtualizar = new Loguin();
		LoguinAtualizar.setId(1);
		LoguinAtualizar.setNome("Vitoria Alves");
		LoguinAtualizar.setSenha("bolacha");

		LoguinPojo LoguinPojoAtualizar = new LoguinPojo();
		LoguinPojoAtualizar.setId(1);
		LoguinPojoAtualizar.setNome(LoguinAtualizar.getNome());
		LoguinPojoAtualizar.setSenha(LoguinAtualizar.getSenha());

		LoguinDao LoguinDaoAtualizar = new LoguinDao();
		LoguinDaoAtualizar.atualizarLoguin(LoguinPojoAtualizar);

		// testar exclusão

		Loguin LoguinDeletar = new Loguin();
		LoguinDeletar.setId(1);

		LoguinPojo LoguinPojoDeletar = new LoguinPojo();
		LoguinPojoDeletar.setId(1);

		LoguinDao LoguinDaoDeletar = new LoguinDao();
		LoguinDaoDeletar.excluirLoguin(LoguinPojoDeletar);
		

	}

}
