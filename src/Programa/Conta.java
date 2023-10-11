package Programa;

import utlitarios.Utils;

public class Conta {
    private static int contadorDeContas = 1;
    private int numConta;
    private Usuario pessoa;
    private double saldo = 0.0;

    public Conta(Usuario pessoa) {
        this.numConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas += 1;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public Usuario getPessoa() {
        return pessoa;
    }

    public void setPessoa(Usuario pessoa) {
        this.pessoa = pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String toString() {
        return "\nNúmero da conta: " + this.getNumConta() +
                "\nNome: " + this.pessoa.getNome() +
                "\nCPF: " + this.pessoa.getCpf() +
                "\nEmail: " + this.pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }

    public void deposito(Double valor){
        if(valor > 0){
            setSaldo(getSaldo() + valor);
            System.out.println("O depósito foi realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar o depósito!");
        }
    }

    public void sacar (double valor) {
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("O saque foi realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar o saque!");
        }
    }

    public void transferir(Conta contaParaDeposito, double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferência realizada com sucesso!");
        }else {
            System.out.println("Não foi possível realizar a tranferência!");
        }
    }

}
