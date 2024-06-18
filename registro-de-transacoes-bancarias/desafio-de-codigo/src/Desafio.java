//import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Desafio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        try {
            //System.out.println("Digite o titular da conta:");
            String titular = scanner.next();

            //System.out.println("Digite o número da conta:");
            int numeroConta = scanner.nextInt();

            //System.out.println("Digite o saldo da conta:");
            double saldo = scanner.nextDouble();

            //System.out.println("Digite a taxa de juros:");
            double taxaJuros = scanner.nextDouble();

            ContaBancaria conta = new ContaBancaria(numeroConta, titular, saldo, taxaJuros);

            System.out.println("Conta Poupanca:");
            conta.exibirInformacoes();
        } catch (Exception e) {
            System.out.println("Erro ao ler os dados de entrada: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close(); // Fechar o Scanner após o uso
        }
    }
}

class ContaBancaria {
    private int numero;
    private String titular;
    private double saldo;
    private double taxaJuros;

    public ContaBancaria(int numero, String titular, double saldo, double taxaJuros) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.taxaJuros = taxaJuros;
    }

    public void exibirInformacoes() {
        //DecimalFormat decimalFormat = new DecimalFormat("#.0");
        //DecimalFormat percentFormat = new DecimalFormat("0.0%");
        System.out.println(titular);
        System.out.println(numero);
        System.out.println("Saldo: R$ " + (saldo));
        System.out.println("Taxa de juros: " + (taxaJuros) + "%");
    }
}
