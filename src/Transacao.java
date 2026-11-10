import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Transacao {

    // Muda a formatacao da data para o padrao brasileiro (dia/mes/ano)

    private final double valor;
    private final String descricao;
    private final LocalDate data;

    public Transacao(double valor, String descricao, LocalDate data){
        if(valor <= 0){  // Excecao (valor da transacao tem que ser maior que zero)
            throw new IllegalArgumentException("Valor da transacao invalido");
        }
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
    }

    // A classe Receita e Despesa definem como aplicar no saldo
    public abstract double aplicarNoSaldo(double saldo);

    // Cada classe filha Retorna o tipo da Transacao: Despesa ou Receita
    public abstract String tipoDeTransacao();

    // getter de valor
    public double getValor(){
        return this.valor;
    }

    // getter descricao
    public String getDescricao(){
        return this.descricao;
    }

    //getter data
    public LocalDate getData(){
        return this.data;
    }

    // Output: [Data] tipoDaTransacao R$valor Descricao
    @Override
    public String toString(){
        DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = this.data.format(dataFormatter);
        return "[" + dataFormatada + "] " + tipoDeTransacao() + " R$" + String.format("%.2f", this.valor) + " " + this.descricao;
    }
}
