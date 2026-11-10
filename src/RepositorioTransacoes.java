import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositorioTransacoes {

    private final String caminhoArquivo;

    public RepositorioTransacoes(String caminhoArquivo){
        this.caminhoArquivo = caminhoArquivo;
    }


    // Escreve as transacoes no arquivo Transacoes.txt
    public void salvar(Transacao transacao){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))){
            writer.write(transacao.tipoDeTransacao() + ";" + transacao.getValor() + ";" + transacao.getData() + ";" + transacao.getDescricao());
            writer.newLine();
        }
        catch(IOException e){
            System.out.println("Erro");
        }
    }


    // Lê o arquivo inteiro e transforma cada linha em um objeto Receita ou Despesa
    public List<Transacao> carregar(){
        List<Transacao> transacoes = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))){
            String linha;
            while((linha = reader.readLine()) != null){
                String[] partes = linha.split(";", 4);

                // Pula linhas vazias
                if(partes.length != 4){
                    continue;
                }

                String tipo = partes[0];
                double valor = Double.parseDouble(partes[1]);
                LocalDate data = LocalDate.parse(partes[2]);
                String descricao = partes[3];


                if(partes[0].equals("Receita")){
                    transacoes.add(new Receita(valor, descricao, data));
                }
                else{
                    transacoes.add(new Despesa(valor, descricao, data));
                }
            }
        }
        catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return transacoes;
    }
}
