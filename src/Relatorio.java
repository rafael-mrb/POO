public interface Relatorio {

    // Nome que aparece no menu de relatórios.
    String getTitulo();

    // Monta o texto do relatório usando as informações da conta.
    String gerar(Conta conta);
}
