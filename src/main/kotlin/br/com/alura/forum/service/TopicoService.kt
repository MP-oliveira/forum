package br.com.alura.forum.service


import br.com.alura.forum.dto.NovoTopicoDto
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors


@Service
class TopicoService(
        private var topicos: List<Topico> = ArrayList(),
        private val cursoService: CursoService,
        private val usuarioService: UsuarioService
) {


    fun listar(): List<TopicoView>{
        return topicos.stream().map { t -> TopicoView(
            id = t.id,
            titulo = t.titulo,
            menssagem = t.menssagem,
            dataCriacao = t.dataCriacao,
            status = t.status,

        ) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }

    fun cadastrar(dto: NovoTopicoDto) {
        topicos = topicos.plus(
            Topico(
                id = topicos.size.toLong() + 1,
                titulo = dto.titulo,
                menssagem = dto.menssagem,
                curso = cursoService.buscarPorId(dto.idCurso),
                autor = usuarioService.buscarPorId(dto.idAutor)
            )
        )
    }
}
