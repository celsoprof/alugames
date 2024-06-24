package br.com.alura.alugames.servicos

import com.google.gson.Gson
import br.com.alura.alugames.modelo.InfoJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsumoApi {

    fun buscarJogo(id: String): InfoJogo? {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client = HttpClient.newHttpClient()

        val request = HttpRequest
            .newBuilder()
            .uri(URI.create(endereco)) // URL do servidor
            .build()

        val response = client
            .send(request, BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()

        return if (!json.equals("[]")){
            gson.fromJson(json, InfoJogo::class.java)
        } else {
            null
        }
    }

}