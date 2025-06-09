# JavaRestaurante
Projeto em **Java** para criação de um sistema de pedidos de um Restaurante.

## Conceito
Para a realização deste projeto foi necessário uma análisa profunda acerca de todas as possibilidades e passos que fazem com que um pedido seja não só registrado, como também modificado e consultado dentro de um sistema utilizável por restaurantes. Desde o cargo exercido pelo usuário até todas as informações necessárias para que tal registro tome forma.

## Conhecimentos Aplicados
Dentre tudo que foi lecionado ao longo do período na discilplina de Programação Orientada a Objetos, a maioria dos conhecimentos absorvido foram utilizados para a realização do projeto. Desde conceitos básicos como **inicializações de variáveis** e **construção de métodos próprios** até conceitos recentemente introduzidos como a utilização de **Arrays** e a **personalização de Exceções**, tendo como ponto principal a utilização do conceito de **herança**.

## Abordagem
Para a realização desse projeto foi necessária a criação de diversas classes distintas para lidar com cada especificação que o sistema requer. A classe mais simples, que é a classe Prato, serve como base para Pedido e Cardápio até chegar em classes mais complexas como a classe Cliente, que desencadeiam em classes capazes de visualizar e até mesmo editar dados. Tudo isso sendo por fim executável pela classe Main.

## Passo a passo
Para poder executar o programa é necessário uma plataforma capaz de executar códigos em Java, como o Intellij ou o Visual Studio Code. Em seguida o usuário deve clonar o repositório, abrir o programa Main.java e executá-lo. No terminal o usuário irá se deparar com um leque de opções, cada uma representa o "cargo" que o usuário irá exercer enquanto utiliza o programa. O cliente está limitado apenas a consultar o cardápio e o status de seu pedido, sendo o papel mais limitado. Seguindo a hierarquia temos o garçom, que é responsável por adicionar, remover e até mesmo alterar pedidos. Já o gerente, é o papel com mais opções, podendo adicionar, remover e editar cadastros dos clientes e pratos registrados, além de consultar os pedidos.

## Para Compilar

`javac dev/Restaurante/*.java`

`java dev.Restaurante.Main`

## Banco de dados (Modelo Conceitual)

![modelo conceitual](https://github.com/user-attachments/assets/040e558b-5280-4cd5-95a0-e49fe7161a96)

## Banco de dados (Modelo Lógico)

![modelo logico](https://github.com/user-attachments/assets/73d4edbc-2e17-4f88-9326-01ca7af7c772)

