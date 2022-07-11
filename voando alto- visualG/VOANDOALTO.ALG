algoritmo "semnome"

//menu principal
 procedimento cadastro()
 var
 pessoa:vetor[1..3]de caracter
 data:vetor[1..3] de inteiro
 
 i,l:inteiro
 inicio

 para l <- 1 ate 3 faca


ESCREVAL("                      * REALIZE SEU CADASTRO*                   ")
ESCREVAL("================================================================")
ESCREVA("Informe seu Nome:")
LEIA(pessoa[l])
se(pessoa[l] = "") entao
quantCad <- quantCad - 1
interrompa
senao

ESCREVA("Informe seu telefone:")
LEIA(pessoa[l])
ESCREVA("Qual seu destino?")
LEIA(pessoa[l])

 se(pessoa[l] <> opcao) entao
   escreval("Destino esgotado")
   interrompa

senao
ESCREVA("")
 para l <- 1 ate 3 faca

ESCREVA("Qual a data da viagem? ")
LEIA(data[i])
fimpara
fimse
fimse

fimpara
fimprocedimento




var

inicio

//menu inicial

escreval("Bem vindos!")

escreval("Menu inicial")

escolha opcao
caso 1


cadastro()

fimalgoritmo
 
