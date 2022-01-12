package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Contrato;
import entities.Parcela;
import services.PagamentoService;
import services.PaypalTaxService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter contract data");	
		System.out.print("Number: ");
		Integer numeroContrato = sc.nextInt();
		sc.nextLine();
		System.out.print("Date (dd/MM/yyyy): ");
		Date data = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
		System.out.print("Contract value: ");
		Double valorTotal = sc.nextDouble();
		
		Contrato contrato = new Contrato(numeroContrato, data, valorTotal);
		
		System.out.print("Enter number of installments: ");
		Integer numeroParcelas = sc.nextInt();
		
		PagamentoService pagamentoService = new PagamentoService(new PaypalTaxService());
		
		pagamentoService.processarParcelas(contrato, numeroParcelas);
		
		System.out.println("Installments: ");
		
		for(Parcela p : contrato.getParcelas()) {
			System.out.println(p);
		}
		
		sc.close();
		
	}
	
}
