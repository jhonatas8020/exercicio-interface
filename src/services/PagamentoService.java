package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contrato;
import entities.Parcela;

public class PagamentoService {
	
	private TaxService taxService;

	public PagamentoService(TaxService taxService) {
		this.taxService = taxService;
	}
	
	public void processarParcelas(Contrato contrato, Integer numeroParcelas) {
		
		double valorParcela = contrato.getValorTotal() / numeroParcelas;
		
		for(int i = 1; i <= numeroParcelas; i++) {
			Date data = adicionarMes(contrato.getDataContrato(), i);
			double valorParcelaJuros = valorParcela + taxService.taxJuros(valorParcela, i);
			double valorParcelaTotal = valorParcelaJuros + taxService.taxPagamento(valorParcelaJuros);
			contrato.addParcela(new Parcela(data, valorParcelaTotal));
		}
	}
	
	public Date adicionarMes(Date data, int nMeses) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.MONTH, nMeses);
		
		return calendar.getTime();
	}
	
}
