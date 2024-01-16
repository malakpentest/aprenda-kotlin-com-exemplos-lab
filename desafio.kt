
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if(usuario !in inscritos) {
            inscritos.add(usuario)
        }
    }
}

fun main() {
    // Criação de usuários
    val usuario1 = Usuario()
    val usuario2 = Usuario()
    val usuario3 = Usuario()

    // Criação de conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Kotlin para Iniciantes", 60)
    val conteudo2 = ConteudoEducacional("Desenvolvimento de Apps Android", 120)
    val conteudo3 = ConteudoEducacional("UI/UX para Android", 90)

    // Criação de formações
    val formacao1 = Formacao("Desenvolvimento Android", listOf(conteudo1, conteudo2))
    val formacao2 = Formacao("Design de Interfaces", listOf(conteudo3))

    // Matrícula dos usuários nas formações
    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao2.matricular(usuario3)

    // Teste para verificar se os usuários foram matriculados corretamente
    println("Usuários matriculados na formação 1: ${formacao1.inscritos.size}")
    println("Usuários matriculados na formação 2: ${formacao2.inscritos.size}")
}
