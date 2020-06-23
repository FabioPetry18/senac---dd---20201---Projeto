package model.bo;

import model.dao.AlunoDAO;
import model.vo.AlunoVO;

public class AlunoBO {
	
	AlunoDAO dao = new AlunoDAO();
	
	public String salvar(AlunoVO alunoVO) {
	
		String mensagem = "";

	if (dao.verificarCpf(alunoVO.getCpf())) {
			mensagem = "CPF informado (" + alunoVO.getCpf() + ") j� foi utilizado";
		} else {
			alunoVO = dao.cadastrarAluno(alunoVO);
			mensagem = "Cadastro realizado com sucesso!";

		}
	return mensagem;
	}
	
	
	public boolean deletar(AlunoVO a) {
		if(dao.existeRegistroPorIdAlunoDAO(a.getId())){
			boolean resultado = dao.excluir(a.getId());
			if (resultado == true){
				System.out.println("\nUsuario deletado com sucesso.");
			}else {
				System.out.println("\nN�o foi poss�vel excluir o Usu�rio");
			}
		}else {
			System.out.println("\nUsu�rio n�o existe na base da dados.");
		}
		return false;
	}

}
