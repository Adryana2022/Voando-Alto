Algoritmo "VoandoAlto"
// Aluno: Adriana Albuquerque de Almeida
// Recode Pro

tipo

    cad_pessoa = registro

     nome:caracter
     endereco:caracter
     destino:caracter
     data:caracter
     cpf:caracter
     fone:inteiro
     i:inteiro
     total:real

fimregistro


var

 pessoa : vetor[1..5] de cad_pessoa

 opcao,l,i:inteiro
 total:real
 totalPessoas:inteiro
  quantCad,d:inteiro
  pacotes:vetor[1..10] de caracter
  pacFamilia:vetor[1..5] de caracter


inicio

totalPessoas <- 5
quantCad <- 0
para l de 1 até 5 faca
pacFamilia[l] <- " Paris 4 pessoas - R$ 10.000 - Maldivas 4 pessoas - R$ 20.000"
 fimpara

para d de 1 ate 10 faca
pacotes[d] <- "Paris - 3.000","Maldivas - R$ 10.000"

fimpara
escreval("===================* SEJAM BEM VINDOS*=========================")
ESCREVAL("")
ESCREVAL("================================================================")
ESCREVAL("                      * REALIZE SEU CADASTRO*                   ")
ESCREVAL("================================================================")

para i de 1 ate totalPessoas faca
       quantCad <- quantCad + 1
       fimpara

ESCREVA("Informe seu Nome:")
LEIA(pessoa[i].nome)
                    se(pessoa[i].nome = "") entao
                     quantCad <- quantCad - 1
           interrompa
       fimse

ESCREVA("Informe seu Cpf:")
LEIA(pessoa[i].cpf)
ESCREVA("Informe seu Endereco:")
LEIA(pessoa[i].endereco)
ESCREVA("Informe seu telefone:")
LEIA(pessoa[i].fone)
ESCREVA("Qual seu destino?")
LEIA(pessoa[i].destino)

ESCREVA("Qual a data da viagem? ")
LEIA(pessoa[i].data)

//MENUS DOS SERVIÇOS

opcao <- 0
enquanto opcao <>6 faca
ESCREVAL("======================MENU DE SERVIÇOS=======================")
ESCREVAL("")
ESCREVAL("1--------------------:PACOTES" )
ESCREVAL("2--------------------:HOSPEDAGEM ")
ESCREVAL("3--------------------:PACOTES FAMILIA")
ESCREVAL("4--------------------:TOTAL DOS SERVICOS ")
ESCREVAL("5--------------------:RELATORIO")
ESCREVAL("Digite um numero do serviço desejado ou digite 6 para sair")
leia(opcao)

se (opcao<1) ou (opcao >7) entao
	Escreval ("POR FAVOR DIGITE UMA OPCAO VALIDA:")

senao
  se (opcao=1) entao
  limpatela
 	escreval("NOSSOS PACOTES",pacotes[d])

    senao
   se   (opcao=2) entao
   limpatela
   escreval("HOSPEDAGEM  R$ 2.000")
   senao
  	se (opcao=3) entao
  	limpatela
  	escreval(" PACOTES FAMILIA",pacFamilia[l])
    senao
   se(opcao=4) entao

   escreval("")
   escreval("    ---------Relatorio----------    ")
   escreval ( pessoa[i])

    escreval("")
    senao

    se(opcao=5) entao
   ESCREVAL("======================RECIBO===========================")
   escreval("TOTAL DOS SERVICOS R$", total)

      senao
      se (opcao=6) entao
     escreval ("")
     escreval("Pagamento Aprovado - Pedido Finalizado - VOLTE SEMPRE, Obrigado!!!")
    interrompa
fimse
 fimse
 fimse
 fimse
 fimse
 fimse
 fimse
 fimenquanto
 
Fimalgoritmo