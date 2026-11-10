import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Conta {

    private List<Transacao> transacoesList = new ArrayList<>();

    // Adiciona novas transacoes na lista
    public void registrar(Transacao transacao){
        transacoesList.add(transacao);
    }

    // Soma os valores das transacoes na lista
    public double getSaldo(){
        double saldo = 0;

        for(Transacao t : transacoesList){
            saldo = t.aplicarNoSaldo(saldo);
        }

        return saldo;
    }

    // Retorna uma lista so com permissao de leitura 
    public List<Transacao> getTransacoes(){
        return Collections.unmodifiableList(transacoesList);
    }
}
