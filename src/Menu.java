import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private Conta conta;
    private RepositorioTransacoes repositorio;
    private List<Relatorio> relatorio;
    Transacao transacao;


    public Menu(Conta conta, RepositorioTransacoes repositorio, List<Relatorio> relatorio){
        this.conta = conta;
        this.repositorio = repositorio;
        this.relatorio = relatorio;
    }


    public void iniciar(){
        Scanner scanner = new Scanner(System.in);
        int opcao = 1;
        while(opcao != 0){
            System.out.println("\n[1] Nova Receita");
            System.out.println("[2] Nova Despesa");
            System.out.println("[3] Ver Relatorio");
            System.out.println("[4] Ver saldo");
            System.out.println("[0] Sair");
            System.out.print("Insira uma opcao: ");
            opcao = Integer.parseInt(scanner.nextLine());

            if(opcao == 1){
                novaReceita();
            }
            else if(opcao == 2){
                novaDespesa();
            }
            else if(opcao == 3){
                verRelatorio();
            }
            else if(opcao == 4){
                System.out.println("Seu saldo é de R$" + conta.getSaldo());
            }
            else if(opcao == 0){
                System.out.println("Saindo");
            }
            else{
                System.out.println("Opcao invalida");
            }

        }
    }

    public void novaReceita(){
        System.out.print("Valor Receita: R$");
        double valorNovaReceita = Double.parseDouble(scanner.nextLine());

        if(valorNovaReceita <= 0){
            System.out.println("Valor deve ser maior que zero");
            return;
        }

        System.out.print("Descricao: ");
        String descricaoNovaReceita = scanner.nextLine();

        transacao = new Receita(valorNovaReceita, descricaoNovaReceita, LocalDate.now());

        // Primeiro grava no arquivo. Se der erro aqui, a conta não muda.
        repositorio.salvar(transacao);

        // Deu certo? Então coloca na conta também.
        conta.registrar(transacao);

        System.out.println("Receita registrada!");
    }

    public void novaDespesa(){
        System.out.print("Valor Despesa: R$");
        double valorNovaDespesa = Double.parseDouble(scanner.nextLine());

        if(valorNovaDespesa <= 0){
            System.out.println("Valor deve ser maior que zero");
            return;
        }

        System.out.print("Descricao: ");
        String descricaoNovaDespesa = scanner.nextLine();

        transacao = new Despesa(valorNovaDespesa, descricaoNovaDespesa, LocalDate.now());

        // Primeiro grava no arquivo.
        repositorio.salvar(transacao);

        // coloca na conta também.
        conta.registrar(transacao);

        System.out.println("Despesa registrada!");
    }

    public void verRelatorio(){
        for (Relatorio relatorio : relatorio) {
            // O Menu não sabe qual relatório é: só chama gerar() e cada um faz do seu jeito
            System.out.println();
            System.out.print(relatorio.gerar(conta));
        }
    }


}
