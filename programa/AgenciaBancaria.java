package programa;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias ;

    public static void main(String[]nargs) {
        operacoes();
    }

    // Novo método para ler inteiros de forma segura
    public static int lerIntSeguro() {
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número inteiro válido:");
                input.next(); // consome a entrada inválida
            }
        }
    }

    public static void operacoes () {
        contasBancarias = (contasBancarias == null) ? new ArrayList<Conta>() : contasBancarias;
        System.out.println("---------------Bem vindo à Agência Bancária!--------------");
        System.out.println("Selecione a operação que deseja realizar:");
        System.out.println("1 - Criar Conta");
        System.out.println("2 - Depositar");
        System.out.println("3 - Sacar");
        System.out.println("4 - Transferir");
        System.out.println("5 - Listar Contas");
        System.out.println("6 - Sair");

        int operacao = lerIntSeguro();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("Obrigado por utilizar nosso sistema bancário!");
                System.exit(0);
            default:
                System.out.println("Operação inválida!");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        System.out.println("Digite o nome do cliente:");
        String nome = input.next();
        System.out.println("Digite o CPF do cliente:");
        String cpf = input.next();
        System.out.println("Digite o email do cliente:");
        String email = input.next();

        Cliente cliente = new Cliente(nome, cpf, email);
        Conta conta = new Conta(cliente);
        contasBancarias.add(conta);
        System.out.println("Conta criada com sucesso! Número da conta: " + conta.getNumero());
        operacoes();
    }

    public static void depositar() {
        System.out.println("Digite o número da conta:");
        int numeroConta = lerIntSeguro();
        System.out.println("Digite o valor a ser depositado:");
        double valor = input.nextDouble();

        Conta conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.Depositar(valor);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Digite o número da conta:");
        int numeroConta = lerIntSeguro();
        System.out.println("Digite o valor a ser sacado:");
        double valor = input.nextDouble();

        Conta conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.Sacar(valor);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Digite o número da conta de origem:");
        int numeroContaOrigem = lerIntSeguro();
        System.out.println("Digite o número da conta de destino:");
        int numeroContaDestino = lerIntSeguro();
        System.out.println("Digite o valor a ser transferido:");
        double valor = input.nextDouble();

        Conta contaOrigem = buscarConta(numeroContaOrigem);
        Conta contaDestino = buscarConta(numeroContaDestino);
        if (contaOrigem != null && contaDestino != null) {
            contaOrigem.Transferir(contaDestino, valor);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Conta(s) não encontrada(s)!");
        }
        operacoes();
    }

    public static void listarContas() {
        System.out.println("Lista de contas:");
        for (Conta conta : contasBancarias) {
            System.out.println("Número da conta: " + conta.getNumero() + ", Titular: " + conta.getTitular().getNome());
        }
        operacoes();
    }

    public static Conta buscarConta(int numero) {
        for (Conta conta : contasBancarias) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }
}