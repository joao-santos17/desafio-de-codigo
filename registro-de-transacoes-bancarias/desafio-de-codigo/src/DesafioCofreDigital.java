import java.util.Scanner;

abstract class Cofre {
    protected String tipo;
    protected String metodoAbertura;

    public Cofre(String tipo, String metodoAbertura) {
        this.tipo = tipo;
        this.metodoAbertura = metodoAbertura;
    }

    public void imprimirInformacoes() {
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Metodo de abertura: " + this.metodoAbertura);
    }
}

class CofreDigital extends Cofre {

    private int senha;

    public CofreDigital(int senha) {
        super("Cofre Digital", "Senha");
        this.senha = senha;
    }

    public boolean validarSenha(int confirmacaoSenha) {
        return confirmacaoSenha == this.senha;
    }
}

class CofreFisico extends Cofre {

    public CofreFisico() {
        super("Cofre Fisico", "Chave");
    }

}

public class DesafioCofreDigital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê o tipo de cofre (digital ou físico)
        //System.out.println("Digite o tipo de cofre a ser criado (digital ou físico):");
        String tipoCofre = scanner.nextLine();

        if (tipoCofre.equalsIgnoreCase("digital")) {
            // Para cofre digital, solicita senha e confirmação
            //System.out.println("Digite a senha (apenas números):");
            int senha = scanner.nextInt();
            //System.out.println("Confirme a senha:");
            int confirmacaoSenha = scanner.nextInt();

            if (senha == confirmacaoSenha) {
                CofreDigital cofreDigital = new CofreDigital(senha);
                cofreDigital.imprimirInformacoes();
                System.out.println("Cofre aberto!");
            } else {
                // Se a senha não coincidir, exibe mensagem específica
                System.out.println("Tipo: Cofre Digital");
                System.out.println("Metodo de abertura: Senha");
                System.out.println("Senha incorreta!");
            }
        } else if (tipoCofre.equalsIgnoreCase("fisico")) {
            // Para cofre físico, cria e imprime as informações
            CofreFisico cofreFisico = new CofreFisico();
            cofreFisico.imprimirInformacoes();
        } else {
            System.out.println("Tipo de cofre desconhecido. Criação de cofre cancelada.");
        }

        scanner.close();
    }
}
