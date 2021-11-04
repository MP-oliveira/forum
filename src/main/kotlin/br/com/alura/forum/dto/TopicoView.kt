package br.com.alura.forum.dto

import br.com.alura.forum.model.StatusTopico
import java.time.LocalDateTime

data class TopicoView(
        val id: Long?,
        val titulo: String,
        val menssagem: String,
        val status: StatusTopico,
        val dataCriacao: LocalDateTime
)
