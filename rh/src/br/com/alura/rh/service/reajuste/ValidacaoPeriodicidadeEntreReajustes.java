package br.com.alura.rh.service.reajuste;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ValidacaoPeriodicidadeEntreReajustes implements IValidacaoReajuste {

	public void validar(Funcionario funcionario, BigDecimal aumento) {

		LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
		LocalDate dataAtual = LocalDate.now();
		long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
		if (mesesDesdeUltimoReajuste > 6) {
			throw new ValidacaoException("Data entre reajustes não pode ser inferior a seis meses");
		}

	}
}
