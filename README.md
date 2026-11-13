# Controle Financeiro em Java

Aplicação de console para registrar receitas e despesas, consultar o saldo e ver relatórios financeiros. As transações ficam salvas em um arquivo de texto para que os dados continuem salvos quando o programa é aberto de novo.

## Funcionalidades
| Opção | O que faz |
| --- | --- | 
| [1] Nova receita | Registra uma entrada de dinheiro (salário, venda...) |
| [2] Nova despesa |	Registra uma saída de dinheiro (mercado, aluguel...) |
| [3] Ver saldo | 	Mostra o saldo atual |
| [4] Relatórios |	Mostra o extrato e o resumo financeiro |
| [0] Sair |	Encerra o programa |

## Exemplo de uso
```java
=== MENU ===
[1] Nova receita
[2] Nova despesa
[3] Ver saldo
[4] Relatórios
[0] Sair
Opção: 4

=== EXTRATO ===
08/11/2026 | Receita | R$ 1500,50 | Salario
08/11/2026 | Despesa | R$ 200,25 | Mercado
Saldo: R$ 1300,25

=== RESUMO FINANCEIRO ===
Transações: 2
Receitas:   R$ 1500,50
Despesas:   R$ 200,25
Saldo:      R$ 1300,25
```

## Classes
| Classe | Responsável |
| --- | --- |
| Main |	Cria os objetos repositorioTransacao e conta, carrega o histórico e iniciar o menu
| Menu	| Mostra as opções, lê o que o usuário digita e chama os outros objetos |
| Conta	| Guarda a lista de transações e calcula o saldo |
| Transacao |	Define o que toda transação tem (valor, descrição, data) |
| Receita / Despesa |	Define como cada tipo altera o saldo |
| Relatorio |	Define o que todo relatório precisa oferecer |
| Extrato / ResumoFinanceiro |	Monta o texto de cada relatório |
| RepositorioTransacoes	| Salva e carrega as transações do arquivo |
