import java.util.Scanner;
import com.iphone.Iphone;

public class App {
    public static void main(String[] args) throws Exception {
        Iphone iphone = new Iphone();
        Scanner scan = new Scanner(System.in);

        int senhaCadastrada = 200030;
        int senhaUsuario = 0;
        int tentativas = 0;
        int opcao;
        
        final int MAX_TENTATIVA = 4;

        while (tentativas < 4) {
            System.out.println("Digite a senha para entrar: ");
            senhaUsuario = scan.nextInt();

            if (senhaUsuario == senhaCadastrada) {
                System.out.println("Senha correta! Acesso permitido.");
                break;
            } else {
                tentativas++;
                if (tentativas < MAX_TENTATIVA) {
                    System.out.println("Tente novamente! Tentativa " + tentativas + " de " + MAX_TENTATIVA + ".");
                } else {
                    System.out.println("Número máximo de tentativas atingido. Acesso bloqueado.");
                }
            }
        }

            do {
            System.out.println("[1] ITunes");
            System.out.println("[2] Safari");
            System.out.println("[3] Telefone");
            System.out.println("[4] Desligar");
            opcao = scan.nextInt(); 
        
                switch (opcao) {
                    case 1:
                        menuITunes(scan, iphone);
                        break;
                    case 2:
                        menuSafari(scan, iphone);
                        break;
                    case 3:
                        menuTelefone(scan, iphone);
                        break;
                    default:
                        break;
                }
            } while (opcao != 4);

        scan.close();        
    }
    private static void menuITunes(Scanner scan, Iphone iphone){
            String escolha = "";
            
            while (!(escolha.equals("v"))){
                System.out.println("[t] Tocar Musica"); 
                System.out.println("[p] Pausar");
                System.out.println("[v] Voltar"); 
                escolha = scan.next();
                switch (escolha) {
                case "t":
                    iphone.tocar();
                    break;
                case "p":
                    iphone.pausar();
                    break;
                case "v":
                    System.out.println("Voltando...");
                    break;
                default:
                    break;
            }
        }
    }
    private static void menuSafari(Scanner scan, Iphone iphone){
        String escolha = "s";
        while (!escolha.equals("v")){   
            System.out.println("[e] Exibir pagina"); 
            System.out.println("[a] Adicionar Aba"); 
            System.out.println("[u] Atualizar Página");
            System.out.println("[v] Voltar");

            escolha = scan.next();
            switch (escolha) {
                case "e":
                    System.out.println("Digite o url: ");
                    String url = scan.next();
                    iphone.exibirPagina(url);
                    break;
                case "a":
                    iphone.adicionarAba();
                    break;
                case "u":
                    if (!(iphone.atualizarPagina())){
                        System.out.println("Erro ao atualizar página");
                    }
                    System.out.println("Pagina atualizada!");
                    break;
                case "v":
                    System.out.println("Voltando...");
                    break;    
                default:
                    break;
            }
        }
        return;
    }
    private static void menuTelefone(Scanner scan, Iphone iphone){
        String escolha = "";
        while (!escolha.equals("v")){
            System.out.println("[l] Ligar"); 
            System.out.println("[a] Atender"); 
            System.out.println("[i] Iniciar Correio de Voz");
            System.out.println("[v] Voltar"); 

            escolha = scan.next();
            
            switch (escolha) {
                case "l":
                    System.out.println("Digite o numero: ");
                    String numero = scan.next();
                    iphone.ligar(numero);
                    break;
                case "a":
                    while (!(iphone.atender())){
                        System.out.println("Chamando...");
                    }
                    System.out.println("Atendido!");
                    break;
                case "i":
                    iphone.iniciarCorreioDeVoz();
                    break;
                case "v":
                    System.out.println("Voltando...");
                    break;    
                default:
                    break;
            }
        }
    }
}
