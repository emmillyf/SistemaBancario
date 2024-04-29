
![DiagramaClasses drawio](https://github.com/emmillyf/POOGrupo/assets/162373561/95d822b8-16e7-4cb5-9ae9-85059af0d4c9)

<h1> Sistema Bancário </h1>
O trabalho final da disciplina de Java 1 (orientação a objeto) consiste em uma atividade
continuada paralela aos exercícios propostos na apostila da Caelum.
O objetivo deste trabalho é promover o desenvolvimento de um pequeno sistema bancário
utilizando os tópicos apresentados e desenvolvidos na disciplina.
1. Requisitos Mínimos:
Nome e logo para o banco!
Classes
O sistema deverá ter as seguintes classes obrigatoriamente. (Podendo ter classes adicionais
perante a necessidade descoberta por cada grupo):
● Cliente
● Conta(Abstrata ou Interface?)
○ Conta Corrente
○ Conta Poupança
● Funcionário(Abstrata ou Interface?)
○ Gerente
○ Diretor
○ Presidente
● SistemaInterno(Classe main)
● TipoFuncionário(Enum)
● TipoConta(Enum)
● Login e Cadastro
● Leitura e Escrita(i/o)
* Criar o(s) Arquivo(s) .txt para simular o banco de dados.
Atributos
● Cliente deve ter os atributos de senha e CPF para que possam logar no sistema interno.
● Conta, deve conter os atributos de CPF do titular, para relacionar a conta com o
usuário logado no sistema e o saldo. Adicionalmente, a conta deve ter um atributo
identificador da agência.
● Conta Corrente e Conta Poupança, que herdarão os atributos e métodos de Conta.
A Conta também deve conter um atributo “tipo” para identificação do tipo de conta.
● Funcionário, deve conter atributos também de CPF e senha para que possam logar no
sistema. Um atributo “cargo ou tipo de funcionário/pessoa” também deve existir para
identificar qual é o cargo/tipo daquele funcionário. Este atributo pode existir na própria
classe Funcionario ou diretamente em suas classes filhas.
● Gerente, que estenderá de Funcionário deve ter um atributo de identificação da
agência que é responsável por gerir.

2. Características de Funcionamento
Este sistema será executado com um menu interativo no próprio console. Na versão final (a ser
entregue até 18/04/2024) é esperado que o sistema seja populado com os valores referentes
aos clientes, contas e funcionários através da leitura de um arquivo de texto.
3. Passos de Execução
Na tela inicial deve ter uma logo e o usuário deverá fornecer seu CPF e senha para logar.
Opção 1: O sistema deve ser capaz de identificar, no momento do login, se o usuário é um
Cliente, Gerente, Diretor ou Presidente.
Opção 2: O sistema pede ao usuário, no momento do login, para ele informar se é um Cliente,
Gerente, Diretor ou Presidente.
Caso 1:
Caso o usuário seja um Cliente, o sistema fornecerá um menu com opções de:
1. Movimentações na Conta
a. Saque
b. Depósito
c. Transferência
2. Relatórios
a. Saldo. O sistema deverá imprimir o saldo na tela e disponibilizar opção por
imprimir extrato;
b. Relatório de tributação da conta corrente
i. O relatório de tributação deverá apresentar o total gasto nas
operações até o momento do relatório.
ii. Adicionalmente deverão ser informados os valores que o banco cobra
por cada operação bancária;
iii. Para cada saque será cobrado o valor de R$0.10 (dez centavos);
iv. Para cada depósito será cobrado o valor de R$0.10 (dez centavos);
v. Para cada transferência será cobrado o valor de R$0.20 (dez centavos)
que deverá ser cobrado apenas do remetente;

c. Relatório de Rendimento da poupança
i. Retorna uma simulação do valor de rendimento da poupança no prazo
informado. Neste caso o cliente deverá informar o valor em dinheiro e a
quantidade de dias que pretende simular. O sistema deverá informar o
rendimento desse dinheiro para o prazo informado;

d. Desafio:
i. Criar uma classe seguro de vida que possa ser contratado pelo cliente
onde o mesmo informa o valor que será segurado. No ato da
contratação será debitado 20% do valor contratado como tributo do
seguro;
ii. Incluir no relatório de tributação o valor referente ao seguro de vida,
caso este cliente possua estas informações.

Caso 2:
Caso o usuário seja um Funcionário no cargo de Gerente o sistema fornecerá um menu com
opções de:
1. Relatórios
a. Relatório do total de contas da mesma agência em que este gerente
trabalha;
b. Relatório das contas(com informações úteis) dessa mesma
agência;
2. Cadastro
a. Cadastro de Clientes(implica em cadastrar uma conta, não existe cliente
sem conta!)

Caso 3:
Caso o usuário seja um Funcionário no cargo de Diretor o sistema fornecerá um menu com as
opções anteriores de Gerente, adicionando:
1. Relatórios
a. Relatório com as informações de Nome, CPF e Agência de todos
os clientes das agências que esse Diretor coordena em ordem
alfabética.
2. Cadastro
a. Cadastro de Clientes e Cadastro de Gerentes

Caso 4:
Por fim, caso o usuário acessando o sistema seja um Funcionário no cargo de Presidente o
sistema fornecerá um menu com as opções anteriores de Gerente e Diretor, adicionando:
1. Relatórios
a. Relatório da lista de diretores e suas respectivas agências de controle,
contendo o nome do respectivo gerente da agência;
b. Relatório com o valor total do capital armazenado no banco.
2. Cadastro
a. Cadastro de Clientes, Cadastro de Gerentes e Cadastro de Diretores

Restrições:
- Toda operação bancária (Saque, depósito e transferência) deverá ser registrada em um
arquivo de texto de saída que armazena as operações realizadas durante aquela
execução do sistema;
- Todo relatório gerado deve ser registrado em um arquivo texto de saída individual;
- Todas as movimentações e relatórios devem ser apresentados em tela e ter a opção de
imprimir(arquivo gerado a partir de método de escrita);
- O sistema deve realizar ao menos três tratamentos de erros personalizados.
Exemplo: Caso um cliente tente realizar um depósito com valor indevido (valores negativos).
