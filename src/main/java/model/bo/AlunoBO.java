package model.bo;

import model.dao.AlunoDAO;
import model.vo.AlunoVO;

public class AlunoBO {

	
	AlunoDAO DAO= new AlunoDAO();
	public String salvar(AlunoVO alunoVO) {
	
		String mensagem = "";

	if (DAO.verificarCpf(alunoVO.getCpf())) {
			mensagem = "CPF informado (" + alunoVO.getCpf() + ") j� foi utilizado";
		} else {
			alunoVO = DAO.cadastrarAluno(alunoVO);
			mensagem = "Cadastro realizado com sucesso!";

		}
	return mensagem;
	}
	
	
	public void deletar(AlunoVO a) {
		AlunoDAO alunoDAO = new AlunoDAO();
		if(alunoDAO.existeRegistroPorIdAlunoDAO(a.getDtMatricula())){
			boolean resultado = alunoDAO.excluir(a);
			if (resultado == true){
				System.out.println("\nUsuario deletado com sucesso.");
			}else {
				System.out.println("\nN�o foi poss�vel excluir o Usu�rio");
			}
		}else {
			System.out.println("\nUsu�rio n�o existe na base da dados.");
		}
		
	}

}
