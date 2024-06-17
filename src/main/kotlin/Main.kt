package org.example

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

fun main() {

    val client = HttpClient.newHttpClient()

    val request = HttpRequest
        .newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=146")) // URL do servidor
        .build()

    val response = client
        .send(request, BodyHandlers.ofString())

    val headers = response.headers()
    val json = response.body()

    println(json)

    // Utilização do Gson
    val gson = Gson()
    val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

    val meuJogo = Jogo(
        meuInfoJogo.info.title,
        meuInfoJogo.info.thumb
    )

    println(meuJogo)

}

