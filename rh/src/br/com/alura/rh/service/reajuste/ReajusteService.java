package br.com.alura.rh.service.reajuste;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ReajusteService {

	private List<IValidacaoReajuste> validacoes;	
	
	public ReajusteService(List<IValidacaoReajuste> validacoes) {
		super();
		this.validacoes = validacoes;
	}

	public void reajustarSalarioDoFUncionario(Funcionario funcionario, BigDecimal aumento) {
		
		this.validacoes.forEach(v -> v.validar(funcionario, aumento));
		
		BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}

}
