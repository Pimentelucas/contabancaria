package controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	
	int numero;
	
	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null)
			conta.visualizar();
		else
			System.out.println("\nA conta " + numero + " não foi encontrada!");
		}
		
	

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA Conta " + conta.getNumero() + " foi criada!");
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\nA conta " + conta.getNumero() + " foi atualizada com sucesso!");
		}else
			System.out.println("\nA conta" + conta.getNumero() + "não foi encontrada!");
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			if (conta.sacar(valor)== true)
				System.out.println("\n O saque na conta: " + numero + "foi efetuado com sucesso!");	
		}else
		System.out.println("\n A conta" + numero + "não foi encontrada!");
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			conta.depositar(valor); 
				System.out.println("\n O depósito na conta: " + numero + "foi efetuado com sucesso!");
		} else
			System.out.println("\n A conta" + numero + "não foi encontrada ou não é uma conta corrente!");

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if(contaOrigem != null && contaDestino != null) {
			if(contaOrigem.sacar(valor)== true) {
				contaDestino.depositar(valor);
				System.out.println("\nA transferência foi efetuada com sucesso!");
			}
		
		}else
			System.out.println("\nA conta de origem e/ou destino não foram encontradas!");
	}
	
	public int gerarNumero() {
		return ++ numero;
	}
	
	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
}
