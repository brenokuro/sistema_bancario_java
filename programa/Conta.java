package programa;

import utilitarios.Utils;

public class Conta {
    private static int contadorDeContas = 1;
    
    private int numeroConta;
    private Cliente titular;
    private double saldo = 0.0;

    public Conta(Cliente titular) {
        this.numeroConta = contadorDeContas;
        this.titular = titular;
        this.saldo = 0.0;
        contadorDeContas++;
    }

    public int getNumero() {
        return numeroConta;
    }

    public Cliente getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }
 

    public String toString() {
        return "\nNúmero da Conta: " + this.getNumero() +
                "\nTitular: " + titular.toString() +
                "\nCPF: " + titular.getCpf() +
                "\nEmail: " + titular.getEmail() +
                "\nSaldo: " + Utils.doubleToString(saldo);
    }

      public void Depositar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Depósito realizado com sucesso!");
        }else {
            System.out.println("Valor inválido para depósito.");
        }
    }   

    public boolean Sacar(double valor) {
        if (valor > 0 && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
            return false;
        }
    }

    public boolean Transferir(Conta contaParaDeposito, Double valor) {
        if (valor > 0 && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            contaParaDeposito.setSaldo(contaParaDeposito.getSaldo() + valor);
            System.out.println("Transferência realizada com sucesso!");
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para transferência.");
            return false;
        }
    }
    public void TransferirV2(Conta contaParaDeposito, Double valor) {
        if (valor > 0 && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            contaParaDeposito.setSaldo(contaParaDeposito.getSaldo() + valor);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para transferência.");
        } 
    }

}


