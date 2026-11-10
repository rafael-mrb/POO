public class ResumoFinanceiro implements Relatorio{

    @Override
    public String getTitulo(){
        return "Resumo Financeiro";
    }

    @Override
    public String gerar(Conta conta){
        double totalReceitas = 0;
        double totalDespesas = 0;

        for(Transacao t : conta.getTransacoes()){
            if(t instanceof Receita){
                totalReceitas = totalReceitas + t.getValor();
            }
            else{
                totalDespesas = totalDespesas + t.getValor();
            }
        }
        int quantidade = conta.getTransacoes().size();

        return "Transacoes: " + quantidade + "\nReceitas: R$" + totalReceitas + "\nDespesas: R$" + totalDespesas + "\nSaldo: " + conta.getSaldo();
    }
}
