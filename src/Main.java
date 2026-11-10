
import java.util.ArrayList;
import java.util.List;

public class Main{

    static void main(String[] args) {

        RepositorioTransacoes repositorioTransacoes = new RepositorioTransacoes("src/Transacoes.txt");
        Conta conta = new Conta();

        List<Transacao> transacoesSalvas = repositorioTransacoes.carregar();

        for (Transacao transacao : transacoesSalvas) {
            conta.registrar(transacao);
        }

        // 4. Cria a lista de relatórios disponíveis
        List<Relatorio> relatorios = new ArrayList<>();
        relatorios.add(new Extrato());
        relatorios.add(new ResumoFinanceiro());

        // 5. Abre o menu
        Menu menu = new Menu(conta, repositorioTransacoes, relatorios);
        menu.iniciar();
    }
}
