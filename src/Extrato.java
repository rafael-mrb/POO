import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Extrato implements Relatorio{

    @Override
    public String getTitulo(){
        return "Extrato";
    }

    @Override
    public String gerar(Conta conta){
        List<Transacao> listaOrdenada = new ArrayList<>();
        listaOrdenada.addAll(conta.getTransacoes());

        // Ordena a lista de transações pela data, da mais antiga para a mais recente.
        listaOrdenada.sort(Comparator.comparing(Transacao::getData));

        // Cria uma String para armazenar o extrato da conta.
        String texto = "=== EXTRATO ===\n";

        // Percorre as transações (organizadas por data) e adiciona cada uma a String extrato.
        for (Transacao transacao : listaOrdenada) {
            texto += transacao.toString() + "\n";
        }

        // Adiciona o saldo atual da conta ao final do extrato.
        texto += String.format("Saldo: R$ %.2f%n", conta.getSaldo());

        // Retorna o extrato completo.
        return texto;
    }
}
