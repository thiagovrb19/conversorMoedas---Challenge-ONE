# 💱 Conversor de Moedas - Desafio Técnico

Este projeto é um **conversor de moedas** utilizando a [ExchangeRate API](https://www.exchangerate-api.com/), desenvolvido como parte de um **desafio proposto pelo programa ONE - Oracle Next Education, da Alura**.

## 📌 Objetivo

Criar um programa que permita converter valores entre diferentes moedas com base nas taxas atuais fornecidas por uma API pública.

## 🛠️ Tecnologias Utilizadas

- Java 17
- HTTP Client (java.net.http)
- Gson (para parser JSON)
- ExchangeRate API

## 🔄 Conversões disponíveis
1️⃣ BRL → ARS
2️⃣ USD → BRL
3️⃣ CLP → BOB
4️⃣ COP → USD
5️⃣ ARS → BRL
6️⃣ BRL → CLP

## 🧠 Como o desafio foi resolvido
- Implementei uma chamada HTTP usando HttpClient para obter as taxas.
- Usei a biblioteca Gson para fazer o parse do JSON retornado pela API.
- Estruturei a conversão utilizando um método genérico e fácil de entender.
- Organizei o código por pacotes (api, model, ui) para facilitar a manutenção.
- Criei um menu interativo com Scanner no terminal para a experiência do usuário.
