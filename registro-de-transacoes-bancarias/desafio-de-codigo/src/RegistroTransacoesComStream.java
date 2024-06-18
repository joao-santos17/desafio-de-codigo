import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroTransacoesComStream {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saldo = scanner.nextDouble();
        int quantidadeTransacoes = scanner.nextInt();

        List<Transacao> transacoes = new ArrayList<>();

        for (int i = 1; i <= quantidadeTransacoes; i++) {
            char tipoTransacao = scanner.next().charAt(0);
            double valorTransacao = scanner.nextDouble();

            // Criar uma nova transação e adicioná-la à lista de transações
            Transacao transacao = new Transacao(tipoTransacao, valorTransacao);
            transacoes.add(transacao);

            // Verifica e atualiza o saldo da conta com base no tipo de transação
            if (transacao.getTipo() == 'd') {
                saldo = saldo + valorTransacao;
            } else if (transacao.getTipo() == 's') {
                saldo = saldo - valorTransacao;
            }
        }

        // Imprime o saldo final da conta
        System.out.println("\nSaldo : " + saldo);

        // Imprime as transações formatadas
        System.out.println("\nTransacoes:");
        transacoes.forEach(transacao -> {
            String tipo = Character.toString(transacao.getTipo()).toLowerCase(); // Obtém o tipo como 'd' ou 's'
            System.out.println(tipo + " de " + transacao.getValor());
        });

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}

class Transacao {
    private char tipo;
    private double valor;

    public Transacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}
