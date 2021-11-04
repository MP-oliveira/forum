package br.com.alura.forum.service

import org.springframework.stereotype.Service
import br.com.alura.forum.model.Usuario
import java.util.*

@Service
data class UsuarioService(var usuarios: List<Usuario>)    {

    init{
        val usuario = Usuario (id = 1, nome = "Mauricio", email = "mauricio@email.com")
        usuarios = listOf(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter { u ->
            u.id == id
        }.findFirst().get()
    }

}
