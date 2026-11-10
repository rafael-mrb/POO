import java.time.LocalDate;

public class Despesa extends Transacao{

    public Despesa(double valor, String descricao, LocalDate data){
        super(valor, descricao, data);
    }

    // Saldo - valorDaTransacao
    @Override
    public double aplicarNoSaldo(double saldo){
        return saldo - getValor();
    }

    @Override
    public String tipoDeTransacao(){
        return "Despesa";
    }
}
