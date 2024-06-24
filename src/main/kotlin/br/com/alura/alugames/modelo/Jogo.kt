package br.com.alura.alugames.modelo

data class Jogo(
    val titulo: String,
    val capa: String
) {

    var descricao: String? = null

//    constructor(titulo: String, capa: String, descricao: String) {
//        this.titulo = titulo
//        this.capa = capa
//        this.descricao = descricao
//    }

    override fun toString(): String {
        return "Meu Jogo:\n" +
                "----------------------------------\n" +
                "Titulo: $titulo\n" +
                "Capa: $capa\n" +
                "Descrição: $descricao"
    }


}