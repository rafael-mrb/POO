import java.time.LocalDate;

public class Receita extends Transacao{

    public Receita(double valor, String descricao, LocalDate data){
        super(valor, descricao, data);
    }

    @Override
    public double aplicarNoSaldo(double saldo){
        return saldo + getValor();
    }

    @Override
    public String tipoDeTransacao(){
        return "Receita";
    }
}
