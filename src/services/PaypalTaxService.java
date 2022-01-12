package services;

public class PaypalTaxService implements TaxService {

	@Override
	public Double taxJuros(Double parcela, Integer parcelaNumero) {
		return parcela * 0.01 * parcelaNumero;
	}

	@Override
	public Double taxPagamento(Double parcela) {
		return parcela * 0.02;
	}

}
