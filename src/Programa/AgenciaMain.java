package Programa;

import com.sun.javafx.geom.Curve;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaMain {
    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes(){
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------Bem vindos a nossa Agência----------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("***************Selecione uma operação que deseja realizar***********");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta    |");
        System.out.println("|   Opção 2 - Depositar      |");
        System.out.println("|   Opção 3 - Sacar          |");
        System.out.println("|   Opção 4 - Transferir     |");
        System.out.println("|   Opção 5 - Listar         |");
        System.out.println("|   Opção 6 - Sair           |");


        int operacao = teclado.nextInt();
        switch (operacao){
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
                trasferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("Obrigado por usar nossa agência ^^");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
        }
    }
    public  static void criarConta() {
        System.out.println("\nNome: ");
        String nome = teclado.next();

        System.out.println("\nCPF: ");
        String cpf = teclado.next();

        System.out.println("\nemail: ");
        String email = teclado.next();

        Usuario pessoa = new Usuario( nome, cpf, email);
        Conta conta = new Conta(pessoa);
        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!");

        operacoes();
    }

    private static Conta encontrarConta(int numeroConta){
        Conta conta = null;
        if(contasBancarias.size() > 0){
            for(Conta c: contasBancarias){
                if(c.getNumConta() == numeroConta);
                conta = c;
            }
        }
        return conta;
    }
    public static void depositar(){
        System.out.println("Número da conta: ");
        int numeroConta = teclado.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = teclado.nextDouble();
            conta.deposito(valorDeposito);
            System.out.println(" Valor depositado com sucesso! ");

        }else {
            System.out.println("Conta não foi encontrada!  ");
        }
        operacoes();
    }
    public static void sacar() {
        System.out.println("Número da conta: ");
        int numeroConta = teclado.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorsaque = teclado.nextDouble();
            conta.sacar(valorsaque);
        }else {
            System.out.println("Conta não foi encontrada!  ");
        }
        operacoes();

    }

    public static void trasferir(){
        System.out.println("Número do remetente: ");
        int numeroContaRemetente = teclado.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null){
            System.out.println("Número da conta do destinatário: ");
            int numeroContaDestinatario = teclado.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null) {
                System.out.println("Qual o valor da tranferência: ");
                Double valor = teclado.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);
            }else {
                System.out.println("A conta para depósito não foi encontrada ");
            }
        }else {
            System.out.println("Conta para transferência não encontrada");
        }
        operacoes();
    }
    public static void listarContas() {
        if(contasBancarias.size() > 0){
            for(Conta conta: contasBancarias) {
                System.out.println(conta);
            }
        }else{
            System.out.println("Não há contas cadastradas! ");
        }
        operacoes();
    }



}



