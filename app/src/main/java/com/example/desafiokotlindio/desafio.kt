package com.example.desafiokotlindio

// Enum que representa o nível da formação
enum class Nivel {
    BASICO,
    INTERMEDIARIO,
    AVANCADO
}

// Classe que representa um conteúdo educacional
data class ConteudoEducacional(
    val nome: String,
    val cargaHoraria: Int
)

// Classe que representa um aluno
data class Aluno(
    val nome: String
)

// Classe que representa uma formação
data class Formacao(
    val nome: String,
    val nivel: Nivel,
    val conteudos: List<ConteudoEducacional>
)

// Classe que representa uma experiência educacional
class ExperienciaEducacional(
    val nome: String
) {
    // Lista mutável de alunos matriculados
    private val alunosMatriculados = mutableListOf<Aluno>()

    // Função para matricular um aluno
    fun matricular(aluno: Aluno) {
        alunosMatriculados.add(aluno)
    }

    // Função para listar alunos matriculados
    fun listarAlunos() {
        println("Alunos matriculados na experiência $nome:")
        alunosMatriculados.forEach {
            println("- ${it.nome}")
        }
    }
}

// Função principal
fun main() {

    // Criando conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 10)
    val conteudo2 = ConteudoEducacional("Kotlin Orientado a Objetos", 15)

    // Criando uma formação
    val formacaoKotlin = Formacao(
        nome = "Formação Kotlin Developer",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = listOf(conteudo1, conteudo2)
    )

    // Criando alunos
    val aluno1 = Aluno("Rafaela")
    val aluno2 = Aluno("João")

    // Criando uma experiência educacional
    val experiencia = ExperienciaEducacional("Bootcamp Kotlin DIO")

    // Matriculando alunos
    experiencia.matricular(aluno1)
    experiencia.matricular(aluno2)

    // Exibindo informações
    println("Formação: ${formacaoKotlin.nome}")
    println("Nível: ${formacaoKotlin.nivel}")
    println("Conteúdos:")
    formacaoKotlin.conteudos.forEach {
        println("- ${it.nome} (${it.cargaHoraria}h)")
    }

    println()
    experiencia.listarAlunos()
}
