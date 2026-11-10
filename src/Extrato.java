import java.util.ArrayList;
import java.util.List;

public class Extrato implements Relatorio{

    @Override
    public String getTitulo(){
        return "Extrato";
    }

    @Override
    public String gerar(Conta conta){
        List<Transacao> listaOrdenada = new ArrayList<>(conta.getTransacoes());

        // Ordena comparando as datas de duas transações (a e b)
        listaOrdenada.sort((a, b) -> a.getData().compareTo(b.getData()));

        // StringBuilder serve para ir juntando vários textos de forma eficiente
        StringBuilder texto = new StringBuilder();
        texto.append("=== EXTRATO ===\n");

        for (Transacao transacao : listaOrdenada) {
            texto.append(transacao.toString()).append("\n");
        }

        texto.append(String.format("Saldo: R$ %.2f%n", conta.getSaldo()));

        return texto.toString();
    }
}
