package org.example.br.com.alura.alugames.principal

import br.com.alura.alugames.servicos.ConsumoApi
import org.example.br.com.alura.alugames.modelo.Jogo
import java.util.*

fun main() {

    val leitura = Scanner(System.`in`)
    print("Digite o código do jogo buscado: ")

    val id = leitura.nextLine()

    val buscaApi = ConsumoApi()
    val informacaoJogo = buscaApi.buscarJogo(id)

    var meuJogo: Jogo? = null

    val resultado = runCatching {
        meuJogo = Jogo(
            informacaoJogo?.info!!.title,
            informacaoJogo.info.thumb
        )
    }

    resultado.onFailure {
        println("O JOGO BUSCADO NÃO EXISTE!!")
    }

    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N ")
        val opcao = leitura.nextLine()

        if (opcao.equals("S", true)){
            println("Insira a descrição personalizada para o jogo: ")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }
        println(meuJogo)
    }

    resultado.onSuccess {
        println("Busca finalizada com sucesso!")
    }

}