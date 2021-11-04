package br.com.alura.forum.dto

data class NovoTopicoDto (
    val titulo: String,
    val menssagem: String,
    val idCurso: Long,
    val idAutor: Long
)
